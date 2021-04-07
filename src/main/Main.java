package main;

import java.util.LinkedList;
import processing.core.PImage;
import processing.core.PApplet;

public class Main extends PApplet{

	private TCPConnection1 conectado1;
	private TCPConnection2 conectado2;
	private int pantalla;
	private LinkedList <Drags> dragas;
	PImage inicio01;
	PImage inicio02;
	PImage instrucciones;
	PImage imgMapa;
	
	private int posX = 70, posY=140;
	
	
	//Matriz mapa 20*34
	private int mapa [][] = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//1
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//2
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//3
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//4
			{0,0 ,1,1,1,1,1,0,1,1,1, 0,0,0,0,0,0,0,0,0,0,0,0 ,1,1,1,1,1,0,1,1,1 ,0,0},//5
			{0,0 ,1,0,1,0,1,0,1,0,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,1,0,1,0,1,0,1,0,1 ,0,0},//6
			{0,0 ,1,0,1,0,1,0,1,0,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,1,0,1,0,1,0,1,0,1 ,0,0},//7
			{0,0 ,1,0,1,0,1,0,1,0,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,1,0,1,0,1,0,1,0,1 ,0,0},//8
			{0,0 ,1,0,1,0,1,0,1,0,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,1,0,1,0,1,0,1,0,1 ,0,0},//9
			{0,0 ,0,0,1,0,1,0,1,0,0 ,0,0,0,0,0,0,0,0,0,0,0,0 ,0,0,1,0,1,0,1,0,0 ,0,0},//10
			{0,0 ,1,0,1,0,1,0,1,0,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,1,0,1,0,1,0,1,0,1 ,0,0},//11
			{0,0 ,1,0,1,0,1,0,1,0,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,1,0,1,0,1,0,1,0,1 ,0,0},//12
			{0,0 ,1,1,1,0,1,1,1,0,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,1,1,1,0,1,1,1,0,1 ,0,0},//13
			{0,0 ,0,0,0,0,1,0,0,0,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,0,0,0,0,1,0,0,0,1 ,0,0},//14
			{0,0 ,1,1,1,1,1,1,1,1,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,1,1,1,1,1,1,1,1,1 ,0,0},//15
			{0,0 ,1,0,1,0,1,0,0,0,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,1,0,1,0,1,0,0,0,1 ,0,0},//16
			{0,0 ,0,0,1,0,1,0,1,0,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,0,0,1,0,1,0,1,0,1 ,0,0},//17
			{0,0 ,4,1,1,0,1,0,1,1,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,4,1,1,0,1,0,1,1,1 ,0,0},//18
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//19
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//20
			
	};
	
	
	public static void main(String[] args) {
		
		PApplet.main("main.Main");
		
	}
	
    public void settings() {
        size(1200, 700);

    }

    public void setup() {
    	
    	
    	//Aqui se llama el TCP del primer cliente
    	conectado1 = new TCPConnection1();
    	conectado1.setMain(this);
    	conectado1.start();
    	
    	//Aquí se declara la nueva linkedlist 
    	dragas= new LinkedList<Drags>();
    	
    	
    	//Aquí se llama el TCP del segundo cliente 
    	conectado2 = new TCPConnection2();
    	conectado2.setMain(this);
    	conectado2.start();
    	
    	//Espacio para cargar las imagenes
    	inicio01 = loadImage("imagenes/pantalla1.png");
    	inicio02 = loadImage("imagenes/pantalla1-2.png");
    	instrucciones = loadImage("imagenes/instrucciones.png");
    	imgMapa = loadImage("imagenes/mapa.png");

    	//Mientras inicia en 3 para poder empezar en el juego, toca cambiarlo a 1
    	pantalla=1;
    	
    

    }

    public void draw() {
    	
    	switch(pantalla) {
    	
    	case 1:
    		
    		//Pantalla inicio, toca hacer las zonas sesibles
    		image(inicio01,0,0);
    		/*fill(0);
			textSize(10);
			text("X: " + mouseX + " Y " + mouseY, mouseX, mouseY);*/
    		
    		break;
    		
    		
    	case 2:
    		
    		// Pantalla de instrucciones 
    		image(instrucciones,0,0);
    		/*fill(0);
			textSize(10);
			text("X: " + mouseX + " Y " + mouseY, mouseX, mouseY);*/
    		break;
    		
    		
    		
    	case 3:
    		
    		// Pantalla de juego 
    		image(imgMapa,0,0);
    		ellipse(posX+15,posY+15,15,15);
    		
    		break;
    	
    	
    	
    	}
    	
    	
    	
    }
    
    public void mousePressed() {
    	switch(pantalla) {
    	case 1:
    		if(mouseX > 512 && mouseX < 747 && mouseY > 574 && mouseY < 648) {
    			pantalla = 2;
    		}
    		break;
    	
    	case 2:
    		if(mouseX > 480 && mouseX < 645 && mouseY > 574 && mouseY < 648) {
    			pantalla = 3;
    		}
    		break;
    		
    	case 3:
    		break;
    	}
    }
    
    public void keyPressed() {
    	
    }
    
	public void acciono(Acciones acc, Object obj) {
		
		//Verificar que clase es o que TCP mando la info 
		if(obj instanceof TCPConnection1) {
			
			//imprimo en la consola que sucede
			System.out.println("Jugador 1"+acc.getAccion());
			
			//Dice que acción activar 
			switch(acc.getAccion()) {
			
			case "UPSTART":
				dragas.get(0).arribamuevalo();
				
				break;
			
			case "UPSTOP":
				
				dragas.get(0).arribaparelo();
				
				break;
				
			case "DOWNSTART":
				
				dragas.get(0).abajomuevalo();
				
				break;
				
			
			case "DOWNSTOP":
				
				dragas.get(0).abajoparelo();
				
				break;
			
				
			case "LEFTSTART":
				
				dragas.get(0).izquierdomuevalo();
				
				break;
			
			case "LEFTSTOP":
				
				dragas.get(0).izquierdoparelo();
				
				break;
				
				
			case "RIGHTSTART":
				
				dragas.get(0).derechomuevalo();
				
				break;
			
			case "RIGHTSTOP":
				
				dragas.get(0).derechoparelo();
				
				break;
			case "CATCHIT":
				
				
				
				break;
			
			}
			
			
			
		}else if(obj instanceof TCPConnection2) {
			
			System.out.println("Jugador 2"+acc.getAccion());
			
			switch(acc.getAccion()) {
			
			case "UPSTART":
				
				dragas.get(1).arribamuevalo();
				
				break;
			
			case "UPSTOP":
				
				dragas.get(1).arribaparelo();
				
				break;
				
			case "DOWNSTART":
				
				dragas.get(1).abajomuevalo();
				
				break;
				
			
			case "DOWNSTOP":
				
				dragas.get(1).abajoparelo();
				
				break;
			
				
			case "LEFTSTART":
				
				dragas.get(1).izquierdomuevalo();
				
				break;
			
			case "LEFTSTOP":
				
				dragas.get(1).izquierdoparelo();
				
				break;
				
				
			case "RIGHTSTART":
				
				dragas.get(1).derechomuevalo();
				
				break;
			
			case "RIGHTSTOP":
				
				dragas.get(1).derechoparelo();
				
				break;
			case "CATCHIT":
				
			
				
				break;
			
			}	
		}
	}
}
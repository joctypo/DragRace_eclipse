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
	PImage dora,rosa,ropa1,ropa2,peluca1,peluca2,makeup1,makeup2;
	PImage doraropa,rosaropa,dorapelu,rosapelu,doramake,rosamake;
	private int pomay,pomax;
	private int posX = 70, posY=140;
	//Estos contadores son para verificar si ya cogió todos los objetos
	private int contadordora=0,contadorrosa=0;
	
	
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
			{0,0 ,1,0,1,0,1,0,1,0,4 ,0,0,0,0,0,0,0,0,0,0,0,0 ,1,0,1,0,1,0,1,0,4 ,0,0},//9
			{0,0 ,0,0,1,0,1,0,1,0,0 ,0,0,0,0,0,0,0,0,0,0,0,0 ,0,0,1,0,1,0,1,0,0 ,0,0},//10
			{0,0 ,1,0,1,0,1,0,1,0,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,1,0,1,0,1,0,1,0,1 ,0,0},//11
			{0,0 ,3,0,1,0,1,0,1,0,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,3,0,1,0,1,0,1,0,1 ,0,0},//12
			{0,0 ,1,1,1,0,1,1,1,0,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,1,1,1,0,1,1,1,0,1 ,0,0},//13
			{0,0 ,0,0,0,0,1,0,0,0,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,0,0,0,0,1,0,0,0,1 ,0,0},//14
			{0,0 ,1,1,1,1,1,1,1,1,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,1,1,1,1,1,1,1,1,1 ,0,0},//15
			{0,0 ,1,0,1,0,1,0,0,0,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,1,0,1,0,1,0,0,0,1 ,0,0},//16
			{0,0 ,0,0,1,0,1,0,2,0,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,0,0,1,0,1,0,2,0,1 ,0,0},//17
			{0,0 ,1,1,1,0,1,0,1,1,1 ,0,0,0,0,0,0,0,0,0,0,0,0 ,1,1,1,0,1,0,1,1,1 ,0,0},//18
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//19
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//20
			// 2 maquillaje 3 peluca 4 ropa
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
    	dora = loadImage("imagenes/dora.png");
    	rosa = loadImage("imagenes/rosa.png");
    	doramake = loadImage("imagenes/doramake.png");
    	rosamake = loadImage("imagenes/rosamake.png");
    	doraropa = loadImage("imagenes/doraropa.png");
    	rosaropa = loadImage("imagenes/rosaropa.png");
    	dorapelu = loadImage("imagenes/pelucadora.png");
    	rosapelu = loadImage("imagenes/pelucarosa.png");
    	ropa1 = loadImage("imagenes/doritaropa.png");
    	peluca1 = loadImage("imagenes/doritapelu.png");
    	makeup1 = loadImage("imagenes/doritamake.png");
    	ropa2 = loadImage("imagenes/rositapelu.png");
    	peluca2 = loadImage("imagenes/rositaropa.png");
    	makeup2 = loadImage("imagenes/rositamake.png");
    	
    	//Mientras inicia en 3 para poder empezar en el juego, toca cambiarlo a 1
    	pantalla=1;
    	
    	dragas.add(new DragDebora(dora, "nada ",2, 17, 70,595, this));
    	dragas.add(new DragRosa(rosa, "nada ",23, 17,810,595, this));
    

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
    		
    		//Aqui toca validar las posiciones de cada objeto si aun estan para pintarlo 
    		//if(mapa[15][17]==2){
    			image(ropa1,0,0);
    		//}else {que pinte la caracteristica grande en el centro}
    		
    		image(peluca1,0,0);
    		image(makeup1,0,0);
    		image(ropa2,0,0);
    		image(peluca2,0,0);
    		image(makeup2,0,0); 
    		dragas.get(0).pintarimagen();
    		
    		dragas.get(1).pintarimagen();
    		validador();
    		//ellipse(dragas.get(0).getPosxx(),dragas.get(0).getPosyy(),15,15);
    		fill(0);
			textSize(10);
			text("X: " + mouseX + " Y " + mouseY, mouseX, mouseY);
    		
    		break;
    		
    		
    
    	case 4:
    	
    		//cuando se de cuenta que alguien gano, pintar la muñeca del ganador 
    		
    	break;
    	
     	case 5:
        	
    		//cuando se de cuenta que alguien gano, pintar la muñeca del ganador 
    		
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
    
    public void validador() {
    	
    	if(contadordora==3) {
    		
    		pantalla=4;
    	}else if (contadorrosa==3) {
    		
    		pantalla =5;
    	}
    	
    }
    
	public int[][] getMapa() {
		return mapa;
	}

	/*public void setMapa(int matrizMapa[][]) {
		this.matrizMapa = matrizMapa;
	}*/
	public void acciono(Acciones acc, Object obj) {
		
		//Verificar que clase es o que TCP mando la info 
		if(obj instanceof TCPConnection1) {
			
			//imprimo en la consola que sucede
			System.out.println("Jugador 1 osquitar"+acc.getAccion());
			
			//Dice que acción activar 
			switch(acc.getAccion()) {
			
			case "UPSTART":
				pomax= dragas.get(0).getPosx();
				pomay= dragas.get(0).getPosy();
				// corregir y meter 3 y 4 
				
				System.out.println("si entro");
				dragas.get(0).arribamuevalo();
				
				break;
			
			case "UPSTOP":
				
				dragas.get(0).arribaparelo();
				
				break;
				
			case "DOWNSTART":
				pomax= dragas.get(0).getPosx();
				pomay= dragas.get(0).getPosy();
				
				
				dragas.get(0).abajomuevalo();
				
				break;
				
			
			case "DOWNSTOP":
				
				dragas.get(0).abajoparelo();
				
				break;
			
				
			case "LEFTSTART":
				pomax= dragas.get(0).getPosx();
				pomay= dragas.get(0).getPosy();
				
				
					
				dragas.get(0).izquierdomuevalo();
				
				break;
			
			case "LEFTSTOP":
				
				dragas.get(0).izquierdoparelo();
				
				break;
				
				
			case "RIGHTSTART":
				pomax= dragas.get(0).getPosx();
				pomay= dragas.get(0).getPosy();
				
				
					System.out.println(mapa[pomay][pomax+1]);
				dragas.get(0).derechomuevalo();
				
				break;
			
			case "RIGHTSTOP":
				
				dragas.get(0).derechoparelo();
				
				break;
			case "CATCHIT":
				
				pomax= dragas.get(0).getPosx();
				pomay= dragas.get(0).getPosy();
				
				if(mapa[pomay][pomax]==2 || mapa[pomay][pomax]==3 || mapa[pomay][pomax]== 4) {
					
				
						mapa[pomay][pomax]=1;
						contadordora+=1;
					
				}
				break;
			
			}
			
			
			
		}else if(obj instanceof TCPConnection2) {
			
			System.out.println("Jugador 2"+acc.getAccion());
			
			switch(acc.getAccion()) {
			
			case "UPSTART":
				pomax= dragas.get(1).getPosx();
				pomay= dragas.get(1).getPosy();
				
				if(mapa[pomay-1][pomax]==1 || mapa[pomay-1][pomax]==2) {
				dragas.get(1).arribamuevalo();
				}
				break;
			
			case "UPSTOP":
				
				dragas.get(1).arribaparelo();
				
				break;
				
			case "DOWNSTART":
				pomax= dragas.get(1).getPosx();
				pomay= dragas.get(1).getPosy();
				
				if(mapa[pomay+1][pomax]==1 || mapa[pomay+1][pomax]==2) {
				dragas.get(1).abajomuevalo();
				}
				break;
				
			
			case "DOWNSTOP":
				
				dragas.get(1).abajoparelo();
				
				break;
			
				
			case "LEFTSTART":
				pomax= dragas.get(1).getPosx();
				pomay= dragas.get(1).getPosy();
				
				if(mapa[pomay][pomax+1]==1 || mapa[pomay][pomax+1]==2) {
				dragas.get(1).izquierdomuevalo();
				}
				break;
			
			case "LEFTSTOP":
				
				dragas.get(1).izquierdoparelo();
				
				break;
				
				
			case "RIGHTSTART":
				pomax= dragas.get(1).getPosx();
				pomay= dragas.get(1).getPosy();
				
				if(mapa[pomay][pomax+1]==1 || mapa[pomay][pomax+1]==2) {
				dragas.get(1).derechomuevalo();
				}
				break;
			
			case "RIGHTSTOP":
				
				dragas.get(1).derechoparelo();
				
				break;
			case "CATCHIT":
				pomax= dragas.get(1).getPosx();
				pomay= dragas.get(1).getPosy();
				
				if(mapa[pomay][pomax]==2 || mapa[pomay][pomax]==3 || mapa[pomay][pomax]== 4) {
					
					mapa[pomay][pomax]=1;
					contadorrosa+=1;
				}
			
				
				break;
			
			}	
		}
	}
}
package main;

import java.util.LinkedList;

import processing.core.PApplet;

public class Main  extends PApplet{

	private TCPConnection1 conectado1;
	private TCPConnection2 conectado2;
	private int pantalla;
	private LinkedList <Drags> dragas;
	
	
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
    	
    	//Mientras inicia en 3 para poder empezar en el juego, toca cambiarlo a 1
    	pantalla=3;
    	
    

    }

    public void draw() {
    	
    	switch(pantalla) {
    	
    	case 1:
    		
    		//Pantalla inicio, toca hacer las zonas sesibles
    		
    		
    		break;
    		
    		
    	case 2:
    		
    		// Pantalla de instrucciones 
    		
    		
    		break;
    		
    		
    		
    	case 3:
    		
    		// Pantalla de juego 
    		
    		
    		break;
    	
    	
    	
    	}
    	
    	
    	
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

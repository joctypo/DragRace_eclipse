package main;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Drags {
	
	private PImage imagendrag;
	private String accion;
	private int posx,posy;
	private PApplet app;
	private boolean moviendoarriba=false,moviendoabajo=false,moviendoderecho=false,moviendoizquierdo=false;
	private float posxx,posyy;

	public Drags(PImage imagendrag,String accion,int posx,int posy,float posxx,float posyy, PApplet app){
		
		this.imagendrag=imagendrag;
		this.accion=accion;
		this.posx=posx;
		this.posy=posy;
		this.app=app;
		this.posxx=posxx;
		this.posyy=posyy;
		
	}



	public PImage getImagendrag() {
		return imagendrag;
	}

	
	public void pintar() {
		
		
		
		if(moviendoarriba) {
			
			this.posyy-=35.29;
			
			
		}else if (moviendoabajo) {
			
			this.posyy+=35.29;
			
		}else if (moviendoderecho) {
			
			
			this.posxx+=35.29;
			
		}else if (moviendoizquierdo) {
			
			this.posxx-=35.29;
			
			
		}
		
	}
	
	public void pintarimagen() {
		
		app.image(imagendrag,posxx,posyy);
		
	}
	


	public void setImagendrag(PImage imagendrag) {
		this.imagendrag = imagendrag;
	}



	public String getAccion() {
		return accion;
	}



	public void setAccion(String accion) {
		this.accion = accion;
	}



	public int getPosx() {
		return posx;
	}



	public void setPosx(int posx) {
		this.posx = posx;
	}



	public int getPosy() {
		return posy;
	}



	public void setPosy(int posy) {
		this.posy = posy;
	}



	public PApplet getApp() {
		return app;
	}



	public void setApp(PApplet app) {
		this.app = app;
	}
	
	
	
	public void arribamuevalo() {
		
		moviendoarriba=true;
		
	}
	
	public void arribaparelo() {
		
		moviendoarriba=false;
		
	}
	
	public void abajomuevalo() {
		
		moviendoabajo=true;
		
	}
	
	public void abajoparelo() {
		
		moviendoabajo=false;
		
	}
	
	
	
	public void derechomuevalo() {
		
		moviendoderecho=true;
		
	}
	
	public void derechoparelo() {
		
		moviendoderecho=false;
		
	}
	
	public void izquierdomuevalo() {
		
		moviendoizquierdo=true;
		
	}
	
	public void izquierdoparelo() {
		
		moviendoizquierdo=false;
		
	}



	public float getPosyy() {
		return posyy;
	}



	public void setPosyy(float posyy) {
		this.posyy = posyy;
	}



	public float getPosxx() {
		return posxx;
	}



	public void setPosxx(float posxx) {
		this.posxx = posxx;
	}



}

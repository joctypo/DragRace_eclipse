package main;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Drags {
	
	private PImage imagendrag;
	private String accion;
	private int posx,posy;
	private PApplet app;
	private boolean moviendoarriba=false,moviendoabajo=false,moviendoderecho=false,moviendoizquierdo=false;
	private double posxx,posyy;
	private double valor=35.29;
	private int mapita [][]= {
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

	public Drags(PImage imagendrag,String accion,int posx,int posy,double posxx,double posyy, PApplet app){
		
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

	
	
	public void pintarimagen() {
		
		if(moviendoarriba) {
			
			if(mapita[this.posy-1][this.posx]==1 || mapita[this.posy-1][this.posx]==2) {
			
			this.posy-=1;
			this.posyy=posyy-valor;
			System.out.println("hasta aqui");
			}
			
		}else if (moviendoabajo) {
			if(mapita[this.posy+1][this.posx]==1 || mapita[this.posy+1][this.posx]==2) {
				
			this.posy+=1;
			this.posyy+=35.29;
			}
			
		}else if (moviendoderecho) {
			if(mapita[this.posy][this.posx+1]==1 || mapita[this.posy][this.posx+1]==2) {
				
			this.posx+=1;
			this.posxx+=35.29;
			
			}
			
		}else if (moviendoizquierdo) {
			if(mapita[this.posy][this.posx-1]==1 || mapita[this.posy][this.posx-1]==2) {
			this.posx-=1;
			this.posxx-=35.29;
			}
			
		}
		float positax= (float)getPosxx();
		float positay= (float)getPosyy();
		app.image(imagendrag,positax,positay);
		
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



	public double getPosyy() {
		return posyy;
	}



	public void setPosyy(double posyy) {
		this.posyy = posyy;
	}



	public double getPosxx() {
		return posxx;
	}



	public void setPosxx(double posxx) {
		this.posxx = posxx;
	}



}

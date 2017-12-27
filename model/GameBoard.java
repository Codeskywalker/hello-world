package cn.edu.ncu.gobangGame.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameBoard extends Canvas{
	private GraphicsContext gc;                         
	public GameBoard(double width,double height) {
		super(width+40,height+40);                                
		gc=getGraphicsContext2D();
		drawBoard(gc,width,height);			
	}
	
	public void drawBoard(GraphicsContext gc,double width,double height) {
		gc.setFill(Color.ORANGE);
		gc.fillRect(0,0,width+20,height+20);
		for(int i=20;i<width;i+=20) {
			for(int j=20;j<height;j+=20) {
			drawRect(gc,i,j);
			}
		}	
	}

	private void drawRect(GraphicsContext gc,int i,int j) {
		gc.strokeRect(i,j,20,20);
	}
	
	public void drawChessPiece(double i,double j,ChessPiecesType piece) {
		if(piece==ChessPiecesType.WHITE) {
	    	 gc.setFill(Color.WHITE);
	    	 gc.fillOval(i, j, 20, 20); 
	    	 }
	    	 else {
	    		 gc.setFill(Color.BLACK);
	    	     gc.fillOval(i, j, 20, 20); 
	    	 }
	}
    
	public void redraw(double width,double height) {
		gc.clearRect(0,0,width+20,height+20);
		gc.setFill(Color.ORANGE);
		gc.fillRect(0,0,width+20,height+20);
		for(int i=20;i<width;i+=20) {
			for(int j=20;j<height;j+=20) {
			drawRect(gc,i,j);
			}
		}	
	}	
}

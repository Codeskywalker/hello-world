package cn.edu.ncu.gobangGame.controller;

import cn.edu.ncu.gobangGame.business.GameLogic;
import cn.edu.ncu.gobangGame.model.ChessPiecesPosition;
import cn.edu.ncu.gobangGame.model.ChessPiecesType;
import cn.edu.ncu.gobangGame.model.GameStatus;
import cn.edu.ncu.gobangGame.view.GameUI;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class PlayController implements EventHandler<MouseEvent> {
    private GameLogic newGame;
    private GameUI gameUI;
    
    public PlayController(GameLogic newGame,GameUI gameUI) {
    	this.newGame=newGame;
    	this.gameUI=gameUI;
    }
	@Override
	public void handle(MouseEvent e) {
		// TODO Auto-generated method stub
		int x=(int)(e.getX()-20)/20;
		int y=(int)(e.getY()-20)/20;
		ChessPiecesPosition p=new ChessPiecesPosition(x,y);
		if(gameUI.isValidPosition(x,y,newGame.chess)) {
			
		  newGame.chess[p.getX()][p.getY()]=(newGame.gameStatus==GameStatus.BLACK_TURN)?
				ChessPiecesType.BLACK:ChessPiecesType.WHITE;
		  gameUI.updateChess(x*20+10,y*20+10,newGame.chess[p.getX()][p.getY()],p);
	
	    }

	}
}

package cn.edu.ncu.gobangGame.business;

import cn.edu.ncu.gobangGame.model.ChessPiecesPosition;
import cn.edu.ncu.gobangGame.model.ChessPiecesType;
import cn.edu.ncu.gobangGame.model.GameStatus;

public class GameLogic {
	//定义游戏逻辑
	private int gameBoardSize;
	public ChessPiecesType[][] chess;
	public GameStatus gameStatus;
    private static GameLogic instance=null;
    
	private GameLogic(int n) {
		this.gameBoardSize=n;
		chess=new ChessPiecesType[gameBoardSize][gameBoardSize];
		for(int i=0;i<gameBoardSize;i++) {
			for(int j=0;j<gameBoardSize;j++) 
				chess[i][j]=null;                                         	
		}
		gameStatus=GameStatus.BLACK_TURN;
	}
   
	public static GameLogic getInstance(int n) {
		if(instance==null)
			instance=new GameLogic(n);
		return instance;
	}
	
	public static GameLogic getInstance() {
		if(instance==null)
			throw new RuntimeException("对象为空");
		return instance;
	}

	public boolean judgeGame(ChessPiecesPosition p) {
		//判断胜负
		boolean up,left,upLeft,upRight;  
		up=checkWin(p,0,1)||checkWin(p, 0, -1);
		left=checkWin(p, 1, 0)||checkWin(p, -1, 0);
		upLeft=checkWin(p, -1, -1)||checkWin(p, 1, 1);
		upRight=checkWin(p, 1, -1)||checkWin(p, -1, 1);
		if(up|| left || upLeft ||upRight) 
		  return true;
		else
			return false;
	}
	private boolean checkWin(ChessPiecesPosition p,int kX,int kY) {
		//判断一个方向是否有五子相连
		int count=0;
		int x=p.getX();
		int y=p.getY();
		while(true) {
			x=x+kX;
			y=y+kY;
			if(isValidPos(x,y,gameBoardSize)&&chess[x][y]==chess[p.getX()][p.getY()])
				count++;
			else 
				break;
			}
		
		if(count==4)
			return true;
	  return false;
	}
	
	private boolean isValidPos(int x,int y,int size) {
		if(x<0||y<0||x>size-1||y>size-1)
			return false;
		return true;
	}
	public void turn() {
		//轮流落子
		 if(gameStatus==GameStatus.BLACK_TURN) { 
			 gameStatus=GameStatus.WHITE_TURN;      
		 }
		 else if(gameStatus==GameStatus.WHITE_TURN) { 
			 gameStatus=GameStatus.BLACK_TURN;
		 }
		}	
	}
	


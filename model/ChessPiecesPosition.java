package cn.edu.ncu.gobangGame.model;

public class ChessPiecesPosition {
	// 定义棋子坐标位置
	
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
   public int getY() {
	   return y;
   }
   public ChessPiecesPosition(int x,int y) {
	   this.x=x;
	   this.y=y;
   }
}

package cn.edu.ncu.gobangGame.model;

public enum  GameStatus {
	BLACK_WIN("�ڷ�Ӯ"),
	WHITE_WIN("�׷�Ӯ"),
	BLACK_TURN("�ڷ���"),
	WHITE_TURN("�׷���");
	private String s;
	private GameStatus(String s) {
		this.s=s;
	}
}

package cn.edu.ncu.gobangGame.model;

public enum  GameStatus {
	BLACK_WIN("黑方赢"),
	WHITE_WIN("白方赢"),
	BLACK_TURN("黑方下"),
	WHITE_TURN("白方下");
	private String s;
	private GameStatus(String s) {
		this.s=s;
	}
}

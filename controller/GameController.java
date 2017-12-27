package cn.edu.ncu.gobangGame.controller;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class GameController extends VBox{
	public GameController() {
		Button exitGame=new Button("ÍË³öÓÎÏ·");
	    getChildren().add(exitGame);
	    exitGame.setOnAction(e->{
	    	exit();
	    });
	}

	public void exit() {
		System.exit(0);
	}
}

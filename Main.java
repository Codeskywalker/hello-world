package cn.edu.ncu.gobangGame;
import cn.edu.ncu.gobangGame.view.GameUI;
/*
 * 双人五子棋 
 * @version 1.0 2017.12.26
 * @author CodeSkywalker
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application{
	@Override
	public void start(Stage app) {
		GameUI gameUI=new GameUI();
		Scene scene=new Scene(gameUI,600,600);
		app.setScene(scene);
		app.setTitle("双人五子棋");
		app.show();
	}
   
	public static void main(String[] args) {
		Application.launch(args);
	}
}

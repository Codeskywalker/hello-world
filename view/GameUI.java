package cn.edu.ncu.gobangGame.view;

import cn.edu.ncu.gobangGame.business.GameLogic;
import cn.edu.ncu.gobangGame.controller.GameController;
import cn.edu.ncu.gobangGame.controller.PlayController;
import cn.edu.ncu.gobangGame.model.ChessPiecesPosition;
import cn.edu.ncu.gobangGame.model.ChessPiecesType;
import cn.edu.ncu.gobangGame.model.GameBoard;
import cn.edu.ncu.gobangGame.model.GameStatus;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameUI extends GridPane{
	GameLogic newGame=GameLogic.getInstance(19);
	double width=19*20;
	double heigth=19*20;
    private GameBoard newGameBoard;
	public GameUI() {
		newGameBoard=new GameBoard(width,heigth);
		Group root=new Group();
		root.getChildren().add(newGameBoard);          
		add(root,0,0);
		root.setOnMouseClicked(new PlayController(newGame, this));
		
		GameController  gController=new GameController();
		add(gController,1,0);
	}
	
	public void updateChess(int x,int y,ChessPiecesType type,ChessPiecesPosition p) {
		newGameBoard.drawChessPiece(x,y,type);
		information(p,newGame.gameStatus);
	}
	  
	private void information(ChessPiecesPosition p,GameStatus gameStatus) {
		if(newGame.judgeGame(p)) {
			showDialog(gameStatus);
		}
		newGame.turn();
	}
	
    private void showDialog(GameStatus gameStatus) {
    	Stage info=new Stage();
		BorderPane pane=new BorderPane();
		Button bt=new Button("Game Over!");
		bt.setOnAction(e->{
			info.close();
		});
		
		Text text=new Text();
		changeTurn(text,gameStatus);
	
		pane.setTop(text);
		pane.setCenter(bt);
		Scene scene=new Scene(pane,200,200);
		info.setScene(scene);
		info.show();
    }
    
	private void changeTurn(Text text,GameStatus gameStatus) {
		if(gameStatus==GameStatus.BLACK_TURN) { 
			text.setText("Winner is Black");
			gameStatus=GameStatus.BLACK_WIN;
		}
		else {
			text.setText("The Winner is White");
			gameStatus=GameStatus.WHITE_WIN;
		}
		
	}
	public boolean isValidPosition(int x,int y,ChessPiecesType[][]chess) {
		if(x>=0&&x<19&&y>=0&&y<19&&chess[x][y]==null) 
			return true;
		else return false;			
	}
}

package javaExperiments.chapter03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class DrawChessBoard extends Application {
	int N=8;
	@Override
	public void start(Stage primaryStage) {
    GridPane pane=new GridPane();
    for(int i=0;i<N;i++) {
    	 for(int j=0;j<N;j++) {
    		 Rectangle rectangle=new Rectangle(80,80);
    		 rectangle.setFill(Color.GRAY);
    		 if((i+j)%2==0) {
    			 rectangle.setFill(Color.WHITE);
    		 }
    		 pane.add(rectangle,j,i);
    		 
    		 Image image = null;
    		 if("0167".contains(i+"")) {
    			 if(i==1||i==6 ) 
    				 image=new Image(getClass().getResource(String.format("img/%d.png", i)).toString());
    			 else
    				 image=new Image(getClass().getResource(String.format("img/%d%d.png", i,j)).toString());
    			
    			 ImageView imageView=new ImageView(image);
    			 imageView.setFitWidth(80);
    			 imageView.setFitHeight(80);
    			 pane.add(imageView, j, i);
    		 }
    	 }
     }
    primaryStage.setTitle("Show ChessBoard");
    primaryStage.setScene(new Scene(pane));
    primaryStage.show();
}
	public static void main(String[] args) {
		launch(args);
	}
}

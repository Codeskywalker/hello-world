package javaExperiments.chapter03;

 import javafx.application.Application;
 import javafx.geometry.Pos;
 import javafx.scene.Scene;
 import javafx.scene.control.Button;
 import javafx.scene.control.Label;
 import javafx.scene.text.FontPosture;
 import javafx.scene.text.FontWeight;
 import javafx.scene.text.Font;
 import javafx.scene.layout.BorderPane;
 import javafx.scene.layout.HBox;
 import javafx.stage.Stage;
 
public class TVUI extends Application {
     static TV tv=new TV();
     @Override
     public void start(Stage primaryStage) {
    	BorderPane pane=new BorderPane();
    	HBox hBox=new HBox();
    	Label channels=new Label("CCTV1");
    	Label volumes=new Label("Volume 10");
    	volumes.setFont(Font.font("Courier",FontWeight.LIGHT,FontPosture.REGULAR,15));
    	channels.setFont(Font.font("Courier",FontWeight.BOLD,FontPosture.ITALIC,20));
   	    Button btChannelDown=new Button("C-");
	    Button btChannelUp=new Button("C+");
	    Button btVolumeDown=new Button("V-");
	    Button btVolumeUp=new Button("V+");
	    Button btOn=new Button("on/off");
	    hBox.getChildren().addAll(volumes,btChannelDown,btChannelUp,btVolumeDown,
	    		btVolumeUp,btOn);
	    hBox.setAlignment(Pos.BOTTOM_RIGHT);
	    hBox.setSpacing(10);;
	    btChannelDown.setOnMouseClicked(e->{
	    	tv.channelDown();
	    	channels.setText("CCTV"+tv.channel);
	    });
	    btChannelUp.setOnMouseClicked(e->{
	    	tv.channelUp();
	        channels.setText("CCTV"+tv.channel);
	    });
	    btOn.setOnMouseClicked(e->{
	         if(tv.on) {
	        	 tv.turnOff();
	        	 pane.setStyle("-fx-background-color:black");
	         }
	         else {
	        	 tv.turnOn();
	        	 pane.setStyle("-fx-background-color:white");
	         }
	         
	    });
	    btVolumeDown.setOnMouseClicked(e->{
	    	tv.volumeDown();
	    	volumes.setText("Volume "+tv.volume);
	    });
	    btVolumeUp.setOnMouseClicked(e->{
	    	tv.volumeUp();
	    	volumes.setText("Volume "+tv.volume);
	    });
    	pane.setBottom(hBox);
    	pane.setCenter(channels);

    	Scene scene=new Scene(pane,400,300);
    	primaryStage.setTitle("Show TV");
    	primaryStage.setScene(scene);
    	primaryStage.show();
    	
     }

     public static void initialize() {
    	 tv.turnOn();
     }
     public static void main(String[] args) {
    	 initialize();
    	 Application.launch(args);
     }
}


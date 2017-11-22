package javaExperiments.chapter03;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class RegularPolygon extends Application{
	final double WIDTH=600,HEIGHT=600;
	double centerX=WIDTH/2,centerY=HEIGHT/2;
	double r=Math.min(WIDTH, HEIGHT)*0.4;
	int n=3;
	Text text=new Text();
	
	@Override
	public void start(Stage primaryStage) {
		BorderPane pane=new BorderPane();
		Polygon polygon=new Polygon();
		polygon.setStroke(Color.BLACK);
		polygon.setFill(Color.WHITE);
		ObservableList<Double> list=polygon.getPoints();
		Label message=new Label("请输入多边形边数:");
		TextField tf=new TextField();
		HBox hb=new HBox();
		Button btOK=new Button("确定");
		
		btOK.setOnAction(e->{ //设置n的值
			try {
				n=Integer.parseInt(tf.getText());
				addPoints(list,n); //把点加入到列表中
			}catch(Exception error) {
				n=3;
				error.printStackTrace();
			}
		});
		tf.clear(); 
		
		text.setFont(Font.font("Courier",FontWeight.LIGHT,FontPosture.REGULAR,15));
		hb.getChildren().addAll(message,tf,btOK);
		pane.setTop(hb);
		pane.setCenter(polygon);
		pane.setBottom(text);
		primaryStage.setTitle("Show Polygon");
		primaryStage.setScene(new Scene(pane,WIDTH,HEIGHT));
		primaryStage.show();
		
	}
	  //添加点到表中
	public void addPoints(ObservableList<Double> list,int N) {
	    	list.clear();
			for(int i=0;i<N;i++) {
				list.add(centerX+r*Math.cos(2*i*Math.PI/N));
				list.add(centerY-r*Math.sin(2*i*Math.PI/N));			
			}
			 text.setText(String.format("Area: %.2f, Perimeter: %.2f",
					 getArea(), getPerimeter()));
	    }
	  
	public double getPerimeter() {
		double l=2*r*Math.sin(Math.PI/n);
		double perimeter = n*l;
		return perimeter;
	}
	
	public double getArea() {
		double l=r*Math.sin(Math.PI/n);
		double h=r*Math.cos(Math.PI/n);
		double area=h*l;
		return area;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage Stage) throws IOException  {

		//povezivanje fxml fajla(screenbuilder) sa eclipsom
		Parent root=FXMLLoader.load(getClass().getResource("StartPage.fxml"));
		Scene scene=new Scene(root);
		Stage.setScene(scene);
		
		Stage.setMinHeight(650);
		Stage.setMinWidth(450);
		
		Stage.setMaxHeight(680);
		Stage.setMaxWidth(460);
		
		Stage.setTitle("Hospital Managment System");
		
		Stage.show();
		Stage.setResizable(false);
		}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * This class is in charge of showing the application
 * @author rdgz
 *
 */
public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root= FXMLLoader.load(getClass().getResource("Magic1.fxml"));
       	
       	Scene scene= new Scene(root);
       	stage.setTitle("Magic Square");
       	stage.setScene(scene);
       	stage.show();
		
	}
	

}

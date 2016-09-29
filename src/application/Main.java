package application;
	

import controller.Admin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import view.IView;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent root = fxmlLoader.load(getClass().getResource("/view/DesktopApp.fxml").openStream());
			Scene scene = new Scene(root,800,500);
			primaryStage.setScene(scene);
			primaryStage.show();
			IView a_view = (IView) fxmlLoader.getController();		// JavaFXGUI class connected to the root 
			//a_view.showWelcomeMessage();	// shows message
			Admin secretary = new Admin(a_view);
			secretary.manage();		// empty form
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}

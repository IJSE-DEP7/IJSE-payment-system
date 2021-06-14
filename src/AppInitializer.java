import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/UserLogin.fxml"));
        Parent root = fxmlLoader.load();
        Scene loginScene = new Scene(root);
        primaryStage.setScene(loginScene);
        loginScene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();

    }



}

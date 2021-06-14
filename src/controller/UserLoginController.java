package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.DateAndTime;
import util.MaterialUI;

import java.io.IOException;


public class UserLoginController {
    public TextField txtUserName;
    public TextField txtPassword;
    public AnchorPane pneBody;
    public Text txtDate;
    public Button btnLogin;

    public void initialize(){
        MaterialUI.paintTextFields(txtUserName,txtPassword);

        MaterialUI.drawBorder(pneBody);
        txtDate.setText(DateAndTime.DateToday());
    }


    public void btnLogin_OnAction(ActionEvent actionEvent) throws IOException {
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader= new FXMLLoader(this.getClass().getResource("/view/MainForm.fxml"));
        Parent root = fxmlLoader.load();
        Scene loginScene = new Scene(root);
        newStage.setScene(loginScene);
        MainFormController ctrl = fxmlLoader.getController();
        ctrl.nav("/view/DashBoard.fxml");
        loginScene.setUserData(ctrl);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(btnLogin.getScene().getWindow());
        loginScene.setFill(Color.TRANSPARENT);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
    }
}

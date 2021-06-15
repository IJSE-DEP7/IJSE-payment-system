package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    public Text txtTime;
    public Text txtForgotPassword;
    public Text txtSignUp;
    public ImageView icnMinimize;
    public ImageView icnClose;

    public void initialize(){
        initWindow();
        MaterialUI.paintTextFields(txtUserName,txtPassword);

        MaterialUI.drawBorder(pneBody);
        txtDate.setText(DateAndTime.DateToday());
    }


    public void btnLogin_OnAction(ActionEvent actionEvent) throws IOException {
        ((Stage)(icnClose.getScene().getWindow())).close();
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader= new FXMLLoader(this.getClass().getResource("/view/MainForm.fxml"));
        Parent root = fxmlLoader.load();
        Scene loginScene = new Scene(root);
        newStage.setScene(loginScene);
        MainFormController ctrl = fxmlLoader.getController();
        ctrl.nav("/view/DashBoard.fxml","Dash Board");
        loginScene.setUserData(ctrl);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(btnLogin.getScene().getWindow());
        loginScene.setFill(Color.TRANSPARENT);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
    }
    private void initWindow(){
        icnClose.setOnMouseExited(event -> icnClose.setImage(new Image("/assests/Multiply.png")));
        icnClose.setOnMouseEntered(event -> icnClose.setImage(new Image("/assests/close.png")));
        icnClose.setOnMouseClicked(event -> ((Stage)(icnClose.getScene().getWindow())).close());

        icnMinimize.setOnMouseExited(event -> icnMinimize.setImage(new Image("/assests/minimize-hove.png")));
        icnMinimize.setOnMouseEntered(event -> icnMinimize.setImage(new Image("/assests/minimize.png")));

    }
}

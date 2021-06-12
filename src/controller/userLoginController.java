package controller;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import util.DateAndTime;
import util.MaterialUI;



public class userLoginController {
    public TextField txtUserName;
    public TextField txtPassword;
    public AnchorPane pneBody;
    public Text txtDate;

    public void initialize(){
        MaterialUI.paintTextFields(txtPassword,txtUserName);

        MaterialUI.drawBorder(pneBody);
        txtDate.setText(DateAndTime.DateToday());
    }




}

package controller;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import util.MaterialUI;



public class userLoginController {
    public TextField txtUserName;
    public TextField txtPassword;
    public AnchorPane pneBody;

    public void initialize(){
        MaterialUI.paintTextFields(txtPassword,txtUserName);

        MaterialUI.drawBorder(pneBody);
    }




}

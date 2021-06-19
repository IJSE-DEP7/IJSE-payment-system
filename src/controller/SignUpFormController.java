package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import util.MaterialUI;

public class SignUpFormController {
    public ImageView icnMinimize;
    public ImageView icnClose;
    public AnchorPane pneStage;
    public TextField txtUserName;
    public TextField txtEmail;
    public TextField txtPassword;
    public TextField txtConfirmPassword;
    public TextField txtContactNumber;
    public TextField txtAddress;
    public Button btnCreateAccount;
    public Text txtBack;
    public AnchorPane window;

    public void initialize(){
        initWindow();
        MaterialUI.drawBorder(pneStage);
        MaterialUI.paintTextFields(txtUserName,txtAddress,txtPassword,txtConfirmPassword,txtEmail,txtContactNumber);
        MaterialUI.addCheckBox(txtUserName,txtAddress,txtPassword,txtConfirmPassword,txtEmail,txtContactNumber);
    }
    
    private void initWindow(){
        icnClose.setOnMouseExited(event -> icnClose.setImage(new Image("/assests/close.png")));
        icnClose.setOnMouseEntered(event -> icnClose.setImage(new Image("/assests/close-hover.png")));
        icnClose.setOnMouseClicked(event -> ((Stage)(icnClose.getScene().getWindow())).close());

        icnMinimize.setOnMouseExited(event -> icnMinimize.setImage(new Image("/assests/minimize.png")));
        icnMinimize.setOnMouseEntered(event -> icnMinimize.setImage(new Image("/assests/minimize-hover.png")));

    }
    

    public void lblMinimize_OnMouseClicked(MouseEvent mouseEvent) {
    }

    public void lblClose_OnMouseClicked(MouseEvent mouseEvent) {
    }

    public void btnCreateAccount_OnAction(ActionEvent actionEvent) {
    }

    public void txtBack_OnMouseClicked(MouseEvent mouseEvent) {
    }
}

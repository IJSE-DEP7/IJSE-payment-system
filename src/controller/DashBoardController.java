package controller;

import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.DashBoardTM;
import util.MaterialUI;

public class DashBoardController {

    public AnchorPane pneBody;
    public Label lblIncomeCash;
    public Label lblDate;
    public Label lblIncomeCard;
    public Label lblIncomeOnline;
    public TableView tblDashBoard;
    public Label lbltime;
    public ImageView icnNotifications;


    public void initialize(){

        MaterialUI.drawBorder(pneBody);
        tblDashBoard.getItems().add(new DashBoardTM());
        tblDashBoard.getItems().add(new DashBoardTM());
        tblDashBoard.getItems().add(new DashBoardTM());
        tblDashBoard.getItems().add(new DashBoardTM());

        icnNotifications.setOnMouseEntered(event -> {
            icnNotifications.setImage(new Image("/assests/Notification-hover.png"));
        });
        icnNotifications.setOnMouseExited(event -> {
            icnNotifications.setImage(new Image("/assests/Notification.png"));
        });
    }

    public void lblNotifications_OnMouseClicked(MouseEvent mouseEvent) {
         MainFormController ctrl = (MainFormController) pneBody.getScene().getUserData();
         ctrl.nav("/view/PaymentAlerts.fxml","Dash Board");
    }
}

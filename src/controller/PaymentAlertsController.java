package controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Window;
import model.PaymentAlertsTM;
import util.DateAndTime;
import util.MaterialUI;

public class PaymentAlertsController {
    public AnchorPane pneBody;
    public Label lblDate;
    public Label lbltime;
    public Button btnBack;
    public TableView<PaymentAlertsTM> tblUpComingPayments;

    public void initialize(){
        MaterialUI.drawBorder(pneBody);
        lblDate.setText(DateAndTime.DateToday());
        tblUpComingPayments.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("courseName"));
        tblUpComingPayments.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("studentName"));
        tblUpComingPayments.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tblUpComingPayments.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        tblUpComingPayments.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("amount"));
        TableColumn<PaymentAlertsTM, VBox> lastcol = (TableColumn<PaymentAlertsTM, VBox>) tblUpComingPayments.getColumns().get(5);

        lastcol.setCellValueFactory(param -> {
            Button btnSMS = new Button();
            Button btnEmail = new Button();
            Button btnTrash = new Button();

            btnSMS.getStyleClass().add("sms-button");
            btnEmail.getStyleClass().add("email-button");
            btnTrash.getStyleClass().add("trash-button");

            return new ReadOnlyObjectWrapper<>(new VBox(5, btnSMS,btnEmail, btnTrash));
        });
        tblUpComingPayments.getItems().add(new PaymentAlertsTM());


    }

    public void btnBack_OnAction(ActionEvent actionEvent) {
        MainFormController ctrl = (MainFormController) pneBody.getScene().getUserData();
        ctrl.nav("/view/DashBoard.fxml","Dash Board");
    }
}

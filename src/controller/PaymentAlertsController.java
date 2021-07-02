package controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.PaymentAlertsTM;
import util.DateAndTime;
import util.MaterialUI;

public class PaymentAlertsController {
    public AnchorPane pneBody;
    public Label lblDate;
    public Label lbltime;
    public Button btnBack;
    public TableView<PaymentAlertsTM>  tblPaymentAlerts;

    public void initialize(){
        MaterialUI.drawBorder(pneBody);
        lblDate.setText(DateAndTime.DateToday());
        tblPaymentAlerts.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("courseName"));
        tblPaymentAlerts.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("studentName"));
        tblPaymentAlerts.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tblPaymentAlerts.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        tblPaymentAlerts.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("amount"));
        TableColumn<PaymentAlertsTM, VBox> lastcol = (TableColumn<PaymentAlertsTM, VBox>) tblPaymentAlerts.getColumns().get(5);

        lastcol.setCellValueFactory(param -> {
            Button btnSMS = new Button();
            Button btnEmail = new Button();
            Button btnTrash = new Button();

            btnSMS.getStyleClass().add("sms-button");
            btnSMS.setText("SMS");
            btnEmail.getStyleClass().add("email-button");
            btnEmail.setText("Email");
            btnTrash.getStyleClass().add("trash-button");
            btnTrash.setText("Remove");



            return new ReadOnlyObjectWrapper<>(new VBox(5, btnSMS,btnEmail, btnTrash));
        });
        tblPaymentAlerts.getItems().add(new PaymentAlertsTM());


    }

    public void btnBack_OnAction(ActionEvent actionEvent) {
        MainFormController ctrl = (MainFormController) pneBody.getScene().getUserData();
        ctrl.navigate("/view/DashBoard.fxml","Dash Board");
    }
}

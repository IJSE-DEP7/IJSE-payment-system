package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.DateAndTime;
import util.MaterialUI;

public class FeesPaymentController {
    public AnchorPane pneBody;
    public Label lblDate;
    public Label lbltime;
    public ComboBox cmbCourse;
    public ComboBox cmbPaymentMethod;
    public TextField txtSearchStudent;
    public TextField txtStudentName;
    public TextField txtStudentEmail;
    public TextField txtCommencementDate;
    public TextField txtBatchNo;
    public TextField txtDescription;
    public Button btnClearAll;
    public Button btnNext;
    public TextField txtRecieptAmount;
    public TextField txtRecievedAmount;
    public TextField txtNextPayment;

    public void initialize(){
        MaterialUI.paintComboBox(cmbCourse,cmbPaymentMethod);
        MaterialUI.paintTextFields(txtBatchNo,txtNextPayment,txtDescription,txtRecieptAmount,txtRecievedAmount,txtCommencementDate,txtSearchStudent,txtStudentEmail,txtStudentName);
        MaterialUI.checkBox(txtBatchNo,txtNextPayment,txtDescription,txtRecieptAmount,txtRecievedAmount,txtCommencementDate,txtSearchStudent,txtStudentEmail,txtStudentName);
        MaterialUI.drawBorder(pneBody);
        lblDate.setText(DateAndTime.DateToday());
    }

    public void btnClearAll_OnAction(ActionEvent actionEvent) {
    }

    public void btnSubmit_OnAction(ActionEvent actionEvent) {
    }
}

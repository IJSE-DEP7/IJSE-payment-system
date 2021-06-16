package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.DateAndTime;
import util.MaterialUI;

public class ManageCoursesController {
    public AnchorPane pneBody;
    public Label lblDate;
    public Label lbltime;
    public TextField txtCourseName;
    public Button btnEnter;
    public TextField txtCourseFee;
    public TextField txtRegistrationFee;
    public TextField txtNoOfPayments;
    public Button btnBack;


    public void initialize(){
        MaterialUI.paintTextFields(txtCourseFee,txtCourseName,txtRegistrationFee,txtNoOfPayments);
        MaterialUI.drawBorder(pneBody);
        MaterialUI.addCheckBox(txtCourseFee,txtCourseName,txtRegistrationFee,txtNoOfPayments);
        lblDate.setText(DateAndTime.DateToday());
    }
    public void btnBack_OnAction(ActionEvent actionEvent) {
    }

    public void btnEnter_OnAction(ActionEvent actionEvent) {
    }
}

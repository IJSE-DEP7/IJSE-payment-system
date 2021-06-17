package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.DateAndTime;
import util.MaterialUI;

public class AddNewCourseController {

    public AnchorPane pneBody;
    public Label lblDateAddNewCourse;
    public Label lbltimeAddNewCourse;
    public TextField txtCourseName;
    public Button btnEnter;
    public TextField txtCourseFee;
    public TextField txtRegistrationFee;
    public TextField txtNoOfPayments;
    public Button btnBack;

    public void initialize(){
        
        MaterialUI.paintTextFields(txtCourseName,txtCourseFee,txtRegistrationFee,txtNoOfPayments);
        lblDateAddNewCourse.setText(DateAndTime.DateToday());
        MaterialUI.addCheckBox(txtCourseName,txtCourseFee,txtRegistrationFee,txtNoOfPayments);
    }

    public void btnBack_OnAction(ActionEvent actionEvent) {
    }

    public void btnEnter_OnAction(ActionEvent actionEvent) {
    }
}

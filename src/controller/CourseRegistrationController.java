package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.DateAndTime;
import util.MaterialUI;

public class CourseRegistrationController {
    //public AnchorPane pneSideBar;
    public AnchorPane pneBody;
    public ComboBox cmbCourse;
    public ComboBox cmbQualification;
    public TextField txtName;
    public TextField txtPlacementExamMarks;
    public TextField txtAddress;
    public TextField txtCommencementDate;
    public TextField txtDateOfBirth;
    public TextField txtEmail;
    public TextField txtPhoto;
    public Button btnClearAll;
    public Button btnNext;

    public void initialize(){
        MaterialUI.paintComboBox(cmbCourse,cmbQualification);
        MaterialUI.paintTextFields(txtName,txtPlacementExamMarks,txtAddress,txtCommencementDate,txtDateOfBirth,txtEmail,txtPhoto);

        //MaterialUI.drawBorder(pneBody);
        //MaterialUI.drawBorder(pneSideBar);
    }

    public void btnClearAll_OnAction(ActionEvent actionEvent) {
    }

    public void btnNext_OnAction(ActionEvent actionEvent) {
    }

    public void chbFullTime_OnMouseClicked(MouseEvent mouseEvent) {
    }

    public void chbPartTime_OnMouseClicked(MouseEvent mouseEvent) {
    }

    


    public void lblAttachPhoto_OnMouseClicked(MouseEvent mouseEvent) {
    }
}

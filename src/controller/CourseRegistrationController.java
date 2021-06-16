package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
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
    public ImageView chk;
    public AnchorPane name;
    public Label lblDate;
    public Label lbltime;
    public Label lblStudentId;
    public ImageView lblAttachPhoto;
    public CheckBox chkPartTime;
    public CheckBox chkFullTime;
    //private ImageView ImageView;


    public void initialize(){
        initWindow();
    }

    private void initWindow(){
        MaterialUI.paintComboBox(cmbCourse,cmbQualification);
        MaterialUI.paintTextFields(txtName,txtPlacementExamMarks,txtAddress,txtCommencementDate,txtDateOfBirth,txtEmail,txtPhoto);
        MaterialUI.checkBox(txtName,txtPlacementExamMarks,txtAddress,txtCommencementDate,txtDateOfBirth,txtEmail);
        MaterialUI.drawBorder(pneBody);
        lblDate.setText(DateAndTime.DateToday());
        checkBoxControl(chkPartTime,chkFullTime);
        checkBoxControl(chkFullTime,chkPartTime);
    }
    private void checkBoxControl(CheckBox clickedBox,CheckBox disableBox){
        clickedBox.setOnMouseClicked(event -> {
            if(disableBox.isDisable()){
                disableBox.setDisable(false);
            }else{
                disableBox.setDisable(true);
            }
        });
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

    public void chkPartTime_OnMouseClicked(MouseEvent mouseEvent) {

    }

    public void chkFullTime_OnMouseClocked(MouseEvent mouseEvent) {
    }
}

package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Student;
import service.StudentService;
import util.DateAndTime;
import util.MaterialUI;

import java.time.LocalDate;

public class StudentRegistrationController {
    public AnchorPane pneBody;
    public ComboBox cmbCourse;
    public ComboBox cmbQualification;
    public TextField txtName;
    public TextField txtPlacementExamMarks;
    public TextField txtAddress;
    public TextField txtDateOfBirth;
    public TextField txtEmail;
    public Button btnClearAll;
    public Button btnNext;
    public ImageView chk;
    public Label lblDate;
    public Label lbltime;
    public Label lblStudentId;
    public CheckBox chkPartTime;
    public CheckBox chkFullTime;
    public TextField txtContactNo;
    public TextField txtNic;


    public void initialize(){
        initWindow();
    }

    private void initWindow(){
        MaterialUI.paintComboBox(cmbCourse,cmbQualification);
        MaterialUI.paintTextFields(txtName,txtPlacementExamMarks,txtAddress,txtContactNo,txtDateOfBirth,txtEmail,txtNic);
        MaterialUI.addCheckBox(txtName,txtPlacementExamMarks,txtAddress,txtContactNo,txtDateOfBirth,txtEmail,txtNic);
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
        try{
            String course=cmbCourse.toString();
            String highestQualification=cmbQualification.toString();
            String name = txtName.getText();
            String marks = txtPlacementExamMarks.getText();
            String address = txtAddress.getText();
            LocalDate dob = LocalDate.parse(txtDateOfBirth.getText());
            String email = txtEmail.getText();
            String contactNo = txtContactNo.getText();
            String nic = txtNic.getText();
            Student student = new Student(course,highestQualification,name,marks,address,dob,email,nic,contactNo);
            StudentService studentService = new StudentService();
            studentService.saveStudent(student);
            new Alert(Alert.AlertType.NONE,"Student has been saved successfully",ButtonType.OK).show();
        }catch (RuntimeException e){
            new Alert(Alert.AlertType.ERROR,"Failed to save student",ButtonType.OK).show();
            return;
        }
        MainFormController ctrl = (MainFormController) pneBody.getScene().getUserData();
        ctrl.nav("/view/FeesPayment.fxml","Fees Payment");
    }

    public void lblAttachPhoto_OnMouseClicked(MouseEvent mouseEvent) {
    }

    public void chkPartTime_OnMouseClicked(MouseEvent mouseEvent) {

    }

    public void chkFullTime_OnMouseClocked(MouseEvent mouseEvent) {
    }
}

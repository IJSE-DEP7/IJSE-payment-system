package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Course;
import model.Student;
import service.CourseService;
import service.StudentService;
import util.DateAndTime;
import util.MaterialUI;

import java.time.LocalDate;

public class StudentRegistrationController {
    public AnchorPane pneBody;
    public ComboBox<String> cmbCourse;
    public ComboBox<String> cmbQualification;
    public TextField txtName;
    public TextField txtPlacementExamMarks;
    public TextField txtAddress;
    public TextField txtDateOfBirth;
    public TextField txtEmail;
    public Button btnClearAll;
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

        ObservableList<String> courseList = cmbCourse.getItems();
        for (Course course: CourseService.findAllCourses()) {
            courseList.add(course.getName());
        }
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
        txtName.clear();
        txtDateOfBirth.clear();
        txtEmail.clear();
        txtPlacementExamMarks.clear();
        txtPlacementExamMarks.clear();
        txtAddress.clear();
        txtContactNo.clear();
        txtNic.clear();
        cmbCourse.getSelectionModel().clearSelection();
        cmbQualification.getSelectionModel().clearSelection();
    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
        try{
            String courseId=CourseService.findCourseByName(cmbCourse.getSelectionModel().getSelectedItem()).getId();
            String highestQualification=cmbQualification.getSelectionModel().getSelectedItem();
            String name = txtName.getText();
            String marks = txtPlacementExamMarks.getText();
            String address = txtAddress.getText();
            LocalDate dob = LocalDate.parse(txtDateOfBirth.getText());
            String email = txtEmail.getText();
            String contactNo = txtContactNo.getText();
            String nic = txtNic.getText();
            Boolean fullTime = chkFullTime.isSelected();

            Student student = new Student(courseId,highestQualification,name,marks,address,dob,email,nic,contactNo,fullTime);
            StudentService studentService = new StudentService();
            studentService.saveStudent(student);
            System.out.println(student);
            new Alert(Alert.AlertType.NONE,"Student has been saved successfully",ButtonType.OK).show();
        }catch (RuntimeException e){
            new Alert(Alert.AlertType.ERROR,"Failed to save student",ButtonType.OK).show();
            return;
        }
    }

}

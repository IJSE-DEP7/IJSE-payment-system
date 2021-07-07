package controller;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.Course;
import model.Student;
import model.StudentTM;
import service.CourseService;
import service.StudentService;
import util.DateAndTime;
import util.MaterialUI;

import java.time.LocalDate;
import java.util.Optional;

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
    public AnchorPane root;
    public Button btnSave;


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
        Platform.runLater(()->{
            if(root.getUserData()!=null){
                StudentTM tm = (StudentTM) root.getUserData();
                Student student = StudentService.findStudent(tm.getNic());
                txtName.setText(student.getName());
                txtDateOfBirth.setText(student.getDateOfBirth().toString());
                txtEmail.setText(student.getEmail());
                txtPlacementExamMarks.setText(student.getMarks());
                txtAddress.setText(student.getAddress());
                txtContactNo.setText(student.getContactNo());
                txtNic.setText(student.getNic());
                cmbCourse.setValue(CourseService.findCourse(student.getCourseId()).getName());
                cmbQualification.setValue(student.getHighestQualification());
                if(student.isFulltime()){
                    chkFullTime.setSelected(true);
                }else{
                    chkPartTime.setSelected(true);
                }
                btnSave.setText("Update");

            }
        });


    }
    private void checkBoxControl(CheckBox clickedBox,CheckBox disableBox){
        clickedBox.setOnMouseClicked(event -> {
            if(clickedBox.isSelected()){
                disableBox.setDisable(true);
                disableBox.setSelected(false);
            }else{
                disableBox.setDisable(false);
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
        chkPartTime.setSelected(false);
        chkFullTime.setSelected(false);
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
            Student student = new Student(courseId, highestQualification, name, marks, address, dob, email, nic, contactNo, fullTime);

            if(btnSave.getText().equals("Update")){

                StudentTM tm = (StudentTM) root.getUserData();
                tm.setAddress(address);
                tm.setContactNo(txtContactNo.getText());
                tm.setEmail(txtEmail.getText());
                tm.setNic(txtNic.getText());
                tm.setName(txtName.getText());
                StudentService.updateStudent(student);
                new Alert(Alert.AlertType.NONE, "Student has been updated successfully", ButtonType.OK).show();

            }else {

                StudentService.saveStudent(student);
                System.out.println(student);
                Optional<ButtonType> buttonType=new Alert(Alert.AlertType.CONFIRMATION, "Is student paid now?", ButtonType.YES,ButtonType.NO).showAndWait();
                if (buttonType.get()==ButtonType.YES){
                    MainFormController ctrl = (MainFormController) pneBody.getScene().getUserData();
                    ctrl.navigate("/view/FeesPayment.fxml","Fees Payment",student);
                }else{
                    new Alert(Alert.AlertType.NONE,"Student data has been saved successfully",ButtonType.OK).show();
                }
            }
        }catch (RuntimeException e){
            new Alert(Alert.AlertType.ERROR,"Failed to save student",ButtonType.OK).show();
            return;
        }
    }

    //TODO:load qualifications list for combo box and change color of selected item of combo box
}

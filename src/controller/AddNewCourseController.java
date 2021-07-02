package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.Course;
import model.CourseTM;
import service.CourseService;
import util.DateAndTime;
import util.MaterialUI;

import java.util.Optional;

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
    public AnchorPane root;
    public TextField txtCourseId;
    public Text lblTitle;

    public void initialize(){

        initwindow();
    }

    private CourseService cs = new CourseService();
    private void initwindow() {
        MaterialUI.paintTextFields(txtCourseId,txtCourseName,txtCourseFee,txtRegistrationFee,txtNoOfPayments);
        lblDateAddNewCourse.setText(DateAndTime.DateToday());
        MaterialUI.addCheckBox(txtCourseId,txtCourseName,txtCourseFee,txtRegistrationFee,txtNoOfPayments);
        Platform.runLater(()->{

            if(root.getUserData()!=null){
                CourseTM tm = (CourseTM) root.getUserData();
                Course course = cs.findCourse(tm.getId());

                txtCourseId.setText(course.getId());
                txtCourseName.setText(course.getName());
                txtCourseFee.setText(course.getFee());
                txtRegistrationFee.setText(course.getRegFee());
                txtNoOfPayments.setText(course.getNumberOfInstallments());

                btnEnter.setText("Update");
                lblTitle.setText("Update Course");
            }
        });
    }


    public void btnBack_OnAction(ActionEvent actionEvent) {
        MainFormController ctrl = (MainFormController) pneBody.getScene().getUserData();
        ctrl.navigate("/view/ManageCourses.fxml","Manage Courses");
    }

    public void btnEnter_OnAction(ActionEvent actionEvent) {
        try {
            String id = txtCourseId.getText();
            String name = txtCourseName.getText();
            String fee = txtCourseFee.getText();
            String numberOfInstallments = txtNoOfPayments.getText();
            String regFee = txtRegistrationFee.getText();
            Course c = new Course(id, name, fee, regFee, numberOfInstallments);
            if(btnEnter.getText().equals("Update")){

                CourseTM tm = (CourseTM) root.getUserData();
                tm.setId(txtCourseId.getText());
                tm.setCourseFee(txtCourseFee.getText());
                tm.setCourseName(txtCourseName.getText());
                tm.setRegFee(txtRegistrationFee.getText());
                tm.setNoOfInstallments(txtNoOfPayments.getText());
                Optional<ButtonType> buttonType = new Alert(Alert.AlertType.INFORMATION,"Are you sure to change the data", ButtonType.CANCEL,ButtonType.OK).showAndWait();
                if(buttonType.get()==ButtonType.OK){
                    CourseService.updateCourse(c);
                    new Alert(Alert.AlertType.INFORMATION,"Course has been updated successfully", ButtonType.OK).showAndWait();
                }

            }else{

                CourseService.addNewCourse(c);
                new Alert(Alert.AlertType.INFORMATION,"Course has been saved successfully", ButtonType.OK).showAndWait();

            }

        }catch(RuntimeException e){
            new Alert(Alert.AlertType.ERROR,"Failed to save course", ButtonType.OK).showAndWait();
        }
    }
}

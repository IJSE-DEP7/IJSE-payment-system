package controller;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Course;
import service.CourseService;
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
    public TextField txtCourseId;

    public void initialize(){

        initwindow();
    }

    private void initwindow() {
        MaterialUI.paintTextFields(txtCourseId,txtCourseName,txtCourseFee,txtRegistrationFee,txtNoOfPayments);
        lblDateAddNewCourse.setText(DateAndTime.DateToday());
        MaterialUI.addCheckBox(txtCourseId,txtCourseName,txtCourseFee,txtRegistrationFee,txtNoOfPayments);
    }


    public void btnBack_OnAction(ActionEvent actionEvent) {
        MainFormController ctrl = (MainFormController) pneBody.getScene().getUserData();
        ctrl.nav("/view/ManageCourses.fxml","Manage Courses");
    }

    public void btnEnter_OnAction(ActionEvent actionEvent) {
        String id = txtCourseId.getText();
        String name = txtCourseName.getText();
        String fee = txtCourseFee.getText();
        String numberOfInstallments = txtNoOfPayments.getText();
        String regFee = txtRegistrationFee.getText();

        Course c = new Course(id,name,fee,regFee,numberOfInstallments);

        CourseService cs = new CourseService();
        cs.addNewCourse(c);
    }
}

package controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Course;
import model.CourseTM;
import service.CourseService;
import util.DateAndTime;
import util.MaterialUI;

import java.io.IOException;
import java.util.Optional;

public class ManageCoursesController {
    public AnchorPane pneBody;
    public TextField txtCourseName;
    public Button btnEnter;
    public TextField txtCourseFee;
    public TextField txtRegistrationFee;
    public TextField txtNoOfPayments;
    public Button btnBack;
    public TableView<CourseTM> tblManageCourses;
    public Button btnAddNewCourse;
    public Label lbltimeManageCourse;
    public Label lblDateManageCourse;



    public void initialize(){
//        MaterialUI.paintTextFields(txtCourseFee,txtCourseName,txtRegistrationFee,txtNoOfPayments);
//        MaterialUI.drawBorder(pneBody);
//        MaterialUI.addCheckBox(txtCourseFee,txtCourseName,txtRegistrationFee,txtNoOfPayments);
//        lblDate.setText(DateAndTime.DateToday());

        intiwindow();

    }

    private void intiwindow() {
        MaterialUI.drawBorder(pneBody);
        lblDateManageCourse.setText(DateAndTime.DateToday());
        DateAndTime.timeNow(lbltimeManageCourse);

        tblManageCourses.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblManageCourses.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("courseName"));
        tblManageCourses.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("courseFee"));
        tblManageCourses.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("regFee"));
        tblManageCourses.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("noOfInstallments"));
        TableColumn<CourseTM, HBox> lastcol = (TableColumn<CourseTM,HBox>) tblManageCourses.getColumns().get(5);

        lastcol.setCellValueFactory(param -> {

            Button btnEdit = new Button();
            Button btnTrash = new Button();

            btnEdit.getStyleClass().add("edit-button");
            btnTrash.getStyleClass().add("trash-button");

            btnEdit.setOnMouseClicked(event -> updateCourse(param.getValue()));
            btnTrash.setOnMouseClicked(event -> deleteCourse(param.getValue()));

            return new ReadOnlyObjectWrapper<>(new HBox(5, btnEdit, btnTrash));
        });

        loadAllCourses();
    }

    private void loadAllCourses() {
        tblManageCourses.getItems().clear();

        for(Course course : CourseService.findAllCourses()){
            tblManageCourses.getItems().add(new CourseTM(course.getId(), course.getName(), course.getFee(), course.getRegFee(), course.getNumberOfInstallments()));
        }

    }
    
    private void deleteCourse(CourseTM tm){
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure to delete this course",ButtonType.YES,ButtonType.NO).showAndWait();
        try {
            if (buttonType.get() == ButtonType.YES) {
                CourseService.deleteCourse(tm.getId());
                tblManageCourses.getItems().remove(tm);
            }
        }catch (RuntimeException e){
            new Alert(Alert.AlertType.ERROR,"Failed to delete course",ButtonType.OK).show();
        }
    }

    private void updateCourse(CourseTM tm){
        
        try {
            MainFormController ctrl = (MainFormController) pneBody.getScene().getUserData();
            ctrl.navigate("/view/AddNewCourse.fxml","Manage Course",tm);
        } catch (RuntimeException e) {
            new Alert(Alert.AlertType.ERROR,"Failed to update the course").show();
        }

    }
    public void btnBack_OnAction(ActionEvent actionEvent) {
    }

    public void btnEnter_OnAction(ActionEvent actionEvent) {
    }

    public void btnAddNewCourse_OnAction(ActionEvent actionEvent) {
        MainFormController ctrl = (MainFormController) pneBody.getScene().getUserData();
        ctrl.navigate("/view/AddNewCourse.fxml","Manage Courses");
    }

    public void tblManageCourses_OnAction(KeyEvent keyEvent) {
        if(keyEvent.getCode()== KeyCode.DELETE){
            deleteCourse(tblManageCourses.getSelectionModel().getSelectedItem());
        }else if (keyEvent.getCode() == KeyCode.ENTER){
            updateCourse(tblManageCourses.getSelectionModel().getSelectedItem());
        }
    }
}

package controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Material;
import model.CourseTM;
import util.DateAndTime;
import util.MaterialUI;

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

        MaterialUI.drawBorder(pneBody);
        lblDateManageCourse.setText(DateAndTime.DateToday());
        tblManageCourses.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("courseName"));
        tblManageCourses.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("courseFee"));
        tblManageCourses.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("regFee"));
        tblManageCourses.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("noOfInstallments"));
        TableColumn<CourseTM, HBox> lastcol = (TableColumn<CourseTM,HBox>) tblManageCourses.getColumns().get(4);

        lastcol.setCellValueFactory(param -> {

            Button btnEdit = new Button();
            Button btnTrash = new Button();

            btnEdit.getStyleClass().add("edit-button");
            btnTrash.getStyleClass().add("trash-button");

            return new ReadOnlyObjectWrapper<>(new HBox(5, btnEdit, btnTrash));
        });
        tblManageCourses.getItems().add(new CourseTM());

    }
    public void btnBack_OnAction(ActionEvent actionEvent) {
    }

    public void btnEnter_OnAction(ActionEvent actionEvent) {
    }

    public void btnAddNewCourse_OnAction(ActionEvent actionEvent) {
        MainFormController ctrl = (MainFormController) pneBody.getScene().getUserData();
        ctrl.nav("/view/AddNewCourse.fxml","Manage Courses");
    }
}

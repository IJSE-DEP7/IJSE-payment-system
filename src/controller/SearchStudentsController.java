package controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import model.CourseTM;
import model.Student;
import model.StudentTM;
import service.StudentService;
import util.DateAndTime;
import util.MaterialUI;

public class SearchStudentsController {
    public AnchorPane pneBody;
    public Label lblDate;
    public Label lbltime;
    public TableView<StudentTM> tblSearchStudents;
    public TextField txtSearchStudent;

    public void initialize(){

        initwindow();
        loadAllStudents();
    }


    private void initwindow() {
        MaterialUI.drawBorder(pneBody);
        MaterialUI.paintTextFields(txtSearchStudent);
        MaterialUI.addCheckBox(txtSearchStudent);
        lblDate.setText(DateAndTime.DateToday());

        tblSearchStudents.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblSearchStudents.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblSearchStudents.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblSearchStudents.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tblSearchStudents.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("DOB"));
        TableColumn<StudentTM, HBox> lastcol = (TableColumn<StudentTM,HBox>) tblSearchStudents.getColumns().get(5);

        lastcol.setCellValueFactory(param -> {

            Button btnEdit = new Button();
            Button btnTrash = new Button();

            btnEdit.getStyleClass().add("edit-button");
            btnTrash.getStyleClass().add("trash-button");

            return new ReadOnlyObjectWrapper<>(new HBox(10, btnEdit, btnTrash));
        });

    }

    private void loadAllStudents() {

        tblSearchStudents.getItems().clear();

        for(Student student : StudentService.findAllStudents()){
            tblSearchStudents.getItems().add(new StudentTM(student.getName(),student.getAddress(),student.getEmail(),student.getContactNo(),student.getDateOfBirth()));
        }

    }

}

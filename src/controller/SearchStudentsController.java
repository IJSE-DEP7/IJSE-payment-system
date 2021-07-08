package controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import model.Student;
import model.StudentTM;
import service.StudentService;
import util.DateAndTime;
import util.MaterialUI;

import java.util.Optional;

public class SearchStudentsController {
    public AnchorPane pneBody;
    public Label lblDate;
    public Label lbltime;
    public TableView<StudentTM> tblSearchStudents;
    public TextField txtSearchStudent;

    public void initialize(){

        initwindow();
    }


    private void initwindow() {
        MaterialUI.drawBorder(pneBody);
        MaterialUI.paintTextFields(txtSearchStudent);
        MaterialUI.addCheckBox(txtSearchStudent);
        lblDate.setText(DateAndTime.DateToday());
        DateAndTime.timeNow(lbltime);

        tblSearchStudents.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblSearchStudents.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblSearchStudents.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblSearchStudents.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tblSearchStudents.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("nic"));
        TableColumn<StudentTM, HBox> lastCol = (TableColumn<StudentTM,HBox>) tblSearchStudents.getColumns().get(5);

        lastCol.setCellValueFactory(param -> {

            Button btnEdit = new Button();
            Button btnTrash = new Button();

            btnEdit.getStyleClass().add("edit-button");
            btnTrash.getStyleClass().add("trash-button");

            btnTrash.setOnMouseClicked(event -> deleteStudent(param.getValue()));
            btnEdit.setOnMouseClicked(event -> updateStudent(param.getValue()));

            return new ReadOnlyObjectWrapper<>(new HBox(10, btnEdit, btnTrash));
        });

        txtSearchStudent.textProperty().addListener((observable, oldValue, newValue) -> loadAllStudents(newValue));
        loadAllStudents(null);
    }

    private void updateStudent(StudentTM tm){
        try {
            MainFormController ctrl = (MainFormController) pneBody.getScene().getUserData();
            ctrl.navigate("/view/StudentRegistration.fxml","Update Student",tm);
        } catch (RuntimeException e) {
            new Alert(Alert.AlertType.ERROR,"Failed to update the student").show();
        }
    }

    private void deleteStudent(StudentTM tm){
        try{
            Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure to delete this student",ButtonType.NO,ButtonType.YES).showAndWait();
            if(buttonType.get()== ButtonType.YES){
                StudentService.deleteStudent(tm.getNic());
                tblSearchStudents.getItems().remove(tm);
            }

        }catch(RuntimeException e){
            new Alert(Alert.AlertType.ERROR,"Failed to delete the item",ButtonType.OK).show();
        }
    }

    private void loadAllStudents(String query) {

        tblSearchStudents.getItems().clear();

        for(Student student : StudentService.findStudents(query==null || query.trim().isEmpty()?"":query)){
            tblSearchStudents.getItems().add(new StudentTM(student.getName(),student.getAddress(),student.getEmail(),student.getContactNo(),student.getNic()));
        }
    }

    public void tblSearchStudents_OnKeyPressed(KeyEvent keyEvent) {
        if(keyEvent.getCode()== KeyCode.DELETE){
            deleteStudent(tblSearchStudents.getSelectionModel().getSelectedItem());
        }
        if(keyEvent.getCode()== KeyCode.ENTER){
            updateStudent(tblSearchStudents.getSelectionModel().getSelectedItem());
        }
    }
}

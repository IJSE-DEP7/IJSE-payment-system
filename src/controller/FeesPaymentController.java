package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.Course;
import model.Payment;
import model.Student;
import service.CourseService;
import service.PaymentService;
import service.StudentService;
import util.DateAndTime;
import util.MaterialUI;

import java.time.LocalDate;

public class FeesPaymentController {
    public AnchorPane pneBody;
    public Label lblDate;
    public Label lbltime;
    public ComboBox cmbCourse;
    public ComboBox<String> cmbPaymentMethod;
    public TextField txtStudentName;
    public TextField txtStudentEmail;
    public TextField txtNextPaymentDate;
    public TextField txtBatchNo;
    public TextField txtDescription;
    public Button btnClearAll;
    public Button btnNext;
    public TextField txtRecieptAmount;
    public TextField txtRecievedAmount;
    public TextField txtNextPayment;
    public TextField txtSearchStudent;
    public CheckBox chkSendEmail;
    public CheckBox chkPrintReciept;
    public Label lblId;
    public AnchorPane root;


    public void initialize(){

        initwindow();
    }

    private void initwindow() {

        MaterialUI.paintComboBox(cmbCourse,cmbPaymentMethod);
        MaterialUI.paintTextFields(txtBatchNo,txtNextPayment,txtDescription,txtRecieptAmount,txtRecievedAmount,txtNextPaymentDate,txtSearchStudent,txtStudentEmail,txtStudentName);
        MaterialUI.addCheckBox(txtBatchNo,txtNextPayment,txtDescription,txtRecieptAmount,txtRecievedAmount,txtNextPaymentDate,txtSearchStudent,txtStudentEmail,txtStudentName);
        MaterialUI.drawBorder(pneBody);
        lblDate.setText(DateAndTime.DateToday());

        lblId.setText(PaymentService.getPaymentId());
        txtSearchStudent.textProperty().addListener((observable, oldValue, newValue) -> { findStudent(newValue); });
    }

    private void findStudent(String StudentNic) {

        Student student = StudentService.findStudent(StudentNic);
        Course course = CourseService.findCourse(student.getCourseId());

        txtStudentName.setText(student.getName());
        cmbCourse.setValue(course.getName());
        txtStudentEmail.setText(student.getEmail());
        if(!student.getBatchNo().equals(null)){
            txtBatchNo.setText(student.getBatchNo());
        }

    }


    public void btnClearAll_OnAction(ActionEvent actionEvent) {
        txtSearchStudent.clear();
        txtStudentName.clear();
        cmbCourse.getSelectionModel().clearSelection();
        txtStudentEmail.clear();;
        cmbPaymentMethod.getSelectionModel().clearSelection();
        txtBatchNo.clear();
        txtDescription.clear();
        txtNextPaymentDate.clear();
        txtRecieptAmount.clear();
        txtRecievedAmount.clear();
        txtStudentEmail.clear();
        chkPrintReciept.setSelected(false);
        chkSendEmail.setSelected(false);
    }

    public void btnSubmit_OnAction(ActionEvent actionEvent) {
        try{
            if(chkSendEmail.isSelected()){

            }
            if(chkPrintReciept.isSelected()){

            }
            Payment payment = new Payment(txtStudentName.getText(),"userNIC",lblId.getText(),txtDescription.getText(),txtRecievedAmount.getText(), LocalDate.parse(txtNextPaymentDate.getText()),cmbPaymentMethod.getSelectionModel().getSelectedItem(),txtRecieptAmount.getText());
            //TODO:Find and fill userNIC
            PaymentService.savePayment(payment);
            new Alert(Alert.AlertType.INFORMATION,"Payment has been saved successfully",ButtonType.OK).show();
        }catch (RuntimeException e){
            new Alert(Alert.AlertType.ERROR,"Failed to save payment").show();
        }

    }
}

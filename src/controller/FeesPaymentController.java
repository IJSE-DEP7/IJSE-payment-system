package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    public Button btnSubmit;
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
        Platform.runLater(()->{

            txtSearchStudent.textProperty().addListener((observable, oldValue, newValue) -> { findStudent(newValue); });
            if(root.getAccessibleText().equals("newPayment")){
                if(root.getUserData()!=null){
                    Student student = (Student) root.getUserData();
                    txtSearchStudent.setText(student.getNic());
                }else{
                    txtSearchStudent.setPromptText("Search Student By NIC");
                }
            }else if(root.getAccessibleText().equals("searchPayment")){

                txtSearchStudent.setPromptText("Search Payment By Id");
                btnClearAll.setText("Delete");
                btnSubmit.setText("Update");
                txtSearchStudent.textProperty().addListener((observable, oldValue, newValue) -> { findPayment(newValue); });
            }
        });

        MaterialUI.paintComboBox(cmbCourse,cmbPaymentMethod);
        MaterialUI.paintTextFields(txtBatchNo,txtNextPayment,txtDescription,txtRecieptAmount,txtRecievedAmount,txtNextPaymentDate,txtSearchStudent,txtStudentEmail,txtStudentName);
        MaterialUI.addCheckBox(txtBatchNo,txtNextPayment,txtDescription,txtRecieptAmount,txtRecievedAmount,txtNextPaymentDate,txtSearchStudent,txtStudentEmail,txtStudentName);
        MaterialUI.drawBorder(pneBody);
        lblDate.setText(DateAndTime.DateToday());
        lbltime.setText(DateAndTime.timeNow());

        //lblId.setText(PaymentService.getPaymentId());

    }

    private void findPayment(String paymentId) {
        Payment payment = PaymentService.findPayment(paymentId);
        if(payment!=null) {
            Student student = StudentService.findStudent(payment.getStudentNic());
            Course course = CourseService.findCourse(student.getCourseId());

            txtStudentName.setText(student.getName());
            cmbCourse.setValue(course.getName());
            txtStudentEmail.setText(student.getEmail());
            cmbPaymentMethod.setValue(payment.getMethod());
            if (student.getBatchNo() != null) {
                txtBatchNo.setText(student.getBatchNo());
            }
            txtDescription.setText(payment.getPayment());
            txtNextPaymentDate.setText(payment.getDate().toString());
            txtRecieptAmount.setText(payment.getRecieptAmount());
            txtRecievedAmount.setText(payment.getAmount());
            //txtNextPayment.setText();
        }
    }

    private void findStudent(String StudentNic) {

        Student student = StudentService.findStudent(StudentNic);
        if(student !=null) {
            Course course = CourseService.findCourse(student.getCourseId());

            txtStudentName.setText(student.getName());
            cmbCourse.setValue(course.getName());
            txtStudentEmail.setText(student.getEmail());
            if (student.getBatchNo()!=null) {
                txtBatchNo.setText(student.getBatchNo());
            }
        }

    }


    public void btnClearAll_OnAction(ActionEvent actionEvent) {
        if(btnClearAll.getText().equals("Clear All")){
            txtSearchStudent.clear();
            txtStudentName.clear();
            cmbCourse.getSelectionModel().clearSelection();
            txtStudentEmail.clear();
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
        else{
            Payment payment = PaymentService.findPayment(txtSearchStudent.getText());
            if(payment!=null){
                PaymentService.deletePayment(payment);
                txtSearchStudent.clear();
            }
        }

    }

    public void btnSubmit_OnAction(ActionEvent actionEvent) {
        try{
            if(chkSendEmail.isSelected()){
                sendEmail();
            }
            if(chkPrintReciept.isSelected()) {
                printReciept();
            }
            Payment payment = new Payment(txtSearchStudent.getText(),"userNIC","P-0001",txtDescription.getText(),txtRecievedAmount.getText(), LocalDate.parse(txtNextPaymentDate.getText()),cmbPaymentMethod.getSelectionModel().getSelectedItem(),txtRecieptAmount.getText());
            //TODO:Find and fill userNIC
            PaymentService.savePayment(payment);
            System.out.println(payment);
            System.out.println(payment.getPaymentId());
            new Alert(Alert.AlertType.INFORMATION,"Payment has been saved successfully",ButtonType.OK).show();
        }catch (RuntimeException e){
            new Alert(Alert.AlertType.ERROR,"Failed to save payment").show();
        }
    }

    private void printReciept() {
        System.out.println("reciept");
    }

    private void sendEmail() {
    }

}

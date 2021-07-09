package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.Expense;
import model.ExpenseTM;
import service.ExpenseService;
import util.DateAndTime;
import util.MaterialUI;

import java.time.LocalDate;

public class AddNewExpenseController {
    public AnchorPane pneBody;
    public Label lblDate;
    public Label lbltime;
    public Button btnEnter;
    public Button btnBack;
    public TextField txtExpense;
    public TextField txtAmount;
    public ComboBox<String> cmbMethod;
    public TextField txtPassword;
    public AnchorPane root;

    public void initialize(){
        initwindow();
    }

    private void initwindow() {

        MaterialUI.drawBorder(pneBody);
        MaterialUI.paintTextFields(txtExpense,txtAmount,txtPassword);
        MaterialUI.paintComboBox(cmbMethod);
        MaterialUI.addCheckBox(txtExpense,txtAmount,txtPassword);
        lblDate.setText(DateAndTime.DateToday());
        DateAndTime.timeNow(lbltime);
        Platform.runLater(() -> {
        if(root.getUserData()!=null) {
            ExpenseTM tm = (ExpenseTM) root.getUserData();
            txtExpense.setText(tm.getExpense());
            txtAmount.setText(tm.getAmount());
            cmbMethod.setValue(tm.getTransactionMethod());
            btnEnter.setText("Update");
            }
        });

    }

    public void btnBack_OnAction(ActionEvent actionEvent) {
        MainFormController ctrl = (MainFormController) pneBody.getScene().getUserData();
        ctrl.navigate("/view/ManageExpenses.fxml","Manage Expenses");
    }

    public void btnEnter_OnAction(ActionEvent actionEvent) {
        try{
            if(btnEnter.getText().equals("Update")){
                new Alert(Alert.AlertType.INFORMATION, "Expense updated successfully", ButtonType.OK).show();
            }else {
                ExpenseService.saveExpense(new Expense("id", "nic", txtExpense.getText(), txtAmount.getText(), cmbMethod.getSelectionModel().getSelectedItem(), LocalDate.now()));
                new Alert(Alert.AlertType.INFORMATION, "Expense saved successfully", ButtonType.OK).show();
            }
        }catch (RuntimeException e){
            new Alert(Alert.AlertType.ERROR,"Failed to save",ButtonType.OK).show();
        }
    }
}

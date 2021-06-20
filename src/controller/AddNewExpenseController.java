package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.MaterialUI;

public class AddNewExpenseController {
    public AnchorPane pneBody;
    public Label lblDate;
    public Label lbltime;
    public Button btnEnter;
    public Button btnBack;
    public TextField txtExpense;
    public TextField txtAmount;
    public ComboBox cmbMethod;
    public TextField txtPassword;

    public void initialize(){
        initwindow();
    }

    private void initwindow() {
        MaterialUI.drawBorder(pneBody);
        MaterialUI.paintTextFields(txtExpense,txtAmount,txtPassword);
        MaterialUI.paintComboBox(cmbMethod);
        MaterialUI.addCheckBox(txtExpense,txtAmount,txtPassword);
    }

    public void btnBack_OnAction(ActionEvent actionEvent) {
        MainFormController ctrl = (MainFormController) pneBody.getScene().getUserData();
        ctrl.nav("/view/ManageExpenses.fxml","Manage Expenses");
    }

    public void btnEnter_OnAction(ActionEvent actionEvent) {
    }
}
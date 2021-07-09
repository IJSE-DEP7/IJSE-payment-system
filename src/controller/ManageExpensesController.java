package controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import model.Expense;
import model.ExpenseTM;
import service.ExpenseService;
import util.DateAndTime;
import util.MaterialUI;

import java.util.Optional;

public class ManageExpensesController {
    public AnchorPane pneBody;
    public Label lblDate;
    public Label lbltime;
    public TableView<ExpenseTM> tblManageExpenses;

    public void initialize(){
        initwindow();
    }

    private void initwindow() {
        MaterialUI.drawBorder(pneBody);
        lblDate.setText(DateAndTime.DateToday());
        DateAndTime.timeNow(lbltime);

        tblManageExpenses.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("expense"));
        tblManageExpenses.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("amount"));
        tblManageExpenses.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblManageExpenses.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("transactionMethod"));
        tblManageExpenses.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<ExpenseTM, HBox> lastcol = (TableColumn<ExpenseTM, HBox>) tblManageExpenses.getColumns().get(5);

        lastcol.setCellValueFactory(param -> {
            Button btnEdit = new Button();
            Button btnTrash = new Button();

            btnEdit.getStyleClass().add("edit-button");
            btnTrash.getStyleClass().add("trash-button");

            btnEdit.setOnMouseClicked(event -> updateExpense(param.getValue()));
            btnTrash.setOnMouseClicked(event -> deleteExpense(param.getValue()));

            return new ReadOnlyObjectWrapper<>(new HBox(10, btnEdit, btnTrash));
        });
        loadAllExpenses();
    }

    private void updateExpense(ExpenseTM tm) {
        try {
            MainFormController ctrl = (MainFormController) pneBody.getScene().getUserData();
            ctrl.navigate("/view/AddNewExpense.fxml","Manage Expense",tm);
            System.out.println("working"+tm);
        } catch (RuntimeException e) {
            new Alert(Alert.AlertType.ERROR,"Failed to update the expense").show();
        }
    }

    private void deleteExpense(ExpenseTM tm) {
        Optional<ButtonType> buttonType= new Alert(Alert.AlertType.CONFIRMATION,"Are you sure to delete this expense?",ButtonType.NO,ButtonType.YES).showAndWait();
        try{
            if(buttonType.get()== ButtonType.YES){
                ExpenseService.deleteExpense(tm.getId());
                tblManageExpenses.getItems().remove(tm);
            }
        }catch (RuntimeException e){
            new Alert(Alert.AlertType.NONE,"Failed to delete expense",ButtonType.OK).show();
        }
    }

    private void loadAllExpenses() {
        tblManageExpenses.getItems().clear();
        for(Expense expense : ExpenseService.findAllExpenses()){
            //TODO:find userName and add it into the table
            tblManageExpenses.getItems().add(new ExpenseTM(expense.getId(),expense.getExpense(),expense.getAmount(),expense.getDate().toString(),expense.getMethod(),"userName"));
        }
    }

    public void btnAddNewExpense_OnAction(ActionEvent actionEvent) {
        MainFormController ctrl = (MainFormController) pneBody.getScene().getUserData();
        ctrl.navigate("/view/AddNewExpense.fxml","Manage Expenses");
    }
}

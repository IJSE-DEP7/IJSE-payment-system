package controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import model.ExpenseTM;
import util.DateAndTime;
import util.MaterialUI;

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

            return new ReadOnlyObjectWrapper<>(new HBox(10, btnEdit, btnTrash));
        });
        tblManageExpenses.getItems().add(new ExpenseTM());
    }

    public void btnAddNewExpense_OnAction(ActionEvent actionEvent) {
        MainFormController ctrl = (MainFormController) pneBody.getScene().getUserData();
        ctrl.navigate("/view/AddNewExpense.fxml","Manage Expenses");
    }
}

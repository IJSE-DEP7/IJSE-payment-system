package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.MaterialUI;

public class TransactionDetailsController {
    public AnchorPane pneBody;

    public Label lblIncomeCash;
    public Label lblDate;
    public Label lbltime;
    public Label lblIncomeCard;
    public Label lblIncomeOnline;
    public TableView tblDashBoard;
    public TextField txtstartDate;
    public TextField txtLastDay;
    public Button btnSearch;

    public void initialize(){
        MaterialUI.paintTextFields(txtstartDate,txtLastDay);
        MaterialUI.drawBorder(pneBody);
        MaterialUI.addCheckBox(txtstartDate,txtLastDay);
    }
    public void btnSearch_OnAction(ActionEvent actionEvent) {
    }
}

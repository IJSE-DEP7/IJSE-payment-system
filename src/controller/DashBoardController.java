package controller;

import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.DashBoardTM;
import util.MaterialUI;

public class DashBoardController {

    public AnchorPane pneBody;
    public Label lblIncomeCash;
    public Label lblDate;
    public Label lblIncomeCard;
    public Label lblIncomeOnline;
    public TableView tblDashBoard;


    public void initialize(){

        MaterialUI.drawBorder(pneBody);
        tblDashBoard.getItems().add(new DashBoardTM());
        tblDashBoard.getItems().add(new DashBoardTM());
        tblDashBoard.getItems().add(new DashBoardTM());
        tblDashBoard.getItems().add(new DashBoardTM());
    }
}

package controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import model.UserTM;
import util.DateAndTime;
import util.MaterialUI;

public class ManageUsersController {
    public AnchorPane pneBody;
    public Label lblDate;
    public Label lbltime;
    public TableView<UserTM> tblManageUsers;

    public void initialize(){
        initwindow();
    }

    private void initwindow() {
        MaterialUI.drawBorder(pneBody);
        lblDate.setText(DateAndTime.DateToday());

        tblManageUsers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblManageUsers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblManageUsers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblManageUsers.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tblManageUsers.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("admin"));
        TableColumn<UserTM, HBox> lastcol = (TableColumn<UserTM, HBox>) tblManageUsers.getColumns().get(5);

        lastcol.setCellValueFactory(param -> {
            Button btnEdit = new Button();
            Button btnTrash = new Button();

            btnEdit.getStyleClass().add("edit-button");
            btnTrash.getStyleClass().add("trash-button");

            return new ReadOnlyObjectWrapper<>(new HBox(5, btnEdit, btnTrash));
        });
        tblManageUsers.getItems().add(new UserTM());
    }
}

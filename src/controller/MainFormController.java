package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class MainFormController {
    public Label lblTitle;
    public AnchorPane pneSideBar;
    public Button btnDashBoard;
    public Button btnCourseRegister;
    public Button btnFeesPayment;
    public Button btnTransactionDetails;
    public Button btnSearchStudents;
    public Button btnManageStudents;
    public Button btnManageUsers;
    public Button btnManageExpenses;
    public Button btnExit;
    public ImageView lblMenu;
    public ImageView lblMinimize;
    public ImageView lblClose;
    public Text txtUserNameLetter;
    public AnchorPane pneStage;




    public void initialize(){

    }
    public void nav(String url){
        try{
            Parent root = FXMLLoader.load(this.getClass().getResource(url));
            pneStage.getChildren().clear();
            pneStage.getChildren().add(root);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(pneStage);
    }

    /*
            Methods of sidebar
         */
    public void btnDashBoard_OnAction(ActionEvent actionEvent) {
        navigate("/view/DashBoard.fxml","Dash Board");
    }

    public void btnCourseRegister_OnAction(ActionEvent actionEvent) {
        navigate("/view/CourseRegistration.fxml","Course Registration");
    }

    public void btnFeesPayment_OnAction(ActionEvent actionEvent) {
        navigate("/view/FeesPayment.fxml","Fees Payment");
    }

    public void btnTransactionDetails_OnAction(ActionEvent actionEvent) {
        navigate("/view/TransactionDetails.fxml","Transaction Details");
    }

    public void btnSearchStudents_OnAction(ActionEvent actionEvent) {
        navigate("/view/SearchStudents.fxml","Student Details");
    }

    public void btnManageStudents_OnAction(ActionEvent actionEvent) {
        navigate("/view/ManageStudents.fxml","Manage Students");
    }

    public void btnManageUsers_OnAction(ActionEvent actionEvent) {
        navigate("/view/ManageUsers.fxml","Manage Users");
    }

    public void btnManageExpenses_OnAction(ActionEvent actionEvent) {
        navigate("/view/ManageExpenses.fxml","Manage Expenses");
    }

    public void btnExit_OnAction(ActionEvent actionEvent) {
    }

    public void lblMenu_OnMouseClicked(MouseEvent mouseEvent) {
    }

    public void lblMinimize_OnMouseClicked(MouseEvent mouseEvent) {
    }

    public void lblClose_OnMouseClicked(MouseEvent mouseEvent) {
    }

    public void txtUserNameLetter_OnMouseClicked(MouseEvent mouseEvent) {
    }

    private void navigate(String url, String title){
        nav(url);
    }
}

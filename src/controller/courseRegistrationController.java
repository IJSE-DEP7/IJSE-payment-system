package controller;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.DateAndTime;
import util.MaterialUI;

public class courseRegistrationController {
    public AnchorPane pneSideBar;
    public AnchorPane pneBody;
    public ComboBox cmbCourse;
    public ComboBox cmbQualification;
    public TextField txtName;
    public TextField txtPlacementExamMarks;
    public TextField txtAddress;
    public TextField txtCommencementDate;
    public TextField txtDateOfBirth;
    public TextField txtEmail;
    public TextField txtPhoto;

    public void initialize(){
        MaterialUI.paintTextFields(txtName,txtPlacementExamMarks,txtAddress,txtCommencementDate,txtDateOfBirth,txtEmail,txtPhoto);

        MaterialUI.drawBorder(pneBody);
        MaterialUI.drawBorder(pneSideBar);
    }
}

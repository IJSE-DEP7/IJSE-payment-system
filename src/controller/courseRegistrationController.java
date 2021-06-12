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
    public TextField lblName;

    public void initialize(){
        MaterialUI.paintTextFields(lblName);

        MaterialUI.drawBorder(pneBody);
        MaterialUI.drawBorder(pneSideBar);
    }
}

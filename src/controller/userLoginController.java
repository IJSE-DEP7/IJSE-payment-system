package controller;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class userLoginController {
    public TextField txtUserName;
    public TextField txtPassword;

    public void initialize(){

    }

    public void paintTextFields(TextField... textFields){

        for(TextField txt : textFields) {
            AnchorPane pneTextContainer = (AnchorPane) txt.getParent();
            String floatedText = txt.getAccessibleText();
            Canvas canvas = new Canvas(pneTextContainer.getPrefWidth(), pneTextContainer.getPrefHeight());
            pneTextContainer.getChildren().add(0, canvas);
            GraphicsContext ctx = canvas.getGraphicsContext2D();

            redrawTextFieldCanvas(canvas, ctx, floatedText, false);

            txt.focusedProperty().addListener((observable, oldValue, newValue) -> {
                redrawTextFieldCanvas(canvas, ctx, floatedText, newValue);
            });
            pneTextContainer.setOnMouseClicked(event -> {
                txt.requestFocus();
            });
        }

    }

    private void redrawTextFieldCanvas(Canvas canvas,GraphicsContext ctx,String floatedText,boolean focus){
        ctx.clearRect(65,6,canvas.getWidth(), canvas.getHeight());
        ctx.setStroke(focus? Color.BLACK : Color.rgb(0,0,0,0.6));
        ctx.setLineWidth(2);
        ctx.strokeRoundRect(67,8,canvas.getWidth()-134,canvas.getHeight()-10,10,10 );
        ctx.setFill(Color.WHITE);
        ctx.fillRect(77,2,new Text(floatedText).getLayoutBounds().getWidth()+10,25);
        ctx.setFill(focus? Color.BLACK : Color.rgb(0,0,0,0.6));
        ctx.fillText(floatedText,82,11);
    }
}

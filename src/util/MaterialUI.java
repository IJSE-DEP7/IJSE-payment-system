package util;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MaterialUI {

    public static void paintTextFields(TextField... textFields){

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

    private static void redrawTextFieldCanvas(Canvas canvas,GraphicsContext ctx,String floatedText,boolean focus){
        ctx.clearRect(2,2,canvas.getWidth(), canvas.getHeight());
        ctx.setStroke(focus? Color.BLACK : Color.rgb(0,0,0,0.6));
        ctx.setLineWidth(2);
        ctx.strokeRoundRect(2,5,canvas.getWidth()-6,canvas.getHeight()-6,10,10 );
        ctx.setFill(Color.WHITE);
        ctx.fillRect(8,0,new Text(floatedText).getLayoutBounds().getWidth()+10,25);
        ctx.setFill(focus? Color.BLACK : Color.rgb(0,0,0,0.6));
        ctx.fillText(floatedText,13,10);
    }

    public static void drawBorder(AnchorPane pne) {
        Canvas canvas = new Canvas(pne.getPrefWidth(), pne.getPrefHeight());
        pne.getChildren().add(0, canvas);
        GraphicsContext ctx = canvas.getGraphicsContext2D();
        ctx.setFill(Color.BLACK);
        ctx.setLineWidth(2);
        ctx.strokeRect(1,3,pne.getPrefWidth()-2, pne.getPrefHeight()-4);
    }
}

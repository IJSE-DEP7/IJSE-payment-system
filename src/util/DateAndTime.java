package util;

import javafx.concurrent.Task;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateAndTime {

    public static String DateToday(){
        LocalDate today = LocalDate.now();
        String DateToday = today.format(DateTimeFormatter.ofPattern("E,dd-MMM-yyyy"));
        return DateToday;
    }

    public static void timeNow(Label lbl){
        Task task = new Task(){
            protected Object call()throws Exception{
                while (true) {
                    String time = String.format("%tT", new Date());
                    try {
                        Thread.sleep(900);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    updateMessage(time);
                }
            }
        };
        new Thread(task).start();
        lbl.textProperty().bind(task.messageProperty());
    }

}

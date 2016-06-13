/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20h.controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author take5
 */
public class InputPageController implements Initializable{
    
    public static final String PATH = "test.txt";
    
    @FXML private TextField hour;
    @FXML private TextField minute;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void handleWriteFileButtonAction(ActionEvent event) throws IOException {
        int hour = Integer.parseInt(this.hour.getText());
        int minute = Integer.parseInt(this.minute.getText());
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(hour, minute, 0));
        String line = localDateTime.toString() + System.getProperty("line.separator");
        Files.write(Paths.get(PATH), line.getBytes(), StandardOpenOption.APPEND);        
    }
    
}

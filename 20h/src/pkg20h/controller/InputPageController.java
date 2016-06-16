/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20h.controller;

import bean.TimeAndCategoryBean;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyStore;
import java.text.AttributedCharacterIterator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.stream.Stream;
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
    @FXML private TextField category;
    @FXML private TextField categoryEntryField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void handleWriteFileButtonAction(ActionEvent event) throws IOException {
        int hour = Integer.parseInt(this.hour.getText());
        int minute = Integer.parseInt(this.minute.getText());
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(hour, minute, 0));
        String category = this.category.getText();
        TimeAndCategoryBean bean = new TimeAndCategoryBean(localDateTime, category);
        Files.write(Paths.get(PATH), bean.toCSV().getBytes(), StandardOpenOption.APPEND);
    }
    
    @FXML
    private void handleCategoryEntryButton(ActionEvent event) throws IOException {

        Stream<String> stream = Files.lines(Paths.get("category.txt"));
        boolean strExists = stream.anyMatch(str -> str.contains(categoryEntryField.getText()));
        if(strExists){
            return;
        }
        
        boolean fileExists = Files.exists(Paths.get("category.txt"), LinkOption.NOFOLLOW_LINKS);
        String category = categoryEntryField.getText() + System.getProperty("line.separator");
        if(!fileExists) {
            Files.createFile(Paths.get("category.txt"));
        }
        Files.write(Paths.get("category.txt"), category.getBytes(), StandardOpenOption.APPEND);
    };
    
}

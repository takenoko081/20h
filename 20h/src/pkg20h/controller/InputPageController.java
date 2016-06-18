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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
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
    @FXML private ChoiceBox<String> categoryChoiceBox;
    private List<String> listsCategory;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            listsCategory = Files.lines(Paths.get("category.txt")).collect(Collectors.toList());
        } catch (IOException ex) {
            Logger.getLogger(InputPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ObservableList<String> lists = FXCollections.observableList(listsCategory);
        categoryChoiceBox.setItems(lists);        
    }
    
    /**
     * 勉強時間登録アクション
     * @param event
     * @throws IOException 
     */
    @FXML
    private void handleWriteFileButtonAction(ActionEvent event) throws IOException {
        int hour = Integer.parseInt(this.hour.getText());
        int minute = Integer.parseInt(this.minute.getText());
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(hour, minute, 0));
        String category = this.category.getText();
        TimeAndCategoryBean bean = new TimeAndCategoryBean(localDateTime, category);
        Files.write(Paths.get(PATH), bean.toCSV().getBytes(), StandardOpenOption.APPEND);
    }
    
    /**
     * カテゴリ登録アクション
     * @param event
     * @throws IOException 
     */
    @FXML
    private void handleCategoryEntryButton(ActionEvent event) throws IOException {

        Stream<String> stream = Files.lines(Paths.get("category.txt"));
        boolean strExists = stream.anyMatch(str -> str.contains(categoryEntryField.getText()));
        if(strExists){
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Show");
            alert.getDialogPane().setHeaderText("カテゴリ重複");
            alert.getDialogPane().setContentText("すでに登録されているカテゴリです。");
            alert.show();
            
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20h.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author take5
 */
public class InputPageController implements Initializable{
    
    @FXML
    private Button inputButton;
    @FXML
    private TextField hour;
    @FXML
    private TextField minute;
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    private void handleWriteFileButtonAction(ActionEvent event) throws IOException {
        System.out.println("Hello World");
    }
    
}

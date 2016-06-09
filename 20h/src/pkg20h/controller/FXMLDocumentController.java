/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20h.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author take5
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label.setText("Hello World!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }    
    
}

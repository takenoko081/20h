/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20h.controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author take5
 */
public class TopPageController implements Initializable {
    
    @FXML
    private void handleInputPageButtonAction(ActionEvent event) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader(Paths.get("src/pkg20h/view/InputPage.fxml").toUri().toURL());
        Parent parent = fXMLLoader.load();
        Scene s = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(s);
        stage.show();
    }

    @FXML
    private void handleDisplayPageButtonAction(ActionEvent event) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader(Paths.get("src/pkg20h/view/DataViewPage.fxml").toUri().toURL());
        Parent parent = fXMLLoader.load();
        Scene s = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(s);
        stage.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

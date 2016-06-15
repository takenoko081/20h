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
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author take5
 */
public class DataViewPageController implements Initializable {

    @FXML
    private BarChart<String, Integer> studyBarChart;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void handleDisplayButtonAction(ActionEvent event) throws IOException{
        
        XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
        series.setName("H");
        
        Stream<String> stream = Files.lines(Paths.get("test.txt")).filter(str -> !(str.length() == 1));
        List<TimeAndCategoryBean> lists = stream.map(TimeAndCategoryBean::parse).collect(Collectors.toList());
        lists.forEach(list -> series.getData().add(new XYChart.Data<String, Integer>(String.valueOf(list.getLocalDateTime().getDayOfMonth()), list.getLocalDateTime().getMinute())));
        
        studyBarChart.getData().add(series);
        
    }
    
    
}

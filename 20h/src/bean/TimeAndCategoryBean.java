/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.time.LocalDateTime;

/**
 *
 * @author take5
 */
public class TimeAndCategoryBean {
    private LocalDateTime localDateTime;
    private String category;

    public TimeAndCategoryBean(LocalDateTime localDateTime, String category) {
        this.localDateTime = localDateTime;
        this.category = category;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getCategory() {
        return category;
    }

    public String toCSV(){
        return localDateTime.toString() +","+ category + System.getProperty("line.separator");
    }
    
    @Override
    public String toString() {
        return localDateTime.toString() +":"+ category;
    }
    
}

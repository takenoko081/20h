/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

/**
 *
 * @author take5
 */
public class WriteDate {
    
    public static final String PATH = "test.txt";
    
    public WriteDate(){
        
    }
    
    public static void write(LocalDateTime dateAndTime) throws IOException{
        Files.write(Paths.get(PATH), "aaa".getBytes(), StandardOpenOption.CREATE);
    }
}

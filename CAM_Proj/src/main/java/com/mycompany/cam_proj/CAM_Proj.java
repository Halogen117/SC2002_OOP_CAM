/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.cam_proj;

/**
 *
 * @author Halogen
 */
import java.io.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Cell;  
public class CAM_Proj {

    public static void main(String[] args) {
        // Retrieve xlsx  file
        // Function to take in xlsx file and return the list array
        //
        String file_location = "C:\\Users\\Halogen\\Desktop\\Year 2\\Semester 1\\SC2006 - Software Engineering\\CAM_Proj\\src\\main\\resources\\student list.xlsx";
        read_excel re_ex = new read_excel();
        Student[] student_list = (Student[]) re_ex.return_list("Student", file_location);
        file_location = "C:\\Users\\Halogen\\Desktop\\Year 2\\Semester 1\\SC2006 - Software Engineering\\CAM_Proj\\src\\main\\resources\\staff_list.xlsx";
        Staff[] teacher_list = (Staff[]) re_ex.return_list("Staff", file_location);
        
        

            
    }
    
}

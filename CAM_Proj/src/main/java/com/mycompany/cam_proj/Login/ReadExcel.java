/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.Login;

import com.mycompany.cam_proj.Staff;
import com.mycompany.cam_proj.Student;
import com.mycompany.cam_proj.User;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Halogen
 */
public class ReadExcel {
    public ArrayList<User> return_list(String initalizer, String filepath){
        ArrayList<User> user_list = new ArrayList();
        try
        {
            FileInputStream file = new FileInputStream(filepath);
            
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(file);
            //Get first/desired sheet from the workbook
            XSSFSheet ws = wb.getSheetAt(0);
            
            /*
            if(initalizer == "Student"){
                user_list = new Student[ws.getPhysicalNumberOfRows()-1];
            }else if(initalizer == "Staff"){
                user_list = new Staff[ws.getPhysicalNumberOfRows()-1];
            }
            */
            
            int iterator=0;
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = ws.iterator();
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                int inner_int = 0;
                String userID_exc = "";
                String email_exc = "";
                String facul_exc = "";
                while (cellIterator.hasNext()) 
                {

                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.println(cell.getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            if(iterator != 0){
                                if(inner_int == 0){
                                    userID_exc = cell.getStringCellValue();
                                }else if(inner_int == 1){
                                    email_exc = cell.getStringCellValue();
                                }else if(inner_int == 2){
                                    facul_exc = cell.getStringCellValue();
                                }
                            }
                            break;
                    }
                    inner_int += 1;
                }
                if(iterator != 0){
                    if(initalizer == "Student"){ 
                        user_list.add(new Student(userID_exc.trim(), email_exc.trim(), facul_exc.trim()));
                        //user_list[iterator-1] = new Student(userID_exc.trim(), email_exc.trim(), facul_exc.trim());
                    }else if(initalizer == "Staff"){ 
                        user_list.add(new Staff(userID_exc.trim(), email_exc.trim(), facul_exc.trim()));
                        //user_list[iterator-1] = new Staff(userID_exc.trim(), email_exc.trim(), facul_exc.trim());
                    }
                    
                }
                iterator +=1;
            }
            file.close();
            return user_list;
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        return user_list;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj;

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
public class read_excel {
    public User [] return_list(String initalizer, String filepath){
        User[] user_list = null;
        try
        {
            FileInputStream file = new FileInputStream(filepath);
            
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(file);
            //Get first/desired sheet from the workbook
            XSSFSheet ws = wb.getSheetAt(0);
            if(initalizer == "Student"){
                user_list = new Student[ws.getPhysicalNumberOfRows()-1];
            }else if(initalizer == "Staff"){
                System.out.println("Staff");
                user_list = new Staff[ws.getPhysicalNumberOfRows()-1];
            }
            
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
                System.out.println("Reading Row Completed.");
                if(iterator != 0){
                    if(initalizer == "Student"){
                        user_list[iterator-1] = new Student(userID_exc, email_exc, facul_exc);
                    }else if(initalizer == "Staff"){
                        user_list[iterator-1] = new Staff(userID_exc, email_exc, facul_exc);
                    }
                }
                iterator +=1;
            }
            file.close();
            
            for(int i=0; i< ws.getPhysicalNumberOfRows()-1; i++){
                System.out.println(i);
                System.out.println(user_list[i].userID);
            }
            return user_list;
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        return user_list;
    }
}

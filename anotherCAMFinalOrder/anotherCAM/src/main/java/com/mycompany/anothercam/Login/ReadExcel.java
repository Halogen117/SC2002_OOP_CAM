
package com.mycompany.anothercam.Login;
import com.mycompany.anothercam.StudentList;
import com.mycompany.anothercam.StaffList;
import com.mycompany.anothercam.Staff;
import com.mycompany.anothercam.Student;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
Represents the Read Excel Object and the following methods that assist in the venture.
A Read Excel Object can only be declared once
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-3
*/
public class ReadExcel {
    /**
    * Sets the ArrayList of the Staff and the Student when acquired from the respective excel sheets.
    * @param initalizer This variable is either a Student or Staff list.
    * @param filePath The variable contains the file path where the excel file is read at.
    */
    public void return_list(String initalizer, String filePath){
        ArrayList<User> userList = new ArrayList();
        StaffList staffListInt = new StaffList();
        StudentList studentListInt = new StudentList();
        try
        {
            FileInputStream file = new FileInputStream(filePath);
            
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
                String userName_exc = "";
                String userID_exc = "";
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
                                    userName_exc = cell.getStringCellValue();
                                }else if(inner_int == 1){
                                    userID_exc = cell.getStringCellValue();
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
                        studentListInt.addStudentToList(new Student(userID_exc.split("@")[0].trim(),userName_exc , userID_exc.trim(), facul_exc.trim()));
                        //user_list[iterator-1] = new Student(userID_exc.trim(), email_exc.trim(), facul_exc.trim());
                    }else if(initalizer == "Staff"){ 
                        staffListInt.addStaffToList(new Staff(userID_exc.trim().split("@")[0].trim(), userName_exc, userID_exc.trim(), facul_exc.trim()));
                        //user_list[iterator-1] = new Staff(userID_exc.trim(), email_exc.trim(), facul_exc.trim());
                    }
                    
                }
                iterator +=1;
            }
            if(initalizer == "Student"){ 
            studentListInt.getFacultyStudentList();
            }else if(initalizer == "Staff"){ 
            staffListInt.getFacultyStaffList();
            }
            file.close();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }
    

    

}

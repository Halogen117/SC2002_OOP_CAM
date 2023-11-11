/**
Represents the ReportCSVDAO Object and the following assistance methods.
A ReportCSVDAO object can be called multiple times
The class here creates the report format for CSV based on the information given from the camp Array. 
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-2
*/

package com.mycompany.anothercam.ReportGenerator;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import com.mycompany.anothercam.Camp;
import com.opencsv.CSVWriter;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.io.FileOutputStream;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeMap;

public class ReportCSVDAO {
    //private XSSFWorkbook workbook;
    //private XSSFSheet spreadsheet;
    private String filename;
    private String sheetName;
    private CSVWriter csvFile;
    private ArrayList<Camp> tempCampArray;
    //private FileOutputStream streamOut;
    /*
    public ReportCSVDAO(FileOutputStream streamOut,String filename, String sheetName){
        this.filename = filename;
        this.sheetName = sheetName;
        this.streamOut = streamOut;
        
    }
    */
    
    /**
    * The ReportCSVDAO Constructor.
    * @param tempCampArray The ArrayList containing the camp Array to be printed out
    * @param filename The filename to specify the creation of the report.
    */
    public ReportCSVDAO(ArrayList<Camp> tempCampArray, String filename){
        this.filename = filename;
        this.tempCampArray = tempCampArray;
    }
    
    /**
    * Writes the CSV information into the Staff Report.
    * @return boolean value if the file writing is successful. True for success. False for unsuccessful.
    */
    public boolean writeStaffReportInfo(){
        try{
            this.csvFile = new CSVWriter(new FileWriter(new File(this.filename)));
            String[] columnName = {"CAMP Number", "Name", "Date", "Registration Closing Date", "Total slots", "Committee Member Slots", "Staff-in-charge", "Committee Members", "Attendees"};
            this.csvFile.writeNext(columnName);
            for(int i=1; i< tempCampArray.size()+1; i++){
                String slotString = String.valueOf(tempCampArray.get(i-1).getTotalSlot());
                String committeeString = String.valueOf(tempCampArray.get(i-1).getCampCommitteeSlots());
                String firstCommittee;
                // Print the first row of new Camp
                if(tempCampArray.get(i-1).getCampCommitteeList().size() <=0){
                    firstCommittee = "NIL";
                }else{
                    firstCommittee = tempCampArray.get(i-1).getCampCommitteeList().get(0).getUserID();
                }
                String[] firstCol = {String.valueOf(i) ,tempCampArray.get(i-1).getCampName(), tempCampArray.get(i-1).getDateString(),tempCampArray.get(i-1).getRegClosingDateString(),slotString ,committeeString,tempCampArray.get(i-1).getStaffInCharge(), firstCommittee, ""};
                this.csvFile.writeNext(firstCol);
                // Print other camp committee members
                for(int j=1; j< tempCampArray.get(i-1).getCampCommitteeList().size(); j++){
                    String[] secondData = {"", "", "", "", "", "", "", tempCampArray.get(i-1).getCampCommitteeList().get(j).getUserID(), ""};
                    this.csvFile.writeNext(secondData);
                }
                for(int k=0; k< tempCampArray.get(i-1).getCampStudentList().size(); k++){
                    String[] teriaryData = {"", "", "", "", "", "", "", "", tempCampArray.get(i-1).getCampStudentList().get(k).getUserID()};
                    this.csvFile.writeNext(teriaryData);
                }
            String[] blankCol = {"", "", "", "", "", "", "", "",""};
            this.csvFile.writeNext(blankCol);
            }
            this.csvFile.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return true;
    }
    
    /**
    * Writes the CSV information into the Staff Performance Report.
    * @return boolean value if the file writing is successful. True for success. False for unsuccessful.
    */
    public boolean writeStaffPerformanceInfo(){
        try{
            this.csvFile = new CSVWriter(new FileWriter(new File(this.filename)));
            String[] columnName = {"CAMP Number", "Name", "Date", "Committee Members", "Points"};
            this.csvFile.writeNext(columnName);
            for(int i=1; i< tempCampArray.size()+1; i++){
                String slotString = String.valueOf(tempCampArray.get(i-1).getTotalSlot());
                String committeeString = String.valueOf(tempCampArray.get(i-1).getCampCommitteeSlots());
                String firstCommittee;
                String firstCommitteePoints;
                // Print the first row of new Camp
                if(tempCampArray.get(i-1).getCampCommitteeList().size() <=0){
                    firstCommittee = "NIL";
                    firstCommitteePoints = "NIL";
                }else{
                    firstCommittee = tempCampArray.get(i-1).getCampCommitteeList().get(0).getUserID();
                    firstCommitteePoints = Integer.toString(tempCampArray.get(i-1).getCampCommitteeList().get(0).getPoints());
                }
                String[] firstCol = {String.valueOf(i) ,tempCampArray.get(i-1).getCampName(), tempCampArray.get(i-1).getDateString(),firstCommittee, firstCommitteePoints};
                this.csvFile.writeNext(firstCol);
                // Print other camp committee members
                for(int j=1; j< tempCampArray.get(i-1).getCampCommitteeList().size(); j++){
                    String[] secondData = {"", "", "", tempCampArray.get(i-1).getCampCommitteeList().get(j).getUserID(), Integer.toString(tempCampArray.get(i-1).getCampCommitteeList().get(j).getPoints())};
                    this.csvFile.writeNext(secondData);
                }
            String[] blankCol = {"", "", "", "", ""};
            this.csvFile.writeNext(blankCol);
            }
            this.csvFile.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return true;
    }
    
    /**
    * Writes the CSV information into the Camp Committee Report.
    * @return boolean value if the file writing is successful. True for success. False for unsuccessful.
    */
    public boolean writeCampCommitteeInfo(){
        try{
            this.csvFile = new CSVWriter(new FileWriter(new File(this.filename)));
            String[] columnName = {"CAMP Number", "Name", "Date", "Registration Closing Date", "Total slots", "Committee Member Slots", "Staff-in-charge", "Committee Members", "Attendees"};
            this.csvFile.writeNext(columnName);
            for(int i=1; i< tempCampArray.size()+1; i++){
                String slotString = String.valueOf(tempCampArray.get(i-1).getTotalSlot());
                String committeeString = String.valueOf(tempCampArray.get(i-1).getCampCommitteeSlots());
                String firstCommittee;
                // Print the first row of new Camp
                if(tempCampArray.get(i-1).getCampCommitteeList().size() <=0){
                    firstCommittee = "NIL";
                }else{
                    firstCommittee = tempCampArray.get(i-1).getCampCommitteeList().get(0).getUserID();
                }
                String[] firstCol = {String.valueOf(i) ,tempCampArray.get(i-1).getCampName(), tempCampArray.get(i-1).getDateString(),tempCampArray.get(i-1).getRegClosingDateString(),slotString ,committeeString,tempCampArray.get(i-1).getStaffInCharge(), firstCommittee, ""};
                this.csvFile.writeNext(firstCol);
                // Print other camp committee members
                for(int j=1; j< tempCampArray.get(i-1).getCampCommitteeList().size(); j++){
                    String[] secondData = {"", "", "", "", "", "", "", tempCampArray.get(i-1).getCampCommitteeList().get(j).getUserID(), ""};
                    this.csvFile.writeNext(secondData);
                }
                for(int k=0; k< tempCampArray.get(i-1).getCampStudentList().size(); k++){
                    String[] teriaryData = {"", "", "", "", "", "", "", "", tempCampArray.get(i-1).getCampStudentList().get(k).getUserID()};
                    this.csvFile.writeNext(teriaryData);
                }
            String[] blankCol = {"", "", "", "", "", "", "", "",""};
            this.csvFile.writeNext(blankCol);
            }
            this.csvFile.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return true;
    }
    /*

    public boolean writeInfo() throws IOException{
        this.workbook = new XSSFWorkbook(); 
        this.spreadsheet = this.workbook.createSheet(this.sheetName);
        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
        studentData.put("1", new Object[]{"CAMP Number", "Name", "Date", "Registration Closing Date", "Total slots", "Committee Members", "Staff-in-charge", "Committee Members", "Attendees"});
        XSSFRow row;
        Set<String> keyID = studentData.keySet();
        int rowID = 0;
        for(String key : keyID){
            row = this.spreadsheet.createRow(rowID++);
            Object[] objectArr = studentData.get(key);
            int cellID = 0;
            
            for(Object obj:objectArr){
                Cell cell = row.createCell(cellID++);
                cell.setCellValue((String)obj);
            }
            
        }
        this.workbook.write(this.streamOut); 
        this.streamOut.close(); 
        return true;
    }
    */
}

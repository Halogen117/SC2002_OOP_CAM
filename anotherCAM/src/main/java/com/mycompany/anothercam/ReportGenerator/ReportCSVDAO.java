/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.ReportGenerator;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import com.mycompany.anothercam.Camp;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.io.FileOutputStream;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeMap;

import com.opencsv.CSVWriter;
/**
 *
 * @author Halogen
 */
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
    public ReportCSVDAO(ArrayList<Camp> tempCampArray, String filename, String sheetName){
        this.filename = filename;
        this.sheetName = sheetName;
        this.tempCampArray = tempCampArray;
    }
    public boolean writeStaffReportInfo() throws IOException{
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
        
        return true;
    }
    
    public boolean writeStaffPerformanceInfo() throws IOException{
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
        
        return true;
    }
    
    public boolean writeCampCommitteeInfo() throws IOException{
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

/**
Represents the StaffReport Object and the following assistance methods.
A StaffReport can be run multiple times depending on the number of reports to be made.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-8
*/
package com.mycompany.anothercam.StaffApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.DateFormatter;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.ReportGenerator.ReportTXTDAO;
import com.mycompany.anothercam.ReportGenerator.ReportCSVDAO;
import com.mycompany.anothercam.User;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileWriter; //for txt
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffReport{
    /**
    * Runs the Staff Report Camp Application..
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return the boolean value whether the Staff Report of camp object was successful.
    */
    public boolean runStaffReportCamp(ArrayList<Camp> campArray, User cookie,Scanner scanObj){
        Verification verifier = new Verification();
        DateFormatter dateFor = new DateFormatter();
        // Find camp first
        ArrayList<Camp> tempCampArray = new ArrayList<Camp>();
        for(int i=0; i< campArray.size(); i++){
            if(campArray.get(i).getStaffInCharge().equals(cookie.getUserID())){
                tempCampArray.add(campArray.get(i));
            } 
        }
        if(tempCampArray.size() <=0){
            System.out.println("There are no camps to create staff reports for!");
            return false;
        }
       
        //ask for filters
        System.out.println("What filters would you like to apply to the report?");
        System.out.println("0. Quit filter selection");
        System.out.println("1. No Filter");
        System.out.println("2. Filter by Alphabetical order");

        int filter = verifier.verifyScannerNumber(scanObj);
        boolean activateAlphabetical = false;
        switch(filter){
            case 0:
                return true;
            case 1:
                break;
            case 2:
                activateAlphabetical = true;
                System.out.println("Which faculty would");
        }
        //choose format
        System.out.println("What format would you like the report to be?");
        System.out.println("0. Exit Report Format");
        System.out.println("1. txt");
        System.out.println("2. csv");
        
        int format = verifier.verifyScannerNumber(scanObj);
        FileWriter writer;
        FileOutputStream  streamOut;
        //check validity of input
        //converting into txt
        String filename = "staffReport_"+dateFor.convert_datetime_to_string(LocalDateTime.now());
        try{
            if(format == 1){
                writer = new FileWriter(filename+".txt");
                writeInText(campArray, cookie, writer, dateFor, activateAlphabetical);
            }else if(format == 2){
                streamOut = new FileOutputStream(new File(filename+".csv"));
                writeInCSV(campArray, cookie, streamOut, dateFor, filename+".csv", activateAlphabetical); 
            }else if(format == 0){
                return false;
            }else{
                System.out.println("Invalid Input!");
                return false;
            }
        }catch(Exception e){
            System.out.println(e);
            return false;
        }


    return true;
}
    
    /**
    * Runs the Staff Report which is to be formatted to TXT.
    * @param tempCampArray the temporary CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param writer FileWriter object used to write information into the txt file.
    * @param dateFor DateFormatter object used to format any dates required.
    * @return the boolean value whether the TXT Report is saved or not.
    */
    public boolean writeInText(ArrayList<Camp> tempCampArray, User cookie, FileWriter writer, DateFormatter dateFor, boolean activateAlphabetical) throws IOException{
        try{
            ReportTXTDAO genReport = new ReportTXTDAO(writer, activateAlphabetical);
            genReport.reportBeginnerHeader();
            writer.write("\nREPORT GENERATED FOR STAFF "+cookie.getUserID()+" \n");
            genReport.reportGenerateTodayDateHeader(dateFor);
            for(int i=1; i< tempCampArray.size()+1; i++){
                genReport.reportPrintCampDetails(tempCampArray.get(i-1), i-1);
                genReport.reportPrintCommitteeDetails(tempCampArray.get(i-1), i);
                genReport.reportPrintAttendeeDetails(tempCampArray.get(i-1), i);
                }

            genReport.reportEndingHeader();
            writer.close();
            }catch(Exception e){

             System.out.println(e);   
             return false;
            }
        return true;
    }
    
    /**
    * Runs the Staff Report which is to be formatted to CSV.
    * @param tempCampArray the temporary CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param streamOut FileOutputStream object used to write information into the csv file.
    * @param dateFor DateFormatter object used to format any dates required.
    * @param filename String object where csv information will be saved into.
    * @return the boolean value whether the CSV Report is saved or not.
    */
    public boolean writeInCSV(ArrayList<Camp> tempCampArray, User cookie, FileOutputStream streamOut, DateFormatter dateFor, String filename, boolean activateAlphabetical) throws IOException{
        ReportCSVDAO genReport = new ReportCSVDAO(tempCampArray, filename, activateAlphabetical);
        genReport.writeStaffReportInfo();
        return true;
    }
    
}

	



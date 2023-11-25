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

/**
Represents the StaffReport Object and the following assistance methods.
A StaffReport can be run multiple times depending on the number of reports to be made.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-8
*/
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
        System.out.println("2. Filter to print Camp Committee Members only");
        System.out.println("3. Filter to print Attendee Members only");
        System.out.println("4. Filter to print no members or attendee.");
        System.out.println("5. Filter to print only camps that Staff created!");

        int filter = verifier.verifyScannerNumber(scanObj);
        boolean printAttendee = true;
        boolean printCommittee  =true;
        boolean printOnlyCreate = false;
        switch(filter){
            case 0,-1:
                return true;
            case 1:
                break;
            case 2:
                printAttendee = false;
                break;
                
            case 3:
                printCommittee = false;
                break;
            
            case 4:
                printCommittee = false;
                printAttendee = false;
                break;
            case 5:
                printOnlyCreate = true;
                break;
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
        String filename = "staffReport_"+dateFor.convertDatetimeToString(LocalDateTime.now());
        try{
            if(format == 1){
                writer = new FileWriter(filename+".txt");
                writeInText(tempCampArray, campArray, cookie, writer, dateFor, printCommittee, printAttendee, printOnlyCreate);
            }else if(format == 2){
                streamOut = new FileOutputStream(new File(filename+".csv"));
                writeInCSV(tempCampArray, campArray, cookie, streamOut, dateFor, filename+".csv", printCommittee, printAttendee, printOnlyCreate); 
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
     * @param campArray the campArray that contains the entire camps in the application.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param writer FileWriter object used to write information into the txt file.
    * @param dateFor DateFormatter object used to format any dates required.
    * @param printCommittee boolean to check if need to print Camp Committee members.
    * @param printAttendee boolean to check if need to print attendees of camp only
    * @param printOnlyCreate boolean to check if need to print the camp which the staff in charge created.
    * @return the boolean value whether the TXT Report is saved or not.
     * @throws java.io.IOException
    */
    public boolean writeInText(ArrayList<Camp> tempCampArray, ArrayList<Camp> campArray, User cookie, FileWriter writer, DateFormatter dateFor, boolean printCommittee, boolean printAttendee, boolean printOnlyCreate) throws IOException{
        try{
            ReportTXTDAO genReport = new ReportTXTDAO(writer);
            genReport.reportBeginnerHeader();
            writer.write("\nREPORT GENERATED FOR STAFF "+cookie.getUserID()+" \n");
            genReport.reportGenerateTodayDateHeader(dateFor);
            if(printOnlyCreate == false){
                for(int i=1; i< campArray.size()+1; i++){
                    genReport.reportPrintCampDetails(campArray.get(i-1), i);
                    if(printCommittee == true){
                        genReport.reportPrintCommitteeDetails(campArray.get(i-1), i);
                    }
                    if(printAttendee == true){
                        genReport.reportPrintAttendeeDetails(campArray.get(i-1), i);
                    }
                } 
            }else{
                genReport.reportPrintCampDetails(tempCampArray.get(0), 1);
                if(printCommittee == true){
                    genReport.reportPrintCommitteeDetails(tempCampArray.get(0), 1);
                }
                if(printAttendee == true){
                    genReport.reportPrintAttendeeDetails(tempCampArray.get(0), 1);
                }
                
            }


            genReport.reportEndingHeader();
            writer.close();
            System.out.println("Text report successfully created!");
            }catch(Exception e){

             System.out.println(e);   
             return false;
            }
        return true;
    }
    
    /**
    * Runs the Staff Report which is to be formatted to CSV.
    * @param tempCampArray the temporary CampArray which the new camp object is stored.
    * @param campArray The ArrayList containing the camp Array to be printed out (Contains all camps)
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param streamOut FileOutputStream object used to write information into the csv file.
    * @param dateFor DateFormatter object used to format any dates required.
    * @param filename String object where csv information will be saved into.
    * @param printCommittee boolean to check if need to print Camp Committee members.
    * @param printAttendee boolean to check if need to print attendees of camp only
    * @param printOnlyCreate boolean to check if need to print the camp which the staff in charge created.
    * @return the boolean value whether the CSV Report is saved or not.
     * @throws java.io.IOException
    */
    public boolean writeInCSV(ArrayList<Camp> tempCampArray, ArrayList<Camp> campArray, User cookie, FileOutputStream streamOut, DateFormatter dateFor, String filename, boolean printCommittee, boolean printAttendee, boolean printOnlyCreate) throws IOException{
        ReportCSVDAO genReport = new ReportCSVDAO(tempCampArray, campArray, filename, printCommittee, printAttendee, printOnlyCreate);
        genReport.writeStaffReportInfo();
        return true;
    }
    
}

	



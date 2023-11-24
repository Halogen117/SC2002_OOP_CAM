/**
Represents the StaffPerformanceReportApp Object and the following assistance methods.
A StaffPerformanceReportApp can be run multiple times depending on the number of reports to be made.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-3
*/
package com.mycompany.anothercam.StaffApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.DateFormatter;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.ReportGenerator.ReportTXTDAO;
import com.mycompany.anothercam.ReportGenerator.ReportCSVDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class StaffPerformanceReport {
    
    /**
    * Runs the Staff Performance Report Application..
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return the boolean value whether the Staff Performance Report of camp object was successful.
    */
    public boolean runStaffPerformanceReport(ArrayList<Camp> campArray, User cookie, Scanner scanObj) throws IOException{
        DateFormatter dateFor = new DateFormatter();
        Verification verifier = new Verification();
	//check if staff 
		
        //ask for filters
        System.out.println("What filters would you like?");
        System.out.println("0. Quit filter selection");
        System.out.println("1. No Filter");
        System.out.println("2. Filter to print only camps that Staff created!");
                
        // Find camp first
        ArrayList<Camp> tempCampArray = new ArrayList<Camp>();
        for(int i=0; i< campArray.size(); i++){
            if(campArray.get(i).getStaffInCharge().equals(cookie.getUserID())){
                tempCampArray.add(campArray.get(i));
            } 
        }
                
        if(tempCampArray.size() <=0){
            System.out.println("There are no camps to create performance reports for!");
            return false;
        }
        //create string array
        int filter = verifier.verifyScannerNumber(scanObj);
        boolean printOnlyCreate = false;
        ArrayList<Camp> useCampArray = new ArrayList<Camp>();
        switch(filter){
            case 0,-1:
                return true;
            case 1:
                useCampArray = campArray;
                break;
            case 2:
                printOnlyCreate = true;
                useCampArray= tempCampArray;
                break;
            default:
                return false;
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
        String filename = "staffPerformanceReport_"+dateFor.convertDatetimeToString(LocalDateTime.now());

        if(format == 1){
            writer = new FileWriter(filename+".txt");
            writeInText(useCampArray, cookie, writer, dateFor);
        }else if(format == 2){
            streamOut = new FileOutputStream(new File(filename+".csv"));
            writeInCSV(tempCampArray, campArray, cookie, streamOut, dateFor, filename+".csv", printOnlyCreate); 
        }else if(format == 0){
            return false;
        }else{
            System.out.println("Invalid Input!");
            return false;
        }

	return true;
    }
    
    /**
    * Runs the Staff Performance Report which is to be formatted to TXT.
    * @param tempCampArray the temporary CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param writer FileWriter object used to write information into the txt file.
    * @param dateFor DateFormatter object used to format any dates required.
    * @return the boolean value whether the TXT Report is saved or not.
    */
    public boolean writeInText(ArrayList<Camp> tempCampArray, User cookie, FileWriter writer, DateFormatter dateFor){
            try{
                ReportTXTDAO genReport = new ReportTXTDAO(writer);
                genReport.reportBeginnerHeader();
                writer.write("PERFORMANCE REPORT FOR STAFF "+cookie.getUserName()+" \n");
                genReport.reportGenerateTodayDateHeader(dateFor);
                for(int i=1; i< tempCampArray.size()+1; i++){
                    writer.write("============================================\n");
                    writer.write("CAMP Number "+i+"\n");
                    writer.write("CAMP Name: "+tempCampArray.get(i-1).getCampName()+" \n");
                    
                    if(tempCampArray.get(i-1).getCampCommitteeList().size() >0){
                        writer.write("Camp Committee Member Name | Points Received \n");
                        for(int j=0; j<tempCampArray.get(i-1).getCampCommitteeList().size(); j++){
                            
                            writer.write(tempCampArray.get(i-1).getCampCommitteeList().get(j).getUserName()+" "+tempCampArray.get(i-1).getCampCommitteeList().get(j).getPoints()+"\n");
                        }
                    }else{
                         writer.write("No Students signed up for Camp as Attendees Yet! \n");
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
    * Runs the Staff Performance Report which is to be formatted to CSV.
    * @param tempCampArray the temporary CampArray which the new camp object is stored.
    * @param campArray The ArrayList containing the camp Array to be printed out (Contains all camps)
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param streamOut FileOutputStream object used to write information into the csv file.
    * @param dateFor DateFormatter object used to format any dates required.
    * @param filename String object where csv information will be saved into.
    * @param printOnlyCreate boolean to check if need to print the camp which the staff in charge created.
    * @return the boolean value whether the CSV Report is saved or not.
    */
    public boolean writeInCSV(ArrayList<Camp> tempCampArray, ArrayList<Camp> campArray, User cookie, FileOutputStream streamOut, DateFormatter dateFor, String filename, boolean printOnlyCreate){
        ReportCSVDAO genReport = new ReportCSVDAO(tempCampArray, campArray, filename, true, true, printOnlyCreate);
        genReport.writeStaffPerformanceInfo();
        return true;
    }
}

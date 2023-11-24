/**
Represents the CampCommitteeReport Object and the following assistance methods.
A CampCommitteeReport can be run multiple times depending on the number of reports to be made.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-11
*/

package com.mycompany.anothercam.StudentCommitteeApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.DateFormatter;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.ReportGenerator.ReportCSVDAO;
import com.mycompany.anothercam.Student;
import com.mycompany.anothercam.User;
import java.io.FileWriter;
import java.time.LocalDateTime;
import com.mycompany.anothercam.ReportGenerator.ReportTXTDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CampCommitteeReport{
        /**
        * Runs the Student Committee Report Camp Application..
        * @param campArray the CampArray which the new camp object is stored.
        * @param cookie the User Object (A Student Committee) which the requested user creates the report
        * @param scanObj takes in the scanner Object for automated testing.
        * @return the boolean value whether the Camp Committee Report of camp object was successful.
        */
	public boolean runStudentCommitteeReport(ArrayList<Camp> campArray, User cookie, Scanner scanObj) throws IOException{
            DateFormatter dateFor = new DateFormatter();
            Verification verifier = new Verification();
            //ask for filters
            System.out.println("What filters would you like?");
            System.out.println("0. Quit filter selection");
            System.out.println("1. No Filter");

            // Find camp first
            Student studCook = (Student) cookie;
            System.out.println("The student name of the cookie is"+studCook.getUserName());
            ArrayList<Camp> tempCampArray = new ArrayList<Camp>();
            for(int i=0; i< campArray.size(); i++){
                if(studCook.getCampCommitteeName().equals(campArray.get(i).getCampName())){
                    tempCampArray.add(campArray.get(i));
                } 
            }
            
            if(tempCampArray.size() <=0){
                System.out.println("There are no camps to create Camp Committee Reports for!");
                return false;
            }
            //create string array
            //String[] studentlist_report =  new String[StudentList.studList.size()];   //Declaration of the String Array without specifying the size  
            int filter = verifier.verifyScannerNumber(scanObj);
            boolean printOnlyCreate = false;
            ArrayList<Camp> useCampArray = new ArrayList<Camp>();
            switch(filter){
                case 0, -1:
                    return true;
                case 1:
                    useCampArray = campArray;
                    break;
                //case 2:
                    //printOnlyCreate = true;
                    //useCampArray= tempCampArray;
                    //break;
                default:
                    System.out.println("Invalid Input!");
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
            String filename = "CampCommitteeReport_"+dateFor.convertDatetimeToString(LocalDateTime.now());

            if(format == 1){
                writer = new FileWriter(filename+".txt");
                writeInText(tempCampArray, cookie, writer, dateFor);
            }else if(format == 2){
                streamOut = new FileOutputStream(new File(filename+".csv"));
                writeInCSV(tempCampArray, campArray, cookie, streamOut, dateFor, filename+".csv", printOnlyCreate); 
            }else if(format == 0 || format == -1){
                return false;
            }else{
                System.out.println("Invalid Input!");
                return false;
            }
        return true;
    }
        
    /**
    * Runs the Student Report which is to be formatted to TXT.
    * @param tempCampArray the temporary CampArray which the new camp object is stored.
    * @param cookie the User Object (A Student) which the requested user creates the Report
    * @param writer FileWriter object used to write information into the txt file.
    * @param dateFor DateFormatter object used to format any dates required.
    * @return the boolean value whether the TXT Report is saved or not.
    */
    public boolean writeInText(ArrayList<Camp> tempCampArray, User cookie, FileWriter writer, DateFormatter dateFor) throws IOException{
        try{
            ReportTXTDAO genReport = new ReportTXTDAO(writer);
        
        genReport.reportBeginnerHeader();
        writer.write("COMMITTEE REPORT FOR CAMP COMMITTEE "+cookie.getUserID()+" \n");
        genReport.reportGenerateTodayDateHeader(dateFor);
        writer.write("============================================\n");
        genReport.reportPrintCampDetails(tempCampArray.get(0), 0);
        genReport.reportPrintCommitteeDetails(tempCampArray.get(0), 0);
        genReport.reportPrintAttendeeDetails(tempCampArray.get(0), 0);   
        genReport.reportEndingHeader();
        writer.close();
        }catch(Exception e){

         System.out.println(e);   
         return false;
        }
        return true;
    }
    
    /**
    * Runs the Student Camp Committee Report which is to be formatted to CSV.
    * @param tempCampArray the temporary CampArray which the new camp object is stored.
    * @param campArray The ArrayList containing the camp Array to be printed out (Contains all camps)
    * @param cookie the User Object (A Student) which the requested user creates the Report
    * @param streamOut FileOutputStream object used to write information into the csv file.
    * @param dateFor DateFormatter object used to format any dates required.
    * @param filename String object where csv information will be saved into.
    * @param printOnlyCreate boolean to check if need to print the camp which the staff in charge created.
    * @return the boolean value whether the CSV Report is saved or not.
    */
    public boolean writeInCSV(ArrayList<Camp> tempCampArray, ArrayList<Camp> campArray, User cookie, FileOutputStream streamOut, DateFormatter dateFor, String filename, boolean printOnlyCreate) throws IOException{
        ReportCSVDAO genReport = new ReportCSVDAO(tempCampArray, campArray, filename, false, false, printOnlyCreate);
        genReport.writeCampCommitteeInfo();
        return true;
    }
}

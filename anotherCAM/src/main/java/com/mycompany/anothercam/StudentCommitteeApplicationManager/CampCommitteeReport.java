package com.mycompany.anothercam.StudentCommitteeApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.DateFormatter;
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

//currently not sure how to edit



public class CampCommitteeReport{
	//check if staff 
	public boolean runStudentCommitteeReport(ArrayList<Camp> campArray, User cookie, Scanner scanObj) throws IOException{
        DateFormatter dateFor = new DateFormatter();

        //ask for filters
        System.out.println("What filters would you like?");
        System.out.println("1. Quit filter selection");
        System.out.println("2. No Filter");
        System.out.println("3. Filter by Student's faculty");
                
        // Find camp first
        Student studCook = (Student) cookie;
        ArrayList<Camp> tempCampArray = new ArrayList<Camp>();
        for(int i=0; i< campArray.size(); i++){
            if(campArray.get(i).getCampName().equals(studCook.getCampCommitteeName())){
                tempCampArray.add(campArray.get(i));
            } 
        }
        //create string array
        //String[] studentlist_report =  new String[StudentList.studList.size()];   //Declaration of the String Array without specifying the size  
        int filter = scanObj.nextInt();

        //choose format
        System.out.println("What format would you like the report to be?");
        System.out.println("1. txt");
        System.out.println("2. csv");
        System.out.println("0. Exit Report Format");
        int format = scanObj.nextInt();
        FileWriter writer;
        FileOutputStream  streamOut;
        //check validity of input
        //converting into txt
        String filename = "CampCommitteeReport_"+dateFor.convert_datetime_to_string(LocalDateTime.now());

        if(format == 1){
            writer = new FileWriter(filename+".txt");
            writeInText(tempCampArray, cookie, writer, dateFor);
        }else if(format == 2){
            streamOut = new FileOutputStream(new File(filename+".csv"));
            writeInCSV(tempCampArray, cookie, streamOut, dateFor, filename+".csv"); 
        }else if(format == 0){
            return false;
        }else{
            System.out.println("Invalid Input!");
            return false;
        }
        return true;
    }
        
        
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
    
    public boolean writeInCSV(ArrayList<Camp> tempCampArray, User cookie, FileOutputStream streamOut, DateFormatter dateFor, String filename) throws IOException{
        ReportCSVDAO genReport = new ReportCSVDAO(tempCampArray, filename, "Staff Report");
        genReport.writeCampCommitteeInfo();
        return true;
    }
}

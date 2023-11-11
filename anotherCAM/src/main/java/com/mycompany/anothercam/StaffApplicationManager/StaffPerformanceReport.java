package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.DateFormatter;
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
	
    public boolean runStaffPerformanceReport(ArrayList<Camp> campArray, User cookie, Scanner scanObj) throws IOException{
        DateFormatter dateFor = new DateFormatter();
	//check if staff 
		
		//ask for filters
		System.out.println("What filters would you like?");
		System.out.println("1. Quit filter selection");
                System.out.println("2. No Filter");
		System.out.println("3. Filter by Student's faculty");
                
                // Find camp first
                ArrayList<Camp> tempCampArray = new ArrayList<Camp>();
                for(int i=0; i< campArray.size(); i++){
                    if(campArray.get(i).getStaffInCharge().equals(cookie.getUserID())){
                        tempCampArray.add(campArray.get(i));
                    } 
                }
		//create string array
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
                String filename = "staffPerformanceReport_"+dateFor.convert_datetime_to_string(LocalDateTime.now());
                
                if(format == 1){
                    writer = new FileWriter(filename+".txt");
                    writeInText(campArray, cookie, writer, dateFor);
                }else if(format == 2){
                    streamOut = new FileOutputStream(new File(filename+".csv"));
                    writeInCSV(campArray, cookie, streamOut, dateFor, filename+".csv"); 
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
                writer.write("PERFORMANCE REPORT FOR STAFF "+cookie.getUserID()+" \n");
                genReport.reportGenerateTodayDateHeader(dateFor);
                for(int i=1; i< tempCampArray.size()+1; i++){
                    writer.write("============================================\n");
                    writer.write("CAMP Number "+i+"\n");
                    writer.write("CAMP Name: "+tempCampArray.get(i-1).getCampName()+" \n");
                    
                    if(tempCampArray.get(i-1).getCampCommitteeList().size() >0){
                        writer.write("Camp Committee Member Name | Points Received \n");
                        for(int j=0; j<tempCampArray.get(i-1).getCampCommitteeList().size(); j++){
                            
                            writer.write(tempCampArray.get(i-1).getCampCommitteeList().get(j).getUserID()+" "+tempCampArray.get(i-1).getCampCommitteeList().get(j).getPoints()+"\n");
                        }
                    }else{
                         writer.write("No Students signed up for Camp as Attendees Yet! \n");
                    }
                }
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
        genReport.writeStaffPerformanceInfo();
        return true;
    }
}

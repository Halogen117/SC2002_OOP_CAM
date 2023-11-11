package com.mycompany.anothercam.StaffApplicationManager;
import com.mycompany.anothercam.Camp;
import java.util.Scanner;
import java.io.FileWriter; //for txt
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.ReportGenerator.ReportTXTDAO;
import com.mycompany.anothercam.ReportGenerator.ReportCSVDAO;
import java.util.ArrayList;
import com.mycompany.anothercam.DateFormatter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.io.FileOutputStream;
import java.io.File;

public class StaffReport{
    public boolean runStaffReportCamp(ArrayList<Camp> campArray, User cookie,Scanner scanObj) throws IOException{
        DateFormatter dateFor = new DateFormatter();
        
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
                String filename = "staffReport_"+dateFor.convert_datetime_to_string(LocalDateTime.now());
                
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
    
    public boolean writeInCSV(ArrayList<Camp> tempCampArray, User cookie, FileOutputStream streamOut, DateFormatter dateFor, String filename) throws IOException{
        ReportCSVDAO genReport = new ReportCSVDAO(tempCampArray, filename, "Staff Report");
        genReport.writeStaffReportInfo();
        return true;
    }
}

	



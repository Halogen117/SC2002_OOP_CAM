/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.ReportGenerator;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.DateFormatter;
import java.io.FileWriter; 
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Halogen
 */
public class ReportTXTDAO {
    private FileWriter writer;
    public ReportTXTDAO(FileWriter writer){
        this.writer = writer;
    }
    public void reportBeginnerHeader() throws IOException{
        this.writer.write("============================================\n");
        this.writer.write("REPORT TRANSCRIPT BEGIN \n");
        this.writer.write("============================================\n");
    }

    public void reportEndingHeader() throws IOException{
        writer.write("\n============================================\n");
        writer.write("REPORT TRANSCRIPT END \n");
        writer.write("============================================\n");
    }

    public void reportGenerateTodayDateHeader(DateFormatter dateFor) throws IOException{
        writer.write("DATE OF REPORT GENERATED: "+ dateFor.convert_datetime_to_string(LocalDateTime.now())+" \n");
    }
    public void reportPrintCampDetails(Camp campPrint, int i) throws IOException{
        writer.write("\n============================================\n");
        writer.write("CAMP Number "+i+"\n");
        writer.write("CAMP Name: "+campPrint.getCampName()+" \n");
        writer.write("CAMP Date: "+campPrint.getDateString()+" \n");
        writer.write("CAMP Registration Closing Date: "+campPrint.getRegClosingDateString()+" \n");
        writer.write("CAMP Description: "+campPrint.getDescription()+" \n");
        writer.write("CAMP No. of Total Slots: "+campPrint.getTotalSlot()+" \n");
        writer.write("CAMP No. of Camp Committee Slots: "+campPrint.getCampCommitteeSlots() +" \n");
        writer.write("CAMP Staff-in-charge: "+campPrint.getStaffInCharge()+" \n");
    }
    
    public void reportPrintCommitteeDetails(Camp campPrint, int i) throws IOException{
        if(campPrint.getCampCommitteeList().size() <=0){
            writer.write("No Students signed up for Camp as Committee Members Yet! \n");
        }else{
            writer.write("CAMP Committee Members are: \n");
            for(int j=1; j<campPrint.getCampCommitteeList().size()+1; j++){
                writer.write(j+". "+campPrint.getCampCommitteeList().get(j-1).getUserID()+"\n"); // Committee
            }
        }
    }

    public void reportPrintAttendeeDetails(Camp campPrint, int i) throws IOException{
        if(campPrint.getCampStudentList().size() <=0){
            writer.write("No Students signed up for Camp as Attendees Yet! \n");
        }else{
            writer.write("CAMP Attendee Members are: \n");
            for(int k=1; k<campPrint.getCampStudentList().size()+1; k++ ){
                writer.write(k+". "+campPrint.getCampStudentList().get(k-1).getUserID()+"\n"); // Attendee
            }
        }
    }
    
    
}

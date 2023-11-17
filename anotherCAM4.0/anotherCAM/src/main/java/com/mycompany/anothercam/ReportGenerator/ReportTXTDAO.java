/**
Represents the ReportTXTDAO Object and the following assistance methods.
A ReportTXTDAO object can be called multiple times
The class here creates the report format for TXT based on the information given from the camp Array. 
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-5
*/

package com.mycompany.anothercam.ReportGenerator;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.DateFormatter;
import java.io.FileWriter; 
import java.io.IOException;
import java.time.LocalDateTime;

public class ReportTXTDAO {
    private FileWriter writer;
    private boolean printAttendee;
    private boolean printCommittee;
    
    /**
    * The ReportTXTDAO Constructor.
    * @param writer FileWriter Object to write into the txt report.
    */
    public ReportTXTDAO(FileWriter writer){
        this.writer = writer;
    }
    
    /**
    * Writes the TXT beginner header into the TXT Report.
    */
    public void reportBeginnerHeader() throws IOException{
        this.writer.write("============================================\n");
        this.writer.write("REPORT TRANSCRIPT BEGIN \n");
        this.writer.write("============================================\n");
    }

    /**
    * Writes the TXT ending header into the TXT Report.
    */
    public void reportEndingHeader() throws IOException{
        writer.write("\n============================================\n");
        writer.write("REPORT TRANSCRIPT END \n");
        writer.write("============================================\n");
    }

    /**
    * Writes the TXT date of report generated header into the TXT Report.
    */
    public void reportGenerateTodayDateHeader(DateFormatter dateFor) throws IOException{
        writer.write("DATE OF REPORT GENERATED: "+ dateFor.convert_datetime_to_string(LocalDateTime.now())+" \n");
    }
    
    /**
    * Writes the Camp Details of the report into the TXT Report.
    */
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
    
    /**
    * Writes the Camp Committee Details of the report into the TXT Report.
    */
    public void reportPrintCommitteeDetails(Camp campPrint, int i) throws IOException{
        if(campPrint.getCampCommitteeList().size() <=0){
            writer.write("No Students signed up for Camp as Committee Members Yet! \n");
        }else{
            writer.write("CAMP Committee Members are: \n");
            for(int j=1; j<campPrint.getCampCommitteeList().size()+1; j++){
                writer.write(j+". "+campPrint.getCampCommitteeList().get(j-1).getUserName()+"\n"); // Committee
            }
        }
    }

    /**
    * Writes the Student Attendee Details of the report into the TXT Report.
    */
    public void reportPrintAttendeeDetails(Camp campPrint, int i) throws IOException{
        if(campPrint.getCampStudentList().size() <=0){
            writer.write("No Students signed up for Camp as Attendees Yet! \n");
        }else{
            writer.write("CAMP Attendee Members are: \n");
            for(int k=1; k<campPrint.getCampStudentList().size()+1; k++ ){
                writer.write(k+". "+campPrint.getCampStudentList().get(k-1).getUserName()+"\n"); // Attendee
            }
        }
    }
    
    
}

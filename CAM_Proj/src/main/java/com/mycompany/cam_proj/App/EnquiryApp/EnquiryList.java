package com.mycompany.cam_proj.App.EnquiryApp;
import java.util.ArrayList;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;

public class EnquiryList {
    private static List<Enquiry> enquiriesList = new ArrayList<>();

    public static void addEnquiry(Enquiry enquiry){
        enquiriesList.add(enquiry);
    }

    public static void removeEnquiry(Enquiry enquiry){
        enquiriesList.remove(enquiry);
    }

    public static Enquiry getEnquirybyId(int enquiryID){
        for (Enquiry enquiry : enquiriesList){
            if (enquiry.getEnquiryID() == enquiryID){
                return(enquiry);
            }
        }

        return null;
    }

    public static List<Enquiry> getAllEnquiries(){
        return new ArrayList<>(enquiriesList);
    }

    public static void printAllEnquiries(){
        for (Enquiry enquiry : enquriesList){
            System.outprintln(enquiry.getEnquityID() + ":" + enquity.getDescription());
        }
    }

    public static void printAllEnquiries(){
        
    }

    
}

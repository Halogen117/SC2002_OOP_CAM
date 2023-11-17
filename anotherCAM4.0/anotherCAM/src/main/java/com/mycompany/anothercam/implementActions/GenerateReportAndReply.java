/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.implementActions;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;

/**
 *
 * @author Halogen
 */
public interface GenerateReportAndReply{
    boolean runGenerateReport(ArrayList<Camp> camp_array, User cookie);
    
    boolean runReply(ArrayList<Camp> camp_array, User cookie);
}

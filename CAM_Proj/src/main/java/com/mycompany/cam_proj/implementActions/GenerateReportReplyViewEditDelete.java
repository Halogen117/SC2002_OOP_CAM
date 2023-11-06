/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.implementActions;

import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.User;
import java.util.ArrayList;

/**
 *
 * @author Halogen
 */
public interface GenerateReportReplyViewEditDelete extends GenerateReportAndReply, ViewEditDelete{
    boolean runView(ArrayList<Camp> camp_array, User cookie);
    boolean runEdit(ArrayList<Camp> camp_array, User cookie);
    boolean runDelete(ArrayList<Camp> camp_array, User cookie);
    boolean runGenerateReport(ArrayList<Camp> camp_array, User cookie);
    boolean runReply(ArrayList<Camp> camp_array, User cookie);
}

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
interface Register {
    boolean runRegister(ArrayList<Camp> camp_array, User cookie);
    boolean runUnregister(ArrayList<Camp> camp_array, User cookie);
}

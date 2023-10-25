/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.App.CampApp.CampEdit;

import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.User;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Halogen
 */
interface EditCamp {
    boolean runEditCamp(ArrayList<Camp> campArray, User cookie);
}

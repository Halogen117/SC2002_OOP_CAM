/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.App.StatusApp;

import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
interface StatusApp {
    boolean runStatusApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj);
}

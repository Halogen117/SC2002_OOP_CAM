/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.implementActions;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public interface ViewEditDelete{
    boolean runView(ArrayList<Camp> camp_array, User cookie, Scanner scanObj);
    boolean runEdit(ArrayList<Camp> camp_array, User cookie, Scanner scanObj);
    boolean runDelete(ArrayList<Camp> camp_array, User cookie, Scanner scanObj);
}

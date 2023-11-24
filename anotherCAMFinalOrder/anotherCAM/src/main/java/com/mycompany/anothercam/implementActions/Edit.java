package com.mycompany.anothercam.implementActions;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;

import java.util.ArrayList;
import java.util.Scanner;

public interface Edit {
    boolean runEdit(ArrayList<Camp> camp_array, User cookie, Scanner scanObj);
}

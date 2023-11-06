package com.mycompany.cam_proj.App.CampApp.CampView;

import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.User;
import java.util.ArrayList;
import java.util.Scanner;

interface ViewCamp{
    boolean runViewCamp(ArrayList<Camp> campArray, User cookie, Scanner scanObj);
}
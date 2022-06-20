/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;


/**
 *
 */
public class Task {
        
    public boolean checkTaskDescription(String task_description) {
        if (task_description.length() <= 50) {
            System.out.println("Task successfully captured");
            return true;
        }
        System.out.println("Please enter a task description of less than 50 characters");
        return false;
    }

    public String createTaskID(String dev_details, String task_name, String task_number) {
        String developer = dev_details.substring(dev_details.length() - 3, dev_details.length());
        String taskId = (task_name.charAt(0) + "" + task_name.charAt(1) + ":" + task_number + ":" + developer).toUpperCase();
        return taskId;
    }

    public String printTaskDetails(ArrayList<String> task_number, ArrayList<String> task_name, ArrayList<String> task_description, 
            ArrayList<String> task_status, ArrayList<String> task_ID, ArrayList<String> dev_details, ArrayList<Integer> task_duration) {
        String details = "";
        
        for (int i = 0; i < task_number.size(); i++) {

            details += "\nTask name: " + task_name.get(i) + "\nTask number: " + task_number.get(i) + "\nTask description: " + task_description.get(i) + "\nTask Duration: " + task_duration.get(i)
                    + "\nDevelopr details: " + dev_details.get(i) + "\nTask ID " + task_ID.get(i) + "\nTask status: " + task_status.get(i);
        }

        return details;
    }

    public int returnTotalHours(int[] taskDuration) {
        int hours = 0;
        for (int count = 0; count < taskDuration.length; count++) {
            hours += taskDuration[count];
        }

        return hours;
    }

}


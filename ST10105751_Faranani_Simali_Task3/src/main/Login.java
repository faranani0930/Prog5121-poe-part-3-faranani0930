/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;

/**
 *
 */
public class Login {
               private String username,password,name,surname;
    private Scanner read;
    private int numTasks;
    private ArrayList<String> taskName = new ArrayList<String>();
    private ArrayList<String> taskNumber = new ArrayList<String>();
    private ArrayList<String> taskDescription = new ArrayList<String>();
    private ArrayList<String> developerDetails= new ArrayList<String>();
    private ArrayList<Integer> taskDuration = new ArrayList<Integer>();
    private ArrayList<String> taskID = new ArrayList<String>();
    private ArrayList<String> taskStatus = new ArrayList<String>();
    
    public int getNumTasks() {
        return numTasks;
    }

    public ArrayList<String> getTaskName() {
        return taskName;
    }

    public ArrayList<String> getTaskNumber() {
        return taskNumber;
    }

    public ArrayList<String> getTaskDescription() {
        return taskDescription;
    }

    public ArrayList<String> getDeveloperDetails() {
        return developerDetails;
    }

    public ArrayList<Integer> getTaskDuration() {
        return taskDuration;
    }

    public ArrayList<String> getTaskID() {
        return taskID;
    }

    public ArrayList<String> getTaskStatus() {
        return taskStatus;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }
    
    public Login(InputStream inputStream){
        this.read = new Scanner(inputStream);
    }
    
    public Login(){
        this.read = new Scanner(System.in);
    }

    public boolean setUsername(String Username){
        this.username = Username;

        boolean username_is_valid = checkUserName();

        if(username_is_valid){
            System.out.println("Username successfully captured.");
        } else{
            System.out.println("Username is not correctly formatted please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return false;
        }

        return true;
    }

    public boolean setPassword(String Password){
        this.password = Password;
        
        boolean password_is_valid = checkPasswordComplexity();

        if(password_is_valid){
            System.out.println("Password successfully captured.");
        } else{
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            return false;
        }

        return true;
    }

    public void setFirstName(){

        System.out.println("Please enter your name:");
        this.name = this.read.nextLine();
    }

    public void setlastName(){
        System.out.println("Please enter your surname:");
        this.surname = this.read.nextLine();
    }

    public String registerUser(){
        System.out.println("Please enter your username:");
        String Username = this.read.nextLine();

        boolean username_correct = setUsername(Username);

        if(!username_correct){
            return "\nThe username is incorrectly formatted";
        }

        System.out.println("Please enter your password:");
        String Password = this.read.nextLine();
        boolean password_correct = setPassword(Password);

        if(!password_correct){
            return "\nThe password does not meet the complexity requirements.";
        }

        return "\nThe two above conditions have been met and the user has been registered successfully.";
    }

    public boolean checkUserName(){

        return this.username.contains("_") && this.username.length() <= 5;
    }

    public boolean checkPasswordComplexity(){

        String specialCharacter = "(?=.*[-+_!@#$%^&*.,?]).+$" ;
        String digit = ".*[0-9].*";
        String uppercase = ".*[A-Z].*";

        return this.password.length()>=8 &&this.password.matches(uppercase) && this.password.matches(digit) && this.password.matches(specialCharacter);
    }
    
    public boolean getLoginDetails(){
        System.out.println("Username:");
        String userName = read.nextLine();

        System.out.println("Password");
        String userPassword = read.nextLine();
        
        boolean loginStatus = loginUser(userName, userPassword);
        if(loginStatus == true){
            JOptionPane.showMessageDialog(null,"\nWelcome " + this.username + " " + this.surname + " it is great to see you again.");
        } else{
            JOptionPane.showMessageDialog(null,"\nUsername or Password is incorrect please try again.");

        }
        
        return loginStatus;
    }

    public boolean loginUser(String userName, String userPassword){
        

        return this.username.equals(userName) && this.password.equals(userPassword);
    }

    public void addTasks(int numTasks){

        Task task = new Task();
        
        for(int count = 0; count < numTasks;count++){
            System.out.println("Please enter the task name:");
            taskName.add(this.read.nextLine());
            
            taskNumber.add(String.valueOf(count));
            
            while(true){
                
                System.out.println("Please enter a task description of less than 50 character:");
                taskDescription.add(this.read.nextLine());
                
                if(task.checkTaskDescription(taskDescription.get(count))){
                    break;
                }
            }
            
            
            System.out.println("Please enter developer details:");
            developerDetails.add(this.read.nextLine());
            
            System.out.println("Please enter task duration in hours:");
            taskDuration.add(this.read.nextInt());
                
            
            taskID.add(task.createTaskID(developerDetails.get(count), taskName.get(count), taskNumber.get(count)));
            
            System.out.println("Please enter task status:");
            System.out.println("> To Do");
            System.out.println("> Done");
            System.out.println("> Doing");

            while(true){
                String status = this.read.nextLine();
                if(status.equalsIgnoreCase("To Do") || status.equalsIgnoreCase("Done") || status.equalsIgnoreCase("Doing")){
                    taskStatus.add(status);
                    break;
                }
            }
            
        }

    }

    public void showReport(){
        String message = printTaskDetails();
        
        
        JOptionPane.showMessageDialog(null,message);
    }

    public boolean quit(){
        System.out.println("Exiting.");
        return true;
    }

    public String printTaskDetails() {
        Task task = new Task();
        return task.printTaskDetails(taskNumber, taskName, taskDescription, taskStatus, taskID, developerDetails, taskDuration);
    }
    
    public String searchLongestDuration(){
        int duration = getTaskDuration().get(0);   // start with the first value
        String developer = "";
        for (int i=1; i<getTaskDuration().size(); i++) {
            
        
            if (getTaskDuration().get(i) > duration) {
               
                duration = getTaskDuration().get(i);   // new maximum
                developer = getDeveloperDetails().get(i);
            }
        }
        
        return  developer+", "+duration;
        
    }
    
    public String searchTask(String taskName){
        String message = "";
        
        
        for(int count = 0 ; count < getTaskName().size(); count ++){
            
            if(taskName.equalsIgnoreCase(getTaskName().get(count))){
                message =getDeveloperDetails().get(count) + ", " + getTaskName().get(count);
            } 
        }
        return message;
        
    }
    
    public String searchAllTasks(String searchDeveloper){
        String message = "";
        for(int count = 0; count < getDeveloperDetails().size(); count++){
            
            
            if(searchDeveloper.equalsIgnoreCase(getDeveloperDetails().get(count))){
                message += getTaskName().get(count) + "\n";
            }
            
        }
        
        return message;
        
    }
    
    public String deleteTask(String task){
        String message = "Could not find requested task. Please try again.";
    
        int index = getTaskName().indexOf(task);
        if(index >= 0){
            getTaskDescription().remove(index);
            getDeveloperDetails().remove(index);
            getTaskName().remove(index);
            getTaskNumber().remove(index);
            getTaskID().remove(index);
            getTaskStatus().remove(index);
            getTaskDuration().remove(index);
            
            message = "Entry \"" + task + "\" successfully deleted";
        }
        return message;
    }

}
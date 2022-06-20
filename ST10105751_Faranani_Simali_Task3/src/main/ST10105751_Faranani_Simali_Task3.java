/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package main;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 */


public class ST10105751_Faranani_Simali_Task3 {
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Login accountLogin = new Login();
        

        System.out.println("Set up your EasyKanban account.");
        getUserDetais(accountLogin);
        JOptionPane.showMessageDialog(null,"Welcome to EasyKanban.");
        login(accountLogin);
        while(true){
            String choice = JOptionPane.showInputDialog(null, "What would you like to do next: e.g 1 or 2\n1. Add Tasks.\n2. Show report.\n3. Quit.\n4. Search for a task with a Task Name "
                    + "\n5. Search for all tasks assigned to a developer \n6. Display the Developer and Duration of the class with the longest duration.\n7. Delete a task using the Task Name" );
            
            if(choice.equals("1")){
                System.out.println("How many tasks would you like to add?");
                int numTasks = read.nextInt();
                accountLogin.addTasks(numTasks);
                String displayMessage = accountLogin.printTaskDetails();
                JOptionPane.showMessageDialog(null, "Task details:" + displayMessage);
                
            } else if(choice.equals("2")){ 
                accountLogin.showReport();
            } else if(choice.equals("3")){
                accountLogin.quit();
                break;
            } else if(choice.equals("4")){
                String taskName = JOptionPane.showInputDialog(null, "Enter task name to start search:");
                JOptionPane.showMessageDialog(null, "Search results: \n" + accountLogin.searchTask(taskName));
                
            } else if(choice.equals("5")){
                String taskName = JOptionPane.showInputDialog(null, "Enter developer details to start search:");
                JOptionPane.showMessageDialog(null, "Search results: \n" + accountLogin.searchAllTasks(taskName));
                
            } else if(choice.equals("6")){
                JOptionPane.showMessageDialog(null, "Search results: " +accountLogin.searchLongestDuration());
                
            } else if(choice.equals("7")){
                String taskName = JOptionPane.showInputDialog(null, "Enter task name to delete:");
                JOptionPane.showMessageDialog(null, accountLogin.deleteTask(taskName));
            }
        }

    }


    public static void getUserDetais(Login accountLogin){
        accountLogin.setFirstName();
        accountLogin.setlastName();
        while(true){
            String registerUser = accountLogin.registerUser();

            if(registerUser.equals("\nThe two above conditions have been met and the user has been registered successfully.")){
                break;
            } 
            
            System.out.println("Please try again.");
        }
    }

    public static void login(Login accountLogin){
        boolean login_successful = false;
        System.out.println("\nPleaser enter your login details.");
        while(true){
            login_successful = accountLogin.getLoginDetails();
            
            if(login_successful){
                return;
            }
        }
    }
    
}  
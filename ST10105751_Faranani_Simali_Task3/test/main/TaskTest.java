/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class TaskTest {
         private Task task = new Task();

    @Test
    public void testCheckTaskDescriptionTrue(){
        
        String taskDescription = "Testing task description string";
        boolean checkTask = task.checkTaskDescription(taskDescription);
        
        assertEquals(true, checkTask);
    }
    
    
    @Test
    public void testCheckTaskDescriptionFalse(){
        
        String taskDescripton = "Testing task description string but expection it to fail because the string is longer than 50 characters";
        boolean checkTask = task.checkTaskDescription(taskDescripton);
        
        assertEquals(false, checkTask);
   
        
    }
    
    @Test
    public void testTaskId(){
        
        String developerDetails = "Robyn Harrison";
        
        String taskName = "Login Feature";
        
        String taskNumber = "0";
        
        
        String taskId = task.createTaskID(developerDetails, taskName, taskNumber);
        
        assertEquals("LO:0:SON", taskId);
    }
    
    
    @Test
    public void testHours(){
        int[] duration =  {10,12,55,11,1};
        
        int hours = task.returnTotalHours(duration);
        
        assertEquals(89,hours);
        
        
    }
}


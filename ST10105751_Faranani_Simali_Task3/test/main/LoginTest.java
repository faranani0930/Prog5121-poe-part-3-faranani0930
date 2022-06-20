/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
           private Login login = new Login();
    
    String test_user_1 = "Create Login\nTest Data Task 1\nMike Smith\n5\nTo Do\n";
    String test_user_2 = "Create Add Features\nTest Data Task 2\nEdward Harrison\n8\nDoing\n";
    String test_user_3 = "Create Reports\nTest Data Task 3\nSamantha Paulson\n2\nDone\n";
    String test_user_4 = "Add Arrays\nTest Data Task 4\nGlenda Oberholzer\n11\nTo Do\n";
    
    @Test
    public void testArrays(){
        
        InputStream mockedInput = new ByteArrayInputStream((test_user_1+test_user_2+test_user_3+test_user_4).getBytes());
        Login login = new Login(mockedInput);
        login.addTasks(4);
        assertEquals("[Mike Smith, Edward Harrison, Samantha Paulson, Glenda Oberholzer]",  Arrays.toString((login.getDeveloperDetails()).toArray()));
    }
    
    @Test
    public void testSearch(){
        InputStream mockedInput = new ByteArrayInputStream((test_user_1+test_user_2+test_user_3+test_user_4).getBytes());
        Login login = new Login(mockedInput);
        login.addTasks(4);
        
        assertEquals("Mike Smith, Create Login", login.searchTask("Create Login"));
    }
    
    @Test
    public void testSearchDeveloperDetails(){
        InputStream mockedInput = new ByteArrayInputStream((test_user_1+test_user_2+test_user_3+test_user_4).getBytes());
        Login login = new Login(mockedInput);
        login.addTasks(4);
 
        assertEquals("Create Reports", login.searchAllTasks("Samantha Paulson").trim());
    }
    
    @Test
    public void testDeleteTask(){
        InputStream mockedInput = new ByteArrayInputStream((test_user_1+test_user_2+test_user_3+test_user_4).getBytes());
        Login login = new Login(mockedInput);
        login.addTasks(4);
 
        assertEquals("Entry \"Create Reports\" successfully deleted", login.deleteTask("Create Reports").trim());
    }
    
    @Test
    public void testLongestDuration(){
        InputStream mockedInput = new ByteArrayInputStream((test_user_1+test_user_2+test_user_3+test_user_4).getBytes());
        Login login = new Login(mockedInput);
        login.addTasks(4);
        login.searchLongestDuration();
        assertEquals("Glenda Oberholzer, 11",  login.searchLongestDuration());
    }
    
    @Test
    public void testUserNameCorrectInput(){
        
        
        String username = "kyl_1";
        boolean test_username = login.setUsername(username);
        
        assertEquals(true,test_username);
    }
    
    @Test
    public void testUsernameWrongInput(){
        
        String username = "kyle!!!!!!";
        boolean test_username = login.setUsername(username);
        
        assertEquals(false,test_username);
    }
    
    
    @Test
    public void testPasswordCorrect(){
        
        String password = "Ch&&sec@ke99!";
        login.setPassword(password);
        
        boolean test_password = login.checkPasswordComplexity();
        
        assertEquals(true, test_password);
    }
    
    @Test
    public void testPasswordIncorrect(){
        
        String password = "password";
        login.setPassword(password);
        
        boolean test_password = login.checkPasswordComplexity();
        
        assertEquals(false, test_password);
    }
    
    @Test
    public void testLoginSuccessful(){
        
        String username = "kyl_";
        String password = "Ch&&sec@ke99!";
        
        login.setUsername(username);
        login.setPassword(password);
        
        boolean loginStatus = login.loginUser(username, password);
        
        assertTrue(loginStatus);
    }
    
    @Test
    public void testLoginFailed(){
        
        String username = "kyl_";
        String password = "Ch&&sec@ke99!";
        
        login.setUsername(username);
        login.setPassword(password);
        
        username = "testing";
        password = "Testing@12";
        
        boolean loginStatus = login.loginUser(username, password);
        
        assertFalse(loginStatus);
    }
    
    @Test
    public void testValidUsername(){
        
        String username = "kyl_";
        login.setUsername(username);
        boolean test_checkUserName = login.checkUserName();
        
        assertTrue(test_checkUserName);
        
    }
    
    @Test
    public void testInValidUsername(){
        
        String username = "kyle";
        login.setUsername(username);
        boolean test_checkUserName = login.checkUserName();
        
        assertFalse(test_checkUserName);
        
    }
    
    @Test
    public void testValidPassword(){
        
        String password = "Ch&&sec@ke99!";
        login.setPassword(password);
        
        boolean test_password = login.checkPasswordComplexity();
        
        assertTrue(test_password);
        
    }
    
    @Test
    public void testInvalidPassword(){
        
        String password = "testin@232";
        login.setPassword(password);
        
        boolean test_password = login.checkPasswordComplexity();
        
        assertFalse(test_password);
    }
    

}


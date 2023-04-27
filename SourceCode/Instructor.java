
package quizgame_3035;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class Instructor {
    //Fields
    private final String SR;
    private final String TB;
    private final String AN;
    private final String UI;

    Assets icon = new Assets();
    
    //Constructor
    public Instructor(String sr, String tb, String an, String ui) throws IOException{
        SR = sr;
        TB = tb;
        AN = an;
        UI = ui;
        
        //Display options
        String[] options = {"Add Question", "Display Stats", "Add Student"};
        int jop = JOptionPane.showOptionDialog(null, "What would you like to do?", "Instructor Panel", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        switch (jop) {
            case 0 -> AddQuestion();
            case 1 -> DisplayStats();
            default -> AddStudent();
        }
    }
    
    private void AddQuestion() throws IOException{
        //Get question to add
        String question = JOptionPane.showInputDialog("What question do you want to add?");
        
        //Add new question to TestBank
        FileWriter TestBank = new FileWriter(TB,true);
        try (PrintWriter atb = new PrintWriter(TestBank)) {
            atb.println("\n" + question);
        }
        
        //Get answer to new question
        String[] options = { "TRUE", "FALSE"};
        int answer = JOptionPane.showOptionDialog(null, "What is the answer to the question?", "Adding Test Question", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        
        //Add answer to Answers.txt
        FileWriter Ans = new FileWriter(AN,true);
        try (PrintWriter aa = new PrintWriter(Ans)) {
            if (answer == 0){
                aa.println("TRUE");
            } else {
                aa.println("FALSE");
            }
        }
    }
    
    private void DisplayStats() throws IOException{
        int max = 0;
        String highest = "";
        int min = 101;
        String lowest = "";
        int sum = 0;
        int lines = 0;
         
        //Get total number of student reports
        try (BufferedReader reader = new BufferedReader(new FileReader(SR))) {
            while(reader.readLine() != null) lines++;
        }
        
        //find highest score, lowest score, and sum of scores
        try (Scanner reports = new Scanner(new File(SR))) {
            reports.useDelimiter("[,]");
            while(reports.hasNext()){
                //Process data
                String name = reports.next();
                int score = Integer.parseInt(reports.next());
                
                //Add score to sum
                sum = sum + score;
                
                //Get max
                if (score > max){
                    max = score;
                    highest = name;
                //Get min
                } else if (score < min) {
                    min = score;
                    lowest = name;
                }
                
            }
         }
        
        //Calcluate average
        int average = sum / lines;
        
        //Display stats
        ImageIcon stats = icon.StatsIcon();
        JOptionPane.showMessageDialog(null,("Highest Score: " + highest + "\n" + "Lowest Score: " + lowest + "\n" + "Average Score: " + average),"Display Stats",JOptionPane.PLAIN_MESSAGE,stats);

        
    }
    
    private void AddStudent() throws IOException{
        //Get student information
        JOptionPane.showMessageDialog(null, "Please provide the student's information");
        String Fname = JOptionPane.showInputDialog("First name?");
        String Lname = JOptionPane.showInputDialog("Last name?");
        String UserName = JOptionPane.showInputDialog("Username?");
        String Password = JOptionPane.showInputDialog("Password?");
        
        //Add student to UserInfo
        FileWriter UsI = new FileWriter(UI,true);
        try (PrintWriter userInfo = new PrintWriter(UsI)) {
            userInfo.println("\n" + Fname + "," + Lname + "," + UserName + "," + Password + "," + "Student" + ",");
        }
    }
}

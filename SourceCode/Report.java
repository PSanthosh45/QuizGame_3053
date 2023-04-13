
package quizgame_3035;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class Report {
    //Fields
    private final String path;
    private final String name;
    private final String username;
    private final String timestamp;
    private final String elapsed;
    private final int score;
    //DATA STRUCTURE: TreeMap to process AnswerSheet from Quiz
    private final TreeMap<String, String> answers;
    
    Assets icons = new Assets();
    
    //Constructor
    public Report(String p, String n, String un, String ts, String elt, int s,TreeMap<String, String> ans){
        path = p;
        name = n.trim();
        username = un;
        timestamp = ts;
        elapsed = elt;
        score = s;
        answers = ans;
        
    }
    
    //Display student report
    public void StudentReport(){
        //Display report to student
        if (score >= 90){
            //Grade A
            ImageIcon gradeA = icons.AIcon();
            JOptionPane.showMessageDialog(null,(timestamp + "\n" + name + "\nYou Scored: " + score + "/100"),"Grade Report",JOptionPane.PLAIN_MESSAGE,gradeA);
        } else if (score >= 80 && score <= 89){
            //Grade B
            ImageIcon gradeB = icons.BIcon();
            JOptionPane.showMessageDialog(null,(timestamp + "\n" + name + "\nYou Scored: " + score + "/100"),"Grade Report",JOptionPane.PLAIN_MESSAGE,gradeB);
        } else if (score >= 70 && score <= 79){
            //Grade C
            ImageIcon gradeC= icons.CIcon();
            JOptionPane.showMessageDialog(null,(timestamp + "\n" + name + "\nYou Scored: " + score + "/100"),"Grade Report",JOptionPane.PLAIN_MESSAGE,gradeC);
        } else if (score >= 60 && score <= 69) {
            //Grade D
            ImageIcon gradeD = icons.DIcon();
            JOptionPane.showMessageDialog(null,(timestamp + "\n" + name + "\nYou Scored: " + score + "/100"),"Grade Report",JOptionPane.PLAIN_MESSAGE,gradeD);
        } else if (score <= 59){
            //Grade F
            ImageIcon gradeF = icons.FIcon();
            JOptionPane.showMessageDialog(null,(timestamp + "\n" + name + "\nYou Scored: " + score + "/100"),"Grade Report",JOptionPane.PLAIN_MESSAGE,gradeF);
        }
        
        //Ask if user wants to see the answer sheet
        String[] options = {"Yes", "No"};
        int useranswer = JOptionPane.showOptionDialog(null, "Would you like to check your answers?", "Answer Sheet Display", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
         if (useranswer == 0){
                DisplayAnswers();
            } else {
                JOptionPane.showMessageDialog(null,"Have a good day!","Goodbye Message",JOptionPane.PLAIN_MESSAGE,null);
            }  
    }
    
    //Display AnswerSheet
    public void DisplayAnswers(){
        for(Map.Entry<String,String> entry : answers.entrySet()){
            JOptionPane.showMessageDialog(null,(entry.getKey() + "Correct Answer: " + entry.getValue()),"Answer Key",JOptionPane.PLAIN_MESSAGE,null);
        }
    }
    
    //Create report card file
    public void ReportCardFile(String path)throws IOException {
        String filename = username + "_COSC_236_Quiz.txt";
        //String filename = username + "_COSC_236_Quiz_" + timestamp + ".txt"; **FOR SOME REASON IT WON'T WORK WITH THE TIMESTAMP**
        String filepath = path + filename;
        File SR = new File(filepath);
        FileWriter SRwriter = new FileWriter(SR);
        SRwriter.write("Name: " + name + "\n");
        SRwriter.write("Username: " + username + "\n");
        SRwriter.write("Score: " + score + "\n");
        SRwriter.write(elapsed + "\n \n");
        SRwriter.write("Answer Sheet: \n");
        for (Map.Entry<String, String> entry : answers.entrySet()){
            SRwriter.write(entry.getKey() + "Correct Answer: " + entry.getValue() + "\n \n");
        }
        SRwriter.close();
    }
    
    //Add report to StudentReports file
    public void AppendReport() throws IOException{
        FileWriter SR = new FileWriter(path,true);
        try (PrintWriter Reports = new PrintWriter(SR)) {
            Reports.printf("\n%s,%s,",name,score, "\n");
        }
    }
    
}

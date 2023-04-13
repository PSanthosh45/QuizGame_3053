package quizgame_3035;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class QuizGame_3035 {
    
    public static final String path = "C:\\Users\\parus\\Documents\\NetBeansProjects\\QuizGame_3035\\src\\quizgame_3035\\Data\\";
    public static String UIpath = (path + "UsersInfo.txt");
    public static String ANpath = (path + "Answers.txt");
    public static String TBpath = (path + "TestBank.txt");
    public static String SRpath = (path + "StudentReports.txt");
    
    public static void main(String[] args) throws IOException {
        int runagain = 0;
        while (runagain == 0) {
            //Login
            Login login = new Login(UIpath);
            login.LoginUP();
            String username = login.getUsername();
            String name = login.getName();
            String role = login.getRole();
            
            //Run program
            if (role.equals("Student")){
                Student(name, username);
            } else {
                Instructor inst = new Instructor(SRpath, TBpath, ANpath, UIpath);
            }
            
            //Run Again
            String[] options = {"Yes", "No"};
            runagain = JOptionPane.showOptionDialog(null, "Would you like to run the program again?", "Run Agian", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        }
        
    }
    
    
    public static void Student(String name, String username) throws IOException {
        //Run quiz 
            Quiz quiz = new Quiz(TBpath, ANpath);
            quiz.RunQuiz();
            
            //Get quiz info
            int score = quiz.getScore();
            String timestamp = quiz.getTimestamp();
            String elapsed = quiz.getElapsedTime();
            TreeMap<String, String> answerSheet = quiz.getAnswerSheet();
            
            //Reports
            Report report = new Report(SRpath,name,username,timestamp,elapsed,score,answerSheet);
            report.StudentReport();
            report.ReportCardFile(path);
            report.AppendReport();
    }
    
}

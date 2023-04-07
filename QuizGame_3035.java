package quizgame_3035;

import java.io.*;
import java.util.*;

public class QuizGame_3035 {
        
    public static void main(String[] args) throws IOException {
        //Defining file paths
        String path = "C:\\Users\\parus\\Documents\\NetBeansProjects\\QuizGame_3035\\src\\quizgame_3035\\Data\\";
        String UIpath = (path + "UsersInfo.txt");
        String ANpath = (path + "Answers.txt");
        String TBpath = (path + "TestBank.txt");
        String SRpath = (path + "StudentReports.txt");

        //Login
        Login login = new Login(UIpath);
        login.LoginUP();
        //Get user info
        String username = login.getUsername();
        String name = login.getName();
        String role = login.getRole();
                
        
        if (role.equals("Student")){
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
            //report.StudentReport();
            //report.ReportCardFile(path);
            report.AppendReport();
        } else {
            Instructor inst = new Instructor(SRpath, TBpath, ANpath, UIpath);
        }
        
    }
}

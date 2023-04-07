
package quizgame_3035;

import java.util.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;

public class Quiz {
    //Fields
    private final String TBpath;
    private final String Apath;
    private final String timestamp;
    private final long startTime;
    private long endTime;
    private String elapsedTime;
    private final int questions = 10;
    private int score = 0;
    //DATA STRUCTURE: HashMap for storing user answer and correct answer
    private final HashMap<String, String> AnswerSheet;
    //DATA STRUCTURE: TreeMap for sorting HashMap AnswerSheet
    private final TreeMap<String, String> sortedAS;
    
    //Constructor
    public Quiz(String TBp, String Ap){
        TBpath = TBp;
        Apath = Ap;
        
        //Inititalize HashMap
        AnswerSheet = new HashMap<>();
        
        //Initialize TreeMap
        sortedAS = new TreeMap<>();
        
        //Get start time
        startTime = System.currentTimeMillis();
        
        //Get timestamp
        Date date = new Date();
        SimpleDateFormat fdate = new SimpleDateFormat("MM.dd.yyyy_hh:mm:ss_a");
        timestamp = fdate.format(date);
    }
    
    //Run Quiz
    public void RunQuiz() throws IOException{
        //Get lines in TestBank (# of questions)
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(TBpath))) {
            while(reader.readLine() != null) lines++;
        }
        
        //Ask Questions
        for (int i = 0; i < questions; i ++){
            //Get random question & it's answer
            Random rand = new Random();
            int randline = rand.nextInt(lines) + 1;
            String question = Files.readAllLines(Paths.get(TBpath)).get(randline);
            String answer = Files.readAllLines(Paths.get(Apath)).get(randline);
            
            //Display question w/ answer choices
            String[] options = {"TRUE", "FALSE"};
            int useranswer = JOptionPane.showOptionDialog(null, question, ("Question #" + (i+1)), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
           
            //Add to HashMap
            String quest = "Question " + (i) + "\n";    //the question numbers will start at 0 for sorting purposes
            if (useranswer == 0){
                String keyT = quest + "Your Answer: True\n";
                AnswerSheet.put(keyT, answer);
            } else {
                String keyF = quest + "Your Answer: False\n";
                AnswerSheet.put(keyF, answer);
            }
            
            //Check answer & grade
            if (useranswer == 0) {
                if (answer.equals("TRUE")){
                    score += 10;
                }
            } else {
                if (answer.equals("FALSE")){
                    score += 10;
                }
            }
        }
        
        //If score ends up negative, reset to 0 (for grading purposes) 
            if (score < 0) {
                score = 0;
            }
            
        //Get end time
        endTime = System.currentTimeMillis();
        
    }
    
    //Sort and return AnswerSheet
    public TreeMap getAnswerSheet(){
        //Sort AnswerSheet by making it a TreeMap
        sortedAS.putAll(AnswerSheet);
        
        //return AnswerSheet 
        return(sortedAS);
    }
    
    //Get score
    public int getScore(){
        return score;
    }
    
    //Get elapsedTime
    public String getElapsedTime(){
        //Calculate elapsed time
        long elapTime = endTime - startTime;
        elapTime = elapTime/60000;  //convert from millis to minutes
        
        elapsedTime = "Quiz Duration: "+ String.valueOf(elapTime) + " minutes";
        
        return elapsedTime;
    }
    
    //Get timeStamp
    public String getTimestamp() {
        return timestamp;
    }
}

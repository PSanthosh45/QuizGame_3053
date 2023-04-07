
package quizgame_3035;

import java.awt.HeadlessException;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class Login {
    //Fields
    private final String path;
    private String username;
    private String password;
    private String name;
    private String role;
    
    Assets icons = new Assets();
    
    //Constructor
    public Login(String p){
        path = p;
    }
    
    //Login 
    public void LoginUP () throws IOException {
        //Prompt user for username
        username = JOptionPane.showInputDialog("What is your username?");
        
        //CHecker variables
        boolean found = false;
        int tries = 3;
        
        
        try{
            //Open UsersInfo
            try (Scanner userinfo = new Scanner(new File(path))) {
                //Get user info
                userinfo.useDelimiter("[,]");
                while(userinfo.hasNext() && !found){
                    String Fname = userinfo.next();
                    String Lname = userinfo.next();
                    String User = userinfo.next();
                    String Pass = userinfo.next();
                    String Role = userinfo.next();
                    
                    //Username verification
                    if(User.equals(username)){
                        found = true;
                        //Prompt for password
                        JPasswordField pwd = new JPasswordField();
                        pwd.setEchoChar('*');
                        int pass = JOptionPane.showConfirmDialog(null, pwd, "What is your password?",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                        String password = "";
                        if (pass == JOptionPane.OK_OPTION){
                            password = new String(pwd.getPassword());
                        }
                        //Password verification (3 tries)
                        while (!password.equals(Pass) && tries != 0){
                            JOptionPane.showMessageDialog(null, "Invalid password");
                            tries -= 1;
                            //Exit program after 3 tries
                            if (tries == 0){
                                ImageIcon impicon = icons.ImposterIcon();
                                JOptionPane.showMessageDialog(null,"IMPOSTER! \n You are not allowed in.","Imposter",JOptionPane.PLAIN_MESSAGE,impicon);
                                System.exit(0);
                            }
                            //Continued attempts
                            pass = JOptionPane.showConfirmDialog(null, pwd, "What is your password?",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                            if (pass == JOptionPane.OK_OPTION){
                                password = new String(pwd.getPassword());
                            }
                        }
                        //Grab role and name of user
                        role = Role;    
                        name = Fname + "_" + Lname;
                    }
                }
            }
        } catch (HeadlessException e) {
            System.out.println("Error");
        }
    }
    
    //Get username
    public String getUsername(){
        return username;
    }
    
    //Get name
    public String getName(){
        return name;
    }
    
    //Get role
    public String getRole(){
        return role;
    }
    
}


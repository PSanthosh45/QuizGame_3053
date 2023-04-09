# QuizGame_3053
By: Parvathy Santhosh

## What is it?
This is a Quiz program written entirely in Java that employs JOptionPane instead of command line outputs.
This app has three main functions:
1. Administer a quiz to a Student
2. Generate student report cards
3. Allow Instructor to perfrom the following functions:
  - Add quiz questions
  - Get student score statistics
  - Register a new student

## How does it work?
### QuizGame_3035.java
This is the main class of the program and calls the other classes. It also defines the path variables used in the rest of the program. 

### Login.java 
This class verifies the user and returns the necessary information of the user. This class uses UserInfo.txt, a file with data on the allowed users. 

### Quiz.java
This class administers the quiz of ten random questions from the TestBank. The program will display each question with a true or false option and calculate the students score. This class returns the score and timestamps for the duration of the quiz. 

### Report.java
The class both generates student report cards. These report cards can be displayed at the end of their quiz as well as append student grades to a file for use later in the program.

### Instructor.java
This class includes the methods for adding quiz questions, getting student score statistcs, and registering a new student.

### Assets.java
This class includes the icons used in the JOptionPane pop-ups throughout the 

## How to run it?
1. Make sure you have Java and a Java IDE downloaded
2. Download ALL files in this repository (with the exception of the README.md) and make sure they are all in the same folder/location
3. Replace path variables with the path that is specific to your computer
4. Open all .java files and run program according to your IDE

## Thank you!

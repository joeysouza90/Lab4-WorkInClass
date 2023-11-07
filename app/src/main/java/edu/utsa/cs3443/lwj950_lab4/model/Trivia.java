package edu.utsa.cs3443.lwj950_lab4.model;

import android.app.Activity;
import android.content.res.AssetManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Scanner;

public class Trivia {

    private String question;
    private String option1;
    private String option2;
    private String option3;

//    private String[] options = new String[3];
    private String descriptionAnswer;

    //Do we need to identify which answer is the correct one?
    private String correctAnswer;


    //need a method for correctAnswer

    public Trivia(String question, String option1, String option2, String option3, String descriptionAnswer) {
       this.question = question;

        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.descriptionAnswer = descriptionAnswer;
    }

    public Trivia() {
        System.out.println("Explicit default constructor");
    }

    //TODO: setters and getters
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getDescriptionAnswer() {
        return descriptionAnswer;
    }

    public void setDescriptionAnswer(String descriptionAnswer) {
        this.descriptionAnswer = descriptionAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }



    //method will return an object of trivia

    /**
     *
     * @param mainActivity
     * @return Trivia object
     * loadTrivia: this method takes in an activity from input as an argument, it reads the file
     * and stores 1 piece of trivia form that file
     */
    public Trivia loadTrivia(Activity activity) {
        //get an instance of asset manager
        //read the file in the assets folder using inputStream
        //how many lines are in this file, the number of lines are equivalent to the number of trivia questions
        //randomly select a random number smaller or equal to the number of lines
        //create an object of Trivia from that line's information
        //return the object

        AssetManager manager = activity.getAssets();
        Scanner scanner;

        try {
            InputStream input = manager.open("trivia.csv");
            scanner = new Scanner(input);
            int i = 0;

            while(scanner.hasNextLine()) {
                i++;
            }
            System.out.println("Number of lines: " + i);
            //randomly select a number from 1 to i
            SecureRandom sRandom = new SecureRandom(());
            //if i = 7 (number of lines in file -> a random number from 0 to 6
            int lineNumber = sRandom.nextInt(i) + 1; //secureRandom.nextInt will take upper bound

            int j = 1;

            while(j < lineNumber) {
                line = scanner.nextLine();
            }
            //when this loop is over, I am standing right by the line that i want to return

            line = scanner.nextLine();
            String[] lineSplit = line.trim().split(",");
            this.question = lineSplit[0].trim();
            this.option1 = lineSplit[1].trim();
            this.option2 = lineSplit[2].trim();
            this.option3 = lineSplit[3].trim();
            this.descriptionAnswer = lineSplit[4];
            //from index 4 forward, we have the description
            for(int k = 4; k < lineSplit.length; k++) {
                this.descriptionAnswer = this.descriptionAnswer + "," + lineSplit[k];
            }

            return (this);


        }catch(FileNotFoundException e) {   //subclass of IOException, subclass needs to be before superclass
            System.err.println("File not found");
        }catch(IOException e) {
            System.err.println("IO exception, which is a super class of FileNotFoundException"); //superclass
        }

        return (this);

    }

    private void identifyCorrectAnswer() {
        //takes all the options and checks if the description contains any of the options, if so, that option,
        //becomes the correctAnswer
    }

}




































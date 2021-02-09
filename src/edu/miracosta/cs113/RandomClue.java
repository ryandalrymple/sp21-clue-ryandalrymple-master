package edu.miracosta.cs113;
/********************************************
 * AUTHOR: Ryan Dalrymple
 * COURSE: CS 113 - Java
 * ASSIGNMENT: Clue
 * LAST MODIFIED: <02/04/21>
 ********************************************/
/*****************************************************************************
 * <RandomClue>
 *****************************************************************************
 * PROGRAM DESCRIPTION:
 * The purpose of this driver program is to create a solution where you guess the correct answer in <=20 attempts
 *****************************************************************************
 * ALGORITHM:
 * Hardcode all values == 1
 * if solution == 1, increment wep by 1
 * else if solution == 2, increment location by 1
 * else if solution == 3, increment murder by 1
 * longest to solve will always be theory 2 because it has the max values for each int, so it will always take 20 attempts
 *****************************************************************************
 * ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
 * N/A
 *****************************************************************************/


import java.util.Random;
import java.util.Scanner;
import model.Theory;
import model.AssistantJack;

public class RandomClue {

    public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int answerSet, solution, murder, weapon, location;
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        // INPUT
        System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);

        //trying incrementing by 1 each time below
        weapon = 1;
        location = 1;
        murder = 1;

        do {
            solution = jack.checkAnswer(weapon, location, murder);
            if(solution == 1)
            {
                weapon++;
            }
            else if(solution == 2)
            {
                location++;
            }
            else if(solution == 3)
            {
                murder++;
            }
        } while (solution != 0);

        answer = new Theory(weapon, location, murder);

        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!"); //hi
        }

    }

}
package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactorialExercise{

    private static boolean programRun = true;
    private static BufferedReader input;

    public static void main(String[] args){
        while(programRun) {
            factorial();
        }

        if(input != null){
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getInput(){
        String inputString = "";

        try {
            input = new BufferedReader(new InputStreamReader(System.in));
            inputString = input.readLine();
        } catch (IOException e) {
            e.getMessage();
        }

        return inputString;
    }

    private static void factorial(){
        System.out.print("\n00. to exit... \nWhat number do you want to find its factorial?: ");
        int num = Integer.parseInt(getInput());

        double fact = 1;

        if(num != 00){
            for(int i = num; i >= 1; i--){
                fact *= i;
            }
            System.out.println("Factorial of " + num + " = " + fact);

        }
        else if(num == 00){
            programRun = false;
        }


    }
}

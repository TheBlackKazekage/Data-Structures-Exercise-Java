package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloydTriangle {

    private static BufferedReader input;

    private static int counter = 1;

    private static boolean programRun = true;

    public static void main(String[] args) {
        while(programRun){
            floydTriangle();
        }

        if(input != null){
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void floydTriangle(){
        System.out.print("\n\n00. to exit... \nPlease enter the number of rows in your Floyd's triangle: ");

        int rowNum = Integer.parseInt(getInput());

        if(rowNum != 00){
            for(int i = 1; i <= rowNum; i++){
                for(int j = 1; j <= i; j++){
                    System.out.print(counter + " ");
                    counter++;
                }
                System.out.println();
            }
            counter = 1;
        }
        else if(rowNum == 00){
            programRun = false;
        }
    }

    private static String getInput(){
        String inputString = "";

        input = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputString = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputString;
    }
}

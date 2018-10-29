package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StackImplementation {
    private static boolean programRun = true;
    private static BufferedReader input;
    private static ArrayList<String> list;

    public static void main(String[] args) {
        list = new ArrayList<>();

        while(programRun) {
            stackImp();
        }

        if(input != null){
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void stackImp() {

        StackUsingArrayList customStack = new StackUsingArrayList(list);

        System.out.println("Below is the stack implementation: \n"
                +"1. Adding items into the stack. \n"
                +"2. Removing items from the stack. \n"
                +"3. Print items in the stack. \n\n"
                +"0. Exit");

        int choice = Integer.parseInt(getInput());
        switch (choice){
            case 1:
                System.out.print("How many items do you want to input into your stack?: ");
                int number = Integer.parseInt(getInput());

                System.out.println("What elements do you want to add in your stack?: ");

                for(int i = 0; i < number; i++){
                    customStack.push(getInput());
                }

                customStack.display();
                break;

            case 2:
                customStack.display();
                System.out.println("Popping last element...");
                customStack.pop();
                break;

            case 3:
                customStack.display();
                break;

            case 0:
                programRun = false;
                break;
            default:
                System.out.println("Please choose a valid option...");
                break;
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

}

class StackUsingArrayList{

    private ArrayList<String> mList;

    StackUsingArrayList(ArrayList<String> list) {
        mList = list;
    }

    void push(String t){
        mList.add(t);
    }

    void pop(){
        int len = mList.size();

        if(len > 0){
            mList.remove(len - 1);
            display();
        }
    }

    void display(){
        for(String s : mList){
            System.out.print(s + ", ");
        }

        System.out.println();
    }
}


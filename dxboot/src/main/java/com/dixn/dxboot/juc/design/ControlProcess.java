package com.dixn.dxboot.juc.design;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ControlProcess extends ProcessHook {
    @Override
    public void process2() {

        System.out.println("ControlProcess process2");

    }

    @Override
    public void process3() {

        System.out.println("ControlProcess process3");

    }

    @Override
    public boolean customerCondiments() {
        String answer = getUserInput();
        return answer.toLowerCase().startsWith("y");
    }

    private String getUserInput() {
        String answer = null;

        System.out.println("Would you like milk and sugar with your coffee(y/n)? ");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            System.out.println("IO error trying to read your answer");
        }

        if (answer == null) {
            return "no";
        }

        return answer;
    }
}

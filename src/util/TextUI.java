package util;

import java.util.Scanner;

public class TextUI {
    private static Scanner sc = new Scanner(System.in);

    public String getUserInput(String prompt){
        System.out.println(prompt);
        return sc.nextLine();
    }
    public void showMessage(String message){
        System.out.println(message);
    }
    public String promptForUsername(){
        System.out.println("Username: ");
        return sc.nextLine();// indtil nu

    }
    public String promptForPassword(){
        System.out.println("Password: ");
        return sc.nextLine(); // indtil nu

    }
}
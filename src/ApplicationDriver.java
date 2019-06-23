package wmadp201_assginment4_group.src;

import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationDriver {
    public static void main(String[] args) {
        System.out.println(getLoginViewText());
        Scanner reader = new Scanner(System.in);
        String userName = reader.nextLine();
        String passWord = reader.nextLine();
    }

    private static void printTextArray(ArrayList<String> text) {
        for (String s: text) {
            System.out.println(s);
        }
    }

    private static String getLoginViewText() {

        String txt = "************************************************************\n" +
                "Please enter your account to login:\n" +
                "************************************************************\n" +
                "Username:\n" +
                "Password:\n" +
                "\n" +
                "----------------\n" +
                "Not registered yet? Type “Register” and press enter to start the registration process!\n" +
                "";

        return txt;
    }

    private static String getUncorrectInfoViewText() {
        String txt = "************************************************************\n" +
                "Welcome to Cornerstone International College of Canada.\n" +
                "************************************************************";

        return txt;
    }

    private static String getCorrectInfoViewText() {
        String txt = "************************************************************\n" +
                "Your account does not exist. Please try again!\n" +
                "************************************************************";

        return txt;
    }
}

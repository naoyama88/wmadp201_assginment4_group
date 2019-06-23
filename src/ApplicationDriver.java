package wmadp201_assginment4_group.src;

import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationDriver {
    public static void main(String[] args) {
        System.out.println(getLoginViewText());
        Scanner reader = new Scanner(System.in);
        String userName = reader.nextLine();
        // TODO if name is
        if (userName.equals("Register")) {
            // TODO move to resister
        }
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

    private static String getRegisterViewText() {
        String txt = "************************************************************\n" +
                "Welcome to CornerstoneInternational College of Canada.\n" +
                "************************************************************\n" +
                "Please enter your first name:\n" +
                "Please enter your last name:\n" +
                "Please enter your gender [M/F]:\n" +
                "Please enter your country of origin:\n" +
                "Please enter the year of admission:\n" +
                "Please enter your age:\n" +
                "Please enter a username [At least 6 characters]:\n" +
                "Please enter a username [At least 6 characters with at least one digit]:\n";

        return txt;
    }

    private static String getMainMenuViewText() {
        String txt = "************************************************************\n" +
                "Select from the options:\n" +
                "************************************************************\n" +
                "—-[1] Print my enrolment certificate\n" +
                "—-[2] Print my courses\n" +
                "—-[3] Print my transcript\n" +
                "—-[4] Print my GPA\n" +
                "—-[5] Print my ranking among all students in the college\n" +
                "—-[6] List all available courses\n" +
                "—-[7] List all students\n" +
                "—-[8] Show My Profile\n" +
                "-—[9] Logout\n" +
                "-—[10] Exit\n" +
                "\n" +
                "************************************************************\n" +
                "Enter the number corresponding to each item to proceed:";

        return txt;
    }
}

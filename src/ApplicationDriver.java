package wmadp201_assginment4_group.src;

import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationDriver {

    private static ArrayList<Student> students;
    private static Student currentUser;

    public static void main(String[] args) {

        // TODO prepare sample data
        students = new ArrayList<>();

        boolean isEnd = false;
        while (!isEnd) {
            currentUser = null;
            isEnd = startSystem();
        }
    }

    private static boolean startSystem() {

        System.out.println(getLoginViewText());
        System.out.print("user name: ");
        Scanner reader = new Scanner(System.in);
        String userName = reader.nextLine();
        if (userName.equals("Register")) {
            register();

        } else {
            System.out.print("password: ");
            String password = reader.nextLine();
            Student student;
            boolean isCorrectLoginInfo = isRegisteredStudent(userName, password);
            if (!isCorrectLoginInfo) {
                System.out.println(getUncorrectInfoViewText());
                return false;
            } else {
                student = getStudent(userName, password);
            }

            currentUser = student;
        }

        System.out.println(getCorrectInfoViewText());

        boolean isEnd = false;
        while(currentUser != null) {
            isEnd = startMainMenu();
        }

        return isEnd;
    }

    private static boolean startMainMenu() {

        Scanner reader = new Scanner(System.in);
        String number;

        while(true) {
            System.out.print(getMainMenuViewText());
            number = reader.nextLine();
            switch (number) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                    // TODO dev
                    break;
                case "9":
                    currentUser = null;
                    return false;
                case "10":
                    currentUser = null;
                    return true;
                default:
                    // TODO continue

            }

        }
    }

    private static void register() {
        System.out.println(getRegisterViewText());

        Scanner reader = new Scanner(System.in);
        System.out.print("first name: ");
        String firstName = reader.nextLine();

        System.out.print("last name: ");
        String lastName = reader.nextLine();

        String gender = "";
        while(true) {
            System.out.print("gender [M/F]: ");
            gender = reader.nextLine();
            if (gender.equals("M") || gender.equals("F")) {
                // success
                break;
            }
            System.out.println("Sorry we don't correspond for other gender. Please input M or F.");
        }

        System.out.print("country of origin: ");
        String country = reader.nextLine();

        System.out.print("address: ");
        String address = reader.nextLine();

        System.out.print("year of admission: ");
        String admission = reader.nextLine();

        System.out.print("age: ");
        String age = reader.nextLine();

        String userName = "";
        while(true) {
            System.out.print("username [At least 6 characters]: ");
            userName = reader.nextLine();
            if (userName.length() < 6) {
                System.out.println("You must input username at least 6 characters.");
                continue;
            }
            break;
        }

        String password = "";
        while(true) {
            System.out.print("Please enter a password [At least 6 characters with at least one digit: ");
            password = reader.nextLine();
            int length = password.length();
            if (length < 6) {
                System.out.println("You must input username at least 6 characters.");
                continue;
            }

            boolean hasDigit = false;
            for (int i = 0; i < length; i++) {
                boolean isDigit = Character.isDigit(password.charAt(i));
                if (isDigit) {
                    hasDigit = true;
                }
            }

            if (hasDigit) {
                break;
            }

            System.out.println("Password must include at least one digit.");
        }

        StudentProfile sp = new StudentProfile(firstName, lastName, gender, country, address, age, admission);
        Account account = new Account(userName, password);
        Student student = new Student(sp, account);
        students.add(student);
        currentUser = student;
    }

    private static boolean isRegisteredStudent(String userName, String password) {
        if (students == null) {
            return false;
        }
        for (Student student: students) {
            if (student.getUserName().equals(userName) && student.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    private static Student getStudent(String userName, String password) {

        for (Student student : students) {
            if (student.getUserName().equals(userName) && student.getPassword().equals(password)) {
                return student;
            }
        }

        throw new IllegalArgumentException("Student supposes to exist in ArrayList of student as field variable.");
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

    private static String getCorrectInfoViewText() {
        String txt = "************************************************************\n" +
                "Welcome to Cornerstone International College of Canada.\n" +
                "************************************************************\n";

        return txt;
    }

    private static String getUncorrectInfoViewText() {
        String txt = "************************************************************\n" +
                "Your account does not exist. Please try again!\n" +
                "************************************************************\n";

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
                "Please enter your address:\n" +
                "Please enter the year of admission:\n" +
                "Please enter your age:\n" +
                "Please enter a username [At least 6 characters]:\n" +
                "Please enter a password [At least 6 characters with at least one digit]:\n";

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

    private static void setSampleData() {

    }
}

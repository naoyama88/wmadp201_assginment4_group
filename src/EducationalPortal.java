package wmadp201_assginment4_group.src;

import java.util.ArrayList;
import java.util.Scanner;

public class EducationalPortal {

    private static int previousStudentsId;
    private ArrayList<Account> accounts;
    private Account currentAccount;

    public EducationalPortal() {
        this.accounts = new ArrayList<>();
        this.currentAccount = null;
    }

    public void start() {

        boolean isEnd = false;
        while (!isEnd) {
            this.currentAccount = null;
            isEnd = startSystem();
        }

    }

    public static int getStudentId() {
        return ++previousStudentsId;
    }

    private boolean startSystem() {

        System.out.println(getLoginViewText());
        System.out.print("user name: ");
        Scanner reader = new Scanner(System.in);
        String userName = reader.nextLine();
        if (userName.equals("Register")) {
            registerStudent();

        } else {
            System.out.print("password: ");
            String password = reader.nextLine();
            Account account;
            boolean isCorrectLoginInfo = isRegisteredUser(userName, password);
            if (!isCorrectLoginInfo) {
                System.out.println(getUncorrectInfoViewText());
                return false;
            } else {
                account = getAccount(userName, password);
            }

            this.currentAccount = account;
        }

        System.out.println(getWelcomeText());
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        boolean isEnd = false;
        while(this.currentAccount != null) {
            isEnd = startMainMenu();
        }

        return isEnd;
    }

    private boolean startMainMenu() {

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
                    // TODO Atsushi
                    System.out.println("Do something.");
                    break;
                case "9":
                    this.currentAccount = null;
                    return false;
                case "10":
                    this.currentAccount = null;
                    return true;
                default:
                    System.out.println("Please input number between 1 and 10.");
                    System.out.println("");

            }

        }
    }

    private void registerStudent() {
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
        Student student = new Student(sp);
        Account account = new Account(userName, password, student);
        this.accounts.add(account);
        this.currentAccount = account;
    }

    private boolean isRegisteredUser(String userName, String password) {
        if (this.accounts == null) {
            return false;
        }
        for (Account account: this.accounts) {
            if (account.getUserName().equals(userName) && account.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    private Account getAccount(String userName, String password) {

        for (Account account : this.accounts) {
            if (account.getUserName().equals(userName) && account.getPassword().equals(password)) {
                return account;
            }
        }

        throw new IllegalArgumentException("Student supposes to exist in ArrayList of student as field variable.");
    }

    private String getLoginViewText() {

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

    private String getWelcomeText() {
        String txt = "************************************************************\n" +
                "Welcome to Cornerstone International College of Canada.\n" +
                "************************************************************\n";

        return txt;
    }

    private String getUncorrectInfoViewText() {
        String txt = "************************************************************\n" +
                "Your account does not exist. Please try again!\n" +
                "************************************************************\n";

        return txt;
    }

    private String getRegisterViewText() {
        String txt = "\n************************************************************\n" +
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

    private String getMainMenuViewText() {
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

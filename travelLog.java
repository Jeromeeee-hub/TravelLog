import java.util.Scanner;

public class travelLog {

    static Scanner s = new Scanner(System.in);
    static String fName;
    static String uName;
    static String email;
    static String number;
    static String pass;
    static String confirmPass;

    public static void main(String[] args) {
        System.out.println("Travel Log");
        System.out.println("[1] Sign Up \n[2] Sign In");
        int userInput = s.nextInt();
        s.nextLine();
        System.out.println();
        switch (userInput) {
            case 1:
                System.out.println("Sign Up");
                System.out.println("Please Fill Up The Following.");

                do {
                    System.out.println();
                    System.out.println(
                        "Full Name Must Contain 5-80 Characters"
                    );
                    System.out.print("Enter Full Name: ");
                    fName = s.nextLine();
                    System.out.println();
                    if (
                        fName.length() < 5 ||
                        fName.length() > 80 ||
                        fName.isBlank() ||
                        fName.matches(".*[0-9].*")
                    ) System.out.println(
                        "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                    );
                } while (
                    fName.length() < 5 ||
                    fName.length() > 80 ||
                    fName.isBlank() ||
                    fName.matches(".*[0-9].*")
                );

                do {
                    System.out.println(
                        "User Name Must Contain 8-50 Characters And No Special Characters Or Spaces Are Allowed."
                    );
                    System.out.print("Enter User Name: ");
                    uName = s.nextLine();
                    System.out.println();
                    if (
                        uName.length() < 8 ||
                        uName.length() > 50 ||
                        !uName.matches("^[a-zA-Z0-9]+$") ||
                        uName.isBlank()
                    ) System.out.println(
                        "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                    );
                } while (
                    uName.length() < 8 ||
                    uName.length() > 50 ||
                    !uName.matches("^[a-zA-Z0-9]+$") ||
                    uName.isBlank()
                );

                do {
                    System.out.println(
                        "Email Address Must Follow The Email Adress Pattern And Must Not Exceed 30 Characters"
                    );
                    System.out.print("Enter Email Address: ");
                    email = s.nextLine();
                    System.out.println();
                    if (
                        !email.contains("@gmail.com") ||
                        email.length() > 30 ||
                        email.isBlank()
                    ) System.out.println(
                        "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                    );
                } while (
                    !email.contains("@gmail.com") ||
                    email.length() > 30 ||
                    email.isBlank()
                );

                do {
                    System.out.println(
                        "Mobile Number Must Contain Exactly 11 Numbers And Must Start With 0"
                    );
                    System.out.print("Enter Mobile Number: ");
                    number = s.nextLine();
                    System.out.println();
                    if (
                        !number.matches("^[0-9]+$") ||
                        number.isBlank() ||
                        number.charAt(0) != '0' ||
                        number.length() != 11
                    ) System.out.println(
                        "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                    );
                } while (
                    !number.matches("^[0-9]+$") ||
                    number.isBlank() ||
                    number.charAt(0) != '0' ||
                    number.length() != 11
                );

                do {
                    System.out.println(
                        "Password Must Contain 8-20 Characters, Must Contain At Least: 1 Uppercase Letter, 1 Lowercase Letter, 1 Number, And 1 Special Character"
                    );
                    System.out.print("Enter Password:");
                    pass = s.nextLine();
                    do {
                        System.out.print("Confirmation: ");
                        confirmPass = s.nextLine();
                    } while (!pass.equals(confirmPass));
                    if (
                        pass.length() < 8 ||
                        pass.length() > 20 ||
                        !pass.matches("^[a-zA-Z0-9!@#$%&*.]+$") ||
                        !pass.matches(".*[A-Z].*") ||
                        !pass.matches(".*[0-9].*") ||
                        !pass.matches(".*[a-z].*") ||
                        !pass.matches(".*[!@#$%&*.].*") ||
                        pass.isBlank()
                    ) System.out.println(
                        "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                    );
                } while (
                    pass.length() < 8 ||
                    pass.length() > 20 ||
                    !pass.matches("^[a-zA-Z0-9!@#$%&*.]+$") ||
                    !pass.matches(".*[A-Z].*") ||
                    !pass.matches(".*[0-9].*") ||
                    !pass.matches(".*[a-z].*") ||
                    !pass.matches(".*[!@#$%&*.].*") ||
                    pass.isBlank()
                );
                User p = new User(fName, uName, email, number, pass);
                System.out.println();
                System.out.println(
                    "Account Created Succesfuly, Now Proceeding To Log In"
                );
                System.out.println();
            case 2:
                System.out.println("Log In");
                System.out.println("Please Fill Up the Following");
                System.out.println();
                int attempts = 3;
                do {
                    System.out.print("Enter Username: ");
                    String loginUser = s.nextLine();
                    System.out.print("Enter Password: ");
                    String loginPass = s.nextLine();
                    if (loginUser.equals(uName) && loginPass.equals(pass)) {
                        System.out.println("Log In Succesful");
                        System.out.println();
                        menu();
                        break;
                    } else if (
                        !loginUser.equals(uName) || !loginPass.equals(pass)
                    ) {
                        attempts--;
                        System.out.println(
                            "Invalid User Name Or Password, Please Try Again " +
                                attempts +
                                " Remaining"
                        );
                        if (attempts == 0) {
                            System.out.println(
                                "Login Unsuccessful, Please Try Again Later. Type \"Okay\" To Terminate"
                            );
                            s.nextLine();
                            break;
                        }
                        System.out.println();
                    }
                } while (attempts > 0);
                break;
            default:
                System.out.println("Input Out Of Reach");
                break;
        }
    }

    static void menu() {
        int userInput;
        do {
            System.out.println(
                "=================================================="
            );
            System.out.println(
                "     Personal Travel Management System Menu       "
            );
            System.out.println(
                "==================================================\n"
            );
            System.out.println("Welcome, <" + fName + ">!\n");
            System.out.println(
                "[1] Add Travel Log\n" +
                    "[2] Add Trip Plan\n" +
                    "[3] Modify Travel Log\n" +
                    "[4] Modify Trip Plan\n" +
                    "[5] Delete Travel Log\n" +
                    "[6] Delete Trip Plan\n" +
                    "[7] Display User\n" +
                    "[8] Display Records By Username\n" +
                    "[9] Display All Travel Logs\n" +
                    "[10] Display All Trip Plans\n" +
                    "[11] Search Travel Log\n" +
                    "[12] Search Trip Plan\n" +
                    "[13] Export\n" +
                    "[14] Import\n" +
                    "[15] Exit\n"
            );
            System.out.print("Enter Choice: ");
            userInput = s.nextInt();
            if (userInput < 1 || userInput > 15) System.out.println(
                "Invalid Input, Please Choose Among The Choices Only."
            );
            System.out.println();
            switch (userInput) {
                case 1:
                    addTravelLog();
                    break;
                default:
                    break;
            }
        } while (userInput != 15);
    }

    static void addTravelLog() {
        System.out.println("Add Travel Log");
    }
}

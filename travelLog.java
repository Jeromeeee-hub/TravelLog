import java.util.Scanner;

public class travelLog {

    static Scanner s = new Scanner(System.in);
    static TravelLogObject[] log = new TravelLogObject[50];
    static tripPlan[] trip = new tripPlan[20];
    static User p;
    static int logCount = 0;
    static int tripCount = 0;

    public static void main(String[] args) {
        String fName;
        String uName;
        String email;
        String number;
        String pass;
        String confirmPass;
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
                        isinValidLength(fName, 5, 80) ||
                        fName.isBlank() ||
                        fName.matches(".*[0-9].*")
                    ) System.out.println(
                        "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                    );
                } while (
                    isinValidLength(fName, 5, 80) ||
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
                        isinValidLength(uName, 8, 50) ||
                        !uName.matches("^[a-zA-Z0-9]+$") ||
                        uName.isBlank()
                    ) System.out.println(
                        "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                    );
                } while (
                    isinValidLength(uName, 8, 50) ||
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
                        isinValidLength(email, 1, 30) ||
                        email.isBlank()
                    ) System.out.println(
                        "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                    );
                } while (
                    !email.contains("@gmail.com") ||
                    isinValidLength(email, 1, 30) ||
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
                        isinValidLength(number, 11, 11)
                    ) System.out.println(
                        "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                    );
                } while (
                    !number.matches("^[0-9]+$") ||
                    number.isBlank() ||
                    number.charAt(0) != '0' ||
                    isinValidLength(number, 11, 11)
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
                        isinValidLength(pass, 8, 20) ||
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
                    isinValidLength(pass, 8, 20) ||
                    !pass.matches("^[a-zA-Z0-9!@#$%&*.]+$") ||
                    !pass.matches(".*[A-Z].*") ||
                    !pass.matches(".*[0-9].*") ||
                    !pass.matches(".*[a-z].*") ||
                    !pass.matches(".*[!@#$%&*.].*") ||
                    pass.isBlank()
                );
                p = new User(fName, uName, email, number, pass);
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
                    if (
                        loginUser.equals(p.userName) &&
                        loginPass.equals(p.passW)
                    ) {
                        System.out.println("Log In Succesful");
                        System.out.println();
                        menu(p.fullName);
                        break;
                    } else if (
                        !loginUser.equals(p.userName) ||
                        !loginPass.equals(p.passW)
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

    static void menu(String name) {
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
            System.out.println("Welcome, <" + name + ">!\n");
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
            userInput = numOnly();
            System.out.println();

            if (userInput < 1 || userInput > 15) {
                System.out.println(
                    "Invalid Input, Please Choose Among The Choices Only."
                );
            } else {
                menuFunction(userInput);
            }
        } while (userInput != 15);
    }

    static void menuFunction(int x) {
        switch (x) {
            case 1:
                addTravelLog();
                break;
            case 2:
                tripPlan();
                break;
            case 3:
                modifyTravelLog();
                break;
            default:
                break;
        }
    }

    static void addTravelLog() {
        String destiName;
        String destiType;
        int numOfVisits;
        String firstDateVisited;
        String location;
        String travelexp;
        if (logCount == 50) {
            System.out.println(
                "Travel Log, Already Contains 50 Logs, You Can't Add Anymore."
            );
            return;
        }

        System.out.println(
            "==================================================\n"
        );
        System.out.println("[1] Add Travel Log Menu");
        System.out.println(
            "==================================================\n"
        );
        do {
            System.out.println(
                "Destination Name Must Contain 3-50 Characters, And Must Be Unique, No Duplicates Allowed\nExample: Kapehan Sa Baguio"
            );
            System.out.print("Enter Destination Name: ");
            destiName = s.nextLine();
            System.out.println();
            if (isDuplicate(destiName, logCount, log)) System.out.println(
                "Destination Name \"" +
                    destiName +
                    "\" Is Already Stored, Please Use Another Name."
            );
            if (
                isinValidLength(destiName, 3, 50) ||
                destiName.isBlank() ||
                !destiName.matches("^[a-zA-Z0-9 ]+$")
            ) System.out.println(
                "Invalid Input, Please Try Again. Follow The Instructions Below\n"
            );
        } while (
            destiName.isBlank() ||
            isinValidLength(destiName, 3, 50) ||
            isDuplicate(destiName, logCount, log) ||
            !destiName.matches("^[a-zA-Z0-9 ]+$")
        );

        do {
            System.out.println(
                "Destination Type\nb = Beach, m = Mountain, c = city, h = Historical Site, o = Other.\n(Case Sensitive)"
            );
            System.out.print(
                "Enter Destination Type Of " + destiName + " Trip: "
            );
            destiType = s.nextLine();
            System.out.println();
            if (!destiType.matches("[bmcho]")) System.out.println(
                "Invalid Input, Please Try Again. Follow The Instructions Below\n"
            );
        } while (!destiType.matches("[bmcho]"));

        do {
            System.out.println("Number Of Visits Must Not Be Less Than 1");
            System.out.print(
                "Enter Number Of Visits In " + destiName + " Trip: "
            );
            numOfVisits = numOnly();
            System.out.println();
            s.nextLine();
            System.out.println();
            if (!isPositive(numOfVisits)) System.out.println(
                "Invalid Input, Please Try Again. Follow The Instructions Below\n"
            );
        } while (!isPositive(numOfVisits));

        do {
            System.out.println(
                "Date First Visited Must Follow The Format \"mm/dd/yyyy\", And Must Contain Exactly 8 Numbers And 2 / Characters"
            );
            System.out.print(
                "Enter First Date Visited Of The Trip " + destiName + ": "
            );
            firstDateVisited = s.nextLine();
            System.out.println();
            if (
                isinValidLength(firstDateVisited, 10, 10) ||
                !firstDateVisited.matches("\\d{2}/\\d{2}/\\d{4}")
            ) System.out.println(
                "Invalid Input, Please Try Again. Follow The Instructions Below\n"
            );
        } while (
            isinValidLength(firstDateVisited, 10, 10) ||
            !firstDateVisited.matches("\\d{2}/\\d{2}/\\d{4}")
        );
        do {
            System.out.println(
                "Location Name Must Not Exceed 30 Characters, Specific Location Of Destination\nExample: Baguio"
            );
            System.out.print("Enter Location: ");
            location = s.nextLine();
            System.out.println();
            if (
                isinValidLength(location, 0, 30) || location.isBlank()
            ) System.out.println(
                "Invalid Input, Please Try Again. Follow The Instructions Below\n"
            );
        } while (isinValidLength(location, 0, 30) || location.isBlank());

        do {
            System.out.println(
                "Travel Experience Contains The User's Overall Experience, Impression, Notes About The Destination.\nMust Not Be Empty And Must Not Exceed 300 Characters."
            );
            travelexp = s.nextLine();
            System.out.println();
            if (
                isinValidLength(travelexp, 0, 300) || travelexp.isBlank()
            ) System.out.println(
                "Invalid Input, Please Try Again. Follow The Instructions Below\n"
            );
        } while (isinValidLength(travelexp, 0, 300) || travelexp.isBlank());
        log[logCount] = new TravelLogObject(
            destiName,
            destiType,
            numOfVisits,
            firstDateVisited,
            location,
            travelexp
        );
        System.out.println(
            "Log \"" + log[logCount].destinationName + "\" Has Been Saved!"
        );
        logCount++;
    }

    static void tripPlan() {
        String tripName;
        String tripDescription;
        int tripPrepTime;
        int tripTravelTime;
        int tripNumActivities;
        int tripNumInstructions;

        if (tripCount == 20) {
            System.out.println(
                "Trip Plan Already Contains 20 Plans, You Can't Add Anymore"
            );
            return;
        }
        System.out.println(
            "==================================================\n"
        );
        System.out.println("[2] Add Trip Plan Menu");
        System.out.println(
            "==================================================\n"
        );
        do {
            System.out.println(
                "Trip Name Must Contain 3-50 Characters, And Must Be Unique, No Duplicates Allowed\nExample: Pahinga Sa Japan"
            );
            System.out.print("Enter Trip Name: ");
            tripName = s.nextLine();
            System.out.println();
            if (IsDuplicate(tripName, tripCount, trip)) System.out.println(
                "Trip Name \"" +
                    tripName +
                    "\" Is Already Stored, Please Use Another Name."
            );
            if (
                IsDuplicate(tripName, tripCount, trip) ||
                tripName.isBlank() ||
                isinValidLength(tripName, 3, 50) ||
                !tripName.matches("^[a-zA-Z0-9 ]+$")
            ) System.out.println(
                "Invalid Input, Please Try Again. Follow The Instructions Below\n"
            );
        } while (
            tripName.isBlank() ||
            IsDuplicate(tripName, tripCount, trip) ||
            isinValidLength(tripName, 3, 50) ||
            !tripName.matches("^[a-zA-Z0-9 ]+$")
        );

        do {
            System.out.println(
                "Trip Description Describe The Purpose Or Overall Plan For The Trip. Must Not Be Empty And Must Not Exceed 160 Characters"
            );
            System.out.print("Enter Trip Description: ");
            tripDescription = s.nextLine();
            System.out.println();
            if (
                tripDescription.isBlank() ||
                isinValidLength(tripDescription, 1, 160)
            ) System.out.println(
                "Invalid Input, Please Try Again. Follow The Instructions Below\n"
            );
        } while (
            tripDescription.isBlank() ||
            isinValidLength(tripDescription, 1, 160)
        );

        do {
            System.out.println(
                "Preperation Time, Represents The Estimated Preperation Time. Must Not Be Less Than 1"
            );
            System.out.print("Enter Preperation Time (In Minutes): ");
            tripPrepTime = numOnly();
            s.nextLine();
            System.out.println();
            if (!isPositive(tripPrepTime)) System.out.println(
                "Invalid Input, Please Try Again. Follow The Instructions Below\n"
            );
        } while (!isPositive(tripPrepTime));

        do {
            System.out.println(
                "Travel Time, Represents The Estimated Travel Time, Must Not Be Less Than 1"
            );
            System.out.print("Enter Travel Time (In Minutes): ");
            tripTravelTime = numOnly();
            System.out.println();
            s.nextLine();
            if (!isPositive(tripTravelTime)) System.out.println(
                "Invalid Input, Please Try Again. Follow The Instructions Below\n"
            );
        } while (!isPositive(tripTravelTime));

        do {
            System.out.println(
                "Number Of Activities You Will Do In Your Trip, Must Not Be More Than 20"
            );
            System.out.print("Enter Number Of Activities: ");
            tripNumActivities = numOnly();
            s.nextLine();
            System.out.println();
            if (
                !isPositive(tripNumActivities) || tripNumActivities > 20
            ) System.out.println(
                "Invalid Input, Please Try Again. Follow The Instructions Below\n"
            );
        } while (!isPositive(tripNumActivities) || tripNumActivities > 20);

        String[] tripListActivities = new String[tripNumActivities];

        for (int i = 0; i < tripNumActivities; i++) {
            do {
                System.out.println(
                    "Trip Activity Must Not Be Empty, And Must Not Exceed 80 Characters"
                );

                System.out.print("Enter Activity " + (i + 1) + ": ");
                tripListActivities[i] = s.nextLine();

                if (
                    tripListActivities[i].isBlank() ||
                    isinValidLength(tripListActivities[i], 1, 80)
                ) {
                    System.out.println(
                        "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                    );
                }
            } while (
                tripListActivities[i].isBlank() ||
                isinValidLength(tripListActivities[i], 1, 80)
            );
        }
        System.out.println();
        do {
            System.out.println(
                "Enter Number Of Instructions You Will Follow, Must Not Be Less Than 1 And Not More Than 20"
            );
            System.out.print("Enter Number Of Instructions: ");
            tripNumInstructions = numOnly();
            System.out.println();
            s.nextLine();
            if (
                !isPositive(tripNumInstructions) || tripNumInstructions > 20
            ) System.out.println(
                "Invalid Input, Please Try Again. Follow The Instructions Below\n"
            );
        } while (!isPositive(tripNumInstructions) || tripNumInstructions > 20);

        String tripInstructions[] = new String[tripNumInstructions];
        for (int i = 0; i < tripNumInstructions; i++) {
            do {
                System.out.println(
                    "Trip Instructions Must Not Be Empty, And Must Not Exceed 100 Characters."
                );
                System.out.print("Enter Trip Instructions" + (i + 1) + ": ");
                tripInstructions[i] = s.nextLine();
                if (
                    tripInstructions[i].isBlank() ||
                    isinValidLength(tripInstructions[i], 1, 100)
                ) System.out.println(
                    "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                );
            } while (
                tripInstructions[i].isBlank() ||
                isinValidLength(tripInstructions[i], 1, 100)
            );
        }
        trip[tripCount] = new tripPlan(
            tripName,
            tripDescription,
            tripPrepTime,
            tripTravelTime,
            tripNumActivities,
            tripListActivities,
            tripNumInstructions,
            tripInstructions
        );
        System.out.println(
            "Trip \"" + trip[tripCount].planName + "\" Has Been Saved!"
        );
        tripCount++;
    }

    static void modifyTravelLog() {
        int modifyLogIndex;
        int logField;
        System.out.println(
            "==================================================\n"
        );
        System.out.println("[3] Modify Travel Log Menu");
        System.out.println(
            "==================================================\n"
        );
        System.out.println("Searching " + p.userName + "'s Travel Log");
        if (logCount == 0) System.out.println(
            "Theres No Recorded Travel Log In The User Name \"" +
                p.userName +
                "\""
        );
        System.out.println(p.userName + " Travel Log History:");
        System.out.println();
        for (int i = 0; i < logCount; i++) {
            System.out.println(
                "Destination Name [" + (i + 1) + "]: " + log[i].destinationName
            );
        }
        System.out.println("Please Select A Travel Log You Want To Modify");
        System.out.print("Enter The Travel Log You Want To Modify: ");
        modifyLogIndex = numOnly();
        s.nextLine();
        int logIndex = modifyLogIndex - 1;
        System.out.println();
        System.out.println(
            "Modifying Travel Log: " + log[logIndex].destinationName
        );
        do {
            System.out.println(
                "Please Choose A Field Of Travel Log \"" +
                    log[logIndex].destinationName +
                    "\" You Want to Modify"
            );
            System.out.println(
                "[1] Destination Name \n[2] Destination Type \n[3] Number Of Visits \n[4] Date First Visited \n[5] Location \n[6] Travel Experience \n[7] Finish Modifying"
            );
            logField = numOnly();
            s.nextLine();
            System.out.println();
            switch (logField) {
                case 1:
                    String newDestiName;
                    System.out.println(
                        "Modifying Destination Name " +
                            log[logIndex].destinationName
                    );
                    do {
                        System.out.println(
                            "Destination Name Must Contain 3-50 Characters, And Must Be Unique, No Duplicates Allowed\nExample: Kapehan Sa Baguio"
                        );
                        System.out.print("Enter New Destination Name: ");
                        newDestiName = s.nextLine();
                        System.out.println();
                        if (
                            isDuplicate(newDestiName, logCount, log)
                        ) System.out.println(
                            "Destination Name \"" +
                                newDestiName +
                                "\" Is Already Stored, Please Use Another Name."
                        );
                        if (
                            isinValidLength(newDestiName, 3, 50) ||
                            newDestiName.isBlank() ||
                            !newDestiName.matches("^[a-zA-Z0-9 ]+$")
                        ) System.out.println(
                            "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                        );
                    } while (
                        isinValidLength(newDestiName, 3, 50) ||
                        isDuplicate(newDestiName, logCount, log) ||
                        newDestiName.isBlank() ||
                        !newDestiName.matches("^[a-zA-Z0-9 ]+$")
                    );
                    log[logIndex].destinationName = newDestiName;
                    System.out.println(
                        "Destination Name Has Been Successfully Changed To " +
                            log[logIndex].destinationName
                    );
                    break;
                default:
                    break;
            }
        } while (logField != 7);
    }

    static boolean isinValidLength(String text, int min, int max) {
        return text.length() < min || text.length() > max;
    }

    static boolean isPositive(int x) {
        return x >= 1;
    }

    static boolean isDuplicate(
        String currentName,
        int count,
        TravelLogObject[] array
    ) {
        boolean duplicate = false;
        for (int i = 0; i < count; i++) {
            if (currentName.equals(array[i].destinationName)) {
                duplicate = true;
                break;
            }
        }
        return duplicate;
    }

    static boolean IsDuplicate(
        String currentName,
        int count,
        tripPlan[] array
    ) {
        boolean duplicate = false;
        for (int i = 0; i < count; i++) {
            if (currentName.equals(array[i].planName)) {
                duplicate = true;
                break;
            }
        }
        return duplicate;
    }

    static int numOnly() {
        while (!s.hasNextInt()) {
            System.out.println("Invalid Input, Please Enter An Number.");
            s.next();
        }

        return s.nextInt();
    }
}
class tripPlan {

    String planName, planDescription, tripListActivities[], planInstructions[];
    int planPrepTime, planTravelTime, planActivities, planNumInstructions;

    tripPlan(
        String planName,
        String planDescription,
        int planPrepTime,
        int planTravelTime,
        int planActivities,
        String tripListActivities[],
        int planNumInstructions,
        String planInstructions[]

    ) {
        this.planName = planName;
        this.planDescription = planDescription;
        this.planPrepTime = planPrepTime;
        this.planTravelTime = planTravelTime;
        this.planActivities = planActivities;
        this.tripListActivities = tripListActivities;
        this.planNumInstructions = planNumInstructions;
        this.planInstructions = planInstructions;
    }
}
class TravelLogObject {

    String destinationName, destinationType, dateVisited, location, travelExp;
    int visits;

    TravelLogObject(
        String destinationName,
        String destinationType,
        int visits,
        String dateVisited,
        String location,
        String travelExp
    ) {
        this.destinationName = destinationName;
        this.destinationType = destinationType;
        this.visits = visits;
        this.dateVisited = dateVisited;
        this.location = location;
        this.travelExp = travelExp;
    }
}

class User {

    String userName, fullName, emailAddr, passW, mobNumber;

    User(
        String fullName,
        String userName,
        String emailAddr,
        String mobNumber,
        String passW
    ) {
        this.fullName = fullName;
        this.userName = userName;
        this.emailAddr = emailAddr;
        this.mobNumber = mobNumber;
        this.passW = passW;
    }
}

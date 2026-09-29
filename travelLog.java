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
                    "[9] Display All Travel Logs And Trip Plans By User Name\n" +
                    "[10] Display All Travel Log\n" +
                    "[11] Display All Trip Plan\n" +
                    "[12] Search Travel Log\n" +
                    "[13] Search Trip Plan\n" +
                    "[14] Export\n" +
                    "[15] Import\n" +
                    "[16] Exit\n"
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
            case 4:
                modifyTrip();
                break;
            case 5:
                deleteTravelLog();
                break;
            case 6:
                deleteTripPlan();
                break;
            case 7:
                displayUser();
                break;
            case 9:
                displayAllTravelLogs();
                break;
            case 10:
                displayAllTripPlans();
                break;
            case 11:
                searchTravelLog();
                break;
            case 12:
                searchTripPlan();
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
                    String newDestiType;
                    String newDestiName;
                    int newNumVisits;
                    String newDateVisited;
                    String newLocation;
                    String newTravelExp;
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
                    System.out.println();
                    break;
                case 2:
                    do {
                        System.out.println(
                            "Modifying Destination Type Of " +
                                log[logIndex].destinationName +
                                " Log"
                        );
                        System.out.println(
                            "Destination Type\nb = Beach, m = Mountain, c = city, h = Historical Site, o = Other.\n(Case Sensitive)"
                        );
                        System.out.print("Enter New Destination Type: ");
                        newDestiType = s.nextLine();
                        System.out.println();
                        if (
                            !newDestiType.matches("[bmcho]")
                        ) System.out.println(
                            "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                        );
                    } while (!newDestiType.matches("[bmcho]"));
                    log[logIndex].destinationType = newDestiType;
                    System.out.println(
                        "Destination Type Has Been Successfully Changed To " +
                            log[logIndex].destinationType
                    );
                    System.out.println();
                    break;
                case 3:
                    do {
                        System.out.println(
                            "Modifying Number Of Visits " +
                                log[logIndex].destinationName +
                                " Log"
                        );
                        System.out.println(
                            "Number Of Visits Must Not Be Less Than 1"
                        );
                        System.out.print(
                            "Enter New Number Of Visits In " +
                                log[logIndex].destinationName +
                                ": "
                        );
                        newNumVisits = numOnly();
                        s.nextLine();
                        if (!isPositive(newNumVisits)) System.out.println(
                            "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                        );
                        System.out.println();
                    } while (!isPositive(newNumVisits));
                    log[logIndex].visits = newNumVisits;
                    System.out.println(
                        "Num Of Visits Has Been Changed To " +
                            newNumVisits +
                            " Successfuly"
                    );
                case 4:
                    do {
                        System.out.println(
                            "Modifying Date First Visited In Log " +
                                log[logIndex].destinationName +
                                " Log"
                        );
                        System.out.println(
                            "Date First Visited Must Follow The Format \"mm/dd/yyyy\", And Must Contain Exactly 8 Numbers And 2 / Characters"
                        );
                        System.out.print(
                            "Enter First Date Visited In " +
                                log[logIndex].destinationName +
                                " Trip: "
                        );
                        newDateVisited = s.nextLine();
                        System.out.println();
                        if (
                            isinValidLength(newDateVisited, 10, 10) ||
                            !newDateVisited.matches("\\d{2}/\\d{2}/\\d{4}")
                        ) System.out.println(
                            "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                        );
                    } while (
                        isinValidLength(newDateVisited, 10, 10) ||
                        !newDateVisited.matches("\\d{2}/\\d{2}/\\d{4}")
                    );
                    log[logIndex].dateVisited = newDateVisited;
                    System.out.println(
                        "Date Visited Has Been Changed To " + newDateVisited
                    );
                    System.out.println();
                    break;
                case 5:
                    do {
                        System.out.println(
                            "Location Name Must Not Exceed 30 Characters, Specific Location Of Destination\nExample: Baguio"
                        );
                        System.out.print("Enter New Location: ");
                        newLocation = s.nextLine();
                        System.out.println();
                        if (
                            isinValidLength(newLocation, 0, 30) ||
                            newLocation.isBlank()
                        ) System.out.println(
                            "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                        );
                    } while (
                        isinValidLength(newLocation, 0, 30) ||
                        newLocation.isBlank()
                    );
                    log[logIndex].location = newLocation;
                    System.out.println(
                        "Location Has Been Successfuly Changed To" + newLocation
                    );
                    break;
                case 6:
                    do {
                        System.out.println(
                            "Travel Experience Contains The User's Overall Experience, Impression, Notes About The Destination.\nMust Not Be Empty And Must Not Exceed 300 Characters."
                        );
                        newTravelExp = s.nextLine();
                        System.out.println();
                        if (
                            isinValidLength(newTravelExp, 0, 300) ||
                            newTravelExp.isBlank()
                        ) System.out.println(
                            "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                        );
                    } while (
                        isinValidLength(newTravelExp, 0, 300) ||
                        newTravelExp.isBlank()
                    );
                default:
                    System.out.println(
                        "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                    );

                    break;
            }
        } while (logField != 7);
    }

    static void modifyTrip() {
        int modifyTripPlan;
        int tripField;

        System.out.println(
            "==================================================\n"
        );
        System.out.println("[4] Modify Trip Plan");
        System.out.println(
            "==================================================\n"
        );
        if (tripCount == 0) System.out.println(
            "Theres No Recorded Trip Plan In The User Name \"" +
                p.userName +
                "\""
        );
        System.out.println("Searching " + p.userName + "'s Trip Plan");
        for (int i = 0; i < tripCount; i++) {
            System.out.println(
                "Destination Name [" + (i + 1) + "]: " + trip[i].planName
            );
        }

        System.out.println("Please Select A Trip Plan You Want To Modify");
        modifyTripPlan = numOnly();
        int tripIndex = modifyTripPlan - 1;
        System.out.println("Modifying Trip Plan " + trip[tripIndex].planName);
        do {
            System.out.println(
                "[1] Trip Plan Name\n[2] Trip Description\n[3] Preparation Time\n[4] Travel Time\n[5] Number of Activities\n[6] List of Activities\n[7] Number of Instruction\n[8] Instruction\n[9] Exit"
            );
            tripField = numOnly();
            s.nextLine();
            switch (tripField) {
                case 1:
                    String newPlanName;
                    String newTripDesc;
                    int newPrepTime;
                    int newTravelTime;
                    int newNumOfActs;
                    System.out.println(
                        "Modifying Trip Log " + trip[tripIndex].planName
                    );
                    do {
                        System.out.println(
                            "Trip Name Must Contain 3-50 Characters, And Must Be Unique, No Duplicates Allowed\nExample: Pahinga Sa Japan"
                        );
                        System.out.print("Enter New Trip Name: ");
                        newPlanName = s.nextLine();
                        if (
                            IsDuplicate(newPlanName, tripCount, trip)
                        ) System.out.println(
                            "Trip Name \"" +
                                newPlanName +
                                "\" Is Already Stored, Please Use Another Name."
                        );
                        if (
                            IsDuplicate(newPlanName, tripCount, trip) ||
                            newPlanName.isBlank() ||
                            isinValidLength(newPlanName, 3, 50) ||
                            !newPlanName.matches("^[a-zA-Z0-9 ]+$")
                        ) System.out.println(
                            "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                        );
                    } while (
                        IsDuplicate(newPlanName, tripCount, trip) ||
                        newPlanName.isBlank() ||
                        isinValidLength(newPlanName, 3, 50) ||
                        !newPlanName.matches("^[a-zA-Z0-9 ]+$")
                    );
                    trip[tripIndex].planName = newPlanName;
                    System.out.println(
                        "Trip Plan Name Has Been Changed Successfuly To " +
                            trip[tripIndex].planName
                    );
                    break;
                case 2:
                    do {
                        System.out.println(
                            "Trip Description Describe The Purpose Or Overall Plan For The Trip. Must Not Be Empty And Must Not Exceed 160 Characters"
                        );
                        System.out.print("Enter New Trip Description For: ");
                        newTripDesc = s.nextLine();
                        System.out.println();
                        if (
                            newTripDesc.isBlank() ||
                            isinValidLength(newTripDesc, 1, 160)
                        ) System.out.println(
                            "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                        );
                    } while (
                        newTripDesc.isBlank() ||
                        isinValidLength(newTripDesc, 1, 160)
                    );
                    trip[tripIndex].planDescription = newTripDesc;
                    System.out.println(
                        "Trip Description Has Been Successfuly Changed To " +
                            trip[tripIndex].planDescription
                    );
                    break;
                case 3:
                    do {
                        System.out.println(
                            "Preperation Time, Represents The Estimated Preperation Time. Must Not Be Less Than 1"
                        );
                        System.out.print(
                            "Enter New Preperation Time (In Minutes): "
                        );
                        newPrepTime = numOnly();
                        s.nextLine();
                        System.out.println();
                        if (!isPositive(newPrepTime)) System.out.println(
                            "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                        );
                    } while (!isPositive(newPrepTime));
                    trip[tripIndex].planPrepTime = newPrepTime;
                    System.out.println(
                        "Trip Preperation Time Has Been Successfuly Changed To " +
                            trip[tripIndex].planPrepTime
                    );
                    break;
                case 4:
                    do {
                        System.out.println(
                            "Travel Time, Represents The Estimated Travel Time, Must Not Be Less Than 1"
                        );
                        System.out.print(
                            "Enter New Travel Time (In Minutes): "
                        );
                        newTravelTime = numOnly();
                        System.out.println();
                        s.nextLine();
                        if (!isPositive(newTravelTime)) System.out.println(
                            "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                        );
                    } while (!isPositive(newTravelTime));
                    trip[tripIndex].planTravelTime = newTravelTime;
                    System.out.println(
                        "Travel Time Has Beeen Successfuly Changed To " +
                            trip[tripIndex].planTravelTime
                    );
                    break;
                case 5:
                    do {
                        System.out.println(
                            "Number Of Activities You Will Do In Your Trip, Must Not Be More Than 20"
                        );

                        System.out.print("Enter New Number Of Activities: ");
                        newNumOfActs = numOnly();
                        s.nextLine();
                        System.out.println();

                        if (!isPositive(newNumOfActs) || newNumOfActs > 20) {
                            System.out.println(
                                "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                            );
                        }
                    } while (!isPositive(newNumOfActs) || newNumOfActs > 20);
                    String[] newActivities = new String[newNumOfActs];

                    for (int i = 0; i < newNumOfActs; i++) {
                        do {
                            System.out.println(
                                "Trip Activity Must Not Be Empty, And Must Not Exceed 80 Characters"
                            );

                            System.out.print(
                                "Enter Activity " + (i + 1) + ": "
                            );
                            newActivities[i] = s.nextLine();

                            if (
                                newActivities[i].isBlank() ||
                                isinValidLength(newActivities[i], 1, 80)
                            ) {
                                System.out.println(
                                    "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                                );
                            }
                        } while (
                            newActivities[i].isBlank() ||
                            isinValidLength(newActivities[i], 1, 80)
                        );
                    }

                    trip[tripIndex].planActivities = newNumOfActs;
                    trip[tripIndex].tripListActivities = newActivities;

                    System.out.println(
                        "Number Of Activities Has Been Successfully Changed."
                    );
                    break;
                case 6:
                    String[] changedActivities = new String[trip[
                        tripIndex
                    ].planActivities];

                    for (int i = 0; i < trip[tripIndex].planActivities; i++) {
                        do {
                            System.out.println(
                                "Trip Activity Must Not Be Empty, And Must Not Exceed 80 Characters"
                            );

                            System.out.print(
                                "Enter New Activity " + (i + 1) + ": "
                            );
                            changedActivities[i] = s.nextLine();

                            if (
                                changedActivities[i].isBlank() ||
                                isinValidLength(changedActivities[i], 1, 80)
                            ) {
                                System.out.println(
                                    "Invalid Input, Please Try Again. Follow The Instructions Below\n"
                                );
                            }
                        } while (
                            changedActivities[i].isBlank() ||
                            isinValidLength(changedActivities[i], 1, 80)
                        );
                    }

                    trip[tripIndex].tripListActivities = changedActivities;

                    System.out.println(
                        "List Of Activities Has Been Successfully Changed."
                    );
                    break;
                default:
                    break;
            }
        } while (tripField != 9);
    }

    static void deleteTripPlan() {
        if (tripCount == 0) {
            System.out.println(
                "Theres No Recorded Trip Plan In The User Name \"" +
                    p.userName +
                    "\""
            );
            return;
        }

        System.out.println(
            "==================================================\n"
        );
        System.out.println("[6] Delete Trip Plan Menu");
        System.out.println(
            "==================================================\n"
        );

        System.out.println("Searching " + p.userName + "'s Trip Plan");
        System.out.println();

        for (int i = 0; i < tripCount; i++) {
            System.out.println(
                "Trip Plan [" + (i + 1) + "]: " + trip[i].planName
            );
        }

        System.out.println();
        System.out.print("Enter The Trip Plan You Want To Delete: ");
        int deleteTripIndex = numOnly();
        s.nextLine();
        System.out.println();

        if (deleteTripIndex < 1 || deleteTripIndex > tripCount) {
            System.out.println(
                "Invalid Input, Please Choose A Trip Plan From The List."
            );
            return;
        }

        int tripIndex = deleteTripIndex - 1;

        System.out.println("Deleting Trip Plan: " + trip[tripIndex].planName);

        for (int i = tripIndex; i < tripCount - 1; i++) {
            trip[i] = trip[i + 1];
        }

        trip[tripCount - 1] = null;
        tripCount--;

        System.out.println("Trip Plan Has Been Successfully Deleted!");
    }

    static void deleteTravelLog() {
        System.out.println(
            "==================================================\n"
        );
        System.out.println("[5] Delete Travel Log Menu");
        System.out.println(
            "==================================================\n"
        );

        if (logCount == 0) {
            System.out.println(
                "There's No Recorded Travel Log In The User Name \"" +
                    p.userName +
                    "\""
            );
            return;
        }

        System.out.println(p.userName + " Travel Log History:\n");
        for (int i = 0; i < logCount; i++) {
            System.out.println(
                "Destination Name [" + (i + 1) + "]: " + log[i].destinationName
            );
        }
        System.out.println();

        int choice;
        do {
            System.out.print(
                "Enter The Travel Log Number You Want To Delete (0 To Cancel): "
            );
            choice = numOnly();
            s.nextLine();
            System.out.println();
            if (choice < 0 || choice > logCount) {
                System.out.println(
                    "Invalid Input, Please Choose Among The Listed Logs Only.\n"
                );
            }
        } while (choice < 0 || choice > logCount);

        if (choice == 0) {
            System.out.println("Delete Cancelled.");
            return;
        }

        int index = choice - 1;
        String confirm;
        do {
            System.out.print(
                "Are You Sure You Want To Delete \"" +
                    log[index].destinationName +
                    "\"? (y/n): "
            );
            confirm = s.nextLine();
            System.out.println();
            if (!confirm.matches("[yn]")) {
                System.out.println(
                    "Invalid Input, Please Enter y Or n Only.\n"
                );
            }
        } while (!confirm.matches("[yn]"));

        if (confirm.equals("n")) {
            System.out.println("Delete Cancelled.");
            return;
        }

        String deletedName = log[index].destinationName;

        for (int i = index; i < logCount - 1; i++) {
            log[i] = log[i + 1];
        }
        log[logCount - 1] = null;
        logCount--;

        System.out.println("Log \"" + deletedName + "\" Has Been Deleted!");
    }

    static void displayAllTripPlans() {
        System.out.println(
            "=================================================="
        );
        System.out.println("[11] Display All Trip Plans");
        System.out.println(
            "==================================================\n"
        );

        if (tripCount == 0) {
            System.out.println("There Are No Recorded Trip Plans.");
            return;
        }

        for (int i = 0; i < tripCount; i++) {
            System.out.println("Trip Plan [" + (i + 1) + "]");
            System.out.println("Trip Name        : " + trip[i].planName);
            System.out.println("Description      : " + trip[i].planDescription);
            System.out.println(
                "Preparation Time : " + trip[i].planPrepTime + " minutes"
            );
            System.out.println(
                "Travel Time      : " + trip[i].planTravelTime + " minutes"
            );
            System.out.println("Activities       :");
            for (int j = 0; j < trip[i].planActivities; j++) {
                System.out.println(
                    "  [" + (j + 1) + "] " + trip[i].tripListActivities[j]
                );
            }
            System.out.println("Instructions     :");
            for (int j = 0; j < trip[i].planNumInstructions; j++) {
                System.out.println(
                    "  [" + (j + 1) + "] " + trip[i].planInstructions[j]
                );
            }
            System.out.println(
                "--------------------------------------------------"
            );
        }
    }

    static void displayUser() {
        System.out.println(
            "=================================================="
        );
        System.out.println("[7] Display User");
        System.out.println(
            "==================================================\n"
        );

        System.out.println("Full Name     : " + p.fullName);
        System.out.println("Username      : " + p.userName);
        System.out.println("Email Address : " + p.emailAddr);
        System.out.println("Mobile Number : " + p.mobNumber);
    }

    static void searchTravelLog() {
        String keyword;
        int found = 0;
        System.out.println(
            "==================================================\n"
        );
        System.out.println("[11] Search Travel Log Menu");
        System.out.println(
            "==================================================\n"
        );
        System.out.println("Searching " + p.userName + "'s Travel Log");
        if (logCount == 0) {
            System.out.println(
                "Theres No Recorded Travel Log In The User Name \"" +
                    p.userName +
                    "\""
            );
            return;
        }

        do {
            System.out.println(
                "Search Keyword Must Not Be Empty And Must Not Exceed 50 Characters\nYou Can Type A Whole Or Part Of The Destination Name (Not Case Sensitive)"
            );
            System.out.print("Enter Destination Name To Search: ");
            keyword = s.nextLine().trim();
            System.out.println();
            if (
                keyword.isBlank() || isinValidLength(keyword, 1, 50)
            ) System.out.println(
                "Invalid Input, Please Try Again. Follow The Instructions Below\n"
            );
        } while (keyword.isBlank() || isinValidLength(keyword, 1, 50));

        System.out.println("Search Results For \"" + keyword + "\":");
        System.out.println();
        for (int i = 0; i < logCount; i++) {
            if (
                log[i].destinationName
                    .toLowerCase()
                    .contains(keyword.toLowerCase())
            ) {
                found++;
                System.out.println("Result [" + found + "]");
                System.out.println(
                    "Destination Name: " + log[i].destinationName
                );
                System.out.println(
                    "Destination Type: " + typeName(log[i].destinationType)
                );
                System.out.println("Number Of Visits: " + log[i].visits);
                System.out.println("Date First Visited: " + log[i].dateVisited);
                System.out.println("Location: " + log[i].location);
                System.out.println("Travel Experience: " + log[i].travelExp);
                System.out.println();
            }
        }

        if (found == 0) {
            System.out.println(
                "No Travel Log Found With The Name \"" + keyword + "\""
            );
        } else {
            System.out.println(found + " Travel Log(s) Found");
        }
        System.out.println();
    }

    static String typeName(String code) {
        switch (code) {
            case "b":
                return "Beach";
            case "m":
                return "Mountain";
            case "c":
                return "City";
            case "h":
                return "Historical Site";
            default:
                return "Other";
        }
    }

    static void searchTripPlan() {
        String keyword;
        int found = 0;
        System.out.println(
            "==================================================\n"
        );
        System.out.println("[12] Search Trip Plan Menu");
        System.out.println(
            "==================================================\n"
        );
        System.out.println("Searching " + p.userName + "'s Trip Plans");
        if (tripCount == 0) {
            System.out.println(
                "Theres No Recorded Trip Plan In The User Name \"" +
                    p.userName +
                    "\""
            );
            return;
        }

        do {
            System.out.println(
                "Search Keyword Must Not Be Empty And Must Not Exceed 50 Characters\nYou Can Type A Whole Or Part Of The Trip Name (Not Case Sensitive)"
            );
            System.out.print("Enter Trip Name To Search: ");
            keyword = s.nextLine().trim();
            System.out.println();
            if (
                keyword.isBlank() || isinValidLength(keyword, 1, 50)
            ) System.out.println(
                "Invalid Input, Please Try Again. Follow The Instructions Below\n"
            );
        } while (keyword.isBlank() || isinValidLength(keyword, 1, 50));

        System.out.println("Search Results For \"" + keyword + "\":");
        System.out.println();
        for (int i = 0; i < tripCount; i++) {
            if (
                trip[i].planName.toLowerCase().contains(keyword.toLowerCase())
            ) {
                found++;
                System.out.println("Result [" + found + "]");
                System.out.println("Trip Name: " + trip[i].planName);
                System.out.println(
                    "Trip Description: " + trip[i].planDescription
                );
                System.out.println(
                    "Preparation Time: " + trip[i].planPrepTime + " Minutes"
                );
                System.out.println(
                    "Travel Time: " + trip[i].planTravelTime + " Minutes"
                );
                System.out.println(
                    "Activities (" + trip[i].planActivities + "):"
                );
                for (int j = 0; j < trip[i].planActivities; j++) {
                    System.out.println(
                        "  " + (j + 1) + ". " + trip[i].tripListActivities[j]
                    );
                }
                System.out.println(
                    "Instructions (" + trip[i].planNumInstructions + "):"
                );
                for (int j = 0; j < trip[i].planNumInstructions; j++) {
                    System.out.println(
                        "  " + (j + 1) + ". " + trip[i].planInstructions[j]
                    );
                }
                System.out.println();
            }
        }

        if (found == 0) {
            System.out.println(
                "No Trip Plan Found With The Name \"" + keyword + "\""
            );
        } else {
            System.out.println(found + " Trip Plan(s) Found");
        }
        System.out.println();
    }

    static void displayAllTravelLogs() {
        System.out.println(
            "==================================================\n"
        );
        System.out.println("[9] Display All Travel Logs Menu");
        System.out.println(
            "==================================================\n"
        );

        if (logCount == 0) {
            System.out.println(
                "There's No Recorded Travel Log In The User Name \"" +
                    p.userName +
                    "\""
            );
            System.out.println();
            return;
        }

        System.out.println(
            p.userName + " Travel Log History (" + logCount + " Total):\n"
        );
        for (int i = 0; i < logCount; i++) {
            System.out.println(
                "--------------------------------------------------"
            );
            System.out.println("Travel Log [" + (i + 1) + "]");
            System.out.println(
                "Destination Name   : " + log[i].destinationName
            );
            System.out.println(
                "Destination Type   : " +
                    destinationTypeName(log[i].destinationType)
            );
            System.out.println("Number Of Visits   : " + log[i].visits);
            System.out.println("Date First Visited : " + log[i].dateVisited);
            System.out.println("Location           : " + log[i].location);
            System.out.println("Travel Experience  : " + log[i].travelExp);
        }
        System.out.println(
            "--------------------------------------------------\n"
        );
    }

    static String destinationTypeName(String code) {
        switch (code) {
            case "b":
                return "Beach";
            case "m":
                return "Mountain";
            case "c":
                return "City";
            case "h":
                return "Historical Site";
            default:
                return "Other";
        }
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

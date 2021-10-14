package dev.tinajero.app;

import dev.tinajero.services.LoginService;
import dev.tinajero.services.SignupService;

import java.util.Scanner;

public class MainDisplay {
    public static Scanner scanner = new Scanner(System.in);

    public static LoginService loginService = new LoginService();

    public static SignupService signupService = new SignupService();

    public static void Display(){
        CivilianMenu civilMenu = new CivilianMenu();
        HeroMenu heroMenu = new HeroMenu();

        boolean runningApp = true;

        while(runningApp) {
            System.out.println("Welcome to LeagueVengers!\n");

            System.out.println("1: Sign up\n2: Log in\n3: Report Anonymously\n4: Quit");
            System.out.print("Please select from the options above: ");

            int selection = scanner.nextInt();
            switch (selection) {

                case 1: {
                    scanner.nextLine();
                    String name, last, user, pass, email;
                    System.out.println("\nPlease Provide the Following:\nFirst Name:");
                    name = scanner.nextLine();
                    System.out.println("Last Name: ");
                    last = scanner.nextLine();
                    System.out.println("Username: ");
                    user = scanner.nextLine();
                    System.out.println("Password:(Must be between 9 and 18 characters in length)");
                    pass = scanner.nextLine();
                    while(pass.length() <8 || pass.length() >18){
                        System.out.println("Password length doesnt meet requirements, try again");
                        pass = scanner.nextLine();
                    }
                    System.out.println("Email: ");
                    email = scanner.nextLine();
                    boolean signInResponse = signupService.signUp(name, last, user, pass, email, false);
                    if (signInResponse) {
                        System.out.println("Sign Up successful");
                    } else
                        System.out.println("Sign Up failed");
                    break;

                }

                case 2:
                    scanner.nextLine();
                    System.out.println("\n1: Hero\n2: Civilian\n3: Quit");
                    System.out.print("Please Select type of Login:");
                    int select;
                    select = scanner.nextInt();
                    if(select == 1) {
                        scanner.nextLine();
                        System.out.println("\nPlease enter your username- ");
                        String husername = scanner.nextLine();
                        System.out.println("Please enter a password- ");
                        String hpassword = scanner.nextLine();
                        boolean hsignInResponse = loginService.loginHero(husername, hpassword);
                        if (hsignInResponse) {
                            System.out.println("login success");
                            heroMenu.selectionMenu();
                        } else {
                            System.out.println("login failed\nAre you a hero?");
                            break;
                        }
                    }
                    else if(select == 2) {
                        scanner.nextLine();
                        System.out.println("Please enter your username: ");
                        String username = scanner.nextLine();
                        System.out.println("Please enter a password: ");
                        String password = scanner.nextLine();
                        boolean signInResponse = loginService.loginUser(username, password);
                        if (signInResponse) {
                            System.out.println("login success");
                            civilMenu.selectionMenu();
                        } else {
                            System.out.println("login failed\nForgot Password?");
                            break;
                        }
                    }
                    else if(select == 3)
                        break;
                    break;
                case 3: {
                    AnonymousReport.display();
                    break;
                }

                case 4: {
                    runningApp = false;
                    System.out.println("Have a nice day!");
                    break;
                }


            }
        }
    }
}

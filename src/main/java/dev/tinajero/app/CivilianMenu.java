package dev.tinajero.app;

import dev.tinajero.models.Emergencies;
import dev.tinajero.models.Users;
import dev.tinajero.repositories.MessagesRepo;
import dev.tinajero.services.EmergencyService;
import dev.tinajero.services.HeroException;
import dev.tinajero.services.UserServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static dev.tinajero.app.HeroMenu.userRepo;

public class CivilianMenu {
    public static Scanner scanner = new Scanner(System.in);

    public static EmergencyService emergencyService = new EmergencyService();
    public static UserServices userServices = new UserServices();
    public static MessagesRepo messagesRepo = new MessagesRepo();


    public void selectionMenu(){
        int serviceSelection;
        boolean running = true;
        Emergencies emer = new Emergencies();

        while(running) {
            int selection;
            System.out.println("What would you like to do?\n\n1:Request emergency services");
            System.out.println(("2:Request hero help\n3:Upload an emergency\n4:Quit"));
            selection = scanner.nextInt();

            if(selection == 1){
                System.out.println("Which of these emergency services would you like to call?\n1:Medical\n2:Police\n3:Fire Fighters");
                scanner.nextLine();
                serviceSelection = scanner.nextInt();
                if(serviceSelection == 1) {
                    messagesRepo.getById(serviceSelection);
                }
                else if(serviceSelection == 2) {
                    messagesRepo.getById(serviceSelection);
                }
                else if(serviceSelection == 3){
                    messagesRepo.getById(serviceSelection);
                }
            }
            else if(selection == 2){
                List<Users> arr = new ArrayList<Users>();
                scanner.nextLine();
                int hero = 0;
                boolean run = true;
                while(run) {
                    arr = userRepo.getAllUsers(true);
                    arr.forEach(System.out::println);
                    System.out.println("Please select the hero you need from the list: ");
                    hero = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        userServices.check(hero);
                        Users request = userRepo.getId(hero);
                        if (request.isHero()) {
                            System.out.println("Hero " + hero + " will be on the way!");
                            run = false;
                        }
                    }catch(HeroException he){
                        System.out.println("Custom Exception caught-Invalid Selection:Retry");
                    }

                }

            }
            else if(selection == 3){
                System.out.println("Please enter your emergency: ");
                String emergency;
                scanner.nextLine();
                emergency = scanner.nextLine();
                if(!emergencyService.addEmergency(emergency)){
                    System.out.println("Emergency Uploaded!");
                }
            }
            else if(selection == 4)
                running = false;

        }
    }
}

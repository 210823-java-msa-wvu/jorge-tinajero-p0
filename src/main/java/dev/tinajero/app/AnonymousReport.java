package dev.tinajero.app;

import dev.tinajero.services.EmergencyService;

import java.util.Scanner;


public class AnonymousReport {

    public static EmergencyService emergencyService = new EmergencyService();

    public static void display() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your emergency: ");
        String emergency;
        emergency = scanner.nextLine();
        if(!emergencyService.addEmergency(emergency))
            System.out.println("Emergency Uploaded");
    }
}
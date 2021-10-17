/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GarageProject;

import java.util.ArrayList;

/**
 *
 * @author Cryowynd
 */
public class Garage {

    private int parkingSpots;
    private int spotsLeft;
    private double moneyTotal;
    private ArrayList<Staff> staffList = new ArrayList<Staff>();
    private ArrayList<Vehicle> parkedList = new ArrayList<Vehicle>();

    //Constructor for number of parking spots and staff
    public Garage(int parkingSpots, Staff... staffList) {
        this.parkingSpots = parkingSpots;
        this.spotsLeft = this.parkingSpots;
        for (Staff staff : staffList) {
            this.staffList.add(staff);
        }

    }
    //Check if garage has empty spots

    public boolean hasSpotsLeft() {
        if (spotsLeft == 0) {
            return false;
        } else {
            return true;
        }
    }

    public double getMoneyTotal() {
        return moneyTotal;
    }

    //Attempt to park new vehicle
    public void parkVehicle(Vehicle vehicle, Staff staff) {

        //Check if vehicle is car or motorcycle
        if ((!vehicle.getType().equalsIgnoreCase("motorcycle")) && (!vehicle.getType().equalsIgnoreCase("car"))) {
            System.out.println("Invalid vehicle type, " + vehicle.getType() + " " + vehicle.getLicensePlate() + " not parked.");
            return;
        }

        //Check if valid license plate 
        if (vehicle.getLicensePlate().equalsIgnoreCase("")) {
            System.out.println("License plate can not be empty, " + vehicle.getType() + " " + vehicle.getLicensePlate() + " not parked.");
            return;
        }

        //Check if valid driver name
        if (!isAlpha(vehicle.getOwner().getName())) {
            System.out.println("Invalid driver's name, " + vehicle.getType() + " " + vehicle.getLicensePlate() + " not parked.");
            return;
        }

        //Check if duplicate license plate
        String license = vehicle.getLicensePlate();
        for (Vehicle temp : parkedList) {
            if (temp.getLicensePlate().equalsIgnoreCase(license)) {
                System.out.println("Duplicate license plate, " + vehicle.getType() + " " + vehicle.getLicensePlate() + " not parked.");
                return;
            }
        }

        //Check if there are available parking spots
        if (!hasSpotsLeft()) {
            System.out.println("No parking spots available, " + vehicle.getType() + " " + vehicle.getLicensePlate() + " not parked.");
            return;
        }

        //Check if multiple vehicles belong to one driver to apply the discount.
        for (Vehicle temp : parkedList) {
            if (temp.getOwner() == vehicle.getOwner()) {
                temp.setHasDiscount(true);
                vehicle.setHasDiscount(true);
            }
        }

        //Park vehicle
        parkedList.add(vehicle);
        vehicle.setParkedBy(staff);
        vehicle.startTimer();
        spotsLeft--;
        System.out.println(vehicle.getType() + " " + vehicle.getLicensePlate() + " parked.");

    }

    public void chargeVehicle(Vehicle vehicle) {
        double charge = vehicle.getCharge();
        moneyTotal += charge;
        System.out.println(vehicle.getType() + " " + vehicle.getLicensePlate() + " was charged " + charge + ".");
    }

    public void removeVehicle(Vehicle vehicle) {
        if (parkedList.contains(vehicle)) {
            spotsLeft++;
            parkedList.remove(vehicle);
            chargeVehicle(vehicle);
            System.out.println(vehicle.getType() + " " + vehicle.getLicensePlate() + " removed.");
        } else {
            //Vehicle not currently parked
            System.out.println(vehicle.getType() + " " + vehicle.getLicensePlate() + " is not currently parked");
        }
    }

    //Check if driver's name is empty or doesn't only contain letters
    public static boolean isAlpha(String s) {
        if (s == null) {
            return false;
        } else if (s.equals("")) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Vehicle> getParkedList() {
        return parkedList;
    }

}

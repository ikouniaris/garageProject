/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GarageProject;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cryowynd
 */
public class Main {

    public static void main(String[] args) {
        //Create objects for examples

        //Staff
        Staff emp1 = new Staff("George", 19);
        Staff emp2 = new Staff("Jon", 18);
        Staff emp3 = new Staff("Bob", 13);

        //Drivers
        Driver dr1 = new Driver("Maria");
        Driver dr2 = new Driver("Sam");
        //Invalid driver name
        Driver dr3 = new Driver("Sam14");

        //Cars
        Car c1 = new Car("12523");
        Car c2 = new Car("12548");
        //Car with empty license plate
        Car c3 = new Car("");
        //Car with duplicate license plate
        Car c4 = new Car("12523");

        //Motorcycles
        Motorcycle m1 = new Motorcycle("49818");
        Motorcycle m2 = new Motorcycle("18915");

        //Invalid vehicle type
        Vehicle v1 = new Vehicle("52251");

        //Add vehicles to drivers
        dr1.addVehicle(c1, m1);
        dr2.addVehicle(c2, c3, v1);
        dr3.addVehicle(m2);

        //Create garage
        Garage garage = new Garage(3, emp1, emp2, emp3);

        garage.parkVehicle(c1, emp2);

        System.out.println("Vehicle parked by " + garage.getParkedList().get(0).getParkedBy().getName() + ".");

        garage.parkVehicle(m1, emp2);

        //Wait
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        garage.parkVehicle(c2, emp3);
        garage.parkVehicle(c3, emp3);
        garage.parkVehicle(v1, emp3);

        //Wait
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        garage.parkVehicle(m2, emp1);

        dr1.addVehicle(m2);

        garage.parkVehicle(m2, emp1);

//Wait
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        garage.removeVehicle(c1);
        garage.removeVehicle(c3);
        garage.removeVehicle(m2);

        //Wait
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        garage.removeVehicle(m1);

        System.out.print("Total money: " + garage.getMoneyTotal());

    }
}

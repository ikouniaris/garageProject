/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GarageProject;

/**
 *
 * @author Cryowynd
 */
public class Motorcycle extends Vehicle {
    //Set vehicle type to motorcycle, rate value to 3

    public Motorcycle(String licensePlate) {
        super(licensePlate);
        super.setType("Motorcycle");
        super.setRate(3);
    }

}

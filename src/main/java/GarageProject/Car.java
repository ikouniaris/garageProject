/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GarageProject;

/**
 *
 * @author Cryowynd
 */
public class Car extends Vehicle {

    //Set vehicle type to car, rate value to 5
    public Car(String licensePlate) {
        super(licensePlate);
        super.setType("Car");
        super.setRate(5);
    }

}

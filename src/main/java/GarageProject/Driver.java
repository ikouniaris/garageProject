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
public class Driver extends Person {

    private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
    private int vehicleAmount;

    //Constructor for driver name and vehicles
    public Driver(String name, Vehicle... vehicles) {
        super(name);
        for (Vehicle vehicle : vehicles) {
            vehicleList.add(vehicle);
            vehicle.setOwner(this);
        }
        this.vehicleAmount = vehicleList.size();
    }

    //Constructor for driver name without vehicles
    public Driver(String name) {
        super(name);
        this.vehicleAmount = vehicleList.size();
    }

    public int getVehicleAmount() {
        return vehicleAmount;
    }

    //Add vehicles to driver
    public void addVehicle(Vehicle... vehicles) {
        for (Vehicle temp : vehicles) {
            vehicleList.add(temp);
            temp.setOwner(this);
        }
        vehicleAmount = vehicleList.size();
    }

}

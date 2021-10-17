/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GarageProject;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Cryowynd
 */
//Base vehicle class, to be extended
public class Vehicle {
//Placeholder values

    private String type = "0";
    private Driver owner = new Driver("");
    private String licensePlate;
    private int rate = 0;
    private long start;
    private Staff parkedBy;
    private boolean hasDiscount;

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public boolean isHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public Staff getParkedBy() {
        return parkedBy;
    }

    public void setParkedBy(Staff parkedBy) {
        this.parkedBy = parkedBy;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setOwner(Driver owner) {
        this.owner = owner;
    }

    public Driver getOwner() {
        return owner;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    //Save the time when the vehicle was parked
    public void startTimer() {
        start = System.nanoTime();
    }

    //Calculate the charge for the time the vehicle was parked
    public double getCharge() {
        //Calculate time parked
        long end = System.nanoTime();
        double time = (end - start);
        time = time / 1000000000;
        //Divide by 60 for minutes, 3600 for hours, or leave commented for seconds.

        //time = time / 60;
        //Apply the 30 minute free parking if needed.
        System.out.println(this.getType() + " " + this.getLicensePlate() + " has been parked for " + BigDecimal.valueOf(time).setScale(2, RoundingMode.HALF_UP).doubleValue() + ".");
        if (hasDiscount) {
            if (time > 0.5) {
                time -= 0.5;
            }
            //Apply 30% discount
            time *= 0.7;
            System.out.println("Driver with multiple parked vehicles, discount applied.");
        }

        //Calculate charge
        double charge = time * rate;
        return BigDecimal.valueOf(charge).setScale(2, RoundingMode.HALF_UP).doubleValue();

    }

}

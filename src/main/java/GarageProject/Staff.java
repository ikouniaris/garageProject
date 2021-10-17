/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GarageProject;

/**
 *
 * @author Cryowynd
 */
public class Staff extends Person {

    private int staffId;

    public Staff(String name, int staffId) {
        super(name);
        this.staffId = staffId;
    }

    public int getStaffId() {
        return staffId;
    }

}

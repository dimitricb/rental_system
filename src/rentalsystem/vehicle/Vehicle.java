/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalsystem.vehicle;

/**
 *
 * @author Bojana
 */
public abstract class Vehicle {

    public String brand;
    public String model;
    public double value;

    public Vehicle(String brand, String model, double value) {
        this.brand = brand;
        this.model = model;
        this.value = value;
    }

    public abstract double getDailyRentalCost(int rentalDays);

    public abstract double getInitialInsuranceCost();
    
    public abstract double getDailyInsuranceCost(int rentalDays, int additionalParameter);

}

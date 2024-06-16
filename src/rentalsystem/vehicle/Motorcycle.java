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
public class Motorcycle extends Vehicle {

    private int riderAge;

    public Motorcycle(String brand, String model, double value, int riderAge) {
        super(brand, model, value);
        this.riderAge = riderAge;
    }

    @Override
    public double getDailyRentalCost(int rentalDays) {
        return rentalDays > 7 ? 10 : 15;
    }

    @Override
    public double getInitialInsuranceCost() {
        return 0.0002 * value;
    }
    
    @Override
    public double getDailyInsuranceCost(int rentalDays, int additionalParameter) {
        double insuranceCost = getInitialInsuranceCost();
        if (riderAge < 25) {
            insuranceCost *= 1.20;
        }
        return insuranceCost;
    }

    
}

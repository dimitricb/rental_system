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
public class Car extends Vehicle {

    private int safetyRating;

    public Car(String brand, String model, double value, int safetyRating) {
        super(brand, model, value);
        this.safetyRating = safetyRating;
    }

    @Override
    public double getDailyRentalCost(int rentalDays) {
        return rentalDays > 7 ? 15 : 20;
    }
    
    @Override
    public double getInitialInsuranceCost() {
        return 0.0001 * value;
    }

    @Override
    public double getDailyInsuranceCost(int rentalDays, int additionalParameter) {
        double insuranceCost = getInitialInsuranceCost();
        if (safetyRating >= 4) {
            insuranceCost *= 0.90;
        }
        return insuranceCost;
    }

    

}

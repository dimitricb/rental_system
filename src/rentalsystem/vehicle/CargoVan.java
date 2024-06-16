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
public class CargoVan extends Vehicle {

    private int driverExperience;

    public CargoVan(String brand, String model, double value, int driverExperience) {
        super(brand, model, value);
        this.driverExperience = driverExperience;
    }

    @Override
    public double getDailyRentalCost(int rentalDays) {
        return rentalDays > 7 ? 40 : 50;
    }

    @Override
    public double getInitialInsuranceCost() {
        return 0.0003 * value;
    }
    
    @Override
    public double getDailyInsuranceCost(int rentalDays, int additionalParameter) {
        double insuranceCost = getInitialInsuranceCost();
        if (driverExperience > 5) {
            insuranceCost *= 0.85;
        }
        return insuranceCost;
    }

    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalsystem.rental;

import java.time.LocalDate;
import rentalsystem.vehicle.Vehicle;

/**
 *
 * @author Bojana
 */
public class Rental {

    private Vehicle vehicle;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate actualReturnDate;
    private int rentalDays;
    private int actualRentalDays;

    public Rental(Vehicle vehicle, LocalDate startDate, LocalDate endDate, LocalDate actualReturnDate) {
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.actualReturnDate = actualReturnDate;
        this.rentalDays = (int) (endDate.toEpochDay() - startDate.toEpochDay());
        this.actualRentalDays = (int) (actualReturnDate.toEpochDay() - startDate.toEpochDay());

    }

    public double calculateRentalCost() {
        double dailyCost = vehicle.getDailyRentalCost(rentalDays);
        if (actualRentalDays >= rentalDays) {
            return actualRentalDays * dailyCost;
        } else {
            return actualRentalDays * dailyCost + (rentalDays - actualRentalDays) * (dailyCost / 2);
        }
    }

    public double calcuteInsuranceCost() {
        double dailyInsurance = vehicle.getDailyInsuranceCost(rentalDays, 0);
        if (actualRentalDays < rentalDays) {
            return dailyInsurance * actualRentalDays;
        } else {
            return dailyInsurance * rentalDays;
        }
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public int getActualRentalDays() {
        return actualRentalDays;
    }

    

}

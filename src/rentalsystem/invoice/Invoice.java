/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalsystem.invoice;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import rentalsystem.rental.Rental;
import rentalsystem.vehicle.Car;
import rentalsystem.vehicle.CargoVan;
import rentalsystem.vehicle.Motorcycle;

/**
 *
 * @author Bojana
 */
public class Invoice {

    private String customerName;
    Rental rental;

    public Invoice(String customerName, Rental rental) {
        this.customerName = customerName;
        this.rental = rental;
    }

    public void printInvoice() {

        DecimalFormat df = new DecimalFormat("0.00");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("XXXXXXXXXX");
        System.out.println("Date: " + LocalDate.now());
        System.out.println("Customer Name: " + customerName);
        System.out.println("Rented Vehicle: " + rental.getVehicle().brand + " " + rental.getVehicle().model);

        System.out.println("\nReservation start date: " + rental.getStartDate());
        System.out.println("Reservation end date: " + rental.getEndDate());
        System.out.println("Reserved rental days: " + rental.getRentalDays()+" days");

        System.out.println("\nActual return date: " + rental.getActualReturnDate());
        System.out.println("Actual rental days: "+ rental.getActualRentalDays()+" days");

        System.out.println("\nRental cost per day: $" + df.format(rental.getVehicle().getDailyRentalCost(rental.getRentalDays())));

        double insurancePerDay = rental.getVehicle().getDailyInsuranceCost(rental.getRentalDays(), 0);
        double initialInsuranceCost = rental.getVehicle().getInitialInsuranceCost();

        double additionORDiscount = insurancePerDay - initialInsuranceCost;

        
        if (additionORDiscount!=0 && additionORDiscount> 0) {
            System.out.println("Initial insurance per day: $" + df.format(initialInsuranceCost));
            System.out.println("Insurance addition per day: $" + df.format(Math.abs(insurancePerDay - rental.getVehicle().getInitialInsuranceCost())));
        } else if (additionORDiscount!=0 && additionORDiscount< 0){
            System.out.println("Initial insurance per day: $" + df.format(initialInsuranceCost));
            System.out.println("Insurance discount per day: $" + df.format(Math.abs(insurancePerDay - rental.getVehicle().getInitialInsuranceCost())));
        }

        System.out.println("Insurance per day: $" + df.format(insurancePerDay));

        if (rental.getActualRentalDays() < rental.getRentalDays()) {
            double earlyReturnDiscountForRent = (rental.getVehicle().getDailyRentalCost(rental.getRentalDays()) / 2) * (rental.getRentalDays() - rental.getActualRentalDays());
            System.out.println("\nEarly return discount for rent: $" + df.format(earlyReturnDiscountForRent));

            double earlyReturnDiscountForInsurance = (rental.getVehicle().getDailyInsuranceCost(rental.getRentalDays(), 0)) * (rental.getRentalDays() - rental.getActualRentalDays());
            System.out.println("Early return discount for insurance: $" + df.format(earlyReturnDiscountForInsurance));

        }

        System.out.println("\nTotal rent: $" + df.format(rental.calculateRentalCost()));
        System.out.println("Total insurance: $" + df.format(rental.calcuteInsuranceCost()));
        System.out.println("Total: $" + df.format(rental.calculateRentalCost() + rental.calcuteInsuranceCost()));
        System.out.println("XXXXXXXXXX");

    }

}

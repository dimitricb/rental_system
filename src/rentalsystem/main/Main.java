/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalsystem.main;

import java.time.LocalDate;
import java.time.Month;
import rentalsystem.invoice.Invoice;
import rentalsystem.rental.Rental;
import rentalsystem.vehicle.Car;
import rentalsystem.vehicle.CargoVan;
import rentalsystem.vehicle.Motorcycle;

/**
 *
 * @author Bojana
 */
public class Main {

    public static void main(String[] args) {
        
        Car car=new Car("Mitsubishi","Mirage",15000,3);
        Rental carRental=new Rental(car, LocalDate.of(2024, 6, 3), LocalDate.of(2024, 6, 13), LocalDate.of(2024, 6, 13));
        Invoice carInvoice=new Invoice("John Doe", carRental);
        carInvoice.printInvoice();

        Motorcycle motorcycle=new Motorcycle("Triumph Tiger", "Sport 660", 10000, 20);
        Rental motorcycleRental=new Rental(motorcycle, LocalDate.of(2024,6,03), LocalDate.of(2024,6,13), LocalDate.of(2024,6,13));
        Invoice motorcycleInvoice=new Invoice("Mary Johnson", motorcycleRental);
        motorcycleInvoice.printInvoice();
        
        CargoVan cargoVan=new CargoVan("Citroen", "Jumper", 20000, 8);
        Rental cargoVanRental=new Rental(cargoVan, LocalDate.of(2024,6,03), LocalDate.of(2024,6,18), LocalDate.of(2024,6,13));
        Invoice cargoVanInvoice=new Invoice("John Markson", cargoVanRental);
        cargoVanInvoice.printInvoice();
        
        
        
    }
    
}

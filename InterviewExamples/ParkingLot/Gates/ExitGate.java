package InterviewExamples.ParkingLot.Gates;

import InterviewExamples.ParkingLot.Parking.Factory.ParkingSpotFactory;
import InterviewExamples.ParkingLot.Parking.Manager.ParkingSpotManager;
import InterviewExamples.ParkingLot.Parking.Spot.ParkingSpot;
import InterviewExamples.ParkingLot.Tickets.Ticket;
import InterviewExamples.ParkingLot.Vehicles.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExitGate {

    private ParkingSpotFactory parkingSpotFactory;
    private ParkingSpotManager parkingSpotManager;

    /*
    Now here we can implement a payment method also using strategyPattern ( creditCardStrategy, debitCardStrategy, upiStrategy etc..)
     */


    public int generateBill(Ticket ticket){
        this.parkingSpotManager = parkingSpotFactory.getParkingSpotManger(ticket.getVehicle());
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        ParkingSpot spot = removeVehicle(ticket.getVehicle());
        int price = calculatePrice(entryTime, exitTime, spot);
        return price;
    }


    private ParkingSpot removeVehicle(Vehicle vehicle){
        return parkingSpotManager.removeVehicle(vehicle);
    }

    private int calculatePrice(LocalDateTime entryTime, LocalDateTime exitTime, ParkingSpot spot){

        int hourlyPrice = spot.getPrice();
        long hours = Duration.between(entryTime, exitTime).toHours();
        if (Duration.between(entryTime, exitTime).toMinutes() % 60 != 0) {
            hours++;
        }
        return (int) (hours * hourlyPrice);
    }
}

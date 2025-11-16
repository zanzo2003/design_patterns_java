package InterviewExamples.ParkingLot.Tickets;

import InterviewExamples.ParkingLot.Parking.Spot.ParkingSpot;
import InterviewExamples.ParkingLot.Vehicles.Vehicle;

import java.time.LocalDateTime;


public class Ticket {

    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime entryTime;


    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

   public ParkingSpot getParkingSpot(){
        return parkingSpot;
   }

   public LocalDateTime getEntryTime(){
        return entryTime;
   }
}


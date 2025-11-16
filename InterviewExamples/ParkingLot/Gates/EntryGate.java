package InterviewExamples.ParkingLot.Gates;

import InterviewExamples.ParkingLot.Parking.Factory.ParkingSpotFactory;
import InterviewExamples.ParkingLot.Parking.Manager.ParkingSpotManager;
import InterviewExamples.ParkingLot.Parking.Spot.ParkingSpot;
import InterviewExamples.ParkingLot.Tickets.Ticket;
import InterviewExamples.ParkingLot.Vehicles.Vehicle;

public class EntryGate {

    private ParkingSpotFactory parkingSpotFactory;
    private ParkingSpotManager parkingSpotManager;

    public ParkingSpot bookSpot(Vehicle vehicle){
        return parkingSpotManager.parkVehicle(vehicle);
    }

    public ParkingSpot findParkingSpot(){
        return parkingSpotManager.findParkingSpot();
    }

    public Ticket generateTicket(Vehicle vehicle){
        ParkingSpot spot = bookSpot(vehicle);
        return new Ticket(vehicle, spot);
    }


}

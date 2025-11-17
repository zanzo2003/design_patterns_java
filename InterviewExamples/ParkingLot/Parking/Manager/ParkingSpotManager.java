package InterviewExamples.ParkingLot.Parking.Manager;

import InterviewExamples.ParkingLot.Parking.Spot.ParkingSpot;
import InterviewExamples.ParkingLot.Vehicles.Vehicle;

public interface ParkingSpotManager {

    void addParkingSpot(ParkingSpot parkingSpot);

    void removeParkingSpot(ParkingSpot parkingSpot);

    ParkingSpot findParkingSpot();

    ParkingSpot parkVehicle(Vehicle vehicle);

    ParkingSpot removeVehicle(Vehicle vehicle);
}

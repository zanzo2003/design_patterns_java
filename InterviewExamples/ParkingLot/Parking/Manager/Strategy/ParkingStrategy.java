package InterviewExamples.ParkingLot.Parking.Manager.Strategy;

import InterviewExamples.ParkingLot.Parking.Spots.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {


    ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpots);
}

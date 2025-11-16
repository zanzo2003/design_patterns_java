package InterviewExamples.ParkingLot.Parking.Strategy;

import InterviewExamples.ParkingLot.Parking.Spot.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {


    ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpots);
}

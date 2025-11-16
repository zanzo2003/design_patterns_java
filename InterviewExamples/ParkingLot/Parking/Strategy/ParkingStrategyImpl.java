package InterviewExamples.ParkingLot.Parking.Strategy;

import InterviewExamples.ParkingLot.Parking.Spot.ParkingSpot;
import java.util.List;

public class ParkingStrategyImpl implements ParkingStrategy{


    /*
    This is the finding algorithm, we can enhance the search, or implement based on requirements like finding the nearest to the entry point or exit point
    etc.
     */

    @Override
    public ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpots) {
        for(ParkingSpot parkingSpot: parkingSpots){
            if(parkingSpot.isEmpty()){
                return parkingSpot;
            }
        }
        return null;
    }
}

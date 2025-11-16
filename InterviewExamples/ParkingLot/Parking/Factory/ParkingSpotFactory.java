package InterviewExamples.ParkingLot.Parking.Factory;

import InterviewExamples.ParkingLot.Parking.Manager.FourWheelerParkingManger;
import InterviewExamples.ParkingLot.Parking.Manager.ParkingSpotManager;
import InterviewExamples.ParkingLot.Parking.Manager.TwoWheelerParkingManager;
import InterviewExamples.ParkingLot.Vehicles.Vehicle;
import InterviewExamples.ParkingLot.Vehicles.VehicleType;

public class ParkingSpotFactory {

    private final ParkingSpotManager twoWheelerParkingManager;
    private final ParkingSpotManager fourWheelerParkingSpotManager;

    public ParkingSpotFactory(TwoWheelerParkingManager twoWheelerParkingManager, FourWheelerParkingManger fourWheelerParkingSpotManager){
        this.twoWheelerParkingManager = twoWheelerParkingManager;
        this.fourWheelerParkingSpotManager = fourWheelerParkingSpotManager;

    }

    public ParkingSpotManager getParkingSpotManger(Vehicle vehicle){
        if(vehicle.getVehicleType().equals(VehicleType.TwoWheeler)){
            return twoWheelerParkingManager;
        }
        else if( vehicle.getVehicleType().equals(VehicleType.FourWheeler)){
            return fourWheelerParkingSpotManager;
        }
        throw new IllegalArgumentException("Invalid Vehicle Type");

    }
}

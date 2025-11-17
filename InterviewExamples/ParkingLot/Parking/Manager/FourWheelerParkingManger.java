package InterviewExamples.ParkingLot.Parking.Manager;

import InterviewExamples.ParkingLot.Parking.Strategy.ParkingStrategy;
import InterviewExamples.ParkingLot.Parking.Spot.FourWheelerParkingSpot;
import InterviewExamples.ParkingLot.Parking.Spot.ParkingSpot;
import InterviewExamples.ParkingLot.Vehicles.Vehicle;
import InterviewExamples.ParkingLot.Vehicles.VehicleType;

import java.util.List;

public class FourWheelerParkingManger implements ParkingSpotManager{


    private List<ParkingSpot> parkingSpots;
    private ParkingStrategy parkingStrategy;

    public FourWheelerParkingManger(List<ParkingSpot> parkingSpots, ParkingStrategy parkingStrategy){
        if(!validateListParkingSpot(parkingSpots)) throw new IllegalArgumentException("Invalid Parking Spot Type");
        this.parkingSpots = parkingSpots;
        this.parkingStrategy = parkingStrategy;
    }


    @Override
    public void addParkingSpot(ParkingSpot parkingSpot) {
        if( validateParkingSpot(parkingSpot)) {
            this.parkingSpots.add(parkingSpot);
        }
        else throw new IllegalArgumentException("Invalid Parking Spot Type");

    }

    @Override
    public void removeParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.remove(parkingSpot);

    }

    @Override
    public ParkingSpot findParkingSpot() {
        return parkingStrategy.findParkingSpot(parkingSpots);
    }

    @Override
    public ParkingSpot parkVehicle(Vehicle vehicle) {
        if(!validateVehicle(vehicle)) throw new IllegalArgumentException("Invalid Vehicle Type");
        ParkingSpot parkingSpot = findParkingSpot();
        if (parkingSpot != null) parkingSpot.setParkedVehicle(vehicle);
        else throw new RuntimeException("No parking spots available!!");
        return parkingSpot;
    }

    @Override
    public ParkingSpot removeVehicle(Vehicle vehicle) {
        ParkingSpot spot = null;
        for(ParkingSpot parkingSpot: parkingSpots){
            if(!parkingSpot.isEmpty() && parkingSpot.getParkedVehicle().equals(vehicle)){
                parkingSpot.removeParkedVehicle();
                spot = parkingSpot;
            }
        }
        return spot;
    }


    private boolean validateVehicle( Vehicle vehicle){
        return vehicle.getVehicleType().equals(VehicleType.FourWheeler);
    }

    private boolean validateListParkingSpot(List<ParkingSpot> parkingSpots){
        return parkingSpots.stream()
                .allMatch(this::validateParkingSpot);
    }

    private boolean validateParkingSpot(ParkingSpot parkingSpot){
        return parkingSpot instanceof FourWheelerParkingSpot;
    }
}

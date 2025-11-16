package InterviewExamples.ParkingLot.Parking.Spot;

import InterviewExamples.ParkingLot.Vehicles.Vehicle;

public interface ParkingSpot {

    void setParkedVehicle(Vehicle parkedVehicle) ;

    public void removeParkedVehicle();

    // Getters
    public boolean isEmpty();
    public int getId();
    public int getPrice();
    public Vehicle getParkedVehicle();
}

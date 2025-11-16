package InterviewExamples.ParkingLot.Parking.Spot;

import InterviewExamples.ParkingLot.Vehicles.Vehicle;
import InterviewExamples.ParkingLot.Vehicles.VehicleType;

public class TwoWheelerParkingSpot implements ParkingSpot {

    private final int id;
    private boolean isEmpty;
    private Vehicle parkedVehicle;
    private final int price;

    public TwoWheelerParkingSpot(int id, int price){
        this.id = id;
        this.price = price;
        this.isEmpty = true;
    }


    @Override
    public void setParkedVehicle(Vehicle vehicle) {
        validate(vehicle);
        this.parkedVehicle = vehicle;
        this.isEmpty = false;
    }

    @Override
    public void removeParkedVehicle() {
        this.parkedVehicle = null;
        this.isEmpty = true;
    }

    @Override
    public boolean isEmpty() {
        return this.isEmpty;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }


    private void validate(Vehicle vehicle){
        if (!isEmpty) throw new IllegalStateException("Spot already occupied!");
        if ( !vehicle.getVehicleType().equals(VehicleType.TwoWheeler)) throw new IllegalArgumentException("Cant parking your vehicle here!!");
    }

}

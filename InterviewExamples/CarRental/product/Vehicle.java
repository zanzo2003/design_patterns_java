package InterviewExamples.CarRental.product;

import InterviewExamples.CarRental.constants.VehicleStatus;
import InterviewExamples.CarRental.constants.VehicleType;

import java.util.UUID;

public class Vehicle {

    private String vehicleId;
    private String registrationNumber;
    private VehicleType type;
    private VehicleStatus status;
    private double dailyRentalPrice;

    // ------------ Constructors -------------------

    public Vehicle( String registrationNumber, VehicleType type , double price ) {
        this.vehicleId = UUID.randomUUID().toString();
        this.registrationNumber = registrationNumber;
        this.type = type;
        this.status = VehicleStatus.AVAILABLE;
        this.dailyRentalPrice = price;
    }

    // ---------------- Getters ------------------

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public double getDailyRentalPrice() {
        return dailyRentalPrice;
    }


    //---------------- Setters ------------------

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public void setDailyRentalPrice( double price ){
        this.dailyRentalPrice = price;
    }

}

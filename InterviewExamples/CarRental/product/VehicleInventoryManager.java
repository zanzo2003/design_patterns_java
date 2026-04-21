package InterviewExamples.CarRental.product;


import InterviewExamples.CarRental.constants.VehicleType;
import InterviewExamples.CarRental.reservation.ReservationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class VehicleInventoryManager {

    private final Map< String , Vehicle > vehicleList = new ConcurrentHashMap<>();
    private final Map< String , List<String>> reservedVehicles = new ConcurrentHashMap<>();
    private final Map< String , ReentrantLock > vehicleLocks = new ConcurrentHashMap<>();
    private ReservationRepository reservationRepository;

    public void addVehicle( Vehicle vehicle ){}

    public void removeVehicle( String vehicleId ){}

    public void setReservationRepository( ReservationRepository repository ){
        this.reservationRepository = repository;
    }

    public boolean isVehicleAvailable( String vehicleId , LocalDate from , LocalDate to ){ return false; }

    public boolean reserveVehicle( String vehicleId , String reservationId , LocalDate from , LocalDate to ){ return false;}

    public boolean releaseVehicle( String vehicleId , String reservationId ){ return false;}

    public List<Vehicle> getAvailableVehicles( VehicleType type , LocalDate from , LocalDate to ){ return null; }


}

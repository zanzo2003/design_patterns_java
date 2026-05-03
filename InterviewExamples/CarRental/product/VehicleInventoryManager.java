package InterviewExamples.CarRental.product;


import InterviewExamples.CarRental.reservation.Reservation;
import InterviewExamples.CarRental.reservation.ReservationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class VehicleInventoryManager {

    private final Map< String , Vehicle > vehicleList = new ConcurrentHashMap<>();
    private final Map< String , List<String>> reservedVehicles = new ConcurrentHashMap<>();
    private final Map< String , ReentrantLock > vehicleLocks = new ConcurrentHashMap<>();
    private ReservationRepository reservationRepository;

    public void setReservationRepository( ReservationRepository repository ){
        this.reservationRepository = repository;
    }


    public void addVehicle( Vehicle vehicle ){
        String vehicleId = vehicle.getVehicleId();
        if( !vehicleList.containsKey( vehicleId ) ){
            vehicleList.put( vehicleId , vehicle );
            vehicleLocks.put( vehicleId , new ReentrantLock() );
        }
        return ;
    }

    public void removeVehicle( String vehicleId ){
        if( vehicleList.containsKey( vehicleId ) && !vehicleLocks.get( vehicleId ).isLocked() ){
            vehicleList.remove( vehicleId );
        }
        return ;
    }



    public boolean isVehicleAvailable( String vehicleId , LocalDate from , LocalDate to ){
        Vehicle vehicle = vehicleList.get( vehicleId );

        if( vehicle  == null || vehicle.getStatus() == VehicleStatus.MAINTENANCE ){
            return false;
        }

        List<Optional<Reservation>> reservations = reservedVehicles.get( vehicleId ).stream()
                .map( id -> reservationRepository.findById(id) )
                .filter( reservation -> reservation != null )
                .toList();

        if(reservations.isEmpty()){
            return true;
        }

        DateInterval requestedInterval = new DateInterval( from , to );
        boolean conflict = reservations.stream()
                .filter( reservation -> reservation.isPresent() )
                .anyMatch( reservation -> {
                    Reservation currentReservation = reservation.get();
                    return requestedInterval
                            .isOverlap(new DateInterval(currentReservation.getFrom(), currentReservation.getTo()));
                });

        return conflict;
    }

    public boolean reserveVehicle( String vehicleId , String reservationId , LocalDate from , LocalDate to ){ return false;}

    public boolean releaseVehicle( String vehicleId , String reservationId ){ return false;}



    public List<Vehicle> getAvailableVehicles( VehicleType type , LocalDate from , LocalDate to ){ return null; }

}

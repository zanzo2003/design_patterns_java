package InterviewExamples.CarRental.reservation;


import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/*

 * The ResercationRepositoy as the name suggests maintains all the confirmed reservation
    in a thread safe map.
 * Other classes can reservation, remove them and access them by passing the reservationId.

 */


public class ReservationRepository {

    private Map<String, Reservation> reservations;

    public ReservationRepository(){
        this.reservations = new ConcurrentHashMap<>();
    }

    // Save or update reservation
    public void save(Reservation reservation) {
        reservations.put(reservation.getReservationId(), reservation);
    }

    // Lookup reservation by ID
    public Optional<Reservation> findById(String reservationId) {
        return Optional.ofNullable(reservations.get(reservationId));
    }

    // Delete reservation from repository
    public void remove(String reservationId) {
        reservations.remove(reservationId);
    }

    // Return all reservations (for reporting/debug)
    public Map<String, Reservation> getAll() {
        return reservations;
    }


}

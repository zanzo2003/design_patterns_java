package InterviewExamples.CarRental.reservation;

import InterviewExamples.CarRental.constants.ReservationStatus;
import InterviewExamples.CarRental.constants.ReservationType;

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {

    private final String reservationId;
    private final String userId;
    private final String vehicleId;
    private final LocalDate from;
    private final LocalDate to;
    private final ReservationType reservationType;
    private ReservationStatus reservationStatus;


    //----------------- CONSTRUCTORS ---------------------------

    public Reservation( String vehicleId,
                       String userId,
                       LocalDate dateBookedFrom,
                       LocalDate dateBookedTo,
                       ReservationType reservationType) {

        this.reservationId = UUID.randomUUID().toString();
        this.vehicleId = vehicleId;
        this.userId = userId;
        this.from = dateBookedFrom;
        this.to = dateBookedTo;
        this.reservationType = reservationType;
        this.reservationStatus = ReservationStatus.CONFIRMED;
    }



    //-------------------GETTERS-------------------------

    public String getUserId() {
        return userId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    //--------------------- SETTERS--------------------------

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

}

package InterviewExamples.CarRental.constants;


/*
------- JAVADOC---------
 * this represent the different status that a vehicle can have.
 * A vehicle is either booked , or available or has gone for service.
 * When booking a vehicle these status need to be considered .
 * if available, only then will the booking proceed.
 */


public enum VehicleStatus {

    BOOKED ,
    AVAILABLE ,
    MAINTENANCE

}

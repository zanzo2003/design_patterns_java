package InterviewExamples.CarRental.product;

import java.time.LocalDate;

public class DateInterval {

    private LocalDate from;
    private LocalDate to;

    public DateInterval( LocalDate from , LocalDate to ) throws IllegalArgumentException{
        if( from.isAfter( to ) ){
            throw new IllegalArgumentException(" Start date of the reservation can't be after the End date");
        }
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }


    public boolean isOverlap( DateInterval other ){
        return !( this.from.isAfter( other.to ) || this.to.isBefore( other.from ) );

        /*
         Two date ranges overlap if they share at least one common day.

         Example of overlap:
         This  : 10 May -> 15 May
         Other : 14 May -> 20 May

         Common dates = 14,15 May


         Instead of checking overlap directly,
         we check when they DO NOT overlap.

         Non-overlap can happen in only 2 cases:

         Case 1:
         This interval starts AFTER the other one ends

         Example:
         This  : 20 May -> 25 May
         Other : 10 May -> 15 May

         Here:
         this.from.isAfter(other.to) == true


         Case 2:
         This interval ends BEFORE the other one starts

         Example:
         This  : 10 May -> 12 May
         Other : 15 May -> 18 May

         Here:
         this.to.isBefore(other.from) == true


         If either case is true => no overlap.

         Therefore:
         overlap = NOT(no overlap)
        */
    }
}

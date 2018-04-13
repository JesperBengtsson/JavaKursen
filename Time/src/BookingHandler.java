import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BookingHandler {

    ArrayList<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking) {
        //lägger in ny datetime is listan
        bookings.add(booking);
    }
    public void listBookings() {
        for (Booking booking : bookings) {
            //formaterar datetime och printar datetime
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            System.out.println(formatter.format(booking.getStart()) + "  -  " + formatter.format(booking.getEnd()));
        }
    }
    public boolean isListEmpty() {
        return bookings.size() == 0;
    }
    //kollar om någon datetime som förs in är emellan bookingen som också skickats in
    public boolean isBetween(LocalDateTime datetime, Booking booking){
        return !datetime.isBefore(booking.getStart()) && !datetime.isAfter(booking.getEnd());
    }
    //kollar ifall bookingen som skickas in överlappar nån av dom befintliga bookningar
    public boolean checkIfDatetimeOverlaps(Booking newBooking) {
        for (Booking booking : bookings) {
            if (isBetween(newBooking.getStart(), booking) || isBetween(newBooking.getEnd(), booking)
            		|| ifOverlapping(booking, newBooking)) {
                return true;
            }
        } return false;
    }
    public boolean ifOverlapping(Booking booking, Booking newBooking){
        return newBooking.getStart().isBefore(booking.getStart()) && newBooking.getEnd().isAfter(booking.getEnd());
    }
}
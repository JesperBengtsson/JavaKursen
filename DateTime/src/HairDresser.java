import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HairDresser {
    private List<Booking> bookings;
    private String name;
    private double price;
    private String description;

    public HairDresser(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.bookings = new ArrayList<>();
    }

    public void addBooking(LocalDateTime start, LocalDateTime end, double price) {
        bookings.add(new Booking(start, end, price));
    }

    public void listBookings() {
        for (Booking booking : bookings) {
            //formaterar datetime och printar datetime
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            System.out.println(formatter.format(booking.getStart()) + "  -  " + formatter.format(booking.getEnd())
                    + " Price: " + booking.getPrice() + "kr");
        }
    }

    public boolean isBetween(LocalDateTime datetime, Booking booking){
        return !datetime.isBefore(booking.getStart()) && !datetime.isAfter(booking.getEnd());
    }

    public boolean ifOverlapping(LocalDateTime start ,LocalDateTime end, Booking booking){
        return start.isBefore(booking.getStart()) && end.isAfter(booking.getEnd());
    }

    //kollar ifall bookingen som skickas in överlappar nån av dom befintliga bookningar
    public boolean checkIfDatetimeOverlaps(LocalDateTime start, LocalDateTime end) {
        for (Booking booking : bookings) {
            if (isBetween(start, booking) || isBetween(end, booking)
                    || ifOverlapping(start, end, booking)) {
                return true;
            }
        } return false;
    }

    //räknar ut pris för klippning per min
    public double calculatePriceMin(LocalDateTime start, LocalDateTime end) {
        Duration diff = Duration.between(start, end);
        double diffMin = (diff.toMinutes()*5);
        return diffMin;
    }

    // Getters and setters

    public List<Booking> getBookings() {
        return bookings;
    }
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
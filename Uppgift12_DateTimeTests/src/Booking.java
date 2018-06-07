import java.time.LocalDateTime;

public class Booking {

    private LocalDateTime myEnd;
    private LocalDateTime myStart;
    private double myPrice;

    public Booking(LocalDateTime myStart, LocalDateTime myEnd, double myPrice) {
        this.myStart = myStart;
        this.myEnd = myEnd;
        this.myPrice = myPrice;
    }

    // Getters and setters

    public void setStart(LocalDateTime myStart) {
        this.myStart = myStart;
    }
    public LocalDateTime getStart() {
        return this.myStart;
    }
    public void setEnd(LocalDateTime myEnd) {
        this.myEnd = myEnd;
    }
    public LocalDateTime getEnd() {
        return this.myEnd;
    }
    public double getPrice() {
        return myPrice;
    }
    public void setPrice(double myPrice) {
        this.myPrice = myPrice;
    }
}
import java.time.LocalDateTime;

public class Booking {

    private LocalDateTime myStart;
    private LocalDateTime myEnd;
  
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
}
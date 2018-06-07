import org.junit.Test;
import org.junit.Before;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class HairDresserTest {

    @Before
    public void setUp(){
    }

    @Test
    public void addBokingWithoutOverlapAndPrice() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        HairDresserHandler hairDresser = new HairDresserHandler();
        HairDresser dresser = hairDresser.getDresser(0);
        LocalDateTime start1 = LocalDateTime.parse("2018-01-01 12:00", formatter);
        LocalDateTime end1 = LocalDateTime.parse("2018-01-01 13:00", formatter);
        dresser.addBooking(start1, end1, dresser.calculatePriceMin(start1, end1));
        assertEquals("Booking wasn't added properly", 1, dresser.getBookings().size());

        LocalDateTime start2 = LocalDateTime.parse("2018-01-01 13:01", formatter);
        LocalDateTime end2 = LocalDateTime.parse("2018-01-01 14:00", formatter);
        dresser.addBooking(start2, end2, dresser.calculatePriceMin(start2, end2));
        assertEquals("Booking wasn't added properly", 2, dresser.getBookings().size());
    }

    @Test
    public void addBookingStarttimeOverlap() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        HairDresserHandler hairDresser = new HairDresserHandler();
        HairDresser dresser = hairDresser.getDresser(0);
        LocalDateTime start1 = LocalDateTime.parse("2018-01-01 12:00", formatter);
        LocalDateTime end1 = LocalDateTime.parse("2018-01-01 13:00", formatter);
        dresser.addBooking(start1, end1, dresser.calculatePriceMin(start1, end1));

        LocalDateTime start2 = LocalDateTime.parse("2018-01-01 12:30", formatter);
        LocalDateTime end2 = LocalDateTime.parse("2018-01-01 13:30", formatter);
            if (!dresser.checkIfDatetimeOverlaps(start2, end2)) {
                dresser.addBooking(start2, end2, dresser.calculatePriceMin(start2, end2));
            }
        assertEquals("Overlap check not working properly", 1, dresser.getBookings().size());
    }

    @Test
    public void addBookingEndtimeOverlaps() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        HairDresserHandler hairDresser = new HairDresserHandler();
        HairDresser dresser = hairDresser.getDresser(0);
        LocalDateTime start1 = LocalDateTime.parse("2018-01-01 12:00", formatter);
        LocalDateTime end1 = LocalDateTime.parse("2018-01-01 13:00", formatter);
        dresser.addBooking(start1, end1, dresser.calculatePriceMin(start1, end1));

        LocalDateTime start2 = LocalDateTime.parse("2018-01-01 11:30", formatter);
        LocalDateTime end2 = LocalDateTime.parse("2018-01-01 12:30", formatter);
        if (!dresser.checkIfDatetimeOverlaps(start2, end2)) {
            dresser.addBooking(start2, end2, dresser.calculatePriceMin(start2, end2));
        }
        assertEquals("Overlap check not working properly", 1, dresser.getBookings().size());
    }

    @Test
    public void addBookingTimeOverlaps() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        HairDresserHandler hairDresser = new HairDresserHandler();
        HairDresser dresser = hairDresser.getDresser(0);
        LocalDateTime start1 = LocalDateTime.parse("2018-01-01 12:00", formatter);
        LocalDateTime end1 = LocalDateTime.parse("2018-01-01 13:00", formatter);
        dresser.addBooking(start1, end1, dresser.calculatePriceMin(start1, end1));

        LocalDateTime start2 = LocalDateTime.parse("2018-01-01 11:30", formatter);
        LocalDateTime end2 = LocalDateTime.parse("2018-01-01 13:30", formatter);
        if (!dresser.checkIfDatetimeOverlaps(start2, end2)) {
            dresser.addBooking(start2, end2, dresser.calculatePriceMin(start2, end2));
        }
        assertEquals("Overlap check not working properly", 1, dresser.getBookings().size());
    }

    @Test
    public void addBookingTimeIsBetween() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        HairDresserHandler hairDresser = new HairDresserHandler();
        HairDresser dresser = hairDresser.getDresser(0);
        LocalDateTime start1 = LocalDateTime.parse("2018-01-01 12:00", formatter);
        LocalDateTime end1 = LocalDateTime.parse("2018-01-01 13:00", formatter);
        dresser.addBooking(start1, end1, dresser.calculatePriceMin(start1, end1));

        LocalDateTime start2 = LocalDateTime.parse("2018-01-01 12:10", formatter);
        LocalDateTime end2 = LocalDateTime.parse("2018-01-01 12:30", formatter);
        if (!dresser.checkIfDatetimeOverlaps(start2, end2)) {
            dresser.addBooking(start2, end2, dresser.calculatePriceMin(start2, end2));
        }
        assertEquals("Overlap check not working properly", 1, dresser.getBookings().size());
    }

    @Test
    public void calculatePrice() {
        HairDresserHandler hairDresser = new HairDresserHandler();
        HairDresser dresser = hairDresser.getDresser(0);
        assertEquals("Not calculating properly", 300,
                dresser.calculatePriceMin(LocalDateTime.of(2018, 1, 1, 12, 0), LocalDateTime.of(2018, 1, 1, 13, 0)), 0);
    }
}
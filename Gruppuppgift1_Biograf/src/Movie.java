import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Movie {
    private String Time;
    private String Name;
    private HashMap<Integer, String> SeatMap;

    public Movie(String name, String time) {
        this();
        Time = time;
        Name = name;
    }

    public void bookSeats(int startSeat, int numOfSeats) {
        if(startSeat + numOfSeats > (SeatMap.size() + 1) || numOfSeats < 0 || numOfSeats > 10) {
            System.out.println("Platsen finns inte");
            return;
        }
        for(int i = startSeat; i < startSeat + (numOfSeats -1); i++) {
            if(SeatMap.get(i).equals("U")) {
                System.out.println("En av platserna är upptagen");
                return;
            }
        }
        for(int i = startSeat; i < (startSeat) + numOfSeats; i++) {
            SeatMap.put((i - 1), "U");
        }
        System.out.println(SeatMap.values());
    }

    public void bookSeatsFree(int numOfSeats) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = 0;
        int count = 0;

        while(count < numOfSeats && numOfSeats < 10) {

            System.out.println("Välj plats " + (count + 1) + " av " + numOfSeats);
            try {
                input = Integer.parseInt(br.readLine());
                if(input < 1 || input > 10) {
                    System.out.println("Den plats du angivit finns inte.");
                    continue;
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("invalid input");
            }
            try{
            if(SeatMap.get(input - 1).equals("U")) {
                System.out.println("Plats " + input + " är upptagen. välj en ny");
                continue;
            }
            SeatMap.replace(input - 1, "U");

            count++;
        }catch (NullPointerException e) {
                System.out.println("Invalid input");
            }
        }

        System.out.println(SeatMap.values());

    }

    public void printSeats() {
        for(int i = 0; i < SeatMap.size(); i++) {
            System.out.println("Plats " + (i + 1) + ": " + SeatMap.get(i));
        }
    }

    // Getters and setters

    public Movie(){
        SeatMap = new HashMap<Integer, String>();
        for(int i = 0; i < 10; i++) {
            SeatMap.put(i, "A");
        }
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public HashMap<Integer, String> getSeatMap() {
        return SeatMap;
    }
}
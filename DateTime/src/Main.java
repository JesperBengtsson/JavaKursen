import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        HairDresserHandler hairDresser = new HairDresserHandler();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = "";

        while(!command.equals("EXIT")) {
            System.out.println("--------MENU--------\n"
                    + "[0] To select hairdresser\n[1] To see ALL bookings\nTYPE EXIT TO EXIT \n"
                    + "--------------------");
            command = reader.readLine();

            if(command.equals("0")) {
                HairDresser dresser = null;
                while(dresser == null) {
                    System.out.println("Choose a hairdresser");
                    hairDresser.printDressers(true);
                    System.out.println("[MENU] Back to menu");
                    command = reader.readLine();
                    if(command.equals("MENU")) {
                        break;
                    }
                    else {
                        try {
                            int index = Integer.parseInt(command);
                            dresser = hairDresser.getDresser(index);
                        }
                        catch (NumberFormatException | IndexOutOfBoundsException e) {
                            System.out.println("Invalid input");
                            continue;
                        }
                    }
                }
                if(command.equals("MENU")) {
                    continue;
                }
                while (!command.equals("MENU")){
                    System.out.println("You're working with " + dresser.getName());
                    System.out.println("[0] To add booking\n[1] To see all bookings\n[MENU] Back to menu");
                    command = reader.readLine();

                    if(command.equals("0")) {
                        System.out.println("Enter starttime after format(yyyy-MM-dd HH:mm):");
                        String start = reader.readLine();
                        System.out.println("Enter endtime after format(yyyy-MM-dd HH:mm: ");
                        String end = reader.readLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        try {
                            LocalDateTime startDateTime = LocalDateTime.parse(start, formatter);
                            LocalDateTime endDateTime = LocalDateTime.parse(end, formatter);
                            if (!dresser.checkIfDatetimeOverlaps(startDateTime, endDateTime)) {
                                dresser.addBooking(startDateTime, endDateTime, dresser.calculatePriceMin(startDateTime, endDateTime));
                                System.out.println("Booking added to: " + dresser.getName());
                            } else System.out.println("Time of booking already exists");
                        } catch(DateTimeParseException | NullPointerException e) {
                            System.out.println("Invalid input");
                            continue;
                        }
                    }
                    else if(command.equals("1")) {
                        dresser.listBookings();
                    }
                }
            }
            else if(command.equals("1")){
                hairDresser.printAllBookings();
            }
        }
    }
}
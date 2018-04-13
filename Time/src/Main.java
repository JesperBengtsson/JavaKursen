import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        BookingHandler handler = new BookingHandler();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String command = "";

        while(!command.equals("EXIT")) {
            System.out.println("--------MENU--------\n"
                    + "[A] Show list\n[B] New booking\nTYPE EXIT TO EXIT \n"
                    + "--------------------");
            command = reader.readLine();
            if(command.equals("A")) {
                //kollar om userinput är A, isf visar listan
                handler.listBookings();
                continue;
            }
            if(command.equals("B")) {
                //kollar om userinput är B, isf går vidare och får skriva in datetime
                Booking newBooking = new Booking();
                while(handler.isListEmpty() || command.equals("B")) {
                    //läser av userinput datetimes, starttid och endtid
                    System.out.println("Example: 2018-04-12 09:23\nEnter a start date: ");
                    String start = reader.readLine();
                    System.out.println("Example: 2018-04-12 09:23\nEnter a end date: ");
                    String end = reader.readLine();
                    //try catch på formateringen så att man inte kan skriva in invalid input
                    //printar Not valid om det inte stämmer med formateringen
                    try {
                        newBooking.setStart(LocalDateTime.parse(start, formatter));
                        newBooking.setEnd(LocalDateTime.parse(end, formatter));
                    }
                    catch(Exception E) {
                        System.out.println("Not valid");
                        continue;
                    }
                    //callar funktion från bookinghandler som kollar om datetimes redan finns i listan
                    //finns det inte läggs den in i listan och breakar while loopen och går tillbaka till menyn
                    if(!handler.checkIfDatetimeOverlaps(newBooking)) {
                        handler.addBooking(newBooking);
                        break;
                    }
                    else {
                        //finns userinputs datetime i listan frågas om du vill lägga in en ny tid eller gå
                        //tillbaka till menyn
                        System.out.println("Input already exists!\n[Y] Try again\n[N] Back to menu");
                        command = reader.readLine();
                        if(command.equals("N")) {
                            break;
                        }
                        else if(command.equals("Y")) {
                            command = "B";
                            continue;
                        }
                        else
                            break;
                    }
                }
            }
        }
    }
}
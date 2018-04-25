import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        BookingHandler handler = new BookingHandler();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
       
       final String A, B, Y, N, EXIT;
       A = "A";
       B = "B";
       Y = "Y";
       N = "N";
       EXIT = "EXIT";
       
       String command = "";

        while(!EXIT.equals(command)) {
            System.out.println("--------MENU--------\n"
                    + "[A] Show list\n[B] New booking\nTYPE EXIT TO EXIT \n"
                    + "--------------------");
            command = reader.readLine();
            if(A.equals(command)) {
                //kollar om userinput �r A, isf visar listan s� l�nge den inte �r tom
            	if(!handler.isListEmpty()) {            		
            		handler.listBookings();
            		continue; 
                } else
                	System.out.println("List is empty!");
                	continue;            
            }
            if(B.equals(command)) {
                //kollar om userinput �r B, isf g�r vidare och f�r skriva in datetime
                Booking newBooking = new Booking();
                while(handler.isListEmpty() || command.equals(B)) {
                    //l�ser av userinput datetimes, starttid och endtid
                    System.out.println("Example: 2018-04-12 09:23\nEnter a start date: ");
                    String start = reader.readLine();
                    System.out.println("Example: 2018-04-12 09:23\nEnter a end date: ");
                    String end = reader.readLine();
                    //try catch p� formateringen s� att man inte kan skriva in invalid input
                    //printar invalid input om det inte st�mmer med formateringen
                    try {
                    	newBooking.setStart(LocalDateTime.parse(start, formatter));
                    	newBooking.setEnd(LocalDateTime.parse(end, formatter));
                    }
                    catch(DateTimeParseException | NullPointerException E) {
                        System.out.println("Invalid input!\n[Y] Try again\n[N] Back to menu");
                        command = reader.readLine();
                        if(N.equals(command)) {
                        	break;
                        }
                        else if(Y.equals(command)) {
                        	continue;
                        }
                        else 
                        	break;
                    }
                    //callar funktion fr�n bookinghandler som kollar om datetimes redan finns i listan
                    //finns det inte l�ggs den in i listan och breakar while loopen och g�r tillbaka till menyn          
                    if(!handler.checkIfDatetimeOverlaps(newBooking)) {
                        handler.addBooking(newBooking);
                        break;
                    }
                    else {
                        //finns userinputs datetime i listan fr�gas om du vill l�gga in en ny tid eller g�
                        //tillbaka till menyn
                        System.out.println("Input already exists!\n[Y] Try again\n[N] Back to menu");
                        command = reader.readLine();
                        if(N.equals(command)) {
                            break;
                        }
                        else if(Y.equals(command)) {
                            command = B;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//GRUPPUPPGIFT_1_BIO JESPER BENGTSSON, KARL-GUSTAV LARSSON

public class Main {
    public static void main(String[] args) {
        TheaterHandler theaterHandler = new TheaterHandler();
        String command = "";
        while (!command.toLowerCase().equals("exit")) {

            System.out.println("[0] För att välja salong\n[1] För att se all salonger\n[2] För se alla filmer i alla salonger");

            command = readLine();

            if (command.equals("0")) {
                Salon salon = null;
                while (salon == null) {
                    System.out.println("Välj en salong");
                    theaterHandler.printSalons(true);
                    salon = theaterHandler.getSalon(readAndParse());
                }
                System.out.println("Du jobbar med salong: " + salon.getSalonName());
                System.out.println("[0] För att lägga till en film\n[1] För att se alla filmer\n[2] För att välja film");
                command = readLine();
                if(command.equals("0")) {
                    System.out.println("Namn på film");
                    String name = readLine();
                    System.out.println("Tid för film");
                    String time = readLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                    try {
                        LocalTime.parse(time, formatter);
                    }
                    catch(DateTimeParseException | NullPointerException E) {
                        System.out.println("Invalid input!");
                            break;
                    }
                    salon.addMovie(name, time);
                }
                else if(command.equals("1")) {
                    salon.printMovies(false);
                }
                else if(command.equals("2")) {
                    System.out.println("Välj en film\n");
                    salon.printMovies(true);
                    Movie movie = salon.getMovie(readAndParse());
                    System.out.println("Lediga platser för filmen\n");
                    movie.printSeats();
                    System.out.println("[0] För länkande platser\n [1] För fria platser");
                    command = readLine();
                    if(command.equals("0")) {
                        System.out.println("Ange startplats\n");
                        int startSeat = readAndParse();
                        System.out.println("Ange antal platser\n");
                        int numSeats = readAndParse();
                        movie.bookSeats(startSeat, numSeats);
                    }
                    else if(command.equals("1")) {
                        System.out.println("Ange antal platser");
                        int numSeats = readAndParse();
                        movie.bookSeatsFree(numSeats);
                    }
                }
            }

            else if (command.equals("1")) {
                theaterHandler.printSalons(false);
            }

            else if (command.equals("2")) {
                theaterHandler.printAllMovies();
            }
        }


    }

    private static String readLine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = "";
        try {
            tmp = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    private static int readAndParse() {
        String tmp = readLine();
        try {
            int tmpInt = Integer.parseInt(tmp);
            return tmpInt;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            return 0;
        }
    }
}
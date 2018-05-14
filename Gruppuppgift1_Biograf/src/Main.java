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
        while (!command.equals("EXIT")){
            System.out.println("[0] F�r att v�lja salong\n[1] F�r att se all salonger\n[2] F�r se alla filmer i alla salonger");

            command = readLine();

            if (command.equals("0")) {
                Salon salon = null;
                while (salon == null) {
                    System.out.println("V�lj en salong");
                    theaterHandler.printSalons(true);
                    System.out.println("[MENU] Back to menu");
                    command = readLine();
                    if (command.equals("MENU")) {
                        break;
                    } else {
                        try {
                            int index = Integer.parseInt(command);
                            salon = theaterHandler.getSalon(index);
                        } catch (NumberFormatException | IndexOutOfBoundsException e) {
                            System.out.println("Invalid input");
                            continue;
                        }
                    }

                }
                if (command.equals("MENU")) {
                    continue;
                }
                while (!command.equals("MENU")) {
                    System.out.println("Du jobbar med salong: " + salon.getSalonName());
                    System.out.println("[0] F�r att l�gga till en film\n[1] F�r att se alla filmer\n[2] F�r att v�lja film\n[MENU] Back to menu");
                    command = readLine();

                    if (command.equals("0")) {
                        System.out.println("Namn p� film");
                        String name = readLine();
                        System.out.println("Tid f�r film");
                        String time = readLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                        try {
                            LocalTime.parse(time, formatter);
                        } catch (DateTimeParseException | NullPointerException E) {
                            System.out.println("Invalid input!");
                            continue;
                        }
                        if(!salon.checkIfTimeExists(time)) {
                        salon.addMovie(name, time);
                        }
                        else System.out.println("Tiden �r redan bokad");
                    } else if (command.equals("1")) {
                        salon.printMovies(false);
                    } else if (command.equals("2")) {
                        System.out.println("V�lj en film\n");
                        salon.printMovies(true);
                        Movie movie = salon.getMovie(readAndParse());
                        if (movie == null) {
                            System.out.println("filmen finns ej");
                            continue;
                        } else if (movie != null) {
                            System.out.println("Lediga platser f�r filmen\n");
                            movie.printSeats();
                            System.out.println("A = Ledig plats\nU = Upptagen plats\n[0] F�r l�nkande platser\n[1] F�r fria platser");
                            command = readLine();
                            if (command.equals("0")) {
                                System.out.println("Ange antal platser du vill boka");
                                int numSeats = readAndParse();
                                System.out.println("Ange startplats f�r bokning");
                                int startSeat = readAndParse();
                                movie.bookSeats(startSeat, numSeats);
                            } else if (command.equals("1")) {
                                System.out.println("Ange antal platser du vill boka");
                                int numSeats = readAndParse();
                                movie.bookSeatsFree(numSeats);
                            }
                        }
                    }
                }
            }
            else if (command.equals("1")) {
                theaterHandler.printSalons(false);
                continue;
            }
            else if (command.equals("2")) {
                theaterHandler.printAllMovies();
                continue;
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
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Invalid input");

            return -1;
        }
    }
}
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HairDresserHandler {

    List<HairDresser> hairDresserList;

    public HairDresserHandler(){
        hairDresserList = new ArrayList<>();
        initDressers();
    }

    public void initDressers(){
        hairDresserList.add(new HairDresser("Kalle Olsson", 200.0, "Cuts men only"));
        hairDresserList.add(new HairDresser("Anna Larsson", 200.0, "Cuts women only"));
        hairDresserList.add(new HairDresser("Sture Arnesson", 200.0, "Cuts both gender"));
    }

    //printar ut specifik frisör
    public void printDressers(boolean showIndex){
        for (HairDresser hairDresser : hairDresserList) {
            if(showIndex)
                System.out.println("[" + hairDresserList.indexOf(hairDresser) + "] Hairdresser: " +
                        hairDresser.getName() + ", " + hairDresser.getDescription());
            else
                System.out.println("Hairdresser: " + hairDresser.getName());
        }
    }

    //printar ut alla frisörer
    public void printAllBookings() {
        for(HairDresser hairDresser: hairDresserList){
            System.out.println(hairDresser.getName() + " ");
            for(Booking booking : hairDresser.getBookings()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                System.out.println(formatter.format(booking.getStart()) + "  -  " + formatter.format(booking.getEnd()));
            }
            if(hairDresser.getBookings().size() == 0) {
                System.out.println("Got no bookings\n");

            }else System.out.println(" ");
        }
    }

    public HairDresser getDresser(int index) {
        if(index >= 0 && index < hairDresserList.size()) {
            return hairDresserList.get(index);
        }
        System.out.println("Doesn't exist");
        return null;
    }

}

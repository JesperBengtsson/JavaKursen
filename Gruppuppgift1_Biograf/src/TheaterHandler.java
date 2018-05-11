import java.util.ArrayList;
import java.util.List;

public class TheaterHandler {
    private List<Salon> Salons;

    public TheaterHandler(){
        Salons = new ArrayList<>();
        initSalons();

    }

    public List<Salon> getSalons() {
        return Salons;
    }

    private void initSalons(){
        for(int i = 65; i < 70; i++) {
            Salons.add(new Salon((char) i + ""));
        }
    }

    public void printSalons(boolean showIndex){
        for (Salon salon : Salons) {
            if(showIndex)
                System.out.println("[" + Salons.indexOf(salon) + "] Salong: " + salon.getSalonName());
            else
                System.out.println("Salong: " + salon.getSalonName());
        }
    }

    public void printAllMovies(){
        for(Salon salon : Salons) {
            System.out.println("Salong: " + salon.getSalonName());
            for(Movie movie : salon.getMovies()) {
                System.out.println("Film: " + movie.getName() + " Time: " + movie.getTime());
            }
            if(salon.getMovies().size() == 0) {
                System.out.println("Inga filmer i denna salong\n");
            }
            else {
                System.out.println(" ");
            }

        }
    }

    public Salon getSalon(int index) {
        if(index >= 0 && index < Salons.size()) {
            return Salons.get(index);
        }
        System.out.println("Doesn't exist");
        return null;
    }
}
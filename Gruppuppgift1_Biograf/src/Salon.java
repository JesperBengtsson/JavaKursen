import java.util.ArrayList;
import java.util.List;

public class Salon {
    private List<Movie> Movies;
    private String SalonName;

    public Salon(String salonName) {
        this();
        SalonName = salonName;
    }

    public Salon(){
        Movies = new ArrayList<>();
    }

    public void addMovie(String movieName, String time) {
        Movies.add(new Movie(movieName, time));
    }

    public Movie getMovie(int index) {
        return Movies.get(index);
    }

    public void printMovies(boolean showIdex){

        for(Movie movie : Movies) {
            if(showIdex) {
                System.out.println("[" + Movies.indexOf(movie) + "] Name: " + movie.getName() + "Time: " + movie.getTime());
            }
            else {
                System.out.println("Name: " + movie.getName() + "Time: " + movie.getTime());
            }
        }
        if(Movies.size() == 0) {
            System.out.println("Finns inga filmer\n");
        }
    }
    // Getters and setters

    public String getSalonName(){
        return SalonName;
    }

    public List<Movie> getMovies() {
        return Movies;
    }
}
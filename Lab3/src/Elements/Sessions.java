package Elements;
public class Sessions {
    int id;
    String Movies;
    String time;
    int free_seats;
    public Sessions(int id, String Movies, String time,int  free_seats){
        this.id=id;
        this .Movies = Movies;
        this .time = time;
        this .free_seats= free_seats;
    }
    public  int get_id () {
        return id;
    }
    public void set_id( int id ) {
        this .id = id;
    }
    public String getMovies () {
        return Movies;
    }
    public void setMovie ( String Movies ) {
        this .Movies = Movies;
    }
    public String get_time () {
        return time;
    }
    public void set_time ( String time ) {
        this .time = time;
    }
    public int get_free_seats () {
        return free_seats;
    }
    public void set_free_seats ( int free_eats ) {
        this .free_seats = free_seats;
    }

    public String toString () {
        return    "["+id+"]"+":"+Movies + ", " + time ;
    }

}
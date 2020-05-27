// 대여 정보 클래스
// Simple Rental class
public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented){
        _movie = movie;
        _daysRented = daysRented;

    }
    public int getDaysRented(){
        return _daysRented;
    }
    public Movie getMovie(){
        return _movie;
    }

}

import java.time.LocalDate;

public class Race {
    private String name;
    private double distanceInMiles; // miles
    private LocalDate date;

    public Race(String name, double distanceInMiles, LocalDate date) {
        this.name = name;
        this.distanceInMiles = distanceInMiles;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public double getDistanceInMiles() {
        return distanceInMiles;
    }

    public LocalDate getDate() {
        return date;
    }
}

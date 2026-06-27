public class Reptile extends Animal implements Trackable {
    private boolean isVenomous;
    private double lengthCm; 

    public Reptile(String species, String nickname, String island, double weightKg, String healthStatus,
                   boolean isVenomous, double lengthCm) { 

        super(species, nickname, island, weightKg, healthStatus);


        this.isVenomous = isVenomous;
        this.lengthCm = lengthCm; 
    }

    public boolean isVenomous() {
        return isVenomous;
    }

    public double getLengthCm() {
        return lengthCm;
    }

    public String getType() {
        return "Reptile";
    }   


    public double getDailyFoodCostTTD() { 
        return 25.0 + getWeightKg() * 2.0; 
    }

    // tracking methods
    public void logSighting(String date, String location) {
        getSightings().add(date + " at " + location);
    }

    public int getSightingCount() {
        return getSightings().size();
    }

    
    public String getLastSighting() {
        if (getSightings().size() == 0) {
            return "No sightings recorded";
        }
        return getSightings().get(getSightings().size() - 1);
    }
}
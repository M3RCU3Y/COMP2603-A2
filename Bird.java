public class Bird extends Animal implements Trackable, Relocatable {
    private double wingspanCm;
    private boolean canFly;

    public Bird(String species, String nickname, String island, double weightKg, String healthStatus,
                double wingspanCm, boolean canFly) {
        super(species, nickname, island, weightKg, healthStatus);

        this.wingspanCm = wingspanCm;
        this.canFly = canFly;
    }

    public double getWingspanCm() {
        return wingspanCm;
    }

    public boolean canFly() {
        return canFly;
    }

    public String getType() {
        return "Bird";
    }

    public double getDailyFoodCostTTD() {
        return 15.0 + getWeightKg() * 50.0;
    }


// trackable methods
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

    // Relocatable 
    public boolean canRelocateTo(String targetIsland) {
        return true;
    }

    public double getRelocationCost() {
        return 500.0 + getWeightKg() * 100.0;
    }

    public void relocateTo(String island) {
        setIsland(island);
    }
}
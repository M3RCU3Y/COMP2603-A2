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

}
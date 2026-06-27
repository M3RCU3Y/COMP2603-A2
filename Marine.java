public class Marine extends Animal implements Trackable, Relocatable {
    private double maxDepthM;
    private int tankSizeLitres;

    public Marine(String species, String nickname, String island, double weightKg, String healthStatus,
                  double maxDepthM, int tankSizeLitres) {

        super(species, nickname, island, weightKg, healthStatus);

        this.maxDepthM = maxDepthM;
        this.tankSizeLitres = tankSizeLitres;
    }

    public double getMaxDepthM() { 
        return maxDepthM;
    }

    public int getTankSizeLitres() {
        return tankSizeLitres;
    }

    public String getType() {
        return "Marine";    
    }

    public double getDailyFoodCostTTD() {
        return 50.0 + getWeightKg() * 3.0;  
    }

    // --- Trackable methods ---
    // TODO M4: Implement logSighting(String date, String location)

    // TODO M4: Implement getSightingCount()

    // TODO M4: Implement getLastSighting()

    // --- Relocatable methods ---
    // TODO M6: Implement canRelocateTo(String targetIsland)
    //          Returns true only if targetIsland is NOT the animal's current island

    // TODO M6: Implement getRelocationCost()
    //          Returns 2000.0 + tankSizeLitres * 5.0

    // TODO M6: Implement relocateTo(String island)
    //          Updates the island using setIsland()
}
import java.util.ArrayList;

public abstract class Animal {
    private static int nextId = 1;

    private int animalId;
    private String species;
    private String nickname;
    private String island;
    private double weightKg;
    private String healthStatus;
    private ArrayList<String> sightings;

    
    public Animal(String species, String nickname, String island, double weightKg, String healthStatus) {
        if (species == null || species.trim().equals("")) {
            throw new IllegalArgumentException("Species cannot be empty");
        } 
        if (nickname == null || nickname.trim().equals("")) {
            throw new IllegalArgumentException("Nickname cannot be empty");
        }
        if (island == null || island.trim().equals("")) {
            throw new IllegalArgumentException("Island cannot be empty");
        }
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }
        if (!isValidHealthStatus(healthStatus)) {
            throw new IllegalArgumentException("Invalid health status");
        }




        this.animalId = nextId; // 
        nextId++;

        this.species = species.trim();
        this.nickname = nickname.trim();
        this.island = island.trim();
        this.weightKg = weightKg;
        this.healthStatus = healthStatus;

        sightings = new ArrayList<String>();
    }

    private boolean isValidHealthStatus(String status) {
        if (status == null) { 
            return false;
        }
        if (status.equals("Healthy")) {
            return true;
        } 
        if (status.equals("Injured")) {
            return true;
        }

        if (status.equals("Critical")) {
            return true;
        } 

        return false; 
    }

    //getters
    public int getAnimalId() {
        return animalId;
    }

    public String getSpecies() {
        return species;
    }

    public String getNickname() {
        return nickname;
    }

    public String getIsland() {
        return island;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    
    public void setIsland(String island) {
        if (island == null || island.trim().equals("")) {
            throw new IllegalArgumentException("Island cannot be empty");
        }

        this.island = island.trim();
    }

    protected ArrayList<String> getSightings() {
        return sightings;
    }

    public void updateHealth(String newStatus) {
        if (!isValidHealthStatus(newStatus)) {
            throw new IllegalArgumentException("Invalid health status");
        }
        healthStatus = newStatus;
    } 

    public abstract String getType(); 
    public abstract double getDailyFoodCostTTD();


// overides
    @Override
    public String toString() {
        return String.format("#%03d %s '%s' (%s) [%s] %.2f kg - %s",
                animalId, species, nickname, island, getType(), weightKg, healthStatus);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            Animal other = (Animal) obj;
            return this.animalId == other.animalId;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(animalId);
    }

} 
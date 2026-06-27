import java.util.ArrayList;
public class Sanctuary {
    private String name;
    private String island;
    private int capacity;
    private ArrayList<Animal> animals;

    public Sanctuary(String name, String island, int capacity) {
        this.name = name;
        this.island = island;
        this.capacity = capacity;
        animals = new ArrayList<Animal>();
    }

    public String getName() {
        return name;
    }
    public String getIsland() {
        return island;
    }   

    public int getCapacity() {
        return capacity;
    }
 
    public ArrayList<Animal> getAnimals() {
        return animals;
    }   

    public boolean addAnimal(Animal a) {
        if (a == null) {
            return false;
        }
        if (animals.size() >= capacity) {
            return false;
        }
        if (!a.getIsland().equals(island)) {
            return false;
        }

        animals.add(a);
        return true;
    } 


    public Animal removeAnimal(int animalId) {
        for (int i = 0; i < animals.size(); i++) {
            Animal current = animals.get(i);

            if (current.getAnimalId() == animalId) {
                animals.remove(i);
                return current;
            }
        }

        return null;
    }

    public int getAnimalCount() {
        return animals.size();
    }


    /**
     * Returns a new ArrayList containing only animals of the given type.
     *
     * TODO M7: Implement getAnimalsOfType
     */
    public ArrayList<Animal> getAnimalsOfType(String type) {
         
        ArrayList<Animal> matchingAnimals = new ArrayList<Animal>();

        for (int i= 0; i < animals.size(); i++) { 
            Animal current=animals.get(i);


            if (current.getType().equals(type)) { 
                matchingAnimals.add(current); 
            }
        }

        return matchingAnimals;
    } 

    public double getDailyFoodBudget() {

        double total =0.0; 

        for (int i = 0;i < animals.size(); i++) { 
            Animal current = animals.get(i); 
            total = total + current.getDailyFoodCostTTD(); 
        }
        return Math.round(total*100.0)/100.0;
    }

    /**
     * Returns all animals that implement the Relocatable interface.
     * Hint: use instanceof.
     *
     * TODO M8: Implement getRelocatableAnimals
     */
    public ArrayList<Animal> getRelocatableAnimals() {
        ArrayList<Animal> relocatableAnimals = new ArrayList<Animal>();
 
        for (int i =0; i < animals.size(); i++) {
            Animal current = animals.get(i); 

            if (current instanceof Relocatable) {
                relocatableAnimals.add(current);
            } 
        }
        return relocatableAnimals;
    }

    public Animal getMostExpensiveAnimal() {
        if (animals.size() == 0) {
            return null;
        }

        Animal mostExpensive = animals.get(0);

        for (int i =1; i < animals.size(); i++) { 
            Animal current = animals.get(i);
            if (current.getDailyFoodCostTTD()>mostExpensive.getDailyFoodCostTTD()) {
                mostExpensive = current;
            }
        } 
        return mostExpensive; 
    }

    public boolean transferAnimal(int animalId, Sanctuary target) {
        Animal animal = removeAnimal(animalId); 

        if (animal == null) {
            return false; 
        }

        if (!(animal instanceof Relocatable)) {
            animals.add(animal); 
            return false;
        }
        Relocatable relocatableAnimal=(Relocatable) animal;
        relocatableAnimal.relocateTo(target.getIsland());

        if (!target.addAnimal(animal)) {
            relocatableAnimal.relocateTo(this.getIsland());
            animals.add(animal);
            return false; 
        }
 
        return true; 
    }
 
    public void printRoster() {
        for (int i = 0; i < animals.size(); i++) {
            System.out.println("  " + animals.get(i));
        }
    }

    /**
     * Format: "Name (Island) [count/capacity animals]"
     * Example: "Caroni Bird Sanctuary (Trinidad) [12/50 animals]"
     */
    @Override
    public String toString() {
        return name + " (" + island + ") [" + animals.size() + "/" + capacity + " animals]";
    }
}
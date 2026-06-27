
public interface Relocatable {
    boolean canRelocateTo(String targetIsland);
    double getRelocationCost();
    void relocateTo(String island);
}
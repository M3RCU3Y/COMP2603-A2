/**
 * Relocatable interface for animals that can be transferred between islands.
 *
 * TODO M3: Define three method signatures:
 *   - boolean canRelocateTo(String targetIsland)
 *   - double getRelocationCost()
 *   - void relocateTo(String island)
 */
public interface Relocatable {
    boolean canRelocateTo(String targetIsland);
    double getRelocationCost();
    void relocateTo(String island);
}
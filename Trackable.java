/**
 * Trackable interface for animals that can have sighting logs.
 *
 * TODO M3: Define three method signatures:
 *   - void logSighting(String date, String location)
 *   - int getSightingCount()
 *   - String getLastSighting()
 */
public interface Trackable {
    void logSighting(String date, String location);
    int getSightingCount();
    String getLastSighting();
}
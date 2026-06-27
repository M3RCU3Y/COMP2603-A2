public interface Trackable {
    void logSighting(String date, String location);
    int getSightingCount();
    String getLastSighting();
}
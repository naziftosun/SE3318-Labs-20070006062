package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a location in Middle-Earth.
 */
public class Location {
    /**
     * Location name.
     */
    private String name;
    /**
     * List of connected locations.
     */
    private List<String> connectedLocations;
    /**
     * True if location has a secret passage.
     */
    private boolean hasSecretPassage;

    /**
     * Creates a new location.
     * @param name
     * @param hasSecretPassage
     */
    public Location(String name, boolean hasSecretPassage) {
        this.name = name;
        this.hasSecretPassage = hasSecretPassage;
        this.connectedLocations = new ArrayList<>();
    }

    /**
     * Adds a connected location.
     * @param locationName
     */
    public void addConnectedLocation(String locationName) {
        connectedLocations.add(locationName);
    }

    /**
     * Checks if this location is connected to another location.
     * @param locationName
     * @return true if connected.
     */
    public boolean isConnectedTo(String locationName) {
        return connectedLocations.contains(locationName);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public List<String> getConnectedLocations() {
        return connectedLocations;
    }

    public boolean hasSecretPassage () {
        return hasSecretPassage;

    }

    public void setHasSecretPassage(boolean hasSecretPassage) {
        this.hasSecretPassage = hasSecretPassage;

    }

} 
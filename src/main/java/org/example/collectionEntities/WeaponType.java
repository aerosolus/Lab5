package org.example.collectionEntities;

/**
 * An enumeration representing different types of weapons.
 * This enum defines the various weapon categories available in the application.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public enum WeaponType {

    /**
     * Represents an axe as a weapon type.
     */
    AXE,

    /**
     * Represents a pistol as a weapon type.
     */
    PISTOL,

    /**
     * Represents a shotgun as a weapon type.
     */
    SHOTGUN,

    /**
     * Represents a knife as a weapon type.
     */
    KNIFE,

    /**
     * Represents a machine gun as a weapon type.
     */
    MACHINE_GUN;

    /**
     * Converts all weapon types to a comma-separated string representation.
     * This method is useful for displaying or logging all available weapon types.
     *
     * @return A String containing all weapon types separated by commas.
     */
    public static String nameToString() {
        StringBuilder nameToString = new StringBuilder();
        for (WeaponType type : values()) {
            nameToString.append(type.name()).append(", ");
        }
        return nameToString.substring(0, nameToString.length()-2);
    }
}
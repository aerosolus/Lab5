package org.example.collectionEntities;

import java.util.Objects;

/**
 * Represents a point in a two-dimensional coordinate system.
 * This class encapsulates the x and y coordinates of a location.
 *
 * @author aerosolus
 * @version 1.0
 * @since 1.0
 */
public class Coordinates {

    /**
     * The x-coordinate of the point.
     */
    private double x;

    /**
     * The y-coordinate of the point.
     */
    private long y;

    /**
     * Constructs a new Coordinates object using a CoordinatesBuilder.
     *
     * @param coordinatesBuilder The builder instance containing the coordinates.
     */
    public Coordinates(CoordinatesBuilder coordinatesBuilder) {
        x = coordinatesBuilder.x;
        y = coordinatesBuilder.y;
    }

    /**
     * Default constructor for empty Coordinates instances.
     */
    public Coordinates(){

    }

    /**
     * Builder class for constructing Coordinates objects.
     */
    public static class CoordinatesBuilder {

        /**
         * The x-coordinate of the point being built.
         */
        private double x;

        /**
         * The y-coordinate of the point being built.
         */
        private long y;

        /**
         * Constructor for required fields.
         *
         * @param x The x-coordinate of the point.
         * @param y The y-coordinate of the point.
         */
        public CoordinatesBuilder(double x, long y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Constructs and returns a fully built Coordinates object.
         *
         * @return A fully constructed Coordinates object.
         */
        public Coordinates build() {
            return new Coordinates(this);
        }
    }

    /**
     * Gets the x-coordinate of the point.
     *
     * @return The x-coordinate of the point.
     */
    public double getX() {
        return x;
    }

    /**
     * Sets the x-coordinate of the point.
     *
     * @param x The new x-coordinate of the point.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Gets the y-coordinate of the point.
     *
     * @return The y-coordinate of the point.
     */
    public long getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of the point.
     *
     * @param y The new y-coordinate of the point.
     */
    public void setY(long y) {
        this.y = y;
    }

    /**
     * Returns a string representation of the Coordinates object.
     *
     * @return A string representation of the Coordinates object.
     */
    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x
                + ", y="
                + y + '}';
    }

    /**
     * Compares this Coordinates object with another object for equality.
     *
     * @param o The object to compare with.
     * @return true if the objects have the same values for x and y, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Double.compare(x, that.x) == 0 && y == that.y;
    }

    /**
     * Generates a hash code for this Coordinates object.
     *
     * @return An int value representing the hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
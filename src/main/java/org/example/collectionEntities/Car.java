package org.example.collectionEntities;

import java.util.Objects;

/**
 * Represents a Car entity with properties such as name and coolness factor.
 * This class uses the Builder pattern to construct Car objects.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class Car {

    /**
     * The name of the car.
     */
    private String name;

    /**
     * Indicates whether the car is considered "cool".
     */
    private boolean cool;

    /**
     * Constructs a Car object using a CarBuilder.
     *
     * @param carBuilder The builder instance containing the car details.
     */
    public Car(CarBuilder carBuilder) {
        this.name = carBuilder.name;
        this.cool = carBuilder.cool;
    }

    /**
     * Builder class for constructing Car objects.
     */
    public static class CarBuilder {

        /**
         * The name of the car being built.
         */
        private String name;

        /**
         * Indicates whether the car being built is considered "cool".
         */
        private boolean cool;

        /**
         * Builds a new CarBuilder instance with the given name.
         *
         * @param name The name of the car to be built.
         */
        public CarBuilder(String name) {
            this.name = name;
        }

        /**
         * Sets the cool characteristic of the car being built.
         *
         * @param cool Whether the car should be considered "cool".
         * @return This CarBuilder instance for method chaining.
         */
        public CarBuilder setCool(boolean cool) {
            this.cool = cool;
            return this;
        }

        /**
         * Constructs and returns a fully built Car object.
         *
         * @return A fully constructed Car object.
         */
        public Car build() {
            return new Car(this);
        }
    }

    /**
     * Gets the name of the car.
     *
     * @return The name of the car.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the car.
     *
     * @param name The new name for the car.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if the car is considered "cool".
     *
     * @return True if the car is cool, false otherwise.
     */
    public boolean isCool() {
        return cool;
    }

    /**
     * Sets whether the car is considered "cool".
     *
     * @param cool Whether the car should be considered "cool".
     */
    public void setCool(boolean cool) {
        this.cool = cool;
    }

    /**
     * Returns a string representation of the Car object.
     *
     * @return A string representation of the Car object.
     */
    @Override
    public String toString() {
        return "Car{"
                + "name=" + name
                + ", cool=" + cool
                + '}';
    }

    /**
     * Compares this Car object with another object for equality.
     *
     * @param o The object to compare with.
     * @return true if the objects have the same values for name and cool, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return cool == car.cool && Objects.equals(name, car.name);
    }

    /**
     * Generates a hash code for this Car object.
     *
     * @return An int value representing the hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, cool);
    }
}
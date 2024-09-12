package org.example.collectionEntities;

import java.time.LocalDateTime;

/**
 * Represents a human being with various attributes.
 * This class implements the Comparable interface to allow sorting of HumanBeing instances.
 * It uses the Builder pattern for flexible construction of HumanBeing objects.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class HumanBeing implements Comparable <HumanBeing> {

    /**
     * Unique identifier for the human being.
     */
    private int id;

    /**
     * Name of the human being.
     */
    private String name;

    /**
     * Coordinates representing the location of the human being.
     */
    private Coordinates coordinates;

    /**
     * Date and time when the human being was created.
     */
    private java.time.LocalDateTime creationDate;

    /**
     * Flag indicating whether the human being is considered a real hero.
     */
    private boolean realHero;

    /**
     * Flag indicating whether the human being has a toothpick.
     */
    private boolean hasToothpick;

    /**
     * Speed at which the human being impacts something.
     */
    private long impactSpeed;

    /**
     * Name of the soundtrack associated with the human being.
     */
    private String soundtrackName;

    /**
     * Number of minutes the human being waited.
     */
    private Double minutesOfWaiting;

    /**
     * Type of weapon wielded by the human being.
     */
    private WeaponType weaponType;

    /**
     * Vehicle driven by the human being.
     */
    private Car car;

    /**
     * Constructs a new HumanBeing object using a HumanBeingBuilder.
     *
     * @param humanBeingBuilder The builder instance containing the human being details.
     */
    public HumanBeing(HumanBeingBuilder humanBeingBuilder) {
        id = humanBeingBuilder.id;
        name = humanBeingBuilder.name;
        coordinates = humanBeingBuilder.coordinates;
        realHero = humanBeingBuilder.realHero;
        hasToothpick = humanBeingBuilder.hasToothpick;
        soundtrackName = humanBeingBuilder.soundtrackName;
        impactSpeed = humanBeingBuilder.impactSpeed;
        minutesOfWaiting = humanBeingBuilder.minutesOfWaiting;
        weaponType = humanBeingBuilder.weaponType;
        car = humanBeingBuilder.car;
    }

    /**
     * Default constructor for empty HumanBeing instances.
     */
    public HumanBeing() {

    }

    /**
     * Builder class for constructing HumanBeing objects.
     */
    public static class HumanBeingBuilder {

        /**
         * Unique identifier for the human being.
         */
        private int id;

        /**
         * Name of the human being.
         */
        private String name;

        /**
         * Coordinates representing the location of the human being.
         */
        private Coordinates coordinates;

        /**
         * Flag indicating whether the human being is considered a real hero.
         */
        private boolean realHero;

        /**
         * Flag indicating whether the human being has a toothpick.
         */
        private boolean hasToothpick;

        /**
         * Speed at which the human being impacts something.
         */
        private long impactSpeed;

        /**
         * Name of the soundtrack associated with the human being.
         */
        private String soundtrackName;

        /**
         * Number of minutes the human being waited.
         */
        private Double minutesOfWaiting;

        /**
         * Type of weapon wielded by the human being.
         */
        private WeaponType weaponType;

        /**
         * Vehicle driven by the human being.
         */
        private Car car;

        /**
         * Constructor for required fields.
         *
         * @param id Unique identifier for the human being.
         * @param name Name of the human being.
         * @param coordinates Coordinates representing the location of the human being.
         * @param hasToothpick Flag indicating whether the human being has a toothpick.
         * @param soundtrackName Name of the soundtrack associated with the human being.
         * @param impactSpeed Speed at which the human being impacts something.
         * @param minutesOfWaiting Number of minutes the human being waited.
         */
        public HumanBeingBuilder(int id,
                                 String name,
                                 Coordinates coordinates,
                                 boolean hasToothpick,
                                 String soundtrackName,
                                 long impactSpeed,
                                 Double minutesOfWaiting) {
            this.id = id;
            this.name = name;
            this.coordinates = coordinates;
            this.hasToothpick = hasToothpick;
            this.soundtrackName = soundtrackName;
            this.impactSpeed = impactSpeed;
            this.minutesOfWaiting = minutesOfWaiting;
        }

        /**
         * Sets the weapon type for the human being.
         *
         * @param weaponType Type of weapon wielded by the human being.
         * @return This builder instance for method chaining.
         */
        public HumanBeingBuilder setWeaponType(WeaponType weaponType) {
            this.weaponType = weaponType;
            return this;
        }

        /**
         * Sets the vehicle for the human being.
         *
         * @param car Vehicle driven by the human being.
         * @return This builder instance for method chaining.
         */
        public HumanBeingBuilder setCar(Car car) {
            this.car = car;
            return this;
        }

        /**
         * Sets whether the human being is considered a real hero.
         *
         * @param realHero Flag indicating whether the human being is considered a real hero.
         * @return This builder instance for method chaining.
         */
        public HumanBeingBuilder setRealHero(Boolean realHero) {
            this.realHero = realHero;
            return this;
        }

        /**
         * Builds a new instance of HumanBeing class.
         *
         * @return A fully constructed HumanBeing object.
         */
        public HumanBeing build() {
            return new HumanBeing(this);
        }
    }

    /**
     * Gets the unique identifier of the human being.
     *
     * @return The unique identifier of the human being.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Gets the name of the human being.
     *
     * @return The name of the human being.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the coordinates of the human being.
     *
     * @return The coordinates of the human being.
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Gets the creation date of the human being.
     *
     * @return The creation date of the human being.
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Checks if the human being has a toothpick.
     *
     * @return true if the human being has a toothpick, false otherwise.
     */
    public boolean isHasToothpick() {
        return hasToothpick;
    }

    /**
     * Gets the soundtrack name associated with the human being.
     *
     * @return The soundtrack name associated with the human being.
     */
    public String getSoundtrackName() {
        return soundtrackName;
    }

    /**
     * Checks if the human being is considered a real hero.
     *
     * @return true if the human being is considered a real hero, false otherwise.
     */
    public boolean isRealHero() {
        return realHero;
    }

    /**
     * Gets the impact speed of the human being.
     *
     * @return The impact speed of the human being.
     */
    public long getImpactSpeed() {
        return impactSpeed;
    }

    /**
     * Gets the number of minutes the human being waited.
     *
     * @return The number of minutes the human being waited.
     */
    public Double getMinutesOfWaiting() {
        return minutesOfWaiting;
    }

    /**
     * Gets the weapon type of the human being.
     *
     * @return The weapon type of the human being.
     */
    public WeaponType getWeaponType() {
        return weaponType;
    }

    /**
     * Gets the vehicle associated with the human being.
     *
     * @return The vehicle driven by the human being.
     */
    public Car getCar() {
        return car;
    }

    /**
     * Compares this HumanBeing object with another object for sorting purposes.
     * The comparison is based on the name of the human beings.
     *
     * @param o The object to compare with.
     * @return A negative integer, zero, or a positive integer
     * as the first argument is less than, equal to, or greater than the second.
     */
    public int compareTo(HumanBeing o) {
        //System.out.println(name + " " + o.name+ " " + this.name.compareTo(o.name));
        return this.name.toLowerCase().compareTo(o.name.toLowerCase());
    }

    /**
     * Sets the unique identifier of the human being.
     *
     * @param id The new unique identifier for the human being.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the name of the human being.
     *
     * @param name The new name for the human being.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the coordinates of the human being.
     *
     * @param coordinates The new coordinates for the human being.
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Sets the creation date of the human being.
     *
     * @param creationDate The new creation date for the human being.
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Sets whether the human being is considered a real hero.
     *
     * @param realHero Whether the human being should be considered a real hero.
     */
    public void setRealHero(boolean realHero) {
        this.realHero = realHero;
    }

    /**
     * Sets whether the human being has a toothpick.
     *
     * @param hasToothpick Whether the human being has a toothpick.
     */
    public void setHasToothpick(boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    /**
     * Sets the impact speed of the human being.
     *
     * @param impactSpeed The new impact speed for the human being.
     */
    public void setImpactSpeed(long impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    /**
     * Sets the soundtrack name associated with the human being.
     *
     * @param soundtrackName The new soundtrack name for the human being.
     */
    public void setSoundtrackName(String soundtrackName) {
        this.soundtrackName = soundtrackName;
    }

    /**
     * Sets the number of minutes the human being waited.
     *
     * @param minutesOfWaiting The new waiting time for the human being.
     */
    public void setMinutesOfWaiting(Double minutesOfWaiting) {
        this.minutesOfWaiting = minutesOfWaiting;
    }

    /**
     * Sets the weapon type of the human being.
     *
     * @param weaponType The new weapon type for the human being.
     */
    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    /**
     * Sets the vehicle associated with the human being.
     *
     * @param car The new vehicle for the human being.
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Returns a string representation of the HumanBeing object.
     * This method provides a detailed description of the object's state,
     * including all significant fields and their values.
     *
     * @return A string representation of the HumanBeing object.
     * The returned string includes the values of all fields:
     * - id
     * - name
     * - coordinates
     * - creationDate
     * - realHero
     * - hasToothpick
     * - impactSpeed
     * - soundtrackName
     * - minutesOfWaiting
     * - weaponType
     * - car
     *
     * @see #getId()
     * @see #getName()
     * @see #getCoordinates()
     * @see #getCreationDate()
     * @see #isRealHero()
     * @see #isHasToothpick()
     * @see #getImpactSpeed()
     * @see #getSoundtrackName()
     * @see #getMinutesOfWaiting()
     * @see #getWeaponType()
     * @see #getCar()
     */
    @Override
    public String toString() {
        return "HumanBeing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", realHero=" + realHero +
                ", hasToothpick=" + hasToothpick +
                ", impactSpeed=" + impactSpeed +
                ", soundtrackName='" + soundtrackName + '\'' +
                ", minutesOfWaiting=" + minutesOfWaiting +
                ", weaponType=" + weaponType +
                ", car=" + car +
                '}';
    }
}
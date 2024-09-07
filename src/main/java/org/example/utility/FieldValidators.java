package org.example.utility;

/**
 * Utility class for validating various fields related to HumanBeing entities.
 * Provides static methods to check the validity of individual fields.
 *
 * @author Aerosolus
 * @version 1.1
 * @since 1.1
 */
public class FieldValidators {

    /**
     * Validates if the given string represents a valid integer ID.
     *
     * @param stringId The string to be validated as an ID.
     * @return true if the string can be parsed as an integer, false otherwise.
     */
    public static boolean validateHumanBeingId(String stringId)
    {
        try {
            Integer id = Integer.parseInt(stringId);
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return true;
    }

    /**
     * Validates if the given string represents a valid name.
     *
     * @param humanBeingName The string to be validated as a name.
     * @return true if the string is not null and not empty, false otherwise.
     */
    public static boolean validateHumanBeingName(String humanBeingName)
    {
        return (humanBeingName != null && !humanBeingName.isEmpty());
    }

    /**
     * Validates if the given string represents a valid X coordinate.
     *
     * @param stringX The string to be validated as an X coordinate.
     * @return true if the string can be parsed as a double, false otherwise.
     */
    public static boolean validateHumanBeingCoordinateX(String stringX)
    {
        try {
            double x = Double.parseDouble(stringX);
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return true;
    }

    /**
     * Validates if the given string represents a valid Y coordinate.
     *
     * @param stringY The string to be validated as a Y coordinate.
     * @return true if the string can be parsed as a long, false otherwise.
     */
    public static boolean validateHumanBeingCoordinateY(String stringY)
    {
        try {
            long y = Long.parseLong(stringY);
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return true;
    }

    /**
     * Validates if the given string represents a boolean value for real hero status.
     *
     * @param humanBeingRealHero The string to be validated as a boolean.
     * @return true if the string equals "true" or "false", false otherwise.
     */
    public static boolean validateHumanBeingRealHero(String humanBeingRealHero)
    {
        return humanBeingRealHero.equals("true") || humanBeingRealHero.equals("false");
    }

    /**
     * Validates if the given string represents a boolean value for having a toothpick.
     *
     * @param humanBeingHasToothpick The string to be validated as a boolean.
     * @return true if the string equals "true" or "false", false otherwise.
     */
    public static boolean validateHumanBeingHasToothpick(String humanBeingHasToothpick)
    {
        return humanBeingHasToothpick.equals("true") || humanBeingHasToothpick.equals("false");
    }

    /**
     * Validates if the given string represents a valid impact speed.
     *
     * @param humanBeingImpactSpeed The string to be validated as an impact speed.
     * @return true if the string can be parsed as a long, false otherwise.
     */
    public static boolean validateHumanBeingImpactSpeed(String humanBeingImpactSpeed)
    {
        try {
            long impactSpeed = Long.parseLong(humanBeingImpactSpeed);
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return true;
    }

    /**
     * Validates if the given string represents a valid soundtrack name.
     *
     * @param humanBeingSoundtrackName The string to be validated as a soundtrack name.
     * @return true if the string is not null and not empty, false otherwise.
     */
    public static boolean validateHumanBeingSoundtrackName(String humanBeingSoundtrackName)
    {
        return (humanBeingSoundtrackName != null && !humanBeingSoundtrackName.isEmpty());
    }

    /**
     * Validates if the given string represents a valid minutes of waiting value.
     *
     * @param humanBeingMinutesOfWaiting The string to be validated as minutes of waiting.
     * @return true if the string can be parsed as a double, false otherwise.
     */
    public static boolean validateHumanBeingMinutesOfWaiting(String humanBeingMinutesOfWaiting)
    {
        try {
            Double minutesOfWaiting = Double.parseDouble(humanBeingMinutesOfWaiting);
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return true;
    }

    /**
     * Validates if the given string represents a valid weapon type.
     *
     * @param humanBeingWeaponType The string to be validated as a weapon type.
     * @return true if the string matches one of the predefined weapon types, false otherwise.
     */
    public static boolean validateHumanBeingWeaponType(String humanBeingWeaponType)
    {
        return humanBeingWeaponType.equals("AXE") ||
                humanBeingWeaponType.equals("PISTOL") ||
                humanBeingWeaponType.equals("SHOTGUN") ||
                humanBeingWeaponType.equals("KNIFE") ||
                humanBeingWeaponType.equals("MACHINE_GUN");
    }

    /**
     * Validates if the given string represents a boolean value for car coolness.
     *
     * @param humanBeingCarCool The string to be validated as a boolean.
     * @return true if the string equals "true" or "false", false otherwise.
     */
    public static boolean validateHumanBeingCarIs(String humanBeingCarCool)
    {
            return humanBeingCarCool.equals("true") || humanBeingCarCool.equals("false");
    }
}
package org.example.inputOutput;

import org.example.collectionEntities.WeaponType;
import org.example.utility.FieldValidators;

/**
 * Utility class for getting field values for HumanBeing objects from terminal input.
 * This class provides methods to validate and retrieve various fields of a HumanBeing object.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class HumanBeingFieldValuesGetter {

    /**
     * Manager for handling terminal input.
     */
    private final TerminalInputManager terminalInputManager;

    /**
     * Manager for handling terminal output.
     */
    private final TerminalOutputManager terminalOutputManager;

    /**
     * Constructs a HumanBeingFieldValuesGetter with the given terminal input and output managers.
     *
     * @param terminalInputManager Manager for handling terminal input.
     * @param terminalOutputManager Manager for handling terminal output.
     */
    public HumanBeingFieldValuesGetter(TerminalInputManager terminalInputManager, TerminalOutputManager terminalOutputManager) {
        this.terminalInputManager = terminalInputManager;
        this.terminalOutputManager = terminalOutputManager;
    }

    /**
     * Retrieves the key of a HumanBeing object from terminal input.
     *
     * @return The integer key of the HumanBeing object.
     */
    public int getHumanBeingKey() {
        while (true) {
            terminalOutputManager.printlnToTheOutputStream("Введите ключ объекта HumanBeing:");
            String keyString = terminalInputManager.getNextLine();
            int key = -1;
            try {
                key = Integer.parseInt(keyString);
            } catch (NumberFormatException numberFormatException) {
                terminalOutputManager.printlnToTheOutputStream("Значение ключа должно быть целым числом!");
                continue;
            }
            if (FieldValidators.validateHumanBeingId(keyString))
                return Integer.parseInt(keyString);
        }
    }

    /**
     * Retrieves the name of a HumanBeing object from terminal input.
     *
     * @return The name of the HumanBeing object.
     */
    public String getHumanBeingName() {
        while (true) {
            terminalOutputManager.printlnToTheOutputStream("Введите значение поля name объекта HumanBeing:");
            String name = terminalInputManager.getNextLine();
            if (FieldValidators.validateHumanBeingName(name))
                return name;
            else
                terminalOutputManager.printlnToTheOutputStream("Поле name объекта HumanBeing не может быть null и не может быть пустой строкой!");
        }
    }

    /**
     * Retrieves the X coordinate of a HumanBeing object from terminal input.
     *
     * @return The X coordinate of the HumanBeing object.
     */
    public double getHumanBeingCoordinateX() {
        while (true) {
            terminalOutputManager.printlnToTheOutputStream("Введите координату x объекта HumanBeing:");
            String stringX = terminalInputManager.getNextLine();
            double x = 0;
            try {
                x = Double.parseDouble(stringX);
            } catch (NumberFormatException numberFormatException) {
                terminalOutputManager.printlnToTheOutputStream("Координата x должна быть числом с плавающей точкой!");
                continue;
            }
            if (FieldValidators.validateHumanBeingCoordinateX(stringX))
                return x;
        }
    }

    /**
     * Retrieves the Y coordinate of a HumanBeing object from terminal input.
     *
     * @return The Y coordinate of the HumanBeing object.
     */
    public long getHumanBeingCoordinateY() {
        while (true) {
            terminalOutputManager.printlnToTheOutputStream("Введите координату y объекта HumanBeing:");
            String stringY = terminalInputManager.getNextLine();
            long y = 0;
            try {
                y = Long.parseLong(stringY);
            } catch (NumberFormatException numberFormatException) {
                terminalOutputManager.printlnToTheOutputStream("Координата y должна быть примитивным типом long!");
                continue;
            }
            if (FieldValidators.validateHumanBeingCoordinateY(stringY))
                return y;
        }
    }

    /**
     * Retrieves whether a HumanBeing object is a real hero from terminal input.
     *
     * @return True if the HumanBeing object is a real hero, false otherwise.
     */
    public boolean getHumanBeingRealHero() {
        while (true) {
            terminalOutputManager.printlnToTheOutputStream("Введите значение поля realHero:");
            String realHero = terminalInputManager.getNextLine();
            if (FieldValidators.validateHumanBeingRealHero(realHero))
                return Boolean.parseBoolean(realHero);
            else
                terminalOutputManager.printlnToTheOutputStream("Значение поля realHero должно быть true или false!");
        }
    }

    /**
     * Retrieves whether a HumanBeing object has a toothpick from terminal input.
     *
     * @return True if the HumanBeing object has a toothpick, false otherwise.
     */
    public boolean getHumanBeingHasToothpick() {
        while (true) {
            terminalOutputManager.printlnToTheOutputStream("Введите значение поля hasToothpick:");
            String hasToothpick = terminalInputManager.getNextLine();
            if (FieldValidators.validateHumanBeingHasToothpick(hasToothpick))
                return Boolean.parseBoolean(hasToothpick);
            else
                terminalOutputManager.printlnToTheOutputStream("Значение поля hasToothpick должно быть true или false!");
        }
    }

    /**
     * Retrieves the impact speed of a HumanBeing object from terminal input.
     *
     * @return The impact speed of the HumanBeing object.
     */
    public long getHumanBeingImpactSpeed() {
        while (true) {
            terminalOutputManager.printlnToTheOutputStream("Введите значение поля impactSpeed:");
            String impactSpeedString = terminalInputManager.getNextLine();
            long impactSpeed = 0;
            try {
                impactSpeed = Long.parseLong(impactSpeedString);
            } catch (NumberFormatException numberFormatException) {
                terminalOutputManager.printlnToTheOutputStream("Значение поля impactSpeed должно быть примитивным типом long!");
                continue;
            }
            if (FieldValidators.validateHumanBeingImpactSpeed(impactSpeedString)) {
                return impactSpeed;
            }
        }
    }

    /**
     * Retrieves the soundtrack name of a HumanBeing object from terminal input.
     *
     * @return The soundtrack name of the HumanBeing object.
     */
    public String getHumanBeingSoundtrackName() {
        while (true) {
            terminalOutputManager.printlnToTheOutputStream("Введите значение поля soundtrackName:");
            String soundtrackName = terminalInputManager.getNextLine();
            if (FieldValidators.validateHumanBeingSoundtrackName(soundtrackName))
                return soundtrackName;
            else
                terminalOutputManager.printlnToTheOutputStream("Значение поля soundtrackName не может быть null!");
        }
    }

    /**
     * Retrieves the minutes of waiting of a HumanBeing object from terminal input.
     *
     * @return The minutes of waiting of the HumanBeing object.
     */
    public Double getHumanBeingMinutesOfWaiting() {
        while (true) {
            terminalOutputManager.printlnToTheOutputStream("Введите значение поля minutesOfWaiting:");
            String minutesOfWaintingString = terminalInputManager.getNextLine();
            double minutesOfWainting;
            try {
                 minutesOfWainting = Double.parseDouble(minutesOfWaintingString);
            } catch (NumberFormatException numberFormatException) {
                terminalOutputManager.printlnToTheOutputStream("Значение поля minutesOfWaiting должно быть числом с плавающей точкой!");
                continue;
            }
            if (FieldValidators.validateHumanBeingMinutesOfWaiting(minutesOfWaintingString))
                return minutesOfWainting;
        }
    }

    /**
     * Retrieves the weapon type of HumanBeing object from terminal input.
     *
     * @return The weapon type of the HumanBeing object.
     */
    public WeaponType getHumanBeingWeaponType() {
        while (true) {
            terminalOutputManager.printlnToTheOutputStream("Введите тип оружия - введите одно из значений: AXE, PISTOL, SHOTGUN, KNIFE, MACHINE_GUN.");
            String weaponType = terminalInputManager.getNextLine();
            if (FieldValidators.validateHumanBeingWeaponType(weaponType))
                return WeaponType.valueOf(weaponType);
            else
                terminalOutputManager.printlnToTheOutputStream("Данные введены некорректно. Повторите ввод!");
        }
    }

    /**
     * Retrieves the car name of a HumanBeing object from terminal input.
     *
     * @return The car name of the HumanBeing object.
     */
    public String getHumanBeingCarName() {
        terminalOutputManager.printlnToTheOutputStream("Введите значение поля name объекта Car:");
        String humanBeingCarName = terminalInputManager.getNextLine();
        if (humanBeingCarName == null || humanBeingCarName.isEmpty()) {
            return "";
        }
        else {
            return humanBeingCarName;
        }
    }

    /**
     * Retrieves whether a HumanBeing object's car is cool from terminal input.
     *
     * @return True if the HumanBeing object's car is cool, false otherwise.
     */
    public boolean getHumanBeingCarIsCool() {
        while (true) {
            terminalOutputManager.printlnToTheOutputStream("Введите значение поля cool для объекта Car:");
            String humanBeingCarCool = terminalInputManager.getNextLine();
            if (FieldValidators.validateHumanBeingCarIs(humanBeingCarCool))
                return Boolean.parseBoolean(humanBeingCarCool);
            else
                terminalOutputManager.printlnToTheOutputStream("Значение поля cool для объекта Car должно быть true или false!");
        }
    }
}
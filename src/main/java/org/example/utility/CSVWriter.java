package org.example.utility;

import org.example.collectionEntities.HumanBeing;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Utility class for writing HumanBeing objects to a CSV file via BufferedOutputStream.
 * Provides methods to convert a map of HumanBeing objects to a CSV format.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class CSVWriter {

    /**
     * Constant string representing the header row of the CSV file.
     * Contains column names for each field in the HumanBeing object.
     */
    static final String FILE_HEADER = "KEY" +
            "\t" + "ID"
            + "\t" + "NAME"
            + "\t" + "X"
            + "\t" + "Y"
            + "\t" + "CREATION_DATE"
            + "\t" + "REAL_HERO"
            + "\t" + "HAS_TOOTHPICK"
            + "\t" + "IMPACT_SPEED"
            + "\t" + "SOUNDTRACK_NAME"
            + "\t" + "MINUTES_OF_WAITING"
            + "\t" + "WEAPON_TYPE"
            + "\t" + "CAR_NAME"
            + "\t" + "CAR_COOL" + "\n";


    /**
     * Writes the given map of HumanBeing objects to a CSV file.
     *
     * @param humanBeings Map of HumanBeing objects to be written to the file.
     * @param fileName The name of the file to write to.
     * @throws IOException if there's an error during file writing.
     */
    public void printToFile(LinkedHashMap<Integer, HumanBeing> humanBeings, String fileName) throws IOException {
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName));
        out.write(FILE_HEADER.getBytes());
        byte[] buff = lines(humanBeings).getBytes();
        out.write(buff);
        out.close();
    }

    /**
     * Generates a single line of CSV data for a given HumanBeing object.
     *
     * @param humanBeing The HumanBeing object whose data should be converted to CSV format.
     * @return A string representation of the HumanBeing object in CSV format.
     */
    private String line(HumanBeing humanBeing){
        return "\t" + humanBeing.getId()
                + "\t" + humanBeing.getName()
                + "\t" + humanBeing.getCoordinates().getX()
                + "\t" + humanBeing.getCoordinates().getY()
                + "\t" + humanBeing.getCreationDate()
                + "\t" + humanBeing.isRealHero()
                + "\t" + humanBeing.isHasToothpick()
                + "\t" + humanBeing.getImpactSpeed()
                + "\t" + humanBeing.getSoundtrackName()
                + "\t" + humanBeing.getMinutesOfWaiting()
                + "\t" + humanBeing.getWeaponType()
                + "\t" + humanBeing.getCar().getName()
                + "\t" + humanBeing.getCar().isCool();
    }

    /**
     * Converts a map of HumanBeing objects to a CSV-formatted string.
     *
     * @param humanBeings Map of HumanBeing objects to be converted to CSV format.
     * @return A string representation of all HumanBeing objects in CSV format.
     */
    private String lines(LinkedHashMap<Integer, HumanBeing> humanBeings){
        String result = "";
        for (Map.Entry<Integer, HumanBeing> entry : humanBeings.entrySet()) {
            Integer key = entry.getKey();
            HumanBeing value = entry.getValue();
            result = result + key + line(value) + "\n";
        }
        return result;
    }
}

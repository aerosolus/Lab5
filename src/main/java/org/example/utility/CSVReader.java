package org.example.utility;

import org.example.collectionEntities.Car;
import org.example.collectionEntities.Coordinates;
import org.example.collectionEntities.HumanBeing;
import org.example.collectionEntities.WeaponType;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;

import static org.example.utility.CSVWriter.FILE_HEADER;

/**
 * Represents a utility class for reading HumanBeing objects from a CSV file via InputStreamReader.
 * This class provides methods to parse a CSV file and create a map of HumanBeing objects.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class CSVReader {

    /**
     * Reads a CSV file and returns a map of HumanBeing objects.
     *
     * @param fileName The name of the CSV file to read.
     * @return linkedHashMap of HumanBeing objects keyed by their ID.
     * @throws IOException if there's an error during file reading.
     */
    public LinkedHashMap<Integer, HumanBeing> readFile(String fileName) throws IOException {
        LinkedHashMap<Integer, HumanBeing> linkedHashMap = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        if ((reader.readLine() + "\n").equals(FILE_HEADER)) {
            while ((line = reader.readLine()) != null) {
                String[] properties = line.split("\t"); // Assuming tab symbol as the delimiter
                Integer key = Integer.parseInt(properties[0]); // First value is the key
                HumanBeing result = new HumanBeing();
                result.setId(Integer.valueOf(properties[1]));
                if ((properties[2].equals("null")) || properties[2].isEmpty()) {
                    result.setName("standardName"); //if null, then set it to smt standard
                }
                else {
                    result.setName(properties[2]);
                }
                result.setCoordinates(new Coordinates(
                        new Coordinates.CoordinatesBuilder(Double.parseDouble(properties[3]),
                                Long.parseLong(properties[4]))));
                if (properties[5].equals("null")) {
                    result.setCreationDate(LocalDateTime.now()); //if null, then set it to smt standard
                }
                else {
                    result.setCreationDate(LocalDateTime.parse(properties[5]));
                }

                result.setRealHero(Boolean.parseBoolean(properties[6]));
                result.setHasToothpick(Boolean.parseBoolean(properties[7]));
                result.setImpactSpeed(Long.parseLong(properties[8]));
                if (properties[9].equals("null")) {
                    result.setSoundtrackName("standardSoundtrackName"); //if null, then set it to smt standard
                }
                else {
                    result.setSoundtrackName(properties[9]);
                }
                if (properties[10].equals("null")) {
                    result.setMinutesOfWaiting(Double.valueOf(0)); //if null, then set it to smt standard
                }
                else {
                    result.setMinutesOfWaiting(Double.valueOf(properties[10]));
                }
                if (properties[11].equals("null")) {
                    result.setWeaponType(WeaponType.AXE); //if null, then set it to smt standard
                }
                else {
                    result.setWeaponType(WeaponType.valueOf(properties[11]));
                }
                if (properties[12].equals("null")) {
                    Car car = new Car(new Car.CarBuilder("standardCarName")); //if null, then set it to smt standard
                    car.setCool(Boolean.parseBoolean(properties[13]));
                    result.setCar(car);
                }
                else {
                    Car car = new Car(new Car.CarBuilder(properties[12]));
                    car.setCool(Boolean.parseBoolean(properties[13]));
                    result.setCar(car);
                }
                linkedHashMap.put(key, result);
            }
        }
        else {
            System.out.println("Wrong file was being tried to read!");
        }
        return linkedHashMap;
    }
}
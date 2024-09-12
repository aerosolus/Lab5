package org.example.utility;

import org.example.dao.CollectionManager;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * Utility class for creating and initializing the CollectionManager.
 * This class provides a method to load the CollectionManager from a file.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public final class CollectionCreator {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private CollectionCreator() {
    }

    /**
     * Loads and initializes the CollectionManager from a file.
     *
     * @return An initialized CollectionManager instance.
     * @throws NullPointerException if the file path is null.
     */
    public static CollectionManager load() {
        String filePath = System.getenv("STORAGE_FILE");
        CSVReader csvReader = new CSVReader();
        CollectionManager collectionManager;
        if (filePath == null) {
            //filePath = "data.csv"; //works on any PC
            filePath = "абвгд.csv"; //some other cases
            System.out.println("Не удалось получить имя файла для загрузки коллекции.");
            System.out.println("Загружена коллекция из файла по умолчанию.");
        }
        //System.out.println("Storage file: " + filePath);
        try {
            collectionManager = new CollectionManager(csvReader.readFile(filePath), filePath);
        } catch (NullPointerException | IOException e) {
            System.out.println("Файл по некой причине не был прочитан. Создана пустая коллекция.");
            collectionManager = new CollectionManager(new LinkedHashMap<>(), filePath);
        }
        collectionManager.setFilePath(filePath);
        return collectionManager;
    }
}
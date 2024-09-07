package org.example.utility;

import org.example.contoller.Handler;
import org.example.dao.CollectionManager;

/**
 * Singleton instance of the CollectionManager.
 * This manager is responsible for managing collection in the application.
 * This class manages the lifecycle of the application and handles command execution.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 *
 * @see org.example.contoller.Handler
 * @see org.example.dao.CollectionManager
 */
public class ServerEntryPoint {

    /**
     * Singleton instance of the CollectionManager.
     * This manager is responsible for managing collection in the application.
     */
    public static CollectionManager collectionManager;

    /**
     * Default constructor for ServerEntryPoint.
     * Initializes the CollectionManager by loading it from a configuration file.
     */
    public ServerEntryPoint(){
        collectionManager = CollectionCreator.load();
    }

    /**
     * Executes a given command through the Handler.
     *
     * @param handler The Handler object responsible for processing commands.
     */
    public void performCom(Handler handler){
        handler.getCommand().execute();
    }
}
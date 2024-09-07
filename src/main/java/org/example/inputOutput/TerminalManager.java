package org.example.inputOutput;

import org.example.Main;
import org.example.collectionEntities.Car;
import org.example.collectionEntities.Coordinates;
import org.example.collectionEntities.HumanBeing;
import org.example.contoller.CommandRequestManager;
import org.example.utility.ServerEntryPoint;

import static org.example.Main.terminalOutputManager;

/**
 * Manages the terminal interface for user interaction.
 * This class handles the main loop of the application, processing user input and executing commands.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class TerminalManager {

    /**
     * Manager for handling command requests.
     */
    private final CommandRequestManager commandRequestManager;

    /**
     * Manager for handling terminal input.
     */
    private final TerminalInputManager inputManager;

    /**
     * Manager for handling terminal output.
     */
    private final TerminalOutputManager outputManager;

    /**
     * Constructs a TerminalManager with the given components.
     *
     * @param commandRequestManager Manager for handling command requests.
     * @param inputManager          Manager for handling terminal input.
     * @param outputManager         Manager for handling terminal output.
     */
    public TerminalManager(CommandRequestManager commandRequestManager,
                           TerminalInputManager inputManager,
                           TerminalOutputManager outputManager) {
        this.commandRequestManager = commandRequestManager;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    /**
     * Starts the main loop of the application.
     * Continuously reads user input and processes commands until the program ends.
     */
    public void start() {
        while (true) {
            try {
                if (Main.script) {
                    if (!inputManager.scriptBox.isEmpty()) {
                        String[] readLine = inputManager.scriptBox.pop();
                        commandRequestManager.preparationForShipment(readLine[0], readLine[1]);
                    } else {
                        Main.script = false;
                    }
                } else {
                    outputManager.printlnWriteCommand();
                    TerminalInputValidator readLine = inputManager.readTerminal();
                    //^ проверка количества возвррщенных элементов; красивая обработка; kinda
                    commandRequestManager.preparationForShipment(readLine.getCommandName(), readLine.getCommandArguments());
                }
            } catch (NullPointerException e) {
                outputManager.printlnNotCorrectInput();
            }
        }
    }

    /**
     * Creates a new HumanBeing object based on user input.
     *
     * @return A newly created HumanBeing object.
     */
    public HumanBeing createHumanBeing() {
        HumanBeingFieldValuesGetter humanBeingFieldValuesGetter = new HumanBeingFieldValuesGetter(
                new TerminalInputManager(System.in, terminalOutputManager),
                terminalOutputManager);
        return
                new HumanBeing.HumanBeingBuilder(ServerEntryPoint.collectionManager.generateId(),
                        humanBeingFieldValuesGetter.getHumanBeingName(),
                        new Coordinates(new Coordinates.CoordinatesBuilder(
                                humanBeingFieldValuesGetter.getHumanBeingCoordinateX(),
                                humanBeingFieldValuesGetter.getHumanBeingCoordinateY())
                        ),
                        humanBeingFieldValuesGetter.getHumanBeingHasToothpick(),
                        humanBeingFieldValuesGetter.getHumanBeingSoundtrackName(),
                        humanBeingFieldValuesGetter.getHumanBeingImpactSpeed(),
                        humanBeingFieldValuesGetter.getHumanBeingMinutesOfWaiting())
                        .setRealHero(humanBeingFieldValuesGetter.getHumanBeingRealHero())
                        .setWeaponType(humanBeingFieldValuesGetter.getHumanBeingWeaponType())
                        .setCar(createCar())
                        .build();
    }

    /**
     * Updates an existing HumanBeing object based on user input.
     *
     * @param id The ID of the HumanBeing object to update.
     * @return An updated HumanBeing object.
     */
    public HumanBeing updateHumanBeing(int id) {
        HumanBeingFieldValuesGetter humanBeingFieldValuesGetter = new HumanBeingFieldValuesGetter(
                new TerminalInputManager(System.in, terminalOutputManager),
                terminalOutputManager);
        return
                new HumanBeing.HumanBeingBuilder(id,
                        humanBeingFieldValuesGetter.getHumanBeingName(),
                        new Coordinates(new Coordinates.CoordinatesBuilder(
                                humanBeingFieldValuesGetter.getHumanBeingCoordinateX(),
                                humanBeingFieldValuesGetter.getHumanBeingCoordinateY())
                        ),
                        humanBeingFieldValuesGetter.getHumanBeingHasToothpick(),
                        humanBeingFieldValuesGetter.getHumanBeingSoundtrackName(),
                        humanBeingFieldValuesGetter.getHumanBeingImpactSpeed(),
                        humanBeingFieldValuesGetter.getHumanBeingMinutesOfWaiting())
                        .setRealHero(humanBeingFieldValuesGetter.getHumanBeingRealHero())
                        .setWeaponType(humanBeingFieldValuesGetter.getHumanBeingWeaponType())
                        .setCar(createCar())
                        .build();
    }

    /**
     * Creates a new Car object based on user input.
     *
     * @return A newly created Car object.
     */
    public Car createCar() {
        HumanBeingFieldValuesGetter humanBeingFieldValuesGetter = new HumanBeingFieldValuesGetter(
                new TerminalInputManager(System.in, terminalOutputManager),
                terminalOutputManager);
        return
                new Car.CarBuilder(
                        humanBeingFieldValuesGetter.getHumanBeingCarName())
                        .setCool(humanBeingFieldValuesGetter.getHumanBeingCarIsCool())
                        .build();
    }
}

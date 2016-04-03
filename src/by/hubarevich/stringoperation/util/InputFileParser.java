package by.hubarevich.stringoperation.util;

import by.hubarevich.stringoperation.exception.WrongInputException;
import org.apache.log4j.Logger;

import java.io.*;


/**
 * Created by Anton on 15.12.2015.
 * Class parses File for reading to String object.
 */
public class InputFileParser {

    private static final Logger LOGGER = Logger.getLogger(InputFileParser.class);

    private static BufferedReader bufferedReader;
    private static FileInputStream fileInputStream;
    private static String inputString = "";
    private static String line;

    /**
     * Getting file address and return String objecti
     * @param fileAddress - file address in String object
     * @return - the whole text in one String
     */

    public static String makeInputString(String fileAddress) throws WrongInputException{

        try {
            fileInputStream = new FileInputStream(fileAddress);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            line = bufferedReader.readLine();
            while (line != null) {

                inputString = inputString.concat(line).concat("\n");
                line = bufferedReader.readLine();

            }

            if (inputString.isEmpty()) {
                throw new WrongInputException ("It's something bad with the input");
            }

        } catch (FileNotFoundException e) {

            LOGGER.fatal(e);

        } catch (IOException e) {

            LOGGER.error(e);
        }
        return inputString;
    }
}

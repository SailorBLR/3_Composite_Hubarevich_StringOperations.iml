package by.hubarevich.stringoperation.main;

import by.hubarevich.stringoperation.action.TextHandler;

import java.io.IOException;

/**
 * Created by Anton on 14.12.2015.
 * Class-runner for an application
 */
public class StringParserRunner {

    private static final String FILE_ADDRESS = "source_eckel.txt";


    public static void main(String[ ] args)throws IOException{

       TextHandler textHandler = new TextHandler();
        textHandler.handleText(FILE_ADDRESS);

    }
}

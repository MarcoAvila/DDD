package org.marcoavila.ddd.util.testingapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Sample app to show the mechanics.
 * 
 * @author Marco Avila
 */
public class SampleConsoleApp extends ConsoleApp {

	private String myText;
	
	private boolean settingText = false;
	
	
	
	
	
	
	//Config here!
	protected SampleConsoleApp() {
		super("SampleConsoleApp", "(c)2017 Marco Avila", 
				new ConsoleWindow(80, 16, "O"));
	}

	
	
	
	
	
	
	
	
	@Override
	protected void render() {
		
		window.breakLine(6);
		
		if (myText != null) {
			window.printLine("-");
			window.printCenter(myText != null ? myText : "[no text]" );
			window.printLine("-");
		}
		else
			window.printCenter("[no text]");
	}

	
	
	
	
	
	
	
	
	
	
	@Override
	protected List<String> availableCommands() {

		List<String> commands = new ArrayList<>();
		
		commands.add("set [t]ext");
		commands.add("[c]lear text");
		
		return commands;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	protected void processCommand(String command) {

		clearStatusMessage();
		
		//Set text
		if ("t".equalsIgnoreCase(command)) {
			settingText = true;
			setStatusMessage("DIGITE O TEXTO!");
		} else
			
		//Clear text
		if ("c".equalsIgnoreCase(command))
			myText = null;
		else
			
		//Type text
		if (settingText) {
			myText = command;
			settingText = false;
		}		
	}

	
	
	

	
	
	
	
	
	

	public static void main(String[] a) {
		
		ConsoleApp app = new SampleConsoleApp();
		
		app.run();
	}



	
	
	
	
}

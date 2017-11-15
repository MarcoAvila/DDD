package org.marcoavila.ddd.util.testingapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.marcoavila.ddd.util.Log;

/**
 * Simple console app to test some DDD façades.
 * 
 * @author Marco Avila
 */
public abstract class ConsoleApp {

	private String name;
	private String headerText;
	
	private boolean executing = true;
	
	private String statusMessage = "";
	
	protected ConsoleWindow window;
	
		
	
	
	protected ConsoleApp(String name, String headerText, ConsoleWindow window) {		
		this.name = name;
		this.headerText = headerText;
		
		this.window = window;
	}















	public final void run() {

		Log.log("Application started...");
		
		Scanner scanner = new Scanner(System.in);
		
		while (executing) {

			//Render
			renderScreen();
					
			//Input
			String input = scanner.nextLine();	
			
			statusMessage = "Last command: " + input;	
			
			//Exit
			if (input.equals("e"))
				executing = false;
			else
				processCommand(input);
		}
		
		Log.log("Application stopped.");
				
		scanner.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	private void renderScreen() {
				
		//Header
		window.printHeader(name, headerText);
		
		//Render
		render();
				
		//Footer		
		window.printFooter(statusMessage, commands());
		
		window.printTextCenterNoFrame("Waiting command...");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private List<String> commands() {

		List<String> commands = availableCommands();	
		
		if (commands == null)
			commands = new ArrayList<>();

		commands.add("[e]xit");
		
		return commands;
	}
	
	
	
	
	
	
	
	
	
	
	
	//xTension
	protected abstract void render();
	
	protected abstract List<String> availableCommands();
		
	protected abstract void processCommand(String command);








	
	
	
	
	
	



	protected void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	

	protected void clearStatusMessage() {
		this.statusMessage = "";
	}
	
	
	
	
	
	
	
	
}

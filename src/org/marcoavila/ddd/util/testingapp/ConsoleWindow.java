package org.marcoavila.ddd.util.testingapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.marcoavila.ddd.util.Log;
import org.marcoavila.ddd.util.StringsUtil;

/**
 * Emulates an app 'window' on the console
 * 
 * @author Marco Avila
 */
public class ConsoleWindow {

	private final int WIDTH;
	private final int HEIGHT;
	
	private final String THEME;
	private final String SPACE = " ";
	
	private final String LINE;
	
	private int renderedLines = 0;
	
	
	
	
	

	public ConsoleWindow(int width, int height, String theme) {
		WIDTH = width;
		HEIGHT = height;
		THEME = theme;
		
		LINE = StringsUtil.times(THEME, WIDTH);
	}






	
	
	
	
	
	public void print(String text) {
		
		renderedLines++;
		
		printText(text);
	}
	
	
	
	
	
	
	
	
	

	
	public void printCenter(String text) {
		
		renderedLines++;
		
		printTextCenter(text);
	}
	
	
	
	
	
	
	
	


	public void printLine(String theme) {

		renderedLines++;
		
		printText( StringsUtil.times(theme, WIDTH - 4) );
	}
	

	
	
	
	
	

	
	
	public void breakLine() {
		
		renderedLines++;
		
		printText("");
	}
	

	
	
	
	
	
	
	public void breakLine(int count) {
		
		renderedLines += count;
		
		for (int i=0; i<count; i++)
			printText("");
	}
	
	
	
	
	
	
	
	
	
	
	
	public void printHeader(String left, String right) {
			
		renderedLines = 0;
		
		Log.printLn("");
		Log.printLn(LINE);
		
		print(left, right);
				
		Log.printLn(LINE);
	}
	
	
	

	
	
	
	
	
	public void printFooter(String text, List<String> commands) {
		
		for (int i=0; i<HEIGHT - renderedLines; i++)
			printText("");
		
		String time = new SimpleDateFormat("dd/MM/yy HH:mm").format(new Date());
		
		Log.printLn(LINE);
		for (int i=0; i<commands.size(); i+=2)
			if (i < commands.size() - 1)			
				printCenter(commands.get(i), commands.get(i+1));
			else
				printCenter(commands.get(i));
				
		Log.printLn(LINE);
		printText(time + SPACE + THEME + THEME + THEME + SPACE + text);

		Log.printLn(LINE);
	}
	
	
	
	
	


	
	

	
	
	

	
	
	public void printTextCenterNoFrame(String text) {
					
		Log.printLn( center(text, WIDTH) );
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void printText(String text) {
		
		String spaces = StringsUtil.times(SPACE, WIDTH - 3 - text.length());
		
		Log.printLn(THEME + SPACE + text + spaces + THEME);
	}
	
	
	
	

	
	
	private void printTextCenter(String text) {
					
		Log.printLn(THEME + center(text, WIDTH - 2) + THEME);
	}
	
	

	
	
	
	
	
	

	
	private void print(String left, String right) {
		
		String spaces = StringsUtil.times(SPACE, WIDTH - 4 - 
						 left.length() - right.length());
		
		Log.printLn(THEME + SPACE + left + spaces + 
				  right + SPACE + THEME);
	}
	
	
	

	

	
	
	
	private void printCenter(String left, String right) {

		final int COLUMN_WIDTH = (WIDTH - 2) / 2;
		
		//Left
		Log.print(THEME);		
		Log.print( center(left, COLUMN_WIDTH) );

		//Right		
		Log.print( center(right, COLUMN_WIDTH) );
		Log.printLn(THEME);
	}
	
	
	
	
	
	

	
	
	

	
	
	
	
	
	
	private String center(String text, int totalWidth) {

		int availableSpace = totalWidth - text.length();
		
		String spacesBefore = StringsUtil.times(SPACE, availableSpace / 2);
		
		String spacesAfter = StringsUtil.times(SPACE, availableSpace / 2 + 
				(availableSpace % 2 == 1 ? 1 : 0) );
		
		return spacesBefore + text + spacesAfter;	
	}
	
	
	
	
	
	
	
}

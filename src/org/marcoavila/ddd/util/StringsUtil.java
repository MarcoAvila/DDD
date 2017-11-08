package org.marcoavila.ddd.util;

public class StringsUtil {

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	public static String tabulated(String text, int columns) {
				
		StringBuffer sb = new StringBuffer(text);
		for (int i=0; i<columns - text.length(); i++)
			sb.append(" ");
		
		return sb.toString();
	}
	


	
	
	
	
	
	
	
	
	
	public static String tabulatedCentered(String text, int columns) {
		
		int diff = columns - text.length();
		
		int c1 = diff / 2;
		int c2 = diff / 2 + (diff % 2);
						
		StringBuffer sb = new StringBuffer();
		
		for (int i=0; i<c1; i++)
			sb.append(" ");
		
		sb.append(text);

		for (int i=0; i<c2; i++)
			sb.append(" ");
		
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

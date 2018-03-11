package org.marcoavila.ddd.util;

/**
 * 
 * @author Marco Avila
 */
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
	
	
	
	
	
	
	
	
	
	public static String times(String string, int times) {
		StringBuffer b = new StringBuffer();
		for (int i=0; i<times;i++)
			b.append(string);
		return b.toString();
	}
	
	
	
	
	
	
	
	
	

	public static String firstName(String fullName) {

		int i = fullName.indexOf(" ");		
		if (i < 0)
			return fullName;
		
		return fullName.substring(0, i);
	}
	
	
	
	
	
	
	

	
	

	public static String onlyNumbers(String text) {
				
		String numbers = "";
		
		for (char c : text.toCharArray()) {				
				boolean isNumber = (c >='0' && c <='9') || 
						            c == '.' || c == ',';				
				if (isNumber)
					numbers += String.valueOf(c);
			}
		
		return numbers;
	}
	
	
	
	
	
	
	
	


	public static String onlyText(String text) {
				
		String onlyText = "";
		
		for (char c : text.toCharArray()) {				
				boolean isNumber = (c >='0' && c <='9') || 
						            c == '.' || c == ',';				
				if (!isNumber)
					onlyText += String.valueOf(c);
			}
		
		return onlyText;
	}
	
	
	
	
	
	

	
	public static String capitalizeFirst(String text) {
		
		return text.substring(0,1).toUpperCase() +
				text.substring(1, text.length());
		
	}
	
	
	
	
	
	
	
/*
	public static void main(String[] a) {
		
		Log.log( StringsUtil.capitalizeFirst("abcdefg") );
	}
*/
	
	
	
	
	
	
	
	
	
	
	
}

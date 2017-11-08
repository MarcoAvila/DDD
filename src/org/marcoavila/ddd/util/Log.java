package org.marcoavila.ddd.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

	
	
	
	
	
	public static void log(String msg){		
		System.out.println( new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + " | " + msg);
	}
	



	

	
	public static void log(Object o){		
		System.out.println( new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + " | " + o.toString() );
	}
	
	
	
	
	
	

	
	
	public static void printRaw(Object o){		
		
		System.out.print(o + " ");
	}
	
	
	
	
	

	
	
	
	
	public static void print(Object o){		
		
		String s = o.toString().replaceAll("<b>", "")
							   .replaceAll("</b>", "");
		
		System.out.println(s);
	}
	
	
	
	

	
	
	
	public static void printLn(Object o){		
		
		print(o);		
		System.out.println("");
	}
	
	
	
	
	

	
	
	public static void nl(){				
		print("");		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void logException(Exception e){

		System.out.println( new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + " | " + e.toString());
		
		StackTraceElement[] steArray = e.getStackTrace();
		
		for (StackTraceElement ste : steArray)
			System.out.println(ste.getClassName() + "." + 
					           ste.getMethodName() + 
					           " (linha " + ste.getLineNumber() +")" );			
	}
	
	
	
	
	
	
	
}

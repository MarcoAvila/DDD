package org.marcoavila.ddd.util;

public class MaskUtil {
public static final char NUMBER = '#';
    
    
    
    
    
    
    
    
    
    
    
    
    

    /**
     * Mask example: "###.###.###-##"
     */
    
    public static String applyMask(String text, String mask, boolean doComplete) {

        if (text == null || text.equals(""))
            return "";
        
        String texto = "";
        
        //Clear (only numbers, no left zeros)
        for (int i=0; i<text.length(); i++)
            if (text.charAt(i) >= '0' &&
                text.charAt(i) <= '9')
            texto += text.charAt(i);

        int length = texto.length();
        for (int i=0; i<length; i++)
            if (texto.charAt(0) == '0')
                texto = texto.substring(1, texto.length());
        
        //Complete with zeros
        if (doComplete){
            int count = 0;
            for (int i=0; i<mask.length(); i++)
                if (mask.charAt(i) == NUMBER)
                        count++;   
                        
            int zerosCount = count - texto.length();  
            for (int i=0; i<zerosCount; i++)
                texto = "0" + texto;  
        }
        
        //Apply mask
        String maskedText = "";
        int j = 0;
        
        for (int i=0; i<mask.length(); i++){
            if (j == texto.length() )
                return maskedText;
            
            if (mask.charAt(i) == NUMBER)
                maskedText += texto.charAt(j++);
            else
                maskedText += mask.charAt(i);    
        }
        
        return maskedText;
    }
    
    
    
    
    
    
    

    
    
    
    
    
    
    public static String removeMask(String text) {
    
        StringBuffer stringBuffer = new StringBuffer();
        
        for (char myChar : text.toCharArray())
            if (myChar >= '0' &&
                myChar <= '9')
                stringBuffer.append(myChar);
        
        return stringBuffer.toString();
    }
}

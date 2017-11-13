package org.marcoavila.ddd.util;

/**
 * 
 * @author Marco Avila
 */
public class ValidationUtil {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static boolean cpf(Long value) {
		
		String cpf = value.toString();
		
		int soma = 0;

		if (cpf.length() == 11) {
			
			for (int i = 0; i < 9; i++) 
				soma += (10 - i) * (cpf.charAt(i) - '0');
			
			soma = 11 - (soma % 11);
			if (soma > 9) 
				soma = 0;
						
			if (soma == (cpf.charAt(9) - '0')) {
				soma = 0;
				for (int i = 0; i < 10; i++) 
					soma += (11 - i) * (cpf.charAt(i) - '0');
				
				soma = 11 - (soma % 11);
				if (soma > 9) 
					soma = 0;
				
				if (soma == (cpf.charAt(10) - '0')) 
					return true;				
			}
		}
		
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static boolean cns(Long value) {
		
		String cns = value.toString();

		if (cns != null && !cns.equals("")) {
			
			if (cns.trim().length() != 15) 
				return false;
			
			float resto, soma;

			soma = ((Integer.valueOf(cns.substring(0, 1)).intValue()) * 15)
					+ ((Integer.valueOf(cns.substring(1, 2)).intValue()) * 14)
					+ ((Integer.valueOf(cns.substring(2, 3)).intValue()) * 13)
					+ ((Integer.valueOf(cns.substring(3, 4)).intValue()) * 12)
					+ ((Integer.valueOf(cns.substring(4, 5)).intValue()) * 11)
					+ ((Integer.valueOf(cns.substring(5, 6)).intValue()) * 10)
					+ ((Integer.valueOf(cns.substring(6, 7)).intValue()) * 9)
					+ ((Integer.valueOf(cns.substring(7, 8)).intValue()) * 8)
					+ ((Integer.valueOf(cns.substring(8, 9)).intValue()) * 7)
					+ ((Integer.valueOf(cns.substring(9, 10)).intValue()) * 6)
					+ ((Integer.valueOf(cns.substring(10, 11)).intValue()) * 5)
					+ ((Integer.valueOf(cns.substring(11, 12)).intValue()) * 4)
					+ ((Integer.valueOf(cns.substring(12, 13)).intValue()) * 3)
					+ ((Integer.valueOf(cns.substring(13, 14)).intValue()) * 2)
					+ ((Integer.valueOf(cns.substring(14, 15)).intValue()) * 1);

			resto = soma % 11;

			if (resto != 0) 
				return false;
			else 
				return true;			
		}

		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	
	@Test
	public void test() {		
		
		Assert.assertTrue( cpf(70405441053l) );
		Assert.assertTrue( cns(801434325360153l) );

		Assert.assertFalse( cpf(70405441054l) );
		Assert.assertFalse( cns(801434325360154l) );
	}
*/	
	
	
	
	
	
	
}

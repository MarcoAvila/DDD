package com.procergs.ddd.test.spec;

import org.junit.Assert;
import org.junit.Test;

import com.procergs.ddd.spec.Specification;

/**
 * 
 * @author Marco Avila
 */
public class TestSpec {

	
	
	
	
	
	
	
	

	@Test
	public void test() {
		
		Specification<String> specSingleChar = new SingleCharSpec();		
		Specification<String> specUpperCase = new UpperCaseSpec();
		
		String string1 = "A";
		String string2 = "ab";
		String string3 = "AB";
		String string4 = "a";
		
		Assert.assertTrue( specSingleChar.isSatisfiedBy(string1) );
		Assert.assertTrue( specUpperCase.isSatisfiedBy(string1) );

		Assert.assertFalse( specSingleChar.isSatisfiedBy(string2) );
		Assert.assertFalse( specUpperCase.isSatisfiedBy(string2) );

		Assert.assertFalse( specSingleChar.isSatisfiedBy(string3) );
		Assert.assertTrue( specUpperCase.isSatisfiedBy(string3) );
		
		//And
		Assert.assertTrue( specSingleChar.and(specUpperCase).isSatisfiedBy(string1) );
		Assert.assertFalse( specSingleChar.and(specUpperCase).isSatisfiedBy(string3) );

		//Or
		Assert.assertTrue( specSingleChar.or(specUpperCase).isSatisfiedBy(string1) );
		Assert.assertTrue( specSingleChar.or(specUpperCase).isSatisfiedBy(string3) );
		Assert.assertFalse( specSingleChar.or(specUpperCase).isSatisfiedBy(string2) );
				
		//Not
		Assert.assertTrue( specSingleChar.not().isSatisfiedBy(string2) );
		Assert.assertFalse( specSingleChar.not().isSatisfiedBy(string1) );
		
		//Xor
		Assert.assertTrue( specSingleChar.xor(specUpperCase).isSatisfiedBy(string4) );
		Assert.assertFalse( specSingleChar.xor(specUpperCase).isSatisfiedBy(string1) );
				
		//And Or Not
		Specification<String> spec = specSingleChar.and( specUpperCase.or(specSingleChar.not()) );
		Assert.assertTrue( spec.isSatisfiedBy(string1) );
		
		// remainderUnsatisfiedBy retorna a especificação que não foi atendida pelo objeto		
		spec = specSingleChar.and(specUpperCase);

		Assert.assertFalse( spec.isSatisfiedBy(string3) );
		
		//Specification<String> unsatisfiedSpec = spec.remainderUnsatisfiedBy(string1);
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
}

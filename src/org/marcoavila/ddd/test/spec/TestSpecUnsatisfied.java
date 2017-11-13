package com.procergs.ddd.test.spec;

import org.junit.Assert;
import org.junit.Test;

import com.procergs.ddd.spec.Specification;

/**
 * 
 * @author Marco Avila
 */
public class TestSpecUnsatisfied {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Test
	public void test() {
		
		Specification<String> specSingleChar = new SingleCharSpec();		
		Specification<String> specTwoChars = new TwoCharsSpec();	
		Specification<String> specUpperCase = new UpperCaseSpec();

		String string1 = "a";
		String string2 = "A";
		String string3 = "AB";
		
		// 2 specs
		Specification<String> spec = specSingleChar
									.and(specUpperCase);
				
		Specification<String> unsatisfiedSpec = spec.remainderUnsatisfiedBy(string3);
		
		Assert.assertEquals(specSingleChar, unsatisfiedSpec);	
		
		// 3 specs - 1ª		
		spec = specSingleChar
				.and(specUpperCase)
				.and(specTwoChars);
		
		unsatisfiedSpec = spec.remainderUnsatisfiedBy(string3);
		
		Assert.assertEquals(specSingleChar, unsatisfiedSpec);	
		
		// 3 specs - 2ª		
		spec = specSingleChar
				.and(specTwoChars)
				.and(specUpperCase);
		
		unsatisfiedSpec = spec.remainderUnsatisfiedBy(string1);
		
		Assert.assertEquals(specTwoChars, unsatisfiedSpec);	
		
		// 3 specs - 3ª		
		spec = specSingleChar
				.and(specUpperCase)
				.and(specTwoChars);
		
		unsatisfiedSpec = spec.remainderUnsatisfiedBy(string2);
		
		Assert.assertEquals(specTwoChars, unsatisfiedSpec);			
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

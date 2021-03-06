package org.marcoavila.ddd.test.spec;

import org.junit.Assert;
import org.junit.Test;
import org.marcoavila.ddd.spec.Specification;

public class TestSpecUnsatisfied {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Test
	public void test() {
		
		Specification<String> specSingleChar = new SpecSingleChar();		
		Specification<String> specTwoChars = new SpecTwoChars();	
		Specification<String> specUpperCase = new SpecUpperCase();

		String string1 = "a";
		String string2 = "A";
		String string3 = "AB";
		
		// 2 specs
		Specification<String> spec = specSingleChar
									.and(specUpperCase);
				
		Specification<String> unsatisfiedSpec = spec.remainderUnsatisfiedBy(string3);
		
		Assert.assertEquals(specSingleChar, unsatisfiedSpec);	
		
		// 3 specs - 1�	
		spec = specSingleChar
				.and(specUpperCase)
				.and(specTwoChars);
		
		unsatisfiedSpec = spec.remainderUnsatisfiedBy(string3);
		
		Assert.assertEquals(specSingleChar, unsatisfiedSpec);	
		
		// 3 specs - 2�	
		spec = specSingleChar
				.and(specTwoChars)
				.and(specUpperCase);
		
		unsatisfiedSpec = spec.remainderUnsatisfiedBy(string1);
		
		Assert.assertEquals(specTwoChars, unsatisfiedSpec);	
		
		// 3 specs - 3�
		spec = specSingleChar
				.and(specUpperCase)
				.and(specTwoChars);
		
		unsatisfiedSpec = spec.remainderUnsatisfiedBy(string2);
		
		Assert.assertEquals(specTwoChars, unsatisfiedSpec);			
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

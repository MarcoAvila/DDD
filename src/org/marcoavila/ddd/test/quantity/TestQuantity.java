package org.marcoavila.ddd.test.quantity;

import org.junit.Assert;
import org.junit.Test;
import org.marcoavila.ddd.quantity.QuantityVO;
import org.marcoavila.ddd.quantity.unit.UnitLiterVO;

public class TestQuantity {

	
	
	
	
	
	
	
	

	@Test
	public void test() {

		QuantityVO q = new QuantityVO(1, UnitLiterVO.instance);
		
		String display = q.display();
		
		QuantityVO parsed = QuantityVO.parse(display);
		
		Assert.assertEquals(q, parsed);
		
	}

	
	
	
	
	
	
	
	
	
	
}

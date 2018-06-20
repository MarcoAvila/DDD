package org.marcoavila.ddd.test.quantity;

import org.junit.Assert;
import org.junit.Test;
import org.marcoavila.ddd.quantity.QuantityVO;
import org.marcoavila.ddd.quantity.unit.UnitCelsiusVO;
import org.marcoavila.ddd.quantity.unit.UnitFahrenheitVO;
import org.marcoavila.ddd.quantity.unit.UnitLiterVO;
import org.marcoavila.ddd.util.Log;

public class TestQuantity {

	
	
	
	
	
	
	
	

	@Test
	public void test() {

		QuantityVO q = new QuantityVO(1, UnitLiterVO.instance);
		
		String display = q.display();
		
		QuantityVO parsed = QuantityVO.parse(display);
		
		Assert.assertEquals(q, parsed);
		
	}

	
	
	
	
	
	
	
	
	

	
	

	@Test
	public void testCelsiusFarenheit() {

		//0
		QuantityVO c = new QuantityVO(0f, UnitCelsiusVO.instance);

		QuantityVO f = c.convertTo( UnitFahrenheitVO.instance);
		
		Log.log( c.display() + " -> " + f.display() );
		
		Assert.assertEquals(32f, f.getAmount(), 0.01f);

		//45
		f = new QuantityVO(45f, UnitFahrenheitVO.instance);

		c = f.convertTo( UnitCelsiusVO.instance);
		
		Log.log( f.display() + " -> " + c.display() );
		
		Assert.assertEquals(7.22f, c.getAmount(), 0.01f);
		
	}

	
	
	
	
	
	
	
	
	
}

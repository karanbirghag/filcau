package ro.pava.ficau.tests;

import java.util.logging.Logger;

import junit.framework.Assert;
import junit.framework.TestCase;
import ro.pava.filcau.domain.Legatura;


public class LegaturaTest
	extends TestCase {
	Logger logger = Logger.getLogger("UnitTesting");


	public void testCompareTo() {
		Legatura leg1 = new Legatura();
		leg1.setNumberOfTromphs(4);
		leg1.setSmallestCardValue(2);

		Legatura leg2 = new Legatura();
		leg2.setNumberOfTromphs(4);
		leg2.setSmallestCardValue(1);

		Assert.assertEquals(1, leg1.compareTo(leg2));

		leg1.setNumberOfTromphs(3);
		Assert.assertEquals(-1, leg1.compareTo(leg2));
	}

}

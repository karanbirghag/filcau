/*
    This file is part of Filcau.

    Filcau is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Filcau is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Filcau.  If not, see <http://www.gnu.org/licenses/>.
 */
package ro.pava.ficau.tests;

import java.util.logging.Logger;

import junit.framework.Assert;
import junit.framework.TestCase;
import ro.pava.filcau.domain.Card;
import ro.pava.filcau.domain.CardsPack;


/**
 * 
 * @author pava
 */
public class CardsPackTest
	extends TestCase {

	private static final Logger logger = Logger.getLogger(CardsPackTest.class.getName());


	/**
	 * Test method for {@link ro.pava.filcau.domain.CardsPack#shuffle()}.
	 */
	public void testShuffle() {
		CardsPack pack = new CardsPack();
		pack.shuffle();
		Card card1 = pack.getNextCard();

		pack = new CardsPack();
		pack.shuffle();

		Card card2 = pack.getNextCard();
		CardsPackTest.logger.info(card1.toString() + " vs. " + card2.toString());
		Assert.assertTrue("same card: ", !card1.toString()
			.equals(card2.toString()));
	}
}

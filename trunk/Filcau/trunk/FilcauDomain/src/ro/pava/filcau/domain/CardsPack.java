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
package ro.pava.filcau.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * 
 * @author pava
 */
public class CardsPack {
	public static int CARDS_COUNT = 20;
	private List<Card> cards = new ArrayList<Card>(CardsPack.CARDS_COUNT);


	public CardsPack() {
		Card card = null;
		Color[] colors = Color.values();
		CardValue[] values = CardValue.values();
		int colorIndex = 0;
		int valueIndex = 0;
		for (int i = 0; i < CardsPack.CARDS_COUNT; i++) {
			if (colorIndex >= colors.length) {
				colorIndex = 0;
			}
			if (valueIndex >= values.length) {
				valueIndex = 0;
			}
			card = new Card(values[valueIndex++], colors[colorIndex]);
			this.cards.add(i, card);

			if ((i + 1) % 5 == 0) {
				colorIndex++;
			}
		}
	}


	public Card getNextCard() {
		return this.cards.remove(this.cards.size() - 1);
	}


	public void shuffle() {
		Random rng = new Random();
		int n = this.cards.size();
		while (--n > 0) {
			int k = rng.nextInt(n + 1); // 0 <= k <= n (!)
			Card temp = this.cards.get(n);
			this.cards.set(n, this.cards.get(k));
			this.cards.set(k, temp);
		}
	}
}

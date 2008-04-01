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


/**
 * 
 * @author pava
 */
public abstract class Player {

	private String name;
	private List<Card> hand = new ArrayList<Card>(5);


	public void receiveCard(final Card card) {
		this.hand.add(card);
	}


	public abstract Legatura announce();


	public abstract int sayNumberOfTromphs();


	public abstract boolean shoutFrish();


	public Card giveAwayCard(final int index) {
		if ((index >= 0) && (index < this.hand.size())) {
			return this.hand.remove(index);
		}
		return null;
	}


	public List<Card> showHand() {
		return this.hand;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}
}

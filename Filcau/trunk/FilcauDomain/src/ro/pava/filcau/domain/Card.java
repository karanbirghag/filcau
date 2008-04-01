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

/**
 * 
 * @author pava
 */
public class Card {
	private CardValue value;
	private Color color;


	public Card(final CardValue val, final Color col) {
		this.value = val;
		this.color = col;
	}


	public boolean isFilcau() {
		return CardValue.THREE.equals(this.value);
	}


	public int getPoints() {
		return this.value.getPoints();
	}


	/**
	 * @return the value
	 */
	public CardValue getValue() {
		return this.value;
	}


	/**
	 * @param value the value to set
	 */
	public void setValue(final CardValue value) {
		this.value = value;
	}


	/**
	 * @return the color
	 */
	public Color getColor() {
		return this.color;
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(final Color color) {
		this.color = color;
	}


	public String toString() {
		return this.value + " de " + this.color;
	}
}

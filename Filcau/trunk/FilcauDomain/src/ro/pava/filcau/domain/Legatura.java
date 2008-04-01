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
public class Legatura
	implements Comparable<Legatura> {

	private int numberOfTromphs;
	private int smallestCardValue;


	@Override
	public int compareTo(final Legatura o) {
		if (this.numberOfTromphs != o.numberOfTromphs) {
			return new Integer(this.numberOfTromphs).compareTo(o.numberOfTromphs);
		} else {
			return new Integer(this.smallestCardValue).compareTo(o.smallestCardValue);
		}
	}


	/**
	 * @return the numberOfTromphs
	 */
	public int getNumberOfTromphs() {
		return this.numberOfTromphs;
	}


	/**
	 * @param numberOfTromphs the numberOfTromphs to set
	 */
	public void setNumberOfTromphs(final int numberOfTromphs) {
		this.numberOfTromphs = numberOfTromphs;
	}


	/**
	 * @return the smallestCardValue
	 */
	public int getSmallestCardValue() {
		return this.smallestCardValue;
	}


	/**
	 * @param smallestCardValue the smallestCardValue to set
	 */
	public void setSmallestCardValue(final int smallestCardValue) {
		this.smallestCardValue = smallestCardValue;
	}

}

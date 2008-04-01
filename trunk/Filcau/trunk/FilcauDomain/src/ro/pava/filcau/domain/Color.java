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
 * Enum describing all the possible colors of the cards.
 * 
 * @author pava
 */
public enum Color {
	DUBA(0), ROSU(1), VERDE(2), GHINDA(3);

	private int value;


	private Color(final int val) {
		this.value = val;
	}


	public String toString() {
		String string = null;
		switch (this.value) {
			case 0:
				string = "duba";
				break;
			case 1:
				string = "rosu";
				break;
			case 2:
				string = "verde";
				break;
			case 3:
				string = "ghinda";
				break;
		}
		return string;
	}
}

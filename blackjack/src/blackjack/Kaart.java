package blackjack;

public class Kaart {

	private Suit mySuit;
	private int myNumber;

	// Kaart constructor
	public Kaart(Suit aSuit, int aNumber) {

		this.mySuit = aSuit;
		if (aNumber >= 1 && aNumber <= 13) {
			this.myNumber = aNumber;
		} else {
			System.out.println(aNumber + "Kaartnr klopt niet");

		}

	}

	// return nodig want myNumber is private
	public int getNumber() {

		return myNumber;

	}

	public String toString() {

		String numStr = "Error";

		switch (this.myNumber) {

		case 2:
			numStr = "Twee";
			break;

		case 3:
			numStr = "Drie";
			break;

		case 4:
			numStr = "Vier";
			break;

		case 5:
			numStr = "Vijf";
			break;

		case 6:
			numStr = "Zes";
			break;

		case 7:
			numStr = "Zeven";
			break;

		case 8:
			numStr = "Acht";
			break;

		case 9:
			numStr = "Negen";
			break;

		case 10:
			numStr = "Tien";
			break;

		case 11:
			numStr = "Boer";
			break;

		case 12:
			numStr = "Vrouw";
			break;

		case 13:
			numStr = "Heer";
			break;

		case 1:
			numStr = "Aas";
			break;
		}

		return numStr + " " + mySuit.toString();

	}

}

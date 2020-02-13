package blackjack;

public class Speler {
	private String name;
//nieuwe array voor hand, zetten 10 kaarten als die limiet.
// met een arraylist was de 10 niet nodig geweest
	private Kaart[] hand = new Kaart[10];
	private int numCards;

//constructor voor Speler, zelfde naam als class. kan methoden bedenken die je later aanmaakt.
	public Speler(String aName) {
		this.name = aName;
		this.emptyHand();

	}

//speler begint met 0 kaarten in de hand met de method emptyHand
	public void emptyHand() {
		for (int k = 0; k < 10; k++) {
			this.hand[k] = null;
		}
		this.numCards = 0;
	}

	public boolean addKaart(Kaart aKaart) {
		if (this.numCards == 10) {
			System.out.println("kan niet meer kaarten houden");

		}

		this.hand[this.numCards] = aKaart;
		this.numCards++;

		return (this.getHandSum() <= 21);

	}

	public int getHandSum() {
		int handSum = 0;
		int cardNum;
		int numAces = 0;

		for (int k = 0; k < this.numCards; k++) {
			cardNum = this.hand[k].getNumber();

			if (cardNum == 1) {
				numAces++;
				handSum += 11;
			} else if (cardNum > 10) {
				handSum += 10;
			} else {
				handSum += cardNum;
			}

		}

		while (handSum > 21 && numAces > 0) {
			handSum -= 10;
			numAces--;

		}
		return handSum;

	}

//boolean want is false (verborgen) bij de dealer
	public void printHand(boolean showFirstCard) {
		System.out.printf("%s's cards:/n", this.name);
		for (int k = 0; k < this.numCards; k++) {
			if (k == 0 && !showFirstCard) {
				System.out.println("[hidden]");
			} else {
				System.out.println(this.hand[k].toString());

			}

		}

	}

}

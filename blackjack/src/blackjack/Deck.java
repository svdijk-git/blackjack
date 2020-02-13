package blackjack;

import java.util.Random;

public class Deck {

	private Kaart[] myCards;
	private int numCards;

	public Deck() {

		this(1, false);

	}

	public Deck(int numDecks, boolean shuffle) {
		this.numCards = numDecks * 52;
		this.myCards = new Kaart[this.numCards];

		// index voor kaart begint bij 0
		int k = 0;

		for (int d = 0; d < numDecks; d++) {
			// Voor suit
			for (int s = 0; s < 4; s++) {
				// Voor nummer
				for (int n = 1; n <= 13; n++) {
					// Voeg nieuwe kaart toe
					this.myCards[k] = new Kaart(Suit.values()[s], n);
					k++;
				}
			}
		}

		if (shuffle) {
			this.shuffle();
		}

	}

	public void shuffle() {

		Random rng = new Random();

		Kaart temp;

		int j;
		for (int i = 0; i < this.numCards; i++) {

			// swap method 1 methode om te shufflen, random getal tussen 0 en 51 (52
			// kaarten)
			j = rng.nextInt(this.numCards);

			temp = this.myCards[i];
			this.myCards[i] = this.myCards[j];
			this.myCards[j] = temp;

		}

	}

	public Kaart dealNextCard() {
		Kaart top = this.myCards[0];

		for (int k = 1; k < this.numCards; k++) {
			this.myCards[k - 1] = this.myCards[k];
		}
		this.myCards[this.numCards - 1] = null;

		this.numCards--;

		return top;
	}

	public void printDeck(int numToPrint) {
		for (int k = 0; k < numToPrint; k++) {
			// printf d = integer met width 3, s- print string en /n op nieuwe lijn
			System.out.printf("% 3d/%d %s\n", k + 1, this.numCards, this.myCards[k].toString());
		}
		System.out.printf("\t\t[%d other]\n", this.numCards - numToPrint);
	}

}

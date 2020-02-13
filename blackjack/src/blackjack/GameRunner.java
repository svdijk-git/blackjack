package blackjack;

import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// pak deck 1 en shuffle naar true
		Deck theDeck = new Deck(1, true);

//initialiseren van spelers
		Speler ik = new Speler("Ik");
		Speler dealer = new Speler("Dealer");

		ik.addKaart(theDeck.dealNextCard());
		dealer.addKaart(theDeck.dealNextCard());
		ik.addKaart(theDeck.dealNextCard());
		dealer.addKaart(theDeck.dealNextCard());

		System.out.println("Zie kaarten");

		// true voor kaarten zien en false voor hidden
		ik.printHand(true);
		dealer.printHand(false);
		System.out.println("/n");

		boolean meDone = false;
		boolean dealerDone = false;
		String ans;

		while (!meDone || !dealerDone) {

			// speler beurt
			if (!meDone) {
				System.out.println("Hit (h) of stop (s)");
				ans = sc.next();
				System.out.println();

				if (ans.compareToIgnoreCase("h") == 0)
					;
				meDone = !ik.addKaart(theDeck.dealNextCard());
				ik.printHand(true);
			} else {
				meDone = true;

			}

		}

		// dealer beurt
		if (!dealerDone) {
			if (dealer.getHandSum() < 17) {
				System.out.println("Dealer hit");
				dealerDone = !dealer.addKaart(theDeck.dealNextCard());
				dealer.printHand(false);
			} else {
				System.out.println("Dealer stopt");
				dealerDone = true;

			}
		}

		System.out.println();

		sc.close();
		ik.printHand(true);
		dealer.printHand(true);
		int mySum = ik.getHandSum();
		int dealerSum = dealer.getHandSum();

		if (mySum > dealerSum && mySum <= 21 || dealerSum > 21) {
			System.out.println("Gewonnen!");
		} else {
			System.out.println("Dealer wint");
		}

	}
}
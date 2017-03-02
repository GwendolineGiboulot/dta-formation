package inutile;

public class couleur {

	public static String coloriser(String entree) {

		String[] couleur1 = new String[10];
		String couleur2 = "\033[0m";

		couleur1[0] = "\033[30m";
		couleur1[1] = "\033[31m";
		couleur1[2] = "\033[32m";
		couleur1[3] = "\033[33m";
		couleur1[4] = "\033[34m";
		couleur1[5] = "\033[35m";
		couleur1[6] = "\033[36m";
		couleur1[7] = "\033[37m";
		couleur1[8] = "\033[38m";
		couleur1[9] = "\033[39m";

		String newString = "";

		for (int i = 0; i < entree.length(); ++i) {

			newString += couleur1[i % 10];
			newString += entree.substring(i, i + 1);
			newString += couleur2;
		}

		return newString;

	}
}

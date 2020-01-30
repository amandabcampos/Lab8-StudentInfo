import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 
 * @author amandabcampos
 *
 */

public class StudentsInfo {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		int studentIndex = 0;

		System.out.print("Welcome to our Java class. ");

		boolean looping = true;
		while (looping) {
			System.out.print("Which student would you like to know more about? ");
			while (looping) {
				System.out.println("(enter a number 1-10): ");
				try {
					studentIndex = scnr.nextInt() - 1;
					System.out.print("Student " + (studentIndex + 1) + " is " + getName(studentIndex) + ". What "
							+ "would you like to know about " + getName(studentIndex).split(" ")[0] + "? ");
					looping = false;
				} catch (IndexOutOfBoundsException e) {
					System.out.print("That student does not exist. Please try again ");
				} catch (InputMismatchException e) {
					System.out.print("That student does not exist. Please try again ");
					scnr.nextLine();
				}

			}

			scnr.nextLine();

			looping = true;
			while (looping) {
				System.out.println("(enter or \"hometown\" or \"favorite food\"): ");
				String nextInfo = scnr.nextLine();
				if (nextInfo.equalsIgnoreCase("hometown")) {
					System.out.println(getName(studentIndex).split(" ")[0] + " is from " + getHometown(studentIndex)
							+ ". Would" + " you like to know more? (enter \"yes\" or \"no\"): ");
					if (scnr.nextLine().toLowerCase().startsWith("n")) {
						looping = false;
					}
				} else if (nextInfo.equalsIgnoreCase("favorite food")) {
					System.out.println(
							getName(studentIndex).split(" ")[0] + "'s favorite food is " + getFavoriteFood(studentIndex)
									+ ". Would" + " you like to know more? (enter \"yes\" or \"no\"): ");
					if (scnr.nextLine().toLowerCase().startsWith("n")) {
						looping = false;
					}
				} else {
					System.out.print("That data does not exist. Please try again ");
				}
			}
			
			System.out.println("Would you like to know about another student?");
			if (scnr.nextLine().toLowerCase().startsWith("n")) {
				looping = false;
			} else {
				looping = true;
			}

		}

		System.out.print("Thanks!");
		scnr.close();

	}

	public static String getName(int index) {
		String[] names = { "Amanda Campos", "Jeremy", "Taylor", "Jeff", "Jared", "Marina", "Natalie", "Laura", "Troy",
				"Carla" };
		return names[index];
	}

	public static String getHometown(int index) {
		String[] hometowns = { "Detroit, MI", "Chicago", "New Orleans", "DC", "Providence", "Seattle", "Little Rock",
				"Orlando", "Miami", "LA" };
		return hometowns[index];
	}

	public static String getFavoriteFood(int index) {
		String[] favoriteFoods = { "pizza", "hot dog", "eggs", "bacon", "tofu", "pasta", "beans", "hummus", "sausage",
				"bread" };
		return favoriteFoods[index];
	}

}

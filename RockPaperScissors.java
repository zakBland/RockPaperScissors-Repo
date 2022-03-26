import java.util.Scanner;
public class RockPaperScissors {

	public static void main(String[] args) {
		boolean yes = true;
		do {
		Scanner input = new Scanner(System.in);
		int myWins = 0, myLoss = 0, tie = 0;
		String choice = " ";
		
		System.out.print("Enter the total rounds you want to play: ");
		int rounds = input.nextInt();
		while(rounds < 1) {
			System.out.print("Invalid number of rounds. Please reenter a valid number: ");
			rounds = input.nextInt();
		}
		
		for(int i = 0; i < rounds; i++) {
			Scanner temp = new Scanner(System.in);
			System.out.print("\nEnter your choice (rock, paper, or scissor): ");
			choice = temp.next();
	
			while(!choice.equals("rock") && !choice.equals("paper") && !choice.equals("scissor")) {
				System.out.println("\nInvalid choice! Try again! \nEnter your choice (rock, paper, or scissor): ");
				Scanner temp2 = new Scanner(System.in);
				choice = temp2.nextLine();
			}
		
			String opponent = " ";
			int computer = (int)(Math.random() * 3);	
		
			switch(computer) {
				case 0: opponent = "rock"; break;
				case 1: opponent = "paper"; break;
				case 2: opponent = "scissor"; break;
			}
		
			System.out.println("You chose " + choice);
		
			if(choice.equals(opponent)) {
				System.out.println("Tie! Computer chose " + opponent + ".");
				tie++;
			}
			else if(choice.equals("rock") && opponent.equals("paper")) {
				System.out.println("You lose. Computer chose " + opponent + ". Paper wraps rock!");
				myLoss++;
			}
			else if(choice.equals("rock") && opponent.equals("scissor")) {
				System.out.println("You win! Computer chose " + opponent + ". Rock knocks scissors!");
				myWins++;
			}
			else if(choice.equals("paper") && opponent.equals("scissors")) {
				System.out.println("You lose. Computer chose " + opponent + ". Scissors cut paper!");
				 myLoss++;
			}
			else if(choice.equals("paper") && opponent.equals("rock")) {
				System.out.println("You win! Computer chose " + opponent + ". Paper wraps rock!");
				myWins++;
			}
			else if(choice.equals("scissor") && opponent.equals("rock")) {
				System.out.println("You lose. Computer chose " + opponent + ".  Rock knocks scissors!");
				myLoss++;
			}
			else if(choice.equals("scissor") && opponent.equals("paper")) {
				System.out.println("You win. Computer chose " + opponent + ". Scissors cut paper");
				 myWins++;
			}
		}

			System.out.printf("\nThere were %d rounds. You have won %d round(s) and lost %d round(s). There were %d tie(s). Play again? yes or no.\n", rounds, myWins, myLoss, tie);
			
			Scanner temp3 = new Scanner(System.in);
			String response = temp3.nextLine();
			
			if(!response.equals("yes")) {
				yes = false;
			}
		}while(yes == true);
			
		System.out.println("\nGood game! Thanks for playing!");
	}

}

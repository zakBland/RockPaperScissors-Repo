import java.util.InputMismatchException;
import java.util.Scanner;
public class RockPaperScissors {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//variable to indicate whether the player will play again; default is true
		boolean playAgain = true;
		
		Scanner input;
		
		do {
			input = new Scanner(System.in);
			int myWins = 0, myLoss = 0, tie = 0;
			String choice = " ";
		
			System.out.print("Enter the total rounds you want to play: ");
			int rounds = -1;
			
			try {
				rounds = input.nextInt();
				
				if(rounds < 1) throw new InputMismatchException();
			}catch(InputMismatchException ex) {		

				do {
					System.out.print("Invalid number of rounds. Please re-enter a valid number: ");
					
					rounds = input.nextInt();
					
					
				}while(rounds < 1);
			}
			
			input.nextLine();
			
			for(int i = 0; i < rounds; i++) {
				System.out.print("\nEnter your choice (rock, paper, or scissor): ");
				choice = input.next().trim().toLowerCase();
	
				while(!choice.equals("rock") && !choice.equals("paper") && !choice.equals("scissor")) {
					System.out.println("\nInvalid choice! Try again! \nEnter your choice (rock, paper, or scissor): ");
					choice = input.next().trim().toLowerCase();
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
					System.out.println("You lose. Computer chose " + opponent + ". Paper covers rock!");
					myLoss++;
				}
				else if(choice.equals("rock") && opponent.equals("scissor")) {
					System.out.println("You win! Computer chose " + opponent + ". Rock knocks scissors!");
					myWins++;
				}
				else if(choice.equals("paper") && opponent.equals("scissor")) {
					System.out.println("You lose. Computer chose " + opponent + ". Scissors cut paper!");
					myLoss++;
				}
				else if(choice.equals("paper") && opponent.equals("rock")) {
					System.out.println("You win! Computer chose " + opponent + ". Paper covers rock!");
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

			System.out.printf("\nThere " + (rounds == 1 ? "was" : "were") + " %d round" + (rounds == 1 ? "" : "s") + ". You won %d round" + (myWins == 1 ? "" : "s") + " and lost %d round" + (myLoss == 1 ? "" : "s") + ". There " + (tie == 1 ? "was" : "were") + " %d tie" + (tie == 1 ? "" : "s") + ". Play again? Yes or No.\n", rounds, myWins, myLoss, tie);
			
			input.nextLine();

			String response = input.nextLine();
			
			if(!response.equalsIgnoreCase("yes")) {
				playAgain = false;
			}
		}while(playAgain == true);
		
		input.close();
		System.out.println("\nGood game! Thanks for playing!");
	}

}

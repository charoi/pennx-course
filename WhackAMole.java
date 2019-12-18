
import java.util.Scanner;

public class WhackAMole {

	int score;
	int molesLeft;
	int attemptsLeft;
	char[][] moleGrid;
	
	WhackAMole(int numAttempts,int gridDimension) {
		//constructor, specifies number of whacks and size of grids
		this.molesLeft = 0;
		this.score = 0;
		this.attemptsLeft = numAttempts;
		this.moleGrid= new char [gridDimension][gridDimension];
		for (int i = 0; i<gridDimension;i++) {
			for(int j = 0; j<gridDimension;j++) {
				moleGrid[i][j]='*';
			}
		}//creates a hash grid
	}
	//methods
	boolean place(int x,int y) {
		//coordinates of mole
			if(moleGrid[x][y]=='*') {
			moleGrid[x][y] = 'M';
			molesLeft++;
			return true;
			}
			//else case if the position already has a mole?
			else {
				return false;
			}
			
		}
			
	void whack(int x, int y) {
		//whacks the location
		if (moleGrid[x][y]=='M') {
			System.out.println("whacked!");
			moleGrid[x][y] = 'W';
			score+=10;
			attemptsLeft--;
			molesLeft--;
		}
		else {
			attemptsLeft--;
		}
	}
	void printGridToUser() {
		WhackAMole userGrid = new WhackAMole(50,10);
		for (int i = 0; i<10;i++) {
			for(int j = 0; j<10;j++) {
				if (moleGrid[i][j]=='M') {
					userGrid.moleGrid[i][j]='*';
				}
				else if (moleGrid[i][j]=='W') {
					userGrid.moleGrid[i][j]='W';
				}
			}
		}
		int r = 10;
		int c = 10;
		for(int i = 0; i<r; i++)
		{
		    for(int j = 0; j<c; j++)
		    {
		        System.out.print(userGrid.moleGrid[i][j]);
		    }
		    System.out.println();
		}
		
	}//shows a grid of W and *
	
	void printGrid() {
		//prints M,W and *
		int rows = 10;
		int columns = 10;
		for(int i = 0; i<rows; i++)
		{
		    for(int j = 0; j<columns; j++)
		    {
		        System.out.print(moleGrid[i][j]);
		    }
		    System.out.println();
		}
	}
	public static void main(String[] args) {
		WhackAMole myMoles = new WhackAMole(50,10);
		int count = 10;
			while (count>0) {
				int x = (int)(Math.random() * (10));
				int y = (int)(Math.random() * (10));
				myMoles.place(x,y);
				count--;
				}
		while (myMoles.attemptsLeft>0 && myMoles.molesLeft>0) {

			Scanner scanner = new Scanner(System.in);
			System.out.println("You have "+ myMoles.attemptsLeft +
					" attempts left. Enter coordinates: ");
			int coX = scanner.nextInt();
			int coY = scanner.nextInt();
			
			//after inputs taken, check what inputs do
			if (coX==-1 && coY==-1) {
				System.out.println("Thank you for playing!");
				myMoles.attemptsLeft = 0;
				myMoles.printGrid();
				//print grid here
			}	
			else if (coX>9 || coY>9) {
				System.out.println("Error!Value out of bounds");
			}
			else {
			myMoles.whack(coX,coY);
			myMoles.printGridToUser();
			//print grid to user here
			}
		}

		if (myMoles.molesLeft>0 && myMoles.attemptsLeft==0) {
			System.out.println("Your Score is: " + myMoles.score);
			System.out.println("Game over");
		}
		else if (myMoles.molesLeft==0) {
			System.out.println("Your Score is: " + myMoles.score);
			System.out.println("You won!!");
		}
}
}

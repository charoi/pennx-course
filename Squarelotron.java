
public class Squarelotron {

	int size;
	int[][] squarelotron;
	//constructor
	Squarelotron(int n){
		this.size = n;
		int val = 1;
		this.squarelotron= new int[n][n];
		if (n<=8) {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				squarelotron[i][j] = val;
				val= val + 1;
			} // creates the original matrix
		}
		}
		else {
			System.out.println("Error! matrix size too large");
		}
	}
	//methods
	Squarelotron upsideDownFlip(int ring) {
		//i,j becomes length-i,j
		ring = size;
		int temp;
		Squarelotron upsideDown = new Squarelotron(ring);
		for(int i = 0; i<ring; i++) {
			for(int j = 0; j<ring; j++) {
				temp = upsideDown.squarelotron[squarelotron.length-i-1][j];
				upsideDown.squarelotron[squarelotron.length-i-1][j] 
						= upsideDown.squarelotron[i][j];
				upsideDown.squarelotron[i][j] = temp;
			}
		}
		return upsideDown;

	}
	Squarelotron mainDiagonalFlip(int ring) {
		ring = size;
		int temp;
		Squarelotron diagonalFlip = new Squarelotron(ring);
		for(int i = 0; i<ring; i++) {
			for(int j = 0; j<ring; j++) {
				temp = diagonalFlip.squarelotron[i][j];
				diagonalFlip.squarelotron[i][j] = diagonalFlip.squarelotron[j][i];
				diagonalFlip.squarelotron[j][i] = temp;
			} 
	}
		return diagonalFlip;
	}
	
	void rotateRight(int numberOfTurns) {
		//a clockwise turn is just an upside down flip, and later a diagonal flip
		int temp;
		while (numberOfTurns>0) {
	//flip upside down first
			for(int i = 0; i<size; i++) {
				for(int j = 0; j<size; j++) {
					temp = squarelotron[squarelotron.length-i-1][j];
					squarelotron[squarelotron.length-i-1][j] 
							= squarelotron[i][j];
					squarelotron[i][j] = temp;
				}
			} //flip diagonally
			for(int i = 0; i<size; i++) {
				for(int j = 0; j<size; j++) {
					temp = squarelotron[i][j];
					squarelotron[i][j] = squarelotron[j][i];
					squarelotron[j][i] = temp;
				} 
			} 
			numberOfTurns--;
		}

		while (numberOfTurns<0) {
			//for clockwise, flip diagonally first, then flip upside down
			for(int i = 0; i<size; i++) {
				for(int j = 0; j<size; j++) {
					temp = squarelotron[i][j];
					squarelotron[i][j] = squarelotron[j][i];
					squarelotron[j][i] = temp;
				} 
			} //diagonal flip
			for(int i = 0; i<size; i++) {
				for(int j = 0; j<size; j++) {
					temp = squarelotron[squarelotron.length-i-1][j];
					squarelotron[squarelotron.length-i-1][j] 
							= squarelotron[i][j];
					squarelotron[i][j] = temp;
				}
			} //upside down
			numberOfTurns++;
		}
	}
}

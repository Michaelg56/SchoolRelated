public class NumberProcessor {
	public static int getSize(int input) {
		int num = input;
		int i = 0;
		while (num != 0) { // This while loop takes in the value num and divides it by 10 until the value is a single
			num /= 10;	   // digit and increments i in order to get the size of num
			++i;
		}
		return i;
	}

	public static int getNumber(int input) {
		int prePrime = input;
		int Num = prePrime;
		int i = getSize(Num);
		int singleVal;
		int[] tempList = new int[i];
		for (int j = 0; j < tempList.length; ++j) { //This works similarly to the getSize function except it takes each
			tempList[j] = Num;						//value and adds it to the array tempList
			Num /= 10;
		}
		singleVal = tempList[i - 1];
		return singleVal;
	}

	public static int ReduceValue(int input) {
		int Value = input;
		int myVal = getNumber(Value);
		if (getNumber(Value) != 0) {
			int i = getSize(Value) - 1;
			for (int j = 0; j < i; ++j) { //This for loop takes in the size minus 1 of the Value and multiplies the
				myVal *= 10;			  //first digit of Value by ten until it is the size of it in Value
			}
		}
		return Value - myVal;
	}

	public static int mirrorNumber(int input) {
		int preMirror = input;
		int Mirror = 0;
		int num = 0;
		int i = getSize(preMirror);
		if (i == 1) {
			Mirror = preMirror;                         //This is if the value is only one digit
			return Mirror;
		}
		int k = 0;
		int[] listofValues = new int[i];
		int[] ValuesMirrored = new int[i];
		for (int j = 0; j < listofValues.length; ++j) { //this for loops increments through the list of Values
			listofValues[j] = getNumber(preMirror);     //takes the single digit value and assigns them into the array
			if (j != i - 2) {
				preMirror = ReduceValue(preMirror);     //this ensures there is no error when attempting to reduce the
			}											//value
		}
		listofValues[i - 1] = preMirror;
		for (int j = i - 1; j >= 0; --j) {             //this moves through the array listofValues starting at the end
			ValuesMirrored[k] = listofValues[j];       //and assigns them to the new array ValuesMirrored
			++k;
		}
		i -= 1;
		for (int j = 0; j < ValuesMirrored.length; ++j) {
			int l = i;
			num = ValuesMirrored[j];
			while (l > 0) {                           //this for loop moves through the array Values Mirrored and
				num *= 10;							  //multilpies them by their respected values in order to keep
				--l;								  //the same size value
			}
			Mirror += num;
			--i;
		}
		return Mirror;
	}

	public static int stripOdds(int input) {
		int preStrip = input;
		int postStrip = 0;
		int tempVal = 15;
		int i = getSize(preStrip);
		int k = 0;
		int l = 0;
		int[] listofValues = new int[i];
		for (int j = 0; j < listofValues.length; ++j) { //this for loop appends the array listofValues with the single
			listofValues[j] = getNumber(preStrip);		//digit values of preStrip
			if (j != i - 2) {
				preStrip = ReduceValue(preStrip);		//this ensures no errors when attempting to reduce the Value
			}
			if (i > 1) {
				listofValues[i - 1] = preStrip;			//this ensures no errors when appending the Values to the array
			}
		}
		for (int j = 0; j < listofValues.length; ++j) {
			if (listofValues[j] % 2 == 0) {   			//this takes the ammount of values that are not odd
				++k;
			}
			else {
				continue;
			}
		}
		int[] valuesWithoutOdds = new int[k];
		for (int j = 0; j < valuesWithoutOdds.length; ++j) {
			for (int p = l; l < listofValues.length; ++l) {
				if (listofValues[l] % 2 == 0) {
					break;
				}
				else {
					continue;
				}
			}
			if (listofValues[l] != tempVal) {   	   //this makes sure that we are not appending the same values
				valuesWithoutOdds[j] = listofValues[l];
				tempVal = valuesWithoutOdds[j];
			}
		}
		for (int j = 0; j < valuesWithoutOdds.length; ++j) {
			tempVal = valuesWithoutOdds[j];
			int p = 0;
			--k;
			while (p < k) {							  //this multiplies the value by its respective value in order
				tempVal *= 10; 						  //to keep the correct length of the value
				++p;
			}
			postStrip += tempVal;
		}
		return postStrip;
	}

	public static boolean hasHiddenPrime(long input) {
		int Num = (int)input;
		int i = getSize(Num);
		int singleVal;
		int[] tempList = new int[i];
		for (int j = 0; j < tempList.length; ++j) { //this for loop takes in the values and divides it by ten in order
			tempList[j] = Num;						//to get each combination of the Num in the list
			Num /= 10;
		}
		for (int j = 1; j < tempList.length; ++j) {
			for (int k = 2; k < tempList[0]; ++k) { //this increments through every possible value between 2 and the
				if (tempList[j]% k == 0) {			//inputted value
					if (tempList[j] == k) {			//this checks if the value is equal to the number divided by it
						return true;
					}
					else{
						return false;
					}
				}
				else{
					continue;
				}
			}
		}
		return false;
	}

	public static boolean checkCozy(int input1, int input2) {
		int Num = input1;
		int cozyNum = input2;
		int i = getSize(Num);
		int[] tempList = new int[i];
		for (int j = 0; j < tempList.length; ++j) { //this for loop takes in each value for the array and then divides
			tempList[j] = Num;						//it by ten
			Num /= 10;
		}
		for (int j = 0; j < i; ++j) {
			if (tempList[j] == cozyNum) {			//this checks the values to see if any of them are the cozy number
				return true;
			}
			else {
				continue;
			}
		}
		return false;
	}

	public static boolean isCozyNumber(int input1, int input2) {
		int Num = input1;
		int cozyNum = input2;
		int tempVal;
		boolean check;
		while (Num != 0) {
			check = checkCozy(Num, cozyNum);
			if (check == true) {
				return true;
			}
			else {
				Num = ReduceValue(Num);
			}
		}
		return false;

	}

	public static boolean isNumberJackWinner(int[] array){
		int[] hand = new int[3];
		hand = array;
		int total = 0;
		for (int i = 0; i < 3; ++i) {
			if ((hand[i] < 11) && (hand[i] > 0)) { //this ensures that the values of each card are acceptable
				total += hand[i];				   //then adds them together
			}
			else {
				return false;
			}
		}
		if (total < 22 && total > 16) {			   //this checks to see if the inputted values win
			return true;
		}
		else {
			return false;
		}
	}

	public static int[][] array2matrix(int[] array){
		int[] list = array;
		list = array;
		int k = 2;
		int[][] matrix = new int[list[0]][list[1]]; 		//this creates the list in accordance to the values given
		for (int i = 0; i < matrix.length; ++i) {			//these for loops increment through the remaining values
			for (int j = 0; j < matrix[i].length; ++j) {	//and puts them in the array matrix
				for (int l = k; k < list.length;) {
				matrix[i][j] = list[k];
				++k;
				break;
				}
			}
		}
		return matrix;
	}

	 public static void shootBattleCraft(int[][] battleMap, int[][] shotCoordinates) {
		int[][] mapCoordinates = battleMap;
		int[][] shotTaken = shotCoordinates;
		int coordinateX = 0;
		int coordinateY = 0;
		for (int i = 0; i < shotTaken.length; ++i) {
			for (int j = 0; j < shotTaken[i].length; ++j) {
				if (j == 0) {
					coordinateX = shotTaken[i][j]; 				//this assigns the first value in the array with the X
				}												//coordinate
				else {
					coordinateY = shotTaken[i][j];				//this assigns the second value in the arrau with the Y
					}											//coordinate
			}
			if (mapCoordinates[coordinateX][coordinateY] > 0) { //if the shot taken is valid then the ship is destroyed
				mapCoordinates[coordinateX][coordinateY] = -1;  //and is reassigned with the value -1
			}
			else {
				continue;
			}
		}
	}
}
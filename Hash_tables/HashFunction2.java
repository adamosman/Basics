import java.util.Arrays;

public class HashFunction2 {

    String[] theArray;
    int arraySize;
    int itemsInArray = 0;

    public static void main(String[] args){

        HashFunction2 theFunc = new HashFunction2(30);
        // String[] elementsToAdd = {"1", "5", "16", "22", "27"};
        // theFunc.hashFunction1(elementsToAdd, theFunc.theArray);

        String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",
				"235", "802", "900", "723", "699", "1", "16", "999", "890",
				"725", "998", "978", "988", "990", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624" };
        theFunc.hashFunction2(elementsToAdd2, theFunc.theArray);
        theFunc.findKey("660");
        theFunc.displayTheHashTable();

    }
    // Hash function that puts values in the index equal to the value
    public void hashFunction1(String[] stringsForArray, String[] theArray){

        for(int n=0; n < stringsForArray.length; n++){
            String newElementVal = stringsForArray[n];
            // Storing the value in the index
            theArray[Integer.parseInt(newElementVal)] = newElementVal;
        }

    }
    // Takes the modulus of value in array v.s. size of array to assign address
    public void hashFunction2(String[] stringsForArray, String[] theArray){
        
        for(int n=0; n < stringsForArray.length; n++){
            String newElementVal = stringsForArray[n];
            int arrayIndex = Integer.parseInt(newElementVal) % 29;
            System.out.println("Modulus Index= " + arrayIndex + " for value " + newElementVal);

            while(theArray[arrayIndex] != "-1"){
                ++arrayIndex;
                System.out.println("Collision Try " + arrayIndex + " instead");
                arrayIndex %= arraySize;
            }
            theArray[arrayIndex] = newElementVal;
        }
    
    }

    public String findKey(String key){

        int arrayIndexHash = Integer.parseInt(key) % 29;
        while(theArray[arrayIndexHash] != "-1"){
            if(theArray[arrayIndexHash] == key){
                System.out.println(key + " was fond in Index " + arrayIndexHash);
                return theArray[arrayIndexHash];
            }
            ++arrayIndexHash; // look at next index
            arrayIndexHash %= arraySize; // once it reaches the end, go back to zero index
        }
        return null;
    }
    // Constructor
    HashFunction2(int size){

        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, "-1");
    }

    // Displays the hash table in terminal
    public void displayTheHashTable() {

		int increment = 0;
		for (int m = 0; m < 3; m++) {
            increment += 10;
            
			for (int n = 0; n < 71; n++)
                System.out.print("-");
            System.out.println();
            
			for (int n = increment - 10; n < increment; n++) {
				System.out.format("| %3s " + " ", n);
			}
            System.out.println("|");
            
			for (int n = 0; n < 71; n++)
				System.out.print("-");
			System.out.println();

			for (int n = increment - 10; n < increment; n++) {
				if (theArray[n].equals("-1"))
					System.out.print("|      ");
				else
					System.out
							.print(String.format("| %3s " + " ", theArray[n]));

			}

			System.out.println("|");
			for (int n = 0; n < 71; n++)
				System.out.print("-");
			System.out.println();

		}
	}
}
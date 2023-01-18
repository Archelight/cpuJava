package project2;
import project1.Bit;
//Nikita Romanovsky, ICSI404
public class Longword {

	private Bit[] bitStorage;
	
	public Longword() throws Exception {
		this.bitStorage = new Bit[32];
		for (int i = 0; i < bitStorage.length; i++) {
			Bit falseBit = new Bit(false); //turns all bits of the Longword off
			this.setBit(i, falseBit);
		}
	}
	
	public Longword(boolean value) throws Exception {
		this.bitStorage = new Bit[32];
		for (int i = 0; i < bitStorage.length; i++) {
			Bit valueBit = new Bit(value); //turns all bits of the Longword on/off depending on the value given
			this.setBit(i, valueBit);
		}
	}
	
	public Longword(int value) throws Exception {
		this.bitStorage = new Bit[32];
		this.set(value);
	}
	
	public Bit getBit(int i) {
		return bitStorage[i];
	}
	
	public void setBit(int i, Bit value) throws Exception {
		if(i > -1 && i < 32) {
			bitStorage[i] = value; //if the input index is in the 32 bit range, set that bit
		}
		else {
			throw new Exception("Longwords are 32 bits long"); 
		}
	}

	public Longword and(Longword other) throws Exception {
		Longword resultLongword = new Longword();
		for (int i = 0; i < bitStorage.length; i++) {
			resultLongword.setBit(i, this.getBit(i).and(other.getBit(i))); //iterates through this longword and performs and operation on each bit with the second longword as the input
		}
		return resultLongword;
	}
	
	public Longword or(Longword other) throws Exception {
		Longword resultLongword = new Longword();
		for (int i = 0; i < bitStorage.length; i++) {
			resultLongword.setBit(i, this.getBit(i).or(other.getBit(i))); //iterates through this longword and performs or operation on each bit with the second longword as the input
		}
		return resultLongword;
	}
	
	public Longword xor(Longword other) throws Exception {
		Longword resultLongword = new Longword();
		for (int i = 0; i < bitStorage.length; i++) {
			resultLongword.setBit(i, this.getBit(i).xor(other.getBit(i))); //iterates through this longword and performs xor operation on each bit with the second longword as the input
		}
		return resultLongword; 
	}
	
	public Longword not() throws Exception {
		Longword resultLongword = new Longword();
		for (int i = 0; i < bitStorage.length; i++) {
			resultLongword.setBit(i, this.getBit(i).not()); //iterates through this longword and performs not operation on each bit, reversing it
		}
		return resultLongword;
	}
	
	public Longword rightShift(int amount) throws Exception {
		int endingIndex = 0;
		if(amount >= 0) {
			Longword resultLongword = new Longword();
			resultLongword.copy(this);
			for (int i = 0; i < amount; i++) { 
				for (int j = bitStorage.length - 1 ; j > 0 + endingIndex ; j--) { //starting from the 32nd bit, sets each bit equal to the bit behind it
					resultLongword.setBit(j, this.bitStorage[j - 1 - endingIndex]); //since this longword does not change as the loop continues, an endingIndex value is needed to skip over the bits that were already moved with the last iteration of the loop
				}
				Bit falseBit = new Bit(false);
				resultLongword.setBit(endingIndex, falseBit); //the first bit of the longword needs to be set to false manually, as there are no other bits behind it
				endingIndex++; //the endingIndex needs to be increased to set the next bit to false during the next iteration of the loop.
			}
			return resultLongword;
		}
		else {
			throw new Exception("Amount to shift cant be negative");  
		}
	}
	
	public Longword leftShift(int amount) throws Exception {
		int endingIndex = 0;
		if(amount >= 0) {
			Longword resultLongword = new Longword();
			resultLongword.copy(this);
			for (int i = 0; i < amount; i++) {
				for (int j = 0 ; j < 31 - endingIndex ; j++) {
					resultLongword.setBit(j, this.bitStorage[j + 1 + endingIndex]); //starting from the 0th bit, sets each bit to the bit behind it, keeping track of the bit that needs to be moved using the "endingIndex" variable
				}
				Bit falseBit = new Bit(false);
				resultLongword.setBit(bitStorage.length - 1 - endingIndex, falseBit); //the last bit of the new longword needs to be set to false and this index needs to be decreased by 1 for the next loop iteration
				endingIndex++; //the endingIndex needs to be increased for the next iteration of the loop.
			}
			return resultLongword;
		}
		else {
			throw new Exception("Amount to shift cant be negative");  
		}
	}
	
	public void takeTwosComplement() throws Exception {
		this.bitStorage = this.not().bitStorage;
		int count = this.bitStorage.length - 1;
		while(this.getBit(count).getValue() != false && count > 0) {
			Bit falseBit = new Bit(false); //Performs the twos complement algorithm by reversing the longword and adding 1
			this.setBit(count, falseBit); // adds 1 by setting each bit to false until a bit that is turned off is found. Then turns that bit on
			count--;
		}
		Bit trueBit = new Bit(true);
		this.setBit(count, trueBit); //sets the first turned off bit that was found to true
	}

	@Override
	public String toString() {
		StringBuilder longwordString = new StringBuilder();
		for (int i = 0; i < bitStorage.length; i++) {
			longwordString.append(this.bitStorage[i].toString());
			if(i < 31) { //iterates through the longword and performs the toString operation on each bit, then appends it to a string
				longwordString.append(",");
			}
		}
		return longwordString.toString();
	}
	
	public long getUnsigned() {
		long count = 1;
		long sum = 0;
		for (int i = bitStorage.length - 1; i > -1; i--) {
			if(this.getBit(i).getValue() == true) {
				sum = sum + 1 * count; //performs the algorithm to convert a binary number to decimal
			} //keeps track of a sum that is then added to a multiple of 2 in each iteration, as binary numbers are all powers of 2 starting with 2^0 and 2^1
			count = count * 2;
		}
		return sum;
	}
	
	public int getSigned() throws Exception {
		Longword copied = new Longword();
		copied.copy(this);
		int sum = 0;
		if(this.getBit(0).getValue() == false) {
			sum = (int) this.getUnsigned(); //if the first bit the longword is 0, treat it as an unsigned binary number
		}
		else {
			copied.bitStorage = copied.not().bitStorage;
			int count = copied.bitStorage.length - 1;
			while(copied.getBit(count).getValue() != false && count > 0) {
				Bit falseBit = new Bit(false); //Performs the twos complement algorithm by reversing the longword and adding 1
				copied.setBit(count, falseBit); // adds 1 by setting each bit to false until a bit that is turned off is found. Then turns that bit on
				count--;
			}
			Bit trueBit = new Bit(true);
			copied.setBit(count, trueBit); //if the first bit of the longword is 1, take the twos complement to find its negative decimal value
			sum = (int) (copied.getUnsigned() * -1);
		}
		return sum;
	}
	
	public void copy(Longword other) throws Exception {
		for (int i = 0; i < bitStorage.length; i++) {
			Bit copiedValue = new Bit(other.getBit(i).getValue());
			this.setBit(i, copiedValue); //iterates through the longwords and copies each bit over
		}
	}
	
	public void set(int value) throws Exception {
		int i = bitStorage.length - 1;
		int result = value;
		if(value < 0) { //if the value is negative, make it positive
			result = result * -1;
		}
		while(result > 0) {
			if(result % 2 == 0) { //if the result of the division is 0, set the bit i of the longword to false
				Bit falseBit = new Bit(false);			
				this.setBit(i, falseBit);
				result = result / 2; //Performs the algorithm used to convert a decimal number to a binary number
				i--; //keeps track of a total sum that is divided each loop iteration.
			}
			else if(result % 2 == 1 || result % 2 == -1){ //if the result of the division is 1 or -1, set the bit i of the longword to true
				Bit trueBit = new Bit(true);
				this.setBit(i, trueBit);
				result = result / 2;
				i--;
			}
		}
		for (int j = i; j >= 0; j--) {
			Bit falseBit = new Bit(false); //once the sum is less than 1, set all of the remaining bits to false, as a longword must have 32 bits
			this.setBit(j, falseBit);
		}
		if(value < 0) { //if the value was originally negative, take its twos complement to make its binary representation negative
			this.takeTwosComplement();
		}
	}
	
	public static Longword stringToLongword(String value) throws Exception {
		value = value.replaceAll("\\s", "");
		Longword newLongword = new Longword();
		for(int i = 0 ; i < value.length(); i++) {
			if(Character.getNumericValue(value.charAt(i)) == 0)
				newLongword.setBit(i, new Bit(false));
			else
				newLongword.setBit(i, new Bit(true));
		}
		if(value.length() < 32) {
			for(int i = value.length() ; i < 32; i++) { //if the string is is not 32 characters, fill the rest in with zeros
				newLongword.setBit(i, new Bit(false)); 
			}
		}
		return newLongword;
	}	
	
	public boolean equals(Longword secondLongword) {
		for(int i = 0 ; i < 32; i++) {
			if(this.getBit(i).getValue() != secondLongword.getBit(i).getValue())
				return false;
		}
		return true;
	}
}

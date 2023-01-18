package project3;
import project1.Bit;
import project2.Longword;
//Nikita Romanovsky, ICSI404
public class RippleAdder {
	

	public static Longword add(Longword firstLongword, Longword secondLongword) throws Exception {
		Longword result = new Longword();
		Bit carry = new Bit(false);
		for (int i = 31; i > -1; i--) { //begin at the end of the Longword, as that is the beginning of a binary number
			result.setBit( i, (firstLongword.getBit(i).xor(secondLongword.getBit(i)).xor(carry)));
			//adds each row of bits, keeping track of the carry input and carry output. The carry input is added to i'th bit of both Longwords, calculating the i'th bit of the resulting Longword
			carry.set(firstLongword.getBit(i).and(secondLongword.getBit(i)).or(carry.and(firstLongword.getBit(i).or(secondLongword.getBit(i)))).getValue());
			//the carry output is calculated and becomes the carry input of the next loop iteration
		}
		return result;
	}
	
	public static Longword subtract(Longword firstLongword, Longword secondLongword) throws Exception {
		if(secondLongword.getSigned() == 0) {
			return RippleAdder.add(firstLongword, secondLongword); 
		}
		secondLongword.takeTwosComplement(); //since the second Longword needs to be subtracted, take its twos complement in order to make the Longword negative
		return RippleAdder.add(firstLongword, secondLongword); //add the first and second Longwords together, since subtraction is the same as adding a negative and positive values.
	}

}

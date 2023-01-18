package project4;
import project2.Longword;
import project3.RippleAdder;
//Nikita Romanovsky, ICSI404
public class Multiplier {
	
	
	public static Longword multiply (Longword firstLongword, Longword secondLongword) throws Exception {
		//takes twos complement of both longwords if both of them are negative
		if(firstLongword.getBit(0).getValue() == true && secondLongword.getBit(0).getValue() == true ) { 
			firstLongword.takeTwosComplement(); secondLongword.takeTwosComplement();
		}
		Longword product = new Longword();
		//iterates through the firstLongword until an "on" bit is found, left shifts the secondLongword by 31 - i to represent the exponent 2^(31- i), and then adds the shifted longword to a total
		for (int i = 31; i > -1; i--) {
			if(firstLongword.getBit(i).getValue() == true) {
				product = RippleAdder.add(product, secondLongword.leftShift(31 - i));
			}
		}
		return product;
	}
}

package project4;
import project1.Bit;
import project2.Longword;
import project3.RippleAdder;
//Nikita Romanovsky, ICSI404
public class ALU {

	public static Longword doOp(Bit firstBit, Bit secondBit, Bit thirdBit, Bit fourthBit, Longword firstLongword, Longword secondLongword) throws Exception {
		Longword result = new Longword(); //checks the four input bits to determine the operation, then performs the operation
		if(firstBit.getValue() == true && secondBit.getValue() == false && thirdBit.getValue() == false && fourthBit.getValue() == false)
			result = firstLongword.and(secondLongword);
		else if(firstBit.getValue() == true && secondBit.getValue() == false && thirdBit.getValue() == false && fourthBit.getValue() == true)
			result = firstLongword.or(secondLongword);
		else if(firstBit.getValue() == true && secondBit.getValue() == false && thirdBit.getValue() == true && fourthBit.getValue() == false) 
			result = firstLongword.xor(secondLongword);
		else if(firstBit.getValue() == true && secondBit.getValue() == false && thirdBit.getValue() == true && fourthBit.getValue() == true) 
			result = firstLongword.not();
		else if(firstBit.getValue() == true && secondBit.getValue() == true && thirdBit.getValue() == false && fourthBit.getValue() == false) {
			if(secondLongword.getSigned() < 32) //left shifts the firstLongword by the value of the first 5 bits of secondLongword
				result = firstLongword.leftShift(secondLongword.getSigned());
			else
				throw new Exception("Amount to shift cant be larger than 31"); 
		}
		else if(firstBit.getValue() == true && secondBit.getValue() == true && thirdBit.getValue() == false && fourthBit.getValue() == true) {
			if(secondLongword.getSigned() < 32)  //right shifts the firstLongword by the value of the first 5 bits of secondLongword
				result = firstLongword.rightShift(secondLongword.getSigned());
			else
				throw new Exception("Amount to shift cant be larger than 31");
		}	
		else if(firstBit.getValue() == true && secondBit.getValue() == true && thirdBit.getValue() == true && fourthBit.getValue() == false)
			result = RippleAdder.add(firstLongword, secondLongword);
		else if(firstBit.getValue() == true && secondBit.getValue() == true && thirdBit.getValue() == true && fourthBit.getValue() == true) 
			result = RippleAdder.subtract(firstLongword, secondLongword);
		else if(firstBit.getValue() == false && secondBit.getValue() == true && thirdBit.getValue() == true && fourthBit.getValue() == true)
			result = Multiplier.multiply(firstLongword, secondLongword);
		return result;
	}
}

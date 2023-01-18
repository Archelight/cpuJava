package project4Test;
import project1.Bit;
import project2.Longword;
import project4.ALU;
//Nikita Romanovsky, ICSI404
public class ALU_test {

	public static void main(String[] args) throws Exception {
		runAllTests();
	}

	public static void runAllTests() throws Exception {
		testDoOp();
	}
	
	private static void testDoOp() throws Exception {
		if(ALU.doOp(new Bit(true), new Bit(false), new Bit(false), new Bit(false), new Longword(5), new Longword(7)).getSigned() == 5)
			System.out.println("Testing operation and(), Input: (Longword(5)), Longword(7)), Output: 5, Expected output: 5");
		else
			System.out.println("Testing operation and(), Input: (Longword(5), Longword(7)), Output: Wrong Output, Expected output: 5");
		if(ALU.doOp(new Bit(true), new Bit(false), new Bit(false), new Bit(true), new Longword(5), new Longword(7)).getSigned() == 7)
			System.out.println("Testing operation or(), Input: (Longword(5)), Longword(7)), Output: 7, Expected output: 7");
		else
			System.out.println("Testing operation or(), Input: (Longword(5), Longword(7)), Output: Wrong Output, Expected output: 7");
		if(ALU.doOp(new Bit(true), new Bit(false), new Bit(true), new Bit(false), new Longword(5), new Longword(7)).getSigned() == 2)
			System.out.println("Testing operation xor(), Input: (Longword(5)), Longword(7)), Output: 2, Expected output: 2");
		else
			System.out.println("Testing operation xor(), Input: (Longword(5), Longword(7)), Output: Wrong Output, Expected output: 2");
		if(ALU.doOp(new Bit(true), new Bit(false), new Bit(true), new Bit(true), new Longword(2147483647), new Longword(7)).getSigned() == -2147483648)
			System.out.println("Testing operation not(), Input: (Longword(2147483647)), Longword(7)), Output: -2147483648, Expected output: -2147483648");
		else
			System.out.println("Testing operation not(), Input: (Longword(2147483647), Longword(7)), Output: Wrong Output, Expected output: -2147483648");
		if(ALU.doOp(new Bit(true), new Bit(true), new Bit(false), new Bit(false), new Longword(2), new Longword(2)).getSigned() == 8)
			System.out.println("Testing operation leftShift(), Input: (Longword(2)), Longword(2)), Output: 8, Expected output: 8");
		else
			System.out.println("Testing operation leftShift(), Input: (Longword(2), Longword(2)), Output: Wrong Output, Expected output: 8");
		if(ALU.doOp(new Bit(true), new Bit(true), new Bit(false), new Bit(true), new Longword(4), new Longword(2)).getSigned() == 1)
			System.out.println("Testing operation rightShift(), Input: (Longword(4)), Longword(2)), Output: 1, Expected output: 1");
		else
			System.out.println("Testing operation rightShift(), Input: (Longword(4), Longword(2)), Output: Wrong Output, Expected output: 1");
		if(ALU.doOp(new Bit(true), new Bit(true), new Bit(true), new Bit(false), new Longword(4), new Longword(2)).getSigned() == 6)
			System.out.println("Testing operation add(), Input: (Longword(4)), Longword(2)), Output: 6, Expected output: 6");
		else
			System.out.println("Testing operation add(), Input: (Longword(4), Longword(2)), Output: Wrong Output, Expected output: 6");
		if(ALU.doOp(new Bit(true), new Bit(true), new Bit(true), new Bit(true), new Longword(4), new Longword(2)).getSigned() == 2)
			System.out.println("Testing operation subtract(), Input: (Longword(4)), Longword(2)), Output: 2, Expected output: 2");
		else
			System.out.println("Testing operation subtract(), Input: (Longword(4), Longword(2)), Output: Wrong Output, Expected output: 2");
		if(ALU.doOp(new Bit(false), new Bit(true), new Bit(true), new Bit(true), new Longword(4), new Longword(2)).getSigned() == 8)
			System.out.println("Testing operation multiply(), Input: (Longword(4)), Longword(2)), Output: 8, Expected output: 8");
		else
			System.out.println("Testing operation multiply(), Input: (Longword(4), Longword(2)), Output: Wrong Output, Expected output: 8");
		System.out.println();
	}
	
}

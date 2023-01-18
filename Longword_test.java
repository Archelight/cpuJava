package project2Test;
import project1.Bit;
import project2.Longword;
//Nikita Romanovsky, ICSI404
public class Longword_test {
	
	public static void main(String[] args) throws Exception {
		runAllTests();
	}

	public static void runAllTests() throws Exception {
		testGetBit();
		testSetBit();
		testAnd();
		testOr();
		testXor();
		testNot();
		testRightShift();
		testLeftShift();
		testTakeTwosComplement();
		testGetUnsigned();
		testGetSigned();
		testCopy();
		testSet();
		testToString();
	}
	
	private static void testGetBit() throws Exception {
		Longword testLongword = new Longword();
		if(testLongword.getBit(0).getValue() != false)
			System.out.println("Testing method getBit(i), Input: (0), Output: true, Expected output: false");
		else
			System.out.println("Testing method getBit(i), Input: (0), Output: false, Expected output: false");
		testLongword = new Longword(); Bit trueBit = new Bit(true); testLongword.setBit(0, trueBit);
		if(testLongword.getBit(0).getValue() != true)
			System.out.println("Testing method getBit(i), Input: (0), Output: false, Expected output: true");
		else
			System.out.println("Testing method getBit(i), Input: (0), Output: true, Expected output: true");
		System.out.println();
	}
	
	private static void testSetBit() throws Exception {
		Longword testLongword = new Longword(); Bit falseBit = new Bit(false); testLongword.setBit(0, falseBit);
		if(testLongword.getBit(0).getValue() != false)
			System.out.println("Testing method setBit(i), Input: (0, falseBit), Output: true, Expected output: false");
		else
			System.out.println("Testing method setBit(i), Input: (0, falseBit), Output: false, Expected output: false");
		testLongword = new Longword(); Bit trueBit = new Bit(true); testLongword.setBit(0, trueBit);
		if(testLongword.getBit(0).getValue() != true)
			System.out.println("Testing method setBit(i), Input: (0, trueBit), Output: false, Expected output: true");
		else
			System.out.println("Testing method setBit(i), Input: (0, trueBit), Output: true, Expected output: true");
		System.out.println();
	}
	
	private static void testAnd() throws Exception {
		if (new Longword(false).and(new Longword(false)).toString().equals("t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t"))
			System.out.println("Testing method and(), Input: (Longword(false), Longword(false)), Output: all bits true, Expected output: all bits false");
		else
			System.out.println("Testing method and(), Input: (Longword(false), Longword(false)), Output: all bits false, Expected output: all bits false");
		if (new Longword(true).and(new Longword(false)).toString().equals("t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t"))
			System.out.println("Testing method and(), Input: (Longword(false), Longword(true)), Output: all bits true, Expected output: all bits false");
		else
			System.out.println("Testing method and(), Input: (Longword(false), Longword(true)), Output: all bits false, Expected output: all bits false");
		if (new Longword(false).and(new Longword(true)).toString().equals("t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t"))
			System.out.println("Testing method and(), Input: (Longword(true), Longword(false)), Output: all bits true, Expected output: all bits false");
		else
			System.out.println("Testing method and(), Input: (Longword(true), Longword(false)), Output: all bits false, Expected output: all bit false");
		if (new Longword(true).and(new Longword(true)).toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f"))
			System.out.println("Testing method and(), Input: (Longword(true), Longword(true)), Output: all bits false, Expected output: all bits true");
		else
			System.out.println("Testing method and(), Input: (Longword(true), Longword(true)), Output: all bits true, Expected output: all bits true");
		System.out.println();
	}
	
	private static void testOr() throws Exception {
		if (new Longword(false).or(new Longword(false)).toString().equals("t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t"))
			System.out.println("Testing method or(), Input: (Longword(false), Longword(false)), Output: all bits true, Expected output: all bits false");
		else
			System.out.println("Testing method or(), Input: (Longword(false), Longword(false)), Output: all bits false, Expected output: all bits false");
		if (new Longword(true).or(new Longword(false)).toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f"))
			System.out.println("Testing method or(), Input: (Longword(false), Longword(true)), Output: all bits false, Expected output: all bits true");
		else
			System.out.println("Testing method or(), Input: (Longword(false), Longword(true)), Output: all bits true, Expected output: all bits true");
		if (new Longword(false).or(new Longword(true)).toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f"))
			System.out.println("Testing method or(), Input: (Longword(true), Longword(false)), Output: all bits false, Expected output: all bits true");
		else
			System.out.println("Testing method or(), Input: (Longword(true), Longword(false)), Output: all bits true, Expected output: all bit true");
		if (new Longword(true).or(new Longword(true)).toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f"))
			System.out.println("Testing method or(), Input: (Longword(true), Longword(true)), Output: all bits false, Expected output: all bits true");
		else
			System.out.println("Testing method or(), Input: (Longword(true), Longword(true)), Output: all bits true, Expected output: all bits true");
		System.out.println();
	}
	
	private static void testXor() throws Exception {
		if (new Longword(false).xor(new Longword(false)).toString().equals("t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t"))
			System.out.println("Testing method xor(), Input: (Longword(false), Longword(false)), Output: all bits true, Expected output: all bits false");
		else
			System.out.println("Testing method xor(), Input: (Longword(false), Longword(false)), Output: all bits false, Expected output: all bits false");
		if (new Longword(true).xor(new Longword(false)).toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f"))
			System.out.println("Testing method xor(), Input: (Longword(false), Longword(true)), Output: all bits false, Expected output: all bits true");
		else
			System.out.println("Testing method xor(), Input: (Longword(false), Longword(true)), Output: all bits true, Expected output: all bits true");
		if (new Longword(false).xor(new Longword(true)).toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f"))
			System.out.println("Testing method xor(), Input: (Longword(true), Longword(false)), Output: all bits false, Expected output: all bits true");
		else
			System.out.println("Testing method xor(), Input: (Longword(true), Longword(false)), Output: all bits true, Expected output: all bit true");
		if (new Longword(true).xor(new Longword(true)).toString().equals("t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t"))
			System.out.println("Testing method xor(), Input: (Longword(true), Longword(true)), Output: all bits true, Expected output: all bits false");
		else
			System.out.println("Testing method xor(), Input: (Longword(true), Longword(true)), Output: all bits false, Expected output: all bits false");
		System.out.println();
	}
	
	private static void testNot() throws Exception {
		if (new Longword(false).not().toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f"))
			System.out.println("Testing method not(), Input: (Longword(false)), Output: all bits false, Expected output: all bits true");
		else
			System.out.println("Testing method not(), Input: (Longword(false)), Output: all bits true, Expected output: all bits true");
		if (new Longword(true).not().toString().equals("t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t"))
			System.out.println("Testing method not(), Input: (Longword(true)), Output: all bits true, Expected output: all bits false");
		else
			System.out.println("Testing method not(), Input: (Longword(true)), Output: all bits false, Expected output: all bits false");
		System.out.println();
	}
	
	private static void testRightShift() throws Exception {
		Longword testLongword = new Longword();
		testLongword.set(20);
		if (testLongword.rightShift(2).toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,f,t"))
			System.out.println("Testing method rightShift(), Input: Longword.set(20), rightShift(2), Output: correct Longword");
		else
			System.out.println("Testing method rightShift(), Input: Longword.set(20), rightShift(2), Output: incorrect Longword");
		testLongword = new Longword();
		testLongword.set(-1);
		if (testLongword.rightShift(32).toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f"))
			System.out.println("Testing method rightShift(), Input: Longword.set(-1), rightShift(32), Output: correct Longword");
		else
			System.out.println("Testing method rightShift(), Input: Longword.set(-1), rightShift(32), Output: incorrect Longword"); 
		testLongword = new Longword();
		testLongword.set(-22322);
		if (testLongword.rightShift(5).toString().equals("f,f,f,f,f,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,f,t,f,t,f,f,f,t,t,f"))
			System.out.println("Testing method rightShift(), Input: Longword.set(-22322), rightShift(5), Output: correct Longword");
		else
			System.out.println("Testing method rightShift(), Input: Longword.set(-22322), rightShift(5), Output: incorrect Longword"); 
		testLongword = new Longword();
		testLongword.set(4);
		if (testLongword.rightShift(0).toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,f,f"))
			System.out.println("Testing method rightShift(), Input: Longword.set(4), rightShift(0), Output: correct Longword");
		else
			System.out.println("Testing method rightShift(), Input: Longword.set(4), rightShift(0), Output: incorrect Longword"); 
		testLongword = new Longword();
		testLongword.set(4);
		try {
			testLongword.rightShift(-1).toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,f,f");
		}catch(Exception e){
			System.out.println("Testing method rightShift(), Input: Longword.set(4), rightShift(-1) Output: Error, Cant shift by a negative number"); 
		}
		System.out.println();
	}
	
	private static void testLeftShift() throws Exception {
		Longword testLongword = new Longword();
		testLongword.set(20);
		if (testLongword.leftShift(2).toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,f,t,f,f,f,f"))
			System.out.println("Testing method leftShift(), Input: Longword.set(20), leftShift(2), Output: correct Longword");
		else
			System.out.println("Testing method leftShift(), Input: Longword.set(20), leftShift(2), Output: incorrect Longword");
		testLongword = new Longword();
		testLongword.set(-1);
		if (testLongword.leftShift(32).toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f"))
			System.out.println("Testing method leftShift(), Input: Longword.set(-1), leftShift(32), Output: correct Longword");
		else
			System.out.println("Testing method leftShift(), Input: Longword.set(-1), leftShift(32), Output: incorrect Longword"); 
		testLongword = new Longword();
		testLongword.set(-223222000);
		if (testLongword.leftShift(5).toString().equals("f,t,f,t,f,t,t,f,f,f,t,t,t,t,f,f,t,t,t,f,f,f,t,f,f,f,f,f,f,f,f,f"))
			System.out.println("Testing method leftShift(), Input: Longword.set(-22322), leftShift(5), Output: correct Longword");
		else
			System.out.println("Testing method leftShift(), Input: Longword.set(-22322), leftShift(5), Output: incorrect Longword"); 
		testLongword = new Longword();
		testLongword.set(4);
		if (testLongword.leftShift(0).toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,f,f"))
			System.out.println("Testing method leftShift(), Input: Longword.set(4), leftShift(0), Output: correct Longword");
		else
			System.out.println("Testing method leftShift(), Input: Longword.set(4), leftShift(0), Output: incorrect Longword"); 
		testLongword = new Longword();
		testLongword.set(4);
		try {
			testLongword.leftShift(-1).toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,f,f");
		}catch(Exception e){
			System.out.println("Testing method leftShift(), Input: Longword.set(4), leftShift(-1) Output: Error, Cant shift by a negative number"); 
		}
		System.out.println();
	}
	
	private static void testTakeTwosComplement() throws Exception {
		Longword testLongword = new Longword();
		testLongword.set(20);
		testLongword.takeTwosComplement();
		if (testLongword.toString().equals("t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,f,t,t,f,f"))
			System.out.println("Testing method takeTwosComplement(), Input: Longword.set(20), Output: correct Longword");
		else
			System.out.println("Testing method takeTwosComplement(), Input: Longword.set(20), Output: incorrect Longword");
		testLongword.set(2147483647);
		testLongword.takeTwosComplement();
		if (testLongword.toString().equals("t,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t"))
			System.out.println("Testing method takeTwosComplement(), Input: Longword.set(2147483647), Output: correct Longword");
		else
			System.out.println("Testing method takeTwosComplement(), Input: Longword.set(2147483647), Output: incorrect Longword");
		System.out.println();
	}
	
	private static void testGetUnsigned() throws Exception {
		Longword testLongword = new Longword();
		long testLong = 0;
		testLongword.set(20);
		testLong = testLongword.getUnsigned();
		if (testLong == 20)
			System.out.println("Testing method getUnsigned(), Input: Longword.set(20), Expected Output: 20, Output: 20");
		else
			System.out.println("Testing method getUnsigned(), Input: Longword.set(20), Expected Output: 20, Output: incorrect Long");
		testLongword = new Longword();
		testLongword.set(0);
		testLong = testLongword.getUnsigned();
		if (testLong == 0)
			System.out.println("Testing method getUnsigned(), Input: Longword.set(0), Expected Output: 0, Output: 0");
		else
			System.out.println("Testing method getUnsigned(), Input: Longword.set(0), Expected Output: 0, Output: incorrect Long");
		testLongword = new Longword();
		testLongword.set(21211221);
		testLong = testLongword.getUnsigned();
		if (testLong == 21211221)
			System.out.println("Testing method getUnsigned(), Input: Longword.set(21211221), Expected Output: 21211221, Output: 21211221");
		else
			System.out.println("Testing method getUnsigned(), Input: Longword.set(21211221), Expected Output: 21211221. Output: incorrect Long");
		System.out.println();
	}
	
	private static void testGetSigned() throws Exception {
		Longword testLongword = new Longword();
		int testInt = 0;
		testLongword.set(-20);
		testInt = testLongword.getSigned();
		if (testInt == -20)
			System.out.println("Testing method getSigned(), Input: Longword.set(-20), Expected Output: -20, Output: -20");
		else
			System.out.println("Testing method getSigned(), Input: Longword.set(-20), Expected Output: -20, Output: incorrect Long");
		testLongword = new Longword();
		testLongword.set(-2147483648);
		testInt = testLongword.getSigned();
		if (testInt == -2147483648)
			System.out.println("Testing method getSigned(), Input: Longword.set(-2147483648), Expected Output: -2147483648, Output: -2147483648");
		else
			System.out.println("Testing method getSigned(), Input: Longword.set(-2147483648), Expected Output: -2147483648, Output: incorrect Long");
		testLongword = new Longword();
		testLongword.set(2147483647);
		testInt = testLongword.getSigned();
		if (testInt == 2147483647)
			System.out.println("Testing method getSigned(), Input: Longword.set(2147483647), Expected Output: 2147483647, Output: 2147483647");
		else
			System.out.println("Testing method getSigned(), Input: Longword.set(2147483647), Expected Output: 2147483647, Output: incorrect Long");
		System.out.println();
	}
	
	private static void testCopy() throws Exception {
		Longword testLongword = new Longword();
		Longword secondTestLongword = new Longword();
		testLongword.set(20);
		secondTestLongword.copy(testLongword);
		if (secondTestLongword.toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,f,t,f,f"))
			System.out.println("Testing method copy(), Input: Longword.set(20), Output: correct Long");
		else
			System.out.println("Testing method copy(), Input: Longword.set(20), Output: incorrect Long");
		System.out.println();
	}
	
	private static void testSet() throws Exception {
		Longword testLongword = new Longword();
		testLongword.set(-20);
		if (testLongword.toString().equals("t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,f,t,t,f,f"))
			System.out.println("Testing method set(), Input: Longword.set(-20), Output: correct Long");
		else
			System.out.println("Testing method set(), Input: Longword.set(-20), Output: incorrect Long");
		testLongword = new Longword();
		testLongword.set(20);
		if (testLongword.toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,t,f,t,f,f"))
			System.out.println("Testing method set(), Input: Longword.set(20), Output: correct Long");
		else
			System.out.println("Testing method set(), Input: Longword.set(20), Output: incorrect Long");
		testLongword = new Longword();
		testLongword.set(0);
		if (testLongword.toString().equals("f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f"))
			System.out.println("Testing method set(), Input: Longword.set(0), Output: correct Long");
		else
			System.out.println("Testing method set(), Input: Longword.set(0), Output: inCorrect Long");
		System.out.println();
	}
	
	private static void testToString() throws Exception {
		Longword testLongword = new Longword(true);
		if (testLongword.toString().equals("t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t"))
			System.out.println("Testing method toString(), Input: Longword.set(true), Output: correct Long");
		else
			System.out.println("Testing method toString(), Input: Longword.set(true), Output: incorrect Long");
			
	}
}

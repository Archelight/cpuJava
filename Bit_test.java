package project1Test;
import project1.Bit;
//Nikita Romanovsky, ICSI404
//Testing class Bit
public class Bit_test {

	public static void main(String[] args) {
		runAllTests();
	}

	public static void runAllTests() {
		testGetValue();
		testSetInput();
		testToggle();
		testSet();
		testClear();
		testAnd();
		testOr();
		testXor();
		testNot();
		testToString();
	}
	
	private static void testSetInput() {
		Bit testingBit = new Bit(false); testingBit.set(false);
		if(testingBit.getValue() != false)
			System.out.println("Testing method set(input), Starting value: false, Input: (false), Output: true, Expected output: false");
		else
			System.out.println("Testing method set(input), Starting value: false, Input: (false), Output: false, Expected output: false");
		testingBit = new Bit(false); testingBit.set(true);
		if(testingBit.getValue() != true)
			System.out.println("Testing method set(input), Starting value: false, Input: (true), Output: false, Expected output: true");
		else
			System.out.println("Testing method set(input), Starting value: false, Input: (true), Output: true, Expected output: true");
		testingBit = new Bit(true); testingBit.set(false);
		if(testingBit.getValue() != false)
			System.out.println("Testing method set(input), Starting value: true, Input: (false), Output: true, Expected output: false");
		else
			System.out.println("Testing method set(input), Starting value: true, Input: (false), Output: false, Expected output: false");
		testingBit = new Bit(true); testingBit.set(true);
		if(testingBit.getValue() != true)
			System.out.println("Testing method set(input), Starting value: true, Input: (true), Output: false, Expected output: true");
		else
			System.out.println("Testing method set(input), Starting value: true, Input: (true), Output: true, Expected output: true");
		System.out.println();
		
	}
	
	public static void testToggle() {
		Bit testingBit = new Bit(false); testingBit.toggle();
		if(testingBit.getValue() != true)
			System.out.println("Testing method toggle(), Starting value: false, Output: false, Expected output: true");
		else
			System.out.println("Testing method toggle(), Starting value: false, Output: true, Expected output: true");
		testingBit = new Bit(true); testingBit.toggle();
		if(testingBit.getValue() != false)
			System.out.println("Testing method toggle(), Starting value: true, Output: true, Expected output: false");
		else
			System.out.println("Testing method toggle(), Starting value: true, Output: false, Expected output: false");
		System.out.println();
	}
	
	public static void testSet() {
		Bit testingBit = new Bit(false); testingBit.set();
		if(testingBit.getValue() != true)
			System.out.println("Testing method set(), Starting value: false, Output: false, Expected output: true");
		else
			System.out.println("Testing method set(), Starting value: false, Output: true, Expected output: true");
		testingBit = new Bit(true); testingBit.set();
		if(testingBit.getValue() != true)
			System.out.println("Testing method set(), Starting value: true, Output: false, Expected output: true");
		else
			System.out.println("Testing method set(), Starting value: true, Output: true, Expected output: true");
		System.out.println();
	}
	
	public static void testClear() {
		Bit testingBit = new Bit(false); testingBit.clear();
		if(testingBit.getValue() != false)
			System.out.println("Testing method clear(), Starting value: false, Output: true, Expected output: false");
		else
			System.out.println("Testing method clear(), Starting value: false, Output: false, Expected output: false");
		testingBit = new Bit(true); testingBit.clear();
		if(testingBit.getValue() != false)
			System.out.println("Testing method clear(), Starting value: true, Output: true, Expected output: false");
		else
			System.out.println("Testing method clear(), Starting value: true, Output: false, Expected output: false");
		System.out.println();
	}
	
	public static void testGetValue() {
		if (new Bit(false).getValue() != false)
			System.out.println("Testing method getValue(), Starting value: false, Output: true, Expected output: false");
		else
			System.out.println("Testing method getValue(), Starting value: false, Output: false, Expected output: false");
		if (new Bit(true).getValue() != true)
			System.out.println("Testing method getValue(), Starting value: true, Output: false, Expected output: true");
		else
			System.out.println("Testing method getValue(), Starting value: true, Output: true, Expected output: true");
		System.out.println();
	}

	public static void testAnd() {
		if (new Bit(false).and(new Bit(false)).getValue() != false)
			System.out.println("Testing method and(), Input: (false, false), Output: true, Expected output: false");
		else
			System.out.println("Testing method and(), Input: (false, false), Output: false, Expected output: false");
		if (new Bit(false).and(new Bit(true)).getValue() != false)
			System.out.println("Testing method and(), Input: (false, true), Output: true, Expected output: false");
		else
			System.out.println("Testing method and(), Input: (false, true), Output: false, Expected output: false");
		if (new Bit(true).and(new Bit(false)).getValue() != false)
			System.out.println("Testing method and(), Input: (true, false), Output: true, Expected output: false");
		else
			System.out.println("Testing method and(), Input: (true, false), Output: false, Expected output: false");
		if (new Bit(true).and(new Bit(true)).getValue() != true)
			System.out.println("Testing method and(), Input: (true, true), Output: false, Expected output: true");
		else
			System.out.println("Testing method and(), Input: (true, true), Output: true, Expected output: true");
		System.out.println();
	}
	
	public static void testOr() {
		if (new Bit(false).or(new Bit(false)).getValue() != false)
			System.out.println("Testing method or(), Input: (false, false), Output: true, Expected output: false");
		else
			System.out.println("Testing method or(), Input: (false, false), Output: false, Expected output: false");
		if (new Bit(false).or(new Bit(true)).getValue() != true)
			System.out.println("Testing method or(), Input: (false, true), Output: false, Expected output: true");
		else
			System.out.println("Testing method or(), Input: (false, true), Output: true, Expected output: true");
		if (new Bit(true).or(new Bit(false)).getValue() != true)
			System.out.println("Testing method or(), Input: (true, false), Output: false, Expected output: true");
		else
			System.out.println("Testing method or(), Input: (true, false), Output: true, Expected output: true");
		if (new Bit(true).or(new Bit(true)).getValue() != true)
			System.out.println("Testing method or(), Input: (true, true), Output: false, Expected output: true");
		else
			System.out.println("Testing method or(), Input: (true, true), Output: true, Expected output: true");
		System.out.println();
	}
	
	public static void testXor() {
		if (new Bit(false).xor(new Bit(false)).getValue() != false)
			System.out.println("Testing method xor(), Input: (false, false), Output: true, Expected output: false");
		else
			System.out.println("Testing method xor(), Input: (false, false), Output: false, Expected output: false");
		if (new Bit(false).xor(new Bit(true)).getValue() != true)
			System.out.println("Testing method xor(), Input: (false, true), Output: false, Expected output: true");
		else
			System.out.println("Testing method xor(), Input: (false, true), Output: true, Expected output: true");
		if (new Bit(true).xor(new Bit(false)).getValue() != true)
			System.out.println("Testing method xor(), Input: (true, false), Output: false, Expected output: true");
		else
			System.out.println("Testing method xor(), Input: (true, false), Output: true, Expected output: true");
		if (new Bit(true).xor(new Bit(true)).getValue() != false)
			System.out.println("Testing method xor(), Input: (true, true), Output: true, Expected output: false");
		else
			System.out.println("Testing method xor(), Input: (true, true), Output: false, Expected output: false");
		System.out.println();
	}
	
	public static void testNot() {
		if (new Bit(false).not().getValue() != true)
			System.out.println("Testing method not(), Starting value: false, Output: false, Expected output: true");
		else
			System.out.println("Testing method not(), Starting value: false, Output: true, Expected output: true");
		if (new Bit(true).not().getValue() != false)
			System.out.println("Testing method not(), Starting value: true, Output: true, Expected output: false");
		else
			System.out.println("Testing method not(), Starting value: true, Output: false, Expected output: false");
		System.out.println();
	}
	
	public static void testToString() {
		if (new Bit(false).toString().equals("t"))
			System.out.println("Testing method toString(), Starting value: false, Output: t, Expected output: f");
		else
			System.out.println("Testing method toString(), Starting value: false, Output: f, Expected output: f");
		if (new Bit(true).toString().equals("f"))
			System.out.println("Testing method toString(), Starting value: true, Output: f, Expected output: t");
		else
			System.out.println("Testing method toString(), Starting value: true, Output: t, Expected output: t");
		System.out.println();
	}
	
}

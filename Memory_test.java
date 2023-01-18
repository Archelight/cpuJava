package project5Test;
import project2.Longword;
import project5.Memory;
//Nikita Romanovsky, ICSI404
public class Memory_test {
	
	public static void main(String[] args) throws Exception {
		runAllTests();
	}

	public static void runAllTests() throws Exception {
		testRead();
		testWrite();
	}
	
	private static void testRead() throws Exception {
		Memory testMemory = new Memory();
		if(testMemory.read(new Longword(20)).getSigned() == 0)
			System.out.println("Testing method read(), Input: (Longword(20)), Output: 0, Expected output: 0");
		else
			System.out.println("Testing method read(), Input: (Longword(20)), Output: Wrong Output, Expected output: 0");
		testMemory = new Memory();
		testMemory.write(new Longword(40), new Longword(-123));
		if(testMemory.read(new Longword(40)).getSigned() == -123)
			System.out.println("Testing method read(), Input: (Longword(40)), Output: -123, Expected output: -123");
		else
			System.out.println("Testing method read(), Input: (Longword(40)), Output: Wrong Output, Expected output: -123");
		testMemory = new Memory();
		testMemory.write(new Longword(1000), new Longword(2123));
		if(testMemory.read(new Longword(1000)).getSigned() == 2123)
			System.out.println("Testing method read(), Input: (Longword(1000)), Output: 2123, Expected output: 2123");
		else
			System.out.println("Testing method read(), Input: (Longword(1000)), Output: Wrong Output, Expected output: 2123");
		testMemory = new Memory();
		testMemory.write(new Longword(521), new Longword(-21212221));
		if(testMemory.read(new Longword(521)).getSigned() == -21212221)
			System.out.println("Testing method read(), Input: (Longword(-21212221)), Output: -21212221, Expected output: -21212221");
		else
			System.out.println("Testing method read(), Input: (Longword(-21212221)), Output: Wrong Output, Expected output: -21212221");
		try {
			testMemory = new Memory();
			testMemory.read(new Longword(1021));
		}catch(Exception e){
			System.out.println("Testing method read(), Input: (Longword(1021)), Output: Error, address must be less than 1021"); 
		}
		try {
			testMemory = new Memory();
			testMemory.read(new Longword(-560));
		}catch(Exception e){
			System.out.println("Testing method read(), Input: (Longword(-560)), Output: Error, address must be more than -1"); 
		}
		System.out.println();
	}
	
	private static void testWrite() throws Exception {
		Memory testMemory = new Memory();
		testMemory.write(new Longword(20), new Longword(34));
		if(testMemory.read(new Longword(20)).getSigned() == 34)
			System.out.println("Testing method write(), Input: (Longword(20)), Longword(34)), Output: 34, Expected output: 34");
		else
			System.out.println("Testing method write(), Input: (Longword(20), Longword(34)), Output: Wrong Output, Expected output: 34");
		testMemory = new Memory();
		testMemory.write(new Longword(1020), new Longword(6343));
		if(testMemory.read(new Longword(1020)).getSigned() == 6343)
			System.out.println("Testing method write(), Input: (Longword(1020)), Longword(6343)), Output: 6343, Expected output: 6343");
		else
			System.out.println("Testing method write(), Input: (Longword(1020), Longword(6343)), Output: Wrong Output, Expected output: 6343");
		testMemory = new Memory();
		testMemory.write(new Longword(0), new Longword(1000000008));
		testMemory.write(new Longword(3), new Longword(67108864));
		if(testMemory.read(new Longword(0)).getSigned() == 1000000004)
			System.out.println("Testing method write(), then overwrite last 8 bits with '4', Input: (Longword(0)), Longword(1000000008)), Output: 1000000004, Expected output: 1000000004");
		else
			System.out.println("Testing method write(), then overwrite last 8 bits with '4', Input: (Longword(0), Longword(1000000008)), Output: Wrong Output, Expected output: 1000000004");
		testMemory = new Memory();
		testMemory.write(new Longword(210), new Longword(-123123));
		if(testMemory.read(new Longword(210)).getSigned() == -123123)
			System.out.println("Testing method write(), Input: (Longword(210)), Longword(-123123)), Output: -123123, Expected output: -123123");
		else
			System.out.println("Testing method write(), Input: (Longword(210), Longword(-123123)), Output: Wrong Output, Expected output: -123123");
		testMemory = new Memory();
		testMemory.write(new Longword(0), new Longword(0));
		if(testMemory.read(new Longword(0)).getSigned() == 0)
			System.out.println("Testing method write(), Input: (Longword(0)), Longword(0)), Output: 0, Expected output: 0");
		else
			System.out.println("Testing method write(), Input: (Longword(0), Longword(0)), Output: Wrong Output, Expected output: 0");
		testMemory = new Memory();
		testMemory.write(new Longword(700), new Longword(-10000));
		if(testMemory.read(new Longword(700)).getSigned() == -10000)
			System.out.println("Testing method write(), Input: (Longword(700)), Longword(-10000)), Output: -10000, Expected output: -10000");
		else
			System.out.println("Testing method write(), Input: (Longword(700), Longword(-10000)), Output: Wrong Output, Expected output: -10000");
		try {
			testMemory = new Memory();
			testMemory.write(new Longword(1021), new Longword(2));
		}catch(Exception e){
			System.out.println("Testing method write(), Input: (Longword(1021), Longword(2)), Output: Error, address must be less than 1021"); 
		}
		try {
			testMemory = new Memory();
			testMemory.write(new Longword(-560), new Longword(200));
		}catch(Exception e){
			System.out.println("Testing method write(), Input: (Longword(-560), Longword(200)), Output: Error, address must be more than -1"); 
		}
		System.out.println();
	}
}

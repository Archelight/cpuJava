package Project6Test;
import Project6.Assembler;
//Nikita Romanovsky, ICSI404
public class Assembler_test {

	public static void main(String[] args) throws Exception {
		runAllTests();
	}

	public static void runAllTests() throws Exception {
		testAssembler();

	}

	public static void testAssembler() throws Exception {
		System.out.println("Test 1: Every string has correct syntax");
		String[] oldStrings = new String[] { "inTerrupt 1", "add R2 R5 R1", "halt ", "subtract r2 r15 R10",
				"multiply R8 R6 R12", " leftshift  R5 R9  R11", "rightshift R10 R14 R3", "move R1 -43", "and R2 R4 R12",
				"or R5 R1 R0", "xor R7 R1 R13", "not R5 R2", "compare R5 R5", "jump 51", "branchifgreaterthaN 12"};
		printRegArray(oldStrings);
		try {
			printBitArray(Assembler.assemble(oldStrings));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Test 1 Success");
		System.out.println();
		System.out.println("Test 2: Every string has correct syntax");
		oldStrings = new String[] { " MOvE R2  0  ", " add  R9 R2 R2", "interRuPt 0 ", "subtRact R2 R5 R10",
				"mulTiply R8 R6 R12", " lefTShift  R5 R9     R11", "riGhtShift R1 R4 R3", "inTerrupt 1 ", "aNd R2   R4 R2",
				"Or r5 r1 r0", "xor   R7 R14 R13", "not R5   R0" };
		printRegArray(oldStrings);
		try {
			printBitArray(Assembler.assemble(oldStrings));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Test 2 Success");
		System.out.println();
		System.out.println("Test 3: Every string has correct syntax");
		oldStrings = new String[] { "  subTract R3 R2 R9 ", "add R7 R2 R0","haLt", "mOve R14   -128", "xor   R7 R14 R13", "and r2 R0  r2 ",
				"multiply R12 r2 r0", "leftShift R2 R8 R7", "rightShift R3 r8 r9  ", "interrUPT   0", "not R2 R1"};
		printRegArray(oldStrings);
		try {
			printBitArray(Assembler.assemble(oldStrings));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Test 3 Success");
		System.out.println();
		System.out.println("Test 4: Testing when wrong number of arguments is given");
		oldStrings = new String[] { "subtract R2 R4 R9 R0"};
		printRegArray(oldStrings);
		try {
			printBitArray(Assembler.assemble(oldStrings));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Test 4 Success");
		System.out.println();
		System.out.println("Test 5: Testing when wrong arguments is given");
		oldStrings = new String[] { "rightshift R2 R6 23"};
		printRegArray(oldStrings);
		try {
			printBitArray(Assembler.assemble(oldStrings));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Test 5 Success");
		System.out.println();
		System.out.println("Test 6: Testing when wrong arguments is given");
		oldStrings = new String[] { "move R2 R6"};
		printRegArray(oldStrings);
		try {
			printBitArray(Assembler.assemble(oldStrings));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Test 6 Success");
		System.out.println();
		System.out.println("Test 7: Testing when misspelled arguments is given");
		oldStrings = new String[] { "mov R2 21"};
		printRegArray(oldStrings);
		try {
			printBitArray(Assembler.assemble(oldStrings));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Test 7 Success");
		System.out.println();
		System.out.println("Test 8: Testing when number to move is too large");
		oldStrings = new String[] { "move R2 128"};
		printRegArray(oldStrings);
		try {
			printBitArray(Assembler.assemble(oldStrings));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Test 8 Success");
		System.out.println();
		System.out.println("Test 9: Testing when number to move is too small");
		oldStrings = new String[] { "move R2 -129"};
		printRegArray(oldStrings);
		try {
			printBitArray(Assembler.assemble(oldStrings));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Test 9 Success");
		System.out.println();
		System.out.println("Test 10: Testing when random symbols are given");
		oldStrings = new String[] { "interrupt, 1"};
		printRegArray(oldStrings);
		try {
			printBitArray(Assembler.assemble(oldStrings));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Test 10 Success");
		System.out.println();
		System.out.println("Test 11: Testing when random spaces between arguments are given");
		oldStrings = new String[] { "interr upt 1"};
		printRegArray(oldStrings);
		try {
			printBitArray(Assembler.assemble(oldStrings));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Test 11 Success");
		System.out.println();
		System.out.println("Test 12: Testing when too little arguments are given");
		oldStrings = new String[] {"not R5 "};
		printRegArray(oldStrings);
		try {
			printBitArray(Assembler.assemble(oldStrings));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Test 12 Success");
		System.out.println();
		System.out.println("Test 13: Testing when wrong keyword is given");
		oldStrings = new String[] {"interrupt R5 R2 R15 "};
		printRegArray(oldStrings);
		try {
			printBitArray(Assembler.assemble(oldStrings));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Test 13 Success");
		System.out.println();
		System.out.println("Test 14: Testing when negative sign is connected to wrong argument ");
		oldStrings = new String[] {"move -R3 15"};
		printRegArray(oldStrings);
		try {
			printBitArray(Assembler.assemble(oldStrings));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Test 14 Success");
		System.out.println();
		System.out.println("Test 15: Testing when wrong order of arguments is given");
		oldStrings = new String[] {"0 interrupt"};
		printRegArray(oldStrings);
		try {
			printBitArray(Assembler.assemble(oldStrings));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Test 15 Success");
		System.out.println();
		System.out.println("Test 16: Testing when argument interrupt is given a wrong number");
		oldStrings = new String[] {" interrupt 3"};
		printRegArray(oldStrings);
		try {
			printBitArray(Assembler.assemble(oldStrings));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Test 16 Success");
	}

	public static void printRegArray(String[] commands) {
		for (int k = 0; k < commands.length; k++) {
			System.out.print("Original String " + k + ": ");
			for (int i = 0; i < commands[k].length(); i++) {
				System.out.print(commands[k].charAt(i));
			}
			System.out.println();
		}
	}

	public static void printBitArray(String[] commands) {
		System.out.println();
		for (int k = 0; k < commands.length; k++) {
			System.out.print("Assembled String " + k + ": ");
			int j = 3;
			for (int i = 0; i < commands[k].length(); i++) {
				System.out.print(commands[k].charAt(i));
				if (i == j) {
					System.out.print(" ");
					j = j + 4;
				}
			}
			System.out.println();
		}
	}
}

package project5Test;
import project5.Computer;
//Nikita Romanovsky, ICSI404
public class CPU_test1 {

	public static void main(String[] args) throws Exception {
		runAllTests();
	}

	public static void runAllTests() throws Exception {
		testCPU();
	}
	
	public static void testCPU() throws Exception {
		System.out.println("Moving -1 to R1, Moving 2 to R2, Adding R1 and R2 then storing result in R3, Printing Registers, Printing Memory, Halting");
		Computer testComputer = new Computer();
		String[] testString = {"0001 0001 11111111", "0001 0010 00000010", "1110 0001 0010 0011", "0010 0000 0000 0000", "0010 0000 0000 0001", "0000 0000 0000 0000"};
		testComputer.preload(testString);
		testComputer.run();
		System.out.println("Moving 127 to R5, Moving -126 to R0, Subtracting R5 from R0 then storing result in R3, Printing Registers, Printing Memory, Halting, Attempting to move 2 to R2");
		testComputer = new Computer();
		String[] testString1 = {"0001 0101 01111111", "0001 0000 10000010", "1111 0000 0101 0011", "0010 0000 0000 0000", "0010 0000 0000 0001", "0000 0001 0010 0010", "0001 0010 00000010"};
		testComputer.preload(testString1);
		testComputer.run();
		System.out.println("Moving 127 to R5, Moving -126 to R0, Subtracting R5 from R0 then storing result in R3, Moving 50 to R9, Moving 73 to R15, Moving -27 to R5, Multiplying R15 by R9 then storing result in R15, Printing Registers, Printing Memory, Halting");
		testComputer = new Computer();
		String[] testString2 = {"0001 0101 01111111", "0001 0000 10000010", "1111 0000 0101 0011", "0001 1001 00110010", "0001 1111 01001001", "0001 0101 11100101", "0111 1111 1001 1111", "0010 0000 0000 0000", "0010 0000 0000 0001", "0000 0001 0010 0010"};
		testComputer.preload(testString2);
		testComputer.run(); 
		System.out.println("Moving -99 to R1, Moving -22 to R0, Add R1 to R0 then storing result in R0, Moving 50 to R9, Moving 100 to R14, Subtracting R2 from R1 then storing result in R3, Printing Registers, Printing Memory, Moving 127 to R5");
		testComputer = new Computer();
		String[] testString3 = {"0001 0001 10011101", "0001 0000 11101010", "1110 0001 0000 0000", "0001 1001 00110010", "0001 1110 01100100", "1111 0001 0010 0011", "0010 0000 0010 0000", "0010 0000 0100 0001", "0001 0101 01111111"};
		testComputer.preload(testString3);
		testComputer.run(); 
		System.out.println("Moving 74 to R1, Moving -53 to R4, Multiply R4 by R1 then storing result in R0, Printing Registers, Multiply R0 by R1 then storing result in R4, Moving 100 to R1, Subtracting R2 from R1 and storing in R3, Printing Registers, Printing Memory, Moving 1 to R5, Halting");
		testComputer = new Computer();
		String[] testString4 = {"0001 0001 01001010", "0001 0100 11001011", "0111 0001 0100 0000", "0010 0000 0010 0000", "0111 0000 0001 0100", "0001 0001 01100100", "1111 0001 0010 0011", "0010 0000 0010 0000", "0010 0000 0100 0001", "0001 0101 00000001", "0000 0000 1111 1111"};
		testComputer.preload(testString4);
		testComputer.run();
		System.out.println("Moving 1 to R1, Moving 2 to R4, LeftShift R1 by R4 then storing result in R0, Printing Registers, Printing Memory, Halting");
		testComputer = new Computer();
		String[] testString5 = {"0001 0001 00000001", "0001 0100 00000010", "1100 0001 0100 0000", "0010 0000 0010 0000", "0010 0000 0100 0001", "Halting"};
		testComputer.preload(testString5);
		testComputer.run();
		
	}
}

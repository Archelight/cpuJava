package project5;
import project1.Bit;
import project2.Longword;
import project3.RippleAdder;
import project4.ALU;
//Nikita Romanovsky, ICSI404
public class Computer {

	private Bit status;
	private Memory mem;
	private Longword PC;
	private Longword currentInstruction;
	private Longword op1;
	private Longword op2;
	private Longword[] registers;
	private Longword result;
	private Bit equalBit;
	private Bit greaterThanBit;
	private Longword SP;
	
	public Computer() throws Exception {
		status = new Bit(false);
		PC = new Longword();
		currentInstruction = new Longword();
		op1 = new Longword();
		op2 = new Longword();
		result = new Longword();
		SP = new Longword(1020);
		mem = new Memory();
		this.registers = new Longword[16];
		for(int i = 0; i < 16 ; i++)
			this.registers[i] = new Longword(0);
		equalBit = new Bit(false);
		greaterThanBit = new Bit(false);
	}
	
	public void run() throws Exception {
		status.set();
		while(status.getValue() != false) {
			this.fetch();
			this.decode();
			this.execute();
			this.store();
		}
	}
	
	public void fetch() throws Exception {
		currentInstruction = mem.read(PC);
		PC.copy(RippleAdder.add(PC, new Longword(2)));
	}
	
	public Bit[] getCompareBits() {
		Bit[] compareBits = new Bit[2];
		compareBits[0] = greaterThanBit;
		compareBits[1] = equalBit;
		return compareBits;
	}
	
	public void signExtend() {
		for(int i = 21; i > -1; i--) {
			result.getBit(i).set(result.getBit(22).getValue()); //set the bits 0-21 of longword equal to the bit at 22, used in branch instruction
		}
	}
	
	public Longword getBitSegment(int position, int numBits) throws Exception { //gets any 4 bits of currentInstruction, starting from the bit at "position"
		Longword instructionCopy = new Longword(); //currentInstruction will look like 1110 0001 0010 0011 0000 0000...0000
		Longword bitMask = new Longword(1);
		instructionCopy.copy(currentInstruction);
		instructionCopy = instructionCopy.rightShift(position); //right shift the instruction by the position of the first bit that is needed, clearing all of the bits before it
		bitMask = RippleAdder.subtract(bitMask.leftShift(numBits), new Longword(1)); //leftShift the bit mask by 4 to cover the four needed bits, subtract 1 from the bit mask to get it from "10000" to "1111"
		return instructionCopy.and(bitMask); //the bits after the four needed bits will be set to 0
	}
	
	public void decode() throws Exception {
		Longword controlBits = getBitSegment(28, 4); //get bits 28-31 of currentInstuction which represent the operation code
		if(!(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == false && controlBits.getBit(30).getValue() == false && controlBits.getBit(31).getValue() == false) 
			&& !(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == false && controlBits.getBit(30).getValue() == true && controlBits.getBit(31).getValue() == true) 
			&& !(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == false && controlBits.getBit(30).getValue() == true && controlBits.getBit(31).getValue() == false) 
			&& !(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == false && controlBits.getBit(30).getValue() == false && controlBits.getBit(31).getValue() == true)) {
			if(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == true && controlBits.getBit(30).getValue() == false && controlBits.getBit(31).getValue() == false) {
				op1.copy(registers[getBitSegment(20, 4).getSigned()]); //get bits 20-23 of currentInstruction which represent a register to be operated on
				op2.copy(registers[getBitSegment(16, 4).getSigned()]);
			}
			else if(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == true && controlBits.getBit(30).getValue() == true && controlBits.getBit(31).getValue() == false) {
				if(currentInstruction.getBit(4).getValue() == false && currentInstruction.getBit(5).getValue() == false)
					op1.copy(registers[getBitSegment(16, 4).getSigned()]);
			}
			else {
				op1.copy(registers[getBitSegment(24, 4).getSigned()]); //get bits 24-27 of currentInstruction which represent a register to be operated on
				op2.copy(registers[getBitSegment(20, 4).getSigned()]); //get bits 20-23 of currentInstruction which represent a register to be operated on
			}
		}
	}
	
	public void execute() throws Exception {
		Longword controlBits = getBitSegment(28, 4);
		Longword lastFourBits = getBitSegment(16, 4);
		if(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == false && controlBits.getBit(30).getValue() == false && controlBits.getBit(31).getValue() == false)//instruction is halt
			status.clear();
		else if(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == false && controlBits.getBit(30).getValue() == true && controlBits.getBit(31).getValue() == false) { //instruction is an interrupt
			if(lastFourBits.getBit(28).getValue() == false && lastFourBits.getBit(29).getValue() == false && lastFourBits.getBit(30).getValue() == false && lastFourBits.getBit(31).getValue() == false) {//print the registers, interrupt 0
				System.out.println();
				for(int i = 0; i < 16; i++)
					System.out.println("Register"+i+": "+registers[i]+": "+registers[i].getSigned());
			}
			else { //print the memory, interrupt1
				mem.printMem();
			}
		}
		else if(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == true && controlBits.getBit(30).getValue() == false && controlBits.getBit(31).getValue() == false) { //instruction is a compare
			result.copy(RippleAdder.subtract(op1, op2));
		}
		else if(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == true && controlBits.getBit(30).getValue() == false && controlBits.getBit(31).getValue() == true) { //instruction is a branch
			result.copy(new Longword(0)); //reset the result so as to not branch when branch conditions are not met
			if(currentInstruction.getBit(5).getValue() == true && currentInstruction.getBit(4).getValue() == false) {
				if(equalBit.getValue() == true) { //if the branch condition is ifequal, check if equal bit is set to true
					result.copy(getBitSegment(16, 10));
					signExtend();
				}
			}
			else if(currentInstruction.getBit(4).getValue() == true && currentInstruction.getBit(5).getValue() == false) {
				if(greaterThanBit.getValue() == true) { //if the branch condition is ifgreaterthan, check if greaterthan bit is set to true
					result.copy(getBitSegment(16, 10));
					signExtend();
				}
			}
			else if(currentInstruction.getBit(4).getValue() == true && currentInstruction.getBit(5).getValue() == true) {
				if(greaterThanBit.getValue() == true || equalBit.getValue() == true) { //if the branch condition is ifgreaterthanorequal, check if either equal bit or greaterthan bit is set to true
					result.copy(getBitSegment(16, 10));
					signExtend();
				}
			}
			else {
				if(equalBit.getValue() == false) { //if the branch condition is notequal, check if equal bit is set to false
					result.copy(getBitSegment(16, 10));
					signExtend();
				}
			}
		}
		else if(!(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == false && controlBits.getBit(30).getValue() == false && controlBits.getBit(31).getValue() == true) 
				&& !(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == false && controlBits.getBit(30).getValue() == true && controlBits.getBit(31).getValue() == true)
				&& !(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == true && controlBits.getBit(30).getValue() == true && controlBits.getBit(31).getValue() == false))
			//if the instruction is not a move, jump, push, pop, call, or return, call ALU and do operation
			result = ALU.doOp(controlBits.getBit(28), controlBits.getBit(29), controlBits.getBit(30), controlBits.getBit(31), op1, op2);
	}
	
	public void store() throws Exception {
		Longword controlBits = getBitSegment(28, 4);
		if(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == false && controlBits.getBit(30).getValue() == false && controlBits.getBit(31).getValue() == true) { //instruction is move
			Longword valueToMove = new Longword();
			valueToMove.copy(getBitSegment(16, 8)); //gets bits 16-23 which represent the value to be moved
			if(valueToMove.getBit(24).getValue() == true) {
				for(int i = 0; i < 24; i++) //sign extend the move value if it is negative
					valueToMove.setBit(i, new Bit(true));;
			}
			registers[getBitSegment(24, 4).getSigned()] = valueToMove;
		}
		else if(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == false && controlBits.getBit(30).getValue() == true && controlBits.getBit(31).getValue() == true) { //instruction is a jump
			PC.copy(getBitSegment(16, 12));
		}
		else if(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == true && controlBits.getBit(30).getValue() == false && controlBits.getBit(31).getValue() == false) { //instruction is a compare
			if(result.equals(new Longword(0))) { //if compare result is 0, set the equal bit to true since the two compared numbers must be equal
				equalBit.set();
				greaterThanBit.clear();
			}
			else if(result.getBit(0).getValue() == false) {
				equalBit.clear(); //if compare result is more than 0, set the greaterthan bit to true since the first compared number must be greater
				greaterThanBit.set();
			}
			else {
				equalBit.clear(); //if compare result is less than 0, set both bits to false since the first compared number must be lesser than
				greaterThanBit.clear();
			}
		}
		else if(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == true && controlBits.getBit(30).getValue() == true && controlBits.getBit(31).getValue() == false) { //instruction is a push, pop, call, or return
			if(currentInstruction.getBit(4).getValue() == false && currentInstruction.getBit(5).getValue() == false) { //the instruction is a push
				mem.write(SP, op1);
				SP.copy(RippleAdder.subtract(SP, new Longword(4))); //need to subtract 4 to prepare for the next push on to the stack
			}
			else if(currentInstruction.getBit(4).getValue() == false && currentInstruction.getBit(5).getValue() == true) { //the instruction is a pop
				SP.copy(RippleAdder.add(SP, new Longword(4))); //need to add 4 to get to the first longword in the stack
				registers[getBitSegment(16, 4).getSigned()].copy(mem.read(SP));
			}
			else if(currentInstruction.getBit(4).getValue() == true && currentInstruction.getBit(5).getValue() == false) { //the instruction is a call
				mem.write(SP, PC);  //push the next instruction to stack
				PC.copy(getBitSegment(16, 10)); //jump
				SP.copy(RippleAdder.subtract(SP, new Longword(4))); //need to subtract 4 to prepare for the next push on to the stack
			}
			else { //the instruction is a return
				SP.copy(RippleAdder.add(SP, new Longword(4))); //need to add 4 to get to the first longword in the stack
				PC.copy(mem.read(SP)); 
			}
		}
		else if(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == true && controlBits.getBit(30).getValue() == false && controlBits.getBit(31).getValue() == true) { //instruction is a branch
			PC.copy(RippleAdder.add(PC, result));
		}
		else if(status.getValue() != false && !(controlBits.getBit(28).getValue() == false && controlBits.getBit(29).getValue() == false && controlBits.getBit(30).getValue() == true && controlBits.getBit(31).getValue() == false))
			registers[getBitSegment(16, 4).getSigned()].copy(result); //get bits 16-19 of currentInstruction which represent the register to store the operation result
	}
	
	public void preload(String[] instructions) throws Exception {
		int memCount = 0;
		if(instructions.length % 2 == 0) {
			for(int i = 0; i <instructions.length; i = i+2) { //check if the # of strings is even
				Longword twoInstructions = Longword.stringToLongword(instructions[i].concat(instructions[i + 1]));
				mem.write(new Longword(memCount), twoInstructions);
				memCount = memCount + 4;
			}
		}
		else {
			for(int i = 0; i <instructions.length - 1; i = i+2) { //if # of strings is not even, fill the last 16 bits of the last Longword with off bits
				Longword twoInstructions = Longword.stringToLongword(instructions[i].concat(instructions[i + 1])); //concat every 2 strings and convert to a Longword
				mem.write(new Longword(memCount), twoInstructions);
				memCount = memCount + 4; //increment memCount by 4 since each Longword has 2 instructions and an instruction contains 2 bytes
			}
			Longword twoInstructions = Longword.stringToLongword(instructions[instructions.length - 1]);
			mem.write(new Longword(memCount), twoInstructions);
			memCount = memCount + 4;
		}
	}
}

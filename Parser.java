package Project6;
import project2.Longword;
//Nikita Romanovsky, ICSI404
public class Parser extends LexicalAnalyzer {

	private String bitString = new String();
	private int keywordToken = nextToken;

	public String command() throws Exception {
		lex();
		if (nextToken != TokenCode.REGISTER.getLevelCode() && nextToken != TokenCode.NUMBER.getLevelCode() && nextToken != TokenCode.EOS.getLevelCode()) {
			keyword(); //make sure the first argument is a keyword
			return bitString;
		} else
			throw new SyntaxError("Syntax Error");
	}

	public void keyword() throws Exception {
		keywordToken = nextToken; //keep track of the keyword token
		keywordToBits();
		lex();
		if (nextToken == TokenCode.REGISTER.getLevelCode() && keywordToken != TokenCode.INTERRUPT.getLevelCode()
				&& keywordToken != TokenCode.HALT.getLevelCode() && keywordToken != TokenCode.JUMP.getLevelCode() 
				&& keywordToken != TokenCode.BRANCHIFEQUAL.getLevelCode() && keywordToken != TokenCode.BRANCHIFGREATERTHAN.getLevelCode()
				&& keywordToken != TokenCode.BRANCHIFNOTEQUAL.getLevelCode() && keywordToken != TokenCode.BRANCHIFGREATERTHANOREQUAL.getLevelCode()
				&& keywordToken != TokenCode.CALL.getLevelCode() && keywordToken != TokenCode.RETURN.getLevelCode()) //make sure a register does not follow a halt, interrupt, jump, branch, or call keyword
			register();
		else if (nextToken == TokenCode.NUMBER.getLevelCode() && (keywordToken == TokenCode.INTERRUPT.getLevelCode() 
				|| keywordToken == TokenCode.JUMP.getLevelCode() || keywordToken == TokenCode.BRANCHIFEQUAL.getLevelCode() 
				|| keywordToken == TokenCode.BRANCHIFGREATERTHAN.getLevelCode() || keywordToken == TokenCode.BRANCHIFNOTEQUAL.getLevelCode() 
				|| keywordToken == TokenCode.BRANCHIFGREATERTHANOREQUAL.getLevelCode() || keywordToken == TokenCode.CALL.getLevelCode()))
			number(); //at this point, a number must be part of an interrupt or jump or branch keyword
		else if (nextToken == TokenCode.EOS.getLevelCode()) {
			if (keywordToken != TokenCode.HALT.getLevelCode() && keywordToken != TokenCode.RETURN.getLevelCode()) //if the keyword is halt or return, it must be the only argument
				throw new SyntaxError("Syntax Error");
		}
		else
			throw new SyntaxError("Syntax Error");
	}

	public void register() throws Exception {
		registerToBits();
		lex();
		if(keywordToken == TokenCode.NOT.getLevelCode())
			bitString = bitString.concat("0000");
		if (nextToken == TokenCode.REGISTER.getLevelCode() && keywordToken != TokenCode.MOVE.getLevelCode() 
				&& keywordToken != TokenCode.PUSH.getLevelCode() && keywordToken != TokenCode.POP.getLevelCode() ) {
			registerToBits(); //the keyword cannot be "move", "halt", or "interrupt" at this point
			lex();
			if (nextToken == TokenCode.REGISTER.getLevelCode() && keywordToken != TokenCode.NOT.getLevelCode() 
					&& keywordToken != TokenCode.COMPARE.getLevelCode() ) {
				registerToBits(); //the keyword cannot be "not" or "compare" at this point
				lex();
				if (nextToken != TokenCode.EOS.getLevelCode()) {
					throw new SyntaxError("Syntax Error");
				}
			} else if(nextToken != TokenCode.EOS.getLevelCode())
				throw new SyntaxError("Syntax Error");
		} else if (nextToken == TokenCode.NUMBER.getLevelCode() && keywordToken == TokenCode.MOVE.getLevelCode())
			number(); //at this point, only keyword "move" can have a number as a argument
		else if(nextToken == TokenCode.EOS.getLevelCode() && keywordToken != TokenCode.PUSH.getLevelCode() && keywordToken != TokenCode.POP.getLevelCode())
			throw new SyntaxError("Syntax Error");
	}

	public void number() throws Exception {
		Integer numberToAdd = Integer.parseInt(new String(lexeme).trim()); //make sure the interrupt is 0 or 1, add the interrupt number to string
		if (keywordToken == TokenCode.INTERRUPT.getLevelCode()) {
			if(numberToAdd > 1 || numberToAdd < 0) 
				throw new SyntaxError("Syntax Error, Interrupt can only be 0 or 1");
			else
				bitString = bitString.concat(this.numberToBits(Integer.parseInt(new String(lexeme).trim()), 4));
		}
		else if(keywordToken == TokenCode.JUMP.getLevelCode()) { //make sure the jump address can fit into 12 unsigned bits, add the jump address to string
			if(numberToAdd > 4095 || numberToAdd < 0)
				throw new SyntaxError("Syntax Error, can only jump to addresses 0 - 4095");
			else
				bitString = bitString.concat(this.numberToBits(Integer.parseInt(new String(lexeme).trim()), 12));
		}
		else if (keywordToken == TokenCode.BRANCHIFEQUAL.getLevelCode() || keywordToken == TokenCode.BRANCHIFGREATERTHAN.getLevelCode() 
				|| keywordToken == TokenCode.BRANCHIFNOTEQUAL.getLevelCode() || keywordToken == TokenCode.BRANCHIFGREATERTHANOREQUAL.getLevelCode()
				|| keywordToken == TokenCode.CALL.getLevelCode()) {
			if(numberToAdd > 511 || numberToAdd < -512) //make sure the branch amount can fit in 10 signed bits, add the branch amount to string
				throw new SyntaxError("Syntax Error, can only branch to addresses -512 - 511");
			else
				bitString = bitString.concat(this.numberToBits(Integer.parseInt(new String(lexeme).trim()), 10));
		}
		else if (keywordToken == TokenCode.MOVE.getLevelCode()) //keyword must be move at this point, add the number to move to string
			if(numberToAdd > 127 || numberToAdd < -128)
				throw new SyntaxError("Syntax Error, can only move -128 - 127");
			else
			bitString = bitString.concat(this.numberToBits(Integer.parseInt(new String(lexeme).trim()), 8));
		lex();
		if(nextToken != TokenCode.EOS.getLevelCode())
			throw new SyntaxError("Syntax Error");
	}

	public void keywordToBits() {
		switch (new String(lexeme).trim()) {
		case "and":
			bitString = bitString.concat("1000");
			break;
		case "or":
			bitString = bitString.concat("1001");
			break;
		case "xor":
			bitString = bitString.concat("1010");
			break;
		case "not":
			bitString = bitString.concat("1011");
			break;
		case "leftshift":
			bitString = bitString.concat("1100");
			break;
		case "rightshift":
			bitString = bitString.concat("1101");
			break;
		case "add":
			bitString = bitString.concat("1110");
			break;
		case "subtract":
			bitString = bitString.concat("1111");
			break;
		case "multiply":
			bitString = bitString.concat("0111");
			break;
		case "halt":
			bitString = bitString.concat("0000000000000000");
			break;
		case "move":
			bitString = bitString.concat("0001");
			break;
		case "interrupt":
			bitString = bitString.concat("001000000000");
			break;
		case "jump":
			bitString = bitString.concat("0011");
			break;
		case "compare":
			bitString = bitString.concat("01000000");
			break;
		case "branchifequal":
			bitString = bitString.concat("010101");
			break;
		case "branchifgreaterthan":
			bitString = bitString.concat("010110");
			break;
		case "branchifnotequal":
			bitString = bitString.concat("010100");
			break;
		case "branchifgreaterthanorequal":
			bitString = bitString.concat("010111");
			break;
		case "push":
			bitString = bitString.concat("011000000000");
			break;
		case "pop":
			bitString = bitString.concat("011001000000");
			break;
		case "call":
			bitString = bitString.concat("011010");
			break;
		case "return":
			bitString = bitString.concat("0110110000000000");
			break;
		}
	}

	public void registerToBits() throws NumberFormatException, Exception {
		String register = new String(lexeme).trim(); //remove the letter part of the register 'R', then convert the digit part to bits
		bitString = bitString.concat(this.numberToBits(Integer.parseInt(register.substring(1)), 4));
	}

	public String numberToBits(int number, int numBits) throws Exception { //numBits is 8 only when the keyword is "move"
		Longword bitNumber = new Longword(number);
		StringBuilder result = new StringBuilder();
		for (int i = 32 - numBits; i < 32; i++) { //runs through the last 4 or 8 bits of the longword, appending 0 or 1 depending on the bit
			if(bitNumber.getBit(i).getValue() == false)
				result.append('0');
			else
				result.append('1');
		}
		return result.toString();
	}
}

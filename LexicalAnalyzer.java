package Project6;
import java.util.ArrayList;
//Nikita Romanovsky, ICSI404
public class LexicalAnalyzer {
	protected char[] lexeme;
	private char nextChar;
	private ArrayList<Character> expression = new ArrayList<Character>();
	private int instructionLength;
	private int count;
	protected int nextToken;
	private int lexLen;
	private int charClass;

	public void parseString(String st) {
		char[] temp = st.toCharArray();
		while ((count != temp.length)) {
			expression.add(temp[count]);
			count++;
		}
	}

	public void addChar() {
		lexeme[lexLen++] = Character.toLowerCase(nextChar);
	}

	public void getChar() {
		if (instructionLength < count) {
			nextChar = expression.get(instructionLength);
			// determine if the char is a letter, digit, sign, blankspace, or unsuported
			if (Character.isLetter(nextChar))
				charClass = CharClass.LETTER.getLevelCode();
			else if (Character.isDigit(nextChar))
				charClass = CharClass.DIGIT.getLevelCode();
			else if (nextChar == '-')
				charClass = CharClass.SIGN.getLevelCode();
			else if (nextChar == '\n' || nextChar == '\r' || nextChar == ' ')
				charClass = CharClass.BLANKSPACE.getLevelCode();
			else {
				charClass = CharClass.UNSUPORTED.getLevelCode();
			}
		}
		// if the end of the string is reached, make char class EOS to know when to stop
		// lexing
		else
			charClass = TokenCode.EOS.getLevelCode();
		instructionLength++;
	}

	public void getNonBlank() {
		getChar(); // gets the next non blank character, as blankspaces are skipped
		while ((nextChar == '\n' || nextChar == '\r' || nextChar == ' ') && charClass != TokenCode.EOS.getLevelCode())
			getChar();
	}

	public int getNextToken() {
		return nextToken;
	}

	public int lookupReserved(String s) {
		switch (s) {
		case "and":
			nextToken = TokenCode.AND.getLevelCode();
			break;
		case "or":
			nextToken = TokenCode.OR.getLevelCode();
			break;
		case "xor":
			nextToken = TokenCode.XOR.getLevelCode();
			break;
		case "not":
			nextToken = TokenCode.NOT.getLevelCode();
			break;
		case "leftshift":
			nextToken = TokenCode.LEFTSHIFT.getLevelCode();
			break;
		case "rightshift":
			nextToken = TokenCode.RIGHTSHIFT.getLevelCode();
			break;
		case "add":
			nextToken = TokenCode.ADD.getLevelCode();
			break;
		case "subtract":
			nextToken = TokenCode.SUBTRACT.getLevelCode();
			break;
		case "multiply":
			nextToken = TokenCode.MULTIPLY.getLevelCode();
			break;
		case "halt":
			nextToken = TokenCode.HALT.getLevelCode();
			break;
		case "move":
			nextToken = TokenCode.MOVE.getLevelCode();
			break;
		case "interrupt":
			nextToken = TokenCode.INTERRUPT.getLevelCode();
			break;
		case "jump":
			nextToken = TokenCode.JUMP.getLevelCode();
			break;
		case "compare":
			nextToken = TokenCode.COMPARE.getLevelCode();
			break;
		case "branchifequal":
			nextToken = TokenCode.BRANCHIFEQUAL.getLevelCode();
			break;
		case "branchifgreaterthan":
			nextToken = TokenCode.BRANCHIFGREATERTHAN.getLevelCode();
			break;
		case "branchifnotequal":
			nextToken = TokenCode.BRANCHIFNOTEQUAL.getLevelCode();
			break;
		case "branchifgreaterthanorequal":
			nextToken = TokenCode.BRANCHIFGREATERTHANOREQUAL.getLevelCode();
			break;
		case "push":
			nextToken = TokenCode.PUSH.getLevelCode();
			break;
		case "pop":
			nextToken = TokenCode.POP.getLevelCode();
			break;
		case "call":
			nextToken = TokenCode.CALL.getLevelCode();
			break;
		case "return":
			nextToken = TokenCode.RETURN.getLevelCode();
			break;
		}
		return nextToken;
	}

	public int lex() throws Exception {
		lexLen = 0;
		// gets the first non blank character to skip any extra space
		lexeme = new char[100];
		getNonBlank();
		if (charClass == CharClass.LETTER.getLevelCode()) {// if the first character of the lexeme is a letter, Token
															// must be a register or a keyword
			addChar();
			getChar();
			if (charClass == CharClass.DIGIT.getLevelCode()) { // if the next char of the lexeme is a digit, Token must
																// be a register
				while (charClass != CharClass.BLANKSPACE.getLevelCode() && charClass != TokenCode.EOS.getLevelCode()) {
					addChar();
					getChar();
				}
				String temp = new String(lexeme).trim();
				temp = temp.toUpperCase(); // make sure the register exists
				if (temp.equals("R0") || temp.equals("R1") || temp.equals("R2") || temp.equals("R3")
						|| temp.equals("R4") || temp.equals("R5") || temp.equals("R6") || temp.equals("R7")
						|| temp.equals("R8") || temp.equals("R9") || temp.equals("R10") || temp.equals("R11")
						|| temp.equals("R12") || temp.equals("R13") || temp.equals("R14") || temp.equals("R15")) {
					nextToken = TokenCode.REGISTER.getLevelCode();
				} else
					throw new SyntaxError("Input Command is Unsuported, Register error");
			} else {
				while (charClass == CharClass.LETTER.getLevelCode()) { // the Token must be a keyword, add letters until
																		// the next blank space is found
					addChar();
					getChar();
					if (charClass != CharClass.LETTER.getLevelCode() && charClass != CharClass.BLANKSPACE.getLevelCode()
							&& charClass != TokenCode.EOS.getLevelCode())
						throw new SyntaxError("Input Command is Unsuported, KEYWORD error");
				}
				String temp = new String(lexeme).trim();
				temp = temp.toLowerCase(); // make sure the keyword exists
				if ((temp.equals("and") || temp.equals("or") || temp.equals("xor") || temp.equals("not")
						|| temp.equals("leftshift") || temp.equals("rightshift") || temp.equals("add")
						|| temp.equals("subtract") || temp.equals("multiply") || temp.equals("halt")
						|| temp.equals("move") || temp.equals("interrupt") || temp.equals("jump")
						|| temp.equals("compare") || temp.equals("push") || temp.equals("pop")  
						|| temp.equals("call") || temp.equals("return") || temp.equals("branchifequal") 
						|| temp.equals("branchifgreaterthan") || temp.equals("branchifnotequal") || temp.equals("branchifgreaterthanorequal"))) {
					lookupReserved(temp);
				} else {
					throw new SyntaxError("Input Command is Unsuported, KEYWORD error");
				}
			}
		}
		// if the first char is a digit add the chars to lexeme until the char is not a
		// digit, Token must be a positive number
		else if (charClass == CharClass.DIGIT.getLevelCode()) {
			addChar();
			getChar();
			if (charClass != CharClass.DIGIT.getLevelCode() && charClass != CharClass.BLANKSPACE.getLevelCode()
					&& charClass != TokenCode.EOS.getLevelCode()) {
				throw new SyntaxError("Input Command is Unsuported, Number error");
			}
			while (charClass == CharClass.DIGIT.getLevelCode()) {
				addChar();
				getChar();
				if (charClass != CharClass.DIGIT.getLevelCode() && charClass != CharClass.BLANKSPACE.getLevelCode()
						&& charClass != TokenCode.EOS.getLevelCode()) { // if a non digit is found, the token must be
																		// unsupported
					throw new SyntaxError("Input Command is Unsuported, Number error");
				}
			}
			String temp = new String(lexeme).trim();
			if (Integer.parseInt(temp) > 4095) // make sure the number is not too big
				throw new SyntaxError("Input Command is Unsuported, number cant be larger than 4095");
			else
				nextToken = TokenCode.NUMBER.getLevelCode();
			// if the first char is a sign, the token must be a negative number
		} else if (charClass == CharClass.SIGN.getLevelCode()) {
			addChar();
			getChar();
			if (charClass != CharClass.DIGIT.getLevelCode()) {
				throw new SyntaxError("Input Command is Unsuported, SIGN must be followed by a DIGIT");
			}
			while (charClass == CharClass.DIGIT.getLevelCode()) {
				addChar();
				getChar();
				if (charClass != CharClass.DIGIT.getLevelCode() && charClass != CharClass.BLANKSPACE.getLevelCode()
						&& charClass != TokenCode.EOS.getLevelCode()) { // if a non digit is found, the token must be
																		// unsupported
					throw new SyntaxError("Input Command is Unsuported");
				}
			}
			String temp = new String(lexeme).trim();
			if (Integer.parseInt(temp) < -512) // make sure the number is not too small
				throw new SyntaxError("Input Command is Unsuported, number cant be smaller than -512");
			else
				nextToken = TokenCode.NUMBER.getLevelCode();
		} else if (charClass == CharClass.UNSUPORTED.getLevelCode()) {
			throw new SyntaxError("Input Command is Unsuported");
		}
		// if the end of the string is reached, make lexeme eos to represent the end
		else if (charClass == TokenCode.EOS.getLevelCode()) {
			nextToken = TokenCode.EOS.getLevelCode();
			for (int i = 0; i <= lexeme.length - 1; i++)
				lexeme[i] = 0;
			lexeme[0] = 'E';
			lexeme[1] = 'O';
			lexeme[2] = 'S';
		}
		return nextToken;
	}

}

package Project6;
//Nikita Romanovsky, ICSI404
public class Assembler {

	public static String[]  assemble (String[] command) throws Exception {
		String[] bitCommands = new String[command.length];
		for(int i = 0;  i < command.length; i++) {
			Parser parse = new Parser();
			parse.parseString(command[i]);
			bitCommands[i] = parse.command();
		}
		return bitCommands;
	}
}

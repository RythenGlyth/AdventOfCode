import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        part1();
    }

    public static void part1() {
        Ship ship = new Ship();

        ArrayList<Ship.Instruction> instructions = new ArrayList<Ship.Instruction>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
			String line = reader.readLine();
			while (line != null) {
                instructions.add(new Ship.Instruction(line));
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
        }
        instructions.forEach(instruction -> {
            instruction.apply(ship);
        });
        System.out.println(Math.abs(ship.x) + Math.abs(ship.y));
    }

}
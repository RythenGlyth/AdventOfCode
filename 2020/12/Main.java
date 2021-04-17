import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        List<String> arr = Arrays.asList(args);
        if(arr.contains("part1")) part1();
        if(arr.contains("part2")) part2();
    }

    public static void part1() {
        Ship.Part1 ship = new Ship.Part1();

        ArrayList<Ship.Part1.Instruction> instructions = new ArrayList<Ship.Part1.Instruction>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
			String line = reader.readLine();
			while (line != null) {
                instructions.add(new Ship.Part1.Instruction(line));
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
        }
        instructions.forEach(instruction -> {
            instruction.apply(ship);
        });
        System.out.println("Part 1: " + (Math.abs(ship.x) + Math.abs(ship.y)));
    }

    public static void part2() {
        Ship.Part2 ship = new Ship.Part2();

        ArrayList<Ship.Part2.Instruction> instructions = new ArrayList<Ship.Part2.Instruction>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
			String line = reader.readLine();
			while (line != null) {
                instructions.add(new Ship.Part2.Instruction(line));
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
        }
        instructions.forEach(instruction -> {
            //System.out.println("Waypoint : {" + ship.waypoint.x + ", " + ship.waypoint.y + "}");
            //System.out.println("Ship : {" + ship.x + ", " + ship.y + "}");
            instruction.apply(ship);
            //System.out.println("instruction : " + instruction.cmd + ", " + instruction.amount);
        });
        //System.out.println("Waypoint : {" + ship.waypoint.x + ", " + ship.waypoint.y + "}");
        //System.out.println("Ship : {" + ship.x + ", " + ship.y + "}");
        System.out.println("Part 2: " + (Math.abs(ship.x) + Math.abs(ship.y)));
    }
}
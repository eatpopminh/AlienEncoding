//Due April 23
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;





public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Use Tree NOT binary tree to get more than two leaf on one root.
		List<String> lines = Files.readAllLines(Paths.get("input.txt"));
		int freq = Integer.parseInt(lines.get(0));
		
		TreeMap data = new TreeMap<Integer, String>();
		
		for(int i = 1 ; i<lines.size() ; i++)
		{
			System.out.println(lines.get(i).split(" ")[0] + " " + Integer.parseInt(lines.get(i).split(" ")[1]));
			
			data.put(Integer.parseInt(lines.get(i).split(" ")[1]), lines.get(i).split(" ")[0]);
		}
		
		
		

		
	
		
	}

}

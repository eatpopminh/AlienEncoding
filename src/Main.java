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
		int firstNum = Integer.parseInt(lines.get(0));
		 
		ArrayList<letter_freq> data = new ArrayList<letter_freq>();
		for(int i  = 1; i<lines.size();i++)
		{
			letter_freq lf = new letter_freq(lines.get(i).split(" ")[0], Integer.parseInt(lines.get(i).split(" ")[1]));
			data.add(lf);
		}
		
//		for(int i  = 0; i<lines.size()-1;i++)
//		{
//			System.out.println(data.get(i).letter);
//		}
		
		//sort everything by freq.
		quickSort(data,0,456975);		
		for(int i  = 0; i<lines.size()-1;i++)
		{
			System.out.println(data.get(i).letter+ " "+data.get(i).freq);
		}
		//
		
	}
	  public static int partition(ArrayList<letter_freq> arr, int l, int h) 
	    { 
	        int pivot = arr.get(h).freq;  
	        int i = (l-1); 
	        for (int j=l; j<h; j++) 
	        { 
	            if (arr.get(j).freq < pivot) 
	            { 
	                i++; 
	                letter_freq temp = arr.get(i);
	                arr.set(i,arr.get(j));
	                arr.set(j, temp); 
	            } 
	        } 
	        letter_freq temp = arr.get(i+1); 
	        arr.set(i+1, arr.get(h));
	        arr.set(h, temp);
	  
	        return i+1; 
	    } 
	public static void quickSort(ArrayList<letter_freq> arr, int l, int h) 
    { 
        if (l < h) 
        { 
            int temp = partition(arr, l, h); 
  
            quickSort(arr, l, temp-1); 
            quickSort(arr, temp+1, h); 
        } 
    } 

}

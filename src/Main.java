//Due April 23
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
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
		ArrayList<String> letter = new ArrayList<String>();
		ArrayList<Integer> freq = new ArrayList<Integer>();
		for(int i  = 1; i<lines.size();i++)
		{
			letter_freq lf = new letter_freq(lines.get(i).split(" ")[0], Integer.parseInt(lines.get(i).split(" ")[1]), firstNum);
			data.add(lf);
			letter.add(lines.get(i).split(" ")[0]);
			freq.add(Integer.parseInt(lines.get(i).split(" ")[1]));
		}
		
		
		//sort everything by freq.
		quickSort(data,0,456975);		
		for(int i  = 0; i<lines.size()-1;i++)
		{
			//System.out.println(data.get(i).letter+ " "+data.get(i).freq);
		}
		
		Queue<letter_freq> pq1 = new LinkedList<letter_freq>(); 
		Queue<letter_freq> pq2 = new LinkedList<letter_freq>();
		ArrayList<letter_freq> pq_list = new ArrayList<letter_freq>();
		//adding everything to queue.
		for(int i  = 0; i<lines.size()-1;i++)
		{
			pq1.add(data.get(i));
		}
		//testing if data is in pq1.
//		for(int i  = 0; i<lines.size()-1;i++)
//		{
//			letter_freq temp = pq1.poll();
//			//System.out.println(temp.letter + " " + temp.freq);			
//		}
		//check if pq2 is empty.
		if(pq2.isEmpty())
		{
			pq_is_empty(pq1,pq_list,firstNum);
			pq2.add(combine_lowest(pq_list,firstNum));
		}
		letter_freq temp = pq2.poll();
		System.out.println(temp.letter + " "+ temp.freq);
		
		
		
		
		
		
		}
	public static letter_freq combine_lowest(ArrayList<letter_freq> pq_list, int firstNum)
	{
		letter_freq temp = new letter_freq();
		temp.transfer_array(pq_list);
		temp.print_array();
		
		return temp;
		
	}
	public static void pq_is_empty(Queue<letter_freq> pq1, ArrayList<letter_freq> pq_list, int firstNum)
	{
		for(int i = 0;i<firstNum;i++)
		{
			letter_freq temp = pq1.poll();
			System.out.println(temp.letter + " " + temp.freq);
			pq_list.add(temp);
			
		}
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

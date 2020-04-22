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
	public static int a = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Use Tree NOT binary tree to get more than two leaf on one root.
		List<String> lines = Files.readAllLines(Paths.get("input.txt"));
		int firstNum = 2;//Integer.parseInt(lines.get(0));
		 
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
		//456975
		quickSort(data,0,4);	
		int total = 0;
		for(int i  = 0; i<lines.size()-1;i++)
		{
			System.out.println(data.get(i).letter+ " "+data.get(i).freq);
			total+=data.get(i).freq;
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
		
		int aaa = 0;
		while(!(pq1.isEmpty() && pq2.size()==1))
		//for(int i =0;i<38080;i++)
		{
			//check if pq2 is empty.
			add_min_to_array(pq1, pq2, pq_list, firstNum);
//			System.out.println(aaa);
//		aaa++;
			
		}
//		System.out.println(pq2.poll().letter);
		System.out.println(pq2.peek().freq);
		System.out.println("Hello the total is: " + total);
//			System.out.println(pq2.peek().letter);
//			System.out.println(pq2.peek().freq);
			
		
		letter_freq temp = pq2.poll();
//		System.out.println(temp.data.get(0).freq + " " + temp.data.get(1).freq);
//		System.out.println(temp.data.get(1).data.get(1).freq);
//		System.out.println("------------------------------");
//		System.out.println(temp.data.size());
//		System.out.println(temp.data.get(1).data.size());
//		System.out.println(temp.data.get(1).data.get(0).data.size());
		traveral(temp);
		System.out.println("DONE");
		
		}
	public static void traveral(letter_freq lf)
	{
		int size = lf.data.size();
		
		for(int i = 0;i<size;i++)
			traveral(lf.data.get(i));
		System.out.println(lf.freq+ "/"+lf.letter);
		//traveral(lf.data.get(size-1));
		
	}
	public static void traveral2(letter_freq lq)
	{
		for(int i =0;i<1000;i++)
		{
			letter_freq temp = lq;
			
		}
	}
	public static void add_min_to_array(Queue<letter_freq> pq1, Queue<letter_freq> pq2, ArrayList<letter_freq> pq_list, int firstNum)
	{
		
			//for(int i = 0 ;i<firstNum;i++)
			while(!(pq_list.size()==firstNum))
			{
				if(pq2.isEmpty())
				{
					pq_list.add(pq1.poll());
				}
				if(pq1.isEmpty())
				{
					pq_list.add(pq2.poll());
				}
				if(!pq2.isEmpty() && !pq1.isEmpty())				
				{
					if(pq1.peek().freq <= pq2.peek().freq)
					{
						pq_list.add(pq1.poll());
					}
					else
					{
						pq_list.add(pq2.poll());
					}
				}
			}	

			pq2.add(combine_lowest(pq_list));
			pq_list.clear();
			
	}

	public static letter_freq combine_lowest(ArrayList<letter_freq> pq_list)
	{
		letter_freq temp = new letter_freq();
		temp.transfer_array(pq_list);
		return temp;
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

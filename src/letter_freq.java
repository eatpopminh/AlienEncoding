import java.util.ArrayList;
import java.util.Queue;

public class letter_freq {
	
	public String letter;
	public int freq;
	public ArrayList<letter_freq> data = new ArrayList<letter_freq>();
	public int num;
	
	public letter_freq()
	{
		letter = "";
		freq = 0;
	}
	public letter_freq(String l)
	{
		letter = l;
		freq = 0;
	}
	public letter_freq(String a, int b, int c)
	{
		letter = a;
		freq = b;
		num = c;
	}
	public void adding_freq_letter_array()
	{
		for(int i = 0 ;i<data.size();i++)
		{
			freq+=data.get(i).freq;
			//letter+=data.get(i).letter;
		}
	}
	public void transfer_array(ArrayList<letter_freq> pq_list)
	{
		for(int i = 0 ;i<pq_list.size();i++)
		{
			data.add(pq_list.get(i));
		}
		adding_freq_letter_array();
					
	}
	
	
	public void print_array()
	{
		System.out.println("--------------------------------------------");
		for(int i = 0 ; i < data.size();i++)
		{
			System.out.println(data.get(i).letter + " " + data.get(i).freq);
		
		}
		
	}
	
}

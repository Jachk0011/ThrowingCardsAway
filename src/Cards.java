import java.io.*;

public class Cards {
	
	static Queue q = new Queue(), r1 = new Queue();
		
	public void readFile()
	{		
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try 
		{
			file = new File ("test1.txt");
			fr = new FileReader (file);
			br = new BufferedReader(fr);	
			
			String line = br.readLine();
			int size = 0;
			int[] queue = null;
			while(Integer.parseInt(line) != 0)
			{
				size = Integer.parseInt(line);
				queue = new int[size];
				for(int i = 0; i < queue.length; i++)
					q.enqueue(new Node(i+1));		
				
						
				while(q.sizeQueue()>=2)
				{
					r1.enqueue(q.dequeue());
					q.enqueue(q.dequeue());								
				}
				
				System.out.print("\nDiscarded cards: ");			
				r1.printQueue();
				System.out.print("\nRemaining card: " + q.dequeue().toString());
				
				
				Node tmp = r1.getHead();
				while(tmp.next != null)
				{
					tmp = tmp.next;
					r1.dequeue();
					
				}
				r1.dequeue();	
				
				line = br.readLine();
			}
		}
		catch(Exception e)
	    {
			e.printStackTrace();
	    }
		finally
		{	         
			try{                    
			    if( fr != null )   
			       fr.close();			                      
			 }catch (Exception e2){ 
			    e2.printStackTrace();
			 }
		}	
	}
	
	public static void main(String[] args)  {
		
		Cards card = new Cards();		
		card.readFile();
	}
}

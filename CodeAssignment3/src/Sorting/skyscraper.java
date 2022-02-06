package Sorting;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class skyscraper {
	
		static Queue<Day> queue=new LinkedList<>();
		static Queue<Day> tempqueue=new LinkedList<>();
		
		//Method Creation Started
		static void createQueue(int days)
		{
			Day temp = null;
			
			for(int j=1;j<=days;j++)
			{
				System.out.println("\nDay : "+j);
				while(!queue.isEmpty()) {
					temp=queue.peek();
				if(temp.day<=j)
				{
					System.out.print(temp.size + " ");
					queue.poll();
				}
				
				else
				{
					break;
				}
			}}
		}

		 static void insertQueue(Day d) 
		{		
			if(queue.isEmpty())
				queue.add(d);
			else
			{
				allTotempqueue();
				Day d1;
				
				while(!tempqueue.isEmpty()) 
				{
					d1=tempqueue.peek();
					if(d1.size>d.size)
						queue.add(tempqueue.poll());
					else
					{
						queue.add(d);
						allToqueue();
						d=null;
					}
				}
				
				if(d!=null)
					queue.add(d);
			}
				
		}
		 
		//Method to copy all elements to temporary queue
		 static void allToqueue() 
		{
			while(!tempqueue.isEmpty())
				queue.add(tempqueue.poll());
			
		}

		 //Method to copy all elements to temporary queue
		static void allTotempqueue() 
		{
				while(!queue.isEmpty())
					tempqueue.add(queue.poll());
			
		}

		//Created subclass for instance creation
		static class Day
		{
			int size;
			int day;
			Day(int s,int d)
			{
				size=s;
				day=d;
			}
		}

		//Main Method
		public static void main(String[] args) {
			
			Scanner sc=new Scanner(System.in);
			Day daily;
			
			System.out.println("Please Enter Number of Days : ");
			int days=sc.nextInt();
			int floorNum;
			
			for(int i=1;i<=days;i++)
			{
				System.out.println("Please Enter Floor Size on Given Day : " + i);
				floorNum=sc.nextInt();
				daily=new Day(floorNum,i);
				insertQueue(daily);
			}
			    createQueue(days);
			    sc.close();
			}
		
		

	}

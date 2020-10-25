package packEx5;
import java.util.ArrayList;

public class MainExercise5 
{
	private ArrayList<Long> elapsedTimeAL = new ArrayList<Long>(); 
	private int[] array1;
	private int[] array2;
	private int[] array3;
	private int[] array4;
	private int[] array5;
	private int[] array6;
	private int[] array7;
	private int[] array8;
	private long elapsedTime;
		

	public static void main(String[] args) 
	{
		MainExercise5 m = new MainExercise5();
	
//Generating random arrays and storing them in array of ints variables. randomArray() takes an argument that decides the length of the array.
//Input the length between 1-100 for best results.
		m.array1 = 	m.randomArray(10);
		m.array2 = 	m.randomArray(5);
		m.array3 = 	m.randomArray(8);
		m.array4 = 	m.randomArray(7);
		m.array5 = 	m.randomArray(25);
		m.array6 = 	m.randomArray(7);
		m.array7 = 	m.randomArray(38);
		m.array8 = 	m.randomArray(100);
		
//Here the unsorted and sorted arrays are displayed using the displayArray().
//The insertionSort() is chained into this method. 
		
		m.displayArray(m.array1);
		m.displayArray(m.array2);
		m.displayArray(m.array3);
		m.displayArray(m.array4);
		m.displayArray(m.array5);
		m.displayArray(m.array6);
		m.displayArray(m.array7);
		m.displayArray(m.array8);
		
//The elapsed time that it took to sort each array of numbers is calculated and stored within the elapsedTimeAL ArrayList.
// ArrayLists have a sorting method which is used here to sort the elapsed times in order from fastest to slowest.
		m.elapsedTimeAL.sort(null);
		System.out.println("This is the various lengths of time "
				+ "(in nanoseconds) it took to sort the 8 randomly generated arrays - sorted from fastest to slowest: " 
				+  m.elapsedTimeAL);
	}
//randomArray has a parameter called randomLength, that takes an int argument.	
	public int[] randomArray(int randomLength)
	{
		int i;
        int[] ar1 = new int[randomLength];
        for(i = 0; i <  ar1.length; i++) 
        {
            ar1[i] = (int) (Math.random() * 100);
        }
        return ar1;
	}
	
	public void displayArray(int[] array)
	{
		System.out.println("Array BEFORE the sort:");
		
		for(int i = 0; i<array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
		System.out.println("Array AFTER the sort:");
		
		elapsedTime = insertionSort(array);
		elapsedTimeAL.add(elapsedTime);
		
		for(int i = 0; i<array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
		System.out.println("The sorting of this array took " + elapsedTime + " nanoseconds.");
		
	}
	
//The insertion sort method that also measures how long the sorting took. 
//elapsedTime value is passed to the displayArray method.
	
	public long insertionSort(int[] array)
	{
		long startTime = System.nanoTime();//measuring the time prior to the sorting
		
		for (int i = 1; i < array.length; i++)
		{
			int current = array[i];
			int j = i - 1;

			while(j >= 0 && current < array[j])//this repeats until the number that we have picked from the array is in its right place
			{
				array[j+1] = array[j];
				j--;
			}
			// at this point we have exited the while loop. 
			// So j is either -1
			// or it's at the first element where current >= a[j]
			array[j+1] = current;
		}
		
		long endTime = System.nanoTime();//measuring time after the sorting
		long elapsedTime = (endTime - startTime);//calculating elapsed time
		return elapsedTime;
	}
	
}//end of class

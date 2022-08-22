//Array Programs - ArrayInsertion, ArrayDeletion, DisplayArray, LinearSearch, BinarySearch, BubbleSort

import java.util.*;
public class Array{
	static int [] array;  //array
	static int size;      //size increases as elements are filled in the array.	
	
	public Array(){
		array=new int[100]; //length of array = 100
		size=0;
	}

	public static int [] insert(int numbertoinsert, int indextoinsertat){
		//check if array is full or not.
		if(size>=array.length){
			System.out.println("Array Full!");
			return null;
		}
		if(indextoinsertat<0){
			System.out.println("Invail Size value ");
			return null;
		}
		
		//shift elements towards right from indextoinsertat.
		//for(int i=size+1; i>indextoinsertat; i--){
		//	array[i] = array[i-1];
		//}
		for(int i=0;i<array.length;i++)
		{
			if (i==indextoinsertat)
			{
				//insert the given element.
				array[indextoinsertat]=numbertoinsert;
			break;
			}
			
		}

		// increase the size of the array.
		size++; 
		return array;
	}
	
	
	static public int [] delete( int indextodeleteAt){
		//check if index is valid.
		if(indextodeleteAt<0 || indextodeleteAt>array.length-1){
			System.out.println("Invalid Size!");
			return null;
		}
		
		//shift elements towards left from last element till indextodeleteAt.	
		for(int i=indextodeleteAt; i<array.length-1; i++){
			array[i]=array[i+1];
		}
		array[array.length-1] = -1;
		return array;
	}

	
	
	
	
	
	//function to display the array.
	static public void display(){
		for(int i=0;i<size;i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	//function to do Linear Search on the array.
	static public boolean linearSearch(int number){
		for(int i=0;i<size;i++){
			if(number==array[i]){
				return true;
			}
		}
		return false;
	}

	//fuction to sort the array.
	static public void bubbleSort(){
		for(int i=0;i<size-1;i++){
			for(int j=0;j<size-i-1;j++){
				if(array[j]>array[j+1]){
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
	}
				
	public int getvalueAt(int i)
	{
		return array[i];
	}
	//function to to Binary Search on the array.
	static public boolean binarySearch(int number,int low, int high){
		if(low>high){
			return false;
		}
		int mid=low + (high-low)/2;
		if(array[mid]==number){
			return true;
		}
		if(array[mid]>number){
			return binarySearch(number,low,mid-1);
		}
		else{
			return binarySearch(number,mid+1,high);
		}
		
	}

	
}
	
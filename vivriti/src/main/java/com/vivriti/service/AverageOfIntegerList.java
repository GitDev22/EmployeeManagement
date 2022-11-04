package com.vivriti.service;

import java.util.Arrays;
import java.util.List;
/*
 * Question no 2
 * This class will be calculating the avarage of list of integers
 */
public class AverageOfIntegerList {

	public static void main(String []args){
	      List<Integer> list = Arrays.asList(10, 20, 50, 100, 130, 150, 200, 250, 500);
	      int sum = 0;
	      for (int i : list) {
	         sum+=i;
	      }
	      if(list.isEmpty()){
	         System.out.println("Empty list!");
	      } else {
	         System.out.println("Average = " + sum/(float)list.size());
	      }
	      
	     }
	
	

}

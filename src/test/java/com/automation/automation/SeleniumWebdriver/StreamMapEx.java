package com.automation.automation.SeleniumWebdriver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

@Test
public class StreamMapEx {
	@Test(priority = 1)
	public void StreamMapExample(){
		System.out.println(getClass().getDeclaredMethods()[1].toString());
		System.out.println("--------------------------------------------------------------------");
		List<String> ele = Arrays.asList("Anoop","Abhilash","Nitesh","Amit","Ram");
		//to update use map method
		ele.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
	}
	@Test(priority = 2)
	public void SortedMapEx() {
		System.out.println(getClass().getDeclaredMethods()[2].toString());
		System.out.println("--------------------------------------------------------------------");
		List<String> ele = Arrays.asList("Anoop","Abhilash","Nitesh","Amit","Ram1");
		ele.stream().sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}
	@Test(priority = 3)
	public void streamCollectEx() {
		System.out.println(getClass().getDeclaredMethods()[3].toString());
		System.out.println("-------------------------Collect your result and covert to list-------------------------------------------");
		List<String> ele = Arrays.asList("Anoop","Abhilash","Nitesh","Amit","Ram1");
		//filter the updating and adding to new collections 
		List<String> newEle =  ele.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).collect(Collectors.toList()); 	
		//Print the first result
		System.out.println(newEle.get(0));
	}
	@Test (priority = 4)
	public void streamDistinctNumber() {
		System.out.println(getClass().getDeclaredMethods()[4].toString());
		System.out.println("-------------------------Collect your result and covert to list-------------------------------------------");
		List<Integer> value = Arrays.asList(1,5,69,7,4,5,6,8,8);
		value.stream().distinct().sorted().forEach(s->System.out.println(s));
		List<Integer> sortedList =  value.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("===3rd Element from the sorted list "+sortedList.get(2));
		
	}

}

package com.automation.automation.SeleniumWebdriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> name = new ArrayList<>();
		name.add("Amit");
		name.add("Rahul");
		name.add("Abhilash");
		name.add("rohit");
		name.add("Anoop");
		//arrow method 
		System.out.println(name.stream().filter(s->s.startsWith("A")).count());
		System.out.println("------------------------------------------------------------------------");
		//other way to add steam
		System.out.println(Stream.of("Amit","Amrit","Ajay","Anoop","Akash").filter(s -> s.startsWith("A")).count());
		System.out.println("------------------------------------------------------------------------");
		//print all the result with length more than 4
		Stream.of("Amit","Amrit","Ajay","Anoop","Akash").filter(s->s.length() > 4).forEach(s->System.out.println(s));
		System.out.println("------------------------------------------------------------------------");
		//print only one result with length more than 4
		Stream.of("Amit","Amrit","Ajay","Anoop","Akash").filter(s->s.length() > 4).limit(1).forEach(s->System.out.println(s));
		
	}

}

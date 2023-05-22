package com.sample.java.develop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class TestsValues {

	public static void main(String [] args) {
	List<Integer> values= new ArrayList<>(Arrays.asList(40, 32, 80, 30, 90, 81, 15));
	values.stream().filter(e->e%2!=0).collect(Collectors.toList()).forEach(System.out::println);
	int max =values.stream().mapToInt(x->x).summaryStatistics().getMax();
	int min = values.stream().mapToInt(x->x).summaryStatistics().getMin();
	Map<String,Integer> mapVal=new HashMap<>();
	for(int i=0;i<values.size();i++) {
		
		for(int j=i+1;j<values.size();j++) {
		int differene=values.get(i) - values.get(j);
		mapVal.put(i+" "+j+"diff", differene);
		}
		
	}
	
	OptionalInt maxDiff= mapVal.entrySet().stream().filter(entry->entry.getValue()!=null).mapToInt(x->x.getValue()).max();
	if(maxDiff.isPresent()) {
	int maxVal= maxDiff.getAsInt();
	System.out.println(maxVal);
	}
	}
	
	
	
	
	//selling price and buying price
	
	
	
}

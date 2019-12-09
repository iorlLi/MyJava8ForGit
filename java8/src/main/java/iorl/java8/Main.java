package iorl.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		
		List<Apple> apples = Arrays.asList(new Apple(1, 120),new Apple(1, 160), new Apple(0, 160),new Apple(0, 110), new Apple(2, 110));
		//行为参数化  
		List<Apple> greenApples = filterApples(apples, new AppleColorPredicate());
		System.out.println(greenApples);
		List<Apple> weightApples = filterApples(apples, new AppleWeightPredicate());
		System.out.println(weightApples);
		//匿名内部类
		List<Apple> yellowApples = filterApples(apples, new ApplePredicate() {
			@Override
			public boolean test(Apple apple) {
				return apple.getColor().equals(new Integer(2));
			}
		});
		System.out.println(yellowApples);
		
		//lambda
		List<Apple> result = filterApples(apples, (Apple apple) -> apple.getColor().equals(new Integer(1)));
		System.out.println(result);
		//lambda
		List<Apple> result2 = filter(apples, (Apple apple) ->  apple.getColor().equals(new Integer(1)));
		System.out.println(result2);
		
		System.out.println("------排序---");
		//匿名内部类 anonymous inner class
		apples.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple apple1, Apple apple2) {
				//根据重量 : weight
				//再根据颜色 next:color
				return apple1.getColor() == apple2.getColor()?apple1.getWeight().compareTo(apple2.getWeight()):apple1.getColor().compareTo(apple2.getColor());
				/*
				 * int result ; if(apple1.getWeight() > apple2.getWeight()) { result = 1; }else
				 * if(apple1.getWeight() < apple2.getWeight()) { result = -1; }else { return
				 * apple1.getColor().compareTo(apple2.getColor()); } return result;
				 */
			}
		});
		System.out.println(apples);
		Collections.shuffle(apples);
		System.out.println("-----shuffle apples-----");
		System.out.println(apples);
		apples.sort((Apple apple1, Apple apple2) ->apple1.getColor() == apple2.getColor() ? 
					apple1.getWeight().compareTo(apple2.getWeight()):apple1.getColor().compareTo(apple2.getColor()));
		System.out.println(apples);
	}

	public static <T> List<T> filter(List<T> list, ApplePredicate2<T> filter) {
		
		List<T> results = new ArrayList<>();
		for (T t : list) {
			if (filter.test( t)) {
				results.add( t);
			}
		}
		return results;
	}
	@FunctionalInterface
	static interface  ApplePredicate2<T>{
		boolean test(T t);
	}
	public static List<Apple> filterApples(List<Apple> sourceApples, ApplePredicate filter) {
		
		List<Apple> results = new ArrayList<>();
		for (Apple apple : sourceApples) {
			if (filter.test(apple)) {
				results.add(apple);
			}
		}
		return results;
	}
}

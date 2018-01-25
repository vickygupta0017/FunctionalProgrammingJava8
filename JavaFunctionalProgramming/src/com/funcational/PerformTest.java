package com.funcational;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.Entity.Ball;

public class PerformTest {

	//1
	public List<Ball> filterByColor(List<Ball> inventory, String color){
		List<Ball> filteredInventory = new ArrayList<>();
		for(Ball ball:inventory) {
			if(color.equals(ball.getColor())) {
				filteredInventory.add(ball);
			}
		}
		return filteredInventory;
	}
	
	//2
	
	public List<Ball> filterBalls(List<Ball> inventory, String color,
			int weight, boolean flag){
		List<Ball> filteredInventory = new ArrayList<>();
		for(Ball ball:inventory) {
			if((flag && color.equals(ball.getColor())) || (!flag && ball.getWeight()>weight)) {
				filteredInventory.add(ball);
			}
		}
		return filteredInventory;
	}
	
	//3
	
	
	public List<Ball> filterBalls(List<Ball> inventory,Filter filter, Object obj){
		List<Ball> filteredInventory = new ArrayList<>();
		for(Ball ball:inventory) {
			if(filter.perform(ball, obj)) {
				filteredInventory.add(ball);
			}
		}
		return filteredInventory;
	}
	
	
	/*public static void main(String[] args) {
		List<Ball> inventory =  Arrays.asList(new Ball("green",2),new Ball("red",1), new Ball("orange",3));
		List<Ball> filteredInventory = 
				new PerformTest().
					filterBalls(inventory, new WeightFilter(), new Integer(2));
		for(Ball ball: filteredInventory) {
			System.out.println(ball.getColor());
		}
	}*/
	
	
	//4
	/*public static void main(String[] args) {
		List<Ball> inventory =  Arrays.asList(new Ball("green",2),new Ball("red",1), new Ball("orange",3));
		List<Ball> filteredInventory = 
				new PerformTest().
					filterBalls(inventory,
							new Filter() {

								@Override
								public boolean perform(Ball ball, Object weight) {
									return ball.getWeight()>(int)weight;
								}
						
					},
							
							new Integer(2));
		
		for(Ball ball: filteredInventory) {
			System.out.println(ball.getColor());
		}
	}*/
	
	//5 

	public static List<Ball> filterBallsByLambda(List<Ball> inventory,Predicate<Ball> p){
		List<Ball> filteredInventory = new ArrayList<>();
		for(Ball ball:inventory) {
			if(p.test(ball)) {
				filteredInventory.add(ball);
			}
		}
		return filteredInventory;
	}
	
	public static boolean isRed(Ball ball) {
		return "red".equals(ball.getColor());
	}
	
	public static void main3(String[] args) {
		List<Ball> inventory =  Arrays.asList(new Ball("green",2),new Ball("red",1), new Ball("orange",3));
		/*List<Ball> filteredInventory =  filterBallsByLambda(inventory, 
					(Ball ball) -> "red".equals(ball.getColor())
					);*/
		
		List<Ball> filteredInventory =  filterBallsByLambda(inventory, PerformTest::isRed);
		
		for(Ball ball: filteredInventory) {
			System.out.println(ball.getColor());
		}
	}

	//6
	public static void main(String a[]) {
		List<Ball> inventory =  Arrays.asList(new Ball("green",2),new Ball("red",1), new Ball("orange",3));
		List<Ball> filteredInventory = inventory.stream().filter(PerformTest::isRed)
		.collect(Collectors.toList());
		for(Ball ball: filteredInventory) {
			System.out.println(ball.getColor());
		}
	}
	
	
}

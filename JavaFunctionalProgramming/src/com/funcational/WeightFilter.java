package com.funcational;

import com.Entity.Ball;

public class WeightFilter implements Filter<Integer>{
	@Override
	public boolean perform(Ball ball, Integer weight) {
		return ball.getWeight()>weight;
	}
}

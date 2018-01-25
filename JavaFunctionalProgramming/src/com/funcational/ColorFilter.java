package com.funcational;

import com.Entity.Ball;

public class ColorFilter implements Filter<String>{
	@Override
	public boolean perform(Ball ball, String color) {
		return color.equals(ball.getColor());
	}
}

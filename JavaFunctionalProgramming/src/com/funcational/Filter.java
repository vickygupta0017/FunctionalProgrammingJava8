package com.funcational;

import com.Entity.Ball;

interface Filter<T>{
	public boolean perform(Ball ball, T obj);
}

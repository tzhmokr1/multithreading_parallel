package com.balazsholczer.udemy;

import java.util.concurrent.ForkJoinPool;

public class App {

	public static void main(String[] args) {
		
		ForkJoinPool forkJoinPool = new ForkJoinPool(); // 'Runtime.getRuntime().availableProcessors()' is not needed as set by default
		SimpleRecursiveAction simpleRecursiveAction = new SimpleRecursiveAction(400);
		forkJoinPool.invoke(simpleRecursiveAction);
		
		
	}
}

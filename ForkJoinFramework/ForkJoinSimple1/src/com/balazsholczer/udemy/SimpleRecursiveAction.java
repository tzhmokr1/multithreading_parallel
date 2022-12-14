package com.balazsholczer.udemy;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {

	private int simulatedWork;

	public SimpleRecursiveAction(int simulatedWork) {
		this.simulatedWork = simulatedWork;
	}

	@Override
	protected void compute() {

		if (simulatedWork > 100) {

			System.out.println("Parallel execution and split the tasks..." + simulatedWork);

			SimpleRecursiveAction simpleRecursiveAction1 = new SimpleRecursiveAction(simulatedWork / 2);
			SimpleRecursiveAction simpleRecursiveAction2 = new SimpleRecursiveAction(simulatedWork / 2);

			// simpleRecursiveAction1.fork(); // insert into ForkJoinPool
			// simpleRecursiveAction2.fork(); // insert into ForkJoinPool
			// simpleRecursiveAction1.join(); // wait
			// simpleRecursiveAction2.join(); // wait

			invokeAll(simpleRecursiveAction1, simpleRecursiveAction2); // same as .fork() and .join()

		} else {
			System.out.println("No need for parallel execution, sequential is OK for this task..." + simulatedWork);
		}
	}
}

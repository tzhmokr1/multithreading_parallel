package com.librarayproject;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {

	private int id;
	private Lock lock;

	public Book(int id) {
		this.lock = new ReentrantLock();
		this.id = id;
	}

	public void read(Student student) throws InterruptedException {
		if(lock.tryLock(10, TimeUnit.SECONDS)) {
			System.out.println(student + " starts reading " + this);
			Thread.sleep(2000); // read book
			lock.unlock();
			System.out.println(student + " has finished reading " + this);
		}
	}

	public String toString() {
		return "Book" + id;
	}
}
package com.globalsoftwaresupport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) throws IOException {

		List<Book> books = new ArrayList<>();
		books.add(new Book("Being and Time", "Heidegger", 560, Type.PHILOSOPHY));
		books.add(new Book("The Trial", "Franz Kafka", 240, Type.NOVEL));
		books.add(new Book("Death on The Nile", "Agatha Christie", 370, Type.THRILLER));
		books.add(new Book("Ancient Greece", "Robert F.", 435, Type.HISTORY));
		books.add(new Book("Ancient Rome", "Robert F.", 860, Type.HISTORY));
		books.add(new Book("Death of Virgil", "Hermann Broch", 590, Type.NOVEL));
		books.add(new Book("The Stranger", "Albert Camus", 560, Type.NOVEL));

		// grouping by type
		Map<Type, List<Book>> booksByTypeMap = books.stream().collect(Collectors.groupingBy(Book::getType));

		booksByTypeMap.entrySet().stream().forEach(System.out::println);

		// finding 2 longest books (with more than 500 pages) (number of pages)
		List<String> longestBooks = books.stream().filter(p -> p.getPages() > 500)
				// .sorted(Comparator.comparing(Book::getAuthor))
				.map(Book::getTitle).limit(2)
				.collect(Collectors.toList());

		longestBooks.stream().forEach(System.out::println);

		// select all the book where the title is made up of exactly 2 words.
		books.stream().filter(b -> b.getTitle().split(" ").length == 2)
				.collect(Collectors.toList())
				.forEach(System.out::println);

		// process files with streams
		String path = "/multithreading_parallel/Streams/Streams/src/com/globalsoftwaresupport/names";
		Stream<String> nameStream = Files.lines(Paths.get(path));
		List<String> list = nameStream.collect(Collectors.toList());
		list.forEach(System.out::println);
	}
}

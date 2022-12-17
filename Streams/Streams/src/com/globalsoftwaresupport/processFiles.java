package com.globalsoftwaresupport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class processFiles {

	public static void main(String[] args) throws IOException {

		// process files with streams
		String path = "/multithreading_parallel/Streams/Streams/src/com/globalsoftwaresupport/names";
		Stream<String> nameStream = Files.lines(Paths.get(path));
		List<String> list = nameStream.collect(Collectors.toList());
		list.forEach(System.out::println);
	}
}

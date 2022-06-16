package com.misc.javadocs.io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;

public class NIO_Main {
	
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("D:\\etc\\test.txt");
		Files.copy(path, Paths.get("D:\\etc\\test_2.txt"),REPLACE_EXISTING);
		System.out.println(Files.isSameFile(path, path));
		
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		for (Path name: dirs) {
		    System.err.println(name);
		}
		//Files.createDirectories(Paths.get("D:\\etc\\test"));
		
		DirectoryStream<Path> dir = Files.newDirectoryStream(Paths.get("D:\\etc\\"));
		for(Path p:dir) {
			System.out.println(p.toString());
		}
		
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{java,class,txt}");
		
		if(matcher.matches(Paths.get("test"))) {
			System.out.println("Found");
		}
		/*
		 * Charset charset = Charset.forName("US-ASCII"); BufferedReader reader =
		 * Files.newBufferedReader(path,charset); String s="";
		 * while((s=reader.readLine())!=null) { System.out.println(s); }
		 */
	}
}

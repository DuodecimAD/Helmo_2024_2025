package AoC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class day11 {

	public static void main(String[] args) {
		
		//part1();
		//part2();
		part2AfterSomeHelmoPooClasses();

	}
	
	public static void part1() {
		
		
		
		ArrayList<Long> a = new ArrayList<>(Arrays.asList(3279L, 998884L, 1832781L, 517L, 8L, 18864L, 28L, 0L));
		
		//System.out.println(a);
		
		for (int i = 0; i < 75; i++) {
			long startTime = System.nanoTime();
			ArrayList<Long> b = new ArrayList<Long>();
			
			for (int j = 0; j < a.size(); j++) {
				
				String numberStr = String.valueOf(a.get(j));
				int length = numberStr.length();
				int middle = length / 2;
				
				if (a.get(j) == 0) {
					b.add(1L);
				} else if (length % 2 == 0) {
					b.add(Long.parseLong(numberStr.substring(0, middle)));
					b.add(Long.parseLong(numberStr.substring(middle)));
				} else if (length % 2 == 1) {
					b.add(a.get(j) * 2024);
				} else {
					System.out.println("Error");
				}
				
			}
			//System.out.println(b);
			a = b;
			System.out.println(i + "size : " + a.size());
			long endTime = System.nanoTime(); 
	        long duration = (endTime - startTime) / 1000000;
	        System.out.println("Duration : " + duration/1000.00 + " sec ");
		}
		
	}

	/** Got heap overflow on first try, so i tried to write to file instead but it was way too slow
	 *  arrived at loop 46 that took by itself about 15 minutes to complete.
	 *  Guess if i had the patience i would use memory for calculations but do it as batches to avoid heap overflow.
	 * 
	 */
	public static void part2() {
		
		String PathA = "data/day11textA.txt";
		String PathB = "data/day11textB.txt";
		int batchSize = 10000;
		int totalTime= 0;
		
		File fileA = new File(PathA);

		try {
		    if (fileA.exists()) {
		        fileA.delete();
		    }
		    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileA))) {
		        writer.write("3279\n998884\n1832781\n517\n8\n18864\n28\n0");
		    }

		    for (int i = 0; i < 75; i++) {
		    	long startTime = System.nanoTime();
		        File fileB = new File(PathB);
		        if (fileB.exists()) {
		            fileB.delete();
		        }

		        try (
		                BufferedReader readerA = new BufferedReader(new FileReader(PathA));
		                BufferedWriter writerB = new BufferedWriter(new FileWriter(fileB, true))
		            ) {
		                String line;
		                int lineCount = 0;

		                while ((line = readerA.readLine()) != null) {
		                    long lineValue = Long.parseLong(line);
		                    int length = line.length();
		                    int middle = length / 2;

		                    if (lineValue == 0) {
		                        writerB.write("1\n");
		                    } else if (lineValue == 1) {
		                        writerB.write((lineValue * 2024) + "\n");
		                    } else if (length % 2 == 0) {
		                        writerB.write(line.substring(0, middle) + "\n");
		                        String secondHalf = line.substring(middle);
		                        writerB.write(Long.parseLong(secondHalf) + "\n");
		                    } else {
		                        writerB.write((lineValue * 2024) + "\n");
		                    }

		                    lineCount++;

		                    if (lineCount % batchSize == 0) {
		                        writerB.flush(); 
		                    }
		                }
		            }

		        if (fileA.exists()) {
		            fileA.delete();
		        }

		        try (
		            BufferedReader readerB = new BufferedReader(new FileReader(fileB));
		            BufferedWriter writerA = new BufferedWriter(new FileWriter(fileA))
		        ) {
		            String line;
		            while ((line = readerB.readLine()) != null) {
		                writerA.write(line + "\n");
		            }
		        }

		        if (fileB.exists()) {
		            fileB.delete();
		        }
		        
		        long aCount = Files.lines(Paths.get(PathA)).count();
		        long endTime = System.nanoTime(); 
		        long duration = (endTime - startTime) / 1000000;
		        totalTime += duration/1000.00;
		        System.out.println("Loop " + i + " took " + duration/1000.00 + " sec for a total time of : " + totalTime/3600 + " hours and nbLines : " + aCount);

		        System.gc();
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}


	}
	
	// still sucks
	public static void part2AfterSomeHelmoPooClasses() {
		
		String[] array = new String[] {"3279", "998884", "1832781", "517", "8", "18864", "28", "0"};
		
		StringJoiner arrayJoiner = new StringJoiner(" ");

		
		for (int i = 0; i < 75; i++) {
			int counter = 0;
			long startTime = System.nanoTime();
						
			for (int j = 0; j < array.length; j++) {

				if (array[j].equals("0")) {
					arrayJoiner.add("1");
					counter++;
				} else if (array[j].length() % 2 == 1) {
					arrayJoiner.add(String.valueOf(Long.parseLong(array[j]) * 2024));
					counter++;
				} else if (array[j].length() % 2 == 0) {
					arrayJoiner.add(String.valueOf(Long.parseLong(array[j].substring(0, array[j].length()/2))));
					arrayJoiner.add(String.valueOf(Long.parseLong(array[j].substring(array[j].length()/2))));
					counter+=2;
				} else {
					System.out.println("Error");
				}
				
			}

			//System.out.println(arrayJoiner.toString());
			System.out.println(i + " size : " + counter);
			array = Arrays.copyOf(arrayJoiner.toString().split(" "), arrayJoiner.toString().split(" ").length);
			arrayJoiner = new StringJoiner(" ");
			
			long endTime = System.nanoTime(); 
	        long duration = (endTime - startTime) / 1000000;
	        System.out.println("Duration : " + duration/1000.00 + " sec ");
		}

	}

}

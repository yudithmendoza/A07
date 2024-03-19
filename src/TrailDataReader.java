package a07;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File; 
import edu.princeton.cs.algs4.ST;
/**
 * Read data from CSV file. Test Client
 * @author Shala and Yudith
 */
public class TrailDataReader {
	public static List<TrailPathData> readData(String csvFile) {
		List<TrailPathData> dataList = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy HH:mm"); 
		
		try (Scanner scanner = new Scanner(new File(csvFile))) {
			if (scanner.hasNextLine()) {
				scanner.nextLine(); // skip the header
			}
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				String[] separate = line.split(",");
				
				if (separate.length < 6) {
					continue; // skip incomplete lines
				}
				
				int objectID;
				try {
					objectID = Integer.parseInt(separate[0]);
				} catch (NumberFormatException e) {
					continue; // skip invalid object ID
				}
				
				String primaryName = separate[1]; 
//				int objectID = Integer.parseInt(separate[0]);
				String cartoCode = separate[2];
				String county = separate[3];
				Date createdDate;
				Date lastEditedDate;
				try {
					createdDate = dateFormat.parse(separate[4]);
					lastEditedDate = dateFormat.parse(separate[5]); 
				} catch (ParseException e) {
					continue; // skip invalid date format
				}
				double shapeLength;
				try {
					shapeLength = Double.parseDouble(separate[6]);
				} catch (NumberFormatException e) {
					continue; // skip invalid shape length
				}
				
				TrailPathData trailData = new TrailPathData(objectID, primaryName, cartoCode, county, createdDate, lastEditedDate, shapeLength); 
				dataList.add(trailData); 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		}
		
		return dataList;
		
	}
	

	public static void main(String[] args) {
		String filePath = "Resources/TrailsAndPathways.csv"; 
		
		List<TrailPathData> dataList = TrailDataReader.readData(filePath);
		
		// symbol table to store trail data
		ST<Integer, TrailPathData> symbolTable = new ST<>();  
		
		for (TrailPathData data : dataList) {
			symbolTable.put(data.getObjectID(), data); 
		}
		
//		System.out.println("Symbol Table:"); 

		// Challenge 1: used keys() and get() methods from ST table to look for
		// trails in Salt Lake County; 
		String countyToSearch = "Salt Lake"; 
		int count =0;
		
		for (Integer trailID : symbolTable.keys()) {
			TrailPathData trailData = symbolTable.get(trailID); 
			if (trailData.getCounty().equalsIgnoreCase(countyToSearch)) {
				count++; 
//				System.out.println(trailData.toString()); 
			}
		}
		System.out.println("Number of trails in " + countyToSearch + ": " + count); 
		

		// Challenge 2: Find the trail with a shape length closets to but not exceeding 100 using floor(). 
		double maxLength = 100.00;
		Integer floorTrailID = symbolTable.floor((int) maxLength);
		TrailPathData floorTrail = symbolTable.get(floorTrailID); 
		System.out.println("\nName of county with a trail of shape length closest to but not exceeding 100: " + floorTrail.getCounty()); 
		
		
		// Challenge 3
	}	
}

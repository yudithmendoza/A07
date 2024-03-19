package a07;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File; 

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
				
//				int objectID = Integer.parseInt(separate[0]);
				String cartoCode = separate[1];
				String county = separate[2];
				Date createdDate;
				Date lastEditedDate;
				try {
					createdDate = dateFormat.parse(separate[3]);
					lastEditedDate = dateFormat.parse(separate[4]); 
				} catch (ParseException e) {
					continue; // skip invalid date format
				}
				double shapeLength;
				try {
					shapeLength = Double.parseDouble(separate[5]);
				} catch (NumberFormatException e) {
					continue; // skip invalid shape length
				}
				
				TrailPathData trailData = new TrailPathData(objectID, cartoCode, county, createdDate, lastEditedDate, shapeLength); 
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
		
		System.out.println("Data:"); 
		for (TrailPathData data : dataList) {
			System.out.println(data); 
		}
	}
		
}

package a07;

import java.io.FileNotFoundException;
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
		
		try (Scanner scanner = new Scanner(new File(csvFile))) {
			if (scanner.hasNextLine()) {
				scanner.nextLine(); 
			}
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				String[] separate = line.split(",");
				
				int objectID = Integer.parseInt(separate[0]);
				String cartoCode = separate[1];
				String county = separate[2];
				String createdDate = separate[3];
				String lastEditedDate = separate[4];
				double shapeLength = Double.parseDouble(separate[5]); 
				
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
		
		for (TrailPathData data : dataList) {
			System.out.println(data); 
		}
	}
		
}

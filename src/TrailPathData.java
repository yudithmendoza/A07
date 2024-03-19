package a07;
/**
 * Represents a Trail object with and id, cortocode, county, created data, last-edited date, and shape length
 * @author Shala and Yudith
 */
public class TrailPathData {
	
	int objectID;
	String cartoCode;
	String county;
	String createdDate;
	String lastEditedDate;
	double shapeLength;
	/**
	 * @return the objectID
	 */
	public int getObjectID() {
		return objectID;
	}
	/**
	 * @return the cartoCode
	 */
	public String getCartoCode() {
		return cartoCode;
	}
	/**
	 * @return the county
	 */
	public String getCounty() {
		return county;
	}
	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}
	/**
	 * @return the lastEditedDate
	 */
	public String getLastEditedDate() {
		return lastEditedDate;
	}
	/**
	 * @return the shapeLength
	 */
	public double getShapeLength() {
		return shapeLength;
	}
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy h:mm:ss a"); 
		String CreatedDateString = "";
		String lastEditedDateString = "";
		
		try {
			Date createdDateObj = dateFormat.parse(createdDate); 
			Date lastEditedObj = dateFormat.parse(lastEditedDate);
			CreatedDateString = dateFormat.format(createdDateObj); 
			lastEditedDateString = dateFormat.format(lastEditedObj);
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "OjectID: " + objectID + 
				", CartoCode: " + cartoCode + 
				", County: " + county +
				", Created Date: " + CreatedDateString +
				", Last Edited Date: " + lastEditedDateString +
				", Shape Length: " + shapeLength; 
	}
}

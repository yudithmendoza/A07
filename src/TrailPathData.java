package a07;

import java.text.ParseException;
import java.util.Date; 
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a Trail object with and id, cortocode, county, created data, last-edited date, and shape length
 * @author Shala and Yudith
 */
public class TrailPathData {
	private int objectID;
	private String cartoCode;
	private String county;
	private Date createdDate;
	private Date lastEditedDate;
	private double shapeLength;
	
	/**
	 * Constructor
	 * 
	 * @param objectID
	 * @param cartoCode
	 * @param county
	 * @param createdDate2
	 * @param lastEditedDate2
	 * @param shapeLength
	 */
	public TrailPathData(int objectID, String cartoCode, String county, Date createdDate, Date lastEditedDate,
			double shapeLength) {
		super();
		this.objectID = objectID;
		this.cartoCode = cartoCode;
		this.county = county;
		this.createdDate = createdDate;
		this.lastEditedDate = lastEditedDate; 
		this.shapeLength = shapeLength;
	}


	/**
	 * Represents the ID of the trail
	 * 
	 * @return the objectID
	 */
	public int getObjectID() {
		return objectID;
	}


	/**
	 * Returns the cartographic of the trail
	 * 
	 * @return the cartoCode
	 */
	public String getCartoCode() {
		return cartoCode;
	}


	/**
	 * Retruns the county where the trail is located
	 * 
	 * @return the county
	 */
	public String getCounty() {
		return county;
	}


	/**
	 * Returns the date when the trail was created.
	 * 
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}


	/**
	 * Returns the date when the trail was last edited
	 * 
	 * @return the lastEditedDate
	 */
	public Date getLastEditedDate() {
		return lastEditedDate;
	}


	/**
	 * Returns the length of the trail.
	 * 
	 * @return the shapeLength
	 */
	public double getShapeLength() {
		return shapeLength;
	}

	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy h:mm:ss a"); 
		String CreatedDateString = dateFormat.format(createdDate);
		String lastEditedDateString = dateFormat.format(lastEditedDate);
		
		return "OjectID: " + objectID + 
				", CartoCode: " + cartoCode + 
				", County: " + county +
				", Created Date: " + CreatedDateString +
				", Last Edited Date: " + lastEditedDateString +
				", Shape Length: " + shapeLength; 
	}
	
	
}

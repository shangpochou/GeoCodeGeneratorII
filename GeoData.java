import java.util.*;

public class GeoData {

	public String cityName;
	public String townshipName;
	public String villageName;
	public String cityCode;
	public String townshipCode;
	public String villageCode;
	public String totalCode;
	/*
	 * contain division which are seperated from this
	 * division
	 * */
	public ArrayList<GeoData> newDivisionList;
	/*
	 * need to initialize the newDivisionList 
	 * in constructor
	 * */
	public GeoData(){
		this.newDivisionList = new ArrayList<GeoData>();
	}
}

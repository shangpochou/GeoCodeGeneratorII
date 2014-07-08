import java.util.*;


public class DataBase {
	
	/*
	 * Hashtable which keeps all the Geo data
	 * */
	public Hashtable<String, GeoData> geoDataHT;
	
	public ArrayList<GeoData> geoDataList;
	
	public String geoCodePath;
	
	public String divideListPath;
	
	public String addListPath;
	
	public String outputCSVPath;
	//singulaton 
	private static DataBase myDataBase;
	
	/*
	 * Constructor, and config here.
	 */
	public DataBase(){	
		this.geoDataList = new ArrayList<GeoData>();
		this.geoDataHT = new Hashtable<String, GeoData>();
	}
	
	public void SetPath(String geoCodePath, String divideListPath, String outputPath){
		this.geoCodePath = geoCodePath;
		this.divideListPath = divideListPath;
		this.outputCSVPath = outputPath;
	}
	
	public static DataBase GetDataBase(){
		if(myDataBase == null){
			myDataBase = new DataBase();
		}
		return myDataBase;
	}
	
}

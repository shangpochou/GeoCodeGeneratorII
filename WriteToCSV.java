import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;


public class WriteToCSV extends Procedure{
	public void Task(){
		try {
			Output();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Output() throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(myDB.outputCSVPath)); 

		String tmpTitle = new String();
		
		tmpTitle += this.WarpWithComma("CityCode") + this.WarpWithComma("CityName")+ this.WarpWithComma("TownshipCode");
		tmpTitle += this.WarpWithComma("TownshipName")+this.WarpWithComma("VillageCode")+ this.WarpWithComma("VillageName");
		tmpTitle += this.WarpWithComma("TotalCode");
		tmpTitle += this.WarpWithComma("CityCode") + this.WarpWithComma("CityName")+ this.WarpWithComma("TownshipCode");
		tmpTitle += this.WarpWithComma("TownshipName")+this.WarpWithComma("VillageCode")+ this.WarpWithComma("VillageName");
		tmpTitle += this.WarpWithoutComma("TotalCode");

		bw.write(tmpTitle);
	    bw.newLine();
	    
		for(int j = 0; j < myDB.geoDataList.size(); j++){
			GeoData tmpGData = myDB.geoDataList.get(j);

			String temp = new String();
		
			temp += this.WarpWithCommaTab(tmpGData.cityCode);
			temp += this.WarpWithComma(tmpGData.cityName);
			temp += this.WarpWithCommaTab(tmpGData.townshipCode);
			temp += this.WarpWithComma(tmpGData.townshipName);
			temp += this.WarpWithCommaTab(tmpGData.villageCode);
			temp += this.WarpWithComma(tmpGData.villageName);
			temp += this.WarpWithCommaTab(tmpGData.totalCode);	
	
			temp += this.WarpWithCommaTab(tmpGData.cityCode);
			temp += this.WarpWithComma(tmpGData.cityName);
			temp += this.WarpWithCommaTab(tmpGData.townshipCode);
			temp += this.WarpWithComma(tmpGData.townshipName);
			temp += this.WarpWithCommaTab(tmpGData.villageCode);
			temp += this.WarpWithComma(tmpGData.villageName);
			temp += this.WarpWithoutCommaTab(tmpGData.totalCode);	
			
			bw.write(temp);
			bw.newLine();
			if(tmpGData.newDivisionList.size() != 0){
				for(int i = 0; i < tmpGData.newDivisionList.size(); i++){
					String tmpNewDiv = new String();
					
					GeoData tmpNewDivData = tmpGData.newDivisionList.get(i);
					
					tmpNewDiv += this.WarpWithComma("") + this.WarpWithComma("");
					tmpNewDiv += this.WarpWithComma("") + this.WarpWithComma("");
					tmpNewDiv += this.WarpWithComma("") + this.WarpWithComma("");
					tmpNewDiv += this.WarpWithComma("");
					
					tmpNewDiv += this.WarpWithCommaTab(tmpNewDivData.cityCode); 
					tmpNewDiv += this.WarpWithComma(tmpNewDivData.cityName); 
					tmpNewDiv += this.WarpWithCommaTab(tmpNewDivData.townshipCode); 
					tmpNewDiv += this.WarpWithComma(tmpNewDivData.townshipName); 
					tmpNewDiv += this.WarpWithCommaTab(tmpNewDivData.villageCode); 
					tmpNewDiv += this.WarpWithComma(tmpNewDivData.villageName); 
					tmpNewDiv += this.WarpWithoutCommaTab(tmpNewDivData.totalCode); 
					
					bw.write(tmpNewDiv);
					bw.newLine();
				}
				
			}
			
			
		}
		
		bw.close();
	}
	
}

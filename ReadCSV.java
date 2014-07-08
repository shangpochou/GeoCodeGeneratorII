import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*
 * Read input geo code from a .csv file.
 * */
public class ReadCSV extends Procedure{

	
	public void Task(){
        BufferedReader reader;
        
        try {

            reader = new BufferedReader(new FileReader(myDB.geoCodePath));
         
            // Read the first line or not (comment means yes)
            reader.readLine();
      
            String line = null;
            
            while ((line = reader.readLine()) != null) {               
                String item[] = line.split(",");              
             
                if(item.length == 6){
                GeoData tmpGData = new GeoData();
                tmpGData.cityCode = this.ParseCSV(item[0]);
                tmpGData.cityName = this.ParseCSV(item[1]);
                tmpGData.townshipCode = this.ParseCSV(item[2]);
                tmpGData.townshipName = this.ParseCSV(item[3]);
                tmpGData.villageCode = this.ParseCSV(item[4]);
                tmpGData.villageName = this.ParseCSV(item[5]);
                 
                tmpGData.totalCode = tmpGData.cityCode + tmpGData.townshipCode + tmpGData.villageCode;
                myDB.geoDataList.add(tmpGData);
                myDB.geoDataHT.put(tmpGData.totalCode, tmpGData);
                }else{
                	System.out.println(item);
                }
                /*
                for(int i = 0; i < item.length; i++)
                	System.out.println(this.ParseCSV(item[i]));
				*/
            }
            reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}

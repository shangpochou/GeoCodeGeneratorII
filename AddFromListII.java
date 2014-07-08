import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * supporting different format.
 * This format is more closed to what we got from the Gov.
 * So we tend to use this format for our program.
 * */
public class AddFromListII extends Procedure{

	public void Task(){
        BufferedReader reader;
        
        try {

            reader = new BufferedReader(new FileReader(myDB.addListPath));
         
            // Read the first line or not (comment means yes)
            //reader.readLine();
      
            String line = null;
            
            while ((line = reader.readLine()) != null) {               
                String item[] = line.split(",");              
             
                if(item.length == 4){
                GeoData tmpGData = new GeoData();
                tmpGData.cityName = this.ParseCSV(item[0]);
                tmpGData.townshipName = this.ParseCSV(item[1]);
                tmpGData.totalCode = this.ParseCSV(item[2]);
                tmpGData.villageName = this.ParseCSV(item[3]);
                
                /*
                 * There are two cases, municipality and
                 * other cities
                 * */
                
                String firstTwoDigit = tmpGData.totalCode.substring(0,2);
                /*
                 * Very dirty code for parsing total code.
                 * */
                if(firstTwoDigit.equals("63") || firstTwoDigit.equals("64") || firstTwoDigit.equals("65") || firstTwoDigit.equals("66") || firstTwoDigit.equals("67")){              
                	tmpGData.cityCode = tmpGData.totalCode.substring(0, 2);
                	tmpGData.townshipCode = tmpGData.totalCode.substring(2, 7);
                	tmpGData.villageCode = tmpGData.totalCode.substring(7, 10);
                }else{
                	tmpGData.cityCode = tmpGData.totalCode.substring(0, 4);
                	tmpGData.townshipCode = tmpGData.totalCode.substring(5, 7);
                	tmpGData.villageCode = tmpGData.totalCode.substring(7, 10);
                }
  
                myDB.geoDataHT.put(tmpGData.totalCode, tmpGData);
                }else{
                	System.out.println(item);
                }
                /*
                for(int i = 0; i < item.length; i++)
                	System.out.println(item[i]);
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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Read divide list, and put the information to GeoData
 * 
 * */

public class ReadDivideList extends Procedure{

	public void Task(){
        BufferedReader reader;
        
        try {

            reader = new BufferedReader(new FileReader(myDB.divideListPath));
         
            // Read the first line or not (comment means yes)
            //reader.readLine();
      
            String line = null;
            /*
             * represent the index of current pivot, 
             * which is the division will divide to 
             * other division.
             */
            int curPivotIndex = -1;
            
            while ((line = reader.readLine()) != null) {               
                String item[] = line.split(",");              
             
                if(item.length == 1){
                	/*
                	 * this line is for pivot 
                	 * */
                	String pivotID = this.ParseCSV(item[0]);
                	/*
                	 * dump linear comparison to find
                	 * the pivot index.
                	 * */
     //           	System.out.println(pivotID);
                	for(int i = 0; i < myDB.geoDataList.size(); i++){
                	//	System.out.println(myDB.geoDataList.get(i).totalCode);
                		if(myDB.geoDataList.get(i).totalCode.equals(pivotID)){
                			curPivotIndex = i;
                		}
                	}
                }else if(item.length == 6){
                	/*
                	 * this line is for newly separated division
                	 * */
                	GeoData tmpGData = new GeoData();
                    tmpGData.cityCode = this.ParseCSV(item[0]);
                    tmpGData.cityName = this.ParseCSV(item[1]);
                    tmpGData.townshipCode = this.ParseCSV(item[2]);
                    tmpGData.townshipName = this.ParseCSV(item[3]);
                    tmpGData.villageCode = this.ParseCSV(item[4]);
                    tmpGData.villageName = this.ParseCSV(item[5]);
                     
                    tmpGData.totalCode = tmpGData.cityCode + tmpGData.townshipCode + tmpGData.villageCode;
                	
                    myDB.geoDataList.get(curPivotIndex).newDivisionList.add(tmpGData);
                }else{
                	System.out.println("incorrect input format");
                	System.out.println(item);
                }
               
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

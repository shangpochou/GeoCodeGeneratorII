import java.util.ArrayList;


public class GeoCodeGeneratorII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataBase myDB = DataBase.GetDataBase();
	
		myDB.SetPath(args[0], args[1], args[2]);
		
		ArrayList<Procedure> myProcAL = new ArrayList<Procedure>();
		
		ReadCSV myRCSV = new ReadCSV();
		myProcAL.add(myRCSV);
				
//		AddFromList myAFL = new AddFromList();
//		myProcAL.add(myAFL);
		
//		AddFromListII myAFLII = new AddFromListII();
//		myProcAL.add(myAFLII);
	
		ReadDivideList myRDL = new ReadDivideList();
		myProcAL.add(myRDL);
		
		WriteToCSV myWCSV = new WriteToCSV();
		myProcAL.add(myWCSV);
				
		for(int i = 0; i < myProcAL.size(); i++){
			myProcAL.get(i).GetData(myDB);
			myProcAL.get(i).Task();
		}
		
		
	}

}

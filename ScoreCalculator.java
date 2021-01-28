import java.text.DecimalFormat;

/*
 * Calculates Precision and Recal for each class in a multiclass confusion matrix
 * 
 */

public class ScoreCalculator {
	private static int[][] sourceData= {
			
			{5337,1,1,51,46,7},
			{0,454,0,0,6,3},
			{0,1,397,10,0,3},
			{28,0,4,566,0,0},
			{116,3,0,0,319,2},
			{21,4,4,0,2,276}};
	
	private static int classIndex =0;// index of the class under investigation
	private static int numClasses=6;// total nuber of classes
	private static int[][] result = new int[numClasses][2];
	private static int[] tpArr = new int[numClasses];
	private static int curRow=0; // current row and current column
	private static int curColumn=0;
	private int TP; //True positive
	public static void main(String args[]){
	
	//	for(classIndex =0;classIndex<numClasses-1;classIndex++) {
		//iterate over rows and columns
		System.out.println("Confusion Matrix");
			for(curRow = 0;curRow<numClasses;curRow++) {
				for(curColumn =0; curColumn<numClasses;curColumn++) {
					//find TP
					if(curRow==classIndex&& curColumn== classIndex) {
						tpArr[classIndex]=sourceData[curRow][curColumn];
					
					}
				//add all values of column 
						System.out.print(sourceData[curRow][curColumn]+", ");
						result[curRow][0]+=sourceData[curRow][curColumn];
						result[curColumn][1]+=sourceData[curRow][curColumn];
				}
				classIndex++;
				System.out.println("");
		}
		System.out.println("TruePositiv's, sum of the column, sum of the row");
		for(int i=0;i<numClasses;i++) {
			System.out.println("TruePositive: "+i+" "+tpArr[i]+ ", colSum:"+result[i][0]+ ", rowSum:"+result[i][1]);
		}
		//Print Precision and recall
		System.out.println("\n"+"Class, Precision, Recal");
		DecimalFormat df = new DecimalFormat("#.##");
		for(int i=0;i <numClasses;i++) {
			double precision = (double)(tpArr[i])/(double)(result[i][0]);
			double recal = (double)(tpArr[i]/(double)result[i][1]);
			System.out.println(i+": precision:"+df.format(precision)+" recal:"+df.format(recal));
		}
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longdivision;

/**
 *
 * @author vv
 */
public class LongDivision {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       double[][]x={{2.0,0.0,15.0,4.0,25.0,10.0},{5,4,3,2,1,0}};
       double[][]y={{2.0,0.0,5.0},{2,1,0}};
       longDivision(x,y);
       
    }
  public static Object longDivision(double[][]arrayOfNumerator, double[][]arrayOfDenominator){
  
  double[][]arrayOfResult = new double[2][arrayOfNumerator[0].length-arrayOfDenominator[0].length+1];
  double[][]reduced=new double[arrayOfNumerator.length][arrayOfNumerator[0].length];
  copyArray(reduced,arrayOfNumerator);
for(int i=0;i<arrayOfNumerator[0].length-arrayOfDenominator[0].length;i++){


arrayOfResult[0][i]=reduced[0][i]*1.0/arrayOfDenominator[0][0]*1.0;
arrayOfResult[1][i]=reduced[1][i]-arrayOfDenominator[1][0];
copyArray(reduced,subArrays(reduced,multTermByArray(arrayOfResult,i,arrayOfDenominator),i));
}
   System.out.println(arrayOfResult[0][0]);
   System.out.println(arrayOfResult[1][0]);
   System.out.println(arrayOfResult[0][1]);
   System.out.println(arrayOfResult[1][1]);
   System.out.println(arrayOfResult[0][2]);
   System.out.println(arrayOfResult[1][2]);
    
return "";
       
  }
  public static double[][] subArrays(double[][]arr1,double[][]arr2,int start){
  double[][]arr3=new double[arr1.length][arr1[0].length];
  copyArray(arr3,arr1);
  
  for(int i=start;i<arr2[0].length;i++){
  if(arr1[1][i]==arr2[1][i]){
  arr3[0][i]=arr1[0][i+start]-arr2[0][i];
  }
  }
  return arr3;
  }
  public static double[][] multTermByArray(double[][]term,int n,double[][]arr){
  double[][]arr3=new double[arr.length][arr[0].length];
  copyArray(arr3,arr);
  for(int i=0;i<arr[0].length;i++){
  arr3[0][i]=arr[0][i]*term[0][n];
  }
  for(int i=0;i<arr.length;i++){
  arr3[1][i]=arr[1][i]+term[1][n];
  }
  return arr3;
  
  }
  public static void copyArray(double[][]x,double[][]y){
  for(int i=0;i<y[0].length;i++){
  x[0][i]=y[0][i];
  }
  for(int j=0;j<y.length;j++){
  x[1][j]=y[1][j];
  }
  }
}

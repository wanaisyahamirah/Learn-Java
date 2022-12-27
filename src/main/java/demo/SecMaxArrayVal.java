package demo;

public class SecMaxArrayVal 
{
    public static void main( String[] args )
    {

        int array[] = {10, 20, 25, 63, 96, 57};

        boolean isUnique=isUniqueArray(array);

        if(!isUnique){
			return;
		}
		System.out.println("Is Unique is true");
		if(!isAtLeastTwoVal(array)){
			return;
		}
		System.out.println("Have Two Values is true ");

		System.out.println("Second Largest Value  is :: " +findSecLargestVal(array));
    }
   
    public static boolean isUniqueArray(int arrayValue[])
    {

        for (int i = 0; i < arrayValue.length; i++) {
            for (int j = 0; j < arrayValue.length; j++) {
                if (i == j) continue; // when sama index, no need to compare
                if (arrayValue[i] == arrayValue[j]) { // return false kalau sama, maksudnya tak unik
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean isAtLeastTwoVal(int arrayValue[]){
        return arrayValue.length >= 2;
    }

    public static int findSecLargestVal(int arrayValue[]){

        int temp, size;
        size = arrayValue.length;
        
        
        for(int i = 0; i<size; i++ ){
           for(int j = i+1; j<size; j++){
  
              if(arrayValue[i]>arrayValue[j]){
                 temp = arrayValue[i];
                 arrayValue[i] = arrayValue[j];
                 arrayValue[j] = temp;
              }
           }
        }
        return arrayValue[size-2];
    }

}

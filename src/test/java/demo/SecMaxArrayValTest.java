package demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SecMaxArrayValTest 
{

    /*
        Task is to find the second maximum value in an array
        Rules:
        1. Numbers in array must be unique
        2. There will always be at least 2 number in an array

        Example
		  int[] arrInput = { 5, 3, 1, 9, 7, 10 };
          Ans:9

          int[] arrInput = { 1, 2, 3 };
          Ans:2


          int[] arrInput = { 4, 5, 6 };
          Ans:5;


          int[] arrInput ={ 3, 5, 4 };
          Ans:4;

          int[] arrInput ={ 6, 5, 4 };
          Ans:5;

		  int[] arrInput ={ 1, 2};
          Ans:1;
    */
   
    @Test
    public void isUniqueArrayTest()
    {
        assertTrue(SecMaxArrayVal.isUniqueArray(new int[] { 5, 3, 1, 9, 7, 10 }));
        assertTrue(SecMaxArrayVal.isUniqueArray(new int[] { 1, 2, 3 }));
        assertTrue(SecMaxArrayVal.isUniqueArray(new int[] { 4, 5, 6 }));
        assertTrue(SecMaxArrayVal.isUniqueArray(new int[] { 3, 5, 4  }));
        assertTrue(SecMaxArrayVal.isUniqueArray(new int[] { 6, 5, 4 }));
        assertTrue(SecMaxArrayVal.isUniqueArray(new int[] { 1, 2 }));

        assertFalse(SecMaxArrayVal.isUniqueArray(new int[] { 2, 2, 1, 5 }));
    }

    @Test
    public void isAtLeastTwoValTest()
    {
        assertTrue(SecMaxArrayVal.isAtLeastTwoVal(new int[] { 5, 3, 1, 9, 7, 10 }));
        assertTrue(SecMaxArrayVal.isAtLeastTwoVal(new int[] { 1, 2, 3 }));
        assertTrue(SecMaxArrayVal.isAtLeastTwoVal(new int[] { 4, 5, 6 }));
        assertTrue(SecMaxArrayVal.isAtLeastTwoVal(new int[] { 3, 5, 4  }));
        assertTrue(SecMaxArrayVal.isAtLeastTwoVal(new int[] { 6, 5, 4 }));
        assertTrue(SecMaxArrayVal.isAtLeastTwoVal(new int[] { 1, 2 }));

        assertFalse(SecMaxArrayVal.isAtLeastTwoVal(new int[] { 2 }));
    }

    @Test
    public void findSecLargestValTest()
    {
        assertEquals(9, SecMaxArrayVal.findSecLargestVal(new int[] { 5, 3, 1, 9, 7, 10 }));
        assertEquals(2, SecMaxArrayVal.findSecLargestVal(new int[] { 1, 2, 3 }));
        assertEquals(5, SecMaxArrayVal.findSecLargestVal(new int[] { 4, 5, 6 }));
        assertEquals(4, SecMaxArrayVal.findSecLargestVal(new int[] { 3, 5, 4  }));
        assertEquals(5, SecMaxArrayVal.findSecLargestVal(new int[] { 6, 5, 4 }));
        assertEquals(1, SecMaxArrayVal.findSecLargestVal(new int[] { 1, 2 }));
    }
}

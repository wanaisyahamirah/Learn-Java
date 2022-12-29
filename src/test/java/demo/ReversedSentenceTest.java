package demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ReversedSentenceTest 
{
    
    @Test
    public void splitInputBySpaceTest()
    {

        String expectedInput = "Hello World";

        List<String> expectedList=new ArrayList<>();
		expectedList.add("Hello");
		expectedList.add("World");

        List<String> resultList = ReversedSentence.splitInputBySpace(expectedInput);

        for(int i = 0; i < resultList.size(); i ++){
            assertTrue(resultList.get(i).equals(expectedList.get(i)));
            assertFalse(!resultList.get(i).equals(expectedList.get(i)));
        }
        
    }

    @Test
    public void printReversedTest(){

        String expectedInput = "Hello World";
        String expectedOutput = "World Hello";

        List<String> resultList = ReversedSentence.splitInputBySpace(expectedInput);
        assertTrue(ReversedSentence.concatReveseString(resultList).equals(expectedOutput));

    }

}

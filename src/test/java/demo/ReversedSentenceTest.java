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

        String expectedInput = "Hello how are you";

        List<String> expectedList=new ArrayList<>();
		expectedList.add("Hello");
		expectedList.add("how");
        expectedList.add("are");
        expectedList.add("you");

        List<String> resultList = ReversedSentence.splitInputBySpace(expectedInput);

        for(int i = 0; i < resultList.size(); i ++){
            assertTrue(resultList.get(i).equals(expectedList.get(i)));
            assertFalse(!resultList.get(i).equals(expectedList.get(i)));
        }
        
    }

    @Test
    public void printReversedTest(){

        // Hello how are you
        // I am a Human
        String expectedInput = "I am a Human";
        
        // you are how Hello
        // Human a am I
        String expectedOutput = "Human a am I";

        List<String> resultList = ReversedSentence.splitInputBySpace(expectedInput);
        assertTrue(ReversedSentence.concatReveseString(resultList).equals(expectedOutput));

    }

}

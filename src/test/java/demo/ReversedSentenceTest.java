package demo;

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

        List<String> resultList = ReversedSentence.splitInputBySpace(expectedInput) ;

        assertTrue(expectedList.get(0).equals(resultList.get(0)));
		assertTrue(expectedList.get(1).equals(resultList.get(1)));
    }

}

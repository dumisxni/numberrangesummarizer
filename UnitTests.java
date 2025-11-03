package numberrangesummarizer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collection;;

public class UnitTests {
    public Solution solution = new Solution();

    // Tests for the Collect method
    @Test
    public void testCollect(){
        Collection<Integer> list = solution.collect("1,2,3,4,5,6,7,8,9,10");
        Assertions.assertEquals(Arrays.asList(1,2,3,4,5,6,7,8,9,10), list);
    }
    @Test
    public void testCollectNegativeNumbers(){
        Collection<Integer> list = solution.collect("-3,-2,-1,0,3,4");
        Assertions.assertEquals(Arrays.asList(-3, -2, -1, 0, 3, 4), list);
    }
    @Test
    public void testCollectInputWithSpaces(){
        Collection<Integer> list = solution.collect("-3,       -2, -1,     0,    3, 4");
        Assertions.assertEquals(Arrays.asList(-3, -2, -1, 0, 3, 4), list);
    }
    @Test
    public void testCollectInvalidInput(){
        Collection<Integer> list = solution.collect("@,a,b,c,4,6,4,3,3");
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void testCollectNull(){
        Collection<Integer> list = solution.collect(null);
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void testCollectEmpty(){
        Collection<Integer> list = solution.collect("");
        Assertions.assertTrue(list.isEmpty());
    }
    // Tests for the summarizeCollection method
    @Test
    public void testSummarizeCollection(){
        Collection<Integer> input = solution.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        String result = solution.summarizeCollection(input);
        Assertions.assertEquals("1, 3, 6-8, 12-15, 21-24, 31", result);
    }
    @Test
    public void testSummarizeCollectionTwoConsecutive() {
        Collection<Integer> input = Arrays.asList(1, 2);
        String result = solution.summarizeCollection(input);
        Assertions.assertEquals("1-2", result);
    }
    @Test
    public void testSummarizeCollectionAllConsecutive() {
        Collection<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        String result = solution.summarizeCollection(input);
        Assertions.assertEquals("1-10", result);
    }
    @Test
    public void testSummarizeCollectionNoneConsecutive() {
        Collection<Integer> input = Arrays.asList(1, 3, 5, 7, 9);
        String result = solution.summarizeCollection(input);
        Assertions.assertEquals("1, 3, 5, 7, 9", result);
    }
    @Test
    public void testSummarizeCollectionOneNumber() {
        Collection<Integer> input = Arrays.asList(1);
        String result = solution.summarizeCollection(input);
        Assertions.assertEquals("1", result);
    }

    @Test
    public void testSummarizeCollectionMixedNumbers() {
        Collection<Integer> input = Arrays.asList(1, 3, 4, 5, 7, 9, 10, 11, 13);
        String result = solution.summarizeCollection(input);
        Assertions.assertEquals("1, 3-5, 7, 9-11, 13", result);
    }
    @Test
    public void testSummarizeCollectionNegativeNumbers() {
        Collection<Integer> input = Arrays.asList(-5, -4, -3, -1, 0, 1, 2);
        String result = solution.summarizeCollection(input);
        Assertions.assertEquals("-5--3, -1-2", result);
    }
    @Test
    public void testSummarizeCollectionEmptyInput() {
        Collection<Integer> input = Arrays.asList();
        String result = solution.summarizeCollection(input);
        Assertions.assertEquals("Input Collection can't be null, contain null elements or empty", result);
    }
    @Test
    public void testSummarizeCollectionNullInput() {
        String result = solution.summarizeCollection(null);
        Assertions.assertEquals("Input Collection can't be null, contain null elements or empty", result);
    }
}

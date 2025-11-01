package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;

public class Solution implements NumberRangeSummarizer{
    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31"); // assumption no1, the input is a sorted string of numbers
    }

    @Override
    public Collection<Integer> collect(String input) {

        String[] inputIntegers = input.split(","); // split the string by commas
        ArrayList<Integer> inputArrayList = new ArrayList<>();

        for (String no : inputIntegers) {
            inputArrayList.add(Integer.parseInt(no)); // add the numbers from the split array to the inputArrayList
        }
        return inputArrayList;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        StringBuilder sb = new StringBuilder();
        
        return sb.toString();
    }
}
package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;

public class Solution implements NumberRangeSummarizer{
    public static void main(String[] args) {
        Solution sl = new Solution();
        Collection<Integer> input = sl.collect("1,3,4,5,7,9,10,11,13,26,27"); // assumption no1, the input is a sorted string of numbers
        System.out.println(sl.summarizeCollection(input));

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
        ArrayList<Integer> inputArrayList = new ArrayList<>(input); // change the collection into an arraylist for access using indexes
        StringBuilder sb = new StringBuilder(); // build the output string
        String group = ""; // to temporarily store the range if it does exist
        // pointers to check for consecutive numbers
        int pointer1 = 0;
        int pointer2 = 1;

        while(pointer2 < inputArrayList.size()){

            if(inputArrayList.get(pointer2)-inputArrayList.get(pointer1)!=1){ // if the numbers are not consecutive
                sb.append(inputArrayList.get(pointer1)+", ");
                pointer1++;
                pointer2++;
            }
            else{ // this is for when they are consecutive
                group+= inputArrayList.get(pointer1)+"-";
                // the pointers continue moving as long as the numbers are consecutive
                while(pointer2<inputArrayList.size()&&inputArrayList.get(pointer2)-inputArrayList.get(pointer1)==1){
                    pointer1++;
                    pointer2++;
                }
                // add the last number in the pair
                group+= inputArrayList.get(pointer1);
                sb.append(group+", "); // add the group to the output string
                // reset the pointers and the group string that temporarily stores the group
                pointer1=pointer2;
                pointer2++;
                group="";
            }
        }

        // if the is an element left just add it to the end
        if (pointer1 < inputArrayList.size()) {
            sb.append(inputArrayList.get(pointer1));
        }

        return sb.toString().replaceAll(", $", ""); // remove the extraspaces or commas at the end
    }
}
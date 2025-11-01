package numberrangesummarizer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collection;

public class UnitTests {
    @Test
    public void testCollect(){
        Solution s = new Solution();
        Collection<Integer> list = s.collect("1,2,3,4,5,6,7,8,9,10");
        Assertions.assertEquals(Arrays.asList(1,2,3,4,5,6,7,8,9,10), list);
    }
}

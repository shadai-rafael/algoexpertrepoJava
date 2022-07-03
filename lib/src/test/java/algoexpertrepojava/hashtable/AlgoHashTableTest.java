package algoexpertrepojava.hashtable;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AlgoHashTableTest {
    
    private AlgoHashTable algoHashTableTest = null;

    @Before
    public void init(){
        algoHashTableTest = AlgoHashTable.getInstance();
    }

    @Test
    public void fibonacciTest(){
        List<String> dictionary =Arrays.asList("work","aba","korw","asa");
        algoHashTableTest.findAnagrams(dictionary).forEach(ls -> ls.forEach(s->System.out.println(s)));
    }
      
}

package algoexpertrepojava.stack;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;

public class AlgoStackTest {

    AlgoStack algoStackUnderTest;

    @Before
    public void init(){
        algoStackUnderTest = AlgoStack.getInstance();
    }

    @Test 
    public void sortStackTest(){
        ArrayList<Integer> stack = new ArrayList<Integer>(
                                Arrays.asList(3,2,1,4,4));
        System.out.println(algoStackUnderTest.sortStack(stack));
    }
}

/*
MIT License
Copyright (c) 2022 shadai-rafael
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package algoexpertrepojava.recursion;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;

public class AlgoRecursionTest {

    private AlgoRecursion algoRecursionUnderTest = null;

    @Before
    public void init(){
        algoRecursionUnderTest = AlgoRecursion.getInstance();
    }

    @Test
    public void fibonacciTest(){
        assertTrue((algoRecursionUnderTest.getNthFib(6) == 5));
        assertTrue((algoRecursionUnderTest.getNthFib(1) == 0));
        assertTrue((algoRecursionUnderTest.getNthFib(4) == 2));
    }
    
    @Test
    public void productSumTest(){
        List<Object> array1 = new ArrayList<Object>();
        array1.add((Object) Integer.valueOf(-13));
        array1.add((Object) Integer.valueOf(8));

        List<Object> array2 = new ArrayList<Object>();
        array2.add((Object) Integer.valueOf(6));
        array2.add(array1);
        array2.add((Object) Integer.valueOf(4));

        List<Object> array3 = new ArrayList<Object>();
        array3.add((Object) Integer.valueOf(7));
        array3.add((Object) Integer.valueOf(-1));

        List<Object> array4 = new ArrayList<Object>();
        array4.add((Object) Integer.valueOf(5));
        array4.add((Object) Integer.valueOf(2));
        array4.add(array3);
        array4.add((Object) Integer.valueOf(3));
        array4.add(array2);

        assertTrue(algoRecursionUnderTest.productSum(array4)==12);
    }

    @Test
    public void getPermutationsTest(){

        List<Integer> listForTest = Arrays.asList(new Integer[] {1,2,3});

        Integer[][] array = {{ 1, 2, 3 },{ 1, 3, 2 },{ 2, 1, 3 },{ 2, 3, 1 },{ 3, 1, 2 },{ 3, 2, 1 }};

          List<List<Integer>> listForCheck = Arrays.stream(array)
                .map(innerArray -> new ArrayList<>(Arrays.asList(innerArray)))
                .collect(Collectors.toCollection(ArrayList::new));
        
        var res = algoRecursionUnderTest.getPermutations(listForTest);
        assertArrayEquals(listForCheck.toArray(), res.toArray());
    }

    @Test
    public void getPowerSetTest(){
        List<Integer> listForTest = new ArrayList<Integer>(Arrays.asList(new Integer[] {1,2,3}));

        Integer[][] array = {{},{1},{2},{1,2},{3},{1,3},{2,3},{1,2,3}};

            List<List<Integer>> listForCheck = Arrays.stream(array)
                .map(innerArray -> new ArrayList<>(Arrays.asList(innerArray)))
                .collect(Collectors.toCollection(ArrayList::new));

        var res = algoRecursionUnderTest.powerset(listForTest);        

        assertArrayEquals(res.toArray(), listForCheck.toArray());
    }

    @Test
    public void phoneNumberMnemonicsTest(){
        String[] array = {"ad","ae","af","bd","be","bf","cd","ce","cf"};
        var res = algoRecursionUnderTest.phoneNumberMnemonics("23");
        assertArrayEquals(array,res.toArray());
    }

}

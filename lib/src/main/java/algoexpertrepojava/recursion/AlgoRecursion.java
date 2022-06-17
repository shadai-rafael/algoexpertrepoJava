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

import java.util.Hashtable;
import java.util.Map;

public class AlgoRecursion {

    static private AlgoRecursion algoRecursion = null;

    private AlgoRecursion(){    
    }
  
    static public synchronized AlgoRecursion getInstance(){
      if(algoRecursion == null){
        algoRecursion = new AlgoRecursion();
        return algoRecursion;
      }else{
        return algoRecursion;
      }
    }

/*Fibonacci sequence
 * The Fibonacci sequence is defined as follows: The first number of the sequence is 0,
 * the second number is 1, and the nth number is the sum of the nth(nth-1) and nth(nth-2)
 * numbers. Write a function that takes the integer n and returns the nth Fibonacci number
 */
    public int getNthFib(int n) {

      Map<Integer,Integer> fibMap = new Hashtable<Integer,Integer>();
      return calculateNthFib(n,fibMap);
    }

    private int calculateNthFib(int n, Map<Integer,Integer> fibMap){
      if(n == 1){
        return 0;
      }
      if(n == 2){
        return 1;
      }

      if(fibMap.containsKey(n)){
        return fibMap.get(n);
      }else{
        return getNthFib(n-1) + getNthFib(n-2);
      }
    }
}

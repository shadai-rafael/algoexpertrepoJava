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
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

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

/*Product Sum
 *Write a function that takes in a "special" and returns its product sum.
 *A special array is a non-empty array that contain either integers or other special
 *arrays. The product sum of a "special" array is the sum of its elements, where "special"
 *arrays inside it are summed themselves and multiplied it by their level of depth.
 *The depth of a "special" array is how far nested it is. For instance the depth of []
 *is 1; the depth of the inner array [[]] is 2; the depth of the innermost array in [[[]]] is
 *3.
 */
  public int productSum(List<Object> array) {
    return productSumHelper(array,1);
  }

  private int productSumHelper(List<Object> array, int level){
    int sum = 0;
    for(Object item : array){
      if(item instanceof Integer)
      {
        sum = sum + (Integer)item;
      }else if(item instanceof ArrayList){
        sum = sum + productSumHelper((List<Object>)item,level + 1);
      }
    }
    return level*sum;
  }

/*Permutation
 *Write a function that takes in an array of unique integers and returns an array
 *of all permutations of those integers in no particular order.
 */
  public List<List<Integer>> getPermutations(List<Integer> array) {

    if(array.size() < 2){
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      if(array.size() > 0)
        list.add(array);
      return list;
    }

    List<List<Integer>> finalList = new ArrayList<List<Integer>>();

    for(int i=0;i<array.size();i++){
      Integer holder = array.get(i);
      List<Integer> subArray = new ArrayList<>(array);
      subArray.remove(i);
      var subList = getPermutations(subArray);
      for (List<Integer> tempList : subList) {
        tempList.add(0, holder);
      }
      finalList.addAll(subList);
    }

    return finalList;
  }

}

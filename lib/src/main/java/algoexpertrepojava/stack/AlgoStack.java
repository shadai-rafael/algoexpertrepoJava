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
package algoexpertrepojava.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class AlgoStack {

    static private AlgoStack algoStack = null;

    private AlgoStack(){    
    }
  
    static public synchronized AlgoStack getInstance(){
      if(algoStack == null){
        algoStack = new AlgoStack();
        return algoStack;
      }else{
        return algoStack;
      }
    }

/*
*Banlanced Brackets
*Write a function that takes in a string made up of brackets ([{}]) and other
*optional characters. The function should return a boolean representing whether
*the string is balanced with regards of brackets.
 */

    private boolean checkTheBrackets(Character chr, String str){
        for(int i=0;i<str.length();i++){        
            if( chr.compareTo(str.charAt(i)) == 0){
                return true;
            }    
        }
        return false;
    }

    public boolean balancedBrackets(String str){
        String brackets = "(){}[]";
        String openBrackets = "({[";

        Deque<Character> stack = new LinkedList<>();

        for(int i=0;i<str.length();i++){            
            if(checkTheBrackets(str.charAt(i), brackets)){
                if(checkTheBrackets(str.charAt(i), openBrackets)){
                    stack.push(str.charAt(i));
                }else{
                    if(stack.isEmpty()){
                      return false;
                    }
                    var chr = stack.peek();
                    if(chr.compareTo('(') == 0 && str.charAt(i) == ')'){
                        stack.pop();
                        continue;
                    }else if(chr.compareTo('[') == 0 && str.charAt(i) == ']'){
                        stack.pop();
                        continue;
                    }else if(chr.compareTo('{') == 0 && str.charAt(i) == '}'){
                        stack.pop();
                        continue;
                    }else{
                        break;
                    }
                }
            }else{
                continue;
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

/*Sunset Views
 * Given an array of buildings and a direction that all of the building face, return an
 * array of the indices that can see the sunset.
 * A building can see the sunset if it is extrictly taller than all of the buildings that
 * come after it in the direction that it faces.
 * The input array named buildings contains positive non zero integers representing the
 * heights of the buildings. A building at index i is denoted by building[i]. All of the
 * buildings face the same direction, and this direction is EAST or WEST. In relation to 
 * the input array, you can interpret this directions as right for the east and left for
 * west.
*/
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction){
    
        int index = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
    
        result.add(index);
    
        if(buildings.length <= 1){
            if(buildings.length == 0 ) result.clear();
            return result;
        }

        if(direction.equals("EAST")){
            index = buildings.length - 1;
            result.remove(0);
            result.add(index);
            do{
                if(buildings[index] > buildings[result.get(0)]){
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(index);
                    temp.addAll(result);
                    result = temp;
                }
                index--;
            }while(index >= 0);
        }else{
            do{
                if(buildings[index] > buildings[result.get(result.size()-1)]){
                    result.add(index);
                }
                index++;
            }while(index < buildings.length);
        }

        return result;
    }

/*Sort Stack
 * Write a function that takes in an array of integers representing a stack, recursively sort
 * the stack in place and returns it.
 * The array must be treated as stack with the end of the array as the top of the stack. 
 * Therefore you are only allowed to:
 * *Pop elements to the top of the stack by appending elements from the end of the array using the
 * built-in pop method of your programming language of choice.
 * *Push elements from the top of the stack by appending elements to the end of the array using the
 * built-in append method of your programming language of choice.
 * *Peek at the element on top of the stack by accessing the last element in the array.
 */
    private ArrayList<Integer> sortStackHelper(ArrayList<Integer> stack, int i){
        int greaterNumber = 0;
  
            if(stack.size() == i){
                return stack;
            }
            
            if(stack.get(stack.size() - 1) > stack.get(stack.size() - 2)){
                greaterNumber = stack.remove(stack.size() - 1);
            }else{
                int temp = stack.remove(stack.size() - 1);
                greaterNumber = stack.remove(stack.size() - 1);
                stack.add(temp);            
            }
    
            sortStackHelper(stack,i);
    
            stack.add(greaterNumber);
    
        return stack;
    }

    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        for(int i=1;i<stack.size();i++){
            sortStackHelper(stack,i);
        }
        return stack;
    }
}
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
package algoexpertrepojava.string;

import java.util.HashMap;
import java.util.Map;

public class AlgoString {

  static private AlgoString algoString = null;

  private AlgoString(){    
  }

  static public synchronized AlgoString getInstance(){
    if(algoString == null){
      algoString = new AlgoString();
      return algoString;
    }else{
      return algoString;
    }
  }

  public boolean isPalindrome(String str) {
    int middleIndex = (str.length()/2)-1;
    boolean result = true;
    for(int i = 0; i <= middleIndex ;i++){
      if(str.charAt(i) != str.charAt(str.length()-1-i)){
        result = false;
        break;
      }
    }
    return result;
  }

  public String caesarCypherEncryptor(String str, int key) {
    char alphabetSize = ('z'-'a')+1;
    StringBuilder strBuilder = new StringBuilder();
    for (char ch: str.toCharArray()) {
      strBuilder = strBuilder.append((char) ('a' + (((ch-'a') + key) %alphabetSize)));
    }
    return strBuilder.toString();
  }

  public String runLengthEncoding(String string) {
    StringBuilder strBuilder = new StringBuilder();
    int letterCounter = 0;
    char letter = '\0';
    for (int i = 0;i<string.length();i++) {
      letter = string.charAt(i);
      while( i < string.length() && letter == string.charAt(i)){
        letterCounter++;
        if(letterCounter == 9){
          strBuilder.append(Integer.valueOf(letterCounter).toString());
          strBuilder.append(letter);
          letterCounter = 0;
          break;
        }
        i++;
      }
      if(letterCounter!=0){
        strBuilder.append(Integer.valueOf(letterCounter).toString());
        strBuilder.append(letter);
        letterCounter = 0;
        i--;
      }
    }
    return strBuilder.toString();
  }

  public boolean generateDocument(String characters, String document) {
    boolean result = true;
    HashMap<Character, Integer> mapCharacter = new HashMap<>();
    HashMap<Character, Integer> mapDocument = new HashMap<>();

    for (char ch: characters.toCharArray()) {
      if(mapCharacter.containsKey(ch)){
        int frequency = mapCharacter.get(ch);
        frequency++;
        mapCharacter.put(ch,frequency);
      }else{
        mapCharacter.put(ch,1);
      }
    }

    for (char ch: document.toCharArray()) {
      if(mapDocument.containsKey(ch)){
        int frequency = mapDocument.get(ch);
        frequency++;
        mapDocument.put(ch,frequency);
      }else{
        mapDocument.put(ch,1);
      }
    }

    for (Map.Entry documentPair : mapDocument.entrySet()) {
      char documentKey = (char)documentPair.getKey();
      if(mapCharacter.containsKey(documentKey)){
        int charFreq = mapCharacter.get(documentKey);
        if(charFreq >= (int)documentPair.getValue()){
          continue;
        }else{
          result = false;
          break;
        }
      }
      else{
        result = false;
        break;
      }
  }

    return result;
  }
}
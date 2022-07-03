package algoexpertrepojava.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class AlgoHashTable {

    static private AlgoHashTable algoHashTable = null;

    private AlgoHashTable(){    
    }
  
    static public synchronized AlgoHashTable getInstance(){
      if(algoHashTable == null){
        algoHashTable = new AlgoHashTable();
        return algoHashTable;
      }else{
        return algoHashTable;
      }
    }

/*
 * Partition into anagrams
 * Anagrams are popular word play puzzles, where by rearranging letters of one
 * set of words you get another set of words for example, "eleven plus two" is an
 * anagram of "twelve plus one".
 * Write a program that takes as input a set of words and returns groups of anagrams 
 * for those words.
 */
    public List<List<String>> findAnagrams(List<String> dictionary){

        List<String> sorterdDictionary = dictionary.stream()
                                                .map((s)->{
                                                    char[] chr = s.toCharArray();
                                                    Arrays.sort(chr);
                                                    return String.valueOf(chr);
                                                })
                                                .collect(Collectors.toList());
        
        Map<String,List<String>> mapAnagrams = new HashMap<>();

        for(int i = 0;i< sorterdDictionary.size();i++){            
            if(!mapAnagrams.containsKey(sorterdDictionary.get(i))){           
                mapAnagrams.put(sorterdDictionary.get(i), new ArrayList<String>());
            }
            mapAnagrams.get(sorterdDictionary.get(i)).add(dictionary.get(i));
        }

        List<List<String>> anagrams = new ArrayList<>();

        for(Entry<String, List<String>> anagramGroup : mapAnagrams.entrySet()){
           if(anagramGroup.getValue().size()>1){
                anagrams.add(anagramGroup.getValue());
            }
        }
        return anagrams;
    }
}

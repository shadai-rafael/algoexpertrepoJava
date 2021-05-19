package algoexpertrepojava.string;

import org.junit.Test;
import static org.junit.Assert.*;
import algoexpertrepojava.string.AlgoString;

public class AlgoStringTest{
    @Test public void isPalindromeTest(){
        AlgoString algoStringUnderTest = new AlgoString();
        assertTrue(algoStringUnderTest.isPalindrome("abba"));
        assertTrue(algoStringUnderTest.isPalindrome("abiba"));
        assertTrue(!algoStringUnderTest.isPalindrome("chili"));
        assertTrue(!algoStringUnderTest.isPalindrome("abb"));
    }

    @Test public void caesarCypherEncryptorTest(){
        AlgoString algoStringUnderTest = new AlgoString();
        String result = algoStringUnderTest.caesarCypherEncryptor("xyz",2);
        assertTrue(result.equalsIgnoreCase("zab"));
    }

    @Test public void runLengthEncodingTest(){
        AlgoString algoStringUnderTest = new AlgoString();
        String result = algoStringUnderTest.runLengthEncoding("        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        assertTrue(result.equalsIgnoreCase("8 9a9a9a9a9a4a"));
    }
}

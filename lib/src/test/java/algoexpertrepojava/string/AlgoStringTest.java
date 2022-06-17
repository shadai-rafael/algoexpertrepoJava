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

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import algoexpertrepojava.string.AlgoString;

public class AlgoStringTest{

    private AlgoString algoStringUnderTest = null;

    @Before
    public void init(){
        algoStringUnderTest = AlgoString.getInstance();
    }

    @Test public void isPalindromeTest(){
        assertTrue(algoStringUnderTest.isPalindrome("abba"));
        assertTrue(algoStringUnderTest.isPalindrome("abiba"));
        assertTrue(!algoStringUnderTest.isPalindrome("chili"));
        assertTrue(!algoStringUnderTest.isPalindrome("abb"));
    }

    @Test public void caesarCypherEncryptorTest(){
        String result = algoStringUnderTest.caesarCypherEncryptor("xyz",2);
        assertTrue(result.equalsIgnoreCase("zab"));
    }

    @Test public void runLengthEncodingTest(){
        String result = algoStringUnderTest.runLengthEncoding("        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        assertTrue(result.equalsIgnoreCase("8 9a9a9a9a9a4a"));
    }

    @Test public void generateDocumentTest(){
        assertTrue(algoStringUnderTest.
                   generateDocument("Bste!hetsi ogEAxpelrt x ",
                   "AlgoExpert is the Best!"));
        assertTrue(algoStringUnderTest.
                   generateDocument("a hsgalhsa sanbjksbdkjba kjx",
                   ""));
    }
}

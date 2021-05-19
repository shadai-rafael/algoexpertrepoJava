package algoexpertrepojava.string;

public class AlgoString {

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
}

package java;

import org.apache.ibatis.parsing.GenericTokenParser;
import org.apache.ibatis.parsing.TokenHandler;
import org.junit.Test;

public class GenericTokenParserTest {


  @Test
  public void testGenericTokenParser(){
    GenericTokenParser genericTokenParser = new GenericTokenParser("#{","}", new TokenHandler() {
      public String handleToken(String content) {
        if(content.equalsIgnoreCase("aaa")) return "哈哈哈";
        return content;
      }
    });
    System.out.println(genericTokenParser.parse("#{111}"));
    System.out.println(genericTokenParser.parse("#{aaa}"));
    System.out.println(genericTokenParser.parse("#{aa}"));
    System.out.println(genericTokenParser.parse("#{}"));
    System.out.println(genericTokenParser.parse("#{1"));
  }
}

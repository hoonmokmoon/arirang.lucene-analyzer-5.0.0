package test.org.apache.lucene.analysis.ko;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.ko.KoreanAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import junit.framework.TestCase;

public class TestKoreanAnalyzer extends TestCase {

	public void testKoreanAnalyzer() throws Exception {
		
		String input = "정보화용역사업";

		KoreanAnalyzer a = new KoreanAnalyzer();
		a.setQueryMode(false);
		
		StringBuilder actual = new StringBuilder();
		
		TokenStream ts = a.tokenStream("bogus", input);
	    CharTermAttribute termAtt = ts.addAttribute(CharTermAttribute.class);
	    ts.reset();
	    while (ts.incrementToken()) {
	      actual.append(termAtt.toString());
	      actual.append(' ');
	    }
	    System.out.println(actual);

	    ts.end();
	    ts.close();
	}
	
	public void testConvertUnicode() throws Exception {
		char c = 0x772C;
		System.out.println(c);
		
		int code = '領';
		System.out.println(code);
		
		System.out.println(Character.getType('&'));
	}
}

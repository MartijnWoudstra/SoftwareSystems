package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello World";

        System.out.println(Hex.encodeHexString(input.getBytes()));
        
        input = "Hello Big World";
        
        System.out.println(Hex.encodeHexString(input.getBytes()));
 
        
        System.out.println("4d6f64756c652032");
        
        System.out.println(Base64.encodeBase64String(input.getBytes()));
        
        String s = "010203040506";
        char[] bytes = s.toCharArray();
        System.out.println("hereeee " + new String(Base64.encodeBase64(Hex.decodeHex(bytes))));
        
        
        System.out.println(decodeBase64("010203040506"));
        
        System.out.println(decodeBase64("U29mdHdhcmUgU31zdGVtcw=="));   
        
        printAs(); 
    }
    
    private static String decodeBase64(String string){
    	byte[] aa = Base64.decodeBase64(string);
    	return new String(aa);
    }
    
    private static String decodeHex(String string) throws DecoderException {
    	byte[] a = Hex.decodeHex(string.toCharArray());
    	return new String(a);
    }
    
    private static void printAs(){
    	String s = "a";
    	for(int i = 1; i < 10; i++) {
    		System.out.println(encodeBase64(s));
    		s = s + "a";
    	}
    }
    
    private static String encodeBase64(String string) {
    	return new String(Base64.encodeBase64(string.getBytes()));
    	
    }
}

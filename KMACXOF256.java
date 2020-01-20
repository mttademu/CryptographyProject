import java.math.BigInteger;

public class KMACXOF256 {

	//Constants
	
	//Rount constants (BigInteger) 
	private BigInteger[] RC = new BigInteger[24];
	
	//String representations of the constants; to populate RC on radix 16
	private String[] toRC = {"0000000000000001", "0000000000008082", "800000000000808A", "8000000080008000",
			"000000000000808B", "0000000080000001", "8000000080008081", "8000000000008009", "000000000000008A",
			"0000000000000088", "0000000080008009", "000000008000000A", "000000008000808B", "8000000000008089",
			"8000000000008003", "8000000000008002", "8000000000000080", "000000000000800A", "800000008000000A", 
			"8000000080008081", "8000000000008080", "0000000080000001", "8000000080008008"}; 
	
	/**
	 * 
	 * @param k Key
	 * @param m Authenticated data
	 * @param L output bit length
	 * @param S diversification string
	 */
	public KMACXOF256(final BigInteger k, final String m, final int L, final String S) {
		
		//Initialize round constants
		for (int i = 0; i < 24; i++) {
			
			RC[i] = new BigInteger(toRC[i], 16);
		}
		
	}
	
	

	//Prepends an encoding of the integer w to the string x, and pads the result
	//with zeros until it is a byte string whose length in bytes is a multiple
	//of w
	//used for encoded strings
	public String bytepad(String x, int w) {
		
		String z = left_encode(w);
		while (z.length() % 8 != 0) {
			
			z = z + "0";
		}
		while ((z.length() / 8.0) % w != 0) {
			
			z = z + "00000000";
			
		}
		
		return z;
		
	}
	
	//if s.length() < 2^2040,
	//Returns the left_encode of the string's length concatenated w the string
	public String encode_string(String s) {
		
		return left_encode(s.length()) + s;
	}
	
	//Encode from the beginning of the string by inserting the
	//length of the byte string before the byte string representation of x
	/*
	 * Cond:
	 * n is smallest positive int for which 2^8n > x
	 * x = sum(2^8(n-i)*x_i for i = {1, n}
	 * O_i = enc_8(x_i), for i = {1, n}
	 * O_(n+1) = enc_8(n)
	 */
	public String left_encode(int x) {
		
		
		return null;
		
	}
	
	public String right_encode(int x){
		
		return null;
	}
	
	
	/*
	 * KMACXOF256(K, X, L, S):
Validity Conditions: len(K) <22040 and 0 â‰¤ L and len(S) < 22040
1. newX = bytepad(encode_string(K), 136) || X || right_encode(0).
2. T = bytepad(encode_string(â€œKMACâ€�) || encode_string(S), 136).
3. return KECCAK[512](T || newX || 00, L).

	KMACXOF256(String k, String x, ...
	 */
	
	
}

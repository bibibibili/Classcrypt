package swt;
import java.util.*;
class ReverseCipher extends Cryptography{
	public String Encrypt() {
		
		String complete=new StringBuilder(this.plainText).reverse().toString();
		return complete;

		
	}
}

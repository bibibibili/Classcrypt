package swt;
import java.util.*;


class Caesar extends Cryptography {
	
	int key=0; //key for decryption
	char[] ch={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','h','y','z'}; 
	
	public String Encrypt() {
		
		
		char encrypted = 0;
		String complete="";
		for(int i=0; i<this.plainText.length();i++) { //Encrypt each character in plain text
			if(this.plainText.charAt(i)<=122&& this.plainText.charAt(i)>=97 ) {
				if(this.plainText.charAt(i)+this.key>122)
					encrypted=(char) (this.plainText.charAt(i)+this.key-26); 
				
				else
					encrypted=(char) (this.plainText.charAt(i)+this.key);
				complete=complete+encrypted;
			}
			else if(this.plainText.charAt(i)<=90&& this.plainText.charAt(i)>=65) {
				if(this.plainText.charAt(i)+this.key>90)
					encrypted=(char) (this.plainText.charAt(i)+this.key-26); 
				
				else
					encrypted=(char) (this.plainText.charAt(i)+this.key);
				complete=complete+encrypted;
			}
			else if(this.plainText.charAt(i)==32) {
				complete=complete+" ";
			}
		
		}
		System.out.println("Your result is: "+complete);
		return complete;
	}
	
	public String Decrypt() {
		
		int index=0;
		String complete1="The result is: ";
		for(int i=1;i<26;i++) { //Decrypt with key from 1 to 26
			char Decrypted;
			String complete="";
			for(int j=0; j<this.cipherText.length();j++) { //Decrypt each character in encrypted text
				if((this.cipherText.charAt(j)<=122&& this.cipherText.charAt(j)>=97)
						||this.cipherText.charAt(j)<=90&& this.cipherText.charAt(j)>=65) {
				for(int g=0;g<ch.length;g++){
					if(this.cipherText.charAt(j)==ch[g]||Character.toUpperCase(ch[g])==this.cipherText.charAt(j)) { //Check character's position in Alphabet
						index=g+1;
						break;
					}
				}
				if(index<=i) Decrypted=(char) (this.cipherText.charAt(j)+26-i); 
				else  Decrypted=(char) (this.cipherText.charAt(j)-i);
				
				//Combine character to complete text
				complete=complete+Decrypted;
				index=0;
				}
				else if(this.cipherText.charAt(j)==32){
					complete=complete+" ";
					index=0;
				}
				else {
					index=0;
				}
			}
			complete1=complete1+"\n"+ "Key " + i+ ": "+complete;
			
		
			
		}
		System.out.println(complete1);
		return complete1;
	}
}


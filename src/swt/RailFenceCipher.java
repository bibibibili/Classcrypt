package swt;
import java.util.Scanner;

public class RailFenceCipher extends Cryptography {
	int key=0;
	
	public String Encrypt() {
		
		
		int length=this.plainText.length();
		int arrays[][] = new int[this.key][length]; //the table made by numbers of rails and length of plain text
		for(int i=0;i<this.key;i++) {//Add character in encode table to complete string
			for(int j=0;j<length;j++) {
				arrays[i][j]='*';
				
			}

		}
		int currentRow=0;
		int currentColumn=0;
		
		/*
		 tag is for checking the direction is up or down
		 	true: Move from top to bottom
		 	false: Move from bottom to top
		 */
		boolean tag=true; 
		for(int i=0;i<length;i++) {// put each character to suitable position
			if(currentRow==0&&tag==false) {//If move to from the bottom to top, then start to go down again
				
				currentRow=currentRow+1; //start new cycle
							
				tag=true;//change tag to move from top to bottom
			}
			if((currentRow+1<=this.key)&&(tag==true)) {//Move from top to bottom
			
				arrays[currentRow][currentColumn]=this.plainText.charAt(i);
				
				currentColumn=currentColumn+1;
				currentRow=currentRow+1;
				
			}
			else { //start changing direction to bottom to top
				if(currentRow+1>this.key)currentRow=currentRow-2; 
				else currentRow=currentRow-1;
				tag=false;
				
				arrays[currentRow][currentColumn]=this.plainText.charAt(i);

				currentColumn=currentColumn+1;
				
			}
		}
		String completeString="";
		
		for(int i=0;i<this.key;i++) {//Add character in encode table to complete string
			for(int j=0;j<length;j++) {
				if((char)arrays[i][j]!='*') 
					
					completeString=completeString+(char)arrays[i][j];
				else completeString=completeString;
				
			}

		}
		
		System.out.println(completeString);
		return completeString;
	}
	public String Decrypt() {
		
		int length=this.cipherText.length();
		int arrays[][] = new int[this.key][length]; //the table made by numbers of rails and length of plain text
		int currentRow=0;
		int currentColumn=0;
		/*
		 tag is for checking the direction is up or down
		 	true: Move from top to bottom
		 	false: Move from bottom to top
		 */
		boolean tag=true; 
		//Draw ZigZag
		for(int i=0;i<length;i++) {
			if(currentRow==0&&tag==false) {//If move to from the bottom to top, then start to go down again
				
				currentRow=currentRow+1; //start new cycle
				arrays[currentRow][currentColumn]='.';
				
				tag=true;//change tag to move from top to bottom
			}
			if((currentRow+1<=this.key)&&(tag==true)) {//Move from top to bottom
			
				arrays[currentRow][currentColumn]='.';
				
				currentColumn=currentColumn+1;
				currentRow=currentRow+1;
				
			}
			else { //start changing direction to bottom to top
				if(currentRow+1>this.key)currentRow=currentRow-2; 
				else currentRow=currentRow-1;
				tag=false;
				
				arrays[currentRow][currentColumn]='.';

				currentColumn=currentColumn+1;
				
			}
		}
		
		//Fill text to predefine zigzag
		currentRow=0;
		for(int i=0; i<length;i++) {//put each character to table

			for(int j=0;j<length;j++) {
				
				if(arrays[currentRow][j]=='.') {
					arrays[currentRow][j]=this.cipherText.charAt(i);
				
					j=length;
				}
				else if(j+1==length) {
					currentRow=currentRow+1;
					i=i-1;
					break;
					
				}
			
			}
		
		}
		
		//Read
		tag=true;
		currentRow=0;
		currentColumn=0;
		String completeString="";
		for(int i=0;i<length;i++) {
			if(currentRow==0&&tag==false) {//If move to from the bottom to top, then start to go down again
				
				currentRow=currentRow+1; //start new cycle
				 
				
				tag=true;//change tag to move from top to bottom
				
			}
			if((currentRow+1<=this.key)&&(tag==true)) {//Move from top to bottom
			
				completeString= completeString+(char)arrays[currentRow][currentColumn];
				
				currentColumn=currentColumn+1;
				currentRow=currentRow+1;
				
			}
			else { //start changing direction to bottom to top
				if(currentRow+1>this.key)currentRow=currentRow-2; 
				else currentRow=currentRow-1;
				tag=false;
				
				completeString= completeString+(char)arrays[currentRow][currentColumn];
				
				currentColumn=currentColumn+1;
				
			}
		}
		return completeString;
	}
}

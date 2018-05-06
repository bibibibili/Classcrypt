package swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class RailFenceDecryptUI {

	protected Shell shell;
	private Text text;
	private Text text_1;
	int key=2;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RailFenceDecryptUI window = new RailFenceDecryptUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(726, 481);
		shell.setText("SWT Application");
		RowLayout rowLayout = new RowLayout();
		 
	 
	    Combo comboDropDown = new Combo(shell, SWT.DROP_DOWN | SWT.BORDER);
	    
	    comboDropDown.addSelectionListener(new SelectionAdapter() {
	    	
	    	 public void widgetSelected(SelectionEvent e) {
	    	        key=Integer.parseInt(comboDropDown.getText());
	    	      }
	    
	    });
	    comboDropDown.setBounds(601, 354, 52, 28);
	    comboDropDown.setText("2");
	    
	    CLabel lblSelectKey = new CLabel(shell, SWT.NONE);
	    lblSelectKey.setBounds(519, 356, 76, 26);
	    lblSelectKey.setText("Select key:");
	    
	    Label lblNewLabel = new Label(shell, SWT.NONE);
	    lblNewLabel.setBounds(32, 244, 70, 20);
	    lblNewLabel.setText("Plain text");
	    
	    Label lblCypherText = new Label(shell, SWT.NONE);
	    lblCypherText.setText("Cypher text");
	    lblCypherText.setBounds(32, 77, 87, 20);
	    
	    for(int i=2; i<=26; i++) {
	     
	      comboDropDown.add(""+i);
	      
	      
	
	    }
	   
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(125, 0, 583, 172);
		

		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(125, 178, 583, 154);
		text_1.setEditable(false);
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Get the plain text
		        final String input = text.getText();
		        
		        RailFenceCipher rf=new RailFenceCipher();
		        rf.cipherText=input;
		        rf.key=key;
		        System.out.println(rf.key);
		        final String output=rf.Decrypt();
		        text_1.setText(output);
		        
		        
			}
		});
		btnNewButton.setBounds(361, 352, 90, 30);
		btnNewButton.setText("Decrypt");
		
		 
		
		
		
		 

		

	}

}

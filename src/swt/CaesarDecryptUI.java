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
import org.eclipse.swt.custom.ScrolledComposite;

public class CaesarDecryptUI {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CaesarDecryptUI window = new CaesarDecryptUI();
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
	    
	    Label lblNewLabel = new Label(shell, SWT.NONE);
	    lblNewLabel.setBounds(27, 66, 92, 20);
	    lblNewLabel.setText("Cypher text");
	    
	    Label lblCypherText = new Label(shell, SWT.NONE);
	    lblCypherText.setText("Plain text");
	    lblCypherText.setBounds(27, 241, 92, 20);
	    
	   
	   
		
		Text text = new Text(shell, SWT.BORDER);
		text.setBounds(125, 0, 583, 172);
		

		Text text_1 = new Text(shell, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		text_1.setBounds(125, 178, 583, 154);
		text_1.setEditable(false);
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Get the plain text
		        final String input = text.getText();
		        
		        Caesar caesar=new Caesar();
		        caesar.cipherText=input;
		       
		       
		        final String output=caesar.Decrypt();
		        text_1.setText(output);
		        
		        
			}
		});
		btnNewButton.setBounds(361, 352, 90, 30);
		btnNewButton.setText("Decrypt");
		
		 


	}
}

package swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CaesarUI {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CaesarUI window = new CaesarUI();
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button btnEncrypt = new Button(shell, SWT.NONE);
		btnEncrypt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CaesarEncryptUI encryptWindow=new CaesarEncryptUI();
				encryptWindow.open();
			}
		});
		btnEncrypt.setBounds(177, 50, 90, 30);
		btnEncrypt.setText("Encrypt");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CaesarDecryptUI decryptWindow=new CaesarDecryptUI();
				decryptWindow.open();
			}
		});
		btnNewButton.setBounds(177, 101, 90, 30);
		btnNewButton.setText("Decrypt");
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				CryptographyUI returnUI=new CryptographyUI();
				returnUI.open();
			}
		});
		btnBack.setBounds(177, 155, 90, 30);
		btnBack.setText("Back");

	}
}

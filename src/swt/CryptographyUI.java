package swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CryptographyUI {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CryptographyUI window = new CryptographyUI();
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
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CaesarUI a=new CaesarUI();
				shell.close();
				a.open();
		
			}
		});
		btnNewButton.setBounds(160, 24, 108, 39);
		btnNewButton.setText("Caesar");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ReverseUI reverse=new ReverseUI();
				reverse.open();
			}
		});
		btnNewButton_1.setBounds(160, 79, 108, 39);
		btnNewButton_1.setText("Reverse ");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setBounds(160, 189, 108, 39);
		btnNewButton_2.setText("Exit");
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				RailFenceUI rfe=new RailFenceUI();
				shell.close();
				rfe.open();
			}
		});
		button.setText("Rail Fence");
		button.setBounds(160, 134, 108, 39);

	}
}

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

public class ReverseUI {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ReverseUI window = new ReverseUI();
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
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(101, 167, 607, 161);
		text.setEditable(false);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(101, 4, 607, 155);
	
		Label lblText = new Label(shell, SWT.NONE);
		lblText.setBounds(26, 233, 70, 20);
		lblText.setText("Result");
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("Text");
		label.setBounds(26, 83, 70, 20);
		
		Button btnConvert = new Button(shell, SWT.NONE);
		btnConvert.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ReverseCipher reverse=new ReverseCipher();
				reverse.plainText=text_1.getText();
				String output=reverse.Encrypt();
				text.setText(output);
			}
		});
		btnConvert.setBounds(355, 352, 90, 30);
		btnConvert.setText("Convert ");
		

	}
}

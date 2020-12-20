package tr.com.mdb.test;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;


import tr.com.mdb.FrontEnd.LoginFE;
import javax.swing.UIManager.*;

public class Run {

	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// new AnaPencereUI();
				new LoginFE();
			}
		});
	}
}

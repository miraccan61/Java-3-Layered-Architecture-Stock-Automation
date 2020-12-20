package tr.com.mdb.FrontEnd;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;

import tr.com.mdb.DAL.DALAccounts;
import tr.com.mdb.DAL.DALPersonel;
import tr.com.mdb.Interfaces.FrontEndInterfaces;
import tr.com.mdb.Types.PersonelContract;

public class LoginFE extends JDialog implements FrontEndInterfaces {

	public static JComboBox emailBox;

	public LoginFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Lütfen Sisteme Giriþ Yapmak için Bilgilerinizi Giriniz"));
		add(panel);
		setTitle("Lütfen Giriþ Yapýnýz");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new GridLayout(3, 2));
		JLabel emailLabel = new JLabel("Email", JLabel.RIGHT);
		panel.add(emailLabel);
		emailBox = new JComboBox(new DALPersonel().GetAll().toArray());
		panel.add(emailBox);
		JLabel passwordLabel = new JLabel("Þifreniz", JLabel.RIGHT);
		panel.add(passwordLabel);
		JPasswordField passwordField = new JPasswordField(15);

		panel.add(passwordField);

		JButton loginButton = new JButton("Giriþ Yap");
		panel.add(loginButton);
		JButton iptalButton = new JButton("Ýptal");

		iptalButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		panel.add(iptalButton);

		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonelContract contract = (PersonelContract) emailBox.getSelectedItem();
				String sifre = passwordField.getText();
				if (new DALAccounts().GetPersonelIdVeSifre(contract.getId(), sifre).getId() != 0) {
					new AnaPencereUI();
				} else {
					JOptionPane.showMessageDialog(null, "Giriþ Baþarýsýz");
				}

			}
		});

		return panel;
	}

	@Override
	public JMenuBar initBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}

}

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
import tr.com.mdb.DAL.DALYetkiler;
import tr.com.mdb.Interfaces.FrontEndInterfaces;
import tr.com.mdb.Types.AccountsContract;
import tr.com.mdb.Types.PersonelContract;
import tr.com.mdb.Types.YetkilerContract;

public class SifreÝslemleriFE extends JDialog implements FrontEndInterfaces {

	public SifreÝslemleriFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Þifre Belirleme Ýþlemleri"));
		add(panel);
		setTitle("Þifre Belirleme Ýþlemleri");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(5, 2));
		JLabel personelLabel = new JLabel("Personel Seç", JLabel.RIGHT);
		panel.add(personelLabel);
		JComboBox personelBox = new JComboBox(new DALPersonel().GetAll().toArray());
		panel.add(personelBox);
		JLabel yetkiLabel = new JLabel("Yetki Seç", JLabel.RIGHT);
		panel.add(yetkiLabel);
		JComboBox yetkiBox = new JComboBox(new DALYetkiler().GetAll().toArray());
		panel.add(yetkiBox);
		JLabel passwordLabel = new JLabel("Þifre belirle", JLabel.RIGHT);
		panel.add(passwordLabel);
		JPasswordField passField = new JPasswordField(10);
		panel.add(passField);
		JLabel passTekrarLabel = new JLabel("Þifre Tekrar", JLabel.RIGHT);
		panel.add(passTekrarLabel);
		JPasswordField passTekrarField = new JPasswordField(10);
		panel.add(passTekrarField);

		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptalButton = new JButton("Ýptal");
		panel.add(iptalButton);
  
		iptalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		kaydetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AccountsContract contract = new AccountsContract();
				PersonelContract pContract = (PersonelContract) personelBox.getSelectedItem();
				YetkilerContract yContract = (YetkilerContract) yetkiBox.getSelectedItem();

				if (passField.getText().equals(passTekrarField.getText())) {
					contract.setPersonelId(pContract.getId());
					contract.setYetkiId(yContract.getId());
					contract.setSifre(passField.getText());
					new DALAccounts().Insert(contract);
					JOptionPane.showMessageDialog(null,
							pContract.getAdiSoyadi() + " adlý kiþiye" + yContract.getAdi() + " yetkisi verilmiþtir.");
				} else {
					JOptionPane.showMessageDialog(null, "Þifreler Eþleþmiyor");
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

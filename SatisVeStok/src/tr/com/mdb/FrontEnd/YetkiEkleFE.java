package tr.com.mdb.FrontEnd;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.mdb.DAL.DALYetkiler;
import tr.com.mdb.Interfaces.FrontEndInterfaces;
import tr.com.mdb.Types.YetkilerContract;

public class YetkiEkleFE extends JDialog implements FrontEndInterfaces {

	public YetkiEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Yetki Ekle"));
		add(panel);

		setTitle("Yetki Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(2, 2));
		JLabel adiLabel = new JLabel("Yetki Adý", JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(10);
		panel.add(adiField);
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
				YetkilerContract contract = new YetkilerContract();
				contract.setAdi(adiField.getText());
				new DALYetkiler().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdi() + " adli yetki baþarýlý bir þekilde eklendi");

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

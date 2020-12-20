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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultEditorKit.InsertContentAction;

import tr.com.mdb.DAL.DALKategori;
import tr.com.mdb.Interfaces.FrontEndInterfaces;
import tr.com.mdb.Types.KategoriContract;

public class kategoriEkleFE extends JDialog implements FrontEndInterfaces {

	public kategoriEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Kategori Ekle"));
		add(panel);
		setTitle("Kategori EKle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	
	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(3, 2));

		JLabel adiLabel = new JLabel("Kategori Adý:", JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(10);
		panel.add(adiField);

		JLabel kategoriLabel = new JLabel("Kategori Seç:", JLabel.RIGHT);
		panel.add(kategoriLabel);
		JComboBox kategoriBox = new JComboBox(new DALKategori().GetAllParentId().toArray());
		panel.add(kategoriBox);

		kategoriBox.insertItemAt("--Kategori Seçiniz--", 0);
		kategoriBox.setSelectedIndex(0);
		

		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		kaydetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				KategoriContract contract = new KategoriContract();

				if (kategoriBox.getSelectedIndex() != 0) {
					KategoriContract casContract = (KategoriContract) kategoriBox.getSelectedItem();
					contract.setAdi(adiField.getText());
					contract.setParentId(casContract.getId());

					new DALKategori().Insert(contract);
					JOptionPane.showMessageDialog(null,
							contract.getAdi() + "Adlý Kategori Baþarýlý bir þekilde eklenmiþtir");
				} else {
					contract.setAdi(adiField.getText());
					contract.setParentId(kategoriBox.getSelectedIndex());

					new DALKategori().Insert(contract);
					JOptionPane.showMessageDialog(null,
							contract.getAdi() + "Adlý Kategori Baþarýlý bir þekilde eklenmiþtir");
					kategoriBox.addItem(new DALKategori().GetAllParentId().toArray());
				}

			}
		});
		JButton iptalButton = new JButton("Ýptal");
		iptalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		panel.add(iptalButton);

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

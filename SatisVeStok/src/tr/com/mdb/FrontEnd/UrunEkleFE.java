package tr.com.mdb.FrontEnd;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

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

import com.toedter.calendar.JDateChooser;

import tr.com.mdb.DAL.DALKategori;
import tr.com.mdb.DAL.DALUrunler;
import tr.com.mdb.Interfaces.FrontEndInterfaces;
import tr.com.mdb.Types.KategoriContract;
import tr.com.mdb.Types.UrunlerContract;

public class UrunEkleFE extends JDialog implements FrontEndInterfaces {

	public UrunEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Ürün Kayýt Alaný"));
		add(panel);
		setTitle("Ürün Ekleyin");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new GridLayout(5, 2));

		JLabel adiLabel = new JLabel("Ürün Adý:", JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(10);
		panel.add(adiField);

		JLabel kategoriLabel = new JLabel("Kategori Seç:", JLabel.RIGHT);
		panel.add(kategoriLabel);
		JComboBox kategoriBox = new JComboBox(new DALKategori().GetAll().toArray());
		panel.add(kategoriBox);

		JLabel tarihLabel = new JLabel("Tarih Gir:", JLabel.RIGHT);
		panel.add(tarihLabel);
		JDateChooser tarihDate = new JDateChooser();
		panel.add(tarihDate);

		JLabel fiyatLabel = new JLabel("Fiyat Gir:", JLabel.RIGHT);
		panel.add(fiyatLabel);
		JTextField fiyatField = new JTextField(10);
		panel.add(fiyatField);

		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptalButton = new JButton("Ýptal");
		panel.add(iptalButton);
		kaydetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UrunlerContract contract = new UrunlerContract();
				KategoriContract casContract = (KategoriContract) kategoriBox.getSelectedItem();
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

				String date = format.format(tarihDate.getDate());
				contract.setAdi(adiField.getText());
				contract.setKategoriId(casContract.getId());
				contract.setTarih(date);
				contract.setFiyat(Float.parseFloat(fiyatField.getText()));

				new DALUrunler().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdi() + "adli ürün baþarýlý bir þekilde eklendi");

			}
		});
		
		iptalButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			   

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

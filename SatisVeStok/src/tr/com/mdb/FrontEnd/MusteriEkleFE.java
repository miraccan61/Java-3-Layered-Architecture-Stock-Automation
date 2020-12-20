package tr.com.mdb.FrontEnd;

import java.awt.BorderLayout;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import tr.com.mdb.DAL.DALMusteri;
import tr.com.mdb.DAL.DALPersonel;
import tr.com.mdb.Interfaces.FrontEndInterfaces;
import tr.com.mdb.Types.MusteriContract;
import tr.com.mdb.Types.PersonelContract;

public class MusteriEkleFE extends JDialog implements FrontEndInterfaces {

	public MusteriEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("M��teri Ekle"));

		add(panel);
		setTitle("M��teri Ekle");
		pack();
		setLocationRelativeTo(null);// bir yerle ili�kisi olsun mu demek
		setModalityType(DEFAULT_MODALITY_TYPE);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JPanel fieldPanel = new JPanel(new GridLayout(5, 2));
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		JLabel musteriAdiSoyadiLabel = new JLabel("Ad� Soyad�", JLabel.RIGHT);
		fieldPanel.add(musteriAdiSoyadiLabel);
		JTextField musteriAdiSoyadiField = new JTextField(15);
		fieldPanel.add(musteriAdiSoyadiField);

		JLabel musteriTelefonLabel = new JLabel("Telefon:", JLabel.RIGHT);
		fieldPanel.add(musteriTelefonLabel);
		JTextField musteriTelefonField = new JTextField(15);
		fieldPanel.add(musteriTelefonField);

		JLabel sehirSecLabel = new JLabel("�ehir Se�", JLabel.RIGHT);
		fieldPanel.add(sehirSecLabel);

		String[] items = { "�ehir Se�iniz", "Adana", "Ad�yaman", "Afyon", "A�r�", "Amasya", "Ankara", "Antalya",
				"Artvin", "Ayd�n", "Bal�kesir", "Bilecik", "Bing�l", "Bitlis", "Bolu", "Burdur", "Bursa", "�anakkale",
				"�ank�r�", "�orum", "Denizli", "Diyarbak�r", "Edirne", "Elaz��", "Erzincan", "Erzurum", "Eski�ehir",
				"Gaziantep", "Giresun", "G�m��hane", "Hakkari", "Hatay", "Isparta", "Mersin", "�stanbul", "�zmir",
				"Kars", "Kastamonu", "Kayseri", "K�rklareli", "K�r�ehir", "Kocaeli", "Konya", "K�tahya", "Malatya",
				"Manisa", "Kahramanmara�", "Mardin", "Mu�la", "Mu�", "Nev�ehir", "Ni�de", "Ordu", "Rize", "Sakarya",
				"Samsun", "Siirt", "Sinop", "Sivas", "Tekirda�", "Tokat", "Trabzon", "Tunceli", "�anl�urfa", "U�ak",
				"Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "K�r�kkale", "Batman", "��rnak",
				"Bart�n", "Ardahan", "I�d�r", "Yalova", "Karab�k", "Kilis", "Osmaniye", "D�zce" };
		JComboBox musteriSehirBox = new JComboBox<String>(items);
		fieldPanel.add(musteriSehirBox);
		JLabel musteriAdresLabel = new JLabel("Adres:");
		fieldPanel.add(musteriAdresLabel);
		JTextArea musteriAdresArea = new JTextArea(7, 1);
		JScrollPane pane = new JScrollPane(musteriAdresArea);

		pane.setBorder(BorderFactory.createTitledBorder("Adres Bilgisi"));

		JButton kaydetButton = new JButton("Kaydet");
		buttonPanel.add(kaydetButton);
		kaydetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MusteriContract contract = new MusteriContract();
				contract.setAdiSoyadi(musteriAdiSoyadiField.getText());
				contract.setTelefon(musteriTelefonField.getText());
				contract.setAdres(musteriAdresArea.getText());
				contract.setSehirName(musteriSehirBox.getSelectedItem().toString());

				new DALMusteri().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdiSoyadi() + " adl� personel eklendi");

			}
		});
		JButton iptalButton = new JButton("�ptal");
		buttonPanel.add(iptalButton);
		iptalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel.add(fieldPanel, BorderLayout.NORTH);
		panel.add(pane, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
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

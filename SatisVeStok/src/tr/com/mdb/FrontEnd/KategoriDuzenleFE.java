package tr.com.mdb.FrontEnd;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.mdb.DAL.DALKategori;
import tr.com.mdb.Interfaces.FrontEndInterfaces;

public class KategoriDuzenleFE extends JDialog implements FrontEndInterfaces {

	public KategoriDuzenleFE() {
		initPencere();
		
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		add(panel);
		setTitle("Kategori Listele");
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		/* kapanýnca hepsi kapanmasýn diye */
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	
	
	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Düzenleme Ýþlemleri"));
		JPanel ustPanel = new JPanel(new GridLayout(3, 2));
		ustPanel.setBorder(BorderFactory.createTitledBorder("Kategori Düzenle"));

		JLabel kategoriAdiLabel = new JLabel("Kategori Adý", JLabel.RIGHT);
		ustPanel.add(kategoriAdiLabel);
		JTextField kategoriAdiField = new JTextField(10);
		ustPanel.add(kategoriAdiField);

		JLabel ustKategoriLabel = new JLabel("Üst Kategorisi", JLabel.RIGHT);
		ustPanel.add(ustKategoriLabel);
		JComboBox ustKategoriBox = new JComboBox(new DALKategori().GetAll().toArray());
		ustPanel.add(ustKategoriBox);

		JList kategoriList = new JList();
		kategoriList.setListData(new DALKategori().GetAll().toArray());
		JScrollPane pane = new JScrollPane(kategoriList);
		pane.setBorder(BorderFactory.createTitledBorder("Düzenlenecek Liste"));
		kategoriList.setSelectedIndex(0);
		kategoriAdiField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				kategoriList.setListData(new DALKategori().GetSearchKategori(kategoriAdiField.getText()).toArray());
				kategoriList.setSelectedIndex(0);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		panel.add(ustPanel, BorderLayout.NORTH);
		panel.add(pane, BorderLayout.CENTER);

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

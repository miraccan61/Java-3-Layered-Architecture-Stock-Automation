package tr.com.mdb.Utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import tr.com.mdb.DAL.DALAccounts;
import tr.com.mdb.FrontEnd.KategoriDuzenleFE;
import tr.com.mdb.FrontEnd.LoginFE;
import tr.com.mdb.FrontEnd.MusteriDuzenleFE;
import tr.com.mdb.FrontEnd.MusteriEkleFE;
import tr.com.mdb.FrontEnd.PersonelEkleFE;
import tr.com.mdb.FrontEnd.PersonelIslemleriFE;
import tr.com.mdb.FrontEnd.Sifre�slemleriFE;
import tr.com.mdb.FrontEnd.UrunDuzenleFE;
import tr.com.mdb.FrontEnd.UrunEkleFE;
import tr.com.mdb.FrontEnd.YetkiEkleFE;
import tr.com.mdb.FrontEnd.kategoriEkleFE;
import tr.com.mdb.Types.PersonelContract;

public class MenulerUI {

	public static JMenuBar initBar() {
		JMenuBar bar = new JMenuBar();

		JMenu dosyaMenu = new JMenu("Dosya");
		bar.add(dosyaMenu);
		JMenuItem cikisItem = new JMenuItem("��k��");
		dosyaMenu.add(cikisItem);
		cikisItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		/* �r�nler Men�s� */
		JMenu urunlerMenu = new JMenu("�r�nler");
		bar.add(urunlerMenu);
		JMenuItem urunEkleItem = new JMenuItem("�r�n Ekle");
		urunlerMenu.add(urunEkleItem);
		JMenuItem kategoriEkleItem = new JMenuItem("Kategori Ekle");
		urunlerMenu.add(kategoriEkleItem);
		urunlerMenu.addSeparator();
		JMenuItem urunDuzenleItem = new JMenuItem("�r�n� D�zenle");
		urunlerMenu.add(urunDuzenleItem);
		urunDuzenleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UrunDuzenleFE();

			}
		});
		JMenuItem kategoriDuzenleItem = new JMenuItem("Kategoriyi D�zenle");
		urunlerMenu.add(kategoriDuzenleItem);
		kategoriDuzenleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new KategoriDuzenleFE();

			}
		});

		/* Personeller Men�s� */
		JMenu personellerMenu = new JMenu("Personel ��lemleri");
		bar.add(personellerMenu);
		JMenuItem personelEkleItem = new JMenuItem("Personel Ekle");
		personellerMenu.add(personelEkleItem);
		personelEkleItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new PersonelEkleFE();
					}
				});

			}
		});
		JMenuItem yetkiEkleItem = new JMenuItem("Yetki Ekle");
		personellerMenu.add(yetkiEkleItem);
		yetkiEkleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new YetkiEkleFE();
					}
				});
			}
		});
		JMenuItem sifreBelirleItem = new JMenuItem("�ifre Belirleme");
		personellerMenu.add(sifreBelirleItem);
		sifreBelirleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Sifre�slemleriFE();

			}
		});
		personellerMenu.addSeparator();
		JMenuItem personelDuzenleItem = new JMenuItem("Personel D�zenle");
		personelDuzenleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PersonelIslemleriFE();

			}
		});
		personellerMenu.add(personelDuzenleItem);

		/* M��teri Men�s� */
		JMenu musterilerMenu = new JMenu("M��teriler");
		bar.add(musterilerMenu);
		JMenuItem musteriEkleItem = new JMenuItem("M��teri Ekle");
		musterilerMenu.add(musteriEkleItem);
		musteriEkleItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new MusteriEkleFE();
					}
				});

			}
		});

		musterilerMenu.addSeparator();
		JMenuItem musteriDuzenleItem = new JMenuItem("M��teri D�zenle");
		musterilerMenu.add(musteriDuzenleItem);

		musteriDuzenleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MusteriDuzenleFE();

			}
		});

		PersonelContract contract = (PersonelContract) LoginFE.emailBox.getSelectedItem();

		if (new DALAccounts().GetYetkiId(contract.getId()).getYetkiId() == 2) {
			personellerMenu.hide();
		} else if (new DALAccounts().GetYetkiId(contract.getId()).getYetkiId() == 3) {
			musterilerMenu.hide();
			personellerMenu.hide();
			urunlerMenu.hide();
		}

		urunEkleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new UrunEkleFE();
					}
				});

			}
		});

		kategoriEkleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new kategoriEkleFE();

			}
		});

		return bar;
	}
}

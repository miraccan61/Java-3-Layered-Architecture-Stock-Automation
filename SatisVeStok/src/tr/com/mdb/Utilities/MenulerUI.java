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
import tr.com.mdb.FrontEnd.SifreÝslemleriFE;
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
		JMenuItem cikisItem = new JMenuItem("Çýkýþ");
		dosyaMenu.add(cikisItem);
		cikisItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		/* Ürünler Menüsü */
		JMenu urunlerMenu = new JMenu("Ürünler");
		bar.add(urunlerMenu);
		JMenuItem urunEkleItem = new JMenuItem("Ürün Ekle");
		urunlerMenu.add(urunEkleItem);
		JMenuItem kategoriEkleItem = new JMenuItem("Kategori Ekle");
		urunlerMenu.add(kategoriEkleItem);
		urunlerMenu.addSeparator();
		JMenuItem urunDuzenleItem = new JMenuItem("Ürünü Düzenle");
		urunlerMenu.add(urunDuzenleItem);
		urunDuzenleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UrunDuzenleFE();

			}
		});
		JMenuItem kategoriDuzenleItem = new JMenuItem("Kategoriyi Düzenle");
		urunlerMenu.add(kategoriDuzenleItem);
		kategoriDuzenleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new KategoriDuzenleFE();

			}
		});

		/* Personeller Menüsü */
		JMenu personellerMenu = new JMenu("Personel Ýþlemleri");
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
		JMenuItem sifreBelirleItem = new JMenuItem("Þifre Belirleme");
		personellerMenu.add(sifreBelirleItem);
		sifreBelirleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new SifreÝslemleriFE();

			}
		});
		personellerMenu.addSeparator();
		JMenuItem personelDuzenleItem = new JMenuItem("Personel Düzenle");
		personelDuzenleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PersonelIslemleriFE();

			}
		});
		personellerMenu.add(personelDuzenleItem);

		/* Müþteri Menüsü */
		JMenu musterilerMenu = new JMenu("Müþteriler");
		bar.add(musterilerMenu);
		JMenuItem musteriEkleItem = new JMenuItem("Müþteri Ekle");
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
		JMenuItem musteriDuzenleItem = new JMenuItem("Müþteri Düzenle");
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

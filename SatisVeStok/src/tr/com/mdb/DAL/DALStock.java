package tr.com.mdb.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.mdb.Complex.Types.StokContractComplex;
import tr.com.mdb.Complex.Types.StokContractTotalComplex;
import tr.com.mdb.Core.ObjectHelper;
import tr.com.mdb.Interfaces.DALInterfaces;
import tr.com.mdb.Types.KategoriContract;
import tr.com.mdb.Types.StokContract;

public class DALStock extends ObjectHelper implements DALInterfaces<StokContract> {

	@Override
	public void Insert(StokContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"INSERT INTO stok (PersonelId,UrunId,Tarih,Adet)" + "VALUES(" + entity.getPersonelId() + ","
							+ entity.getUrunId() + ",'" + entity.getTarih() + "'," + entity.getAdet() + ")");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * SELECT stok.Id,personel.AdiSoyadi,urunler.Adi,Adet,stok.Tarih FROM `stok`
	 * LEFT JOIN urunler ON stok.UrunId=urunler.Id LEFT JOIN personel on
	 * stok.PersonelId =personel.Id
	 */

	public List<StokContractComplex> GetAllStok() {
		List<StokContractComplex> dataContract = new ArrayList<StokContractComplex>();
		Connection connection = getConnection();
		StokContractComplex contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resulset = statement
					.executeQuery("SELECT stok.Id, AdiSoyadi, Adi, Adet, stok.Tarih FROM stok  LEFT JOIN urunler"
							+ "	  on stok.UrunId = urunler.Id LEFT JOIN personel on stok.PersonelId ="
							+ "	  personel.Id ORDER BY stok.Id DESC ");
			while (resulset.next()) {
				contract = new StokContractComplex();
				contract.setId(resulset.getInt("Id"));
				contract.setPersonelAdi(resulset.getString("AdiSoyadi"));
				contract.setUrunAdi(resulset.getString("Adi"));
				contract.setAdet(resulset.getInt("Adet"));
				contract.setTarih(resulset.getString("stok.Tarih"));

				dataContract.add(contract);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataContract;
	}

	public List<StokContractTotalComplex> GetTotalStok() {

		List<StokContractTotalComplex> dataContract = new ArrayList<StokContractTotalComplex>();
		Connection connection = getConnection();
		StokContractTotalComplex contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resulset = statement.executeQuery(
					"SELECT SUM(Adet) as toplam, stok.Id, AdiSoyadi, Adi, Adet, stok.Tarih FROM stok LEFT JOIN urunler on stok.UrunId = urunler.Id LEFT JOIN personel on stok.PersonelId = personel.Id GROUP BY UrunId ORDER BY toplam desc");

			while (resulset.next()) {
				contract = new StokContractTotalComplex();
				contract.setId(resulset.getInt("Id"));
				contract.setPersonelAdi(resulset.getString("AdiSoyadi"));
				contract.setUrunAdi(resulset.getString("Adi"));
				contract.setAdet(resulset.getInt("toplam"));
				contract.setTarih(resulset.getString("stok.Tarih"));
//				contract.setToplam(resulset.getInt("toplam"));

				dataContract.add(contract);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataContract;
	}

	@Override
	public List<StokContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(StokContract entity) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void Update(StokContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<StokContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

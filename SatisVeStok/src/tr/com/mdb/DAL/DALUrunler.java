package tr.com.mdb.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.DefaultEditorKit.InsertContentAction;
import javax.swing.text.html.parser.Entity;

import tr.com.mdb.Core.ObjectHelper;
import tr.com.mdb.Interfaces.DALInterfaces;
import tr.com.mdb.Types.KategoriContract;
import tr.com.mdb.Types.UrunlerContract;

public class DALUrunler extends ObjectHelper implements DALInterfaces<UrunlerContract> {

	@Override
	public void Insert(UrunlerContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("INSERT INTO Urunler (Adi,KategoriId,Tarih,Fiyat)" + "VALUES('" + entity.getAdi()
					+ "'," + entity.getKategoriId() + ",'" + entity.getTarih() + "'," + entity.getFiyat() + ")");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<UrunlerContract> GetAll() {

		List<UrunlerContract> datacontract = new ArrayList<UrunlerContract>();
		Connection connection = getConnection();
		UrunlerContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Urunler");
			while (resultSet.next()) {
				contract = new UrunlerContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdi(resultSet.getString("Adi"));
				contract.setFiyat(resultSet.getFloat("Fiyat"));
				contract.setKategoriId(resultSet.getInt("KategoriId"));
				contract.setTarih(resultSet.getString("Tarih"));

				datacontract.add(contract);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}

	@Override
	public void Delete(UrunlerContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			System.out.println(entity.getId());
			String sorgu = "Delete from urunler where Id=" + entity.getId();
			statement.executeUpdate(sorgu);
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void Update(UrunlerContract entity) {
		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();
			String sorgu = "Update urunler set Fiyat='" + entity.getFiyat() + "',Adi='" + entity.getAdi() + "',Tarih='"
					+ entity.getTarih() + "' where Id=" + entity.getId();
			statement.executeUpdate(sorgu);

			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<UrunlerContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

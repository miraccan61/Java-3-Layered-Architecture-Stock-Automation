package tr.com.mdb.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.mdb.Core.ObjectHelper;
import tr.com.mdb.Interfaces.DALInterfaces;
import tr.com.mdb.Types.MusteriContract;

public class DALMusteri extends ObjectHelper implements DALInterfaces<MusteriContract> {

	@Override
	public void Insert(MusteriContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("Insert INTO Musteri (AdiSoyadi, Telefon, Adres, SehirName) values ('"
					+ entity.getAdiSoyadi() + "','" + entity.getTelefon() + "','" + entity.getAdres() + "','"
					+ entity.getSehirName() + "')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<MusteriContract> GetAll() {
		List<MusteriContract> dataContract = new ArrayList<MusteriContract>();
		Connection connection = getConnection();
		MusteriContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resulset = statement.executeQuery("SELECT * FROM Musteri");

			while (resulset.next()) {
				contract = new MusteriContract();
				contract.setId(resulset.getInt("Id"));
				contract.setAdiSoyadi(resulset.getString("AdiSoyadi"));
				contract.setAdres(resulset.getString("Adres"));
				contract.setTelefon(resulset.getString("Telefon"));
				contract.setSehirName(resulset.getString("SehirName"));
				dataContract.add(contract);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataContract;
	}

	@Override
	public void Delete(MusteriContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

			String sorgu = "Delete from musteri where Id=" + entity.getId();
			statement.executeUpdate(sorgu);
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void Update(MusteriContract entity) {
		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();

			String sorgu = "Update musteri set AdiSoyadi='" + entity.getAdiSoyadi() + "',Telefon='"
					+ entity.getTelefon() + "',Adres='" + entity.getAdres() + "',SehirName='" + entity.getSehirName()
					+ "' where Id=" + entity.getId();
			statement.executeUpdate(sorgu);
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<MusteriContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

package tr.com.mdb.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.mdb.Core.ObjectHelper;
import tr.com.mdb.Interfaces.DALInterfaces;
import tr.com.mdb.Types.KategoriContract;

public class DALKategori extends ObjectHelper implements DALInterfaces<KategoriContract> {

	@Override
	public void Insert(KategoriContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("Insert INTO Kategori (Adi,ParentId) values ('" + entity.getAdi() + "',"
					+ entity.getParentId() + ")");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<KategoriContract> GetAll() {
		List<KategoriContract> datacontract = new ArrayList<KategoriContract>();
		Connection connection = getConnection();
		KategoriContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Kategori");
			while (resultSet.next()) {
				contract = new KategoriContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdi(resultSet.getString("Adi"));
				contract.setParentId(resultSet.getInt("ParentId"));

				datacontract.add(contract);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}

	public List<KategoriContract> GetAllParentId() {
		List<KategoriContract> datacontract = new ArrayList<KategoriContract>();
		Connection connection = getConnection();
		KategoriContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from Kategori Where parentId=0");
			while (resultSet.next()) {
				contract = new KategoriContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdi(resultSet.getString("Adi"));
				contract.setParentId(resultSet.getInt("ParentId"));

				datacontract.add(contract);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datacontract;
	}

	@Override
	public void Delete(KategoriContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(KategoriContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("UPDATE Kategori SET Adi='" + entity.getAdi() + "', ParentId="
					+ entity.getParentId() + "WHERE id=" + entity.getId() + "");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<KategoriContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<KategoriContract> GetSearchKategori(String kategoriAdi) {
		List<KategoriContract> dataContract = new ArrayList<KategoriContract>();

		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();

			ResultSet resulset = statement
					.executeQuery("SELECT * FROM Kategori WHERE Adi Like '%" + kategoriAdi + "%'");

			while (resulset.next()) {

				KategoriContract contract = new KategoriContract();

				contract.setAdi(resulset.getString("Adi"));
				contract.setParentId(resulset.getInt("ParentId"));
				dataContract.add(contract);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataContract;
	}

}

package tr.com.mdb.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.mdb.Core.ObjectHelper;
import tr.com.mdb.Interfaces.DALInterfaces;
import tr.com.mdb.Types.PersonelContract;
import tr.com.mdb.Types.YetkilerContract;

public class DALYetkiler extends ObjectHelper implements DALInterfaces<YetkilerContract> {

	@Override
	public void Insert(YetkilerContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("Insert INTO Yetkiler (Adi) values ('" + entity.getAdi() + "')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<YetkilerContract> GetAll() {
		List<YetkilerContract> datacontract = new ArrayList<YetkilerContract>();
		Connection connection = getConnection();
		YetkilerContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Yetkiler");
			while (resultSet.next()) {
				contract = new YetkilerContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdi(resultSet.getString("Adi"));
				datacontract.add(contract);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}

	@Override
	public void Delete(YetkilerContract entity) {

	}

	@Override
	public void Update(YetkilerContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<YetkilerContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

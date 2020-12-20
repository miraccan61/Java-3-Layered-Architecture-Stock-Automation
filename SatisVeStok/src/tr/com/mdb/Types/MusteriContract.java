package tr.com.mdb.Types;

public class MusteriContract {

	private int id;
	private String adiSoyadi;
	private String telefon;
	private String adres;
	private String sehirName;
	
	public MusteriContract() {
		this.adiSoyadi="";
		this.telefon="";
		this.adres="";
		this.sehirName="";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdiSoyadi() {
		return adiSoyadi;
	}

	public void setAdiSoyadi(String adiSoyadi) {
		this.adiSoyadi = adiSoyadi;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getSehirName() {
		return sehirName;
	}

	public void setSehirName(String sehirName) {
		this.sehirName = sehirName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return adiSoyadi;
	}
}

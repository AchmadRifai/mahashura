package ashura.project.ashura.entity;

import java.sql.SQLException;

import org.joda.money.Money;

import ashura.project.ashura.Db;

public class Jabatan {
	private int kode;
	private String nama;
	private Money gaji;
	private int kapasitas,isi;
	private String akses,ket;

	public Jabatan(int kode, Db d) throws SQLException {
		super();
		this.kode = kode;
		loadData(d);
	}

	private void loadData(Db d) throws SQLException {
		java.sql.PreparedStatement p=d.prep("select*from jabatan where kode=?");
		p.setInt(1, kode);
		java.sql.ResultSet r=p.executeQuery();
		if(r.next()) {
			nama=r.getString("nama");
			gaji=Money.parse(r.getString("gaji"));
			kapasitas=r.getInt("kapasitas");
			isi=r.getInt("isi");
			akses=r.getString("akses");
			ket=r.getString("ket");
		} r.close();
		p.close();
	}

	public Jabatan() {
		super();
	}

	public Jabatan(int kode, String nama, Money gaji, int kapasitas, int isi, String akses, String ket) {
		super();
		this.kode = kode;
		this.nama = nama;
		this.gaji = gaji;
		this.kapasitas = kapasitas;
		this.isi = isi;
		this.akses = akses;
		this.ket = ket;
	}

	public int getKode() {
		return kode;
	}

	public void setKode(int kode) {
		this.kode = kode;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Money getGaji() {
		return gaji;
	}

	public void setGaji(Money gaji) {
		this.gaji = gaji;
	}

	public int getKapasitas() {
		return kapasitas;
	}

	public void setKapasitas(int kapasitas) {
		this.kapasitas = kapasitas;
	}

	public int getIsi() {
		return isi;
	}

	public void setIsi(int isi) {
		this.isi = isi;
	}

	public String getAkses() {
		return akses;
	}

	public void setAkses(String akses) {
		this.akses = akses;
	}

	public String getKet() {
		return ket;
	}

	public void setKet(String ket) {
		this.ket = ket;
	}
}

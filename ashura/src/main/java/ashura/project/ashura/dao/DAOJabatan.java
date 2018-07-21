package ashura.project.ashura.dao;

import java.sql.SQLException;
import java.util.List;

import ashura.project.ashura.Db;
import ashura.project.ashura.entity.Jabatan;

public class DAOJabatan implements DAO<Jabatan> {
	private Db d;

	public DAOJabatan(Db d) {
		super();
		this.d = d;
	}

	@Override
	public void createTable() throws SQLException {
		d.execute("create table jabatan(kode int primary key,nama varchar(20)not null,gaji text not null,"
				+ "kapasitas int not null,isi int not null,akses text not null,ket text not null)");
	}

	@Override
	public void insert(Jabatan v) throws SQLException {
		java.sql.PreparedStatement p=d.prep("insert into jabatan values(?,?,?,?,?,?,?)");
		p.setInt(1, v.getKode());
		p.setString(2, v.getNama());
		p.setString(3, ""+v.getGaji());
		p.setInt(4, v.getKapasitas());
		p.setInt(5, v.getIsi());
		p.setString(6, v.getAkses());
		p.setString(7, v.getKet());
		p.execute();
		p.close();
	}

	@Override
	public void delete(Jabatan w) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Jabatan a, Jabatan b) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Jabatan> all() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jabatan> cari(Jabatan w) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}

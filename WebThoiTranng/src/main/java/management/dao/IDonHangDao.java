
package management.dao;


import management.entity.Mathang;
import management.entity.Size;

public interface IDonHangDao {
	
	public Mathang layMatHangTheoID(int id);
	
	public int LayGiaSP(int id);
	
	public Size laySize(int maSize);
	
//	public List<Ctsize> layDSSizeCuaMatHang(String maMH);
}

	
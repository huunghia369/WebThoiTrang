package management.dao;

import java.util.Date;
import java.util.List;

import management.entity.Mathang;
import management.entity.Phieudat;

public interface ILichSuDonHangDAO {
	
	int getMaKHbyEmail(String email);
	
	List<Phieudat> getAllPhieuDatByMaKH(int makh);
	
	List<Integer> getAllMaSPbyMaPD(int mapd);
	
	List<Integer> getAllMaSizebyMaSPandMaPD(int mamh, int mapd);
	
	String getMucSizebyMaSize(int masize);
	
	int getSoluongSp(int mamh, int mapd, int masize);
	
	Date getNgaydatByMaMH(int mapd);
	
	int getPriceByMaMH(int mamh, Date nd);
	
	Mathang layMatHangTheoID(int id);
	
	double getKhuyenMai(int masp, Date ngaydat);
}



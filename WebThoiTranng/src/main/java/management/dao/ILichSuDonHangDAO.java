package management.dao;

import java.util.Date;
import java.util.List;

import management.entity.Ctpd;
import management.entity.Khachhang;
import management.entity.Mathang;
import management.entity.Phieudat;

public interface ILichSuDonHangDAO {
	
	int getMaKHbyEmail(String email);
	
	List<Integer> getAllMaPDbyMaKh(int makh);
	
	List<Integer> getAllMaSPbyMaPD(int mapd);
	
	int getSoluongSp(int mamh, int mapd);
	
	Date getNgaydatByMaMH(int mapd);
	
	Phieudat getPhieuDatByMaPD(int mapd);
	
	int getPriceByMaMH(int mamh, Date nd);
	
	Mathang layMatHangTheoID(int id);
}



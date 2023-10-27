package management.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import management.dao.ILichSuDonHangDAO;
import management.entity.Mathang;
import management.entity.Phieudat;

@Transactional
@Repository
public class LichSuDonHangImpl implements ILichSuDonHangDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int getMaKHbyEmail(String email) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT kh.makh FROM Khachhang kh WHERE kh.taikhoan.email =:email";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		Integer makh = (Integer) query.uniqueResult();
		int result = (makh != null) ? makh.intValue() : 0; // Set a default value if makh is null

		session.close();
		return result;
	}

	@Override
	public List<Phieudat> getAllPhieuDatByMaKH(int makh) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Phieudat pd WHERE pd.khachhang.makh =:makh";
		Query query = session.createQuery(hql);
		query.setParameter("makh", makh);
		List<Phieudat> list = query.list();
		return list;
	}

	@Override
	public List<Integer> getAllMaSPbyMaPD(int mapd) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT DISTINCT ctpd.id.mamh FROM Ctpd ctpd WHERE ctpd.id.mapd = :mapd";
		Query query = session.createQuery(hql);
		query.setParameter("mapd", mapd);
		List<Integer> list = query.list();
		return list;
	}

	@Override
	public List<Integer> getAllMaSizebyMaSPandMaPD(int mamh, int mapd) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT DISTINCT ctpd.id.masize FROM Ctpd ctpd WHERE ctpd.id.mamh = :mamh AND ctpd.id.mapd = :mapd";
		Query query = session.createQuery(hql);
		query.setParameter("mamh", mamh);
		query.setParameter("mapd", mapd);
		List<Integer> list = query.list();
		return list;
	}
	
	@Override
	public String getMucSizebyMaSize(int masize) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT s.tensize FROM Size s WHERE s.masize =:masize";
		Query query = session.createQuery(hql);
		query.setParameter("masize", masize);
		String tensize = (String) query.uniqueResult();
		return tensize;
	}
	
	@Override
	public int getSoluongSp(int mamh, int mapd, int masize) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT ctpd.soluong FROM Ctpd ctpd WHERE ctpd.id.mamh = :mamh AND ctpd.id.mapd =:mapd AND ctpd.id.masize =:masize";
		Query query = session.createQuery(hql);
		query.setParameter("mamh", mamh);
		query.setParameter("mapd", mapd);
		query.setParameter("masize", masize);
		Integer sl = (Integer) query.uniqueResult();
		int result = (sl != null) ? sl.intValue() : 0; // Set a default value if sl is null

		session.close();
		return result;
	}

	@Override
	public Date getNgaydatByMaMH(int mapd) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT pd.ngaydat FROM Phieudat pd WHERE pd.mapd = :mapd";
		Query query = session.createQuery(hql);
		query.setParameter("mapd", mapd);
		Date nd = (Date) query.uniqueResult();
		session.close();

		return nd;
	}

	@Override
	public int getPriceByMaMH(int id, Date nd) {

		// Mở phiên làm việc
		Session session = sessionFactory.openSession();

		try {
			// Sử dụng HQL để truy vấn giá sản phẩm
			String hql = "SELECT bg.giamoi FROM Banggia bg WHERE bg.id.ngayapdung <= :currentDate AND bg.id.mamh =:id ORDER BY bg.id.ngayapdung DESC";
			Query query = session.createQuery(hql);
			Date currentDate = nd; // Ngày hiện tại
			query.setParameter("currentDate", currentDate);

			query.setParameter("id", id);

			query.setMaxResults(1); // Lấy bản ghi đầu tiên (ngày gần nhất)

			// Thực hiện truy vấn
			Integer price = (Integer) query.uniqueResult();
			if (price != null) {
				return price.intValue();
			} else {
				// Handle the case when the result is null (e.g., return a default value)
				return 0; // Or any other appropriate default value
			}
		} finally {
			// Đóng phiên làm việc
			session.close();

			// Đóng SessionFactory khi ứng dụng kết thúc

		}
	}

	@Override
	public Mathang layMatHangTheoID(int id) {
		Session session = sessionFactory.openSession();
		try {
			String hql = "FROM Mathang where mamh = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			Mathang mh = (Mathang) query.uniqueResult();
			return mh;
		} finally {
			session.close();
		}
	}
	
	@Override
	public double getKhuyenMai(int masp, Date ngaydat) {
	    Session session = sessionFactory.openSession();
	    try {
	        // Sử dụng HQL để truy vấn thông tin khuyến mãi
	        String hql = "SELECT max(km.mucgiamgia) FROM Ctdkm km INNER JOIN km.dotkhuyenmai d WHERE km.id.mamh = :masp AND d.ngaybd <= :ngaydat AND d.ngaykt >= :ngaydat";
	        Query query = session.createQuery(hql);
	        query.setParameter("masp", masp);
	        query.setParameter("ngaydat", ngaydat);
	        
	        // Thực hiện truy vấn
	        Double khuyenmai = (Double) query.uniqueResult();
	        if (khuyenmai != null) {
	            return khuyenmai.doubleValue();
	        } else {
	            // Trả về 0.0 nếu không có khuyến mãi hoặc xử lý logic khuyến mãi ở đây
	            return 0.0;
	        }
	    } finally {
	        session.close();
	    }
	}
}
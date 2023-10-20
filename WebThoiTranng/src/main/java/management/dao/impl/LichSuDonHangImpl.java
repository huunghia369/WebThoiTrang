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
	public List<Integer> getAllMaPDbyMaKh(int makh) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT pd.mapd FROM Phieudat pd WHERE pd.khachhang.makh =:makh";
		Query query = session.createQuery(hql);
		query.setParameter("makh", makh);
		List<Integer> list = query.list();
		return list;
	}

	@Override
	public List<Integer> getAllMaSPbyMaPD(int mapd) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT ctpd.id.mamh FROM Ctpd ctpd WHERE ctpd.id.mapd =:mapd";
		Query query = session.createQuery(hql);
		query.setParameter("mapd", mapd);
		List<Integer> list = query.list();
		return list;
	}

	@Override
	public int getSoluongSp(int mamh, int mapd) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT ctpd.soluong FROM Ctpd ctpd WHERE ctpd.id.mamh = :mamh AND ctpd.id.mapd =:mapd";
		Query query = session.createQuery(hql);
		query.setParameter("mamh", mamh);
		query.setParameter("mapd", mapd);
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
	public Phieudat getPhieuDatByMaPD(int mapd) {
		Session session = sessionFactory.openSession();
		try {
			String hql = "FROM Phieudat pd WHERE pd.mapd = :mapd";
			Query query = session.createQuery(hql);
			query.setParameter("mapd", mapd);
			Phieudat pd = (Phieudat) query.uniqueResult();
			return pd;
		} finally {
			session.close();
		}
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
}
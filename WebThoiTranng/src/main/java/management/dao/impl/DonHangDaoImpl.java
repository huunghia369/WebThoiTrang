
package management.dao.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import management.dao.IDonHangDao;
import management.entity.Mathang;
import management.entity.Size;

@Repository
@Transactional
public class DonHangDaoImpl implements IDonHangDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Mathang layMatHangTheoID(int id) {
		Session session = sessionFactory.openSession();
		try {
			String hql = "FROM Mathang where mamh = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			Mathang mh = (Mathang) query.uniqueResult();
			System.out.println(mh.getNhanhieu().getTennh());
			return mh;
		} finally {
			session.close();
		}
	}

	@Override
	public int LayGiaSP(int id) {

		// Mở phiên làm việc
        Session session = sessionFactory.openSession();

        try {
            // Sử dụng HQL để truy vấn giá sản phẩm
            String hql = "SELECT bg.giamoi FROM Banggia bg WHERE bg.id.ngayapdung <= :currentDate AND bg.id.mamh =:id ORDER BY bg.id.ngayapdung DESC";
            Query query = session.createQuery(hql);
            Date currentDate = new Date();  // Ngày hiện tại
            query.setParameter("currentDate", currentDate);

            query.setParameter("id", id);

            query.setMaxResults(1);  // Lấy bản ghi đầu tiên (ngày gần nhất)

            // Thực hiện truy vấn
            Integer price = (Integer) query.uniqueResult();
            System.out.println(price);
            int rf = (int) price;
            return rf;
        } finally {
            // Đóng phiên làm việc
            session.close();

            // Đóng SessionFactory khi ứng dụng kết thúc
          
        }
	}
	
	@Override
	public Size laySize(int maSize) {
		Session session = sessionFactory.openSession();
		try {
			String hql = "FROM Size where masize = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", maSize);
			Size mh = (Size) query.uniqueResult();
			return mh;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			session.close();
		}
	}

}


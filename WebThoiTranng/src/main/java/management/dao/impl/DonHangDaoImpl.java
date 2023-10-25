

package management.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import management.dao.IDonHangDao;
import management.entity.Banggia;
import management.entity.Ctsize;
import management.entity.Mathang;

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
			
			return mh;
		} finally {
			session.close();
		}
	}

	@Override
	public int LayGiaSP(int id1) {

		// Mở phiên làm việc
        Session session = sessionFactory.openSession();

        try {
            // Sử dụng HQL để truy vấn giá sản phẩm
            String hql = "SELECT bg.giamoi FROM Banggia bg WHERE bg.id.ngayapdung <= :currentDate AND bg.id.mamh =:id ORDER BY bg.id.ngayapdung DESC";
            Query query = session.createQuery(hql);
            Date currentDate = new Date();  // Ngày hiện tại
            query.setParameter("currentDate", currentDate);
           
            query.setParameter("id", id1);

            query.setMaxResults(1);  // Lấy bản ghi đầu tiên (ngày gần nhất)

            // Thực hiện truy vấn
            Integer price = (Integer) query.uniqueResult();
           
            int rf = (int) price;
            return rf;
        } finally {
            // Đóng phiên làm việc
            session.close();

            // Đóng SessionFactory khi ứng dụng kết thúc
          
        }
	}

}


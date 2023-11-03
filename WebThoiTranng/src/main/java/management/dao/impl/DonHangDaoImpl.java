package management.dao.impl;

import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
        Session session = sessionFactory.getCurrentSession(); // Sử dụng getCurrentSession() thay vì openSession()
        try {
            String hql = "FROM Mathang where mamh = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            Mathang mh = (Mathang) query.uniqueResult();
            return mh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public int LayGiaSP(int id1) {
        try {
            Session session = sessionFactory.getCurrentSession(); // Sử dụng getCurrentSession() thay vì openSession()
            // Sử dụng HQL để truy vấn giá sản phẩm
            String hql = "SELECT bg.giamoi FROM Banggia bg WHERE bg.id.ngayapdung <= :currentDate AND bg.id.mamh = :id ORDER BY bg.id.ngayapdung DESC";
            Query query = session.createQuery(hql);
            Date currentDate = new Date();  // Ngày hiện tại
            query.setParameter("currentDate", currentDate);
            query.setParameter("id", id1);
            query.setMaxResults(1);  // Lấy bản ghi đầu tiên (ngày gần nhất)
            Integer price = (Integer) query.uniqueResult();
            return (price != null) ? price : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    @Override
    public Size laySize(int maSize) {
        Session session = sessionFactory.getCurrentSession(); // Sử dụng getCurrentSession() thay vì openSession()
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
    }
}

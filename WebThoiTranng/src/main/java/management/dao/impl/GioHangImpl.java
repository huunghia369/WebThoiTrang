package management.dao.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import management.dao.IGioHangDAO;
import management.entity.Mathang;


@Repository
@Transactional
public class GioHangImpl implements IGioHangDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// Lấy mặt hàng từ id có dạng là 1 chuỗi " productID+id "
	@Override
	public String getTenMatHangFromID(int id) {
	    String tenMatHang = null;
	    Session s = sessionFactory.openSession();
	    String hql = "select b.tenmh from Mathang b where b.mamh = :mamh";
	    Query query = s.createQuery(hql);
	    try {
	        query.setParameter("mamh", id);
	        tenMatHang = (String) query.uniqueResult();
	    } finally {
	        s.close();
	    }
	    return tenMatHang;
	}


	@Override
	public int get_Price_From_ID(int id) {
				
		// Mở phiên làm việc
        Session session = sessionFactory.openSession();

        try {
            // Sử dụng HQL để truy vấn giá sản phẩm
            String hql = "SELECT bg.giamoi FROM Banggia bg WHERE bg.id.ngayapdung <= :currentDate AND bg.mathang.mamh =:mamh ORDER BY bg.id.ngayapdung DESC";
            Query query = session.createQuery(hql);
            Timestamp currentDate = new Timestamp(new Date().getTime());
            query.setParameter("currentDate", currentDate);
            query.setParameter("mamh", id);
            query.setMaxResults(1);  // Lấy bản ghi đầu tiên (ngày gần nhất)

            // Thực hiện truy vấn
             int price_int =  (int) query.uniqueResult();
            
            return price_int;
        } finally {
            // Đóng phiên làm việc
            session.close();  
            
        }
        
	}

	
	
}

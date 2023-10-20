package management.dao;




import javax.servlet.http.HttpServletRequest;

import management.entity.Nhanvien;
import management.entity.Taikhoan;


public interface ITaiKhoanDAO {
	boolean check_MailExist(String mail);
	Taikhoan addTaiKhoan( HttpServletRequest request);
	public Nhanvien getNhanVien_byEmail(String nv);
}

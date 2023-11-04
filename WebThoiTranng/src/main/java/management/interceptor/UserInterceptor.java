package management.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import management.dao.ITaiKhoanDAO;

public class UserInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	ITaiKhoanDAO iTaiKhoanDAO;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getRequestURI();
		
		String usermail = (String) request.getSession().getAttribute("loggedInUserEmail");
		
		// Nếu chứa paying và mã quyền là 2( Ql) hoặc chứa paying và chưa đăng nhập
		if ((requestURI.contains("paying")||(requestURI.contains("mua-ngay")) &&  (Boolean) request.getSession().getAttribute("login") == false)
				|| (requestURI.contains("paying")||(requestURI.contains("mua-ngay")) && iTaiKhoanDAO.get_MaQuyen_by_email(usermail) == 2)) {

			response.sendRedirect("/user/login"); // trả về link đăng nhập
			return false; // Dừng xử lý yêu cầu hiện tại
		}
		

		return true; // Tiếp tục xử lý yêu cầu
	}
}
package management.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import management.bean.Validator_check;
import management.dao.IKhachHangDAO;
import management.dao.ITaiKhoanDAO;
import management.entity.Khachhang;
import management.entity.Taikhoan;



@Controller
@RequestMapping("/register/")
public class TaiKhoanController {
	
	  @Autowired 
	  ITaiKhoanDAO taiKhoanDAO;
	  
	  @Autowired  
	  IKhachHangDAO iKhachHangDAO;
	  	
	  
	  @ModelAttribute("KhachHang")
	  public Khachhang createKhachHangModel() {
	      return new Khachhang();
	  }
	  @RequestMapping(value = "insert",method=RequestMethod.GET)
	  public String insert1(HttpServletRequest request)
	  {
		  
		// Lấy giá trị userEmail từ session
		    HttpSession session = request.getSession();
		    String userEmail = (String) session.getAttribute("loggedInUserEmail");
		   	
		 // Ktra neu email chua ton tai thi chuyen huong den trang dang ki tai khoan
			if(taiKhoanDAO.check_MailExist(userEmail)==false)
			{
				System.out.println("o day ");
				return "register";
			}
		    return "home";
		    
	  }
	  
		@RequestMapping(value = "insert",method=RequestMethod.POST)
		public String insert2(ModelMap model,@Validated @ModelAttribute("KhachHang") Khachhang khachHang,HttpServletRequest request,BindingResult errors,HttpSession ss,@ModelAttribute("dstaikhoan") Taikhoan taiKhoan) 
		{	
			System.out.println("Vao day r ne");
	  		
			String ngay = request.getParameter("day");
			String thang = request.getParameter("month");
			String nam = request.getParameter("year");
			String sDate = thang + "/" + ngay +"/" + nam;
	        Date date = null;
			try {
				date = new SimpleDateFormat("MM/dd/yyyy").parse(sDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			khachHang.setNgaysinh(date);
			LocalDate dateOfBirth = khachHang.getNgaysinh().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		    int minimumAge = 12;
		    boolean kt = true;
		    if (!Validator_check.isMinimumAge(dateOfBirth, minimumAge)) {
		    	System.out.println("tuôi bé");
		        errors.rejectValue("name", "KhachHang", "Bạn phải lớn hơn " + minimumAge + " tuổi để đăng ký!");
		        kt = false;
		    }
			
			
			if (khachHang.getHotenkh().trim().isEmpty()) {
		        errors.rejectValue("name", "KhachHang", "Họ và tên không được để trống!");
		        kt = false;
		    }
		    if (khachHang.getDiachi().trim().isEmpty()) {
		        errors.rejectValue("account.password", "KhachHang", "Địa chỉ không được để trống!");
		        kt = false;
		    }
		    if (khachHang.getSdt().trim().isEmpty()) {
		        errors.rejectValue("phoneNumber", "KhachHang", "Số điện thoại không được để trống!");
		        kt = false;
		    }
		    if (!Validator_check.isValidPhoneNumber(khachHang.getSdt())) {
		        errors.rejectValue("phoneNumber", "KhachHang", "Số điện thoại không hợp lệ!");
		        kt = false;
		    }
	
		    System.out.println("Looix 111");
		    
	
			Taikhoan taikhoan = new Taikhoan();
			iKhachHangDAO.createCustomer(khachHang, taikhoan, request);
			
//			if (customerDao.addCustomer(khachHang, taiKhoan)) {
//			    model.addAttribute("tk", taiKhoan);
//			    ss.setAttribute("user", khachHang);
//			    model.addAttribute("message", "Đăng Ký Thành Công");
//			    model.addAttribute("login", false);
//			    model.addAttribute("redirect", true); // Add this line to indicate a redirection is needed
//			    return "login";
//			} else {
//			    model.addAttribute("message", "Thất Bại");
//			    model.addAttribute("login", false);
//			    return "register";
//			}
		    return "home";
		}

}

package management.controller.user;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import management.bean.ProductWithDiscount;
import management.bean.RemoveDiacritics;
import management.dao.IDanhMucDao;
import management.dao.IMatHangDao;
import management.entity.Loaimh;
import management.entity.Mathang;
import management.login_google.UserGoogleDto;




@Controller
@RequestMapping("/user")
public class HomeController {
	
	
	@Autowired
	private IDanhMucDao danhMucDao;
	@Autowired
	private IMatHangDao matHangDao;
	

	@GetMapping("/index")
	public ModelAndView home(ModelMap model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userEmail = (String) session.getAttribute("loggedInUserEmail");
		if(userEmail !=null) session.setAttribute("login", true);
		else session.setAttribute("login", false);
		
		/*
		 * Boolean loginValue = (Boolean) session.getAttribute("login"); // boolean
		 * isLoggedin = loginValue != null && loginValue.booleanValue();
		 * System.out.println(loginValue);
		 */
		List<Loaimh> listCategory=danhMucDao.getAllDanhMuc();
		
		List<Mathang>listtmp=matHangDao.getMathangAndTotalSoluongTop(6);
		List<ProductWithDiscount>list_P_Sale=new ArrayList<>();
		
		for(Mathang mh: listtmp) {
			
			ProductWithDiscount tmp = new ProductWithDiscount();
			tmp.setMucgiamgia((int)matHangDao.getDiscount_Product(mh));
			
			tmp.setMathang(mh);
			tmp.setGia(matHangDao.getPrice_Product(mh));
			
			
			
			list_P_Sale.add(tmp);
			
		}
		
		model.addAttribute("listProductSale", list_P_Sale);
		model.addAttribute("listCategory", listCategory);
		
		List<Mathang>listP_Discount=matHangDao.getProductHasDiscount(8);
		
		
		List<ProductWithDiscount>list_P_D=new ArrayList<>();
		
		for(Mathang mh: listP_Discount) {
			ProductWithDiscount tmp = new ProductWithDiscount();
			tmp.setMucgiamgia((int)matHangDao.getDiscount_Product(mh));
			if(tmp.getMucgiamgia()==0) continue;
			tmp.setMathang(mh);
			tmp.setGia(matHangDao.getPrice_Product(mh));
			
			
			
			list_P_D.add(tmp);
			
		}
		model.addAttribute("listDiscount", list_P_D);
		
		
		ModelAndView modelAndView = new ModelAndView("user/home");
		return modelAndView;
	}
	
	@RequestMapping("log-out")
	public String logOut(HttpServletRequest request )
	{
		HttpSession session = request.getSession();
		Boolean userEmail = (Boolean) session.getAttribute("login");
		
		if (userEmail != null) {
			
	        // Nếu userEmail là null, bạn có thể xóa nó khỏi session như sau:
	        session.setAttribute("login", false);
	    }
		return "redirect:/user/index";
	}

	@RequestMapping("login")
	public String login()
	{
		return "redirect:https://accounts.google.com/o/oauth2/auth?scope=email%20profile&hl=vi&redirect_uri=http://localhost:8080/login_google/LoginGoogleHandler&response_type=code&client_id=242828357380-bmi9embekgk0pqkcl14jqt35g80letup.apps.googleusercontent.com&approval_prompt=force";
	}
	
}


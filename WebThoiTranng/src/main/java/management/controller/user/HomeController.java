package management.controller.user;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.example.demo4.entity.Ctdkm;

import management.bean.ProductWithDiscount;
import management.bean.RemoveDiacritics;
import management.dao.IDanhMucDao;
import management.dao.IMatHangDao;
import management.entity.Loaimh;
import management.entity.Mathang;




@Controller
@RequestMapping("/user")
public class HomeController {
	
	
	@Autowired
	private IDanhMucDao danhMucDao;
	@Autowired
	private IMatHangDao matHangDao;
	

	@GetMapping("/index")
	public ModelAndView home(ModelMap model) {
		
		
		
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
	
	

	
}


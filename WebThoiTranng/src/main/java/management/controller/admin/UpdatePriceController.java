package management.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



import management.bean.ProductWithDiscount;
import management.dao.IDanhMucDao;
import management.dao.IMatHangDao;
import management.entity.Banggia;
import management.entity.BanggiaId;
import management.entity.Loaimh;
import management.entity.Mathang;

@Controller
@RequestMapping("/admin/update/")
public class UpdatePriceController {

	
	@Autowired
	IMatHangDao matHangDao;
	@Autowired
	IDanhMucDao danhMucDao;
	
	
	
	
	
	public List<ProductWithDiscount> listPro() {

		List<Mathang> listProduct = matHangDao.getAllMathang();
		List<ProductWithDiscount> list_P_D = new ArrayList<>();
		for (Mathang mh : listProduct) {
			ProductWithDiscount tmp = new ProductWithDiscount();
			tmp.setMucgiamgia((int) matHangDao.getDiscount_Product(mh));

			tmp.setMathang(mh);
			tmp.setGia(matHangDao.getPrice_Product(mh));

			list_P_D.add(tmp);

		}
		return list_P_D;
	}

	public List<Loaimh> listCategory() {

		List<Loaimh> listCate = danhMucDao.getAllDanhMuc();
		return listCate;
	}
	
	@GetMapping("price")
	public ModelAndView update(ModelMap model) {
		

		model.addAttribute("listProduct", listPro());
		model.addAttribute("listCategory", listCategory());
		ModelAndView modelAndView = new ModelAndView("admin/updatePrice");
		return modelAndView;
		
	}
	
	@PostMapping("{priceType}/successful")
    public ModelAndView updateSuccessful(@RequestParam(name = "productID",  required = false) String[] productIDs,
    									 @PathVariable(required = false) String priceType,
    									 @RequestParam(name = "productList", required = false) String[] productoOfCate,
                                         @RequestParam(name = "newPrice",required = false) Integer  newPrice,
                                         @RequestParam(name= "newPriceList",required = false) Integer  newPriceList ) {
        
		 Date currentDate = new Date();
		 
		
		 
		 if(priceType.equals("price"))
		 {
			
			 extracted(currentDate, productIDs, newPrice);
		 }
		 else if(priceType.equals("pricelist")) {
			extracted(productoOfCate, newPriceList, currentDate);
		 }
		 
       
       
        
        ModelAndView modelAndView = new ModelAndView("admin/updatePrice");
        modelAndView.addObject("listProduct", listPro());
        modelAndView.addObject("listCategory", listCategory());
        String tbCOLOR="alert alert-success";
        String tb="CẬP NHẬT THÀNH CÔNG";
        modelAndView.addObject("tbC", tbCOLOR);
        modelAndView.addObject("tb", tb);

        return modelAndView;
    }

	private void extracted(String[] productoOfCate, int newPriceList, Date currentDate) {
		for(String idCategory:productoOfCate)
		{
			List<Mathang> listP = matHangDao.getProductOfCategory(idCategory);
			for(Mathang product:listP) {
				
		        	Banggia tbp= new Banggia();
		            BanggiaId tbpi= new BanggiaId();
		            
		            tbpi.setMamh(product.getMamh());
		            tbpi.setManv(2);
		            tbpi.setNgayapdung(currentDate);
		            
		            tbp.setId(tbpi);
		            tbp.setGiamoi(newPriceList);
		           
		            matHangDao.updatePrice(tbp);
		        
			}
		}
	}

	private void extracted(Date currentDate, String[] listUpdate, int price) {
		for (String productID : listUpdate) {
        	
        	Banggia tbp= new Banggia();
            BanggiaId tbpi= new BanggiaId();
            
            tbpi.setMamh(Integer.parseInt(productID));
            tbpi.setManv(2);
            tbpi.setNgayapdung(currentDate);
            
            tbp.setId(tbpi);
            tbp.setGiamoi(price);
           
            matHangDao.updatePrice(tbp);
        }
	}
	
	
}

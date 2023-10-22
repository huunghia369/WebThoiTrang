package management.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import management.bean.Donhang;
import management.bean.DonhangInfo;
import management.dao.ILichSuDonHangDAO;
import management.entity.Mathang;
import management.entity.Phieudat;

@Controller
@RequestMapping("/user/")
public class LichSuDonHangController {

	@Autowired
	private ILichSuDonHangDAO lichSuDonHangDAO;

	@GetMapping("history")
	public ModelAndView history(HttpServletRequest request, ModelMap model) {

		HttpSession session = request.getSession();
		String userEmail = (String) session.getAttribute("loggedInUserEmail");

		// Lấy mã khách hàng dựa trên địa chỉ email
		int makh = lichSuDonHangDAO.getMaKHbyEmail("nghia@gmail.com");		

		// Lấy danh sách các mã phiếu đặt dựa trên mã khách hàng
		List<Integer> listPD = lichSuDonHangDAO.getAllMaPDbyMaKh(makh);

		// Tạo danh sách chứa thông tin đơn hàng
		List<DonhangInfo> listDonhang = new ArrayList<>();	

		int tong = 0; // Biến để tính tổng giá đơn hàng

		for (int pd : listPD) {
			
			// Lấy thông tin phiếu đặt dựa trên mã phiếu đặt
			Phieudat phieudat = lichSuDonHangDAO.getPhieuDatByMaPD(pd);
			
			// Tạo danh sách chứa thông tin các đơn hàng cho phiếu đặt
			List<Donhang> listDonhangForPhieuDat = new ArrayList<>();
			
			// Lấy danh sách các mã sản phẩm dựa trên mã phiếu đặt
			List<Integer> listMaSP = lichSuDonHangDAO.getAllMaSPbyMaPD(pd);
			
			for (int masp : listMaSP) {
				// Lấy thông tin sản phẩm dựa trên mã sản phẩm
				Mathang mh = lichSuDonHangDAO.layMatHangTheoID(masp);
				
				// Lấy số lượng sản phẩm cho mỗi phiếu đặt
				int sl = lichSuDonHangDAO.getSoluongSp(masp, pd);
				
				// Lấy ngày đặt sản phẩm
				Date nd = lichSuDonHangDAO.getNgaydatByMaMH(pd);
				
				// Lấy giá sản phẩm dựa trên mã sản phẩm và ngày đặt
				int gia = lichSuDonHangDAO.getPriceByMaMH(masp, nd);
				
				// Tạo đối tượng Donhang
				Donhang dh = new Donhang();				

				// Gán thông tin cho đối tượng Donhang
				dh.setMamh(masp);
				dh.setTenSP(mh.getTenmh());
				dh.setSoluong(sl);
				dh.setTonggia(gia * sl);
				dh.setNgaydat(nd);

				// Thêm đơn hàng vào danh sách đơn hàng cho phiếu đặt
				listDonhangForPhieuDat.add(dh);								
			}

			// Tạo đối tượng DonhangInfo chứa thông tin phiếu đặt và danh sách đơn hàng cho phiếu đặt
			DonhangInfo donhangInfo = new DonhangInfo();
			donhangInfo.setPhieudat(phieudat);
			donhangInfo.setListDonhangForPhieuDat(listDonhangForPhieuDat);

			// Thêm DonhangInfo vào danh sách DonhangInfo
			listDonhang.add(donhangInfo);
		}

		ModelAndView modelAndView = new ModelAndView("user/lichsudonhang");

		modelAndView.addObject("listDonhang", listDonhang);		

		return modelAndView;
	}
}

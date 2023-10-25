package management.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import management.DTO.ThanhToanDto;
import management.dao.IDonHangDao;
import management.dao.IGioHangDAO;
import management.dao.IThanhToanDAO;
import management.DTO.GioHangDto;
import management.DTO.Product_Paying;
import management.entity.Ctpd;
import management.entity.CtpdId;
import management.entity.Ctsize;
import management.entity.CtsizeId;
import management.entity.Danhgia;
import management.entity.Khachhang;
import management.entity.Mathang;
import management.entity.Phieudat;

@Controller
@Transactional
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IDonHangDao donHangDao;

	@Autowired
	private IGioHangDAO iGioHangDAO;

	@Autowired
	private IThanhToanDAO thanhToanDAO;

	@RequestMapping("/chi-tiet-sp/{id}")
	public ModelAndView CTSP(@PathVariable("id") int id) throws ServletException, IOException {
		
		ModelAndView mav = new ModelAndView("user/chiTietSP");
		
		Mathang mh = donHangDao.layMatHangTheoID(id);
		
		int gia = donHangDao.LayGiaSP(id);
		
		System.out.println(mh.getCtsizes());

		float tongDanhGia = 0;
		for (Danhgia dg :mh.getDanhgias()) {
			tongDanhGia += dg.getDanhgia();
		}
		float danhGia = tongDanhGia/mh.getDanhgias().size();
		System.out.println(tongDanhGia);
		System.out.println(danhGia);
		
		mav.addObject("gia", gia);
		mav.addObject("mh", mh);
		mav.addObject("danhGia", danhGia);
		
		return mav;
	}

	@PostMapping("/chi-tiet-sp/them")
	public void themSanPhamVaoGioHang(Model model, @RequestParam("id") int id, @RequestParam("size") int masize,
			HttpServletResponse response) {
		// Đoạn mã xử lý thêm sản phẩm vào giỏ hàng ở đây
		String maSPTmp = "productID" + String.valueOf(id) + "+" + donHangDao.laySize(masize).getTensize();

		Cookie cookie = new Cookie(maSPTmp, "1");
		// Đặt path của cookie
		cookie.setPath("/"); // Đặt path chung cho tất cả các đường dẫn
		cookie.setMaxAge(60 * 60 * 24 * 30); // 1 tháng

		response.addCookie(cookie);

	}

	/*
	 * @RequestMapping("/giohang") public ModelAndView
	 * createGioHangDto(HttpServletRequest request, HttpServletResponse response) {
	 * 
	 * List<GioHangDto> gioHangDto = new ArrayList<GioHangDto>(); ModelAndView
	 * modelAndView = new ModelAndView("user/cart"); Cookie[] cookies =
	 * request.getCookies();
	 * 
	 * if (cookies == null) System.out.println("Cookie null r"); if (cookies !=
	 * null) {
	 * 
	 * // Tạo một danh sách lưu trữ các cookie có tên bắt đầu bằng "productID" // và
	 * giá trị là chuỗi gồm 2 số nguyên được ngăn cách bởi dấu ","
	 * 
	 * for (Cookie cookie : cookies) {
	 * 
	 * if (cookie.getName().startsWith("productID")) {
	 * 
	 * // Lấy name của cookie là productId
	 * 
	 * String cookieName = cookie.getName(); // Tìm vị trí của "productID" trong
	 * chuỗi int indexOfProductID = cookieName.indexOf("productID"); if
	 * (indexOfProductID != -1) { try { // Lấy phần từ sau "productID" đến cuối
	 * chuỗi String value = cookieName.substring(indexOfProductID +
	 * "productID".length()); // Sẽ lấy // "1+SM" // Bây giờ bạn có thể tách "1" và
	 * "SM" từ giá trị này. String[] parts = value.split("\\+"); int firstPart = 0;
	 * // id String secondPart = ""; // size if (parts.length == 2) { firstPart =
	 * Integer.parseInt(parts[0]); // id secondPart = parts[1]; // size }
	 * 
	 * GioHangDto gioHangDto2 = new GioHangDto(iGioHangDAO, firstPart, 1,
	 * secondPart); // soluong // auto la 1
	 * 
	 * gioHangDto.add(gioHangDto2);
	 * 
	 * } catch (NumberFormatException e) { e.printStackTrace();
	 * System.out.println("62 - GioHang Controller"); }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * modelAndView.addObject("GioHang", gioHangDto); return modelAndView; }
	 */

	// Lấy danh sách id và số lượng được chọn ở giỏ hàng
	@GetMapping("/paying")
	public ModelAndView handlePayment(@RequestParam("data") String selectedProductsJSON) {

		ModelAndView mav = new ModelAndView("user/thanhToan");

		// Lớp để tách chuỗi Json
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Lấy đanh sách sp từ giỏ hàng
			List<Product_Paying> selectedProducts = objectMapper.readValue(selectedProductsJSON,
					new TypeReference<List<Product_Paying>>() {
					});

			// Tạo các đối tượng đẻ lưu trữ thông tin truyền qua view
			List<ThanhToanDto> DSSP = new ArrayList<ThanhToanDto>();
			Integer tongTien = 0;
			int soLuongSP = 0;

			// Duyệt qua danh sách sản phẩm và truy cập idProduct, quantity, và size
			for (Product_Paying product : selectedProducts) {

				ThanhToanDto tmp = new ThanhToanDto();

				Ctsize ctsize = thanhToanDAO.layCtSize(product.getIdProduct(), product.getSize());

				// Lưu thông tin từng sản phẩm vào biến tạm
				tmp.setCtSize(ctsize);
				tmp.setDonGia(product.getUnitPrice());
				tmp.setSoLuong(product.getQuantity());

				// Thêm sp vào danh sách để truyền qua thanh toán
				DSSP.add(tmp);

				// Tính tổng tiền và tổng số lượng sản phẩm
				tongTien += (product.getUnitPrice() * product.getQuantity());
				soLuongSP += product.getQuantity();

				// Show console
				System.out.println("Show: " + tmp.toString() + " " + tongTien + " " + soLuongSP);

			}

			ObjectMapper o = new ObjectMapper();
			try {
				// Chuyển đổi list thành json để từ view dễ lấy về lại hơn
				String dsspJson = o.writeValueAsString(DSSP);

				// Chuyển đổi danh sách thành chuỗi JSON
				System.out.println("Show json luc moi chuyen doi: " + dsspJson);

				dsspJson = URLEncoder.encode(dsspJson, "UTF-8");
				System.out.println("Show json luc moi chuyen doi: " + dsspJson);
				
				mav.addObject("dsspJson", dsspJson);
				mav.addObject("dssp", DSSP);
				mav.addObject("tongTien", tongTien);
				mav.addObject("soLuongSP", soLuongSP);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
			// Xử lý lỗi nếu cần
		}

		return mav;
	}

	@GetMapping("mua-ngay")
	public ModelAndView muaNgay(
			@RequestParam("mamh") int mamh,
			@RequestParam("masize") int masize,
			@RequestParam("soLuong") int soLuong
			) throws JsonProcessingException {
		ModelAndView mav = new ModelAndView("user/thanhToan");
		try {
		
		List<ThanhToanDto> DSSP = new ArrayList<ThanhToanDto>();
	
		ThanhToanDto sp = new ThanhToanDto();
		sp.setCtSize(thanhToanDAO.layCtSize(new CtsizeId(masize, mamh)));
		sp.setDonGia(donHangDao.LayGiaSP(mamh));
		sp.setDonGiaKM(0);
		sp.setSoLuong(soLuong);
		
		DSSP.add(sp);
		
		ObjectMapper o = new ObjectMapper();
		String dsspJson = o.writeValueAsString(DSSP);
		dsspJson = URLEncoder.encode(dsspJson, "UTF-8");
		
		int tongTien = soLuong * sp.getDonGia();
		int soLuongSP = soLuong;
		
		mav.addObject("dssp", DSSP);
		mav.addObject("dsspJson", dsspJson);
		mav.addObject("tongTien", tongTien);
		mav.addObject("soLuongSP", soLuongSP);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@PostMapping("/thanhToan")
	public ModelAndView thanhToan(@RequestParam("dsspJson") String dsspJson, @RequestParam("hoTen") String hoTen,
			@RequestParam("sdt") String sdt, @RequestParam("tongTien") int tongTien,
			HttpServletRequest request, @RequestParam("diaChi") String diaChi,
			HttpServletResponse response) throws JsonProcessingException {

		ModelAndView mav = new ModelAndView("redirect:/user/giohang");

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			System.out.println("Show diaChi: " + diaChi );
			System.out.println("Show json tra ve: " + dsspJson );

			// decode Json
			dsspJson = URLDecoder.decode(dsspJson, "UTF-8");

			System.out.println("Show json tra ve: " + dsspJson + " ");

			List<ThanhToanDto> dssp = objectMapper.readValue(dsspJson, new TypeReference<List<ThanhToanDto>>() {
			});
			List<Ctpd> ctpd = new ArrayList<Ctpd>(); 

			HttpSession session = request.getSession();
			String userEmail = (String) session.getAttribute("loggedInUserEmail");

			
			Date ngayHienTai = new Date();
			Khachhang kh = thanhToanDAO.layKhachHangTheoGmail(userEmail);

			Phieudat pd = new Phieudat();
			pd.setDiachi(diaChi);
			pd.setHotennguoinhan(hoTen);
			pd.setKhachhang(kh);
			pd.setNgaydat(ngayHienTai);
			pd.setSdt(sdt);
			pd.setTrangthai(1);

			thanhToanDAO.themPhieuDat(pd);

			for (ThanhToanDto sp : dssp) {

				// Thêm vào list ctpd
				Ctpd tmp = new Ctpd();
				CtpdId id = new CtpdId();

				id.setMamh(sp.getCtsizeId().getMamh());
				id.setMapd(pd.getMapd());
				id.setMasize(sp.getCtsizeId().getMasize());

				tmp.setId(id);
				tmp.setSoluong(sp.getSoLuong());

				ctpd.add(tmp);

				Ctsize ctsizeTmp = thanhToanDAO.layCtSize(sp.getCtsizeId());

				// Cập nhật số lượng tồn
				thanhToanDAO.capNhatSLSP(ctsizeTmp, sp.getSoLuong());

				// Xóa sp khỏi cookie

				String maSPTmp = "productID" + String.valueOf(sp.getCtsizeId().getMamh()) + "+"
						+ ctsizeTmp.getSize().getTensize();

				System.out.println("Show maSPTmp: " + maSPTmp);

				Cookie cookie = new Cookie(maSPTmp, "1");
				// Đặt path của cookie
				cookie.setPath("/");

				cookie.setMaxAge(0);
				response.addCookie(cookie);

			}
			
			
			
			thanhToanDAO.themCtpd(ctpd);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;

	}

	@GetMapping("/tmp")
	public ModelAndView tmp() {
		return new ModelAndView("/user/tmp");
	}
}

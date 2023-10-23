package management.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import management.dao.INhapHangDao;
import management.dto.SPNhapDto;
import management.entity.Chatlieu;
import management.entity.Ctpn;
import management.entity.CtpnId;
import management.entity.Loaimh;
import management.entity.Mathang;
import management.entity.Nhacungcap;
import management.entity.Nhanhieu;
import management.entity.Phieunhap;
import management.entity.Size;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private INhapHangDao nhapHangDao;
		
	@GetMapping("/nhap-hang")
	public ModelAndView show() {
		ModelAndView mav = new ModelAndView("admin/nhapHang");
		
		//Lấy thông tin từ CSDL
		List<Mathang> dsMatHang = nhapHangDao.layDSMatHang();
		List<Size> dsSize = nhapHangDao.layDSSize();
		List<Nhacungcap> dsNCC = nhapHangDao.layDSNhaCungCap();
		List<Loaimh> dsLoaiSP = nhapHangDao.layDSLoaiSP();
		List<Chatlieu> dsChatLieu = nhapHangDao.layDSChatlieu();
		List<Nhanhieu> dsNhanHieu = nhapHangDao.layDSNhanHieu();
		
		//Thêm thông tin vào model
		mav.addObject("dsMatHang", dsMatHang);
		mav.addObject("dsNCC", dsNCC);
		mav.addObject("dsSize", dsSize);
		mav.addObject("dsLoaiSP", dsLoaiSP);
		mav.addObject("dsChatLieu", dsChatLieu);
		mav.addObject("dsNhanHieu", dsNhanHieu);
		
		//Kiểm tra
		System.out.println(dsNCC.get(0).getTenncc());
		
		return mav;
	}
	
	@PostMapping("/them-pn")
	public ModelAndView themPN(@RequestBody List<SPNhapDto> dsSPNhap,
								@RequestParam("ncc") int maNCC) {
		
		System.out.println("Ma ncc: "+maNCC);
		
		Date ngayHienTai = new Date();
		
		Phieunhap pn = new Phieunhap();

		pn.setNgaynhap(ngayHienTai);
		pn.setNhacungcap(nhapHangDao.layNCC(maNCC));
		pn.setNhanvien(nhapHangDao.layNhanVien(1));//Còn chưa hoàn thiện
		nhapHangDao.themPhieuNhap(pn);

		List<Ctpn> ctpns = new ArrayList<Ctpn>();
		
		for (SPNhapDto sp : dsSPNhap) {
			System.out.println("Sp trong pn: "+ sp.toString());
	        
	        Ctpn tmp = new Ctpn();
	        
//	        Ctsize ctsize = nhapHangDao.layCtsize(sp.getProductID(), sp.getSizeID());
	        
	        CtpnId ctpnId = new CtpnId();
	        
	        ctpnId.setMapn(pn.getMapn());
	        ctpnId.setMamh(sp.getProductID());
	        ctpnId.setMasize(sp.getSizeID());
	        
	        tmp.setDongia(sp.getGiaNhap()*1000);
	        tmp.setId(ctpnId);
	        tmp.setSoluong(sp.getProductQuantity());
//	        tmp.setCtsize(ctsize);
	        

	        ctpns.add(tmp);
	        
	        //Thêm ctsize nếu như chưa tồn tại để ràng buộc khóa ngoại cho ctpn
	        nhapHangDao.themCtSize(sp.getProductID(), sp.getSizeID());
	        
	    }

		
		nhapHangDao.themCtpn(ctpns);

		ModelAndView mav = new ModelAndView("admin/nhapHang");

	    return mav;
	}
	
	
	@PostMapping("them-sp-moi")
	public ResponseEntity<String> themSPMoi(
			@RequestParam("tenSPMoi") String tenSPMoi,
			@RequestParam("loaiSP") int maLSP,
			@RequestParam("nhanHieu") int maNH,
			@RequestParam("chatLieu") int maCL,
			@RequestParam("moTa") String moTa
			){
		System.out.println(tenSPMoi);
		Mathang mh = new Mathang();
		
		Loaimh lmh = new Loaimh();
		lmh.setMaloaimh(maLSP);
		
		Nhanhieu nh = new Nhanhieu();
		nh.setManh(maNH);
		
		Chatlieu cl = new Chatlieu();
		cl.setMacl(maCL);
		
		mh.setTenmh(tenSPMoi);
		mh.setLoaimh(lmh);
		mh.setNhanhieu(nh);
		mh.setChatlieu(cl);
		mh.setMota(moTa);
		
		nhapHangDao.themSPMoi(mh);
		
		String rp = mh.getMamh()+ "_ "+ mh.getTenmh();
		System.out.println(rp);
		System.out.println(mh.toString());
		
		return ResponseEntity.ok(rp);
	}
	
	@GetMapping("/tmp")
	public ModelAndView tmp() {
		return new ModelAndView("/admin/tmp");
	}
	
}

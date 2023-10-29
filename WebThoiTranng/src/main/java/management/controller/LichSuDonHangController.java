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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

        // Lấy thông tin phiên đăng nhập của người dùng
        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("loggedInUserEmail");

        // Lấy mã khách hàng dựa trên địa chỉ email
        int makh = lichSuDonHangDAO.getMaKHbyEmail("nghianguyenhuu963@gmail.com");

        // Tạo danh sách chứa thông tin đơn hàng
        List<DonhangInfo> listDonhang = new ArrayList<>();

        // Lấy danh sách các phiếu đặt dựa trên mã khách hàng
        List<Phieudat> listPhieuDat = lichSuDonHangDAO.getAllPhieuDatByMaKH(makh);
        
        // Duyệt qua các phiếu đặt để lấy thông tin
        for (Phieudat phieudat : listPhieuDat) {
            DonhangInfo donhangInfo = new DonhangInfo();
            donhangInfo.setPhieudat(phieudat);

            //Tạo danh sách đơn hàng dựa trên phiếu đặt
            List<Donhang> listDonhangForPhieuDat = new ArrayList<>();
            
            List<Integer> mapdList = new ArrayList<>();
            List<Integer> maspList = new ArrayList<>();
            List<Integer> masizeList = new ArrayList<>();

            // Lấy danh sách các mã sản phẩm dựa trên mã phiếu đặt
            List<Integer> listMaSP = lichSuDonHangDAO.getAllMaSPbyMaPD(phieudat.getMapd());

            // Duyệt qua danh sách mã sản phẩm
            for (int masp : listMaSP) {
                List<Integer> listMaSize = lichSuDonHangDAO.getAllMaSizebyMaSPandMaPD(masp, phieudat.getMapd());

                // Duyệt qua danh sách mã size
                for (int masize : listMaSize) {
                	 // Thêm giá trị vào danh sách tương ứng
                    mapdList.add(phieudat.getMapd());
                    maspList.add(masp);
                    masizeList.add(masize);
                }
            }
            
         // Duyệt qua danh sách 'mapdList', 'maspList', và 'masizeList'
            for (int i = 0; i < mapdList.size(); i++) {
                int mapd = mapdList.get(i);
                int masp = maspList.get(i);
                int masize = masizeList.get(i);

                // Lấy thông tin sản phẩm, ngày đặt, size, giá và khuyến mãi
                Mathang mh = lichSuDonHangDAO.layMatHangTheoID(masp);
                int sl = lichSuDonHangDAO.getSoluongSp(masp, mapd, masize);
                Date ngaydat = lichSuDonHangDAO.getNgaydatByMaMH(mapd);
                int gia = lichSuDonHangDAO.getPriceByMaMH(masp, ngaydat);
                String size = lichSuDonHangDAO.getMucSizebyMaSize(masize);
                double khuyenmai = lichSuDonHangDAO.getKhuyenMai(masp, ngaydat);
                int danhgia = lichSuDonHangDAO.getDanhgia(masp, "nghianguyenhuu963@gmail.com");

                // Tạo đối tượng Donhang và thêm vào danh sách
                Donhang dh = new Donhang();
                dh.setMamh(masp);
                dh.setTenSP(mh.getTenmh());
                dh.setSoluong(sl);
                dh.setTonggia(gia * sl);
                dh.setNgaydat(ngaydat);
                dh.setSize(size);
                dh.setMucgiamgia(khuyenmai);
                dh.setDanhgia(danhgia);

                listDonhangForPhieuDat.add(dh);
            }

            donhangInfo.setListDonhangForPhieuDat(listDonhangForPhieuDat);
            listDonhang.add(donhangInfo);
        }
     

        ModelAndView modelAndView = new ModelAndView("user/lichsudonhang");
        modelAndView.addObject("listDonhang", listDonhang);
        return modelAndView;
    }
    
    @PostMapping("rate")
    @ResponseBody
    public String rateProduct(HttpServletRequest request, ModelMap model,
            @RequestParam("mamh") int mamh,
            @RequestParam("danhgia") int danhgia) {

        // Lấy thông tin phiên đăng nhập của người dùng
        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("loggedInUserEmail");

        // Kiểm tra xem sản phẩm đã được đánh giá chưa bằng cách truy vấn cơ sở dữ liệu
        boolean isProductRated = lichSuDonHangDAO.isProductRated(mamh, "nghianguyenhuu963@gmail.com");

        boolean saveResult;

        if (isProductRated) {
            // Nếu sản phẩm đã được đánh giá trước đó, thực hiện cập nhật đánh giá
            saveResult = lichSuDonHangDAO.updateRating(mamh, "nghianguyenhuu963@gmail.com", danhgia);
        } else {
            // Nếu sản phẩm chưa được đánh giá, thực hiện thêm bản ghi mới
            saveResult = lichSuDonHangDAO.saveRating(mamh, "nghianguyenhuu963@gmail.com", danhgia);
        }

        model.addAttribute("danhgiaStatus", isProductRated);
        
        if (saveResult) {
            return "Đánh giá sản phẩm thành công";
        } else {
            return "Không thể đánh giá hoặc cập nhật đánh giá sản phẩm. Vui lòng thử lại sau.";
        }
    }
}


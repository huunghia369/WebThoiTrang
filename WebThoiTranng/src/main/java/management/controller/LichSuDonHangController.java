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

        // Lấy thông tin phiên đăng nhập của người dùng
        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("loggedInUserEmail");

        // Lấy mã khách hàng dựa trên địa chỉ email
        int makh = lichSuDonHangDAO.getMaKHbyEmail("nghianguyenhuu963@gmail.com");

        // Lấy danh sách các phiếu đặt dựa trên mã khách hàng
        List<Phieudat> listPhieuDat = lichSuDonHangDAO.getAllPhieuDatByMaKH(makh);

        // Tạo danh sách chứa thông tin đơn hàng
        List<DonhangInfo> listDonhang = new ArrayList<>();

        // Duyệt qua các phiếu đặt để lấy thông tin
        for (Phieudat phieudat : listPhieuDat) {
            DonhangInfo donhangInfo = new DonhangInfo();
            donhangInfo.setPhieudat(phieudat);

            List<Donhang> listDonhangForPhieuDat = new ArrayList<>();

            // Lấy danh sách các mã sản phẩm dựa trên mã phiếu đặt
            List<Integer> listMaSP = lichSuDonHangDAO.getAllMaSPbyMaPD(phieudat.getMapd());

            // Duyệt qua danh sách mã sản phẩm
            for (int masp : listMaSP) {
                List<Integer> listMaSize = lichSuDonHangDAO.getAllMaSizebyMaSPandMaPD(masp, phieudat.getMapd());

                // Duyệt qua danh sách mã size
                for (int masize : listMaSize) {
                    // Lấy thông tin sản phẩm, ngày đặt, size, giá và khuyến mãi
                    Mathang mh = lichSuDonHangDAO.layMatHangTheoID(masp);
                    int sl = lichSuDonHangDAO.getSoluongSp(masp, phieudat.getMapd(), masize);
                    Date ngaydat = lichSuDonHangDAO.getNgaydatByMaMH(phieudat.getMapd());
                    int gia = lichSuDonHangDAO.getPriceByMaMH(masp, ngaydat);
                    String size = lichSuDonHangDAO.getMucSizebyMaSize(masize);
                    double khuyenmai = lichSuDonHangDAO.getKhuyenMai(masp, ngaydat);

                    Donhang dh = new Donhang();
                    dh.setMamh(masp);
                    dh.setTenSP(mh.getTenmh());
                    dh.setSoluong(sl);
                    dh.setTonggia(gia * sl);
                    dh.setNgaydat(ngaydat);
                    dh.setSize(size);
                    dh.setMucgiamgia(khuyenmai);

                    listDonhangForPhieuDat.add(dh);
                }
            }

            donhangInfo.setListDonhangForPhieuDat(listDonhangForPhieuDat);
            listDonhang.add(donhangInfo);
        }

        ModelAndView modelAndView = new ModelAndView("user/lichsudonhang");
        modelAndView.addObject("listDonhang", listDonhang);
        return modelAndView;
    }
}


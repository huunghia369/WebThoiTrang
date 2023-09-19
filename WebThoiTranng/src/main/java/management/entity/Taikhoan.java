package management.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "taikhoan")
public class Taikhoan implements java.io.Serializable {

    @Id
    @Column(name = "TENTK", unique = true, nullable = false, length = 50)
    private String tentk;

    
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "taikhoan")
    private Khachhang khachhang;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAQUYEN")
    private Quyen quyen;

    @Column(name = "MATKHAU")
    private String matkhau;

    @Column(name = "MANV", length = 10)
    private String manv;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taikhoan")
    private Set<Danhgia> danhgias = new HashSet<Danhgia>(0);
    
   
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "taikhoan")
    private Nhanvien nhanvien;


    @Column(name = "EMAIL", unique = true, nullable = false, length = 500)
    private String email;

    public Taikhoan() {
    }

    public Taikhoan(String tentk, String matkhau) {
        this.tentk = tentk;
        this.matkhau = matkhau;
    }

    public Taikhoan(String tentk, Khachhang khachhang, Quyen quyen, String matkhau, String manv,
            Set<Danhgia> danhgias) {
        this.tentk = tentk;
        this.khachhang = khachhang;
        this.quyen = quyen;
        this.matkhau = matkhau;
        this.manv = manv;
        this.danhgias = danhgias;
    }

    // Getter và Setter cho các trường

    public String getTentk() {
        return this.tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public Khachhang getKhachhang() {
        return this.khachhang;
    }

    public void setKhachhang(Khachhang khachhang) {
        this.khachhang = khachhang;
    }

    public Quyen getQuyen() {
        return this.quyen;
    }

    public void setQuyen(Quyen quyen) {
        this.quyen = quyen;
    }

    public String getMatkhau() {
        return this.matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getManv() {
        return this.manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public Set<Danhgia> getDanhgias() {
        return this.danhgias;
    }

    public void setDanhgias(Set<Danhgia> danhgias) {
        this.danhgias = danhgias;
    }


package management.entity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
    name = "khachhang",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "EMAIL"),
        @UniqueConstraint(columnNames = "MASOTHUE"),
        @UniqueConstraint(columnNames = "SDT"),
        @UniqueConstraint(columnNames = "SOCMND")
    }
)
public class Khachhang implements java.io.Serializable {

    @Id
    @Column(name = "MAKH", unique = true, nullable = false, length = 10)
    private String makh;

    @Column(name = "HOTENKH", nullable = true, length = 50)
    private String hotenkh;

    @Column(name = "SOCMND", unique = true, nullable = true, length = 15)
    private String socmnd;

    @Column(name = "GIOITINH")
    private Boolean gioitinh;

    @Temporal(TemporalType.DATE)
    @Column(name = "NGAYSINH", nullable = true, length = 10)
    private Date ngaysinh;

    @Column(name = "DIACHI", nullable = true, length = 100)
    private String diachi;

    @Column(name = "SDT", unique = true, nullable = true, length = 15)
    private String sdt;

    @Column(name = "MASOTHUE", unique = true, nullable = true, length = 15)
    private String masothue;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "khachhang")
    private Set<Hoadon> hoadons = new HashSet<Hoadon>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "khachhang")
    private Set<Phieudat> phieudats = new HashSet<Phieudat>(0);

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL", nullable = false)
    private Taikhoan taikhoan;

    public Khachhang() {
    }

    // ... (các phương thức getter và setter cho các trường)

    public Khachhang(String makh, String hotenkh, String socmnd, Boolean gioitinh, Date ngaysinh,
            String diachi, String sdt, String masothue, Set<Hoadon> hoadons, Set<Phieudat> phieudats) {
        this.makh = makh;
        this.hotenkh = hotenkh;
        this.socmnd = socmnd;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.masothue = masothue;
        this.hoadons = hoadons;
        this.phieudats = phieudats;
    }

    // ... (các phương thức getter và setter cho taikhoan)
}
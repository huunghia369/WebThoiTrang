package management.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "nhanvien", uniqueConstraints = {
        @UniqueConstraint(columnNames = "EMAIL"),
        @UniqueConstraint(columnNames = "SDT") })
public class Nhanvien implements java.io.Serializable {

    @Id
    @Column(name = "MANV", unique = true, nullable = false, length = 10)
    private String manv;

    @Column(name = "TENNV", nullable = false, length = 50)
    private String tennv;

    @Column(name = "GIOITINH")
    private Boolean gioitinh;

    @Temporal(TemporalType.DATE)
    @Column(name = "NGAYSINH", nullable = false, length = 10)
    private Date ngaysinh;

    @Column(name = "DIACHI", nullable = false, length = 100)
    private String diachi;

    @Column(name = "SDT", unique = true, nullable = false, length = 15)
    private String sdt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL", nullable = false)
    private Taikhoan taikhoan;

   
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nhanvien")
    private Set<Dondathang> dondathangs = new HashSet<Dondathang>(0);

    // Các getter và setter
    // ...

    public Nhanvien() {
    }

    

    // ...
}
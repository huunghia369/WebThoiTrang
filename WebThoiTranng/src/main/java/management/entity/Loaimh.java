package management.entity;
// Generated Dec 14, 2022, 9:49:56 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Loaimh generated by hbm2java
 */
@Entity
@Table(name = "loaimh",uniqueConstraints = @UniqueConstraint(columnNames = "TENLOAIMH"))
public class Loaimh implements java.io.Serializable {

	private int maloaimh;
	private String tenloaimh;
	private String slug;
	
	
	private Set<Mathang> mathangs = new HashSet<Mathang>(0);

	public Loaimh() {
	}

	public Loaimh(int maloaimh, String tenloaimh) {
		this.maloaimh = maloaimh;
		this.tenloaimh = tenloaimh;
	}

	public Loaimh(int maloaimh, String tenloaimh, Set<Mathang> mathangs) {
		this.maloaimh = maloaimh;
		this.tenloaimh = tenloaimh;
		this.mathangs = mathangs;
	}

	@Id

	@Column(name = "MALOAIMH", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getMaloaimh() {
		return this.maloaimh;
	}

	public void setMaloaimh(int maloaimh) {
		this.maloaimh = maloaimh;
	}

	@Column(name = "TENLOAIMH", unique = true, nullable = false, columnDefinition = "nvarchar(100)")
	public String getTenloaimh() {
		return this.tenloaimh;
	}

	public void setTenloaimh(String tenloaimh) {
		this.tenloaimh = tenloaimh;
	}
	@Column(name = "SLUG", unique = true, nullable = false, columnDefinition = "varchar(100)")
	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}


	@OneToMany(fetch = FetchType.EAGER, mappedBy = "loaimh")
	public Set<Mathang> getMathangs() {
		return this.mathangs;
	}

	
	public void setMathangs(Set<Mathang> mathangs) {
		this.mathangs = mathangs;
	}

}

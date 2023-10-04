package management.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ctsize")
public class Ctsize implements java.io.Serializable{
	
	private CtsizeId id;
	private Size size;
	private Mathang mathang;
	private int soluong;
	
	public Ctsize(CtsizeId id, Size size, Mathang mathang) {
		
		this.id = id;
		this.size = size;
		this.mathang = mathang;
	}
	public Ctsize() {
		
	}
	
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	@EmbeddedId
	
	@AttributeOverrides({
			@AttributeOverride(name = "masize", column = @Column(name = "MASIZE", nullable = false)),
			@AttributeOverride(name = "mamh", column = @Column(name = "MAMH", nullable = false)) })
	public CtsizeId getId() {
		return this.id;
	}
	public void setId(CtsizeId id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MASIZE", nullable = false, insertable = false, updatable = false)
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	
		
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MAMH", nullable = false, insertable = false, updatable = false)
	
	
	public Mathang getMathang() {
		return mathang;
	}
	public void setMathang(Mathang mathang) {
		this.mathang = mathang;
	}
	
	
	
	
}

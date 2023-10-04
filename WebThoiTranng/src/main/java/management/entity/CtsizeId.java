package management.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CtsizeId implements java.io.Serializable {

	private int masize;
	private int mamh;

	public CtsizeId() {
	}

	public CtsizeId(int masize, int mamh) {

		this.masize = masize;
		this.mamh = mamh;
	}



	@Column(name = "SIZE", nullable = false, length = 10)
	public int getMasize() {
		return masize;
	}

	public void setMasize(int masize) {
		this.masize = masize;
	}

	@Column(name = "MAMH", nullable = false)

	public int getMamh() {
		return this.mamh;
	}

	

	public void setMamh(int mamh) {
		this.mamh = mamh;
	}

	

}


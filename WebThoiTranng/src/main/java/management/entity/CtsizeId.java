package management.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CtsizeId implements java.io.Serializable {

	private String masize;
	private String mamh;

	public CtsizeId() {
	}

	public CtsizeId(String masize, String mamh) {
		this.masize = masize;
		this.mamh = mamh;
	}

	@Column(name = "SIZE", nullable = false, length = 10)
	public String getMasize() {
		return masize;
	}

	public void setMasize(String masize) {
		this.masize = masize;
	}

	@Column(name = "MAMH", nullable = false, length = 10)
	public String getMamh() {
		return this.mamh;
	}

	

	public void setMamh(String mamh) {
		this.mamh = mamh;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CtddhId))
			return false;
		CtddhId castOther = (CtddhId) other;

		return ((this.getMasize() == castOther.getMaddh()) || (this.getMasize() != null && castOther.getMaddh() != null
				&& this.getMasize().equals(castOther.getMaddh())))
				&& ((this.getMamh() == castOther.getMamh()) || (this.getMamh() != null && castOther.getMamh() != null
						&& this.getMamh().equals(castOther.getMamh())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMasize() == null ? 0 : this.getMasize().hashCode());
		result = 37 * result + (getMamh() == null ? 0 : this.getMamh().hashCode());
		return result;
	}

}


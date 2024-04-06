package in.satya.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Counseller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String cname;
	private String email;
	private String password;
	private Long phno;

	@OneToMany(mappedBy = "counsellor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Enquirye> enquirye;

	public Counseller() {

	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public List<Enquirye> getEnquirye() {
		return enquirye;
	}

	public void setEnquirye(List<Enquirye> enquirye) {
		this.enquirye = enquirye;
	}

	@Override
	public String toString() {
		return "Counseller [cid=" + cid + ", cname=" + cname + ", email=" + email + ", password=" + password + ", phno="
				+ phno + ", enquirye=" + enquirye + "]";
	}

}

package in.satya.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enquirye {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;
	private String ename;
	private Long phonumber;
	private String course;
	private String mode;
	private String status;

	@ManyToOne
	@JoinColumn(name = "cid")
	private Counseller counsellor;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Long getPhonumber() {
		return phonumber;
	}

	public void setPhonumber(Long phonumber) {
		this.phonumber = phonumber;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Counseller getCounsellor() {
		return counsellor;
	}

	public void setCounsellor(Counseller counsellor) {
		this.counsellor = counsellor;
	}

	@Override
	public String toString() {
		return "Enquirye [eid=" + eid + ", ename=" + ename + ", phonumber=" + phonumber + ", course=" + course
				+ ", mode=" + mode + ", status=" + status + "]";
	}

}

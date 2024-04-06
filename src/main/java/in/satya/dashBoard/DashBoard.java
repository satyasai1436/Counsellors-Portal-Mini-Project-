package in.satya.dashBoard;

public class DashBoard {

	private Long totalEnq;
	private Long openEnq;
	private Long enrolledEnq;
	private Long lostEnq;

	public Long getTotalEnq() {
		return totalEnq;
	}

	public void setTotalEnq(Long totalEnq) {
		this.totalEnq = totalEnq;
	}

	public Long getOpenEnq() {
		return openEnq;
	}

	public void setOpenEnq(Long openEnq) {
		this.openEnq = openEnq;
	}

	public Long getEnrolledEnq() {
		return enrolledEnq;
	}

	public void setEnrolledEnq(Long enrolledEnq) {
		this.enrolledEnq = enrolledEnq;
	}

	public Long getLostEnq() {
		return lostEnq;
	}

	public void setLostEnq(Long lostEnq) {
		this.lostEnq = lostEnq;
	}

	@Override
	public String toString() {
		return "DashBoard [totalEnq=" + totalEnq + ", openEnq=" + openEnq + ", enrolledEnq=" + enrolledEnq
				+ ", lostEnq=" + lostEnq + "]";
	}

}

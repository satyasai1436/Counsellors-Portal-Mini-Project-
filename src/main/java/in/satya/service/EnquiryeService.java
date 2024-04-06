package in.satya.service;

import java.util.List;

import in.satya.dashBoard.DashBoard;
import in.satya.entity.Enquirye;

public interface EnquiryeService {

	public DashBoard getDashBoard(Integer cid);

	public Enquirye saveEnq(Enquirye enquirye, Integer cid);

	public List<Enquirye> viewEnq(Enquirye enquirye, Integer cid);

	public Enquirye enqById(Integer eid);

}

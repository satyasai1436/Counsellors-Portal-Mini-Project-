package in.satya.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.satya.dashBoard.DashBoard;
import in.satya.entity.Counseller;
import in.satya.entity.Enquirye;
import in.satya.repo.CounsellerRepo;
import in.satya.repo.EnquiryeRepo;

@Service
public class EnqServiceImpl implements EnquiryeService {
	@Autowired
	private EnquiryeRepo EnquiryeRepo;

	@Autowired
	private CounsellerRepo counsellerRepo;

	@Override
	public DashBoard getDashBoard(Integer cid) {
		Long totalEnq = EnquiryeRepo.getEnquire(cid);
		Long openEnq = EnquiryeRepo.getOpenEnquire(cid, "new");
		Long enrolledEnq = EnquiryeRepo.getOpenEnquire(cid, "enrolled");
		Long lostEnq = EnquiryeRepo.getOpenEnquire(cid, "lost");

		DashBoard dashBoard = new DashBoard();
		dashBoard.setTotalEnq(totalEnq);
		dashBoard.setOpenEnq(openEnq);
		dashBoard.setEnrolledEnq(enrolledEnq);
		dashBoard.setLostEnq(lostEnq);

		return dashBoard;
	}

	@Override
	public Enquirye saveEnq(Enquirye enquirye, Integer cid) {
		Counseller counId = counsellerRepo.findById(cid).orElseThrow();
		enquirye.setCounsellor(counId);
		return EnquiryeRepo.save(enquirye);

	}

	@Override
	public List<Enquirye> viewEnq(Enquirye enquirye, Integer cid) {
		Counseller counId = counsellerRepo.findById(cid).orElseThrow();

		Enquirye enquiry = new Enquirye();
		enquiry.setCounsellor(counId);
		if (null != enquirye.getMode() && !"".equals(enquirye.getMode())) {
			enquiry.setMode(enquirye.getMode());
		}
		if (null != enquirye.getCourse() && !"".equals(enquirye.getCourse())) {
			enquiry.setCourse(enquirye.getCourse());
		}
		if (null != enquirye.getStatus() && !"".equals(enquirye.getStatus())) {
			enquiry.setStatus(enquirye.getStatus());
		}

		// enquirye.setCounsellor(counId);
		Example<Enquirye> of = Example.of(enquiry);
		List<Enquirye> list = EnquiryeRepo.findAll(of);
		return list;
	}

	@Override
	public Enquirye enqById(Integer eid) {
		Optional<Enquirye> byId = EnquiryeRepo.findById(eid);
		if (byId.isPresent()) {
			return byId.get();
		} else {
			return null;
		}

	}

}

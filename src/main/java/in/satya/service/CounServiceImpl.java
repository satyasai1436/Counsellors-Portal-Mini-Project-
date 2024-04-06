package in.satya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.satya.entity.Counseller;
import in.satya.repo.CounsellerRepo;

@Service
public class CounServiceImpl implements CounsellerService {
	@Autowired
	private CounsellerRepo counsellerRepo;

	@Override
	public boolean saveCounsellor(Counseller counsellor) {
		List<Counseller> byEmail = counsellerRepo.findByEmail(counsellor.getEmail());
		if (!byEmail.isEmpty()) {

			return false;
		} else {

			Counseller save = counsellerRepo.save(counsellor);

			return save.getCid() != null;
		}
	}

	@Override
	public Counseller getCounseller(String email, String password) {
		return counsellerRepo.findByEmailAndPassword(email, password);

	}

}

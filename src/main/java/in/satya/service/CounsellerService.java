package in.satya.service;

import in.satya.entity.Counseller;

public interface CounsellerService {

	public boolean saveCounsellor(Counseller counsellor);

	public Counseller getCounseller(String email, String password);

}

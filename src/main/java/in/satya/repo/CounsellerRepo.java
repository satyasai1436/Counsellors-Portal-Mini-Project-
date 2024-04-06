package in.satya.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.satya.entity.Counseller;

public interface CounsellerRepo extends JpaRepository<Counseller, Integer> {

	public Counseller findByEmailAndPassword(String email, String password);

	public List<Counseller> findByEmail(String email);

}

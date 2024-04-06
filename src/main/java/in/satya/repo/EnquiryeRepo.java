package in.satya.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.satya.entity.Enquirye;

public interface EnquiryeRepo extends JpaRepository<Enquirye, Integer> {

	@Query(value = "select count(*) from Enquirye where cid=:id", nativeQuery = true)
	public Long getEnquire(Integer id);

	@Query(value = "select count(*) from Enquirye where cid=:id and status=:status", nativeQuery = true)

	public Long getOpenEnquire(Integer id, String status);

}

package persondata.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import persondata.demo.entity.Person;
@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person,Integer> {
	
}

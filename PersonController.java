package persondata.demo.controller;

import java.util.List;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import persondata.demo.entity.Person;
import persondata.demo.repository.PersonRepository;
@RestController
@RequestMapping("person")
public class PersonController {
	@Autowired
	private final PersonRepository personRepository;

	public PersonController(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}
	@PostMapping
	public Person save(@RequestBody Person person) {
		return personRepository.save(person);	
	}
	@PostMapping("/all")
	public List<Person> saveAll(@RequestBody List<Person> persons) {
		return personRepository.saveAll(persons);	
	}
	@GetMapping("/{id}")
	public Person findbyId(@PathVariable Integer id) {
		return personRepository.findById(id).orElse(null);		
	}
	@GetMapping
	public List<Person> findAll(){
		return personRepository.findAll();	
	}
	@PutMapping("update/{id}")
	public Person update(@PathVariable Integer id,@RequestBody Person person) {
	Person finalperson=personRepository.findById(id).orElse(null);
	finalperson.setName(person.getName());
	finalperson.setLocation(person.getLocation());
	finalperson.setBirthDate(person.getBirthDate());
	return personRepository.save(finalperson);	
	}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		personRepository.deleteById(id);
	}
}

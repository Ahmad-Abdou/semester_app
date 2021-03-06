package se.lexicon.semester_app.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.semester_app.entity.Company;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, String> {

    List<Company> findCompanyByNameContainsIgnoreCase(String name);

}

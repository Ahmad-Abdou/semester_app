package se.lexicon.semester_app.repository;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.semester_app.entity.Company;
import se.lexicon.semester_app.entity.Employee;
import se.lexicon.semester_app.entity.User;
import se.lexicon.semester_app.entity.UserType;

import java.time.LocalDate;

@SpringBootTest
public class EmployeeRepositoryTest {
    EmployeeRepository employeeRepository;
    Employee employee;
    Company company;
    CompanyRepository companyRepository;
    User user;
    UserRepository userRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @BeforeEach
    public void setUp() {
        employee = new Employee();
        employee.setSavedVacation(12);
        employee.setDateOfEmployment(LocalDate.of(2021, 01, 12));
        employeeRepository.save(employee);

        company = new Company();
        company.setName("Test");
        companyRepository.save(company);

        User user = new User();
        user.setEmail("Test");
        user.setUserType(UserType.USER);
        userRepository.save(user);
    }
}

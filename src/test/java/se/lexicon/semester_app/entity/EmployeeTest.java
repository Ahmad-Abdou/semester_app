package se.lexicon.semester_app.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class EmployeeTest {
    Employee employee;
    User user;

    @BeforeEach
    public void setUp() {
        employee = new Employee();
        employee.setCompany(employee.getCompany());
        employee.setUser(user);
        employee.setSavedVacation(22);
        employee.setDateOfEmployment(LocalDate.of(2021, 01, 12));

        user = new User();
        user.setEmail("Test");
        user.setUserType(UserType.USER);
    }

    @Test
    @DisplayName("Test1")
    public void test1_create_Employee() {
        Assertions.assertEquals(12, employee.getSavedVacation());
        Assertions.assertEquals(LocalDate.of(2021, 01, 12), employee.getDateOfEmployment());
    }

    @Test
    @DisplayName("Test2")
    public void test2_equal() {
        employee = new Employee();
        employee.setSavedVacation(12);
        employee.setDateOfEmployment(LocalDate.of(2021, 01, 12));
        employee.setUser(user);
        Assertions.assertTrue(employee.equals(employee));
    }

    @Test
    @DisplayName("Test3")
    public void test3_hashCode() {
        employee = new Employee();
        employee.setDateOfEmployment(LocalDate.of(2021, 01, 12));
        employee.setUser(user);
        Assertions.assertEquals(employee.hashCode(), employee.hashCode());

    }

}


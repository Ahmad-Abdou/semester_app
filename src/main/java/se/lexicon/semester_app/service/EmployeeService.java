package se.lexicon.semester_app.service;

import se.lexicon.semester_app.dto.CompanyDto;
import se.lexicon.semester_app.dto.EmployeeDto;
import se.lexicon.semester_app.entity.Employee;
import se.lexicon.semester_app.exception.RecordNotFoundException;

import java.util.List;

public interface EmployeeService {

    EmployeeDto findById(String id) throws RecordNotFoundException;

    EmployeeDto create(EmployeeDto employeeDto) throws RecordNotFoundException;

    EmployeeDto update(EmployeeDto employeeDto) throws RecordNotFoundException;

    List<EmployeeDto> findByUserType(int userType);

    List<EmployeeDto> findAll();

    List<EmployeeDto> findByCompany(CompanyDto companyDto);

    void delete(String id);

    List<EmployeeDto> findByRequest(String request);
}
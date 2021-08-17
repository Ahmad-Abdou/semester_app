package se.lexicon.semester_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.semester_app.dto.VacationDayDto;
import se.lexicon.semester_app.exception.RecordNotFoundException;
import se.lexicon.semester_app.service.UserService;
import se.lexicon.semester_app.service.VacationDayService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vacationDay")
@CrossOrigin("*")
public class VacationDayController {

    VacationDayService vacationDayService;
    UserService userService;


    @Autowired
    public void setVacationDayService(VacationDayService vacationDayService) {
        this.vacationDayService = vacationDayService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<VacationDayDto>> findAll() {
        System.out.println();
        return ResponseEntity.status(HttpStatus.OK).body(vacationDayService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<VacationDayDto> findById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        if (id == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.status(HttpStatus.OK).body(vacationDayService.findById(id));
    }


    @PostMapping
    public ResponseEntity<VacationDayDto> create(@RequestBody VacationDayDto vacationDayDto) throws RecordNotFoundException {
        if (vacationDayDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(vacationDayService.create(vacationDayDto));
    }


    @PutMapping
    public ResponseEntity<VacationDayDto> update(@RequestBody VacationDayDto vacationDayDto) throws RecordNotFoundException {
        if (vacationDayDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(vacationDayService.update(vacationDayDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        vacationDayService.delete(id);
        return ResponseEntity.ok().build();
    }
}

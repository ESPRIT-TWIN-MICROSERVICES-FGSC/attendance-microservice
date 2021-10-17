package esprit.fgsc.attendancemicroservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import esprit.fgsc.attendancemicroservice.entities.Attendance;
import esprit.fgsc.attendancemicroservice.services.AttendanceService;


@CrossOrigin(origins = "*")
@RestController
public class AttendanceContoller {
	@Autowired
	private  AttendanceService attendanceService;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
		return new ResponseEntity<>(attendanceService.addAttendance(attendance), HttpStatus.OK);
	}
	
	@GetMapping("/attendance")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Attendance> >getAllAttendance(){
		 return new ResponseEntity<>(attendanceService.getAllAttendances(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteAttendance(@PathVariable String id) {
	    return attendanceService.deleteAttendance(id.toString());
	}

	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Attendance> updateAttendance(@PathVariable("id") String id,@Valid @RequestBody Attendance attendance) {
		return new ResponseEntity<>(attendanceService.updateAttendance(id, attendance),HttpStatus.OK);
	}
	
}

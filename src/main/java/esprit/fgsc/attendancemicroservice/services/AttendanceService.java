package esprit.fgsc.attendancemicroservice.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esprit.fgsc.attendancemicroservice.entities.Attendance;
import esprit.fgsc.attendancemicroservice.repository.IAttendanceRepository;

@Service
public class AttendanceService {
	@Autowired
	private IAttendanceRepository attendanceRepository;
	
	public Attendance addAttendance(Attendance attendance) {
		return attendanceRepository.save(attendance);
		
	}
	public List<Attendance>getAllAttendances(){
		 return attendanceRepository.findAll();
	}
	
	public void deleteAttendance(String id) {   

		attendanceRepository.deleteById(id);
   	
	}
          
public Attendance updateAttendance(String id,Attendance newAttendance) {
	if(attendanceRepository.findById(id).isPresent()) {
		Attendance existingAttendance= attendanceRepository.findById(id).get();
		existingAttendance.setCheckIn(newAttendance.getCheckIn());
		existingAttendance.setDepartement(newAttendance.getDepartement());
		existingAttendance.setFirstName(newAttendance.getFirstName());
		existingAttendance.setLastName(newAttendance.getLastName());
		existingAttendance.setShift(newAttendance.getShift());
		existingAttendance.setStatus(newAttendance.getStatus());
		existingAttendance.setEmployeId(newAttendance.getEmployeId());
		
		return attendanceRepository.save(existingAttendance);
		
	}else {
		return null;
	}
}

public Attendance getAttendanceById(String id) {
	return attendanceRepository.findById(id).get();
	
}
}

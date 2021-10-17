package esprit.fgsc.attendancemicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import esprit.fgsc.attendancemicroservice.entities.Attendance;
@Repository
public interface IAttendanceRepository  extends MongoRepository<Attendance, String> {

}

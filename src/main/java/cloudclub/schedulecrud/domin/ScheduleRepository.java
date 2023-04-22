package cloudclub.schedulecrud.domin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query(value = "SELECT s FROM Schedule s WHERE month(s.schedule_date) = :month")
    List<Schedule> findByMonth(int month);
}

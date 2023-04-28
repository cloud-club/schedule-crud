package cloudclub.schedulecrud.domin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // 찾고자 하는 month 를 보내서, 현재 달과 일치하는 active 된 일정을 모두 가져온다.
    @Query(value = "SELECT s FROM Schedule s WHERE month(s.schedule_date) = :month AND s.isActive = true")
    List<Schedule> findByMonth(int month);

    // 찾고자 하는 month, day 를 같이 보내서, 현재 일자와 일치하는 active 된 일정을 모두 가져온다.
    @Query(value = "SELECT s FROM Schedule s WHERE month(s.schedule_date) = :month AND day(s.schedule_date) = :day AND s.isActive = true")
    List<Schedule> findByDay(int month, int day);
}

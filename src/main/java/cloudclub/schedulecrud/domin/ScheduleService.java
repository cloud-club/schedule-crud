package cloudclub.schedulecrud.domin;

import cloudclub.schedulecrud.domin.dto.ScheduleDayDto;
import cloudclub.schedulecrud.domin.dto.ScheduleDto;
import cloudclub.schedulecrud.domin.dto.ScheduleMonthDayReq;
import cloudclub.schedulecrud.domin.dto.ScheduleReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public List<ScheduleDto> findMonth(int month) {
        return scheduleRepository.findByMonth(month)
                .stream()
                .map(ScheduleDto::of)
                .collect(Collectors.toList());
    }

    public List<ScheduleDayDto> findDay(ScheduleMonthDayReq req) {
        return scheduleRepository.findByDay(req.getMonth(), req.getDay())
                .stream()
                .map(ScheduleDayDto::of)
                .collect(Collectors.toList());
    }

    public void save(ScheduleReq request) {
        Schedule schedule = Schedule.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .schedule_date(request.getSchedule_date())
                .remind_date((request.getRemind_date()))
                .build();

        scheduleRepository.save(schedule);
    }

    public void remove(Long id) {
        Schedule schedule = scheduleRepository.findById(id).get();
        schedule.delete();
        scheduleRepository.save(schedule);
    }
}

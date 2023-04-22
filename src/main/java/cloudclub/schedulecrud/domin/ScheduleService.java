package cloudclub.schedulecrud.domin;

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

    public void save(ScheduleReq request) {

        Schedule schedule = Schedule.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .schedule_date(request.getSchedule_date())
                .remind_date((request.getRemind_date()))
                .build();

        scheduleRepository.save(schedule);
    }
}

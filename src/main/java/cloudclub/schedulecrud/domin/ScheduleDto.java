package cloudclub.schedulecrud.domin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleDto {

    private LocalDate schedule_date;

    public static ScheduleDto of(Schedule entity) {
        return ScheduleDto.builder()
                .schedule_date(entity.getSchedule_date())
                .build();
    }
}

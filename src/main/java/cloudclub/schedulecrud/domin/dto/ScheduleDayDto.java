package cloudclub.schedulecrud.domin.dto;

import cloudclub.schedulecrud.domin.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleDayDto {

    private String title;
    private String content;
    private LocalDate schedule_date;
    private int remind_date;
    private Long id;

    public static ScheduleDayDto of(Schedule entity) {
        return ScheduleDayDto.builder()
                .title(entity.getTitle())
                .content(entity.getContent())
                .schedule_date(entity.getSchedule_date())
                .remind_date(entity.getRemind_date())
                .id(entity.getId())
                .build();
    }
}

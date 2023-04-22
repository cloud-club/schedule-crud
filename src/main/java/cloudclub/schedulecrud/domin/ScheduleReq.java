package cloudclub.schedulecrud.domin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class ScheduleReq {

    private String title;
    private String content;
    private LocalDate schedule_date;
    private int remind_date;

}

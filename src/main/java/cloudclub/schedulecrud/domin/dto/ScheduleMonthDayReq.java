package cloudclub.schedulecrud.domin.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ScheduleMonthDayReq {
    private int month;
    private int day;
}

package cloudclub.schedulecrud.domin;

import cloudclub.schedulecrud.domin.dto.ScheduleDayDto;
import cloudclub.schedulecrud.domin.dto.ScheduleDto;
import cloudclub.schedulecrud.domin.dto.ScheduleMonthDayReq;
import cloudclub.schedulecrud.domin.dto.ScheduleReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ScheduleController {

    private final ScheduleService service;

    @GetMapping("api/month/{month}")
    public List<ScheduleDto> findMonth (
            @PathVariable int month
    ) throws Exception {
        return service.findMonth(month);
    }

    @GetMapping("api/day")
    public List<ScheduleDayDto> findDay (
            @RequestBody ScheduleMonthDayReq req
    ) throws Exception {
        return service.findDay(req);
    }

    @PostMapping("api/")
    public void save (
            @RequestBody ScheduleReq request
    ) throws Exception {
        service.save(request);
    }

    @DeleteMapping("api/{id}")
    public void delete (
            @PathVariable Long id
    ) throws Exception {
        service.remove(id);
    }


}

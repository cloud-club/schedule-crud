package cloudclub.schedulecrud.domin;

import cloudclub.schedulecrud.domin.dto.ScheduleDayDto;
import cloudclub.schedulecrud.domin.dto.ScheduleDto;
import cloudclub.schedulecrud.domin.dto.ScheduleReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
            @RequestParam int month,
            @RequestParam int day
    ) throws Exception {
        return service.findDay(month, day);
    }

    @PostMapping("api")
    public void save (
            @RequestBody ScheduleReq request
    ) throws Exception {
        System.out.println(request.getSchedule_date());
        service.save(request);
    }

    @DeleteMapping("api/{id}")
    public void delete (
            @PathVariable Long id
    ) throws Exception {
        service.remove(id);
    }


}

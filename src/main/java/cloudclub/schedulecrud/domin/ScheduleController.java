package cloudclub.schedulecrud.domin;

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
    ) throws IOException {
        return service.findMonth(month);
    }

    @PostMapping("api/")
    public void save (@RequestBody ScheduleReq request) {
        service.save(request);
    }



}

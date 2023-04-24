package cloudclub.schedulecrud.domin;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue
    @Column(name = "post_id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @Column(name = "schedule_date", nullable = false)
    private LocalDate schedule_date;

    @Column(name = "remind_date", nullable = false)
    private int remind_date;

    @Column(name = "is_active", nullable = false) // columnDefinition = "tinyint(1) default 1"
    private Boolean isActive = true;

    @Builder
    public Schedule(String title, String content, LocalDate schedule_date, int remind_date) {
        this.title = title;
        this.content = content;
        this.schedule_date = schedule_date;
        this.remind_date = remind_date;
        this.isActive = true;
    }

    public void delete() {
        this.isActive = false;
    }

}


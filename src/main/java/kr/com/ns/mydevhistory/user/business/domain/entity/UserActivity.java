package kr.com.ns.mydevhistory.user.business.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Table
@NoArgsConstructor
@Entity(name = "user_activity")
public class UserActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ColumnDefault("0")
    @Column(name = "order_index", nullable = false)
    private short orderIndex;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "description")
    private String description;

}

package kr.com.ns.mydevhistory.project.business.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Entity
@Table(name = "project_performance")
@NoArgsConstructor
public class ProjectPerformance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "content", columnDefinition = "text")
    private String content;

    @ColumnDefault("0")
    @Column(name = "order_index", nullable = false)
    private short orderIndex;
}

package kr.com.ns.mydevhistory.project.business.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "`project`")
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "thumbnail_url", columnDefinition = "text")
    private String thumbnailUrl;

    @ColumnDefault("0")
    @Column(name = "personnel", nullable = false)
    private short personnel;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "project_project_type",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "project_type_id")
    )
    private Set<ProjectType> projectTypes = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "project_tech",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tech_id")
    )
    private Set<Tech> techs = new HashSet<>();

    @OneToMany(mappedBy = "projectId", fetch = FetchType.LAZY)
    private Set<ProjectImage> projectImages = new HashSet<>();

    @OneToMany(mappedBy = "projectId", fetch = FetchType.LAZY)
    private Set<ProjectTaskHistory> projectTaskHistories = new HashSet<>();

    @OneToMany(mappedBy = "projectId", fetch = FetchType.LAZY)
    private Set<ProjectPerformance> projectPerformances = new HashSet<>();
}

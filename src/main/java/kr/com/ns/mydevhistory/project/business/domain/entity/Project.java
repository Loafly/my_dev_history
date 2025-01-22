package kr.com.ns.mydevhistory.project.business.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name = "`project`")
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

//    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
//    private List<ProjectProjectType> projectProjectTypes = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "project_project_type",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "project_type_id")
    )
    private Set<ProjectType> projectTypes = new HashSet<>();


//    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
//    private Set<ProjectTech> projectTechs = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "project_tech",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tech_id")
    )
    private Set<Tech> techs = new HashSet<>();


}

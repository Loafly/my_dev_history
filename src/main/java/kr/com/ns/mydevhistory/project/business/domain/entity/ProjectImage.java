package kr.com.ns.mydevhistory.project.business.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Entity
@Table(name = "project_image")
@NoArgsConstructor
public class ProjectImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "image_url", columnDefinition = "text")
    private String imageUrl;

    @ColumnDefault("false")
    @Column(name = "is_thumbnail", nullable = false)
    private boolean isThumbnail;
}

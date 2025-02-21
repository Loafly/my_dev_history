package kr.com.ns.mydevhistory.unit.project.business.domain.service;

import kr.com.ns.mydevhistory.common.exception.ApiException;
import kr.com.ns.mydevhistory.common.exception.ErrorCode;
import kr.com.ns.mydevhistory.project.business.domain.entity.Project;
import kr.com.ns.mydevhistory.project.business.domain.repository.ProjectRepository;
import kr.com.ns.mydevhistory.project.business.domain.service.ProjectService;
import kr.com.ns.mydevhistory.project.presentation.dto.ProjectDto;
import kr.com.ns.mydevhistory.user.business.domain.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @Nested
    @DisplayName("프로젝트 리스트 조회")
    public class searchTest {
        @Test
        void 프로젝트리스트조회_성공() {

            // given
            Long userId = 1L;
            Long projectId = 1L;
            Long projectId2 = 2L;
            Project project = new Project();
            Project project2 = new Project();
            ReflectionTestUtils.setField(project, "id", projectId);
            ReflectionTestUtils.setField(project2, "id", projectId2);

            List<Project> projects = List.of(project, project2);
            ProjectDto.SearchRequest searchRequest = new ProjectDto.SearchRequest(
                    userId,
                    null,
                    null
            );
            Pageable pageable = PageRequest.of(0, 20);

            // when
            when(projectRepository.search(searchRequest, pageable))
                    .thenReturn(new PageImpl<>(projects, pageable, projects.size()));

            Page<Project> search = projectService.search(searchRequest, pageable);

            // then
            then(projectRepository).should().search(searchRequest, pageable);
            assertEquals(projects.size(), search.getTotalElements());
        }
    }



    @Nested
    @DisplayName("프로젝트 조회")
    public class getByIdTest {
        @Test
        void 프로젝트조회_성공() {

            // given
            Long projectId = 1L;
            Project project = new Project();
            ReflectionTestUtils.setField(project, "id", projectId);

            // when
            when(projectRepository.findFetchById(projectId)).thenReturn(Optional.of(project));
            Project resultProject = projectService.getById(projectId);

            // then
            then(projectRepository).should().findFetchById(projectId);

            assertEquals(projectId, resultProject.getId());
        }

        @Test
        void 프로젝트조회_실패_프로젝트가없는경우() {
            // given
            Long projectId = 1L;
            Project project = new Project();
            ReflectionTestUtils.setField(project, "id", projectId);

            when(projectRepository.findFetchById(projectId)).thenReturn(Optional.empty());

            // when
            ApiException apiException = assertThrows(ApiException.class, () -> projectService.getById(projectId));

            // then
            then(projectRepository).should().findFetchById(projectId);
            assertEquals(ErrorCode.PROJECT_NOT_FOUND, apiException.getErrorCode());
        }
    }
}
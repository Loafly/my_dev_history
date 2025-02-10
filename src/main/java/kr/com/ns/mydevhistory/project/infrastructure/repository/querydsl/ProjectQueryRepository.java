package kr.com.ns.mydevhistory.project.infrastructure.repository.querydsl;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.com.ns.mydevhistory.project.business.domain.entity.Project;
import kr.com.ns.mydevhistory.project.presentation.dto.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static kr.com.ns.mydevhistory.project.business.domain.entity.QProject.project;
import static kr.com.ns.mydevhistory.project.business.domain.entity.QProjectType.projectType;
import static kr.com.ns.mydevhistory.project.business.domain.entity.QTech.tech;

@Repository
@RequiredArgsConstructor
public class ProjectQueryRepository {

     private final JPAQueryFactory queryFactory;

    // 조회
    public Page<Project> search(ProjectDto.SearchRequest request, Pageable pageable) {

        List<Long> projectIds = queryFactory
                .select(project.id)
                .from(project)
                .where(
                        eqIfExistUserId(request.userId()),
                        eqIfExistTechName(request.techName()),
                        eqIfExistProjectTypeName(request.projectTypeName())
                )
                .orderBy(getSortOrders(pageable))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        if (projectIds.isEmpty()) {
            return new PageImpl<>(List.of(), pageable, 0);
        }

        List<Project> projects = queryFactory
                .selectFrom(project)
                .leftJoin(project.projectTypes, projectType).fetchJoin()
                .leftJoin(project.techs, tech).fetchJoin()
                .where(project.id.in(projectIds))
                .orderBy(getSortOrders(pageable))
                .distinct()
                .fetch();

        long totalCount = Optional.ofNullable(
                        queryFactory
                                .select(Wildcard.count)
                                .from(project)
                                .where(
                                        eqIfExistUserId(request.userId()),
                                        eqIfExistTechName(request.techName()),
                                        eqIfExistProjectTypeName(request.projectTypeName())
                                )
                                .fetchOne())
                .orElse(0L);

        return new PageImpl<>(projects, pageable, totalCount);
    }

    public BooleanExpression eqIfExistUserId(Long userId){
        if(Objects.isNull(userId)) {
            return null;
        }

        return project.userId.eq(userId);
    }

    public BooleanExpression eqIfExistTechName(String techName){
        if(Objects.isNull(techName)) {
            return null;
        }

        return project.techs.any().name.eq(techName);
    }

    public BooleanExpression eqIfExistProjectTypeName(String projectTypeName){
        if(Objects.isNull(projectTypeName)) {
            return null;
        }

        return project.projectTypes.any().name.eq(projectTypeName);
    }


    private OrderSpecifier<?>[] getSortOrders(Pageable pageable) {
        if (!pageable.getSort().isSorted()) {
            return new OrderSpecifier[]{project.startDate.desc()}; // 기본 정렬 조건
        }

        // 여러 정렬 조건 처리
        List<OrderSpecifier<?>> orders = new ArrayList<>();
        for (Sort.Order order : pageable.getSort()) {
            String property = order.getProperty();
            boolean isAscending = order.isAscending();

            OrderSpecifier<?> orderSpecifier = switch (property) {
                case "startDate" -> isAscending ? project.startDate.asc() : project.startDate.desc();
                case "endDate" -> isAscending ? project.endDate.asc() : project.endDate.desc();
                case "id" -> isAscending ? project.id.asc() : project.id.desc();
                default -> project.startDate.desc(); // 기본 정렬 조건
            };
            orders.add(orderSpecifier);
        }

        return orders.toArray(new OrderSpecifier[0]); // 배열로 변환하여 반환
    }
}

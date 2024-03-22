package com.resul.ecommerce.specification;

import com.resul.ecommerce.repository.entity.StoreEntity;
import com.resul.ecommerce.repository.entity.StoreEntity_;
import com.resul.ecommerce.vo.FindStoresVo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class StoreSearchSpecification implements Specification<StoreEntity>{
    private final FindStoresVo findStoresVo;

    @Override
    public Predicate toPredicate(Root<StoreEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return Specification.where(nameLike())
                .and(isNotDeleted())
                .toPredicate(root, query, criteriaBuilder);
    }

    public Specification<StoreEntity> nameLike() {
        var namePhrase = findStoresVo.getNamePhrase();
        if (namePhrase == null) {
            return null;
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(StoreEntity_.name), '%' + namePhrase + '%', '\\');
    }

    public Specification<StoreEntity> isNotDeleted() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(StoreEntity_.isDeleted), false);
    }
}

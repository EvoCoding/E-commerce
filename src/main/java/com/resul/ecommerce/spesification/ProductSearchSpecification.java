package com.resul.ecommerce.spesification;

import com.resul.ecommerce.repository.entity.ProductEntity;
import com.resul.ecommerce.entity.ProductEntity_;
import com.resul.ecommerce.vo.FindProductsVo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class ProductSearchSpecification implements Specification<ProductEntity> {
    private final FindProductsVo findProductsVo;
    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
     return Specification.where(nameLike())
             .and(descriptionLike())
             .and(price())
             .and(quantity())
             .and(isNotDeleted())
             .toPredicate(root, query, criteriaBuilder);
    }

    public Specification<ProductEntity> nameLike() {
        var namePhrase = findProductsVo.getNamePhrase();
        if (namePhrase == null) {
            return null;
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(ProductEntity_.name), '%' + namePhrase + '%', '\\');

    }
    public Specification<ProductEntity> descriptionLike(){
        var descriptionPhrase = findProductsVo.getDescriptionPhrase();
        if(descriptionPhrase == null){
            return null;
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(ProductEntity_.description), '%' + descriptionPhrase + '%' , '\\');
    }
    public Specification<ProductEntity> price(){
        var price= findProductsVo.getPrice();
        if(price == null){
            return null;
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(ProductEntity_.price), price);
    }
    public Specification<ProductEntity> quantity(){
        var quantity =findProductsVo.getQuantity();
        if(quantity ==null){
            return null;
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(ProductEntity_.quantity), quantity);

    }
    public Specification<ProductEntity> isNotDeleted(){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(ProductEntity_.isDeleted), false);
    }
}

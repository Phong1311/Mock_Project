package com.vti.specification;

import com.vti.dto.filter.GroupFilter;
import com.vti.entity.Catalog;
import com.vti.entity.Group;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class CatalogSpecificationBuilder {
    private String search;

    public CatalogSpecificationBuilder(String search) {
        this.search = search;
    }

    @SuppressWarnings("deprecation")
    public Specification<Group> build() {

        SearchCriteria seachCriteria = new SearchCriteria("name", "Like", search);

        Specification<Catalog> where = null;

        // search
        if (!StringUtils.isEmpty(search)) {
            where = new CatalogSpecification(seachCriteria);
        }


        return where;
    }
}

package com.vti.dto.creating;

import com.vti.entity.Catalog;
import com.vti.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogFormForCreating {

	private String name;

	public Catalog toEntity() {
		return new Catalog(name);
	}

}

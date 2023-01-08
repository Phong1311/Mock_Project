package com.vti.form.creating;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OderDetailFormForCreating {

    private int oderListId;

    private String productName;

    private int price;

    private int quantity;

    private int total;


}

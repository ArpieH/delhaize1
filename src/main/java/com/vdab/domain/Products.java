package com.vdab.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder

public class Products extends BaseEntity {
    private String productName;
    private Category category;
    private  String description;
    private double price;

}

package com.vdab.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder

public class Category extends BaseEntity {
    private String categoryName;
}

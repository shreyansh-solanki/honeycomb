package com.honeycomb.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ProductCategoryDTO {

    private String id;

    private String name;

    private String description;

    private Integer code;

    private Map<String, String> attributes;

    private Instant dateCreated;
}

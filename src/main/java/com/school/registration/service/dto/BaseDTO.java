package com.school.registration.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public abstract class BaseDTO {
    @ApiModelProperty(hidden = true)
    private Long id;

    public BaseDTO(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        BaseDTO c = (BaseDTO) obj;
        return id == c.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

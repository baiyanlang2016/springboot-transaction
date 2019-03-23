package com.example.transaction.transaction.domain;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Description TODO
 * @Author fm
 * @Date 2019-03-22 14:18
 * @Version 1.0
 */
@ApiModel("person")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Integer id;

    @NotNull
    private String name;

    private Integer age;

    private Date createDt;

    private Date updateDt;
}

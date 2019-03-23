package com.example.transaction.transaction.controller;

import com.example.transaction.transaction.domain.Person;
import com.example.transaction.transaction.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @Description TODO
 * @Author fm
 * @Date 2019-03-22 14:50
 * @Version 1.0
 */
@Api("PersonController")
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/name/update/{id}/{name}")
    @ApiOperation(value = "更新name",notes = "根据用户id更新用户name")
    public Integer updateName(@NotNull @PathVariable("id") int id, @NotNull@PathVariable("name") String name) {
        return personService.updateName(id, name);
    }

    @GetMapping("/age/update/{id}/{age}")
    @ApiOperation(value = "更新age",notes = "根据用户id更新用户age")
    public Integer updateAge(@NotNull @PathVariable("id") int id, @NotNull@PathVariable("age") int age) {
        return personService.updateAge(id, age);
    }

    @PostMapping("/insert/{age}/{name}")
    @ApiOperation(value = "新增", notes = "新增用户信息")
    public Integer insert(@NotNull @PathVariable("age") int age, @NotNull@PathVariable("name") String name) {
        return personService.insert(new Person().builder().age(age).name(name).build());
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "查询", notes = "根据id获取用户信息")
    public Person getById(@NotNull @PathVariable("id") int id) {
        return personService.getPerson(id);
    }
}

package com.example.transaction.transaction.mapper;

import com.example.transaction.transaction.domain.Person;
import org.apache.ibatis.annotations.Param;

public interface PersonMapper {

    int updateNameByPrimaryKey(@Param("id") Integer id, @Param("name") String name);

    int updateAgeByPrimaryKey(@Param("id") Integer id, @Param("age") Integer age);

    int insert(Person person);

    Person selectByPrimaryKey(int id);


}

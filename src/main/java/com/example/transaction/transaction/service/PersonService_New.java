package com.example.transaction.transaction.service;

import com.example.transaction.transaction.domain.Person;
import com.example.transaction.transaction.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @Author fm
 * @Date 2019-03-22 19:52
 * @Version 1.0
 */
@Service
public class PersonService_New {

    @Autowired
    private PersonMapper personMapper;

    /**
     *  此处定义的事务传播级别是PROPAGATION_REQUIRES_NEW，表示另起一个事务，与上层调用事务无关
     * @param person
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int insert(Person person) {
        person.setAge(person.getAge() + 1);
        return personMapper.insert(person);
    }
}

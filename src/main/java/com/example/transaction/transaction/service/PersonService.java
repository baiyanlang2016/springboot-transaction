package com.example.transaction.transaction.service;

import com.example.transaction.transaction.domain.Person;
import com.example.transaction.transaction.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author fm
 * @Date 2019-03-22 14:39
 * @Version 1.0
 */
@Service
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonService_New personService_new;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int updateName(int id, String name) {
        int result = personMapper.updateNameByPrimaryKey(id, name);
        System.out.println("-------result：" +result); // 此处会返回真实的执行结果，但此结果可能不是该方法的最终结果，如果后面有异常抛出则会回滚该结果
        try {
            TimeUnit.SECONDS.sleep(10);
//            throw new RuntimeException(); // 在此处添加异常不会导致回滚，因为被catch了
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException();  // 此处抛出的异常会导致回滚
    }

    /**
     *  读未提交，可以读取上面update未提交的数据
     * @param id
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Person getPerson(int id) {
        return personMapper.selectByPrimaryKey(id);
    }

    public int updateAge(int id, int age) {
        return personMapper.updateAgeByPrimaryKey(id, age);
    }

    /**
     * 下面两个方法可能不会同时回滚，如果personService_new中的方法的事务传播级别被改变，则可能不回滚
     * @param person
     * @return
     */
    @Transactional
    public int insert(Person person) {
        personMapper.insert(person);
        personService_new.insert(person);
        throw new RuntimeException();
    }

}

package cn.hrs.allybei.JavaStudy.SpringBoot.mybatisTest.mapper;

import cn.hrs.allybei.JavaStudy.SpringBoot.mybatisTest.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select(value = "select * from user where id=#{id}")
    User getUser(Long id);

    @Select(value = "select * from user")
    List<User> getUsers();
}

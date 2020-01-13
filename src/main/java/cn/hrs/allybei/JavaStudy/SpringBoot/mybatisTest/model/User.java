package cn.hrs.allybei.JavaStudy.SpringBoot.mybatisTest.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String userName;
    private String password;
    private String address;
}

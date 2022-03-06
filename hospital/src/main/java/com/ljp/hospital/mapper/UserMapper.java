package com.ljp.hospital.mapper;

import com.ljp.hospital.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 判断是否存在用户
     * @param username
     * @return 存在的条数
     */
    int isExistUser(String username);

    /**
     * 根据username查询用户信息
     * @param username
     * @return
     */
    User getUserInfo(String username);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int save (User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int update (User user);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById (int id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> selectAll ();
}
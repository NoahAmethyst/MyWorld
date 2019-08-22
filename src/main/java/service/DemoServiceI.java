package service;

import model.Stu;
import model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemoServiceI {
    List<Stu> getAll();

    int addStu(@Param("name") String name);

    List<User> getById(int id);

}

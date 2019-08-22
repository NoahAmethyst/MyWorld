package mapper;

import model.Stu;
import model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DemoMapper {
    List<Stu> getAll();

    int add(@Param("name") String name);

    List<User> getById(int id);
}

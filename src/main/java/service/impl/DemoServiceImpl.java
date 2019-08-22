package service.impl;

import mapper.DemoMapper;
import model.Stu;
import model.User;
import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import service.DemoServiceI;

import java.util.ArrayList;
import java.util.List;

@Service("demoService")
public class DemoServiceImpl implements DemoServiceI {
    @Autowired
    private DemoMapper demoMapper;


    @Override
    public List<Stu> getAll() {
        List<Stu> list=new ArrayList<>();
        list=demoMapper.getAll();
        return list;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int addStu(@Param("name") String name) {
        demoMapper.add("测试");
        int a=1/0;
        return demoMapper.add(name);
    }


    @Override
    public List<User> getById(int id) {
        List<User> list=new ArrayList<>();
        list=demoMapper.getById(2);
        return list;
    }
}

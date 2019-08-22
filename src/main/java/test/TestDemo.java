package test;
import mapper.DemoMapper;
import model.Stu;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import service.DemoServiceI;
import service.impl.DemoServiceImpl;
import util.MyBatisUtils;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class TestDemo {

   @Test
    public void testI(){
       int[] array={5,4,3,2,1};
       for(int i=0;i<array.length-1;i++){
           for(int j=i;j<array.length-1;j++){
               if(array[i]>array[j]){
                   int temp=array[i];
                   array[i]=array[j];
                   array[j]=temp;
               }
           }
       }
       for (int a:array) {
           System.out.print(a+" ");
       }

       }


    //测试mybatis框架
    @Test
    public void testMybatis(){
//        SqlSession session= MyBatisUtils.getSession();
//        DemoMapper dm=session.getMapper(DemoMapper.class);
//        List<Stu> list=dm.getAll();
//        System.out.println(list);
        try {
            Reader reader=Resources.getResourceAsReader("mybatis-config.xml");
            SqlSession session= new SqlSessionFactoryBuilder().build(reader).openSession();
            DemoMapper dm=session.getMapper(DemoMapper.class);
            List<Stu> list=dm.getAll();
            System.out.println(list);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
        public void addTest(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext-service.xml");
       DemoServiceI demoServiceI= (DemoServiceI) ac.getBean("demoService");
        demoServiceI.addStu("没有回滚");

    }
}

package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtils {

    //本地线程，保证SqlSession是线程独享的
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    private static SqlSessionFactory sf;

    static{
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //SqlSessionFactory工厂只创建化一次,SqlSessionFactoryBuilder也只初始一次
            sf = new SqlSessionFactoryBuilder().build(is);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取 Session()
     * @return
     */
    public static SqlSession getSession(){
        //从本地线程获取
        SqlSession session = threadLocal.get();
        //线程中为null
        if(session==null){
            //从工厂获取，并放置到本地线程中
            session=sf.openSession();
            threadLocal.set(session);
        }
        return session;
    }

    public static void closeSession(){
        SqlSession session = threadLocal.get();
        session.close();
        threadLocal.remove();
    }
}

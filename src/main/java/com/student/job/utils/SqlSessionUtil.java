package com.student.job.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Mybatis工具类
 * @author paddi
 * @version 1.0
 * @since 1.0
 */
public class SqlSessionUtil {
    //工具类的构造方法一般都是私有化的
    //工具类中的所有方法都是静态的，直接采用类名即可调用。不需要new对象
    //为了防止new对象，构造方法私有化
    private SqlSessionUtil(){}

    private static SqlSessionFactory sqlSessionFactory;
    //类加载时执行
    //SqlSessionUtil工具类在进行第一次加载的时候，解析mybatis-config.xml文件。创建SqlSessionFactory对象
    static {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*    static {
        String configFile = "mybatis-config.xml"; // 更改变量名
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(configFile);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            // 具体化异常处理，给出失败提示
            //System.err.println("配置文件加载失败：" + e.getMessage());
            System.out.println(e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // 具体化异常处理，给出失败提示
                    //System.err.println("关闭输入流失败：" + e.getMessage());
                    System.out.println(e);
                }
            }
        }
    }*/

    // 全局的，服务器级别的，一个服务器当中定义一个即可。
    // 为什么把SqlSession对象放到ThreadLocal当中呢？为了保证一个线程对应一个SqlSession。
    private static ThreadLocal<SqlSession> local = new ThreadLocal();
    /**
     * 获取工厂对象
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
    /**
     * 获取会话对象
     * @return 会话对象
     */
    public static SqlSession openSession(){
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            //将sqlSession对象绑定到当前线程上
            local.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭sqlSession对象（从当前线程中移除sqlSession对象）
     * @param sqlSession
     */
    public static void close(SqlSession sqlSession){
        if (sqlSession != null) {
            sqlSession.close();
            // 注意移除SqlSession对象和当前线程的绑定关系。
            // 因为Tomcat服务器支持线程池。也就是说：用过的线程对象t1，可能下一次还会使用这个t1线程。
            local.remove();
        }

    }
}



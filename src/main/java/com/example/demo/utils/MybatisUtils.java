package com.example.demo.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//仅在非整合springmvc时使用
public class MybatisUtils {
    
    public static final SqlSessionFactory SSF=MybatisUtils.getSSF();
    private static final ThreadLocal<SqlSession> THREAD_LOCAL=new ThreadLocal<>();

    /**
     * ��ûỰ����
     * @return
     */
    private  static SqlSessionFactory getSSF() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            return builder.build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * ��ûỰ
     * @return
     */
    public static SqlSession getSession(){
        if(THREAD_LOCAL.get()==null){
            SqlSession session = SSF.openSession();
            THREAD_LOCAL.set(session);
        }
        
        return THREAD_LOCAL.get();
    }
    
    /**
     * �رջỰ
     */
    public static void close(){
        if(THREAD_LOCAL.get()!=null){
            SqlSession session = THREAD_LOCAL.get();
            session.close();
            THREAD_LOCAL.remove();
        }
    }
    
    public static void main(String[] args) {
        System.out.println(MybatisUtils.getSession());
    }
}

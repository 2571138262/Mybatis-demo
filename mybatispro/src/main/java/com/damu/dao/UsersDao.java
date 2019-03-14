package com.damu.dao;

import com.damu.entity.Users;
import com.damu.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UsersDao {
    // 获取Sql会话类对象
    private SqlSession sqlSession;
    private List<Users> list;
    private Users user;

    private SqlSession getSqlSession(){
        sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        return sqlSession;
    }

    /**
     * 查询所有对象
     * @return
     */
    public List<Users> findAll(){
        try {

            // 执行自己定义的SQL语句
            list = getSqlSession().selectList("findUsers");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            sqlSession.close();
        }
        return list;
    }

    /**
     * 查询单个用户根据编号
     * @return
     */
    public Users findById(Integer id){
        // 执行我们自定义的SQL语句
        try {
            // 这里参数为什么是new Users(id)
            // 因为在映射配置文件中命名空间对象的实体类是Users，动态SQL语句中的 #{id} 参数id是从Users对象中找的，
            // 所以需要通过id来实例化一个User的对象，这样才能找到对应的id值
            user = getSqlSession().selectOne("findUsers", new Users(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return user;
    }

    /**
     * 增加一个新用户数据到数据库的方法
     * @param user
     * @return
     */
    public Users addUser(Users user){
        try{
            // 执行自定义的SQL语句，将User作为参数传入进去
            // 返回值：是insert执行过程中影响的行数
            getSqlSession().insert("addUser", user);

            // 将做的数据更新提交一下    提交完成才能在数据库中查看到对应的数据
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return user;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public Users updateUsers(Users user){
        try{
            // 执行自定义的SQL语句，将User作为参数传入进去
            // 返回值：是insert执行过程中影响的行数
            getSqlSession().update("updateUser", user);

            // 将做的数据更新提交一下    提交完成才能在数据库中查看到对应的数据
            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return user;
    }

    public void delUsers(Integer id){
        try {
            // 返回值：是delete执行过程中影响的行数
            getSqlSession().delete("delUser", id);

            // 将做的数据更新提交一下    提交完成才能在数据库中查看到对应的数据
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }

}

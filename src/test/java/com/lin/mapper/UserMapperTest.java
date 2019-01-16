package com.lin.mapper;

import com.lin.BaseMapperTest;
import com.lin.model.SysRole;
import com.lin.model.SysRoleExtend;
import com.lin.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 用户数据库测试
 */
public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 查询id为1的用户
            SysUser user = userMapper.selectById(1L);
            // 用户必须非空
            assertNotNull(user);
            // 用户名必须等于admin
            assertEquals("admin", user.getUserName());
        }
    }

    @Test
    public void testSelectAll() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 查询所有用户
            List<SysUser> userList = userMapper.selectAll();
            // 用户列表必须非空
            assertNotNull(userList);
            // 用户数量大于0
            assertTrue(userList.size() > 0);
        }
    }

    @Test
    public void testSelectRolesByUserId() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 根据用户id获取角色信息
            List<SysRole> userList = userMapper.selectRolesByUserId(1L);
            // 用户列表必须非空
            assertNotNull(userList);
            // 用户数量大于0
            assertTrue(userList.size() > 0);
        }
    }

    @Test
    public void testSelectRolesAndUserNameByUserId() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 根据用户id获取角色信息，并带有当前用户名
            List<SysRoleExtend> userList = userMapper.selectRolesAndUserNameByUserId(1L);
            // 用户列表必须非空
            assertNotNull(userList);
            // 用户数量大于0
            assertTrue(userList.size() > 0);
        }
    }

    @Test
    public void testSelectRolesAndUserNameByUserId2() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 根据用户id获取角色信息，并带有当前用户名
            List<SysRole> userList = userMapper.selectRolesAndUserNameByUserId2(1L);
            // 用户列表必须非空
            assertNotNull(userList);
            // 用户数量大于0
            assertTrue(userList.size() > 0);
        }
    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = getSqlSession();

        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 创建一个用户对象
            SysUser user = new SysUser();
            user.setUserName("tests1");
            user.setUserPassword("123456");
            user.setUserEmail("test1@163.com");
            user.setUserInfo("test info");

            // 正常情况下应该读入一张图片存到byte数组中
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());

            // 插入用户，获取受影响行数
            int effectCount = userMapper.insert(user);
            // 受影响行数必须为1
            assertEquals(1, effectCount);
            // 用户id未赋值，为空
            assertNull(user.getId());
        } finally {
            // 为了不影响其他测试，此处选择回滚
            // 默认openSession()是不自动提交的，不回滚也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2() {
        SqlSession sqlSession = getSqlSession();

        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 创建一个用户对象
            SysUser user = new SysUser();
            user.setUserName("tests1");
            user.setUserPassword("123456");
//            user.setUserEmail("test1@163.com");
            user.setUserInfo("test info");

            // 正常情况下应该读入一张图片存到byte数组中
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());

            // 插入用户，获取受影响行数
            int effectCount = userMapper.insert2(user);
            // 受影响行数必须为1
            assertEquals(1, effectCount);
            // 因为用户id从数据库获取id后回写，此值不为空
            assertNotNull(user.getId());
        } finally {
            // 为了不影响其他测试，此处选择回滚
            // 默认openSession()是不自动提交的，不回滚也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert3() {
        SqlSession sqlSession = getSqlSession();

        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 创建一个用户对象
            SysUser user = new SysUser();
            user.setUserName("tests1");
            user.setUserPassword("123456");
            user.setUserEmail("test1@163.com");
            user.setUserInfo("test info");

            // 正常情况下应该读入一张图片存到byte数组中
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());

            // 插入用户，获取受影响行数
            int effectCount = userMapper.insert3(user);
            // 受影响行数必须为1
            assertEquals(1, effectCount);
            // 因为用户id从数据库获取id后回写，此值不为空
            assertNotNull(user.getId());
        } finally {
            // 为了不影响其他测试，此处选择回滚
            // 默认openSession()是不自动提交的，不回滚也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = getSqlSession();

        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 从数据库查询一个用户
            SysUser user = userMapper.selectById(1L);
            // 当前用户名为admin
            assertEquals("admin", user.getUserName());

            user.setUserName("admin_test");
            user.setUserEmail("test@163.com");

            // 更新数据，获取受影响行数
            int effectCount = userMapper.updateById(user);
            // 受响应行数必须是1
            assertEquals(1, effectCount);

            // 根据当前id查询修改后的数据
            user = userMapper.selectById(1L);
            // 修改后的名字是admin_test
            assertEquals("admin_test", user.getUserName());
        } finally {
            // 为了不影响其他测试，此处选择回滚
            // 默认openSession()是不自动提交的，不回滚也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = getSqlSession();

        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 从数据库查询一个用户
            SysUser user1 = userMapper.selectById(1L);
            // 此时用户非空
            assertNotNull(user1);

            // 调用方法删除
            assertEquals(1, userMapper.deleteById(1L));
            // 再次查询，此时应该为null
            assertNull(userMapper.selectById(1L));

            // 从数据库查询一个用户
            SysUser user2 = userMapper.selectById(1001L);
            // 此时用户非空
            assertNotNull(user2);

            // 调用方法删除
            assertEquals(1, userMapper.deleteById(user2));
            // 再次查询，此时应该为null
            assertNull(userMapper.selectById(1L));
        } finally {
            // 为了不影响其他测试，此处选择回滚
            // 默认openSession()是不自动提交的，不回滚也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserIdAndRoleEnabled() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 根据用户id和角色的enabled状态获取用户的角色
            List<SysRole> userList = userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
            // 用户列表必须非空
            assertNotNull(userList);
            // 用户数量大于0
            assertTrue(userList.size() > 0);
        }
    }

    @Test
    public void testSelectRolesByUserAndRole() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 设置用户id
            SysUser user = new SysUser();
            user.setId(1L);
            // 设置角色启用
            SysRole role = new SysRole();
            role.setEnabled(1);

            // 根据用户id和角色的enabled状态获取用户的角色
            List<SysRole> userList = userMapper.selectRolesByUserAndRole(user, role);
            // 用户列表必须非空
            assertNotNull(userList);
            // 用户数量大于0
            assertTrue(userList.size() > 0);
        }
    }

    @Test
    public void testSelectByUser() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 1.只查询用户名时
            SysUser query = new SysUser();
            query.setUserName("ad");
            List<SysUser> userList = userMapper.selectByUser(query);
            assertTrue(userList.size() > 0);

            // 2.只查询用户邮箱时
            query = new SysUser();
            query.setUserEmail("test@mybatis.tk");
            userList = userMapper.selectByUser(query);
            assertTrue(userList.size() > 0);


            // 3.同时查询用户名和邮箱时
            query = new SysUser();
            query.setUserName("ad");
            query.setUserEmail("test@mybatis.tk");
            userList = userMapper.selectByUser(query);

            // 由于没有同时符合这两个条件的用户，因此查询结果为0
            assertEquals(0, userList.size());
        }
    }

    @Test
    public void testUpdateByIdSelective() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 新建一个user对象
            SysUser user = new SysUser();
            // 设置id为1的用户信息
            user.setId(1L);
            user.setUserEmail("test@163.com");

            // 选择性更新用户信息，获取受影响行数
            int effectCount = userMapper.updateByIdSelective(user);
            // 受影响行数必须是1
            assertEquals(1, effectCount);

            // 查询修改后的数据
            user = userMapper.selectById(1L);

            // 修改后的用户名不变，邮箱改变
            assertEquals("admin", user.getUserName());
            assertEquals("test@163.com", user.getUserEmail());
        }
    }

    @Test
    public void testSelectByIdOrUserName() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 根据id进行查询，用户非空
            SysUser query = new SysUser();
            query.setId(1L);
            query.setUserName("admin");
            SysUser user = userMapper.selectByIdOrUserName(query);
            assertNotNull(user);

            // 没有id时，根据用户名进行查询，用户非空
            query.setId(null);
            user = userMapper.selectByIdOrUserName(query);
            assertNotNull(user);

            // id和用户名都没有时，查询不到用户信息
            query.setUserName(null);
            user = userMapper.selectByIdOrUserName(query);
            assertNull(user);
        }
    }

    @Test
    public void testSelectByIdList() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 创建id列表
            List<Long> idList = new ArrayList<>();
            idList.add(1L);
            idList.add(1001L);

            // 根据id列表获取用户列表
            List<SysUser> userList = userMapper.selectByIdList(idList);
            // 用户列表必须有两个人
            assertEquals(2, userList.size());
        }
    }

    @Test
    public void testInsertList() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 创建多个用户，存到列表中
            List<SysUser> userList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                SysUser user = new SysUser();
                user.setUserName("test" + i);
                user.setUserPassword("123456");
                user.setUserEmail("test@163.com");
                userList.add(user);
            }

            // 批量插入用户，获取受影响行数
            int effectCount = userMapper.insertList(userList);
            // 受影响行数必须为5条
            assertEquals(5, effectCount);

            // 打印回写到user上的id值
            for (SysUser user : userList) {
                System.out.println(user.getId());
            }
        }
    }

    @Test
    public void testUpdateByMap() {
        SqlSession sqlSession = getSqlSession();

        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // map中将设置查询条件id为1，以及要更新的值
            Map<String, Object> map = new HashMap<>();
            // 查询条件
            map.put("id", 1L);
            // 要更新的字段
            map.put("user_email", "test@163.com");
            map.put("user_password", "88888888");

            // 更新数据
            userMapper.updateByMap(map);

            // 根据id获取修改后的数据
            SysUser user = userMapper.selectById(1L);
            // 验证数据是否修改成功
            assertEquals("test@163.com", user.getUserEmail());
            assertEquals("88888888", user.getUserPassword());
        } finally {
            // 为了不影响其他测试，此处选择回滚
            // 默认openSession()是不自动提交的，不回滚也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testSelectUserAndRoleById() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 特别注意，id为1的用户有两个角色，不适合这个例子
            // 这里使用id为1001的用户
            SysUser user = userMapper.selectUserAndRoleById(1001L);
            // 用户非空
            assertNotNull(user);
            // 用户的role属性非空
            assertNotNull(user.getRole());
        }
    }

    @Test
    public void testSelectUserAndRoleById2() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 特别注意，id为1的用户有两个角色，不适合这个例子
            // 这里使用id为1001的用户
            SysUser user = userMapper.selectUserAndRoleById2(1001L);
            // 用户非空
            assertNotNull(user);
            // 用户的role属性非空
            assertNotNull(user.getRole());
        }
    }

    @Test
    public void testSelectUserAndRoleByIdSelect() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 特别注意，id为1的用户有两个角色，不适合这个例子
            // 这里使用id为1001的用户
            SysUser user = userMapper.selectUserAndRoleByIdSelect(1001L);
            // 用户非空
            assertNotNull(user);
            System.out.println("调用user.getRole()");
            // 用户的role属性非空
            assertNotNull(user.getRole());
        }
    }

    @Test
    public void testSelectAllUserAndRoles() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 获取所有的用户和角色信息
            List<SysUser> userList = userMapper.selectAllUserAndRoles();
            System.out.println("用户数：" + userList.size());

            for (SysUser user : userList) {
                System.out.println("用户名：" + user.getUserName());
                for (SysRole role : user.getRoleList()) {
                    System.out.println("角色名：" + role.getRoleName());
                }
            }
        }
    }

}

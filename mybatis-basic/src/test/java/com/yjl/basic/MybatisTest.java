package com.yjl.basic;

import com.yjl.basic.entity.Emp;
import com.yjl.basic.entity.Order;
import com.yjl.basic.mapper.EmployeeMapper;
import com.yjl.basic.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author yujiale
 * @Date 2022/8/21 11:53
 * @Description TODO
 **/
@Slf4j
class MybatisTest {

    private SqlSession session;

    // junit会在每一个@Test方法前执行@Before方法
    @BeforeEach
    void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    // junit会在每一个@Test方法后执行@After方法
    @AfterEach
    void clear() {
        session.commit();
        session.close();
    }

    @Test
    void testGetOrderWithCustomer() {
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Order order = orderMapper.selectOrderWithCustomer(1);
        log.info("Order with customer {} :", order.toString());
    }

    @Test
    void testSelectWithResultMap() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        List<Emp> empList = employeeMapper.selectWithResultMap();
        empList.forEach(e -> log.info("emp {} : ", String.valueOf(e)));
    }

    @Test
    void testGetGeneratedKey() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Emp emp = new Emp(null, "Jojo", 666.11);
        int rowCount = employeeMapper.insertWithKey(emp);
        log.info("rowCount {}: ", rowCount);
        Long empId = emp.getEmpId();
        log.info("emp_id {}: ", empId);
    }

    @Test
    void testSelectForList() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        List<Emp> empList = employeeMapper.selectAll();
        empList.forEach(e -> log.info("emp {} : ", String.valueOf(e)));
    }

    @Test
    void testSelectForMap() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Map<String, Object> mapResult = employeeMapper.selectForMap(1);
        Set<String> keySet = mapResult.keySet();
        keySet.forEach(key -> {
            Object value = mapResult.get(key);
            log.info("key {} ,value {} :", key, value);
        });
    }

    @Test
    void testSelectCount() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Integer count = employeeMapper.selectCount();
        log.info("count {} :", count);
    }

    @Test
    void testUpdateEmpByMap() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("emp_idKey", 1L);
        paramMap.put("emp_nameKey", "Justin");
        paramMap.put("emp_salaryKey", 7777.77);
        employeeMapper.updateByMap(paramMap);
    }

    @Test
    void testUpdateSalaryById() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Long emp_id = 1L;
        Double salary = 666.66;
        employeeMapper.updateSalaryById(emp_id, salary);
        log.info("emp_id {},salary {} :", emp_id, salary);
    }

    @Test
    void testDollar() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Emp emp = employeeMapper.selectEmpByName("o");
        log.info("emp {}:", emp);
    }

    @Test
    void testUpdate() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Emp empById = employeeMapper.selectEmpById(5L);
        if (null == empById) {
            return;
        }
        empById.setEmpName("harry");
        empById.setEmpSalary(999.99);
        employeeMapper.updateEmp(empById);
        log.info("empById {} :", empById);
    }

    @Test
    void testDelete() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        int rowCount = employeeMapper.deleteById(4);
        log.info("rowCount {}:", rowCount);
    }

    @Test
    void testInsert() {
        // 1.获取Mapper对象
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Emp emp = new Emp();
        emp.setEmpName("jerry");
        emp.setEmpSalary(1111.111);
        // 2.调用Mapper对象的方法
        int rowCount = employeeMapper.insertEmp(emp);
        // 3.打印受影响的行数
        log.info("rowCount {}:", rowCount);
    }

    @Test
    void testUsrMapperInterface() {
        // 1.根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        log.info("employeeMapper.getClass().getName()  {} : ", employeeMapper.getClass().getName());
        // 2.调用EmployeeMapper接口的方法完成对数据库的操作
        Emp emp = employeeMapper.selectEmpById(1L);
        // 3.打印查询结果
        log.info("emp {}:", emp);
    }
}

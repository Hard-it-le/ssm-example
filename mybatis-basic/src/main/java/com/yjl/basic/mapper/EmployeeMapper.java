package com.yjl.basic.mapper;

import com.yjl.basic.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 声明这个接口是为了方便上层代码调用Mybatis的具体功能
 * 接口的全类名要和Mapper配置文件的namespace属性一致，这样才能通过接口找到Mapper配置
 * 接口中的方法名要和Mapper配置文件中SQL语句标签的id属性一致，这样才能通过方法名找到具体SQL语句
 * 又因为在Mapper配置文件中id属性的值是不能重复的，所以当前接口中方名也不能重复——当前接口中的方法不能重载
 *
 * @author yujiale
 */
public interface EmployeeMapper {

    /**
     * 通过这个方法对应Mapper配置文件中的SQL语句
     *
     * @param emp_id 当前方法的参数对应SQL语句中#{emp_id}声明的参数
     * @return 当前方法的返回值类型和resultType属性指定的类型一致
     */
    Emp selectEmpById(Long emp_id);

    /**
     * 执行插入操作
     *
     * @param emp
     * @return 受影响的行数
     */
    int insertEmp(Emp emp);

    /**
     * 执行删除操作
     *
     * @param emp_id
     * @return 受影响的行数
     */
    int deleteById(long emp_id);

    /**
     * 执行更新操作
     *
     * @param harry Mybatis返回的受影响行数也可以不使用
     */
    Integer updateEmp(Emp harry);

    /**
     * 模糊查询，根据员工姓名片段查询对应数据
     *
     * @param emp_name
     * @return
     */
    Emp selectEmpByName(String emp_name);

    /**
     * 使用@Param注解给方法形参命名，具体用法参照Mapper配置文件
     *
     * @param emp_id
     * @param salary
     */
    void updateSalaryById(@Param("empId") Long emp_id, @Param("empSalary") Double salary);

    /**
     * @param paramMap
     * @return
     */
    Integer updateByMap(Map<String, Object> paramMap);

    /**
     * @return
     */
    Integer selectCount();

    /**
     * @param emp_id
     * @return
     */
    Map<String, Object> selectForMap(int emp_id);

    /**
     * @return
     */
    List<Emp> selectAll();

    /**
     * 执行插入数据操作，自增主键会放入实体类对象的id属性
     * // 方法返回值还是受影响行数
     *
     * @param emp
     * @return
     */
    int insertWithKey(Emp emp);

    /**
     * @return
     */
    List<Emp> selectWithResultMap();
}

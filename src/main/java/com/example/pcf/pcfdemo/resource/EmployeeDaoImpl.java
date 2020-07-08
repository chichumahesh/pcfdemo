package com.example.pcf.pcfdemo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }


    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Employee> result = new ArrayList<Employee>();
        for (Map<String, Object> row : rows) {
            Employee emp = new Employee();
            emp.setEmployeeId(Integer.parseInt((String) row.get("empId")));
            emp.setEmployeeName((String) row.get("empName"));
            emp.setEmployeeAddress((String)row.get("empAddress"));
            result.add(emp);
        }

        return result;
    }
}
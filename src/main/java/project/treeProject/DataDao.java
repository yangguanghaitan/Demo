package project.treeProject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther d
 * @Date 2022/7/7 10:40
 * @Describe 模拟数据
 **/
public class DataDao {

    public static List<Department> getDepartmentData(){
        List<Department> departmentList=new ArrayList<>();


        departmentList.add(new Department("100","若依科技","0"));
        departmentList.add(new Department("200","深圳总公司","100"));
        departmentList.add(new Department("300","长沙分公司","100"));

        departmentList.add(new Department("201","研发部门","200"));
        departmentList.add(new Department("202","市场部门","200"));
        departmentList.add(new Department("203","测试部门","200"));
        departmentList.add(new Department("204","财务部门","200"));
        departmentList.add(new Department("205","运维部门","200"));

        departmentList.add(new Department("301","市场部门","300"));
        departmentList.add(new Department("302","财务部门","300"));

        return departmentList;
    }
}

package project.treeProject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther d
 * @Date 2022/7/7 10:35
 * @Describe 部门
 **/
public class Department {
    private String deptId;
    private String name;
    private String parentId;

    private List<Department> children = new ArrayList<>();

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Department() {
    }

    public Department(String deptId, String name, String parentId) {
        this.deptId = deptId;
        this.name = name;
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId='" + deptId + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                ", children=" + children +
                '}';
    }
}

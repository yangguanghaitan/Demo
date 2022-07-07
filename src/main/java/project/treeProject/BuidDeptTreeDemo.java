package project.treeProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther d
 * @Date 2022/7/7 11:08
 * @Describe
 **/
public class BuidDeptTreeDemo {
    public static void main(String[] args) {

        BuidDeptTreeDemo demo=new BuidDeptTreeDemo();
        List<Department> departmentDataList = DataDao.getDepartmentData();
        List<Department> departmentListTree = demo.buildDeptTree(departmentDataList);
        System.out.println(Arrays.toString(departmentListTree.toArray()));

    }


    /**
     * 构建前端所需要树结构
     *
     * @param depts 部门列表
     * @return 树结构列表
     */
    public List<Department> buildDeptTree(List<Department> depts) {
        List<Department> deptList = new ArrayList<>();
        List<String> deptIdList = new ArrayList<>();
        for (Department dept : depts) {
            deptIdList.add(dept.getDeptId());
        }
        for (Department dept : depts) {
            // 如果是顶级节点，遍历该父节点所有子节点
            if (!deptIdList.contains(dept.getParentId())) {
                recursionFn(depts, dept);
                deptList.add(dept);
            }
        }
        if (deptList.isEmpty()) {
            deptList = depts;
        }
        return deptList;
    }

    /**
     * 递归列表
     * 结束条件为所遍历的节点无下一级节点
     *
     * @param list 查询获得的所有部门数据
     * @param dept 顶级节点
     */
    private void recursionFn(List<Department> list, Department dept) {
        // 得到子节点列表
        List<Department> childList = getChildList(list, dept);
        dept.setChildren(childList);
        for (Department tChild : childList) {
            // 如果子节点有下一级节点，得到下一级的节点列表
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 获得该节点的下一级子节点列表
     *
     * @param list 查询获得的所有部门数据
     * @param dept 顶级节点
     * @return 顶级节点的下一级子节点列表
     */
    private List<Department> getChildList(List<Department> list, Department dept) {
        List<Department> deptList = new ArrayList<>();
        for(Department d:list){
            // 遍历非顶级节点，并获得传入参数顶级节点的下一级子节点列表
            if (d.getParentId() != null && d.getParentId().equals(dept.getDeptId())) {
                deptList.add(d);
            }
        }
        return deptList;
    }

    /**
     * 判断是否有子节点
     *
     * @param list 节点列表
     * @param dept 部门节点
     * @return Boolean
     */
    private boolean hasChild(List<Department> list, Department dept) {
        return getChildList(list, dept).size() > 0;
    }
}

package project.treeProject2;

import project.treeProject.DataDao;

import java.util.List;

/**
 * @Auther d
 * @Date 2022/7/18 11:05
 * @Describe
 **/
public class BuidDeptTreeDemo2 {
    public static void main(String[] args) {
       BuidDeptTreeDemo2 demo2=new BuidDeptTreeDemo2();
        List<DepartmentVo> departmenTree = demo2.listByAccountId(null);
        System.out.println(departmenTree);

    }

    /**
     * 获取账号的资源树
     */
    public List<DepartmentVo> listByAccountId(Long accountId) {
        //return TreeUtils.generateTrees(BeanUtils.copyProperties(mapper.selectByAccountId(userId), ResourceListVO.class));
        //从数据库获取树形结构的数据
        List<DepartmentVo> departmentData2 = DataDao.getDepartmentData2();
        List<DepartmentVo> departmentTree = TreeUtils.generateTrees(departmentData2);
        return departmentTree;
    }
}

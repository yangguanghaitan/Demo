package project.treeProject2;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Auther d
 * @Date 2022/7/18 10:59
 * @Describe
 **/
public class DepartmentVo implements TreeNode<Long> {
    private Long id;

    private Long pid;

    private String name;

    private List<DepartmentVo> children=new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long id() {
        return this.id;
    }

    @Override
    public Long parentId() {
        return this.pid;
    }

    @Override
    public boolean root() {
        return Objects.equals(this.pid, 0L);
    }

//    @Override
//    public void setChildren(List<? extends TreeNode<Long>> children) {
//        this.children=children;
//    }


    public DepartmentVo(Long id, String name,Long pid) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    @Override
    public List<? extends TreeNode<Long>> getChildren() {
        return this.children;
    }

    @Override
    public void setChildren(List children) {
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    /*public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
*/
//    public void setChildren(List<ResourceListVO> children) {
//        this.children = children;
//    }


    @Override
    public String toString() {
        return "DepartmentVo{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}


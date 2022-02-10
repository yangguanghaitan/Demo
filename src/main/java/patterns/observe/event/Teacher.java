package patterns.observe.event;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther d
 * @Date 2022/2/10 19:58
 * @Describe 事件源，类似于被观察者
 **/
public class Teacher {

    private String name;
    private List<String> homeworks;
    //维护观察者的一个列表
    private Set<HomeworkEventListen> homeworkListenerList;

    public Teacher(String name) {
        this.name = name;
        this.homeworks = new ArrayList<String>();
        this.homeworkListenerList = new HashSet<HomeworkEventListen>();
    }
     //设置家庭作业
    public void setHomework(String homework) {
        System.out.printf("%s布置了作业%s \n", this.name, homework);
        homeworks.add(homework);

        //事件
        HomeworkEventObject event = new HomeworkEventObject(this);
        //通知观察者，布置作业了
        for (HomeworkEventListen listener : homeworkListenerList) {
            listener.update(event, homework);
        }

    }
    //往观察者列表添加观察者
    public void addObserver(HomeworkEventListen homeworkListener){
        homeworkListenerList.add(homeworkListener);
    }

    public  String getName(){
        return name;
    }
}

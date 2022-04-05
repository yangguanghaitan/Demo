package patterns.command.two;

import java.util.Arrays;

/**
 * @Auther d
 * @Date 2022/4/4 10:30
 * @Describe 遥控器
 **/
public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    Command undoComannd;

    //遥控器3个卡槽的出厂默认值
    public RemoteControl() {
        onCommands=new Command[4];
        offCommands=new Command[4];
        Command noCommand=new NoCommand();
        for (int i = 0; i < 4; i++) {
            onCommands[i]=noCommand;
            offCommands[i]=noCommand;
        }
        undoComannd=noCommand;
    }

    /**
     * @author d
     * @date 2022/4/4 10:35
     * @param slotIndex 插槽的位置
     * @param onCommand 开的命令
     * @param offCommand 关的命令
     * @Description
     **/
    public void setCommand(int slotIndex,Command onCommand,Command offCommand){
        onCommands[slotIndex]=onCommand;
        offCommands[slotIndex]=offCommand;
    }

    public void onButtonWasPressed(int slotIndex){
        onCommands[slotIndex].execute();
        undoComannd=onCommands[slotIndex];
    }

    public void offButtonWasPressed(int slotIndex){
        offCommands[slotIndex].execute();
        undoComannd=offCommands[slotIndex];
    }

    public void undoButtonWasPressed(){
        undoComannd.undo();
    }

    /**
     * @author d
     * @date 2022/4/4 10:47
     * @return java.lang.String
     * @Description 打印插槽位置和对应的开关命令
     **/
    @Override
    public String toString() {
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("\n-------遥控器remoteControl--------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuffer.append("slot index="+i+"  "+onCommands[i].getClass().getName()+"  "+offCommands[i].getClass()+"\n");
        }
        stringBuffer.append("undo"+undoComannd.getClass());
        return stringBuffer.toString();
    }
}

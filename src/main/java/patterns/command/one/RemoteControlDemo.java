package patterns.command.one;

import patterns.command.one.electrical.one.Light;
import patterns.command.one.electrical.one.LightOnCommand;
import patterns.command.one.electrical.two.GarageDoor;
import patterns.command.one.electrical.two.GarageDoorOnCommand;

/**
 * @Auther d
 * @Date 2022/4/4 9:52
 * @Describe 命令设计模式,创建一个命令 {@code lightOnCommand}，传递给遥控器的卡槽，由遥控器上的按钮去执行
 **/
public class RemoteControlDemo {
    public static void main(String[] args) {
        //电器之电灯
        Light light=new Light();
        LightOnCommand lightOnCommand=new LightOnCommand(light);
        //电器之电动车库门
        GarageDoor garageDoor=new GarageDoor();
        GarageDoorOnCommand garageDoorOnCommand=new GarageDoorOnCommand(garageDoor);

        //遥控器
        SimpleRemoteControl simpleRemoteControl=new SimpleRemoteControl();
        //插槽
        //插入电灯
        simpleRemoteControl.setSlot(lightOnCommand);
        simpleRemoteControl.buttonWasPressed();
        //插入电动门
        simpleRemoteControl.setSlot(garageDoorOnCommand);
        simpleRemoteControl.buttonWasPressed();
    }
}

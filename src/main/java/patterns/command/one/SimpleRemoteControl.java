package patterns.command.one;

/**
 * @Auther d
 * @Date 2022/4/4 9:54
 * @Describe {@link SimpleRemoteControl}相当于遥控器, {@link slot}遥控器上的插槽，控制着一个装置,
 **/
public class SimpleRemoteControl {

    Command slot;

    public SimpleRemoteControl() {
    }

    public void setSlot(Command slot) {
        this.slot = slot;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}

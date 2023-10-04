import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DotGroupController extends JButton {
    private DotGroup dotGroup;

    public DotGroupController (DotGroup dotGroup) {
        this.dotGroup = dotGroup;

//        this.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("button clicked");
//                this.changeVisibility();
//                DotGroupDemo.this.actionPerformed();
//            }
//        });
    }


}

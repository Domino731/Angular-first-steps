package inputs;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {
    public MouseInputs(){

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // BUTTON1 === left click
        if(e.getButton() == MouseEvent.BUTTON1){
//            gamePanel.getEngine().getPlayer().setIsAttacking(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Mouse dragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
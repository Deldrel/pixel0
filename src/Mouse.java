import java.awt.event.*;

public class Mouse extends MouseAdapter {
    public int x = 0, y = 0, px = 0, py = 0;
    public boolean pressed = false;

    public Mouse() {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        px = x;
        py = y;
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressed = true;
        //TODO : update selected cell
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pressed = false;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int value = -e.getWheelRotation();
        params.scale += value;
        if (params.scale < params.minScale) {
            params.scale = params.minScale;
            return;
        }
        else if (params.scale > params.maxScale) {
            params.scale = params.maxScale;
            return;
        }

        //TODO : update offsets accurately
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
        params.offsetX += x - px;
        params.offsetY += y - py;
    }

    public float map(float value, float start1, float stop1, float start2, float stop2) {
        return (value - start1) / (stop1 - start1) * (stop2 - start2) + start2;
    }
}

package kmitl.lab03.bawonsak58070074.simplemydot.model;


import java.util.ArrayList;
import java.util.List;

public class Dots {

    public interface OnDotsChangeListener {
        void onDotsChanged(Dots dots);
    }

    private OnDotsChangeListener listener;

    public void setListener(OnDotsChangeListener listener) {
        this.listener = listener;
    }

    private List<Dot> allDot = new ArrayList<>();

    public List<Dot> getAllDot() {
        return allDot;
    }

    public void addDot(Dot dot) {
        this.allDot.add(dot);
        this.listener.onDotsChanged(this);
    }

    public void removeBy(int position) {
        allDot.remove(position);
        this.listener.onDotsChanged(this);
    }

    public void clearAll() {
        allDot.clear();
        this.listener.onDotsChanged(this);
    }

    public int findDot(float x, float y) {
        for (int i = 0; i < allDot.size(); i++) {
            float centerX = allDot.get(i).getCenterX();
            float centerY = allDot.get(i).getCenterY();
            double distance = Math.sqrt(Math.pow(centerX - x, 2)) +
                    Math.sqrt(Math.pow(centerY - y, 2));
            if (distance <= allDot.get(i).getRadius()) {
                return i;
            }
        }
        return -1;
    }

}

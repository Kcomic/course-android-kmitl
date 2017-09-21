package kmitl.lab03.bawonsak58070074.simplemydot;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import kmitl.lab03.bawonsak58070074.simplemydot.model.Colors;
import kmitl.lab03.bawonsak58070074.simplemydot.model.Dot;
import kmitl.lab03.bawonsak58070074.simplemydot.view.EditDotView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditDotFragment extends Fragment {
    private Dot dot = null;
    private EditDotView editDotView;
    private int position;
    private EditDotFragmentListener listener = null;

    public EditDotFragment() {
        // Required empty public constructor
    }
    public void setListener(EditDotFragmentListener listener) {
        this.listener = listener;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dot = getArguments().getParcelable("dot");
        position = getArguments().getInt("position", -1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_edit_dot, container, false);
        editDotView = (EditDotView) rootView.findViewById(R.id.editDotView);
        editDotView.setColor(dot.getColor());
        editDotView.setRadius(100);
        final EditText xEdited   = (EditText)rootView.findViewById(R.id.xEdited);
        final EditText yEdited   = (EditText)rootView.findViewById(R.id.yEdited);
        final EditText rEdited = (EditText)rootView.findViewById(R.id.rEdited);
        TextView xValue = (TextView) rootView.findViewById(R.id.xValue) ;
        TextView yValue = (TextView)  rootView.findViewById(R.id.yValue) ;
        TextView raduis = (TextView)  rootView.findViewById(R.id.radius) ;
        xValue.setText(String.format("X : %.2f", dot.getCenterX()));
        yValue.setText(String.format("Y : %.2f", dot.getCenterY()));
        raduis.setText("Raduis : "+dot.getRadius());
        Button ok_btn = (Button) rootView.findViewById(R.id.ok_btn) ;
        Button change_color = (Button) rootView.findViewById(R.id.change_color);
        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dot.setColor(editDotView.getColor());
                listener.EditDotFinished(dot, position);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .remove(EditDotFragment.this)
                        .commit();
                String xValue = xEdited.getText().toString();
                String yValue = yEdited.getText().toString();
                String raduis = rEdited.getText().toString();
                if(!xValue.equals("")){
                    dot.setCenterX(Float.valueOf(xValue));
                }
                if(!yValue.equals("")){
                    dot.setCenterY(Float.valueOf(yValue));
                }
                if(!raduis.equals("")){
                    dot.setRadius(Integer.valueOf(raduis));
                }


            }
        });
        change_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot.setColor(new Colors().randomColor());
                editDotView.setColor(dot.getColor());
                editDotView.invalidate();
            }
        });
        return rootView;
    }

    public static EditDotFragment newInstance(Dot dot, int position, MainFragment mainFragment) {
        Bundle args = new Bundle();
        EditDotFragment fragment = new EditDotFragment();
        fragment.setListener(mainFragment);
        args.putParcelable("dot", dot);
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    public interface EditDotFragmentListener {

        public void EditDotFinished(Dot dot, int position);
    }

}

package kmitl.lab03.bawonsak58070074.simplemydot;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
        editDotView.setRadius(dot.getRadius());
        Button ok_btn = (Button) rootView.findViewById(R.id.ok_btn) ;
        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dot.setColor(editDotView.getColor());
                listener.EditDotFinished(dot, position);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .remove(EditDotFragment.this)
                        .commit();
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

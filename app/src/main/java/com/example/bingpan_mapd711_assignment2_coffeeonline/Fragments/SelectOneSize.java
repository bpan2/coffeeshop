package com.example.bingpan_mapd711_assignment2_coffeeonline.Fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.example.bingpan_mapd711_assignment2_coffeeonline.R;

public class SelectOneSize extends Fragment {
    private String size = "";
    private RadioGroup selectSizeRadioGroup;

    private FragmentToActivity mCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (FragmentToActivity) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement FragmentToActivity");
        }
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SelectOneSize() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectOneSize.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectOneSize newInstance(String param1, String param2) {
        SelectOneSize fragment = new SelectOneSize();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_select_one_size, container, false);
        selectSizeRadioGroup = (RadioGroup) rootView.findViewById(R.id.selectSizeRadioGroup);

        selectSizeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (selectSizeRadioGroup.getCheckedRadioButtonId() != -1) {
                    switch (checkedId) {
                        case R.id.sizeSmall:
                            size = "small";
                            break;
                            case R.id.sizeMedium:
                                size = "medium";
                                break;
                            case R.id.sizeLarge:
                                size = "large";
                                break;
                            default:
                                size = "";
                        }

                    Log.d("size", "prior to sendData(), size:" + size);
                    sendData(size);
                } else {
                    Log.d("size-err", "no size is selected");
                }}});

        return rootView;
    }

    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }
    public void onRefresh() {
        Toast.makeText(getActivity(), "Fragment : Refresh called.", Toast.LENGTH_SHORT).show();
    }

    private void sendData(String size) {
        mCallback.communicate(size);
    }
}


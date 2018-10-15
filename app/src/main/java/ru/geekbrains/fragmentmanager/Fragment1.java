package ru.geekbrains.fragmentmanager;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class Fragment1 extends Fragment {

    private static final String TAG = "myLogs";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
        }
        else{
            instanceState = "Повторный запуск!";
        }
        Toast.makeText(getActivity(), instanceState + "Fragment1.onCreate()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, instanceState + "Fragment1.onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "Fragment1.onCreateView()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment1.onCreateView");
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        Toast.makeText(getActivity(), "Fragment1.onAttach()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment1.onAttach");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toast.makeText(getActivity(), "Fragment1.onActivityCreated()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment1.onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getActivity(), "Fragment1.onStart()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment1.onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "Fragment1.onResume()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment1.onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity(), "Fragment1.onPause()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment1.onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getActivity(), "Fragment1.onStop()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment1.onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getActivity(), "Fragment1.onDestroyView()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment1.onDestroyView");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(), "Fragment1.onDestroy()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment1.onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
        Toast.makeText(getActivity(), "Fragment1.onDetach()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment1.onDetach");
    }
}

package ru.geekbrains.fragmentmanager;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // создадим фрагменты
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        //обработка кнопок
        Button add1 = findViewById(R.id.add1);
        add1.setOnClickListener(new ListenerOnAdd(fragment1));

        Button add2 = findViewById(R.id.add2);
        add2.setOnClickListener(new ListenerOnAdd(fragment2));

        Button add3 = findViewById(R.id.add3);
        add3.setOnClickListener(new ListenerOnAdd(fragment3));

        Button remove1 = findViewById(R.id.remove1);
        remove1.setOnClickListener(new ListenerOnRemove(fragment1));

        Button remove2 = findViewById(R.id.remove2);
        remove2.setOnClickListener(new ListenerOnRemove(fragment2));

        Button remove3 = findViewById(R.id.remove3);
        remove3.setOnClickListener(new ListenerOnRemove(fragment3));

        Button replace1 = findViewById(R.id.replace1);
        replace1.setOnClickListener(new ListenerOnReplace(fragment1));

        Button replace2 = findViewById(R.id.replace2);
        replace2.setOnClickListener(new ListenerOnReplace(fragment2));

        Button replace3 = findViewById(R.id.replace3);
        replace3.setOnClickListener(new ListenerOnReplace(fragment3));

        // Обработка нашей кнопки "Назад"
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack();
            }
        });
    }

    // при написании анонимного класса слушателя на кнопку,
    // было замечено, что при этом возникает
    // много дублирующего кода, пожтому было решено вытащить этот код в отдельный класс.
    // сравните с:
    // add1.setOnClickListener(new View.OnClickListener(){
    //    @Override
    //    public void onClick(View v) {
    //        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
    //        fragmentTransaction.add(R.id.fragment_container, fragment);
    //        fragmentTransaction.commit();
   //    }
    //  });
    private class ListenerOnAdd implements View.OnClickListener {

        private final Fragment fragment;

        private ListenerOnAdd(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onClick(View view) {
            addFragment();
        }

        // Добавить фрагмент
        private void addFragment() {
            FragmentManager fragmentManager = getFragmentManager();
            String tag = getTag(fragment);

            if (fragmentManager.findFragmentByTag(tag) != null) {
                Toast.makeText(MainActivity.this, "fragment already added",
                        Toast.LENGTH_LONG).show();
                return;
            }
            // открыть транзакцию
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            // добавить фрагмент
            fragmentTransaction.add(R.id.fragment_container, fragment, tag);
            fragmentTransaction.addToBackStack("");
            // закрыть транзакцию
            fragmentTransaction.commit();
        }
    }

    private static String getTag(Fragment fragment) {
        return fragment.getClass().getName();
    }

    private class ListenerOnRemove implements View.OnClickListener {

        private final Fragment fragment;

        private ListenerOnRemove(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onClick(View view) {
            removeFragment();
        }

        // удалить фрагмент
        private void removeFragment() {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.remove(fragment);
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.commit();
        }
    }

    private class ListenerOnReplace implements View.OnClickListener {

        private final Fragment fragment;

        private ListenerOnReplace(Fragment fragment){
            this.fragment = fragment;
        }

        @Override
        public void onClick(View view) {
            replaceFragment();
        }

        // заменить фрагмент
        private void replaceFragment() {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment, getTag(fragment));
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.commit();
        }
    }
}

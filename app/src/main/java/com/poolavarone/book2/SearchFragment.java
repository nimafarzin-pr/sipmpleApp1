package com.poolavarone.book2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.poolavarone.book2.Adapter.PersonAdapter;
import com.poolavarone.book2.Database.DataBase;
import com.poolavarone.book2.Model.Person;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    View view;
    LinearLayout linearLayout;
    RecyclerView recyclerView;
    EditText editText;
    PersonAdapter adapter;
    List<Person> personList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_fragment, container, false);

        setupViews();
        setdata();
        showBackground();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().trim().isEmpty()) {
                    showBackground();
                } else {
                    removeBackground();
                    filter(s.toString());
                }
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setupViews() {
        linearLayout = (LinearLayout) view.findViewById(R.id.search_background);
        editText = (EditText) view.findViewById(R.id.search_frame);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_in_searchfragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    public void setdata() {
        DataBase db = new DataBase(getActivity());
        personList = db.getAllperson();
        adapter = new PersonAdapter(getActivity(), personList);
        recyclerView.setAdapter(adapter);
    }

    private void filter(String text) {
        List<Person> filterlist = new ArrayList<>();
        for (Person person:personList){
            if (person.getName().toLowerCase().contains(text.toLowerCase() ) ||  person.getField().toLowerCase().contains(text.toLowerCase() )){
                filterlist.add(person);
            }
        }
        adapter.filterlist(filterlist);
    }

    private void showBackground() {

        linearLayout.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    private void removeBackground() {
        linearLayout.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }
}

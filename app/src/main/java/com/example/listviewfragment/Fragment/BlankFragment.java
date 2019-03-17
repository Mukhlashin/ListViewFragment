package com.example.listviewfragment.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.listviewfragment.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    FragmentManager fm;

    String[] nama = {"Kucing","Burung","Ladybug","Semut","Ikan","Jerapah","Panda"};
    int[] gambar = {R.drawable.cat,R.drawable.bird,R.drawable.ladybird,R.drawable.ant,R.drawable.fish,R.drawable.giraffe,R.drawable.panda};
    ListView lv;
    String name = "Coname";
    String imagec = "ImageC";


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        fm = getActivity().getSupportFragmentManager();
        lv = view.findViewById(R.id.list);

        List<HashMap<String,String>> listHewan = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 7; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();

            hm.put(name, nama[i]);
            hm.put(imagec, Integer.toString(gambar[i]));

            listHewan.add(hm);
        }

            String[] from = {name,imagec};
            int[] to = {R.id.tv_nama,R.id.icon};

            SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), listHewan, R.layout.fragment_layout, from, to);
            lv.setAdapter(simpleAdapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            Toast.makeText(getActivity(), "Kucing", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            Toast.makeText(getActivity(), "Burung", Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            Toast.makeText(getActivity(), "Ladybug", Toast.LENGTH_SHORT).show();
                            break;
                        case 3:
                            Toast.makeText(getActivity(), "Semut", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });


        return view;

    }


}

package com.azkazhanif.visualtalk.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azkazhanif.visualtalk.Adapter.NotificationAdapter;
import com.azkazhanif.visualtalk.Domain.NotificationDomain;
import com.azkazhanif.visualtalk.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotificationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerNotificationList;
    private ArrayList<NotificationDomain> notifArrayList;
    private String[] notifTitle, notifDesc;

    public NotificationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotificationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotificationFragment newInstance(String param1, String param2) {
        NotificationFragment fragment = new NotificationFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataIniitialize();

        recyclerNotificationList = view.findViewById(R.id.NotificationRecyclerView);
        recyclerNotificationList.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerNotificationList.setHasFixedSize(true);

        notifArrayList.add(new NotificationDomain("Dapatkan Promo", "Spesial Diskon hari ini"));
        NotificationAdapter notificationAdapter = new NotificationAdapter(getContext(), notifArrayList);
        recyclerNotificationList.setAdapter(notificationAdapter);
        notificationAdapter.notifyDataSetChanged();
    }

    private void dataIniitialize() {
        notifArrayList = new ArrayList<>();

        notifTitle = new String[]{
                getString(R.string.notif_title_1),
                getString(R.string.notif_title_2),
                getString(R.string.notif_title_3),
                getString(R.string.notif_title_4),
                getString(R.string.notif_title_5),
                getString(R.string.notif_title_6),
                getString(R.string.notif_title_7),
        };

        notifDesc = new String[]{
                getString(R.string.notif_desc_1),
                getString(R.string.notif_desc_2),
                getString(R.string.notif_desc_3),
                getString(R.string.notif_desc_4),
                getString(R.string.notif_desc_5),
                getString(R.string.notif_desc_6),
                getString(R.string.notif_desc_7),
        };

        for(int i = 0; i < notifTitle.length; i++) {
            NotificationDomain notificationDomain = new NotificationDomain(notifTitle[i], notifDesc[i]);
            notifArrayList.add(notificationDomain);
        }
     }
}
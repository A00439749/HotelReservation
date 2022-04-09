package com.example.hotelreservation;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HotelGuestDetailsFragment extends Fragment{

    View view;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.hotel_guest_details_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView hotelRecapTextView = view.findViewById(R.id.hotel_recap_text_view);

        String hotelName = getArguments().getString("hotel name");
        String hotelPrice = getArguments().getString("hotel price");
        String hotelAvailability = getArguments().getString("hotel availability");

        hotelRecapTextView.setText("You have selected " +hotelName+ ". The cost will be $ "+hotelPrice+ " and availability is " +hotelAvailability);

    }

    private void setupRecyclerView() {
        progressBar.setVisibility(View.GONE);
        RecyclerView recyclerView = view.findViewById(R.id.hotel_form_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // TODO: CREATE HOTELFORMADAPTER FILE
        // call setupRecyclerView() in line 39 after creating adapter
        //
        // HotelListAdapter hotelListAdapter = new HotelListAdapter(getActivity(), userListResponseData);
        // recyclerView.setAdapter(hotelListAdapter);
        //Bind the click listener
        //hotelListAdapter.setClickListener(this);
    }
}

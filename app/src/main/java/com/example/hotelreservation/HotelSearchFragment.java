package com.example.hotelreservation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HotelSearchFragment extends Fragment {

    ConstraintLayout mainLayout;
    TextView labelWelcome, labelCheckinDate, labelCheckoutDate, displaySubmitTextView;
    DatePicker checkinDatePicker, checkoutDatePicker;
    Button buttonSubmit, buttonSearch;
    EditText inputGuestsName, inputNumGuests;
    String checkInDate, checkOutDate, numberOfGuests, guestName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.hotel_search_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainLayout = view.findViewById(R.id.main_layout);
        labelWelcome = view.findViewById(R.id.label_welcome_text);
        labelCheckinDate = view.findViewById(R.id.label_checkin_date);
        labelCheckoutDate = view.findViewById(R.id.label_checkout_date);

        checkinDatePicker = view.findViewById(R.id.checkin_date);
        checkoutDatePicker = view.findViewById(R.id.checkout_date);
        buttonSubmit = view.findViewById(R.id.button_submit);
        buttonSearch = view.findViewById(R.id.button_search);

        inputGuestsName = view.findViewById(R.id.input_guests_name);
        inputNumGuests = view.findViewById(R.id.input_num_guests);
        displaySubmitTextView = view.findViewById(R.id.display_submit_text_view);

        labelWelcome.setText(R.string.welcome_text);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInDate = getDateFromCalendar(checkinDatePicker);
                checkOutDate = getDateFromCalendar(checkoutDatePicker);
                numberOfGuests = inputNumGuests.getText().toString();
                guestName = inputGuestsName.getText().toString();
                displaySubmitTextView.setText("Your checkin date is" +checkInDate+ ", and " +
                        "your checkout date is "+checkOutDate+" and # of guests are: "+numberOfGuests);
            }
        });

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInDate = getDateFromCalendar(checkinDatePicker);
                checkOutDate = getDateFromCalendar(checkoutDatePicker);
                numberOfGuests = inputNumGuests.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("check in date", checkInDate);
                bundle.putString("check out date", checkOutDate);
                bundle.putString("number of guests", numberOfGuests);


                HotelListFragment hotelsListFragment = new HotelListFragment();
                hotelsListFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_layout, hotelsListFragment);
                fragmentTransaction.remove(HotelSearchFragment.this);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private String getDateFromCalendar(DatePicker datePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = simpleDateFormat.format(calendar.getTime());
        return formattedDate;
    }

}

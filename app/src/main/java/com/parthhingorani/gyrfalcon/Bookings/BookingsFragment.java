package com.parthhingorani.gyrfalcon.Bookings;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.parthhingorani.gyrfalcon.Database;
import com.parthhingorani.gyrfalcon.Flights.Flight;
import com.parthhingorani.gyrfalcon.Flights.FlightsAdapter;
import com.parthhingorani.gyrfalcon.R;

import java.util.ArrayList;
import java.util.List;

public class BookingsFragment extends Fragment {

    //data structures
    TextView tvError;
    NestedScrollView nsvBookedFlights;
    BookingsAdapter flightsAdapter;
    RecyclerView rvFlights;
    List<Flight> flightsList;
    LinearLayoutManager linearLayoutManager;
    Database database;

    public BookingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bookings, container, false);

        //initialization
        tvError = view.findViewById(R.id.emsgNoBookings);
        rvFlights = view.findViewById(R.id.rvBookedFlights);
        nsvBookedFlights = view.findViewById(R.id.nsvBookedFlights);

        database = new Database(getActivity());
        flightsList = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvFlights.setLayoutManager(linearLayoutManager);

        //get booked flights and load into adapter
        populateFlights();
        flightsAdapter = new BookingsAdapter(getActivity(), flightsList, database);
        rvFlights.setAdapter(flightsAdapter);
        rvFlights.setNestedScrollingEnabled(true);

        return view;
    }

    private void populateFlights()  {

        //flight fetch from db
        flightsList = database.getBookedFlights();
//        flightsAdapter.notifyDataSetChanged();

        //show error if not found
        if (flightsList == null)    {
            tvError.setVisibility(View.VISIBLE);
            nsvBookedFlights.setVisibility(View.GONE);
        } else {
            tvError.setVisibility(View.GONE);
            nsvBookedFlights.setVisibility(View.VISIBLE);
        }
    }
}

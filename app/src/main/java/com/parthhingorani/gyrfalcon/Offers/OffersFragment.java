package com.parthhingorani.gyrfalcon.Offers;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parthhingorani.gyrfalcon.R;

import java.util.ArrayList;
import java.util.List;

public class OffersFragment extends Fragment {

    OffersAdapter offersAdapter;
    RecyclerView rvOffers;
    LinearLayoutManager linearLayoutManager;
    List<Offer> offersList;

    public OffersFragment() {
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
        View view = inflater.inflate(R.layout.fragment_offers, container, false);

        rvOffers = view.findViewById(R.id.rvOffers);

        offersList = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        offersList.add(new Offer("FLYMON",
                "https://logos-download.com/wp-content/uploads/2016/10/icici_bank_logo_symbol.png",
                "Up to ₹1,500 Cashback to Card on Domestic Flights & Additional ₹200 Cashback with ICICI EMI." +
                        "\nExclusive offer on ICICI Bank Credit Cards, EMI, Debit Cards, Internet Banking and Pockets only." +
                        "\nThis offer is valid for bookings made every Monday from 4 PM to 10 PM from 6th August 2018 till 24th September 2018"));
        offersList.add(new Offer("HDFCINT",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/2/28/HDFC_Bank_Logo.svg/2000px-HDFC_Bank_Logo.svg.png",
                "Up to ₹10,000 Cashback to Card on International Flights." +
                        "\nExclusive offer on HDFC Bank Debit & Credit Cards only." +
                        "\nThe offer is valid every Thursday from 5th July 2018 to 27th Sept 2018 (both days included)"));
        offersList.add(new Offer("AXISDOM",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Axis_Bank_logo.svg/2000px-Axis_Bank_logo.svg.png",
                "Up to INR 1,499 cashback to card on Domestic Flights!" +
                        "\nExclusive offer for Axis Bank customers." +
                        "\nThe Offer is valid only on every Wednesdays from 4th July, 2018 to 26th Sep, 2018 between 16:00 hrs to 23:59"));

        offersAdapter = new OffersAdapter(getContext(),offersList);

        rvOffers.setLayoutManager(linearLayoutManager);
        rvOffers.setAdapter(offersAdapter);
        rvOffers.setNestedScrollingEnabled(true);

        return view;
    }
}

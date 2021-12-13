package com.example.dcjd.Vista;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dcjd.R;

public class Fragment_Sucursales extends Fragment {

    Drawable drawable1, drawable2, drawable3;
    ImageView imagen8, imagen9, imagen10;

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__sucursales, container, false);
        //-------------------------------- CARGUE DE IMAGENES ------------------------------

        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.su1, v.getContext().getTheme());

        imagen8 = (ImageView) v.findViewById(R.id.imagen8);
        imagen8.setImageDrawable(drawable1);

        //--------------------------------------------------------

        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.su2, v.getContext().getTheme());

        imagen9= (ImageView) v.findViewById(R.id.imagen9);
        imagen9.setImageDrawable(drawable2);

        //--------------------------------------------------------

        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.su3, v.getContext().getTheme());

        imagen10= (ImageView) v.findViewById(R.id.imagen10);
        imagen10.setImageDrawable(drawable3);
        //----------------------------------------------------------------------------

       return v;
    }
}
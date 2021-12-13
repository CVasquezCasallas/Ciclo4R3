package com.example.dcjd.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dcjd.Modelo.BaseDatosSQLite;
import com.example.dcjd.Modelo.Productos.AdaptadorProducto;
import com.example.dcjd.Modelo.Productos.EntidadProducto;
import com.example.dcjd.R;

import java.util.ArrayList;

public class Fragment_Productos extends Fragment {

    private View view;
    private Cursor cursor;
    private ArrayList<EntidadProducto> listaProductos = new ArrayList<>();
    private int[] listImg = {R.drawable.pr1,R.drawable.pr3, R.drawable.pr4};
    private ListView listViewProd;
    private AdaptadorProducto adaptadorProducto;

    public Fragment_Productos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment__productos, container, false);
        //--------------------------------------------------------------------------------
        listViewProd = (ListView) view.findViewById(R.id.viewProducts);
        adaptadorProducto = new AdaptadorProducto(getProdItems(),getActivity());
        listViewProd.setAdapter(adaptadorProducto);

        //-----------------------------------------------------------------------------
        return view;
    }

    private ArrayList<EntidadProducto> getProdItems(){
        BaseDatosSQLite conector = new BaseDatosSQLite(this.getActivity(), "AppChaqueta", null, 1);

        SQLiteDatabase db_read = conector.getReadableDatabase();


        conector.onUpgrade(db_read,1,2);
        cursor = db_read.rawQuery("SELECT * FROM productos", null);



        //Escritura de elementos de la Base de Datos a la parte visual
        while (cursor.moveToNext()) {
            listaProductos.add(new EntidadProducto(listImg[cursor.getInt(0)],cursor.getString(1),cursor.getString(2) ));
            //lista.append(cursor.getString(0)+" "+cursor.getString(1));

        }
        return listaProductos;
    }

 }
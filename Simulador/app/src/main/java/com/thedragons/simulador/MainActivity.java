package com.thedragons.simulador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.android.BezirkMiddleware;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    Bezirk bezirk;

    //Initialize the Bezirk service
    BezirkMiddleware.initialize(this);


    //Register with BezirkMiddleware to get an instance of Bezirk API.
    //The parameter is any human-readable string for a name of your Zirk
    bezirk = BezirkMiddleware.registerZirk("Simulador de lamparas");

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
}

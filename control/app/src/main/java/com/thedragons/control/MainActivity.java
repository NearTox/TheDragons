package com.thedragons.control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.android.BezirkMiddleware;

public class MainActivity extends AppCompatActivity {

  private Bezirk bezirk;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Initialize the Bezirk service
    BezirkMiddleware.initialize(this);


    //Register with BezirkMiddleware to get an instance of Bezirk API.
    //The parameter is any human-readable string for a name of your Zirk
    bezirk = BezirkMiddleware.registerZirk("Control de lamparas");
  }
}

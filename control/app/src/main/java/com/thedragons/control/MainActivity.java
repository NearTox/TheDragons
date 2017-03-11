package com.thedragons.control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.android.BezirkMiddleware;
import com.thedragons.control.models.Lampara;

public class MainActivity extends AppCompatActivity {

  private Bezirk bezirk;
  private static final int COLOR_AMARILLO = 37;
  private static final int COLOR_AZUL = 38;
  private static final int COLOR_VERDE = 39;
  private static final int ENCENDIDO = 1;
  private static final int APAGADO = 0;
  private static final int APAGAR_TODAS = 100;

  private ToggleButton toggleButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Initialize the Bezirk service
    BezirkMiddleware.initialize(this);
    toggleButton = findViewById(R.id.asd);

    //Register with BezirkMiddleware to get an instance of Bezirk API.
    //The parameter is any human-readable string for a name of your Zirk
    bezirk = BezirkMiddleware.registerZirk("Control de lamparas");

    toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
          bezirk.sendEvent(new LamparaEvent());
        } else {

        }
      }
    });
  }



}

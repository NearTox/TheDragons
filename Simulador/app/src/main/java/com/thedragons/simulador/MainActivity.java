package com.thedragons.simulador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.android.BezirkMiddleware;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.thedragons.simulador.events.LamparaEvent;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    BezirkMiddleware.initialize(this);
    Bezirk bezirk = BezirkMiddleware.registerZirk("Simulador");

    final EventSet eventSet = new EventSet(LamparaEvent.class);

    eventSet.setEventReceiver(new EventSet.EventReceiver() {
      @Override
      public void receiveEvent(Event event, ZirkEndPoint sender) {
        //Check if the event is of interest
        if (event instanceof LamparaEvent) {
          final LamparaEvent lamparaEvent = (LamparaEvent) event;
          Log.d("*****", String .valueOf(lamparaEvent.getEncendido()));
          //TODO encender lamparas
        }
      }
    });
  }
}

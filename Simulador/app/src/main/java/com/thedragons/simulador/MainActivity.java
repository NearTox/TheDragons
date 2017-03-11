package com.thedragons.simulador;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.android.BezirkMiddleware;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.thedragons.events.LamparaEvent;

public class MainActivity extends AppCompatActivity {

  private ImageView imgSala;
  private ImageView imgCocina;
  private ImageView imgDormitorio;

  private static final int COLOR_AMARILLO = 37;
  private static final int COLOR_AZUL = 38;
  private static final int COLOR_VERDE = 39;

  private static final int ENCENDIDO = 1;
  private static final int APAGADO = 0;
  private static final int APAGAR_TODAS = 100;

  private static final int COCINA = 21;
  private static final int SALA = 22;
  private static final int DORMITORIO = 23;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    setContentView(R.layout.activity_berzik_casa);
    imgSala = (ImageView) findViewById(R.id.place1);
    imgCocina = (ImageView) findViewById(R.id.place2);
    imgDormitorio = (ImageView) findViewById(R.id.place3);

    Bezirk bezirk;

    //Initialize the Bezirk service
    BezirkMiddleware.initialize(this);


    //Register with BezirkMiddleware to get an instance of Bezirk API.
    //The parameter is any human-readable string for a name of your Zirk
    bezirk = BezirkMiddleware.registerZirk("Simulador de lamparas");

    super.onCreate(savedInstanceState);

    final EventSet eventSet = new EventSet(LamparaEvent.class);

    eventSet.setEventReceiver(new EventSet.EventReceiver() {
      @Override
      public void receiveEvent(Event event, ZirkEndPoint sender) {
        //Check if the event is of interest
        if (event instanceof LamparaEvent) {
          final LamparaEvent lamparaEvent = (LamparaEvent) event;

          int id = lamparaEvent.getId();
          int encendido = lamparaEvent.getEncendido();
          int color = lamparaEvent.getColor();

          if (encendido == ENCENDIDO) {
            switch (id) {
              case COCINA:
                if(color == COLOR_AZUL) {
                  imgCocina.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.cocina_azul));
                } else if(color == COLOR_VERDE) {
                  imgCocina.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.cocina_verde));
                } else {
                  imgCocina.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.cocina_amarillo));
                }
                break;
              case SALA:
                if(color == COLOR_AZUL) {
                  imgSala.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.sala_azul));
                } else if(color == COLOR_VERDE) {
                  imgSala.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.sala_verde));
                } else {
                  imgSala.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.sala_amarillo));
                }
                break;
              case DORMITORIO:
                if(color == COLOR_AZUL) {
                  imgDormitorio.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.dormitorio_azul));
                } else if(color == COLOR_VERDE) {
                  imgDormitorio.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.dormitorio_verde));
                } else {
                  imgDormitorio.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.dormitorio_amarillo));
                }
                break;
            }
          }  else {
            switch (id) {
              case COCINA:
                imgCocina.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.cocina_sala));
                break;
              case SALA:
                imgSala.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.sala_off));
                break;
              case DORMITORIO:
                imgDormitorio.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.dormitorio_off));
                break;
            }
          }

        }
      }
    });
    bezirk.subscribe(eventSet);
  }
}

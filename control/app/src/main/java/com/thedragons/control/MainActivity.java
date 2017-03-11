package com.thedragons.control;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Button;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.android.BezirkMiddleware;
import com.thedragons.events.LamparaEvent;
import com.thedragons.control.models.Lampara;

public class MainActivity extends AppCompatActivity {

  private Bezirk bezirk;
  private static final int COLOR_AMARILLO = 37;
  private static final int COLOR_AZUL = 38;
  private static final int COLOR_VERDE = 39;

  private static final int ENCENDIDO = 1;
  private static final int APAGADO = 0;
  private static final int APAGAR_TODAS = 100;

  private static final int COCINA = 21;
  private static final int SALA = 22;
  private static final int DORMITORIO = 23;

  private Switch toggleCocina;
  private Switch toggleSala;
  private Switch toggleDormitorio;

  private Button salaVerde;
  private Button salaAzul;
  private Button salaAmarillo;

  private Button cocinaVerde;
  private Button cocinaAzul;
  private Button cocinaaAmarillo;

  private Button dormitorioVerde;
  private Button dormitorioAzul;
  private Button dormitorioAmarillo;

  private int cocinaColor = COLOR_AMARILLO;
  private int salaColor = COLOR_AMARILLO;
  private int dormitorioColor = COLOR_AMARILLO;

  private int cocinaEnabled = APAGADO;
  private int salaEnabled = APAGADO;
  private int dormitorioEnabled = APAGADO;

  protected void SendLampEvent(int id,boolean isChecked, int color) {
    bezirk.sendEvent(new LamparaEvent(id,isChecked?1:0,color));
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Initialize the Bezirk service
    BezirkMiddleware.initialize(this);
    toggleCocina = (Switch) findViewById(R.id.cocina_on);
    toggleDormitorio = (Switch) findViewById(R.id.dormitorio_on);
    toggleSala = (Switch) findViewById(R.id.sala_on);

    //Register with BezirkMiddleware to get an instance of Bezirk API.
    //The parameter is any human-readable string for a name of your Zirk
    bezirk = BezirkMiddleware.registerZirk("Control de lamparas");

    toggleCocina.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        SendLampEvent(COCINA, isChecked, cocinaColor);
      }
    });
    toggleDormitorio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        SendLampEvent(DORMITORIO, isChecked, dormitorioColor);
      }
    });
    toggleSala.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        SendLampEvent(SALA, isChecked, salaColor);
      }
    });
  }



}

package com.thedragons.control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Button;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.android.BezirkMiddleware;
import com.thedragons.events.LamparaEvent;

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
  private Button cocinaAmarillo;

  private Button dormitorioVerde;
  private Button dormitorioAzul;
  private Button dormitorioAmarillo;

  private int cocinaColor = COLOR_AMARILLO;
  private int salaColor = COLOR_AMARILLO;
  private int dormitorioColor = COLOR_AMARILLO;

  private int cocinaEnabled = APAGADO;
  private int salaEnabled = APAGADO;
  private int dormitorioEnabled = APAGADO;

  protected void SendLampEvent(int id,int isChecked, int color) {
    bezirk.sendEvent(new LamparaEvent(id,isChecked,color));
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

    cocinaAmarillo = (Button) findViewById(R.id.cocina_amarillo);
    cocinaAzul = (Button) findViewById(R.id.cocina_azul);
    cocinaVerde = (Button) findViewById(R.id.cocina_verde);

    salaAmarillo = (Button) findViewById(R.id.sala_amarillo);
    salaAzul = (Button) findViewById(R.id.sala_azul);
    salaVerde = (Button) findViewById(R.id.sala_verde);

    dormitorioAmarillo = (Button) findViewById(R.id.dormitorio_amarillo);
    dormitorioAzul = (Button) findViewById(R.id.dormitorio_azul);
    dormitorioVerde = (Button) findViewById(R.id.dormitorio_verde);

    //Register with BezirkMiddleware to get an instance of Bezirk API.
    //The parameter is any human-readable string for a name of your Zirk
    bezirk = BezirkMiddleware.registerZirk("Control de lamparas");

    toggleCocina.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        cocinaEnabled=isChecked?1:0;
        SendLampEvent(COCINA, cocinaEnabled, cocinaColor);
      }
    });
    toggleDormitorio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        dormitorioEnabled=isChecked?1:0;
        SendLampEvent(DORMITORIO, dormitorioEnabled, dormitorioColor);
      }
    });
    toggleSala.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        salaEnabled=isChecked?1:0;
        SendLampEvent(SALA, salaEnabled, salaColor);
      }
    });

    cocinaAzul.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        cocinaColor=COLOR_AZUL;
        SendLampEvent(COCINA, cocinaEnabled, cocinaColor);
      }
    });
    cocinaAmarillo.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        cocinaColor=COLOR_AMARILLO;
        SendLampEvent(COCINA, cocinaEnabled, cocinaColor);
      }
    });
    cocinaVerde.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        cocinaColor=COLOR_VERDE;
        SendLampEvent(COCINA, cocinaEnabled, cocinaColor);
      }
    });
    dormitorioAzul.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        dormitorioColor=COLOR_AZUL;
        SendLampEvent(DORMITORIO, dormitorioEnabled, dormitorioColor);
      }
    });
    dormitorioAmarillo.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        dormitorioColor=COLOR_AMARILLO;
        SendLampEvent(DORMITORIO, dormitorioEnabled, dormitorioColor);
      }
    });
    dormitorioVerde.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        dormitorioColor=COLOR_VERDE;
        SendLampEvent(DORMITORIO, dormitorioEnabled, dormitorioColor);
      }
    });
    salaAzul.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        salaColor=COLOR_AZUL;
        SendLampEvent(SALA, salaEnabled, salaColor);
      }
    });
    salaAmarillo.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        salaColor=COLOR_AMARILLO;
        SendLampEvent(SALA, salaEnabled, salaColor);
      }
    });
    salaVerde.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        salaColor=COLOR_VERDE;
        SendLampEvent(SALA, salaEnabled, salaColor);
      }
    });
  }



}

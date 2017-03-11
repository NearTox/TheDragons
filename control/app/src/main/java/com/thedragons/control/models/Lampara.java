package com.thedragons.control.models;
import com.thedragons.events.LamparaEvent;

public class Lampara {

  public int id;

  public int encendido;

  public int color;

  public LamparaEvent makeEvent(){
    return new LamparaEvent(id,encendido,color);
  }
}

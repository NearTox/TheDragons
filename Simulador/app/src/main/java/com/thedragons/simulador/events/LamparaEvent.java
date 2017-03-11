package com.thedragons.simulador.events;

import com.bezirk.middleware.messages.Event;

/**
 * Created by efrain on 11/03/17.
 */

public class LamparaEvent extends Event {
    private final int id;
    private final int encendido;
    private final int color;

    public LamparaEvent(int id, int encendido, int color) {
        this.id = id;
        this.encendido=encendido;
        this.color=color;
    }

    public int getId() { return id; }
    public int getEncendido() { return encendido; }
    public int getColor() { return color; }
}

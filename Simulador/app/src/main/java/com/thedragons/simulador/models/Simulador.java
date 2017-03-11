package com.thedragons.simulador.models;

import android.content.Context;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.android.BezirkMiddleware;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.thedragons.events.LamparaEvent;

/**
 * Created by efrain on 11/03/17.
 */

public class Simulador {

    private Context contexto;

    Simulador(Context contexto){
        this.contexto = contexto;
    }

    public void recibir() {
        BezirkMiddleware.initialize(this.contexto);
        Bezirk bezirk = BezirkMiddleware.registerZirk("Remote Control Receiver Zirk");

        final EventSet eventSet = new EventSet(LamparaEvent.class);
        eventSet.setEventReceiver(new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint zirkEndPoint) {
                //Check if the event is of interest
                if (event instanceof LamparaEvent) {
                    final LamparaEvent lamparaEvent = (LamparaEvent) event;
                    System.out.println("Received key event - code: " + lamparaEvent.getEncendido());
                }
            }
        });

        bezirk.subscribe(eventSet);
        System.out.println("Listening for SimulateKeyEvents...");
    }
}

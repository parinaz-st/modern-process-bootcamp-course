package com.modern.process.domain;

import org.springframework.stereotype.Component;

@Component
public class Car
{
    private Engine engine;
    private Trailer trailer;
    public Car(Engine engine, Trailer trailer)
    {
        this.engine = engine;
        this.trailer = trailer;
    }
}

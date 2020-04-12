package com.http.las.random;

import lombok.Getter;

import java.util.List;

public class OptionsContainer<T> {
    @Getter
    private boolean filled = false;
    @Getter
    private List<? extends T> options;
    private Filler<? extends T> filler;

    public OptionsContainer(Filler<? extends T> filler, boolean autoFilling) {
        this.filler = filler;
        if (autoFilling) {
            fill();
        }
    }

    public void fill() {
        options = filler.fill();
        filled = true;
    }

    interface Filler<T> {
        List<T> fill();
    }
}

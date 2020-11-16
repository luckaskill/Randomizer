package com.http.las.random;

import java.util.List;

public interface HasOptions <T> {
    List<? extends T> getOptions();
}

package com.honeycomb.Util;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import org.springframework.stereotype.Component;

@Component
public class UlidGenerator {

    public String generateUlid() {
        Ulid ulid = UlidCreator.getUlid();

        return ulid.toString();
    }
}

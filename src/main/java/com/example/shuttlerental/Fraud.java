package com.example.shuttlerental;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value.Immutable;

@Immutable
@JsonSerialize(as = ImmutableFraud.class)
@JsonDeserialize(as = ImmutableFraud.class)
public interface Fraud {

    String name();

}

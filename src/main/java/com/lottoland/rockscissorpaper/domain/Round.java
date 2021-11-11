package com.lottoland.rockscissorpaper.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@JsonDeserialize
public class Round implements Serializable {

    private Choice player1Choice;

    private Choice player2Choice;

    private Result player1Result;

    private Result player2Result;

}

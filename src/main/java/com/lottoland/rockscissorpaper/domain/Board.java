package com.lottoland.rockscissorpaper.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonDeserialize
@Builder
public class Board implements Serializable {

    private String id;

    private List<Round> rounds;

}

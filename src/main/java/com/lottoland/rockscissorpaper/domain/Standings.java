package com.lottoland.rockscissorpaper.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@JsonDeserialize
public class Standings implements Serializable {

    List<Round> roundsPlayed;
}

package com.lottoland.rockscissorpaper.model;

import com.lottoland.rockscissorpaper.domain.Choice;
import com.lottoland.rockscissorpaper.domain.Result;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Round {

    @Id
    private String id;

    private Choice player1Choice;

    private Choice player2Choice;

    private Result player1Result;

    private Result player2Result;

}

package com.lottoland.rockscissorpaper.repository;

import com.lottoland.rockscissorpaper.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,String> {
}

package com.forohub.apiRest.domain.topico;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TopicoRepository extends JpaRepository<Topico, Long> {


    List<Topico> findByTituloContainingIgnoreCase(String titulo);
}

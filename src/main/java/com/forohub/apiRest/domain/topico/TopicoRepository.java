package com.forohub.apiRest.domain.topico;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TopicoRepository extends JpaRepository<Topico, Long> {

   // Page<Topico> findAll(Page paginacion);

    List<Topico> findByTituloContainingIgnoreCase(String titulo);
}

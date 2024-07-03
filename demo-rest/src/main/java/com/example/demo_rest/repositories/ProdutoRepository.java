package com.example.demo_rest.repositories;

import com.example.demo_rest.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
  Page<Produto> findByNomeContainingIgnoreCaseAndFabricanteContainingIgnoreCase(
      String nome, String fabricante, Pageable paginacao);
}

package org.pratice.praticejpa.repository;

import org.pratice.praticejpa.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long>
{

}

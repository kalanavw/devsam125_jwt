package org.sid.demo.dao;

import java.util.List;

import org.sid.demo.entities.Produit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitReposotory  extends JpaRepository<Produit, Integer>{
	@Query("SELECT u FROM Produit u WHERE u.titre = ?1")
	public Page<Produit> rechercheParNom(@Param("mc")String des ,Pageable pageable) ;
	
	@Query("SELECT u FROM Produit u order by u.idP desc ")
	public List<Produit>  listProduitTree() ;
	@Query("SELECT u FROM Produit u order by u.idP desc ")
	public Page<Produit> listProduitTree(PageRequest of);
	
}

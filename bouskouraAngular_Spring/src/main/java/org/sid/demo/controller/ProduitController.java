package org.sid.demo.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.sid.demo.CompareID.CompareID;
import org.sid.demo.dao.ProduitImp;
import org.sid.demo.dao.ProduitReposotory;
import org.sid.demo.entities.Produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;


@RestController
@CrossOrigin(origins = "*")
public class ProduitController {

    @Autowired
    ProduitReposotory produitRep;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/listeprod", method = RequestMethod.GET)
    public List<Produit> Afficher() {

        Produit p;
        //List<Produit>li=	Collections.sort(produitRep.findAll(), new CompareID());
        //return produitRep.listProduitTree();
        return produitRep.findAll();

    }

    @RequestMapping(value = "/lProd/{id}", method = RequestMethod.GET)
    public java.util.Optional<Produit> AfficherParId(@PathVariable("id") int id) {

        return produitRep.findById(id);

    }


    @RequestMapping(value = "/lProd1", method = RequestMethod.GET)
    public Page<Produit> publi11(int page, int size) {
        return produitRep.listProduitTree(PageRequest.of(page, size));
        //produitRep.findAll(PageRequest.of(page, size));


    }


    //	@PostMapping("/AjouterProd")
    @RequestMapping(value = "/AjouterProd", method = RequestMethod.POST)
    public Produit createEmployee(@RequestBody Produit produit) {
        return produitRep.save(produit);
    }


    //
    @RequestMapping(value = "/supP/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void suppProduit(@PathVariable("id") int id) {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        produitRep.deleteById(id);


    }


    @RequestMapping(value = "/modifierP/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> modifierStudent(@RequestBody Produit produit, @PathVariable int id) {

        java.util.Optional<Produit> studentOptional = produitRep.findById(id);

        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();

        produitRep.save(produit);

        return ResponseEntity.noContent().build();
    }
	




/*
	public Page<Produit> rechercheParNom(String des, Pageable pageable) {

		produitRep.rechercheParNom(des, pageable)		
		return null;
	}*/


}

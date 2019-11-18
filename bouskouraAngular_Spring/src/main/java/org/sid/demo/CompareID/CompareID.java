package org.sid.demo.CompareID;

import java.util.Comparator;

import org.sid.demo.entities.Produit;

public class CompareID  implements Comparator<Produit> {

	@Override
	public int compare(Produit arg0, Produit arg1) {
		// TODO Auto-generated method stub
		return arg1.getIdP()-arg0.getIdP() ;
	}
	
  

}

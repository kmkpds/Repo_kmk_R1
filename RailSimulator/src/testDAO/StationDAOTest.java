package testDAO;





import javax.swing.JOptionPane;

import dao.StationDAO;
import beans.Station;
import junit.framework.TestCase;

/**
 * **/


public class StationDAOTest extends TestCase {
		
		String testnomS ;
		String testcommentS ;
		Station st = new Station();		
		StationDAO daostation = new StationDAO();	
		boolean res ; 
	
			
	public void testCreateStation() {	
			
		String testnomS = daostation.generateRandom();
		String testcommentS = daostation.generateRandom() ;
		st = new Station(testnomS, testcommentS);
		//Je cree mon instance dans la base 
		daostation.createStation(testnomS, testcommentS);
		//une instance de verif
		 res = daostation.existStation(st);	
		 System.out.println(res);
		 assertTrue(res);
		
	}

	public void testSupprimerStation() {
		//initialise deux chaines pour la cr�ation d'une nouvelle station qui sera suprimer apr�s
		String testnomS = daostation.generateRandom();
		String testcommentS = daostation.generateRandom();
		st = new Station(testnomS, testcommentS);
		daostation.createStation(testnomS,testcommentS);		
		st = new Station(testnomS,testcommentS);
		int der = daostation.derniereStation() ;	
		st.setIdStation(der);
     	daostation.supprimerStation(der);  	  
     	res = daostation.existStation(st);     	
      	assertTrue(res);
		
	}
	
	public void testListerStation() {
		
		String testnomL = daostation.generateRandom();
	String testcommentL = daostation.generateRandom();
	
	daostation.createStation(testnomL, testcommentL);	
	
	assertNotNull(daostation.listerStation());
}

/**
	public void testGetStationByID() {
		
		int sta = daostation.getStationByID(st.getIdStation()).getIdStation();
		
		assertEquals(st.getIdStation(),""+sta);
	}
	
**/	
	public void testModifierStation() {
		
		//insert dans la base
		String testnomS = daostation.generateRandom();
		String testcommentS = daostation.generateRandom();
		
		daostation.createStation(testnomS, testcommentS);
		st.setNomStation(testnomS);
		st.setCommentaireStation(testcommentS);
		
		String nouvNom = daostation.generateRandom();
		String nouvComment = daostation.generateRandom();	
		Station stn = new Station(nouvNom,nouvComment);
		st =stn ;
		//st.setNomStation(nouvNom);
		//st.setCommentaireStation(nouvComment);
		
		daostation.modifierStation(st);		
			
		assertEquals(st, stn);
		//	assertFalse(daostation.existStation(st));		
						
	}



}


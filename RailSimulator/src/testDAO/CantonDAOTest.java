package testDAO;

import javax.swing.JOptionPane;

import org.hibernate.mapping.List;

import beans.Canton;
import beans.Ligne;
import beans.Station;
import dao.CantonDAO;
import junit.framework.TestCase;

/****
 * 
 * @author faycallemseffer
 * Test unitaire DAO Canton 
 * 
 * La m�me chose, (n'est pas complet) 
 * 
 * Deux test qui marche (creer et supprimer)
 * 
 * le reste viendra apr�s
 * 
 *
 */

public class CantonDAOTest extends TestCase {

	String testnomC ;
	String testcommentC ;
	Canton ct = new Canton();	
	CantonDAO daocanton = new CantonDAO();
	Ligne l = new Ligne();
	Station s = new Station();
	
	public void testCreateCanton() {
		
		 testnomC = JOptionPane.showInputDialog("Entrer le nom du canton ");
		 testcommentC = JOptionPane.showInputDialog("Entrer le commentaire");
				
		daocanton.createCanton(testnomC, testcommentC, l, s);
		ct.setNomCanton(testnomC);
		ct.setCommentaireCanton(testcommentC);		

		assertTrue(daocanton.existCanton(ct));
	}

	public void testSupprimerCanton() {

	
		testnomC = JOptionPane.showInputDialog("creer un canton pour tester la suppression ensuite, le nom ?");
		testcommentC = JOptionPane.showInputDialog("Entrer le commentaire");
		
		 daocanton.createCanton(testnomC, testcommentC,l,s);
		JOptionPane.showMessageDialog(null, "Merci de cliquer pour supp","supp", JOptionPane.INFORMATION_MESSAGE);
		daocanton.supprimerCanton(daocanton.dernierCanton(ct));		
      	assertFalse(daocanton.existCanton(ct));
     }

	public void testListerCanton() {

		List li = (List) daocanton.listerCanton();
		//assertNotNull(daostation.listerStation());
		assertEquals(li, daocanton.listerCanton());
	}

	public void testGetCantonByID() {
		assertNotNull(ct);
	}


	public void testModifierCanton() {
		fail("Not yet implemented");
	}

}
package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	@Test
	public void test() {
		testInit();
		testWalkingWithoutObstacles();
//		testWalkingOnABorder();	
	}
	
	@Test
	public void testInit() {
		PlanetExplorer explorer = new PlanetExplorer(10,10,"(5,5)(4,3)(7,8)");  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
		assertEquals(explorer.getX(), 10);
		assertEquals(explorer.getY(), 10);
		assertEquals(explorer.getXp(), 0);
		assertEquals(explorer.getYp(), 0);
		assertEquals(explorer.getD(), 4);		
		assertEquals(explorer.getObstaclesList().get(0), 5);
		assertEquals(explorer.getObstaclesList().get(1), 5);
		assertEquals(explorer.getObstaclesList().get(2), 4);		
		assertEquals(explorer.getObstaclesList().get(3), 3);
		assertEquals(explorer.getObstaclesList().get(4), 7);
		assertEquals(explorer.getObstaclesList().get(5), 8);
	}

	@Test
	public void testWalkingWithoutObstacles() {
		PlanetExplorer explorer = new PlanetExplorer(10,10,"(5,5)(4,3)(7,8)");  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
		explorer.executeCommand("ffrf");
		assertEquals(explorer.getXp(), 1);
		assertEquals(explorer.getYp(), 2);		
	}

	@Test
	public void testWalkingOnABorder() {
		PlanetExplorer explorer = new PlanetExplorer(5,5,"(4,4)(4,3)");  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
		explorer.executeCommand("ffff");
		assertEquals(explorer.getXp(), 0);
		assertEquals(explorer.getYp(), 4);		
	}
	
	@Test
	public void testWalkingOnAOstacle() {
		PlanetExplorer explorer = new PlanetExplorer(5,5,"(0,1)(4,3)");  
		assertEquals(explorer.getXp(), 0);
		assertEquals(explorer.getYp(), 0);
	}
	
	
}

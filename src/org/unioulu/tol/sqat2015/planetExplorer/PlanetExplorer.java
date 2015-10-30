package org.unioulu.tol.sqat2015.planetExplorer;

import java.util.ArrayList;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID: 155
// Finish time: 17:19

public class PlanetExplorer {
	// size of the field
	private int x;
	private int y;
	
	public int getXp() {
		return xp;
	}

	public int getYp() {
		return yp;
	}

	public int getD() {
		return d;
	}

	// List of obstacles 
	ArrayList<Integer> obstaclesList; 
	
	// currentPosition of explorer
	int xp;
	int yp;
	
	//oldPosition of explorer
	int oldXp;
	int oldYp;
	
	// direction of the explorer (1=east, 2=south, 3=west, 4=north)
	int d;
	
	public PlanetExplorer(int x, int y, String obstacles){
		this.x=x;
		this.y=y;
		
		// starts from (0,0) and fase to north
		xp=0;
		yp=0;
		oldXp=0;
		oldYp=0;
		d=4;
		
		obstaclesList = new ArrayList<Integer>();
		
		// remove first and last letter
		obstacles=obstacles.substring(1, obstacles.length()-1);
		
		String[] pairs = obstacles.split("\\)\\(");
		
		for (int i=0; i<pairs.length; i++) {
			String[] pair = pairs[i].split(",");
			obstaclesList.add(Integer.parseInt(pair[0]));			
			obstaclesList.add(Integer.parseInt(pair[1]));
		}				
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use:explorer.getX()
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
	}
	
	public void exexuteOneCommand(char c) {
		// direction of the explorer (1=east, 2=south, 3=west, 4=north)
		this.oldXp=xp;
		this.oldYp=yp;
		switch(d) {
		case 1:
			if(c=='r')
				d=2;
			if(c=='l')
				d=4;
			if(c=='f'&&!NoBoarder())
				xp+=1;
			if(c=='b'&&!NoBoarder())
				xp-=1;			
		break;
		case 2:
			if(c=='r')
				d=3;
			if(c=='l')
				d=1;
			if(c=='f'&&!NoBoarder())
				yp-=1;
			if(c=='b'&&!NoBoarder())
				yp+=1;			
		break;
		case 3:
			if(c=='r')
				d=4;
			if(c=='l')
				d=2;
			if(c=='f'&&!NoBoarder())
				xp-=1;
			if(c=='b'&&!NoBoarder())
				xp+=1;
		break;
		case 4:
			if(c=='r')
				d=1;
			if(c=='l')
				d=3;
			if(c=='f'&&!NoBoarder())
				yp+=1;
			if(c=='b'&&!NoBoarder())
				yp-=1;			
		break;
		default:
			System.out.println("Error Invalid direction");
		}
		NoObstacle();
	}
	
	public boolean NoBoarder() {
		if(xp==x||yp==y) {
			System.out.println("Invalid move, Explorer cross the border");
			xp=oldXp;
			yp=oldYp;
		
			return true;
		}
		return false;
	}
	
	public boolean NoObstacle() {
		for(int i=0; i<obstaclesList.size(); i+=2) {
			if(xp==obstaclesList.get(i)&&yp==obstaclesList.get(i+1)) {
				System.out.println("Invalid move, Explorer cross tNoObstacle()NoObstacle()he obstacle");
				xp=oldXp;
				yp=oldYp;
			}
			return false;
		}
		return false;
	}
	
	public String executeCommand(String command){
		char [] commands = command.toCharArray();
		
		for(int i=0; i<commands.length; i++) {
			exexuteOneCommand(commands[i]);
			System.out.println("(" + xp + "," + + yp + ")" + " d= " +d);
		}
		
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		return "(" + xp +"," + yp + ")" + "Richtung: " + d + "valid Move";
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public ArrayList getObstaclesList() {
		return obstaclesList;
	}
}
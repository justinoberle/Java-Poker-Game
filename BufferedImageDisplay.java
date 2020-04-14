package poker;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// create image from getpaths now


public class BufferedImageDisplay {
	
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static int height = screenSize.height * 2 / 3;
    private static int width = screenSize.width * 2 / 3;
	
	// Parameter flocation: resource location
	private BufferedImage preloadImage(String flocation){
	    BufferedImage bufimg = null;
//	    System.out.println("Attempting to load image: '" + flocation + "'");

	    try {
	        bufimg = ImageIO.read(new File(flocation));
	    } catch(IOException e){
	        System.err.println(
	                "An error occurred while attempting to load '" + flocation + "'");

	        return null;
	    }

	    // Now store this somewhere safe!
	    return bufimg;
	}
	
	private BufferedImage[][] getWCImageList(){
		BufferedImage bufferedImageArray[][] = new BufferedImage[Poker.numberPlayers][2];
		List<List<String>> pathsList = new ArrayList<List<String>>();
		pathsList = cardStringsTwoDList(RunGameLoop.hand.getWholeCards());
		for(int i = 0; i < pathsList.size(); i++) {
			for(int j = 0; j < pathsList.get(i).size(); j++) {
				bufferedImageArray[i][j] = getImageFromString(pathsList.get(i).get(j));
			}
		}
		return bufferedImageArray;
		
	}
	private BufferedImage[] getFlopImageList(){
		BufferedImage bufferedImageArray[] = new BufferedImage[3];
		List<String> pathsList = new ArrayList<String>();
		pathsList = cardStringsOneDList(RunGameLoop.hand.getFlop());
		for(int i = 0; i < pathsList.size(); i++) {
			bufferedImageArray[i] = getImageFromString(pathsList.get(i));
		}
		return bufferedImageArray;
	}	
	
	private BufferedImage getImageFromString(String path) {
		BufferedImageDisplay image2 = new BufferedImageDisplay();
		BufferedImage image = image2.preloadImage(path);
		return image;
	}
	
	private List<List<String>> cardStringsTwoDList(List<List<String>> TwoDList){
		// converts wholeCards into paths where the images are located and put them all in a 2d list
		List<List<String>> playerCardPaths = new ArrayList<List<String>>();
		if (Poker.numberPlayers >= 1) {		
			for (int i = 0; i < TwoDList.size(); i++) {
				List<String> cards = new ArrayList<String>();
				for (int j = 0; j < TwoDList.get(i).size(); j++) {
					cards.add("C:\\Java_Programs\\Images\\" + TwoDList.get(i).get(j) + ".png");
				}
				playerCardPaths.add(cards);
			}
		}else {
			playerCardPaths.add(null);
		}
		return playerCardPaths;
	}
	
	private List<String> cardStringsOneDList(List<String> oneDList){
		// converts wholeCards into paths where the images are located and put them all in a 2d list
		List<String> playerCardPaths = new ArrayList<String>();
		if (Poker.numberPlayers >= 1) {		
			for (int i = 0; i < oneDList.size(); i++) {
				playerCardPaths.add("C:\\Java_Programs\\Images\\" + oneDList.get(i) + ".png");
			}
		}else {
			playerCardPaths.add(null);
		}
		return playerCardPaths;
	}
	
	private String cardString(String string){
		// converts wholeCards into paths where the images are located and put them all in a 2d list
		String playerCardPath = new String();
		if (Poker.numberPlayers >= 1) {		
			playerCardPath = ("C:\\Java_Programs\\Images\\" + string + ".png");
		}else {
			playerCardPath = null;
		}
		return playerCardPath;
	}
	
	private JFrame frame = new JFrame("Live Poker Game");
	
	public JFrame getFrame() {
		return frame;
	}
	public static void shuffleDealImage() {
		BufferedImageDisplay frameObject = new BufferedImageDisplay();
		JFrame frame = frameObject.getFrame();
		BufferedImageDisplay table2 = new BufferedImageDisplay();

		BufferedImage table = table2.getImageFromString("C:\\Java_Programs\\Images\\Table.png");

		JLabel Jtable = new JLabel(new StretchIcon(table));
		// Create JFrame and add everything to it to display
		

		JButton shuffleDealButton = new JButton();

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setContentPane(Jtable);
	    frame.setBackground(Color.white);
	    frame.getContentPane().setPreferredSize(new Dimension(width, height));
	    frame.pack();
	    frame.setLocationRelativeTo(null);

	    shuffleDealButton.setLocation(340, 240);
	    shuffleDealButton.setSize(250, 40);
	    shuffleDealButton.setFont(new Font("Arial", Font.BOLD, 20));
	    shuffleDealButton.setText("Shuffle up and Deal!");
	    frame.add(shuffleDealButton);
	  	frame.setResizable(false);
	  	frame.setLayout(null);
	  	frame.setVisible(true);
	    shuffleDealButton.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  RunGameLoop.runGame(1);
	    	  createImage(frame);
	    	  frame.remove(shuffleDealButton);
	      }
	    });


	}
	
	public static void createImage(JFrame frame) {
		// set card locations for each player
		int cardHeight = screenSize.height * 1/7;
		int cardWidth = screenSize.width * 1/20;
		List<Integer> player1 = Arrays.asList(550, 0, 550+cardWidth+2, 0);
		List<Integer> player2 = Arrays.asList(690, 100, 690+cardWidth+2, 100);
		List<Integer> player3 = Arrays.asList(730, 220, 730+cardWidth+2, 220);
		List<Integer> player4 = Arrays.asList(680, 340, 680+cardWidth+2, 340);
		List<Integer> player5 = Arrays.asList(490, 380, 490+cardWidth+2, 380);
		List<Integer> player6 = Arrays.asList(290, 380, 290+cardWidth+2, 380);
		List<Integer> player7 = Arrays.asList(90, 340, 90+cardWidth+2, 340);
		List<Integer> player8 = Arrays.asList(40, 220, 40+cardWidth+2, 220);
		List<Integer> player9 = Arrays.asList(80, 100, 80+cardWidth+2, 100);
		List<Integer> player10 = Arrays.asList(220, 0, 220+cardWidth+2, 0);
		List<List<Integer>> playersAll = new ArrayList<List<Integer>>();
		playersAll.add(player1); playersAll.add(player2); playersAll.add(player3); playersAll.add(player4); playersAll.add(player5);
		playersAll.add(player6); playersAll.add(player7); playersAll.add(player8); playersAll.add(player9); playersAll.add(player10);
		
		// Create Buffered Image
		BufferedImageDisplay cards2 = new BufferedImageDisplay();
		BufferedImageDisplay flopCards2 = new BufferedImageDisplay();
		BufferedImageDisplay turnCard2 = new BufferedImageDisplay();
		BufferedImageDisplay riverCard2 = new BufferedImageDisplay();
		BufferedImage[][] cards = cards2.getWCImageList();
		BufferedImage[] flopCards = flopCards2.getFlopImageList();
		BufferedImageDisplay cardStringTurn = new BufferedImageDisplay();
		BufferedImageDisplay cardStringRiver = new BufferedImageDisplay();
		BufferedImage turnCard = turnCard2.getImageFromString(cardStringTurn.cardString(RunGameLoop.hand.getTurn()));
		BufferedImage riverCard = riverCard2.getImageFromString(cardStringRiver.cardString(RunGameLoop.hand.getRiver()));
		
		// Create JLabel
		
		JLabel[][] Jcards = new JLabel[Poker.numberPlayers][2];
		for (int i = 0; i < Poker.numberPlayers; i++) {
			
			for(int j = 0; j < 2; j ++) {
				Jcards[i][j] = new JLabel(new StretchIcon(cards[i][j]));
			}
		}
		JLabel[] JFlopCards = new JLabel[3];
		for (int i = 0; i < 3; i++) {			
			JFlopCards[i] = new JLabel(new StretchIcon(flopCards[i]));
		}
		JLabel JTurnCard = new JLabel(new StretchIcon(turnCard));
		JLabel JRiverCard = new JLabel(new StretchIcon(riverCard));

		// Create JButtons for each player
		JButton[] button = new JButton[Poker.numberPlayers];
		for(int i = 0; i < Poker.numberPlayers; i ++) {
			button[i] = new JButton();
		}
		JButton showFlopButton = new JButton();
		JButton showTurnButton = new JButton();
		JButton showRiverButton = new JButton();
		JButton newGameButton = new JButton();
		
	    for(int i = 0; i < Poker.numberPlayers; i++) {
	    		
	    	Jcards[i][0].setLocation(playersAll.get(i).get(0), playersAll.get(i).get(1));
	    	Jcards[i][0].setSize(cardWidth,  cardHeight);
	    	frame.add(Jcards[i][0]);
	    	Jcards[i][1].setLocation(playersAll.get(i).get(2), playersAll.get(i).get(3));
	    	Jcards[i][1].setSize(cardWidth,  cardHeight);
	    	frame.add(Jcards[i][1]);
	    	button[i].setLocation(playersAll.get(i).get(2)-40, playersAll.get(i).get(1) + 100);
	    	button[i].setSize(80, 20);
	    	button[i].setFont(new Font("Arial", Font.PLAIN, 10));
	    	button[i].setText("Player " + (i+1));
	    	frame.add(button[i]);
	    }
	    showFlopButton.setLocation(380, 240);
	    showFlopButton.setSize(150, 40);
	    showFlopButton.setFont(new Font("Arial", Font.PLAIN, 15));
	    showFlopButton.setText("Deal Flop");
	    frame.add(showFlopButton);
		  	frame.setResizable(false);
		  	frame.setLayout(null);
		  	frame.setVisible(true);
	    
	    // Display flop on click of button
	    showFlopButton.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  //display flop now
	    	  int x = 345;
	    	  int y = 200;
	    	  for(int i = 0; i < 3; i++) {
	    		  JFlopCards[i].setLocation(x, y);
	    		  JFlopCards[i].setSize(cardWidth,  cardHeight);
	    		  frame.add(JFlopCards[i]);
	    		  x += cardWidth + 10;
	    	  }
  	  	      showTurnButton.setLocation(380, 320);
  	  	      showTurnButton.setSize(150, 40);
  	  	      showTurnButton.setFont(new Font("Arial", Font.PLAIN, 15));
  	  	      showTurnButton.setText("Deal Turn");
  		      frame.add(showTurnButton);
    		  frame.setResizable(false);
    		  frame.setLayout(null);
    		  frame.setVisible(true);
    		  frame.remove(showFlopButton);
	      }
	    });
	    
	    // Display turn on click of button
	    showTurnButton.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  // Redisplay flop and display turn now
	    	  int x = 300;
	    	  int y = 200;
	    	  for(int i = 0; i < 3; i++) {
	    		  JFlopCards[i].setLocation(x, y);
	    		  JFlopCards[i].setSize(cardWidth,  cardHeight);
	    		  frame.add(JFlopCards[i]);
	    		  x += cardWidth + 10;
	    	  }
	    	  JTurnCard.setLocation(x, y);
	    	  JTurnCard.setSize(cardWidth,  cardHeight);
	    	  frame.add(JTurnCard);
	    	  showRiverButton.setLocation(380, 320);
	    	  showRiverButton.setSize(150, 40);
	    	  showRiverButton.setFont(new Font("Arial", Font.PLAIN, 15));
	    	  showRiverButton.setText("Deal River");
  		      frame.add(showRiverButton);
    		  frame.setResizable(false);
    		  frame.setLayout(null);
    		  frame.setVisible(true);
    		  frame.remove(showTurnButton);
	      }
	    });
	    
	    // Display river on click of button
	    showRiverButton.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  // Redisplay flop and turn and display river
	    	  int x = 265;
	    	  int y = 200;
	    	  for(int i = 0; i < 3; i++) {
	    		  JFlopCards[i].setLocation(x, y);
	    		  JFlopCards[i].setSize(cardWidth,  cardHeight);
	    		  frame.add(JFlopCards[i]);
	    		  x += cardWidth + 10;
	    	  }
	    	  JTurnCard.setLocation(x, y);
	    	  JTurnCard.setSize(cardWidth,  cardHeight);
	    	  frame.add(JTurnCard);
	    	  x += cardWidth + 10;
	    	  JRiverCard.setLocation(x, y);
	    	  JRiverCard.setSize(cardWidth,  cardHeight);
	    	  frame.add(JRiverCard);
	    	  newGameButton.setLocation(380, 320);
	    	  newGameButton.setSize(150, 40);
	    	  newGameButton.setFont(new Font("Arial", Font.PLAIN, 15));
	    	  newGameButton.setText("Deal New Game");
  		      frame.add(newGameButton);   
  		      frame.setResizable(false);
    		  frame.setLayout(null);
    		  frame.setVisible(true);
    		  frame.remove(showRiverButton);
	      }
	    });
	    
	    // Display river on click of button
	    newGameButton.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  // ReRun everything now
	    	  frame.dispose();
	    	  shuffleDealImage();
	    	  
	      }
	    });
	}
	

	
	
}

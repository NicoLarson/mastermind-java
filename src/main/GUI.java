package main;

import data_structure.Jeton_couleur;
import data_structure.Row;
import graphics.MastermindRenderer;
import graphics.ToursModel;
import graphics.ToursRenderer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class GUI extends JFrame implements ActionListener {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private JFrame mainFrame;
  private JTable reponses, indicators, tours;
  private ToursModel compteur = new ToursModel();
  private ToursRenderer tourRender;
  int retour;

  private JButton color_buttons[], prop_buttons[], clear, submit;
  private Color selectedColor;
  private int selectedColumn;
  Game theGame;

  // Fonction qui initialise l'interface graphique
  // Ne touchez pas � cette fonction
  public void initializeBoard() {
    // Initialize game data
    theGame = new Game();

    /*** Frame instantiation ***/
    mainFrame = new JFrame();
    mainFrame.getContentPane().setLayout(new FlowLayout());
    mainFrame.setTitle("Mastermind");
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize(590, 455);
    mainFrame.setLocationRelativeTo(null);

    /*** Panel instantiation ***/

    // Panel for answer buttons
    JPanel answerPanel = new JPanel();
    // Panel for color buttons
    JPanel colorPanel = new JPanel();

    // Panel grouping two previous button panels
    JPanel buttons = new JPanel();

    FlowLayout globalColorLayout = new FlowLayout();
    JPanel globalColorPanel = new JPanel();
    globalColorPanel.setLayout(globalColorLayout);
    globalColorPanel.add(colorPanel);
    globalColorLayout.setHgap(5);
    globalColorLayout.setVgap(8);
    colorPanel.setPreferredSize(new Dimension(180, 110));

    buttons.add(globalColorPanel);
    buttons.add(answerPanel);

    // Panels for historic guessing
    JPanel histoIndicPanel = new JPanel();
    JPanel histoColorPanel = new JPanel();

    // Counter
    JPanel counter = new JPanel();

    /*** Layout instantiation ***/
    GridLayout gridColor, gridButtons;
    gridButtons = new GridLayout(2, 1);

    // GridLayout for color buttons
    gridColor = new GridLayout(2, 3);
    gridColor.setHgap(7);
    gridColor.setVgap(7);

    colorPanel.setLayout(gridColor);
    buttons.setLayout(gridButtons);

    /*** Elements initialization ***/

    // JTables
    reponses = new JTable(theGame.reponses_data);
    reponses.setPreferredSize(new Dimension(250, 200));
    reponses.setIntercellSpacing(new Dimension(8, 8));
    reponses.setShowGrid(false);
    reponses.setRowHeight(20);

    indicators = new JTable(theGame.indicators_data);
    indicators.setPreferredSize(new Dimension(150, 200));
    indicators.setIntercellSpacing(new Dimension(18, 12));
    indicators.setShowGrid(false);
    indicators.setRowHeight(20);

    tours = new JTable(this.compteur);
    tours.setPreferredSize(new Dimension(30, 200));
    tourRender = new ToursRenderer(mainFrame.getBackground());
    tourRender.setHorizontalAlignment(JLabel.CENTER);
    tours.setDefaultRenderer(String.class, tourRender);
    tours.setIntercellSpacing(new Dimension(10, 10));
    tours.setRowHeight(20);
    tours.setShowGrid(false);
    tours.setOpaque(false);

    reponses.setDefaultRenderer(String.class, new MastermindRenderer());
    indicators.setDefaultRenderer(String.class, new MastermindRenderer());

    /** Buttons **/
    // Contains all the buttons
    color_buttons = new JButton[6];
    prop_buttons = new JButton[4];

    // Color buttons
    for (int x = 0; x < 6; x++) {
      color_buttons[x] = new JButton(Jeton_couleur.getUSED_COLORS().get(x));
      color_buttons[x].addActionListener(this);
      color_buttons[x].setBackground(Jeton_couleur.getColors()[x]);
      color_buttons[x].setForeground(Jeton_couleur.getColors()[x]);
      color_buttons[x].setActionCommand(Jeton_couleur.getUSED_COLORS().get(x));
      color_buttons[x].setPreferredSize(new Dimension(20, 27));
      colorPanel.add(color_buttons[x]);
    }

    // CLEAR button
    clear = new JButton("CLEAR");
    clear.addActionListener(this);
    clear.setBackground(Color.WHITE);
    clear.setActionCommand("CLEAR");
    clear.setPreferredSize(new Dimension(100, 27));
    answerPanel.add(clear);

    // Answer buttons
    for (int y = 0; y < 4; y++) {
      prop_buttons[y] = new JButton("" + (y + 1));
      prop_buttons[y].addActionListener(this);
      prop_buttons[y].setBackground(Color.LIGHT_GRAY);
      prop_buttons[y].setActionCommand("" + (y + 1));
      prop_buttons[y].setPreferredSize(new Dimension(60, 27));
      answerPanel.add(prop_buttons[y]);
    }

    // SUBMIT button
    submit = new JButton("SUBMIT");
    submit.addActionListener(this);
    submit.setBackground(Color.WHITE);
    submit.setActionCommand("SUBMIT");
    submit.setPreferredSize(new Dimension(100, 27));
    answerPanel.add(submit);

    // Add elements to Panel
    histoIndicPanel.add(indicators);
    histoIndicPanel.setBorder(new TitledBorder("Indices"));
    histoColorPanel.add(reponses);
    histoColorPanel.setBorder(new TitledBorder("Propositions"));
    counter.add(tours);
    counter.setBorder(new TitledBorder("Tour"));

    /*** Initialize selected variables ***/

    // LIGHT_GRAY is the default color, corresponding to no button
    selectedColor = Color.LIGHT_GRAY;
    // No column is selected
    selectedColumn = -1;

    /*** Add all elements to the frame ***/

    mainFrame.getContentPane().add(histoIndicPanel);
    mainFrame.getContentPane().add(counter);
    mainFrame.getContentPane().add(histoColorPanel);
    mainFrame.getContentPane().add(buttons);
    mainFrame.setVisible(true);
  }

  // Cette m�thode termine le jeu (soit en cas de succ�s, soit en cas d'�chec)
  public void endGame() {
    this.mainFrame.dispose();
    if (this.retour == JOptionPane.OK_OPTION) {
      this.initializeBoard();
    } else {
      System.exit(0);
    }
  }

  /*
   * M�thode actionPerformed
   * Cette m�thode est appel�e lorsqu'un bouton est cliqu�. ActionEvent e pass� en
   * param�tre contient une chaine de caract�re contenant le nom du bouton
   */
  /*
   * A COMPLETER : compl�ter les parties manquantes de cette fonction en suivant
   * les commentaires. Vous devez compl�ter la partie consacr�e au clique sur le
   * bouton SUBMIT, c'est � dire lorsque le joueur fait une proposition
   */
  public void actionPerformed(ActionEvent e) {
    /* Clique sur le bouton clear */
    // Ne pas toucher
    if ("CLEAR".equals(e.getActionCommand())) {
      for (int x = 0; x < 4; x++) {
        prop_buttons[x].setBackground(Color.LIGHT_GRAY);
      }
      theGame.initProposition();
      selectedColumn = -1;
      selectedColor = Color.LIGHT_GRAY;
    } else if ("SUBMIT".equals(e.getActionCommand())) {
      /* Clique sur le bouton submit */
      // A COMPLETER
      // SI la proposition est incomplete (utilisez des m�thodes de la classe Row et Game via l'attribut theGame)
      if (!theGame.getProposition().complete()) {
        // Afficher un message sur l'inteface graphique indiquant que la proposition est incompl�te
        JOptionPane.showMessageDialog(
          mainFrame,
          "Votre proposition est incomplète, les quatres places doivent être colorées. \nCliquez sur OK pour continuer."
        );
      } // SINON
      else {
        //Modifiez la valeur indiquant le num�ro du prochain tour gr�ce � l'instruction: tourRender.setTour(theGame.getCounter()+2);
        tourRender.setTour(theGame.getCounter() + 2);
        // Indiquez � l'interface graphique qu'elle doit se mettre � jour gr�ce � l'instruction : compteur.fireTableDataChanged();
        compteur.fireTableDataChanged();
        //�valuer la proposition du joueur (appelez la m�thode que vous venez de coder dans la classe Game)
        // SI l'�valuation � renvoyez true
        if (theGame.evalProposition()) {
          // Affichez un message avec une question ferm�e, indiquant au joueur qu'il a trouv� la solution, et demandez lui si il veut rejouer. (Vous pouvez ajouter � ce message des informations comme le nombre de tours mis pour trouver le code)
          // !! N'oubliez pas de r�cuperer dans l'attribut this.retour ce que renvoi la m�thode appel�e pour afficher la question ferm�e !!
          this.retour =
            JOptionPane.showConfirmDialog(
              mainFrame,
              " Vous avez trouvé la solution en " +
              theGame.getCounter() +
              " coups. Voulez-vous rejouer ?",
              "Félicitation !",
              JOptionPane.YES_NO_OPTION
            );

          // Appelez la m�thode permettant de terminer le jeu
          this.endGame();
        }
        // SINON
        else {
          // SI le compteur de tour de l'attribut theGame a atteint ou d�pass� 10
          if (theGame.getCounter() >= 10) {
            // Afficher un message avec question ferm�e, indiquant au joueur qu'il a perdu,
            this.retour =
              JOptionPane.showConfirmDialog(
                mainFrame,
                "Vous avez perdu, voulez-vous rejouer ?",
                "Perdu !",
                JOptionPane.YES_NO_OPTION
              );
            // Appelez la m�thode permettant de terminer le jeu et lui proposant de rejouer.
            this.endGame();
            // FIN SI
          }
          // FIN SI
        }
        // FIN SI
      }
    } else {
      /* Clique sur un bouton pour construire la proposition */
      // Ne pas toucher
      if (Jeton_couleur.getUSED_COLORS().contains(e.getActionCommand())) {
        selectedColor =
          Jeton_couleur.getColors()[Jeton_couleur
              .getUSED_COLORS()
              .indexOf(e.getActionCommand())];
      } else if (Row.getColorPositions().contains(e.getActionCommand())) {
        selectedColumn = Integer.parseInt(e.getActionCommand());
      }

      if (selectedColumn != -1 && !(selectedColor.equals(Color.LIGHT_GRAY))) {
        prop_buttons[selectedColumn - 1].setBackground(selectedColor);
        System.out.println(
          "set " +
          (selectedColumn - 1) +
          " -> " +
          Jeton_couleur
            .getUSED_COLORS()
            .get(Jeton_couleur.colorToInt(selectedColor))
        );
        theGame
          .getProposition()
          .rowSet(
            new Jeton_couleur(Jeton_couleur.colorToInt(selectedColor)),
            selectedColumn - 1
          );
        System.out.println(theGame.getProposition());
        selectedColumn = -1;
      }
    }
  }

  public static void main(String[] args) {
    GUI newInterface = new GUI();
    newInterface.initializeBoard();
  }
}

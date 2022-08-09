package com.company;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class WordleGame implements ActionListener{

    class WordPanel extends JPanel{

        JLabel[] wordColumns= new JLabel[5];
        public WordPanel() {
            this.setLayout(new GridLayout(1,5));
            Border blackBorder =BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            for(int i=0;i<5;i++) {
                wordColumns[i]= new JLabel();
                wordColumns[i].setHorizontalAlignment(JLabel.CENTER);
                wordColumns[i].setOpaque(true);
                wordColumns[i].setBorder(blackBorder);
                this.add(wordColumns[i]);
            }
        }

        public void clearWordPanel() {
            for(int i=0;i<5;i++) {
                wordColumns[i].setText("");
            }

        }

        public void setPanelText(String charValue, int position, Color color) {
            this.wordColumns[position].setText(charValue);
            this.wordColumns[position].setBackground(color);
        }
    }
    class UserPanel extends JPanel{

        private JTextField userInput;
        private JButton okButton;

        public UserPanel() {
            this.setLayout(new GridLayout(1,2));
            userInput= new JTextField();
            okButton= new JButton ("ENTER");
            this.add(userInput);
            this.add(okButton);
        }

        public void addUserText(String text){
            String text1 = userInput.getText() + text;
            userInput.setText(text1);
        }

        public JTextField getUserInput() {
            return userInput;
        }

        public void setUserInput(JTextField userInput) {
            this.userInput = userInput;
        }

        public JButton getOkButton() {
            return okButton;
        }

        public void setOkButton(JButton okButton) {
            this.okButton = okButton;
        }
    }

    class KeyboardPanel extends JPanel{
        public JButton q = new JButton("Q");
        public JButton w = new JButton("W");
        public JButton e = new JButton("E");
        public JButton r = new JButton("R");
        public JButton t = new JButton("T");
        public JButton y = new JButton("Y");
        public JButton u = new JButton("U");
        public JButton ı = new JButton("I");
        public JButton o = new JButton("O");
        public JButton p = new JButton("P");
        public JButton ğ = new JButton("Ğ");
        public JButton ü = new JButton("Ü");
        public JButton a = new JButton("A");
        public JButton s = new JButton("S");
        public JButton d = new JButton("D");
        public JButton f = new JButton("F");
        public JButton g = new JButton("G");
        public JButton h = new JButton("H");
        public JButton j = new JButton("J");
        public JButton k = new JButton("K");
        public JButton l = new JButton("L");
        public JButton ş = new JButton("Ş");
        public JButton i = new JButton("İ");
        public JButton z = new JButton("Z");
        public JButton x = new JButton("X");
        public JButton c = new JButton("C");
        public JButton v = new JButton("V");
        public JButton b = new JButton("B");
        public JButton n = new JButton("N");
        public JButton m = new JButton("M");
        public JButton ö = new JButton("Ö");
        public JButton ç= new JButton("Ç");

        public KeyboardPanel() {
            this.add(q);
            this.add(w);
            this.add(e);
            this.add(r);
            this.add(t);
            this.add(y);
            this.add(u);
            this.add(ı);
            this.add(o);
            this.add(p);
            this.add(ğ);
            this.add(ü);
            this.add(a);
            this.add(s);
            this.add(d);
            this.add(f);
            this.add(g);
            this.add(h);
            this.add(j);
            this.add(k);
            this.add(l);
            this.add(ş);
            this.add(i);
            this.add(z);
            this.add(x);
            this.add(c);
            this.add(v);
            this.add(b);
            this.add(n);
            this.add(m);
            this.add(ö);
            this.add(ç);
        }
    }

    private JFrame gameFrame;
    private WordPanel[] wordPanelArray= new WordPanel[5];
    private UserPanel userPanel;
    private KeyboardPanel keyboardPanel;
    private String wordleString;
    private int count=0;

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    Date date = new Date();

    public WordleGame() {
        gameFrame=new JFrame(dateFormat.format(date));
        gameFrame.setSize(900,900);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLayout(new GridLayout(7,1));
        gameFrame.setVisible(true);
        gameFrame.setLocationRelativeTo(null);

        for(int i=0;i<5;i++) {
            wordPanelArray[i]=new WordPanel();
            gameFrame.add(wordPanelArray[i]);

        }
        userPanel=new UserPanel();
        userPanel.getOkButton().addActionListener(this);
        keyboardPanel = new KeyboardPanel();
        keyboardPanel.q.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("Q");
            }
        });
        keyboardPanel.w.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("W");
            }
        });
        keyboardPanel.e.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("E");
            }
        });
        keyboardPanel.r.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("R");
            }
        });
        keyboardPanel.t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("T");
            }
        });
        keyboardPanel.y.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("Y");
            }
        });
        keyboardPanel.u.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("U");
            }
        });
        keyboardPanel.ı.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("I");
            }
        });
        keyboardPanel.o.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("O");
            }
        });
        keyboardPanel.p.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("P");
            }
        });
        keyboardPanel.ğ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("Ğ");
            }
        });
        keyboardPanel.ü.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("Ü");
            }
        });
        keyboardPanel.a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("A");
            }
        });
        keyboardPanel.s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("S");
            }
        });
        keyboardPanel.d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("D");
            }
        });
        keyboardPanel.f.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("F");
            }
        });
        keyboardPanel.g.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("G");
            }
        });
        keyboardPanel.h.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("H");
            }
        });
        keyboardPanel.j.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("J");
            }
        });
        keyboardPanel.k.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("K");
            }
        });
        keyboardPanel.l.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("L");
            }
        });
        keyboardPanel.ş.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("Ş");
            }
        });
        keyboardPanel.i.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("İ");
            }
        });
        keyboardPanel.z.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("Z");
            }
        });
        keyboardPanel.x.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("X");
            }
        });
        keyboardPanel.c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("C");
            }
        });
        keyboardPanel.v.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("V");
            }
        });
        keyboardPanel.b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("B");
            }
        });
        keyboardPanel.n.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("N");
            }
        });
        keyboardPanel.m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("M");
            }
        });
        keyboardPanel.ö.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("Ö");
            }
        });
        keyboardPanel.ç.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userPanel.addUserText("Ç");
            }
        });
        gameFrame.add(keyboardPanel);
        gameFrame.add(userPanel);
        gameFrame.revalidate();

        wordleString= getWordleString();
        System.out.println("Word for the day: "+wordleString);


    }

    public void writeScore(int count) throws IOException {
        int result = 1000 - count*200;
        String s=Integer.toString(result);
        RandomAccessFile raf = new RandomAccessFile(new File("score.txt"), "rw");
        if(result > getScore()) {
            raf.setLength(0);
            raf.seek(raf.length());
            raf.writeBytes(s);
            raf.writeBytes("\n");
            raf.close();
        }
    }

    public int getScore() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("score.txt"), "r");
        int score;
        if(raf.length()==0) {
            score = 0;
        }
        else {
            raf.seek(0);
            score = raf.readInt();
        }
        raf.close();
        System.out.println(score);
        return score;
    }

    public void showAnimation(String gifName, String message) throws Exception {

        ImageIcon icon = new ImageIcon(getClass().getResource(gifName));
        JLabel label = new JLabel(icon);
        String s=Integer.toString(getScore());
        label.setText(s);

        gameFrame.removeAll();
        gameFrame.pack();
        gameFrame.setVisible(false);
        gameFrame.dispose();

        JFrame animationFrame = new JFrame(message);
        animationFrame.setSize(500,500);
        animationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        animationFrame.setLayout(new BorderLayout());
        animationFrame.setVisible(true);
        animationFrame.getContentPane().add(label);
        animationFrame.pack();
        animationFrame.setLocationRelativeTo(null);
        animationFrame.setVisible(true);
    }


    public static void main(String[] args) {

        new WordleGame();
    }

    public void submitWord() throws Exception {
        if(this.userPanel.getUserInput().getText().length() == 5) {
            String userWord= this.userPanel.getUserInput().getText();
            if(userWord.length()>4) {
                if(isWordleWordEqualTo(userWord.trim().toUpperCase())) {
                    clearAllPanels();
                    try {
                        this.showAnimation("/Users/gulce/IdeaProjects/WordleGame/src/win.gif","YOU WON!");
                    } catch (MalformedURLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    try {
                        this.writeScore(count);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    return;
                }

            }
            count++;
            if(count==5) {

                try {
                    this.showAnimation("/Users/gulce/IdeaProjects/WordleGame/src/lose.gif","YOU LOST!");
                } catch (MalformedURLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                try {
                    this.writeScore(0);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return;
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            submitWord();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    private void clearAllPanels() {
        for(int i=0;i<=count;i++) {
            wordPanelArray[i].clearWordPanel();
        }
    }
    private boolean isWordleWordEqualTo(String userWord) {
        List<String> wordleWordsList = Arrays.asList(wordleString.split(""));
        String[] userWordsArray = userWord.split("");
        List<Boolean> wordMatchesList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            if (wordleWordsList.contains(userWordsArray[i])) {
                if (wordleWordsList.get(i).equals(userWordsArray[i])) {
                    getActivePanel().setPanelText(userWordsArray[i], i, Color.green);
                    wordMatchesList.add(true);
                } else {
                    getActivePanel().setPanelText(userWordsArray[i], i, Color.yellow);
                    wordMatchesList.add(false);
                }
            } else {
                getActivePanel().setPanelText(userWordsArray[i], i, Color.gray);
                wordMatchesList.add(false);
            }
        }
        return !wordMatchesList.contains(false);
    }

    public WordPanel getActivePanel() {
        return this.wordPanelArray[count];
    }




    public String getWordleString() {
        Path path=Paths.get("src/words.txt");
        List<String> wordList=new ArrayList<>();
        try {
            wordList=Files.readAllLines(path);
        }catch(IOException e){
            e.printStackTrace();
        }
        Random random= new Random();
        int position = random.nextInt(wordList.size());
        return wordList.get(position).trim().toUpperCase();

    }

}




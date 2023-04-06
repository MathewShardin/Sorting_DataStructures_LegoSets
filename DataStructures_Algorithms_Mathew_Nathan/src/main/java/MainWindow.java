import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    public MainWindow() throws CsvValidationException {
        String dataSetFilePath = "src/main/resources/setsMid.csv";
        this.setSize(1200, 900);
        this.setTitle("Data Structures & Algorithms");
        this.setLayout(null);

        // create a label and add it to the top center of the window
        JLabel labelTitle = new JLabel("Data structures & algorithms");
        labelTitle.setBounds(300,10,600,60); //x-axis, y-axis, width, height
        labelTitle.setFont(new Font("Arial", Font.PLAIN, 40));
        this.add(labelTitle);

        //Create labels for all three data structures
        JLabel labelLinked = new JLabel("Linked List");
        JLabel labelArray = new JLabel("ArrayList");
        JLabel labelDouble = new JLabel("Doubly Linked List");
        labelLinked.setBounds(125, 60, 150, 50);
        labelArray.setBounds(525, 60, 150, 50);
        labelDouble.setBounds(925, 60, 150, 50);
        this.add(labelLinked);
        this.add(labelArray);
        this.add(labelDouble);

        //Make Buttons for Linked List
        JButton buttonLinkedBub = new JButton("BubbleSort");
        JButton buttonLinkedQui = new JButton("Quick Sort");
        JButton buttonLinkedJump = new JButton("Jump Search");
        JButton buttonLinkedBin = new JButton("Binary Search");
        buttonLinkedBub.setBounds(125,120,150, 50);
        buttonLinkedQui.setBounds(125,180,150, 50);
        buttonLinkedJump.setBounds(125,240,150, 50);
        buttonLinkedBin.setBounds(125,300,150, 50);
        this.add(buttonLinkedBub);
        this.add(buttonLinkedQui);
        this.add(buttonLinkedJump);
        this.add(buttonLinkedBin);

        //Make buttons for ArrayList
        JButton buttonArrayBub = new JButton("BubbleSort");
        JButton buttonArrayQui = new JButton("Quick Sort");
        JButton buttonArrayJump = new JButton("Jump Search");
        JButton buttonArrayBin = new JButton("Binary Search");
        buttonArrayBub.setBounds(525,120,150, 50);
        buttonArrayQui.setBounds(525,180,150, 50);
        buttonArrayJump.setBounds(525,240,150, 50);
        buttonArrayBin.setBounds(525,300,150, 50);
        this.add(buttonArrayBub);
        this.add(buttonArrayQui);
        this.add(buttonArrayJump);
        this.add(buttonArrayBin);

        //Make buttons for Doubly Linked List
        JButton buttonDoubleBub = new JButton("BubbleSort");
        JButton buttonDoubleQui = new JButton("Quick Sort");
        JButton buttonDoubleJump = new JButton("Jump Search");
        JButton buttonDoubleBin = new JButton("Binary Search");
        buttonDoubleBub.setBounds(925,120,150, 50);
        buttonDoubleQui.setBounds(925,180,150, 50);
        buttonDoubleJump.setBounds(925,240,150, 50);
        buttonDoubleBin.setBounds(925,300,150, 50);
        this.add(buttonDoubleBub);
        this.add(buttonDoubleQui);
        this.add(buttonDoubleJump);
        this.add(buttonDoubleBin);

        //Add keyword search input field
        JTextField textField = new JTextField("LegoSet name");
        textField.setBounds(500, 600, 200, 50);
        this.add(textField);
        JLabel keywordLabel = new JLabel("Search Set Name");
        keywordLabel.setBounds(500, 550, 200,50);
        this.add(keywordLabel);
        //Add reset button
        JButton resetButton = new JButton("Clear");
        resetButton.setBounds(500, 700, 200, 50);
        this.add(resetButton);

        LegoSet[] tempArray = CSVParser.parseCSVtoLegoSet(dataSetFilePath);
        //Parse data into custom ArrayList
        CustomArrayList<LegoSet> inputArrayList = new CustomArrayList<>();
        for (LegoSet set : tempArray) {
            inputArrayList.add(set);
        }
        //Parse data into custom Linked List
        LinkedList<LegoSet> inputLinkedList = new LinkedList<>();
        for (LegoSet set : tempArray) {
            inputLinkedList.insertLast(set);
        }
        //Parse data into custom Doubly Linked List


        String[] inputData = getArrayStringsLegoSets(inputArrayList);
        //Create input list
        JList listInput = new JList();
        listInput.setListData(inputData);
        JScrollPane scrollPaneInp = new JScrollPane(listInput);
        scrollPaneInp.setBounds(50, 400, 400, 400);
        this.add(scrollPaneInp);

        //Create output list
        JList listOutput = new JList();
        JScrollPane scrollPaneOut = new JScrollPane(listOutput);
        scrollPaneOut.setBounds(750, 400, 400, 400);
        this.add(scrollPaneOut);

        //---------------------------Button Handlers-------------------------------
        //Reset Button
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] arrOut = new String[1];
                arrOut[0] = "";
                listOutput.setListData(arrOut);

            }
        });

        //Linked list
        buttonLinkedBub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LinkedList<LegoSet> outputLinkedList = SortingTemp.bubbleSort(inputLinkedList);
                listOutput.setListData(getArrayStringsLegoSets(outputLinkedList));

            }
        });
        buttonLinkedQui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LinkedList<LegoSet> outputLinkedList = SortingTemp.sort(inputLinkedList);
                listOutput.setListData(getArrayStringsLegoSets(outputLinkedList));

            }
        });
        buttonLinkedJump.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Comparable<?> result = SearchTemp.jumpSearchLegoSetByName(textField.getText() ,inputLinkedList);
                listOutput.setListData(getArrayOneSearchResultString(result));
            }
        });
        buttonLinkedBin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Comparable<?> result = SearchTemp.binarySearchLegoSetByName(textField.getText() ,inputLinkedList);
                listOutput.setListData(getArrayOneSearchResultString(result));
            }
        });

        //Arraylist
        buttonArrayBub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomArrayList<LegoSet> outputArray = SortingTemp.bubbleSort(inputArrayList);
                listOutput.setListData(getArrayStringsLegoSets(outputArray));

            }
        });
        buttonArrayQui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomArrayList<LegoSet> outputArray = SortingTemp.sort(inputArrayList);
                listOutput.setListData(getArrayStringsLegoSets(outputArray));

            }
        });
        buttonArrayJump.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Comparable<?> result = SearchTemp.jumpSearchLegoSetByName(textField.getText(), inputArrayList);
                listOutput.setListData(getArrayOneSearchResultString(result));
            }
        });
        buttonArrayBin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Comparable<?> result = SearchTemp.binarySearchLegoSetByName(textField.getText(), inputArrayList);
                listOutput.setListData(getArrayOneSearchResultString(result));
            }
        });

        //Doubly Linked List

        //--------------------------------------------------------------------------






        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public <T extends Swappable> Comparable<?>[] getArrayFromGeneric(T collection) {
        Comparable<?>[] arrayOut = new Comparable<?>[collection.size()];
        for (int i = 0; i < collection.size(); i++) {
            arrayOut[i] = collection.get(i);
        }
        return arrayOut;
    }

    public <T extends Swappable> LegoSet[] getArrayLegoSets(T collection) {
        Comparable<?>[] setOut = getArrayFromGeneric(collection);
        LegoSet[] arrayOut = new LegoSet[collection.size()];
        int counter = 0;
        for (Comparable<?> set : setOut) {
            LegoSet setTemp = (LegoSet) set;
            arrayOut[counter] = setTemp;
            counter++;
        }
        return arrayOut;
    }

    public <T extends Swappable> String[] getArrayStringsLegoSets(T collection) {
        Comparable<?>[] setOut = getArrayFromGeneric(collection);
        String[] arrayOut = new String[collection.size()];
        int counter = 0;
        for (Comparable<?> set : setOut) {
            LegoSet setTemp = (LegoSet) set;
            String setString = setTemp.getName() + " " + setTemp.getYearOfRelease() + " " + setTemp.getNum_of_parts();
            arrayOut[counter] = setString;
            counter++;
        }
        return arrayOut;
    }

    public <T extends Comparable> String[] getArrayOneSearchResultString(T result) {
        LegoSet setResult = (LegoSet) result;
        String[] arrayOut = new String[1];
        String setString = setResult.getName() + " " + setResult.getYearOfRelease() + " " + setResult.getNum_of_parts();
        arrayOut[0] = setString;
        return arrayOut;
    }


}

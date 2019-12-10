package GUI;

import VideoLogTracker.Tracker;
import org.json.JSONArray;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Set;

public class FileBrowser extends JFrame {
    private JTable jTable_Files_Name;
    private JScrollPane jScrollPane1;

    private Tracker tracker = new Tracker("VideoLocations.json");


    public FileBrowser()
    {
        checkForDeletedFiles();
        initComponents();
        style();
        this.setVisible(true);
    }

    private void style() {
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(".\\src\\GUI\\images\\icon.png");
        setIconImage(icon);//Frame should set the logo to the icon.png file but has yet to be completed.
        setTitle("Video Explorer");
        jTable_Files_Name.setBackground(Color.WHITE);
        Font label = new Font("Century Gothic", Font.PLAIN, 11);
        jTable_Files_Name.setFont(label);
        jScrollPane1.setBackground(Color.WHITE);
    }

    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jTable_Files_Name = new JTable();

        jTable_Files_Name.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }

        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        });
        jScrollPane1.setViewportView(jTable_Files_Name);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
        );
        pack();
        addTrackerInfo();

        jTable_Files_Name.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2)
                {
                    JTable target = (JTable) e.getSource();
                    int location = target.getSelectedRow();
                    String file_location = (String) jTable_Files_Name.getModel().getValueAt(location, 0);
                    String file_name = (String) jTable_Files_Name.getModel().getValueAt(location, 1);
                    try {
                        System.out.println(file_location + file_name);
                        Desktop.getDesktop().open(new File(file_location + file_name));
                    } catch (IOException ex) {
                        System.out.println("File may have been moved or deleted!");
                    }
                }
            }
        });
    }

    private void addTrackerInfo() {
        Set<String> locations = tracker.getLocations();
        JSONArray filenames;
        DefaultTableModel model = (DefaultTableModel) jTable_Files_Name.getModel();

        model.setColumnIdentifiers(new String[]{"Location", "File"});

        Object[] row = new Object[2];

        for (String location : locations) {
            filenames = tracker.getFilenames(location);
            for(Object filename: filenames.toList()) {
                row[0] = location;
                row[1] = filename.toString();
                model.addRow(row);
            }
        }
    }

    public void checkForDeletedFiles() throws ConcurrentModificationException
    {
        try {
            Set<String> locations = tracker.getLocations();
            for (String location : locations) {
                JSONArray filenames = tracker.getFilenames(location);
                for (Object filename : filenames.toList()) {
                    if (!new File(location + filename).exists()) {
                        tracker.removeFile(location, (String) filename);
                    }
                }
            }
        }
        catch (ConcurrentModificationException ex){
            System.out.println("Error.");
        }
    }


    public static void main(String args[]) {

        new FileBrowser().setVisible(true);

    }

}


//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.SystemColor;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.IOException;
//
//import javax.swing.AbstractAction;
//import javax.swing.Action;
//import javax.swing.*;
//
//public class weight extends javax.swing.JPanel {
//
//	private static JFrame frame;
//	static JFileChooser fileChooser = new JFileChooser();
//	private String filename;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					weight window = new weight();
//					window.frame.setVisible(true);
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public weight() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		
//		//set the frame propertites
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		//frame.setBounds(350, 350, 700, 700);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//
//		JButton btnNewButton = new JButton("Select file");
////		btnNewButton.setAlignmentY(CENTER_ALIGNMENT);
////		btnNewButton.setAlignmentX(CENTER_ALIGNMENT);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
//				int result = fileChooser.showOpenDialog(frame);
//				if (result == JFileChooser.APPROVE_OPTION) {
//					// user selects a file
//					File selectedFile = fileChooser.getSelectedFile();
//					System.out.println("Selected file: " + selectedFile.getAbsolutePath());
//					filename = selectedFile.getAbsolutePath();
//					
//					String show_inheritance = null;
//		String show_nesting = Workedfornesting.callFromGUi_for_nesting(filename);
//		String show_type = workedFortype.callFromGUi_for_type(filename);
//		String show_size = Read.calcArithmeticComplexity(filename);
//		try {
//			 show_inheritance = FileReader.callFromGUi_for_inheritance(filename);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//					//System.out.println(show_nesting);
//					//System.out.println(show_type);
//					//System.out.println(show_size);
//				//	System.out.println(show_inheritance);
//		int tw = Inte
//					String lastOutput =   "\n\n"  + show_size +  "\n\n"  + show_inheritance  + "\n\n" +show_nesting +  "\n\n" + show_type +"\n\n"    ;
//					JOptionPane.showMessageDialog(frame, lastOutput);
//
//				}
//			}
//		});
//		// problem - to display program statement complexity in dialogbox/ new window,
//		// new window is ok
//		btnNewButton.setBackground(SystemColor.text);
//		btnNewButton.setForeground(SystemColor.infoText);
//		btnNewButton.setBounds(71, 94, 291, 23);
//		frame.getContentPane().add(btnNewButton);
//
//	}
//
//}
//



package Bai1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class FibonacciClient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FibonacciClient frame = new FibonacciClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FibonacciClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtInput = new JTextField();
		txtInput.setBounds(94, 33, 253, 20);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Input    :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(22, 34, 62, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblOutput = new JLabel("Output :");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOutput.setBounds(22, 64, 62, 19);
		contentPane.add(lblOutput);
		
		JTextPane txtOutput = new JTextPane();
		txtOutput.setEditable(false);
		txtOutput.setBounds(94, 64, 253, 115);
		contentPane.add(txtOutput);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtOutput.setText(getResult(txtInput.getText()));
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnView.setBounds(369, 32, 89, 23);
		contentPane.add(btnView);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInput.setText("");
				txtOutput.setText("");
			}
		});
		btnReset.setBounds(369, 122, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnQuit.setBounds(369, 156, 89, 23);
		contentPane.add(btnQuit);
	}
	
	private synchronized static String getResult(String msg) throws UnknownHostException, IOException {
		DatagramSocket clientSocket = new DatagramSocket(); 
        InetAddress IPAddress = InetAddress.getByName("localhost"); 
        
        byte[] receiveData = new byte[4096];
        byte[] sendData;
        
        sendData = msg.getBytes();
        
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 7979);
        clientSocket.send(sendPacket);
        
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String str = new String(receivePacket.getData());

        clientSocket.close(); 
		return str.trim();
	}
}

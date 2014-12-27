import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.lang.Math;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import javax.swing.JDialog;

//main class, creates the 
public class WindownInvestment extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField LoanAmount, YearlyInterestRate, NumberOfYears, MonthlyPayment;
	private JRadioButton option1, option2;
	private ButtonGroup group;
	private JButton btnCalculate_1, btnExit;
	String Loan_Amount;
	String Number_Years;
	String Yearly_Rate;
	String Monthly_Payment;
	double loan1;
	double number1;
	double year1;
	double month1;
	double month2;
	double loan2;
	String FinalMonthValue;
	String FinalLoanValue;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindownInvestment frame = new WindownInvestment();
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
	public WindownInvestment() {
		setTitle("Loan Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 319, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.setLayout(null);
		
		
		final JFormattedTextField LoanAmount = new JFormattedTextField();
		LoanAmount.setBounds(176, 58, 114, 28);
		LoanAmount.setValue(new Double(0));
		contentPane.add(LoanAmount);
		
		final JFormattedTextField YearlyInterestRate = new JFormattedTextField();
		YearlyInterestRate.setBounds(177, 98, 113, 28);
		YearlyInterestRate.setValue(new Double(0));
		contentPane.add(YearlyInterestRate);
		
		final JFormattedTextField NumberOfYears = new JFormattedTextField();
		NumberOfYears.setBounds(177, 138, 113, 28);
		NumberOfYears.setValue(new Double(0));
		contentPane.add(NumberOfYears);
		
		final JFormattedTextField MonthlyPayment = new JFormattedTextField();
		MonthlyPayment.setBounds(177, 178, 113, 28);
		MonthlyPayment.setValue(new Double(0));
		contentPane.add(MonthlyPayment);
		
		final JRadioButton option1 = new JRadioButton("Monthly Payment");
		option1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				MonthlyPayment.setEnabled(false);
				MonthlyPayment.setText(null);
				LoanAmount.setEnabled(true);
			}
		});
		option1.setBounds(24, 23, 141, 23);
		contentPane.add(option1);
		
		final JRadioButton option2 = new JRadioButton("Loan Amount");
		option2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoanAmount.setEnabled(false);
				LoanAmount.setText(null);
				MonthlyPayment.setEnabled(true);
			}
		});
		option2.setBounds(177, 23, 141, 23);
		contentPane.add(option2);
		

		ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(173, 232, 117, 29);
		contentPane.add(btnExit);
		
		JTextArea txtrLoanAmount = new JTextArea();
		txtrLoanAmount.setText("Loan Amount:");
		txtrLoanAmount.setBounds(34, 64, 88, 16);
		txtrLoanAmount.setOpaque(false);
		txtrLoanAmount.setEditable(false);
		contentPane.add(txtrLoanAmount);
		
		JTextArea txtrYearlyInterestRate = new JTextArea();
		txtrYearlyInterestRate.setText("Yearly Interest Rate:");
		txtrYearlyInterestRate.setBounds(32, 104, 133, 16);
		txtrYearlyInterestRate.setOpaque(false);
		txtrYearlyInterestRate.setEditable(false);
		contentPane.add(txtrYearlyInterestRate);
		
		JTextArea txtrNumberOfYears = new JTextArea();
		txtrNumberOfYears.setText("Number of Years:");
		txtrNumberOfYears.setBounds(31, 144, 134, 28);
		txtrNumberOfYears.setOpaque(false);
		txtrNumberOfYears.setEditable(false);
		contentPane.add(txtrNumberOfYears);
		
		JTextArea txtrMonthlyPayment = new JTextArea();
		txtrMonthlyPayment.setText("Monthly Payment:");
		txtrMonthlyPayment.setBounds(32, 184, 133, 16);
		txtrMonthlyPayment.setOpaque(false);
		txtrMonthlyPayment.setEditable(false);
		contentPane.add(txtrMonthlyPayment);
		JButton btnCalculate_1 = new JButton("Calculate");
		btnCalculate_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loan1 = ((Number)LoanAmount.getValue()).doubleValue();
				year1 = ((Number)YearlyInterestRate.getValue()).doubleValue();
				number1 = ((Number)NumberOfYears.getValue()).doubleValue();
				month1 = ((Number)MonthlyPayment.getValue()).doubleValue();
				
					
					if(option1.isSelected()){
						Monthly month = new Monthly(loan1, year1, number1);
						month2 = month.setMonthlyPayment(loan1, year1, number1);
						month2 = (double) Math.round(month2 * 100) / 100;
						FinalMonthValue = Double.toString(month2);
						MonthlyPayment.setText(FinalMonthValue);
					}
					else if(option2.isSelected()){
						LoanPayment loan = new LoanPayment(year1, number1, month1);
						loan2 = loan.setLoanAmount(year1, number1, month1);
						System.out.print(loan2);
						loan2 = (double) Math.round(loan2*100) / 100;
						FinalLoanValue = Double.toString(loan2);
						LoanAmount.setText(FinalLoanValue);
					}
					else{
						JFrame f = new JFrame();
						JOptionPane.showMessageDialog(f, "Amrita Bhuj is a nigger faggot");
						setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						}
						
						
					
				
			}
		});
		btnCalculate_1.setBounds(32, 232, 117, 29);
		contentPane.add(btnCalculate_1);
		
		
	}
}

class Monthly{
	static double monthValue;
	double R;
	double N;
	double P;
	public Monthly(Double Loan, Double Year, Double Number){
		P = Loan;
		R = Year;
		N = Number;
	}
	
	public double setMonthlyPayment(Double P, Double R, Double N){
		R = (R * .01)/12;
		N = N * 12;
		monthValue = (R * P)/(1 - (Math.pow((1 + R), -N)));
		return monthValue;
	}
	

}
class LoanPayment{
	static double paymentValue;
	static double R;
	double N;
	double P;
	public LoanPayment(Double Year, Double Number, Double Month){
		P = Month;
		N = Number;
		R = Year;
	}
	public double setLoanAmount(Double R, Double N, Double P){
		R = (R * .01)/12;
		N = N * 12;
		paymentValue = (P*(1-(Math.pow((1+R),-N))))/R;
		return paymentValue;
		
	}
}

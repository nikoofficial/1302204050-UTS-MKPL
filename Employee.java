package lib;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;

	private LocalDate dateJoined;
	private boolean isForeigner;
	private boolean isMale;

	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;

	private Spouse spouse;
	private List<Child> children;

	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address,
			LocalDate dateJoined, boolean isForeigner, boolean isMale) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.dateJoined = dateJoined;
		this.isForeigner = isForeigner;
		this.isMale = isMale;

		children = new ArrayList<>();
	}

	public void setMonthlySalary(int grade) {
		switch (grade) {
			case 1:
				monthlySalary = 3000000;
				break;
			case 2:
				monthlySalary = 5000000;
				break;
			case 3:
				monthlySalary = 7000000;
				break;
			default:
				throw new IllegalArgumentException("Invalid grade: " + grade);
		}
		if (isForeigner) {
			monthlySalary = (int) (monthlySalary * 1.5);
		}
	}

	public void setAnnualDeductible(int deductible) {
		this.annualDeductible = deductible;
	}

	public void setAdditionalIncome(int income) {
		this.otherMonthlyIncome = income;
	}

	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
	}

	public void addChild(Child child) {
		children.add(child);
	}

	public int getAnnualIncomeTax() {
		// Calculate the number of months worked in the current year
		LocalDate now = LocalDate.now();
		int monthsWorked = (now.getYear() == dateJoined.getYear()) ? now.getMonthValue() - dateJoined.getMonthValue()
				: 12;

		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthsWorked,
				annualDeductible, (spouse == null || spouse.isEmpty()), children.size());
	}

	// Getters and setters

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(LocalDate dateJoined) {
		this.dateJoined = dateJoined;
	}

	public boolean isForeigner() {
		return isForeigner;
	}

	public void setForeigner(boolean foreigner) {
		isForeigner = foreigner;
	}

	public boolean isMale() {
		return isMale;
	}
}
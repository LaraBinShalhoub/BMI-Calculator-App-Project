package riri;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BMICalculatorAppProject {

	public static void main(String[] args) {


        JFrame frame = new JFrame("BMI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        String weightInput, heightInput;
        double weight = 0, height = 0;


        while (true) {
            weightInput = JOptionPane.showInputDialog(frame, "Enter your weight in kilograms:");
            if (weightInput == null) return;

            try {
                weight = Double.parseDouble(weightInput.trim());
                if (weight > 0) break;
                else JOptionPane.showMessageDialog(frame, "Please enter a valid value!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Error! (Please enter numbers only)");
            }
        }

        // إدخال الطول
        while (true) {
            heightInput = JOptionPane.showInputDialog(frame,
                    "Enter your height:\n- in meters (e.g., 1.75)\n- or in centimeters (e.g., 175)");
            if (heightInput == null) return;

            try {
                height = Double.parseDouble(heightInput.trim());

                if (height > 0) {
                    // إذا كان بالسنتيمتر نحوله لمتر
                    if (height > 3) {
                        height = height / 100.0;
                    }
                    break;
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid value!");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Error! (Please enter numbers only)");
            }
        }

        // حساب BMI
        double bmi = weight / (height * height);

        // تحديد التصنيف
        String category;

        if (bmi < 18.5) {
            category = "Underweight (نقص في الوزن)";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            category = "Normal weight (وزن طبيعي)";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            category = "Overweight (زيادة في الوزن)";
        } else {
            category = "Obese (سمنة)";
        }

        // عرض النتيجة
        String result = String.format(
                "Your BMI: %.2f\nCategory: %s\nWeight: %.1f kg\nHeight: %.2f m",
                bmi, category, weight, height
        );

        JOptionPane.showMessageDialog(frame, result, "Result", JOptionPane.INFORMATION_MESSAGE);
	}

}

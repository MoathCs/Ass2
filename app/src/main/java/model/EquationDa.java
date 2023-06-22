package model;

public class EquationDa implements Iequations {

    @Override
    public double getDiscriminant(Equation equation) {
        double v = equation.getB() * equation.getB() - 4 * equation.getA() * equation.getC();
        return v;
    }

    @Override
    public double getRoot1(Equation equation) {
        double v = (-equation.getB() + Math.sqrt(getDiscriminant(equation))) / (2 * equation.getA());
        return v;
    }


    @Override
    public double getRoot2(Equation equation) {
        double v = (-equation.getB() - Math.sqrt(getDiscriminant(equation))) / (2 * equation.getA());
        return v;
    }

    public double[] getData(double a, double b, double c) {

        Equation equation = new Equation(a, b, c);
        double[] arr = new double[3];

        arr[0] = getDiscriminant(equation);
        arr[1] = getRoot1(equation);
        arr[2] = getRoot2(equation);
//        ArrayList <equations> arr = new ArrayList<>();
//        arr.add(new equations(a,b,c));
        return arr;
    }
}

public class Presenter {

    public Presenter() {
    }

    public void start() throws IllegalAccessException {

        System.out.println("\nThe program for calculating two complex and real numbers ");
        UI input = new UI();
        String flag = "y";
        while (flag.equals("y")) {
            if (input.chooseTypeNumber() == "r") {
                String readText = View.getArithmeticReal();                         // ввод арифметического выражения из двух действительных чисел
                Parser parserReal = new Parser(readText);                            // конвертирование в формат double
                CalcRealExpression rationalReal = new CalcRealExpression(parserReal);
                View.printResultRealExpression(rationalReal.solveReal());          // вычисление  арифметического выражения из действительных чисел

            } else {
                String[] complexOperand = View.getArithmeticComplex();             //  ввод арифметического выражения из двух комплексных чисел


                Parser parserComplex = new Parser(complexOperand);                  // конвертирование в формат double

                CalcComplexExpression rationalComplex = new CalcComplexExpression(parserComplex.getNumber1().getReal(), parserComplex.getOperation1(), parserComplex.getNumber1().getImage(),
                        parserComplex.getOperation(), parserComplex.getNumber2().getReal(), parserComplex.getOperation2(), parserComplex.getNumber2().getImage());

                System.out.println("\n Rezult:");
                System.out.println(rationalComplex.solveComplex());                 // вычисление арифметического выражения из двух комплексных чисел
            }
            flag = input.chooseExitContue();

        }
    }
}

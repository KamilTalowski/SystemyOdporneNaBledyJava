package testyJednostkowe;

public class Onp {
   
    static private Stos stos = new Stos();
    static private String wyrazenieONP = "";
 
    public static void main(String[] args) {
        String infix = "3+4*2/(1-5)=";
        System.out.println(infix);
        if(infix.charAt(infix.length() - 1) == '=') {
            toONP(infix);
            System.out.println(wyrazenieONP);
            calcONP();
        }
    }
   
    private static int priorytet(char operator) {
        switch(operator) {
        case '^':
            return 3;
        case '*':
        case '/':
            return 2;
        case '+':
        case '-':
            return 1;
        case '(':
            return 0;
        }
        return -1;
    }
   
    public static void toONP(String wyrazenieInf) {
        stos.clear();
        wyrazenieONP = "";
        for(int i = 0; i<wyrazenieInf.length(); i++) {
            if(Character.isDigit(wyrazenieInf.charAt(i))) {
                wyrazenieONP += wyrazenieInf.charAt(i);
                while(Character.isDigit(wyrazenieInf.charAt(i+1))) {
                    i++;
                    wyrazenieONP += wyrazenieInf.charAt(i);
                }
                if(wyrazenieInf.charAt(i+1) == '.') {
                    i++;
                    wyrazenieONP += ".";
                    while(Character.isDigit(wyrazenieInf.charAt(i+1))) {
                        i++;
                        wyrazenieONP += wyrazenieInf.charAt(i);
                    }
                }
                wyrazenieONP += " ";
            }else if(wyrazenieInf.charAt(i)=='(') { //Jeżeli symbol jest lewym nawiasem to włóż go na stos.
                stos.push(wyrazenieInf.charAt(i));
            }else if(wyrazenieInf.charAt(i)==')') { //Jeżeli symbol jest prawym nawiasem to zdejmuj operatory ze stosu i dokładaj je do kolejki wyjście, dopóki symbol na górze stosu nie jest lewym nawiasem
                while(stos.top().charAt(0) != '(') {
                    wyrazenieONP += stos.pop() + " ";
                }
                stos.pop(); //zdejmij lewy nawias ze stosu bez dokładania go do kolejki wyjście
            }else { //Jeśli symbol jest operatorem, o1, wtedy:
                while(!stos.isEmpty() && priorytet(wyrazenieInf.charAt(i))<=priorytet(stos.top().charAt(0)) ) { //dopóki na górze stosu znajduje się operator, o2 taki, że kolejność wykonywania o1 jest mniejsza lub równa kolejności wyk. o2
                    wyrazenieONP += stos.pop() + " "; //zdejmij o2 ze stosu i dołóż go do kolejki wyjściowej
                }
                stos.push(wyrazenieInf.charAt(i));
            }
        }
        while(!stos.isEmpty())
            wyrazenieONP += stos.pop() + " ";
    }
   
    public static double calcONP() {
        stos.clear();
        for(int i = 0; i<wyrazenieONP.length(); i++) {
            if(wyrazenieONP.charAt(i) == ' ') continue;
            if(wyrazenieONP.charAt(i) == '=') {
                String result = stos.pop();
                System.out.println("Wynik: " + result);
                return Double.parseDouble(result);
            }
            if(Character.isDigit(wyrazenieONP.charAt(i))) {
                double temp = (double) Character.getNumericValue(wyrazenieONP.charAt(i));
                while(Character.isDigit(wyrazenieONP.charAt(i+1))) {
                    i++;
                    temp *= 10;
                    temp += Character.getNumericValue(wyrazenieONP.charAt(i));
                }
                if(wyrazenieONP.charAt(i+1) == '.') {
                    i++;
                    double tempmp = 0.1;
                    while(Character.isDigit(wyrazenieONP.charAt(i+1))) {
                        i++;
                        temp += Character.getNumericValue(wyrazenieONP.charAt(i))*tempmp;
                        tempmp /= 10;
                    }
                }
                stos.push(Double.toString(temp));
            }else{
                double a = Double.parseDouble(stos.pop());
                double b = Double.parseDouble(stos.pop());
                switch (wyrazenieONP.charAt(i)) {
                case '+':
                    stos.push(Double.toString(b+a));
                    break;
                case '-':
                    stos.push(Double.toString(b-a));
                    break;
                case '*':
                    stos.push(Double.toString(b*a));
                    break;
                case '/':
                    stos.push(Double.toString(b/a));
                    break;
                default:
                    System.out.println("Nieznany operator " + wyrazenieONP.charAt(i));
                    stos.push(Double.toString(b));
                    stos.push(Double.toString(a));
                }
            }
        }
        return Double.parseDouble(stos.pop());
    }
 
}

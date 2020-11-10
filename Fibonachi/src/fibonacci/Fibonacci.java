package fibonacci;

public class Fibonacci {

    boolean add1 = false;

    public void berechnung(int fibLength) {
        int fibSumme = 1;
        int f1 = 0, f2 = 1, tempInt = 0;
        int strIndex;
        String fibSummeStr = "";
        String f1Str = "", f2Str = "", temp = "";
        boolean ersterDurchgang = true;
        boolean intGrenzeÜberschritten = false;
        boolean größenEnscheidung;
        boolean nullAdded = false;
        for (int i = 0; i < fibLength; i++) {

            if (ersterDurchgang == false) {
                if (intGrenzeÜberschritten == false) {
                    //System.out.println("f1= " + f1 + " f2= " + f2);
                    fibSumme = f1 + f2;
                    if (f1 < f2) {

                        f1 = fibSumme;
                    } else {
                        if (fibSumme > 0) {
                            f2 = fibSumme;
                        }
                    }

                    if (fibSumme < 0) {

                        intGrenzeÜberschritten = true;
                        fibSumme = 0;
                        f1Str = String.valueOf(f1);
                        f2Str = String.valueOf(f2);
                    }
                    if (fibSumme != 0) { //muss gemacht werden sonst wird 47 ein zweites mal mit einer 0 ausgegeben
                        System.out.println(i + 1 + ": " + fibSumme);
                    }
                }
                if (intGrenzeÜberschritten == true) {
                    f1Str = "0" + f1Str;
                    f2Str = "0" + f2Str;

                    for (strIndex = 0; strIndex < f2Str.length(); strIndex++) {
                        tempInt = f1Str.length() - strIndex - 1;
                        f1 = f1Str.charAt(tempInt) - 48;
                        f2 = f2Str.charAt(tempInt) - 48;
                        //System.out.println(i + 1 + ": f1= "+ f1Str +" f2= "+ f2Str);
                        fibSummeStr = fibSummeStr + summeAusgeben(f1Str, f2Str, f1, f2);
                    }

                    fibSummeStr = spiegeln(fibSummeStr);
                    größenEnscheidung = vergleich(f1Str, f2Str, fibSummeStr); //wenn größenEntscheidung = false dann f2 größer. sonst wenn true dann f1 größer 
                    if (größenEnscheidung == true) {
                        f1Str = fibSummeStr;
                        // System.out.println("kleiner" + f2Str + "größer= f1 " + f1Str);
                    } else {
                        f2Str = fibSummeStr;
                        // System.out.println("kleiner" + f1Str + "größer= f2 " + f2Str);

                    }
                    if (fibSummeStr.charAt(0) == '0') {
                        for (strIndex = 0; strIndex < fibSummeStr.length(); strIndex++) {
                            if (fibSummeStr.charAt(strIndex) != '0') {
                                tempInt = strIndex;
                                break;
                            }
                        }
                        fibSummeStr = fibSummeStr.substring(tempInt, fibSummeStr.length());
                    }
                    System.out.println(i + 1 + ": " + fibSummeStr);

                    fibSummeStr = "";

                }

            } else {
                System.out.println(i + 1 + ": " + fibSumme);
                ersterDurchgang = false;
            }
        }

    }

    public String summeAusgeben(String f1Str, String f2Str, int f1, int f2) {
        int fibSumme;
        String fibSummeStr = "", tempStr = "";

        if (add1 == true) {
            fibSumme = f1 + f2 + 1;
            tempStr = String.valueOf(fibSumme);
            //System.out.println(f1 + "+" + f2 + "+1=" + temp);
            add1 = false;
        } else {
            fibSumme = f1 + f2;

            tempStr = String.valueOf(fibSumme);
            //System.out.println(f1 + "+" + f2 + "=" + temp);

        }
        if (fibSumme > 9) {
            add1 = true;
            fibSummeStr = fibSummeStr + tempStr.charAt(1);
        } else {
            fibSummeStr = fibSummeStr + tempStr;
        }

        return fibSummeStr;
    }

    public boolean vergleich(String f1Str, String f2Str, String fibSummeStr) {
        int f1 = 0, f2 = 0;
        boolean finished = false, größenEntscheidung = false; //wenn größenEntscheidung = false dann f2 größer. sonst wenn true dann f1 größer 
        for (int i = 0; i < f1Str.length(); i++) {
            if (finished == false) {
                f1 = f1Str.charAt(i) - 48;
                f2 = f2Str.charAt(i) - 48;

            }
            if (f1 > f2) {
                finished = true;

            }
            if (f1 < f2) {
                größenEntscheidung = true;
                finished = true;
            }

        }
        return größenEntscheidung;
    }

    public String spiegeln(String string) {
        String gespiegeltesString = "";

        for (int i = 0; i < string.length(); i++) {
            gespiegeltesString = gespiegeltesString + string.charAt(string.length() - i - 1);
        }

        return gespiegeltesString;
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        fib.berechnung(100);
    }

}

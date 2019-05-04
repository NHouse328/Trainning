package casanova.gabriel.verificarcpf;

public class Calculos {

    public boolean verificar (String cpf) {
//        String cpf = "11111111111";

//        Coletando os digitos
        String dv1 = cpf.substring(9,10);
        String dv2 = cpf.substring(10,11);

        char[] numeros = cpf.toCharArray();

//        Variaveis de apoio
        int calculo1 = 0;
        int calculo2 = 0;

        for (int i = 0; i < 9; i++) {
            String numero = String.valueOf(numeros[i]);
            int valor = Integer.parseInt(numero);

            calculo1 += (valor * (i + 1));
            calculo2 += valor * i;
        }

        calculo1 %= 11;

        if (calculo1 > 9) {
            calculo1 = 0;
        }

        calculo2 += calculo1 * 9;

        calculo2 %= 11;

        if (calculo2 > 9) {
            calculo2 = 0;
        }

        boolean resultado = (Integer.parseInt(dv1) == calculo1) && (Integer.parseInt(dv2) == calculo2);
        return resultado;
    }
}

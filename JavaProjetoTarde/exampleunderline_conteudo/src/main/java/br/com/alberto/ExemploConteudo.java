package br.com.alberto;

public class ExemploConteudo {
// CamelCase
// lowerCase
    // métodos
    public void operacoes() {
        // variáveis primitivas
        int a = 20, b = 30;
        double c = 7.8;
        // char letra = 'D';
        boolean teste = false;

        // operadores relacionais (compra algo > com algo) com operador lógico &&
        teste = (a>b) && (c<8);

        // entre parentese para mostrar a soma
        System.out.println("Resultado de a + b: " + (a + b));
        System.out.printf("Resultado para teste: %s" , teste);

        // todo if tem que ter uma consição, mas nem sempre precisa do else

        // outro método aqui
        // fazer um encurtador de link básico
    }

    public void controleDeFluxo(){
// If-Else
int idade = 18;
if (idade >= 18) {
    System.out.println("Maior de idade");
} else {
    System.out.println("Menor de idade");
}

// Switch
int dia = 2;
switch(dia) {
    case 1:
        System.out.println("Segunda-feira");
        break;
    case 2:
        System.out.println("Terça-feira");
        break;
    default:
        System.out.println("Outro dia");
}

for (int i = 0; i < 10; i++) {
    System.out.println(i);
}

int i = 10;
while (i>0) {
    System.out.println(i);
    i--;
}

    }

}

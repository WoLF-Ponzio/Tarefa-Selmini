import java.util.Scanner;
public class Exercício6_1 {

    public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    int sala = 0, alunos = 0;
    double media = 0, porcentagem = 0, media_final = 0;
    
    System.out.println("Controle de Alunos");
    System.out.print("Informe o número de salas de aula: ");
    sala = teclado.nextInt();
    double [] salay = new double[sala];
    
    for(int i = 0; i < salay.length;  i++){
        System.out.print("Quantos alunos possuem a " + (i+1) + "ª sala: ");
        alunos = teclado.nextInt();
        double [] alunay = new double[alunos];
        media = notas(alunay,media,i);
        
        
        	media = media/alunay.length;
            porcentagem = porcentagem(porcentagem, alunay, media);
                
            impressao(porcentagem, i, media,media_final, alunay, salay);
            porcentagem = 0;
            media = 0;
    }
}
    public static void impressao(double porcentagem, int i, double media, double media_final, double alunay[], double salay[]) {
    	 System.out.print("A sala " + (i+1) + ", que tem " + alunay.length + " alunos, teve como médias ");
                for(int s = 0; s <alunay.length; s++) {
                	System.out.print(alunay[s] + " ");    
                }
                	System.out.println("\nA média geral da sala foi de " + String.format("%.2f", media) + " pontos!");
                
            media_final = porcentagem/alunay.length;
            salay[i] = media_final;
            System.out.println("Por fim, " + String.format("%.3f", salay[i] * 100)+ "% dos alunos ficaram acima da média da sala.\n");
    }
    
    public static double porcentagem(double porcentagem, double alunay[], double media) {
    	for(int m = 0; m < alunay.length; m++) {
                    if(alunay[m] > media) {
                        porcentagem++;
                    }
                    }
    	return porcentagem;
    	
    }
    public static double notas(double alunay[], double media, int i) {
    Scanner teclado = new Scanner(System.in);
    System.out.println("Informe a nota (de 0 a 100)");
        for(int a = 0; a < alunay.length; a++) {
        	do {
            	System.out.print("Insira a nota do " + (a+1) + "º aluno da sala " + (i+1) + ": ");
            	alunay[a] = teclado.nextInt();
            		if(alunay[a]>100 || alunay[a]<0) {
            			System.out.println("\nNota inválida! Valor acima de 100 ou abaixo de 0");
            			System.out.println("Repita o passo novamente");
            		}else {
            			media = media + alunay[a];
            		}
        	}while (alunay[a]>100 || alunay[a]<0);
        }
    return media;
    }
}
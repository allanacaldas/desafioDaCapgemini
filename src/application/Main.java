package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Anuncio;
import entities.Cliente;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println(" ------- Sistema de cadastro de an�ncios ------- ");
		System.out.println(" ----------------------------------------------- ");

		try {
			System.out.println("Insira o nome do an�ncio: ");
			String nome = sc.nextLine();
			System.out.println("Insira o nome do cliente: ");
			String nomeDoCliente = sc.nextLine();
			System.out.println("Insira a data do in�cio do an�ncio (dd/mm/yyyy): ");
			Date dataInicio;
			dataInicio = sdf.parse(sc.next());
			System.out.println("Insira a data do t�rmino do an�ncio (dd/mm/yyyy): ");
			Date dataTermino = sdf.parse(sc.next());
			System.out.println("De quanto ser� o investimento por dia? ");
			double investimentoDia = sc.nextDouble();

			Cliente cliente = new Cliente(nomeDoCliente);
			Anuncio anuncio = new Anuncio(nome, cliente, dataInicio, dataTermino, investimentoDia);

			System.out.println(anuncio);
			System.out.println();
		} catch (ParseException e) {
			e.getMessage(); // TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println(" ----------------------------------------------- ");
			System.out.println("Fim do Programa");
			System.out.println(" ----------------------------------------------- ");
		}

		sc.close();
	}

}

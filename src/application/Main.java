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

		System.out.println(" ------- Sistema de cadastro de anúncios ------- ");
		System.out.println(" ----------------------------------------------- ");

		try {
			System.out.println("Insira o nome do anúncio: ");
			String nome = sc.nextLine();
			System.out.println("Insira o nome do cliente: ");
			String nomeDoCliente = sc.nextLine();
			System.out.println("Insira a data do início do anúncio (dd/mm/yyyy): ");
			Date dataInicio;
			dataInicio = sdf.parse(sc.next());
			System.out.println("Insira a data do término do anúncio (dd/mm/yyyy): ");
			Date dataTermino = sdf.parse(sc.next());
			System.out.println("De quanto será o investimento por dia? ");
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

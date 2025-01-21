package view;

import dto.AvaliacaoFisicaDTO;
import dto.ExercicioDTO;
import dto.UsuarioDTO;
import model.AvaliacaoFisica;
import model.Exercicio;
import model.Usuario;
import controller.AvaliacaoFisicaController;
import controller.ExercicioController;
import controller.UsuarioController;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		UsuarioController usuarioController = new UsuarioController();
		AvaliacaoFisicaController avaliacaoFisicaController = new AvaliacaoFisicaController();
		ExercicioController exercicioController = new ExercicioController();

		String escolha = "";

		while(!escolha.equals("13")) {
			System.out.println("--------------------------------------------");
			System.out.println("Usuário");
			System.out.println("Selecione uma opção:");
			System.out.println("1. Adicionar Usuario");
			System.out.println("2. Atualizar Usuario");
			System.out.println("3. Obter Usuario");
			System.out.println("4. Excluir Usuario");

			System.out.println("--------------------------------------------");

			System.out.println("Exercicio");

			System.out.println("5. Adicionar Exercicio");
			System.out.println("6. Atualizar Exercicio");
			System.out.println("7. Obter Exercicio");
			System.out.println("8. Excluir Exercicio");

			System.out.println("--------------------------------------------");

			System.out.println("Avaliacao Física");

			System.out.println("9. Adicionar Avaliacao Física");
			System.out.println("10. Atualizar Avaliacao Física");
			System.out.println("11. Obter Avaliacao Física");
			System.out.println("12. Excluir Avaliacao Física");

			System.out.println("--------------------------------------------");

			System.out.println("13. Sair");

			escolha = scanner.nextLine().toLowerCase();

			switch(escolha) {
			case "1": 
				System.out.println("Digite o id:");
				Long idUsuario = scanner.nextLong();
				scanner.nextLine();
				System.out.println("Digite o nome do Usuario:");
				String nomeUsuario = scanner.nextLine();
				System.out.println("Digite o email do Usuario:");
				String emailUsuario = scanner.nextLine();
				System.out.println("Digite a senha do Usuario:");
				String senhaUsuario = scanner.nextLine();
				UsuarioDTO usuarioDTO = new UsuarioDTO();
				usuarioDTO.setId(idUsuario);
				usuarioDTO.setNome(nomeUsuario);
				usuarioDTO.setEmail(emailUsuario);
				usuarioDTO.setSenha(senhaUsuario);
				usuarioController.adicionarUsuario(usuarioDTO);
				break;

			case "2":
				System.out.println("Digite o id:");
				Long idAtualizarUsuario = scanner.nextLong();
				scanner.nextLine();
				System.out.println("Digite o novo nome do Usuario:");
				String nomeAtualizadoUsuario = scanner.nextLine();
				System.out.println("Digite o novo email do Usuario:");
				String emailAtualizadoUsuario = scanner.nextLine();
				System.out.println("Digite a nova senha do Usuario:");
				String senhaAtualizadaUsuario = scanner.nextLine();
				UsuarioDTO usuarioDTOUpdate = new UsuarioDTO();
				usuarioDTOUpdate.setId(idAtualizarUsuario);
				usuarioDTOUpdate.setNome(nomeAtualizadoUsuario);
				usuarioDTOUpdate.setEmail(emailAtualizadoUsuario);
				usuarioDTOUpdate.setSenha(senhaAtualizadaUsuario);
				usuarioController.atualizarUsuario(usuarioDTOUpdate);
				break;

			case "3":
				System.out.println("Digite o id:");
				Long idObterUsuario = scanner.nextLong();
				scanner.nextLine();
				UsuarioDTO usuarioDTOGet = new UsuarioDTO();
				usuarioDTOGet.setId(idObterUsuario);
				Usuario usuario = usuarioController.obterUsuario(usuarioDTOGet);
				if (usuario != null) {
					System.out.println("Usuario encontrado: " + usuario.getNome());
				} else {
					System.out.println("Usuario não encontrado");
				}
				break;

			case "4":
				System.out.println("Digite o id:");
				Long idExcluirUsuario = scanner.nextLong();
				scanner.nextLine();
				UsuarioDTO usuarioDTODelete = new UsuarioDTO();
				usuarioDTODelete.setId(idExcluirUsuario);
				usuarioController.excluirUsuario(usuarioDTODelete);
				System.out.println("Usuario excluído com sucesso");
				break;

			case "5":
				System.out.println("Digite o id:");
				long idExercicio = scanner.nextLong();
				scanner.nextLine();
				System.out.println("Digite o tipo de Exercicio:");
				String tipoExercicio = scanner.nextLine();
				System.out.println("Digite a duração do Exercicio (em minutos):");
				int duracao = scanner.nextInt();
				System.out.println("Digite as calorias queimadas:");
				int caloriasQueimadas = scanner.nextInt();

				System.out.println("Digite o id do Usuario:");
				Long idUsuarioExercicio = scanner.nextLong();
				scanner.nextLine();

				UsuarioDTO usuarioDTOExercicio = new UsuarioDTO();
				usuarioDTOExercicio.setId(idUsuarioExercicio);
				Usuario usuarioAssociado = usuarioController.obterUsuario(usuarioDTOExercicio);

				if (usuarioAssociado != null) {
					ExercicioDTO exercicioDTO = new ExercicioDTO(idExercicio,idUsuarioExercicio, tipoExercicio, duracao, caloriasQueimadas);
					exercicioController.adicionarExercicio(exercicioDTO);
				} else {
					System.out.println("Usuario não encontrado");
				}
				break;

			case "6":
				System.out.println("Digite o id:");
				long idAtualizarExercicio = scanner.nextLong();
				scanner.nextLine();
				System.out.println("Digite o id do Usuário:");
				Long idUsuarioExercicioUpdate = scanner.nextLong();
				scanner.nextLine();
				
				
				System.out.println("Digite o novo tipo de Exercicio:");
				String tipoExercicioAtualizado = scanner.nextLine();
				System.out.println("Digite a nova duração do Exercicio (em minutos):");
				int duracaoAtualizada = scanner.nextInt();
				System.out.println("Digite as novas calorias queimadas:");
				int caloriasQueimadasAtualizadas = scanner.nextInt();


				UsuarioDTO usuarioDTOExercicioUpdate = new UsuarioDTO();
				usuarioDTOExercicioUpdate.setId(idUsuarioExercicioUpdate);
				Usuario usuarioAssociadoUpdate = usuarioController.obterUsuario(usuarioDTOExercicioUpdate);

				if (usuarioAssociadoUpdate != null) {
					ExercicioDTO exercicioDTOUpdate = new ExercicioDTO(idAtualizarExercicio, idUsuarioExercicioUpdate, tipoExercicioAtualizado, duracaoAtualizada, caloriasQueimadasAtualizadas);
					exercicioController.atualizarExercicio(exercicioDTOUpdate);
				} else {
					System.out.println("Usuario não encontrado");
				}
				break;

			case "7":
				System.out.println("Digite o id:");
				long idObterExercicio = scanner.nextLong();
				ExercicioDTO exercicioDTOGet = new ExercicioDTO();
				exercicioDTOGet.setId(idObterExercicio);
				Exercicio exercicio = exercicioController.obterExercicio(exercicioDTOGet);
				if (exercicio != null) {
					System.out.println("Exercicio encontrado: " + exercicio.getTipoExercicio() + ", Duração: " + exercicio.getDuracao() + " minutos, Calorias queimadas: " + exercicio.getCaloriasQueimadas());
				} else {
					System.out.println("Exercicio não encontrado.");
				}
				break;

			case "8":
				System.out.println("Digite o id:");
				long idExcluirExercicio = scanner.nextLong();
				scanner.nextLine();
				ExercicioDTO exercicioDTODelete = new ExercicioDTO();
				exercicioDTODelete.setId(idExcluirExercicio);
				exercicioController.excluirExercicio(exercicioDTODelete);
				System.out.println("Exercicio excluído com sucesso.");
				break;

			case "9":
				System.out.println("Digite o id:");
				Long idAvaliacao = scanner.nextLong();
				System.out.println("Digite o id do Usuário:");
				Long idUsuarioAvaliacao = scanner.nextLong();
				System.out.println("Digite o peso:");
				double peso = scanner.nextDouble();
				System.out.println("Digite a altura:");
				double altura = scanner.nextDouble();
				double imc = peso / (altura * altura);
				scanner.nextLine();

				UsuarioDTO usuarioDTOAvaliacao = new UsuarioDTO();
				usuarioDTOAvaliacao.setId(idUsuarioAvaliacao);
				Usuario usuarioAvaliacao = usuarioController.obterUsuario(usuarioDTOAvaliacao);

				if (usuarioAvaliacao != null) {
					AvaliacaoFisicaDTO avaliacaoDTO = new AvaliacaoFisicaDTO();
					avaliacaoDTO.setId(idAvaliacao);
					avaliacaoDTO.setIdUsuario(idUsuarioAvaliacao);
					avaliacaoDTO.setPeso(peso);
					avaliacaoDTO.setAltura(altura);
					avaliacaoDTO.setImc(imc);
					avaliacaoFisicaController.adicionarAvaliacao(avaliacaoDTO);
				} else {
					System.out.println("Usuario não encontrado");
				}
				break;

			case "10":
				System.out.println("Digite o id:");
				Long idAtualizarAvaliacao = scanner.nextLong();
				System.out.println("Digite o id do Usuário:");
				Long idUsuarioAvaliacaoUpdate = scanner.nextLong();
				System.out.println("Digite o novo peso:");
				double novoPeso = scanner.nextDouble();
				System.out.println("Digite a nova altura:");
				double novaAltura = scanner.nextDouble();
				double novoImc = novoPeso / (novaAltura * novaAltura);
				scanner.nextLine();

				UsuarioDTO usuarioDTOAvaliacaoUpdate = new UsuarioDTO();
				usuarioDTOAvaliacaoUpdate.setId(idUsuarioAvaliacaoUpdate);
				Usuario usuarioAvaliacaoUpdate = usuarioController.obterUsuario(usuarioDTOAvaliacaoUpdate);

				if (usuarioAvaliacaoUpdate != null) {
					AvaliacaoFisicaDTO avaliacaoDTOUpdate = new AvaliacaoFisicaDTO();
					avaliacaoDTOUpdate.setId(idAtualizarAvaliacao);
					avaliacaoDTOUpdate.setIdUsuario(idUsuarioAvaliacaoUpdate);
					avaliacaoDTOUpdate.setPeso(novoPeso);
					avaliacaoDTOUpdate.setAltura(novaAltura);
					avaliacaoDTOUpdate.setImc(novoImc);
					avaliacaoFisicaController.atualizarAvaliacao(avaliacaoDTOUpdate);
				} else {
					System.out.println("Usuario não encontrado");
				}
				break;

			case "11":
				System.out.println("Digite o id:");
				Long idObterAvaliacao = scanner.nextLong();
				AvaliacaoFisicaDTO avaliacaoDTOGet = new AvaliacaoFisicaDTO();
				avaliacaoDTOGet.setId(idObterAvaliacao);
				AvaliacaoFisica avaliacao = avaliacaoFisicaController.obterAvaliacao(avaliacaoDTOGet);
				if (avaliacao != null) {
					System.out.println("Avaliação Física encontrada: Peso: " + avaliacao.getPeso() + ", Altura: " + avaliacao.getAltura() + ", IMC: " + avaliacao.getImc());
				} else {
					System.out.println("Avaliação Física não encontrada");
				}
				break;

			case "12":
				System.out.println("Digite o id:");
				Long idExcluirAvaliacao = scanner.nextLong();
				scanner.nextLine();
				AvaliacaoFisicaDTO avaliacaoDTODelete = new AvaliacaoFisicaDTO();
				avaliacaoDTODelete.setId(idExcluirAvaliacao);
				avaliacaoFisicaController.excluirAvaliacao(avaliacaoDTODelete);
				System.out.println("Avaliação Física excluída com sucesso");
				break;

			case "13":
				System.out.println("Saindo...");
				break;

			default:
				System.out.println("Opção inválida");
				break;
			}
		}
		scanner.close();
	}
}
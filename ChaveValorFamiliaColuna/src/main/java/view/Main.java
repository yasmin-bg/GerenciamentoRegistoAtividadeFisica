package view;

import dto.AvaliacaoFisicaDTO;
import dto.ExercicioDTO;
import dto.UsuarioDTO;
import controller.AvaliacaoFisicaController;
import controller.ExercicioController;
import controller.UsuarioController;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UsuarioController usuarioController = new UsuarioController();
        AvaliacaoFisicaController avaliacaoFisicaController = new AvaliacaoFisicaController();
        ExercicioController exercicioController = new ExercicioController();

        String escolha = "";

        while (!escolha.equals("10")) { 
            System.out.println("--------------------------------------------");
            System.out.println("Selecione uma opção:");
            System.out.println("--------------------------------------------");
            
            System.out.println("Usuário");
            System.out.println("1. Adicionar Usuário");
            System.out.println("2. Buscar Usuário");
            System.out.println("3. Excluir Usuário"); 

            System.out.println("--------------------------------------------");

            System.out.println("Exercício");

            System.out.println("4. Adicionar Exercício");
            System.out.println("5. Buscar Exercício");
            System.out.println("6. Excluir Exercício"); 

            System.out.println("--------------------------------------------");

            System.out.println("Avaliação Física");

            System.out.println("7. Adicionar Avaliação Física");
            System.out.println("8. Buscar Avaliação Física");
            System.out.println("9. Excluir Avaliação Física");

            System.out.println("--------------------------------------------");

            System.out.println("10. Sair");

            System.out.println("--------------------------------------------");

            escolha = scanner.nextLine();

            try {
                switch (escolha) {
                    case "1":
                        System.out.println("Digite o id do Usuário:");
                        long idUsuario = scanner.nextLong();
                        scanner.nextLine();

                        UsuarioDTO usuarioExistente = usuarioController.obterUsuario(new UsuarioDTO(idUsuario, new byte[0], new byte[0], new byte[0]));

                        if (usuarioExistente != null) {
                            System.out.println("Erro: Já existe um usuário com esse ID.");
                            break;
                        }

                        System.out.println("Digite o nome do Usuário:");
                        String nomeUsuario = scanner.nextLine();
                        System.out.println("Digite o email do Usuário:");
                        String emailUsuario = scanner.nextLine();
                        System.out.println("Digite a senha do Usuário:");
                        String senhaUsuario = scanner.nextLine();

                        UsuarioDTO usuarioDTO = new UsuarioDTO(idUsuario, nomeUsuario.getBytes(), emailUsuario.getBytes(), senhaUsuario.getBytes());

                        usuarioController.adicionarUsuario(usuarioDTO);
                        System.out.println("Usuário adicionado com sucesso.");
                        break;

                    case "2":
                        System.out.println("Digite o id do Usuário a ser buscado:");
                        long idObterUsuario = scanner.nextLong();
                        scanner.nextLine();  
                        UsuarioDTO usuarioDTOGet = new UsuarioDTO(idObterUsuario, new byte[0], new byte[0], new byte[0]);
                        UsuarioDTO usuario = usuarioController.obterUsuario(usuarioDTOGet);
                        if (usuario != null) {
                            System.out.println("Usuário encontrado: Nome: " + new String(usuario.getNome()));
                        } else {
                            System.out.println("Usuário não encontrado.");
                        }
                        break;

                    case "3": 
                        System.out.println("Digite o id do Usuário a ser excluído:");
                        long idExcluirUsuario = scanner.nextLong();
                        scanner.nextLine();
                        UsuarioDTO usuarioExcluir = new UsuarioDTO(idExcluirUsuario, new byte[0], new byte[0], new byte[0]);
                        UsuarioDTO usuarioEncontrado = usuarioController.obterUsuario(usuarioExcluir);
                        if (usuarioEncontrado != null) {
                            usuarioController.removerUsuario(usuarioExcluir);
                            System.out.println("Usuário excluído com sucesso.");
                        } else {
                            System.out.println("Erro: ID não encontrado.");
                        }
                        break;

                    case "4":
                        System.out.println("Digite o id do Exercício:");
                        long idExercicio = scanner.nextLong();
                        scanner.nextLine();  

                        ExercicioDTO exercicioExistente = exercicioController.obterExercicio(new ExercicioDTO(idExercicio));

                        if (exercicioExistente != null) {
                            System.out.println("Erro: Já existe um exercício com esse ID.");
                            break;
                        }
                        
                        System.out.println("Digite o id do Usuário associado ao exercício:");
                        long idUsuarioExercicio = scanner.nextLong();
                        scanner.nextLine();  
                        System.out.println("Digite o tipo de Exercício:");
                        String tipoExercicio = scanner.nextLine();
                        System.out.println("Digite a duração do Exercício (em minutos):");
                        String duracao = scanner.nextLine();
                        System.out.println("Digite as calorias queimadas no exercício:");
                        String caloriasQueimadas = scanner.nextLine(); 

                        UsuarioDTO usuarioAssociado = usuarioController.obterUsuario(new UsuarioDTO(idUsuarioExercicio, new byte[0], new byte[0], new byte[0]));

                        if (usuarioAssociado != null) {
                            ExercicioDTO exercicioDTO = new ExercicioDTO(idExercicio, idUsuarioExercicio, tipoExercicio.getBytes(), duracao.getBytes(), caloriasQueimadas.getBytes());
                            exercicioController.adicionarExercicio(exercicioDTO);
                            System.out.println("Exercício adicionado com sucesso.");
                        } else {
                            System.out.println("Erro: Usuário não encontrado.");
                        }
                        break;

                    case "5":
                        System.out.println("Digite o id do Exercício a ser buscado:");
                        long idObterExercicio = scanner.nextLong();
                        scanner.nextLine();  

                        ExercicioDTO exercicioDTOGet = new ExercicioDTO(idObterExercicio);
                        ExercicioDTO exercicio = exercicioController.obterExercicio(exercicioDTOGet);

                        if (exercicio != null) {
                            System.out.println("Exercício encontrado: ");
                            System.out.println("Tipo: " + new String(exercicio.getTipoExercicio()));
                            System.out.println("Duração: " + new String(exercicio.getDuracao()) + " minutos");
                            System.out.println("Calorias queimadas: " + new String(exercicio.getCaloriasQueimadas()));
                        } else {
                            System.out.println("Exercício não encontrado.");
                        }
                        break;

                    case "6":
                        System.out.println("Digite o id do Exercício a ser excluído:");
                        long idExcluirExercicio = scanner.nextLong();
                        scanner.nextLine();
                        ExercicioDTO exercicioExcluir = new ExercicioDTO(idExcluirExercicio);
                        ExercicioDTO exercicioEncontrado = exercicioController.obterExercicio(exercicioExcluir);
                        if (exercicioEncontrado != null) {
                            exercicioController.removerExercicio(exercicioExcluir);
                            System.out.println("Exercício excluído com sucesso.");
                        } else {
                            System.out.println("Erro: ID não encontrado.");
                        }
                        break;
                    	
                    case "7":
                        System.out.println("Digite o id da Avaliação Física:");
                        long idAvaliacao = scanner.nextLong();
                        scanner.nextLine();  

                        AvaliacaoFisicaDTO avaliacaoExistente = avaliacaoFisicaController.obterAvaliacao(new AvaliacaoFisicaDTO(idAvaliacao));

                        if (avaliacaoExistente != null) {
                            System.out.println("Erro: Já existe uma avaliação física com esse ID.");
                            break;
                        }

                        System.out.println("Digite o id do Usuário associado a Avaliacao Fisica:");
                        long idUsuarioAvaliacao = scanner.nextLong();
                        scanner.nextLine();
                     
                        System.out.println("Digite o peso do Usuário:");
                        String pesoString = scanner.nextLine();  
                        double peso = Double.parseDouble(pesoString); 

                        System.out.println("Digite a altura do Usuário:");
                        String alturaString = scanner.nextLine();  
                        double altura = Double.parseDouble(alturaString); 

                        double imc = peso / (altura * altura);  
                        String imcString = String.valueOf(imc); 
                       
                        UsuarioDTO usuarioAvaliacao = usuarioController.obterUsuario(new UsuarioDTO(idUsuarioAvaliacao, new byte[0], new byte[0], new byte[0]));

                        if (usuarioAvaliacao != null) {
                            AvaliacaoFisicaDTO avaliacaoDTO = new AvaliacaoFisicaDTO(idAvaliacao, idUsuarioAvaliacao, pesoString.getBytes(), alturaString.getBytes(), imcString.getBytes());
                            avaliacaoFisicaController.adicionarAvaliacao(avaliacaoDTO);
                            System.out.println("Avaliação Física adicionada com sucesso.");
                        } else {
                            System.out.println("Erro: Usuário não encontrado.");
                        }
                        break;

                    case "8":
                        System.out.println("Digite o id da Avaliação Física a ser buscada:");
                        long idObterAvaliacao = scanner.nextLong();
                        scanner.nextLine();  

                        AvaliacaoFisicaDTO avaliacaoDTOGet = new AvaliacaoFisicaDTO(idObterAvaliacao);
                        AvaliacaoFisicaDTO avaliacao = avaliacaoFisicaController.obterAvaliacao(avaliacaoDTOGet);

                        if (avaliacao != null) {
                            System.out.println("Avaliação Física encontrada:");
                            System.out.println("Peso: " + new String(avaliacao.getPeso()));
                            System.out.println("Altura: " + new String(avaliacao.getAltura()));
                            double imcConversao = Double.parseDouble(new String(avaliacao.getImc()));
                            System.out.printf("IMC: %.2f%n", imcConversao);
                        } else {
                            System.out.println("Avaliação Física não encontrada.");
                        }
                        break;

                    case "9": 
                        System.out.println("Digite o id da Avaliação Física a ser excluída:");
                        long idExcluirAvaliacao = scanner.nextLong();
                        scanner.nextLine();
                        AvaliacaoFisicaDTO avaliacaoExcluir = new AvaliacaoFisicaDTO(idExcluirAvaliacao);
                        AvaliacaoFisicaDTO avaliacaoEncontrada = avaliacaoFisicaController.obterAvaliacao(avaliacaoExcluir);
                        if (avaliacaoEncontrada != null) {
                            avaliacaoFisicaController.removerAvaliacao(avaliacaoExcluir);
                            System.out.println("Avaliação Física excluída com sucesso.");
                        } else {
                            System.out.println("Erro: ID não encontrado.");
                        }
                        break;

                    case "10":
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
package view;

import dto.ExercicioDTO;
import dto.UsuarioDTO;
import controller.ExercicioController;
import controller.UsuarioController;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UsuarioController usuarioController = new UsuarioController();
        ExercicioController exercicioController = new ExercicioController();

        String escolha = "";

        while (!escolha.equals("7")) { 
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

            System.out.println("7. Sair");

            System.out.println("--------------------------------------------");

            escolha = scanner.nextLine();

            try {
                switch (escolha) {
                    case "1":
                        System.out.println("Digite o id do Usuário:");
                        long idUsuario = scanner.nextLong();
                        scanner.nextLine();

                        UsuarioDTO usuarioExistente = usuarioController.obterUsuario(new UsuarioDTO(idUsuario));

                        if (usuarioExistente != null) {
                            System.out.println("Erro: Já existe um usuário com esse ID.");
                            break;
                        }

                        System.out.println("Digite o nome do Usuário:");
                        String nomeUsuario = scanner.nextLine();

                        UsuarioDTO usuarioDTO = new UsuarioDTO(idUsuario, nomeUsuario);

                        usuarioController.adicionarUsuario(usuarioDTO);
                        System.out.println("Usuário adicionado com sucesso.");
                        break;

                    case "2":
                        System.out.println("Digite o id do Usuário a ser buscado:");
                        long idObterUsuario = scanner.nextLong();
                        scanner.nextLine();  
                        UsuarioDTO usuarioDTOGet = new UsuarioDTO(idObterUsuario);
                        UsuarioDTO usuario = usuarioController.obterUsuario(usuarioDTOGet);
                        if (usuario != null) {
                            System.out.println("Usuário encontrado: Nome: " + usuario.getNome());
                        } else {
                            System.out.println("Usuário não encontrado.");
                        }
                        break;

                    case "3": 
                        System.out.println("Digite o id do Usuário a ser excluído:");
                        long idExcluirUsuario = scanner.nextLong();
                        scanner.nextLine();
                        UsuarioDTO usuarioExcluir = new UsuarioDTO(idExcluirUsuario);
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
                        
                        System.out.println("Digite o tipo de Exercício:");
                        String tipoExercicio = scanner.nextLine();

                        ExercicioDTO exercicioDTO = new ExercicioDTO(idExercicio, tipoExercicio);
                        exercicioController.adicionarExercicio(exercicioDTO);
                        System.out.println("Exercício adicionado com sucesso.");
                        break;

                    case "5":
                        System.out.println("Digite o id do Exercício a ser buscado:");
                        long idObterExercicio = scanner.nextLong();
                        scanner.nextLine();  

                        ExercicioDTO exercicioDTOGet = new ExercicioDTO(idObterExercicio);
                        ExercicioDTO exercicio = exercicioController.obterExercicio(exercicioDTOGet);

                        if (exercicio != null) {
                            System.out.println("Exercício encontrado: ");
                            System.out.println("Tipo: " + exercicio.getTipoExercicio());
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
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
        scanner.close();
    }
}

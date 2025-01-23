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

        while (!escolha.equals("14")) {
            System.out.println("--------------------------------------------");
            System.out.println("Usuário");
            System.out.println("Selecione uma opção:");
            System.out.println("1. Adicionar Usuario");
            System.out.println("2. Atualizar Usuario");
            System.out.println("3. Obter Usuario");
            System.out.println("4. Excluir Usuario");
            System.out.println("5. Listar Todos os Usuários");

            System.out.println("--------------------------------------------");

            System.out.println("Exercicio");

            System.out.println("6. Adicionar Exercicio");
            System.out.println("7. Atualizar Exercicio");
            System.out.println("8. Obter Exercicio");
            System.out.println("9. Excluir Exercicio");
            System.out.println("10. Listar Todos os Exercícios");

            System.out.println("--------------------------------------------");

            System.out.println("Avaliacao Física");

            System.out.println("11. Adicionar Avaliacao Física");
            System.out.println("12. Atualizar Avaliacao Física");
            System.out.println("13. Obter Avaliacao Física");
            System.out.println("14. Excluir Avaliacao Física");

            System.out.println("--------------------------------------------");

            escolha = scanner.nextLine().toLowerCase();

            switch (escolha) {
                case "1":
                    System.out.println("Digite o id do Usuário:");
                    Long idUsuario = scanner.nextLong();
                    scanner.nextLine();

                    // Verificação para evitar duplicação de ID
                    if (usuarioController.obterUsuario(new UsuarioDTO(idUsuario)) != null) {
                        System.out.println("Erro: Já existe um usuário com esse ID.");
                        break;
                    }

                    System.out.println("Digite o nome do Usuário:");
                    String nomeUsuario = scanner.nextLine();
                    System.out.println("Digite o email do Usuário:");
                    String emailUsuario = scanner.nextLine();
                    System.out.println("Digite a senha do Usuário:");
                    String senhaUsuario = scanner.nextLine();
                    
                    UsuarioDTO usuarioDTO = new UsuarioDTO(idUsuario, nomeUsuario, emailUsuario, senhaUsuario);
                    usuarioController.adicionarUsuario(usuarioDTO);
                    System.out.println("Usuário adicionado com sucesso.");
                    break;

                case "2":
                    System.out.println("Digite o id do Usuário a ser atualizado:");
                    Long idAtualizarUsuario = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Digite o novo nome do Usuário:");
                    String nomeAtualizadoUsuario = scanner.nextLine();
                    System.out.println("Digite o novo email do Usuário:");
                    String emailAtualizadoUsuario = scanner.nextLine();
                    System.out.println("Digite a nova senha do Usuário:");
                    String senhaAtualizadaUsuario = scanner.nextLine();
                    UsuarioDTO usuarioDTOUpdate = new UsuarioDTO(idAtualizarUsuario, nomeAtualizadoUsuario, emailAtualizadoUsuario, senhaAtualizadaUsuario);
                    usuarioController.atualizarUsuario(usuarioDTOUpdate);
                    System.out.println("Usuário atualizado com sucesso.");
                    break;

                case "3":
                    System.out.println("Digite o id do Usuário a ser buscado:");
                    Long idObterUsuario = scanner.nextLong();
                    scanner.nextLine();
                    UsuarioDTO usuarioDTOGet = new UsuarioDTO();
                    usuarioDTOGet.setId(idObterUsuario);
                    Usuario usuario = usuarioController.obterUsuario(usuarioDTOGet);
                    if (usuario != null) {
                        System.out.println("Usuário encontrado: " + usuario.getNome());
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case "4":
                    System.out.println("Digite o id do Usuário a ser excluído:");
                    Long idExcluirUsuario = scanner.nextLong();
                    scanner.nextLine();
                    UsuarioDTO usuarioDTODelete = new UsuarioDTO();
                    usuarioDTODelete.setId(idExcluirUsuario);
                    usuarioController.excluirUsuario(usuarioDTODelete);
                    System.out.println("Usuário excluído com sucesso.");
                    break;

                case "5": // Listar Todos os Usuários
                    System.out.println("Lista de Usuários:");
                    for (UsuarioDTO usuarioList : usuarioController.listarTodosUsuarios()) {
                        System.out.println("id: " + usuarioList.getId() + ", Nome: " + usuarioList.getNome());
                    }
                    break;

                case "6":
                    System.out.println("Digite o id do Exercício:");
                    long idExercicio = scanner.nextLong();
                    scanner.nextLine();

                    // Verificação para evitar duplicação de ID
                    if (exercicioController.obterExercicio(new ExercicioDTO(idExercicio)) != null) {
                        System.out.println("Erro: Já existe um exercício com esse ID.");
                        break;
                    }

                    System.out.println("Digite o tipo de Exercício:");
                    String tipoExercicio = scanner.nextLine();
                    System.out.println("Digite a duração do Exercício (em minutos):");
                    int duracao = scanner.nextInt();
                    System.out.println("Digite as calorias queimadas no exercício:");
                    int caloriasQueimadas = scanner.nextInt();

                    System.out.println("Digite o id do Usuário associado ao exercício:");
                    Long idUsuarioExercicio = scanner.nextLong();
                    scanner.nextLine();

                    UsuarioDTO usuarioDTOExercicio = new UsuarioDTO();
                    usuarioDTOExercicio.setId(idUsuarioExercicio);
                    Usuario usuarioAssociado = usuarioController.obterUsuario(usuarioDTOExercicio);

                    if (usuarioAssociado != null) {
                        ExercicioDTO exercicioDTO = new ExercicioDTO(idExercicio, idUsuarioExercicio, tipoExercicio, duracao, caloriasQueimadas);
                        exercicioController.adicionarExercicio(exercicioDTO);
                        System.out.println("Exercício adicionado com sucesso.");
                    } else {
                        System.out.println("Erro: Usuário não encontrado.");
                    }
                    break;

                case "7":
                    System.out.println("Digite o id do Exercício a ser atualizado:");
                    long idAtualizarExercicio = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Digite o id do Usuário:");
                    Long idUsuarioExercicioUpdate = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Digite o novo tipo de Exercício:");
                    String tipoExercicioAtualizado = scanner.nextLine();
                    System.out.println("Digite a nova duração do Exercício (em minutos):");
                    int duracaoAtualizada = scanner.nextInt();
                    System.out.println("Digite as novas calorias queimadas:");
                    int caloriasQueimadasAtualizadas = scanner.nextInt();

                    UsuarioDTO usuarioDTOExercicioUpdate = new UsuarioDTO();
                    usuarioDTOExercicioUpdate.setId(idUsuarioExercicioUpdate);
                    Usuario usuarioAssociadoUpdate = usuarioController.obterUsuario(usuarioDTOExercicioUpdate);

                    if (usuarioAssociadoUpdate != null) {
                        ExercicioDTO exercicioDTOUpdate = new ExercicioDTO(idAtualizarExercicio, idUsuarioExercicioUpdate, tipoExercicioAtualizado, duracaoAtualizada, caloriasQueimadasAtualizadas);
                        exercicioController.atualizarExercicio(exercicioDTOUpdate);
                        System.out.println("Exercício atualizado com sucesso.");
                    } else {
                        System.out.println("Erro: Usuário não encontrado.");
                    }
                    break;

                case "8":
                    System.out.println("Digite o id do Exercício a ser buscado:");
                    long idObterExercicio = scanner.nextLong();
                    ExercicioDTO exercicioDTOGet = new ExercicioDTO();
                    exercicioDTOGet.setId(idObterExercicio);
                    Exercicio exercicio = exercicioController.obterExercicio(exercicioDTOGet);
                    if (exercicio != null) {
                        System.out.println("Exercício encontrado: Tipo: " + exercicio.getTipoExercicio() + ", Duração: " + exercicio.getDuracao() + " minutos, Calorias queimadas: " + exercicio.getCaloriasQueimadas());
                    } else {
                        System.out.println("Exercício não encontrado.");
                    }
                    break;

                case "9":
                    System.out.println("Digite o id do Exercício a ser excluído:");
                    long idExcluirExercicio = scanner.nextLong();
                    scanner.nextLine();
                    ExercicioDTO exercicioDTODelete = new ExercicioDTO();
                    exercicioDTODelete.setId(idExcluirExercicio);
                    exercicioController.excluirExercicio(exercicioDTODelete);
                    System.out.println("Exercício excluído com sucesso.");
                    break;

                case "10": // Listar Todos os Exercícios
                    System.out.println("Lista de Exercícios:");
                    for (ExercicioDTO exercicioList : exercicioController.listarTodosExerciciosComUsuarioRelacionado()) {
                        System.out.println("id: " + exercicioList.getId() + ", Tipo: " + exercicioList.getTipoExercicio());
                    }
                    break;

                case "11":
                    System.out.println("Digite o id da Avaliação Física:");
                    Long idAvaliacao = scanner.nextLong();
                    scanner.nextLine();

                    // Verificação para evitar duplicação de ID
                    if (avaliacaoFisicaController.obterAvaliacao(new AvaliacaoFisicaDTO(idAvaliacao)) != null) {
                        System.out.println("Erro: Já existe uma avaliação com esse ID.");
                        break;
                    }

                    System.out.println("Digite o id do Usuário:");
                    Long idUsuarioAvaliacao = scanner.nextLong();
                    System.out.println("Digite o peso do Usuário:");
                    double peso = scanner.nextDouble();
                    System.out.println("Digite a altura do Usuário:");
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
                        System.out.println("Avaliação Física adicionada com sucesso.");
                    } else {
                        System.out.println("Erro: Usuário não encontrado.");
                    }
                    break;

                case "12":
                    System.out.println("Digite o id da Avaliação Física a ser atualizada:");
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
                        System.out.println("Avaliação Física atualizada com sucesso.");
                    } else {
                        System.out.println("Erro: Usuário não encontrado.");
                    }
                    break;

                case "13":
                    System.out.println("Digite o id da Avaliação Física a ser buscada:");
                    Long idObterAvaliacao = scanner.nextLong();
                    AvaliacaoFisicaDTO avaliacaoDTOGet = new AvaliacaoFisicaDTO();
                    avaliacaoDTOGet.setId(idObterAvaliacao);
                    AvaliacaoFisica avaliacao = avaliacaoFisicaController.obterAvaliacao(avaliacaoDTOGet);
                    if (avaliacao != null) {
                        System.out.println("Avaliação Física encontrada: Peso: " + avaliacao.getPeso() + ", Altura: " + avaliacao.getAltura() + ", IMC: " + avaliacao.getImc());
                    } else {
                        System.out.println("Avaliação Física não encontrada.");
                    }
                    break;

                case "14":
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}
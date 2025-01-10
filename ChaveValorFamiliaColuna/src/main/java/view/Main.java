package view;

import dto.ExercicioDTO;
import model.Exercicio;
import dao.ExercicioDAO;
import dto.UsuarioDTO;
import model.Usuario;
import dao.UsuarioDAO;
import controller.ExercicioController;
import controller.UsuarioController;
import dto.AvaliacaoFisicaDTO;
import model.AvaliacaoFisica;
import controller.AvaliacaoFisicaController;

public class Main {

    public static void main(String[] args) {
        ExercicioController exercicioController = new ExercicioController();
        UsuarioController usuarioController = new UsuarioController();
        AvaliacaoFisicaController avaliacaoFisicaController = new AvaliacaoFisicaController();

        // Criando e adicionando um usuário
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(1L);
        usuarioDTO.setNome("João");
        usuarioDTO.setEmail("joao@exemplo.com");
        usuarioDTO.setSenha("senha123");

        System.out.println("Adicionando usuário...");
        usuarioController.adicionarUsuario(usuarioDTO);

        // Obtendo o usuário
        System.out.println("\nObtendo usuário...");
        Usuario usuario = usuarioController.obterUsuario(usuarioDTO);
        if (usuario != null) {
            System.out.println("Usuário obtido: " + usuario.getNome());
        } else {
            System.out.println("Usuário não encontrado.");
        }

        // Criando e adicionando um exercício
        ExercicioDTO exercicioDTO = new ExercicioDTO();
        exercicioDTO.setId(1L);
        exercicioDTO.setTipoExercicio("Corrida");
        exercicioDTO.setDuracao(30);
        exercicioDTO.setCaloriasQueimadas(300);

        System.out.println("\nAdicionando exercício...");
        exercicioController.adicionarExercicio(exercicioDTO);

        // Obtendo o exercício
        System.out.println("\nObtendo exercício...");
        Exercicio exercicio = exercicioController.obterExercicio(exercicioDTO);
        if (exercicio != null) {
            System.out.println("Exercício obtido: " + exercicio.getTipoExercicio());
        } else {
            System.out.println("Exercício não encontrado.");
        }

        // Atualizando o exercício
        System.out.println("\nAtualizando exercício...");
        exercicioDTO.setDuracao(45);
        exercicioDTO.setCaloriasQueimadas(450);
        exercicioController.atualizarExercicio(exercicioDTO);

        // Obtendo o exercício após atualização
        System.out.println("\nObtendo exercício após atualização...");
        exercicio = exercicioController.obterExercicio(exercicioDTO);
        if (exercicio != null) {
            System.out.println("Exercício atualizado: " + exercicio.getTipoExercicio() + ", Duração: " + exercicio.getDuracao());
        } else {
            System.out.println("Exercício não encontrado.");
        }

        // Criando e adicionando uma avaliação física
        AvaliacaoFisicaDTO avaliacaoFisicaDTO = new AvaliacaoFisicaDTO();
        avaliacaoFisicaDTO.setId(1L);
        avaliacaoFisicaDTO.setIdUsuario(1L);
        avaliacaoFisicaDTO.setPeso(70.5);
        avaliacaoFisicaDTO.setAltura(1.75);
        avaliacaoFisicaDTO.setImc(22.9);

        System.out.println("\nAdicionando avaliação física...");
        avaliacaoFisicaController.adicionarAvaliacao(avaliacaoFisicaDTO);

        // Obtendo a avaliação física
        System.out.println("\nObtendo avaliação física...");
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaController.obterAvaliacao(avaliacaoFisicaDTO);
        if (avaliacaoFisica != null) {
            System.out.println("Avaliação física obtida: Peso: " + avaliacaoFisica.getPeso() + ", IMC: " + avaliacaoFisica.getImc());
        } else {
            System.out.println("Avaliação física não encontrada.");
        }

        // Atualizando a avaliação física
        System.out.println("\nAtualizando avaliação física...");
        avaliacaoFisicaDTO.setPeso(72.0);
        avaliacaoFisicaDTO.setImc(23.5);
        avaliacaoFisicaController.atualizarAvaliacao(avaliacaoFisicaDTO);

        // Obtendo a avaliação física após atualização
        System.out.println("\nObtendo avaliação física após atualização...");
        avaliacaoFisica = avaliacaoFisicaController.obterAvaliacao(avaliacaoFisicaDTO);
        if (avaliacaoFisica != null) {
            System.out.println("Avaliação física atualizada: Peso: " + avaliacaoFisica.getPeso() + ", IMC: " + avaliacaoFisica.getImc());
        } else {
            System.out.println("Avaliação física não encontrada.");
        }
    }
}
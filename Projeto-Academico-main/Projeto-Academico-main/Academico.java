
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Academico {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Map<Integer, Cursos> cursos = new LinkedHashMap<>();
        Map<Integer, Disciplinas> disciplinas = new LinkedHashMap<>();
        Map<Integer, Professores> professores = new LinkedHashMap<>();
        Map<Integer, Map<Integer, Double>> notas = new LinkedHashMap<>();
        Map<Integer, Aluno> alunos = new LinkedHashMap<>();

        int opcaoPrimaria; //opcao de escolha do menu principal
        int opcaoSecundaria; //opcao de escolha dos menus secundarios
        boolean codigoValido = false; //validação para os código, matriculas, etc...
        boolean rodando = true;        

        while (rodando == true) {
            System.out.println("==== MENU PRINCIPAL ====\n");//menu interativo principal
            System.out.println("1 - Gerenciar cursos");
            System.out.println("2 - Gerenciar alunos");
            System.out.println("3 - Gerenciar disciplinas");
            System.out.println("4 - Gerenciar professores");
            System.out.println("5 - Gerenciar notas");
            System.out.println("6 - Sair\n");
            System.out.print("Escolha uma opção: ");
            opcaoPrimaria = entrada.nextInt();
            entrada.nextLine();
            System.out.println();

            switch (opcaoPrimaria) {

                case 1:
                    while (true) {
                        System.out.println("==== MENU CURSO ====\n");
                        System.out.println("1 - Cadastrar curso");
                        System.out.println("2 - Listar cursos");
                        System.out.println("3 - Retornar ao menu principal\n");
                        System.out.print("Selecione uma opção: ");
                        opcaoSecundaria = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println();

                        switch (opcaoSecundaria) { //opções do menu curso
                            case 1:
                                while (true) {
                                    int codigo;
                                    while (true) {
                                        try { //Verifica se a entrada é um número inteiro
                                            System.out.print("Digite o Código do curso: ");
                                            codigo = entrada.nextInt();
                                            codigoValido = true;
                                            break;
                                        } catch (InputMismatchException e) { //se não for, retorna a mensagem para o usuário digitar novamente
                                            System.out.println("Digite apenas números inteiros!");
                                        }
                                    }
                                    entrada.nextLine();
                                    System.out.print("Digite o nome do curso: ");//nome do curso
                                    String nome = entrada.nextLine();
                                    System.out.println();

                                    if (cursos.containsKey(codigo)) { // verifica se o codigo do curso já existe
                                        System.out.println("Já existe um curso com esse código!");
                                        System.out.println();

                                        String tentarNovamente; //durante a verificação de duplicata, pergunta ao usuario se deseja continuar o cadastro
                                        while (true) {
                                            System.out.print("Deseja tentar novamente? (S/N): ");
                                            tentarNovamente = entrada.nextLine();
                                            if (tentarNovamente.equalsIgnoreCase("S") || (tentarNovamente.equalsIgnoreCase("N"))) {
                                                break;
                                            } else {
                                                System.out.println("Dígito inválido, tente novamente!");
                                            }
                                        }

                                        if (tentarNovamente.equalsIgnoreCase("S")) {
                                            System.out.println();
                                            continue;
                                        } else {
                                            System.out.println();
                                            break;
                                        }
                                    }

                                    boolean nomeJaExistente = false;
                                    for (Map.Entry<Integer, Cursos> cEntry : cursos.entrySet()) {
                                        if (cEntry.getValue().getNome().equalsIgnoreCase(nome)) {
                                            nomeJaExistente = true; //verifica se o nome ja existe
                                            break;
                                        }
                                    }

                                    if (nomeJaExistente) { //se existir joga para o cadastro novamente do curso
                                        System.out.println("Já existe um curso com esse nome!");
                                        System.out.println();

                                        String tentarNovamente;
                                        while (true) {
                                            System.out.print("Deseja tentar novamente? (S/N): ");
                                            tentarNovamente = entrada.nextLine();
                                            if (tentarNovamente.equalsIgnoreCase("S") || (tentarNovamente.equalsIgnoreCase("N"))) {
                                                break;
                                            } else {
                                                System.out.println("Dígito inválido, tente novamente!");
                                            }
                                        }

                                        if (tentarNovamente.equalsIgnoreCase("S")) {
                                            System.out.println();
                                            continue;
                                        } else {
                                            System.out.println();
                                            break;
                                        }
                                    }

                                    cursos.put(codigo, new Cursos(codigo, nome));
                                    System.out.println("\n-------------------------------");
                                    System.out.println("Curso cadastrado com sucesso!");
                                    System.out.println("-------------------------------");
                                    System.out.println();

                                    String resposta;
                                    while (true) {
                                        System.out.print("Deseja continuar? (S/N): ");
                                        resposta = entrada.nextLine();
                                        System.out.println();
                                        if (resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("N")) {
                                            break;
                                        } else {
                                            System.out.println("Dígito inválido, tente novamente!");
                                        }
                                    }
                                    if (resposta.equalsIgnoreCase("N")) {
                                        System.out.println();
                                        break;
                                    }
                                }
                                break;

                            case 2://listar cursos
                                if (cursos.isEmpty()) {
                                    System.out.println("Lista vazia! Adicione um curso.");
                                    System.out.println();
                                } else {
                                    System.out.println("====== Cursos Cadastrados ======\n");
                                    for (Map.Entry<Integer, Cursos> p : cursos.entrySet()) {
                                        int codigoC = p.getKey();
                                        Cursos n = p.getValue();

                                        System.out.println("Código: " + codigoC + " | Curso: " + n.getNome());
                                        System.out.println("------------------------------------------------------------------");
                                        System.out.println();
                                    }
                                }
                                break;

                            case 3://retornar ao menu principal
                                System.out.println("Retornando ao menu principal...");
                                System.out.println();
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente!");
                                System.out.println();
                        }
                        if (opcaoSecundaria == 3) {
                            break;
                        }
                    }
                    break;//fim do menu cursos

                case 2:// menu alunos
                    while (true) {
                        System.out.println("==== MENU ALUNOS ====\n");
                        System.out.println("1 - Cadastrar alunos");
                        System.out.println("2 - Listar alunos");
                        System.out.println("3 - Retornar ao menu principal\n");
                        System.out.print("Selecione uma opção: ");
                        opcaoSecundaria = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println();

                        switch (opcaoSecundaria) { //opções do menu aluno
                            case 1:
                                while (true) {
                                    int matricula;
                                    while (true) {
                                        try { //Verifica se a entrada é um número inteiro
                                            System.out.print("Digite o número da matricula: ");
                                            matricula = entrada.nextInt();
                                            codigoValido = true;
                                            break;
                                        } catch (InputMismatchException e) { //se não for, retorna a mensagem para o usuário digitar novamente
                                            System.out.println("Digite apenas números inteiros!");
                                        }
                                    }
                                    entrada.nextLine();
                                    System.out.print("Digite o nome do aluno: ");//nome do aluno
                                    String nomeAluno = entrada.nextLine();
                                    System.out.println();

                                    if (alunos.containsKey(matricula)) {//verificação de duplicação de matriculas
                                        System.out.println("Já existe um aluno com essa matrícula!\n");

                                        String tentarNovamente;
                                        while (true) {
                                            System.out.print("Deseja continuar? (S/N): ");
                                            tentarNovamente = entrada.nextLine();

                                            if (tentarNovamente.equalsIgnoreCase("S") || tentarNovamente.equalsIgnoreCase("N")) {
                                                break;
                                            } else {
                                                System.out.println("Dígito inválido, tente novamente!");
                                            }
                                        }

                                        if (tentarNovamente.equalsIgnoreCase("S")) {
                                            System.out.println();
                                            continue;
                                        } else {
                                            System.out.println();
                                            break;
                                        }
                                    }

                                    System.out.println("==== Cursos Disponíveis ====");

                                    for (Map.Entry<Integer, Cursos> entry : cursos.entrySet()) {//lista os cursos para seleção
                                        System.out.println(entry.getKey() + " | " + entry.getValue().getNome());
                                        System.out.println("-----------------------------------------------------");
                                    }
                                    System.out.println();

                                    Cursos cursoEscolhido = null;

                                    if (cursos.isEmpty()) { // informa que não ha cursos cadastrados e encerra o cadastro
                                        System.out.println("Nenhum curso cadastrado! cadastre um curso antes de prosseguir");
                                        System.out.println();
                                        break;
                                    }

                                    while (cursoEscolhido == null) { // pede o código do curso para fazer a atribuição
                                        System.out.println("Digite o código do curso desejado: ");

                                        int codigoCurso;
                                        try {
                                            codigoCurso = entrada.nextInt();
                                            entrada.nextLine();
                                        } catch (InputMismatchException e) {
                                            System.out.println("Dígito inválido, digite apenas números inteiros!");
                                            entrada.nextLine();
                                            continue;
                                        }

                                        cursoEscolhido = cursos.get(codigoCurso); // faz a associação do código com o curso existente

                                        if (cursoEscolhido == null) {//mostra erro ao digitar um código que não seja igual aos disponíveis
                                            System.out.println("Código inválido, tente novamente!");
                                            System.out.println();
                                        }
                                    }

                                    alunos.put(matricula, new Aluno(matricula, nomeAluno, cursoEscolhido));//objeto criado e adicionado ao map

                                    System.out.println("\n-------------------------------");
                                    System.out.println("Aluno cadastrado com sucesso!");
                                    System.out.println("-------------------------------");
                                    System.out.println();

                                    String resposta;
                                    while (true) {
                                        System.out.print("Deseja continuar? (S/N): ");
                                        resposta = entrada.nextLine();
                                        if (resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("N")) {
                                            System.out.println();
                                            break;
                                        } else {
                                            System.out.println("Dígito inválido, tente novamente!");
                                        }
                                    }
                                    if (resposta.equalsIgnoreCase("N")) {
                                        System.out.println();
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                if (alunos.isEmpty()) { //se nao houver nenhum aluno dentro do map, retorna esta mensagem abaixo.
                                    System.out.println("Nenhum aluno cadastrado, adicione um novo aluno para prosseguir!");
                                    System.out.println();
                                } else {
                                    System.out.println("==== Alunos Cadastrados ====\n"); //se houver, printa na tela todos os alunos cadastrados.
                                    for (Map.Entry<Integer, Aluno> a : alunos.entrySet()) {
                                        Integer a1 = a.getKey();
                                        Aluno a2 = a.getValue();
                                        System.out.println("Matrícula: " + a1);
                                        System.out.println("Aluno: " + a2.getNome());
                                        System.out.println("Curso: " + a2.getCurso());
                                        System.out.println("\n------------------------------------------------------------------");
                                        System.out.println();
                                    }
                                }
                                break;

                            case 3://retorna ao menu principal
                                System.out.println("Retornando ao menu principal...");
                                System.out.println();
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente!");
                                System.out.println();
                                break;
                        }
                        if (opcaoSecundaria == 3) {
                            break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.println("==== MENU DISCIPLINAS ====\n");
                        System.out.println("1 - cadastrar disciplinas");
                        System.out.println("2 - listar disciplinas");
                        System.out.println("3 - Retornar ao menu principal\n");
                        System.out.print("Escolha uma opção: ");
                        opcaoSecundaria = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println();

                        switch (opcaoSecundaria) {
                            case 1:
                                while (true) { // menu disciplina
                                    int codigoDisciplina;
                                    while (true) {
                                        try {
                                            System.out.print("Digite o código da disciplina: ");//verifica se o código da disciplina só possui números inteiros
                                            codigoDisciplina = entrada.nextInt();
                                            codigoValido = true;
                                            break;
                                        } catch (InputMismatchException e) {
                                            System.out.println("Digite apenas números inteiros!");// se houver algo que não seja números inteiros retorna essa mensagem
                                        }
                                    }

                                    entrada.nextLine();
                                    System.out.print("Digite o nome da disciplina: "); //variavel do nome da disciplina
                                    String nomeDisciplina = entrada.nextLine();
                                    System.out.println();

                                    if (disciplinas.containsKey(codigoDisciplina)) {
                                        System.out.println("Já existe uma disciplina com esse código!");//verifica se o código da discplina já existe
                                        System.out.println();

                                        String tentarNovamente;
                                        while (true) {
                                            System.out.println("Deseja tentar novamente? (S/N): "); //pergunta ao usuário se ele quer continuar com o cadastro da disciplina
                                            tentarNovamente = entrada.nextLine();
                                            if (tentarNovamente.equalsIgnoreCase("S") || (tentarNovamente.equalsIgnoreCase("N"))) {
                                                break;
                                            } else {
                                                System.out.println("Dígito inválido, tente novamente!");
                                            }
                                        }

                                        if (tentarNovamente.equalsIgnoreCase("S")) {
                                            System.out.println();
                                            continue;
                                        } else {
                                            System.out.println();
                                            break;
                                        }
                                    }

                                    boolean nomeJaExiste = false; //verifica se o nome da disciplina já existe
                                    for (Map.Entry<Integer, Disciplinas> dEntry : disciplinas.entrySet()) {
                                        if (dEntry.getValue().getNome().equalsIgnoreCase(nomeDisciplina)) {
                                            nomeJaExiste = true;
                                            break;
                                        }
                                    }

                                    if (disciplinas.containsValue(nomeDisciplina)) {
                                        System.out.println("Já contém uma disciplina com esse nome!");// retorna que já existe uma disciplina com esse nome
                                        System.out.println();

                                        String tentarNovamente;
                                        while (true) {
                                            System.out.println("Deseja tentar novamente? (S/N): ");//pergunta ao usuário se ele deseja continuar o cadastro
                                            tentarNovamente = entrada.nextLine();
                                            if (tentarNovamente.equalsIgnoreCase("S") || tentarNovamente.equalsIgnoreCase("N")) {
                                                break;
                                            } else {
                                                System.out.println("Dígito inválido, tente novamente!");
                                            }
                                        }

                                        if (tentarNovamente.equalsIgnoreCase("N")) {
                                            System.out.println();
                                            break;
                                        } else {
                                            System.out.println();
                                            continue;
                                        }
                                    }

                                    disciplinas.put(codigoDisciplina, new Disciplinas(codigoDisciplina, nomeDisciplina));//cria um novo objeto e adiciona ao map
                                    System.out.println("\n-------------------------------");
                                    System.out.println("Disciplina cadastrada com sucesso!");
                                    System.out.println("-------------------------------");
                                    System.out.println();

                                    String resposta;
                                    while (true) {
                                        System.out.print("Deseja continuar? (S/N): ");
                                        resposta = entrada.nextLine();
                                        if (resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("N")) {
                                            break;
                                        } else {
                                            System.out.println("Dígito inválido, tente novamente!");
                                            System.out.println();
                                        }
                                    }

                                    if (resposta.equalsIgnoreCase("N")) {
                                        System.out.println();
                                        break;
                                    } else {
                                        System.out.println();
                                        continue;
                                    }
                                }
                                break;

                            case 2: // listar as disciplinas
                                if (disciplinas.isEmpty()) {
                                    System.out.println("Lista vazia, cadastre uma disciplina para prosseguir!");
                                    System.out.println();
                                } else {
                                    System.out.println("==== Disciplinas ====\n");
                                    for (Map.Entry<Integer, Disciplinas> dEntry : disciplinas.entrySet()) {
                                        System.out.println("Código: " + dEntry.getKey() + " | " + "Disciplina: " + dEntry.getValue().getNome());
                                        System.out.println("--------------------------------------------------------------------\n");
                                    }
                                }
                                break;

                            case 3:
                                System.out.println("Retornando ao menu principal...");
                                System.out.println();
                                break;

                            default:
                                System.out.println("Opção inválida, tente novamente!");
                                break;
                        }
                        if (opcaoSecundaria == 3) {
                            break;
                        }
                    }
                    break;
                case 4:
                    while (true) {
                        System.out.println("==== MENU PROFESSORES ====\n");
                        System.out.println("1 - Cadastrar professores");
                        System.out.println("2 - Listar professores");
                        System.out.println("3 - Retornar para o menu principal\n");
                        System.out.println("Escolha uma opção: ");
                        opcaoSecundaria = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println();

                        switch (opcaoSecundaria) {
                            case 1:
                                while (true) {
                                    int matriculaProfessor;
                                    while (true) {
                                        try {
                                            System.out.println("Digite o número da matrícula: ");//verificação se os número da matrícula são apenas números inteiros.
                                            matriculaProfessor = entrada.nextInt();
                                            codigoValido = true;// validação para saber se a matrícula está de acordo para prosseguir.
                                            break;
                                        } catch (InputMismatchException e) {
                                            System.out.println("Digite apenas números inteiros!");//se estiver em desacordo, exibe a mensagem de erro aqui presente.
                                        }
                                    }
                                    entrada.nextLine();
                                    System.out.println("Digite o nome do professor: ");// pede ao usuário o nome do professor a ser cadastrado
                                    String nomeProfessor = entrada.nextLine();
                                    System.out.println();

                                    if (professores.containsKey(matriculaProfessor)) { // pergunta ao usuário se quer tentar novamente o cadstro após notificar que a matrícula já existe
                                        System.out.println("Já existe um professor com essa matrícula!");

                                        String tentarNovamente; //variavel feita para armazenar a resposta do usuário, se S continua, se N para.
                                        while (true) {
                                            System.out.print("Deseja tentar novamente? (S/N): ");
                                            tentarNovamente = entrada.nextLine().toUpperCase();
                                            if (tentarNovamente.equals("S")) {
                                                continue;
                                            } else if (tentarNovamente.equals("N")) {
                                                break;
                                            } else {
                                                System.out.println("Dígito inválido! tente novamente.");
                                            }
                                        }
                                        break;
                                    }
                                    System.out.println("==== Cursos Disponíveis ====");//exibição dos cursos disponíveis para escolha do usuário.

                                    for (Map.Entry<Integer, Cursos> cEntry : cursos.entrySet()) { //for usado para exibição dos cursos
                                        System.out.println(cEntry.getKey() + " | " + cEntry.getValue().getNome());
                                        System.out.println("---------------------------------------------------------------");
                                    }

                                    Cursos escolhaCurso = null; //variavel para escolha do curso

                                    if (cursos.isEmpty()) { //verifica se o map cursos tem algum objeto dentro, se nao houver cancela o cadastro.
                                        System.out.println("Nenhum curso cadastrado, adicione um curso antes de prosseguir!");
                                        System.out.println();
                                        break;
                                    }

                                    while (escolhaCurso == null) {
                                        System.out.print("\nDigite o código do curso desejado: ");
                                        int codigoCurso = entrada.nextInt();//variavel para escolha do curso através do código
                                        entrada.nextLine();

                                        escolhaCurso = cursos.get(codigoCurso);//variavel que usa o codigo digitado para escolher o curso.

                                        if (escolhaCurso == null) {
                                            System.out.println("Código inválido, tente novamente:");//Se o usuário digitar algum número que não corresponde com algum código de curso, entra em loop até digitar um válido.
                                            System.out.println();
                                        } else {
                                            System.out.println("Curso adicionado com sucesso!");//se o valor for válido o curso é cadastrado com sucesso.
                                        }
                                    }

                                    List<Disciplinas> disciplinasEscolhidas = new ArrayList<>(); //List que guarda as disciplinas que o usuário escolher, caso haja mais que uma.

                                    if (disciplinas.isEmpty()) {
                                        System.out.println("nenhuma disciplina cadastrada!");//se o map das disciplinas estiverem vazias retorna a mensagem anterior.
                                        System.out.println();
                                        break;
                                    }

                                    while (true) {
                                        System.out.println("\nDisciplinas disponíveis:\n");
                                        for (Map.Entry<Integer, Disciplinas> dEntry : disciplinas.entrySet()) {//for usado para exibir as disciplinas disponíveis para escolha.
                                            System.out.println(dEntry.getKey() + " | " + dEntry.getValue().getNome());
                                            System.out.println("-------------------------------------------------------");
                                        }

                                        System.out.println();
                                        System.out.print("Digite o código da disciplina desejada: ");
                                        int codigoDisciplina = entrada.nextInt();// variavel que recebe o código da(s) disciplina(s) escolhida(s).
                                        entrada.nextLine();

                                        Disciplinas disciplinaEscolhida = disciplinas.get(codigoDisciplina); //variavel que pega o(s) código(s) digitado(s) anteriormente 

                                        if (disciplinaEscolhida == null) {
                                            System.out.println("Código inválido, tente novamente!");// se o código da disciplina não corresponder ao de nenhuma disciplina cadastrada anteriormente, entra em loop.
                                            System.out.println();
                                        } else if (disciplinasEscolhidas.contains(disciplinaEscolhida)) {
                                            System.out.println("Disciplina já adicionada, escolha outra!\n");//verifica se a disciplina já foi selecionada antes, se sim retorna essa mensagem, senão adiciona a List.
                                        } else {
                                            disciplinasEscolhidas.add(disciplinaEscolhida);// se o código corresponder, salva na List.
                                            System.out.println("Disciplina adicionada com sucesso!\n");
                                        }

                                        String tentarNovamente;
                                        while (true) {
                                            System.out.print("Deseja adicionar outra disciplina? (S/N): ");//variavel para o usuário continuar escolhendo as disciplinas enquanto houver disciplinas pra escolher.
                                            tentarNovamente = entrada.nextLine();
                                            if (tentarNovamente.equalsIgnoreCase("S")) {
                                                break;
                                            } else if (tentarNovamente.equalsIgnoreCase("N")) {
                                                break;
                                            } else {
                                                System.out.println("Dígito inválido!");
                                            }
                                        }
                                        if (tentarNovamente.equalsIgnoreCase("N")) {
                                            break;
                                        }
                                    }

                                    professores.put(matriculaProfessor, new Professores(matriculaProfessor, nomeProfessor, disciplinasEscolhidas, escolhaCurso));//objeto professor criada para o map.

                                    System.out.println("\n----------------------------------");
                                    System.out.println("Professor adicionado com sucesso!");
                                    System.out.println("----------------------------------");
                                    System.out.println();

                                    boolean cadastraNovamente = false;
                                    String tentarNovamente;

                                    while (true) {
                                        System.out.print("Deseja continuar? (S/N): ");
                                        tentarNovamente = entrada.nextLine();

                                        if (tentarNovamente.equalsIgnoreCase("S")) {
                                            cadastraNovamente = true;
                                            break;
                                        } else if (tentarNovamente.equalsIgnoreCase("N")) {
                                            break;
                                        } else {
                                            System.out.println("Dígito inválido, digite apenas 'S' ou 'N'!");
                                        }
                                    }

                                    if (cadastraNovamente) {
                                        System.out.println();
                                        continue;//se o usuário digitar s, volta ao inicio do loop e cadastra outro professor.
                                    } else {
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                if (professores.isEmpty()) {
                                    System.out.println("Lista vazia, cadastre um professor para prosseguir!\n");//se não houver nenhum professor cadastrado, retorna esta mensagem.
                                } else {
                                    System.out.println("==== Professores cadastrados ====\n");
                                    for (Map.Entry<Integer, Professores> pEntry : professores.entrySet()) {//se não, retorna a lista de professores cadastrados.
                                        System.out.println("Matrícula: " + pEntry.getKey());
                                        System.out.println("Professor: " + pEntry.getValue().getNome());
                                        System.out.println("Curso: " + pEntry.getValue().getCurso());
                                        System.out.println("Disciplina(s): ");
                                        for (Disciplinas disciplinas1 : pEntry.getValue().getDisciplina()) {
                                            System.out.println(" - " + disciplinas1.getCodigo() + " | " + disciplinas1.getNome());
                                        }
                                        System.out.println("--------------------------------------------------------------------\n");
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Retornando ao menu principal..."); //sai do menu de professores, para o menu principal.
                                System.out.println();
                                break;

                            default:
                                System.out.println("Opção inválida, tente novamente!");
                                System.out.println();
                                break;
                        }
                        if(opcaoSecundaria == 3) {
                            break;
                        }
                    }
                    break;
                case 5:
                    while (true) {

                        System.out.println("==== MENU NOTAS ====\n");
                        System.out.println("1 - Cadastrar/alterar nota");
                        System.out.println("2 - Consultar notas de um aluno");
                        System.out.println("3 - Verificar aprovação e certificado");
                        System.out.println("4 - Retornar ao menu principal");
                        System.out.println("Escolha uma opção: ");
                        opcaoSecundaria = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println();

                        switch (opcaoSecundaria) {

                            case 1:

                                //verifica se a lista de alunos está vazia, se estiver quebra o cadastro/atualização da nota
                                if (alunos.isEmpty()) {
                                    System.out.println("Lista vazia, cadastre um aluno para prosseguir!\n");
                                    break;
                                }
                                //lista os alunos já cadastrados
                                System.out.println("==== Alunos disponíveis ====\n");
                                for (Map.Entry<Integer, Aluno> entry : alunos.entrySet()) {
                                    System.out.println(entry.getKey() + " | " + entry.getValue().getNome());
                                    System.out.println("------------------------------------------------------------");
                                }
                                System.out.println();

                                int matriculaA;
                                while (true) {

                                    System.out.println("Digite o número da matrícula do aluno: ");

                                    matriculaA = entrada.nextInt();//variável que pede a matrícula do aluno
                                    entrada.nextLine();

                                    if (alunos.containsKey(matriculaA)) {//se o número da matrícula for igual ao de um dos alunos que deseja selecionar ele seleciona, senao ele exibe mensagem de erro e entra em loop
                                        break;
                                    } else {
                                        System.out.println("Matrícula inexistente, tente novamente!\n");
                                    }
                                }

                                if (disciplinas.isEmpty()) { //se o map das disciplinas estiver vazia, quebra o cadastro/alteração das notas
                                    System.out.println("Lista vazia, Adicione uma disciplina para prosseguir!");
                                    break;
                                }

                                //(putIfAbsent) = se o map não existir ainda ele cria um novo map, e se já existir ele pega o que já existe
                                notas.putIfAbsent(matriculaA, new LinkedHashMap<>());

                                int codDisciplina;

                                while (true) {

                                    System.out.println("==== Disciplinas disponíveis ====\n"); //lista as disciplinas disponíveis
                                    while (true) {
                                        for (Map.Entry<Integer, Disciplinas> dEntry : disciplinas.entrySet()) {
                                            System.out.println(dEntry.getKey() + " | " + dEntry.getValue().getNome());
                                            System.out.println("---------------------------------------------------------");
                                        }
                                        System.out.println();

                                        System.out.println("Digite o código da disciplina desejada: ");
                                        codDisciplina = entrada.nextInt();//variavel que pede o código da disciplina
                                        entrada.nextLine();

                                        if (disciplinas.containsKey(codDisciplina)) {//se o codigo digitado da disciplina bater com o código de uma das disciplinas cadastradas, seleciona-a
                                            System.out.println();
                                            break;
                                        } else {
                                            System.out.println("\nCódigo inexistente, tente novamente!\n");//se não bater exibe essa mensagem de erro 
                                        }
                                    }

                                    System.out.println("Digite a nota do aluno dessa disciplina: ");
                                    double valorNota = entrada.nextDouble();// variavel do valor da nota do aluno para a disciplina selecionada
                                    entrada.nextLine();

                                    notas.get(matriculaA).put(codDisciplina, valorNota);//o map dentro do map criado, ou alterado, dependendo da existencia do map com alguma nota do aluno selecionado

                                    System.out.println("\n-----------------------------------------------\n");
                                    System.out.println("Nota cadastrada/atualizada com sucesso!");
                                    System.out.println("\n-----------------------------------------------\n");

                                    String continuar;
                                    while (true) {
                                        System.out.println("Deseja adicionar nota para outra disciplina desse aluno? (S/N): ");
                                        continuar = entrada.nextLine();//variavel que recebe S ou N para continuar adicionando nota a alguma disciplina
                                        if (continuar.equalsIgnoreCase("S") || continuar.equalsIgnoreCase("N")) {
                                            System.out.println();
                                            break;
                                        } else {
                                            System.out.println("Dígito inválido, tente novamente!\n");
                                        }
                                    }

                                    if (continuar.equalsIgnoreCase("N")) {//se a resposta for não ele sai do cadastro
                                        break;
                                    }
                                }
                                break;

                            case 2:
                                // verifica se o map de aluno está vazio ou não
                                if (alunos.isEmpty()) {
                                    System.out.println("Lista vazia, cadastre um aluno para prosseguir!\n");
                                    break;
                                }

                                System.out.println("==== Consultar Notas ====\n");

                                for (Map.Entry<Integer, Aluno> aEntry : alunos.entrySet()) {// exibe todos os alunos cadastros para seleção
                                    System.out.println(aEntry.getKey() + " | " + aEntry.getValue().getNome());
                                    System.out.println("-----------------------------------------------------");
                                }

                                System.out.println();

                                int matriculaConsulta;

                                while (true) {

                                    System.out.println("Digite o número da matrícula do aluno que deseja consultar: ");
                                    matriculaConsulta = entrada.nextInt();//variavel que recebe o valor da matricula do aluno já cadastrado
                                    entrada.nextLine();

                                    if (alunos.containsKey(matriculaConsulta)) {//se o numero digitado bater com o da matricula do aluno ele seleciona
                                        break;
                                    } else {//se não exibe o erro
                                        System.out.println("\nMatrícula inválida, tente novamente!\n");
                                    }
                                }
                                //se o valor da matricula nao existir no map de notas exibe a mensagem abaixo
                                if (!notas.containsKey(matriculaConsulta) || notas.get(matriculaConsulta).isEmpty()) {
                                    System.out.println("Esse aluno não possui notas cadastradas até o momento!\n");//<- essa aqui
                                    break;
                                }

                                System.out.println("\n==== Notas do aluno " + alunos.get(matriculaConsulta).getNome() + " ====\n");
                                //==== Notas do aluno "AlunoEscolhido" ====

                                for (Map.Entry<Integer, Aluno> aEntry : alunos.entrySet()) {
                                    System.out.println("Curso: " + aEntry.getValue().getCurso());
                                }
                                System.out.println();
                                
                                System.out.println("***** NOTAS *****\n");

                                for (Map.Entry<Integer, Double> entry : notas.get(matriculaConsulta).entrySet()) {
                                    int codigoDisc = entry.getKey();
                                    double notaA = entry.getValue();
                                    String nomeDisciplina = disciplinas.get(codigoDisc).getNome();
                                    System.out.println(codigoDisc + " | " + nomeDisciplina + " -> Nota: " + notaA);//printa o codigo da disciplina, o nome da disciplina, e a nota
                                }

                                System.out.println();

                                break;

                            case 3:
                                // verifica se o map de aluno está vazio ou não
                                if (alunos.isEmpty()) {
                                    System.out.println("Nenhum aluno cadastrado!\n");
                                    break;
                                }

                                System.out.println("==== Verificar Aprovação ====\n");

                                // lista os alunos já cadastrados
                                for (Map.Entry<Integer, Aluno> entry : alunos.entrySet()) {
                                    System.out.println(entry.getKey() + " | " + entry.getValue().getNome());
                                }
                                System.out.println();

                                int matAprovado;

                                // verifica se a matrícula é válida
                                while (true) {
                                    System.out.println("Digite a matrícula do aluno: ");
                                    matAprovado = entrada.nextInt();//variavel que pede a matricula do aluno
                                    entrada.nextLine();

                                    if (alunos.containsKey(matAprovado)) {//se o map de alunos tiver o número da matricula digitado, seleciona
                                        break;
                                    } else {
                                        System.out.println("Matrícula inexistente, tente novamente!\n");
                                    }
                                }

                                Aluno a = alunos.get(matAprovado);
                                Cursos c = a.getCurso();
                                String nomeCurso = c.getNome();

                                // verifica se o aluno tem notas já cadastradas
                                if (!notas.containsKey(matAprovado) || notas.get(matAprovado).isEmpty()) {
                                    System.out.println("Esse aluno não possui notas cadastradas.\n");
                                    break;
                                }

                                Map<Integer, Double> notasAluno = notas.get(matAprovado);//busca no map interno as disciplinas e notas referentes ao aluno selecionado anteriormente

                                int discAprovadas = 0;//variavel que armazena as disciplinas nas quais o aluno está aprovado

                                List<Integer> disciplinasBaixas = new ArrayList<>();//ArrayList usada para armazenar as disciplinas com nota inferior ao necessario para aprovação

                                List<Integer> disciplinasReprovadas = new ArrayList<>();

                                // verifica cada disciplina e sua nota
                                for (Map.Entry<Integer, Double> entry : notasAluno.entrySet()) {
                                    int cod = entry.getKey();
                                    double nota = entry.getValue();

                                    if (nota >= 7) { //se a nota for maior ou igual a 7, o aluno foi aprovado
                                        discAprovadas++;//adiciona a variavel de disciplinas aprovadas + 1
                                    } else if (nota >= 4 && nota < 7) {//se for menor ou igual a 4, e menor que 7
                                        disciplinasBaixas.add(cod);//adiciona a ArrayList de disciplinas com nota baixa
                                    }else{
                                        disciplinasReprovadas.add(cod);
                                    }
                                }
                                //verifica se há alguma disciplina com nota abaixo de 4 no ArrayList
                                if(!disciplinasReprovadas.isEmpty()){
                                    System.out.println("O aluno foi reprovado nas seguintes disciplinas:\n");
                                    
                                    for(int notaReprovada : disciplinasReprovadas){ //exibe as disciplinas com a nota baixa
                                        System.out.println(notaReprovada + " | " + disciplinas.get(notaReprovada).getNome() + " -> Nota: " + notasAluno.get(notaReprovada));
                                    }
                                    
                                    System.out.println("\nAluno reprovado por nota insuficiente!\n ");//informa a situação do aluno
                                    break;
                                }

                                // mostra as disciplinas que precisam de nota corrigida
                                if (!disciplinasBaixas.isEmpty()) {

                                    System.out.println("\nO aluno possui notas entre 4 e 6,9. É necessário corrigir:\n");

                                    for (int cod : disciplinasBaixas) {//percorre a ArrayList de disciplinas com nota baixa para mostrá-las alinhadas
                                        System.out.println(cod + " | " + disciplinas.get(cod).getNome() + " -> Nota atual: " + notasAluno.get(cod));
                                    }

                                    while (true) {

                                        System.out.println("\nDeseja corrigir alguma nota? (S/N): ");
                                        String esc = entrada.nextLine();//variavel que recebe o valor do usuario para continuar e corrigir as notas ou nao

                                        if (esc.equalsIgnoreCase("N")) {//se a resposta for N para por ai
                                            break;
                                        }

                                        if (esc.equalsIgnoreCase("S")) { // se a repsosta for S continua a correção

                                            int codCorrecao;

                                            while (true) {
                                                System.out.println("Digite o código da disciplina a corrigir: ");
                                                codCorrecao = entrada.nextInt();//variavel que recebe o codigo da disciplina 
                                                entrada.nextLine();

                                                if (disciplinasBaixas.contains(codCorrecao)) {//se a ArrayList possuir o codigo da disciplina digitado anteriormente, seleciona
                                                    break;
                                                } else {//se não exibe a mensagem abaixo
                                                    System.out.println("Código inválido, tente novamente!\n");
                                                }
                                            }

                                            System.out.println("Digite a nova nota: ");
                                            double novaNota = entrada.nextDouble();//variavel que recebe a nova nota
                                            entrada.nextLine();

                                            notasAluno.put(codCorrecao, novaNota);//adiciona o codigo da disciplina e a nota corrigida ao map interno de notas
                                            System.out.println("\n-----------------------\n");
                                            System.out.println("Nota atualizada!");
                                            System.out.println("\n------------------------");

                                        } else {
                                            System.out.println("Entrada inválida!");
                                        }
                                    }

                                    System.out.println("\nNotas corrigidas concluídas.\n");
                                }

                                //recalcula a aprovação depois das possíveis correções
                                discAprovadas = 0;
                                for (double nota : notasAluno.values()) {//percorre o map interno de notas retornando os valores, mas nao as exibe
                                    if (nota >= 7) {//se as notas forem maiores ou iguais a 7
                                        discAprovadas++;//adiciona + 1 a variavel das disciplinas aprovadas
                                    }
                                }

                                System.out.println("Disciplinas aprovadas: " + discAprovadas);//exibe a quantidade de disciplinas aprovadas

                                if (discAprovadas >= 10) { //se o aluno for aprovado em 10 disciplinas ou mais 
                                    System.out.println("\nAluno APROVADO!\n");//exibe essa mensagem

                                    LocalDate hoje = LocalDate.now();// variavel de tempo, sem horas
                                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");//variavel que formata a data para o modo desejado, nesse caso: "dia/mes/ano"

                                    String dataFormatada = hoje.format(fmt);//variavel recebendo a data formatada


                                    //emissão do certificado em caso de aprovação
                                    System.out.println("=== CERTIFICADO DE CONCLUSÃO ===\n");
                                    System.out.println("Aluno: " + alunos.get(matAprovado).getNome());
                                    System.out.println("Matrícula: " + matAprovado);
                                    System.out.println("Curso: " + nomeCurso);
                                    System.out.println("Data de emissão: " + dataFormatada);
                                    System.out.println("\n=================================\n");

                                } else {
                                    System.out.println("\nAluno ainda não atingiu 10 disciplinas com nota maior ou igual a 7.\n");
                                }

                                break;

                            case 4:
                                System.out.println("Retornando ao menu principal..."); //sai do menu de notas, para o menu principal.
                                System.out.println();
                                break;

                            default:
                                System.out.println("Opção inválida, tente novamente");
                                break;
                        }
                        if(opcaoSecundaria == 4) {
                            break;
                        }
                    }
                    break;

                case 6://sai do programa
                    System.out.println("Saindo....");
                    System.out.println();
                    rodando = false;
                    break;

                default:
                    System.out.println("Digite uma opção válida!");
                    System.out.println();
                    break;
            }
        }
        entrada.close();
    }
}

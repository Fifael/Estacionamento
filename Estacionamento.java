import java.util.Scanner;

public class Estacionamento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("Estacionamento");
        System.out.println("Bem vindo ao Estacionamento dos FORGET");

        do {
            System.out.println(" O que deseja fazer???");
            System.out.println("1 - Cadastrar Veiculo");
            System.out.println("2 - Cadastrar vaga");
            System.out.println("3 - Cadastrar locacao");
            System.out.println("4 - Listar Veiculo");
            System.out.println("5 - Listar vaga");
            System.out.println("6 - Listar Locacao");
            System.out.println("7 - Remover Carro");
            System.out.println("8 - Remover Moto");
            System.out.println("9 - Remover Bicicleta");
            System.out.println("10 - Remover Vaga");
            System.out.println("11 - Remover Locacao");
            System.out.println("12 - Sair");
            System.out.print("Opção: ");
            try {
                opcao = scanner.nextInt();
            } catch (Exception e) {
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    cadastrarVeiculo(scanner);
                    break;
                case 2:
                    cadastrarVaga(scanner);
                    break;
                case 3:
                    cadastrarLocacao(scanner);
                    break;
                case 4:
                    listarVeiculo();
                    break;
                case 5:
                    listarVaga();
                    break;
                case 6:
                    listarLocacao();
                    break;
                case 7:
                    removerCarro(scanner);
                    break;
                case 8:
                    removerMoto(scanner);
                    break;
                case 9:
                    removerBicicleta(scanner);
                    break;
                case 10:
                    removerLocacao(scanner);
                    break;
                case 11:
                    removerVaga(scanner);
                    break;
                case 12:
                    sair();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 12);
    }

    public static void cadastrarVeiculo(Scanner scanner) {
        System.out.println("Cadastrar veiculo");
        System.out.println("Digite o nome do veículo: ");
        String nome = scanner.next();
        System.out.println("Digite o tipo: ([C] Carro; [M] Moto; [B] Bicicleta) ");
        String tipo = scanner.next().toUpperCase().trim().substring(0, 1);
        switch (tipo) {
            case "C":
                System.out.println("Informe a Placa do carro:");
                String placa = scanner.next();
                System.out.println("Informe a Cor do carro:");
                String cor = scanner.next();
                Carro carro = new Carro(nome, placa, cor);
                System.out.println("\nCarro cadastrado com sucesso!");
                break;

            case "M":
                System.out.println("Informe a Placa da moto:");
                String placaM = scanner.next();
                System.out.println("Informe a Cilindrada da moto:");
                int cilindrada = scanner.nextInt();
                Moto moto = new Moto(nome, placaM, cilindrada);
                System.out.println("\nMoto cadastrado com sucesso!");
                break;

            case "B":
                System.out.println("Informe a Marca da bicibleta:");
                String marca = scanner.next();
                System.out.println("Informe a Cor da bicicleta:");
                String corB = scanner.next();
                Bicicleta bicicleta = new Bicicleta(nome, marca, corB);
                System.out.println("\nBicicleta cadastrado com sucesso!");
            default:
                break;
        }
    }

    public static void cadastrarVaga(Scanner scanner) {
        try {
            System.out.println("Cadastrar Vaga");
            System.out.println("Digite o número da vaga: ");
            int numero = scanner.nextInt();
            System.out.println("Digite o tamanho da vaga: ");
            String tamanho = scanner.next();
            System.out.println("Digite o preço da vaga: ");
            String preco = scanner.next();
            System.out.println("Digite o tipo da vaga: ([C] Carro; [M] Moto; [B] Bicicleta: ");
            String tipo1 = scanner.next().toUpperCase().trim().substring(0, 1);
            Vaga vaga = new Vaga(numero, tipo1, tamanho, preco);

            System.out.println("Vaga cadastrada com sucesso!");
            System.out.println(vaga);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void cadastrarLocacao(Scanner scanner) {
        System.out.println("Cadastro de Locacao");
        System.out.println("Digite o data da locacao: ");
        String data = scanner.next();
        System.out.println("Digite o id da vaga: ");
        try {
            int idVaga = scanner.nextInt();
            Vaga vaga = Vaga.getVaga(idVaga);
            System.out.println("Digite o id do veiculo: ");
            int idVeiculo = scanner.nextInt();
            String tipo = vaga.gettipo1();
            Veiculo veiculo = null;
            switch (tipo) {
                case "C":
                    veiculo = Carro.getCarro(idVeiculo);
                    break;
                case "M":
                    veiculo = Moto.getMoto(idVeiculo);
                    break;
                case "B":
                    veiculo = Bicicleta.getBicicleta(idVeiculo);
                    break;
                default:
                    break;
            }
            if (veiculo == null) {
                throw new Exception("Veiculo não existe");
            }
            Locacao locacao = new Locacao(data, veiculo, vaga);

            System.out.println("Locacao cadastrada com sucesso!");
            System.out.println(locacao);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void listarVeiculo() {

        System.out.println("Listar Carro");
        for (Carro carro : Carro.getCarros()) {
            System.out.println(carro);
        }

        System.out.println("Listar Moto");
        for (Moto moto : Moto.getMotos()) {
            System.out.println(moto);
        }
        System.out.println("Listar Bicicleta");
        for (Bicicleta bicicleta : Bicicleta.getBicicletas()) {
            System.out.println(bicicleta);
        }
    }

    public static void listarVaga() {

        try {
            System.out.println("Listar Vaga");
            for (Vaga vaga : Vaga.getVagas()) {
                System.out.println(vaga);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar vaga. " + e.getMessage());
        }

    }

    public static void listarLocacao() {

        try {
            System.out.println("Listar Locacao");
            for (Locacao locacao : Locacao.getLocacoes()) {
                System.out.println(locacao);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar vaga. " + e.getMessage());
        }

    }

    public static void removerCarro(Scanner scanner) {
        try {
            System.out.println("Digite o id: ");
            int id = scanner.nextInt();
            Carro.removeCarro(id);
        } catch (Exception e) {
            System.out.println("Erro ao excluir veículo. " + e.getMessage());
        }
    }

    public static void removerMoto(Scanner scanner) {
        try {
            System.out.println("Digite o id: ");
            int id = scanner.nextInt();
            Moto.removeMoto(id);
        } catch (Exception e) {
            System.out.println("Erro ao excluir veículo. " + e.getMessage());
        }
    }

    public static void removerBicicleta(Scanner scanner) {
        try {
            System.out.println("Digite o id: ");
            int id = scanner.nextInt();
            Bicicleta.removeBicicleta(id);
        } catch (Exception e) {
            System.out.println("Erro ao excluir veículo. " + e.getMessage());
        }
    }

    public static void removerLocacao(Scanner scanner) {
        try {
            System.out.println("Digite o id: ");
            int id = scanner.nextInt();
            Locacao.removeLocacao(id);
        } catch (Exception e) {
            System.out.println("Erro ao excluir veículo. " + e.getMessage());
        }
    }

    public static void removerVaga(Scanner scanner) {
        try {
            System.out.println("Digite o id: ");
            int id = scanner.nextInt();
            Vaga.removeVaga(id);
        } catch (Exception e) {
            System.out.println("Erro ao excluir veículo. " + e.getMessage());
        }

    }

    public static void sair() {
        System.out.println("Saindo...");
        System.exit(0);
    }

}

package almoxarifado;

import produtos.Produto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Almoxarifado {
    private final static Scanner scanner = new Scanner(System.in);

    List<Produto> produtoList;

    public Almoxarifado() {
        this.produtoList = new ArrayList<>();
    }

    public List<Produto> exibirProdutos(){
        return produtoList;
    }

    public void adicionarProduto(){
        Produto produto;
        System.out.println(" _____             _              _\n" +
                " / ____|           | |            | |\n" +
                "| |       __ _   __| |  __ _  ___ | |_  _ __   ___\n" +
                "| |      / _` | / _` | / _` |/ __|| __|| '__| / _ \\\n" +
                "| |____ | (_| || (_| || (_| |\\__ \\| |_ | |   | (_) |\n" +
                " \\_____| \\__,_| \\__,_| \\__,_||___/ \\__||_|    \\___/\n");
        System.out.println("Nome do produto: ");
        scanner.nextLine();
        String nome = scanner.next();
        scanner.nextLine();
        System.out.println("Quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.println("Preço por unidade: ");
        double preco = scanner.nextDouble();
        System.out.println("Data de inclusao: ");
        LocalDate dataInclusao = LocalDate.ofEpochDay(scanner.nextInt());
        System.out.println("Codigo de barras do produto: ");
        String codigoBarras = scanner.next();

        produtoList.add(produto = new Produto(nome, quantidade,preco,dataInclusao, codigoBarras));

        System.out.println("Produto adicionado: " + produto.getNome() + " codigo: "+ produto.getCod());

    }

    public Produto bucarProduto(String codigoBarras){
        System.out.println(" ____\n" +
                "|  _ \\\n" +
                "| |_) | _   _  ___   ___   __ _\n" +
                "|  _ < | | | |/ __| / __| / _` |\n" +
                "| |_) || |_| |\\__ \\| (__ | (_| |\n" +
                "|____/  \\__,_||___/ \\___| \\__,_|\n" +
                "\n" +
                "\n");

            Produto produtoBuscado = null;
            while (produtoBuscado != null){
                System.out.println("Entre com o codigo do produto");
                codigoBarras = scanner.next();
                for (Produto i: produtoList)
                    if(codigoBarras.equalsIgnoreCase(produtoBuscado.getCodigoBarras())){
                        produtoBuscado = i;
                        break;

                    }
                    else {
                        System.out.println("Prduto não encontrado, tente novamente");
                    }
            }
            return produtoBuscado;
    }


}

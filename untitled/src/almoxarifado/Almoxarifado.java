package almoxarifado;

import produtos.ComparetorPorData;
import produtos.Produto;


import java.time.LocalDate;
import java.util.*;

public class Almoxarifado {
    private final static Scanner scanner = new Scanner(System.in);

    List<Produto> produtoList;

    public Almoxarifado() {
        this.produtoList = new ArrayList<>();
    }

    public List<Produto> exibirProdutos(){
        return produtoList;
    }

    public List<Produto> exibirProdutosPorData(){
        List<Produto> produtosOrganizados = new ArrayList<>(produtoList);
        Collections.sort(produtosOrganizados, new ComparetorPorData());

        return  produtosOrganizados;
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
        System.out.println("Codigo de barras do produto: ");
        String codigoBarras = scanner.next();
        System.out.println("Localização do produto: (corredor + predio)");
        String local = scanner.next();

        produtoList.add(produto = new Produto(nome, quantidade,preco, codigoBarras,local));

        System.out.println("Produto adicionado: " + produto.getNome() + " codigo: "
                + produto.getCod() + " local de estoque " + produto.getLocal() + produto.getDataDeInclusao());

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
            if (!produtoList.isEmpty()){

                while (produtoBuscado != null){
                    System.out.println("Digite o codigo de barras: ");
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
            }else{
                System.out.println("Estoque vazio");
            }
        return produtoBuscado;
    }

    public List<Produto> buscarPorNome(){
        System.out.println(" ____\n" +
                "|  _ \\\n" +
                "| |_) | _   _  ___   ___   __ _\n" +
                "|  _ < | | | |/ __| / __| / _` |\n" +
                "| |_) || |_| |\\__ \\| (__ | (_| |\n" +
                "|____/  \\__,_||___/ \\___| \\__,_|\n" +
                "\n" +
                "\n");
        List<Produto> produtosBuscados = new ArrayList<>();
        if (!produtoList.isEmpty()){
            System.out.println("Nome do produto: ");
            scanner.nextLine();
            String nomeProduto = scanner.next();
            scanner.nextLine();
            for(Produto p: produtoList){
                if (p.getNome().equalsIgnoreCase(nomeProduto)){
                    produtosBuscados.add(p);
                }
                else{
                    System.out.println("Nenhum produto encontrado com esse nome");
                }
            }
        }
        else{
            System.out.println("Estoque vazio");
        }
        return produtosBuscados;
    }

    public double totalPrecoDoEstoque(){
        double totalPreco = 0;
        if(!produtoList.isEmpty()){
         for(Produto p: produtoList)
             totalPreco =+ p.getTotalPreco();
         }
        else{
            System.out.println("Estoque vazio");
        }
        return totalPreco;
    }
    
    public void excluirProduto(){
        Produto produtoRemover = null;
        if(!produtoList.isEmpty()){
            System.out.println("Codigo do produto que queira remover");
            int code = scanner.nextInt();
            for (Produto p: produtoList){
                String simOuNao = "";
                if (p.getCod() == code ){
                    while (simOuNao.equalsIgnoreCase("sim") || simOuNao.equalsIgnoreCase("nao")){
                        System.out.println("Realemente deseja remove o produto? sim - nao ");
                        simOuNao =scanner.next();
                        if (simOuNao.equalsIgnoreCase("sim")){
                            produtoRemover = p;
                            break;
                        } else if (simOuNao.equalsIgnoreCase("nao")) {
                            break;

                        }
                        else{
                            System.out.println("Alternativa invalida, digite sim ou nao");
                        }
                    }
                }
            }
            produtoList.remove(produtoRemover);
        }
        else{
            System.out.println("Estoque vazio");
        }
    }


}

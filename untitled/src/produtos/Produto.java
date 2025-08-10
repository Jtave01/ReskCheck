package produtos;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Produto {
   private String nome;
   private int quantidade;
   private double preco;
   private double totalPreco;
   private LocalDate dataDeInclusao;
   private LocalDate dataValidade;
   private int SEQUENCIAL_CODE =0;
   private String codigoBarras;
   private String local;

    public Produto(String nome, int quantidade, double preco, String codigoBarras, String local) {
        this.nome =nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.codigoBarras = codigoBarras;
        this.dataDeInclusao = dataDeInclusao.now();
        this.SEQUENCIAL_CODE = SEQUENCIAL_CODE++;
        this.totalPreco = (this.preco * this.quantidade);
        this.local = local;
    }


    @Override
    public String toString() {
        return "Produto{" +
                "Nome='" + nome + '\'' +
                ", Quantidade=" + quantidade +
                ", Preco=" + preco +
                ", TotalPreco=" + totalPreco +
                ", DataDeInclusao=" + dataDeInclusao +
                ", Codigo do produto=" + SEQUENCIAL_CODE +
                ", Codigo de barras='" + codigoBarras + '\'' +
                ", localização='" + local + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public double getPreco() {
        return preco;
    }
    public double getTotalPreco(){
        return totalPreco;
    }
    public LocalDate getDataDeInclusao() {
        return dataDeInclusao;
    }
    public int getCod() {
        return SEQUENCIAL_CODE;
    }
    public String getCodigoBarras(){
        return codigoBarras;
    }
    public String getLocal(){
        return local;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setDataDeInclusao(LocalDate dataDeInclusao) {
        this.dataDeInclusao = dataDeInclusao;
    }
    public void setCodigoBarras(String codigoBarras){
        this.codigoBarras = codigoBarras;
    }
    public void setLocal(String local){
        this.local = local;

    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Produto produto)) return false;
        return getCod() == produto.getCod();
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(getCod());
    }

}

public class ComparetorPorData implements Comparator<Produto>{

    @Override
    public int compare(Produto p1, Produto p2) {
        return p1.getDataDeInclusao().compareTo(p2.getDataDeInclusao());
    }
}
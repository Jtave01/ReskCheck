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
   private int SEQUENCIAL_CODE =0;
   private String codigoBarras;

    public Produto(String nome, int quantidade, double preco, LocalDate dataInclusao, String codigoBarras) {
        this.nome =nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.codigoBarras = codigoBarras;
        this.dataDeInclusao = dataDeInclusao;
        this.SEQUENCIAL_CODE = SEQUENCIAL_CODE++;

        this.totalPreco = (this.preco * this.quantidade);
    }


    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                ", totalPreco=" + totalPreco +
                ", dataDeInclusao=" + dataDeInclusao +
                ", SEQUENCIAL_CODE=" + SEQUENCIAL_CODE +
                ", codigoBarras='" + codigoBarras + '\'' +
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

class comparetorPorData implements Comparator<Produto>{

    @Override
    public int compare(Produto p1, Produto p2) {
        return p1.getDataDeInclusao().compareTo(p2.getDataDeInclusao());
    }
}